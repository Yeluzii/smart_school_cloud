package net.maku.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import net.maku.model.WebSocketMessage;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
@ServerEndpoint("/ws")
public class WebSocketServer {
    // 用于记录当前在线连接数
    private static final AtomicInteger ONLINE_COUNT = new AtomicInteger(0);

    // 用于存放每个客户端对应的WebSocketServer对象
    private static final Map<String, WebSocketServer> CLIENTS = new ConcurrentHashMap<>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    // 客户端ID
    private String clientId;

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        this.clientId = session.getId();
        CLIENTS.put(clientId, this);
        addOnlineCount();
        log.info("有新连接加入，当前在线数：{}", getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        CLIENTS.remove(clientId);
        subOnlineCount();
        log.info("有一连接关闭，当前在线数：{}", getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自客户端{}的消息：{}", clientId, message);
        try {
            // 解析收到的消息
            WebSocketMessage webSocketMessage = objectMapper.readValue(message, WebSocketMessage.class);
            // 如果是注册消息，更新clientId
            if ("register".equals(webSocketMessage.getType()) && webSocketMessage.getDeviceId() != null) {
                // 移除旧的映射
                CLIENTS.remove(clientId);
                // 更新clientId
                this.clientId = webSocketMessage.getDeviceId();
                // 添加新的映射
                CLIENTS.put(clientId, this);
                log.info("客户端注册成功：{}", clientId);
                // 发送确认消息
                WebSocketMessage response = WebSocketMessage.builder()
                        .type("register_success")
                        .deviceId(clientId)
                        .timestamp(System.currentTimeMillis())
                        .build();
                this.sendMessage(objectMapper.writeValueAsString(response));
            }

        } catch (Exception e) {
            log.error("处理消息出错", e);
        }
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误", error);
    }

    /**
     * 发送消息
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 群发消息
     */
    public static void broadcastMessage(String message) {
        CLIENTS.forEach((id, client) -> {
            try {
                client.sendMessage(message);
            } catch (IOException e) {
                log.error("广播消息失败", e);
            }
        });
    }

    /**
     * 发送消息给指定客户端
     */
    public static void sendMessageToClient(String clientId, String message) {
        WebSocketServer client = CLIENTS.get(clientId);
        if (client != null) {
            try {
                client.sendMessage(message);
            } catch (IOException e) {
                log.error("发送消息失败", e);
            }
        } else {
            log.warn("客户端{}不在线", clientId);
        }
    }

    public static synchronized int getOnlineCount() {
        return ONLINE_COUNT.get();
    }

    public static synchronized void addOnlineCount() {
        ONLINE_COUNT.incrementAndGet();
    }

    public static synchronized void subOnlineCount() {
        ONLINE_COUNT.decrementAndGet();
    }

    public static Map<String, WebSocketServer> getClients() {
        return CLIENTS;
    }
}

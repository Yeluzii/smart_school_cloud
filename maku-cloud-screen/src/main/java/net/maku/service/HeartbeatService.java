package net.maku.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.maku.model.WebSocketMessage;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableScheduling
@RequiredArgsConstructor
public class HeartbeatService {

    private final ObjectMapper objectMapper;

    /**
     * 每30秒发送一次心跳消息
     */
    @Scheduled(fixedRate = 30000)
    public void sendHeartbeat() {
        if (WebSocketServer.getOnlineCount() == 0) {
            return;
        }

        WebSocketMessage heartbeat = WebSocketMessage.builder()
                .type("heartbeat")
                .timestamp(System.currentTimeMillis())
                .build();

        try {
            String message = objectMapper.writeValueAsString(heartbeat);
            WebSocketServer.broadcastMessage(message);
            log.debug("已发送心跳消息");
        } catch (JsonProcessingException e) {
            log.error("发送心跳消息失败", e);
        }
    }
}

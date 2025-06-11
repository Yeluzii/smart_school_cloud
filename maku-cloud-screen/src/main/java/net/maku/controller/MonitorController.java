package net.maku.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.maku.model.WebSocketMessage;
import net.maku.service.WebSocketServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MonitorController {
    private final ObjectMapper objectMapper;

    /**
     * 获取当前所有在线客户端
     */
    @GetMapping("/clients")
    public ResponseEntity<Map<String, Object>> getClients() {
        Map<String, Object> result = new HashMap<>();
        result.put("count", WebSocketServer.getOnlineCount());
        result.put("clients", WebSocketServer.getClients().keySet());
        return ResponseEntity.ok(result);
    }

    /**
     * 模拟红外感应触发
     */
    @PostMapping("/trigger/infrared")
    public ResponseEntity<Map<String, Object>> triggerInfrared(
            @RequestParam(value = "location", defaultValue = "客厅") String location,
            @RequestParam(value = "deviceId", defaultValue = "monitor_001") String deviceId) {

        WebSocketMessage message = WebSocketMessage.builder()
                .type("motion_detected")
                .location(location)
                .timestamp(System.currentTimeMillis())
                .content("检测到移动")
                .build();

        try {
            String messageString = objectMapper.writeValueAsString(message);

            // 如果指定了设备ID，只发送给特定设备
            if (deviceId != null && !deviceId.isEmpty()) {
                WebSocketServer.sendMessageToClient(deviceId, messageString);
                log.info("已向设备 {} 发送红外触发消息", deviceId);
            } else {
                // 否则广播给所有设备
                WebSocketServer.broadcastMessage(messageString);
                log.info("已广播红外触发消息");
            }

            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "已发送红外触发消息");
            result.put("timestamp", message.getTimestamp());
            return ResponseEntity.ok(result);

        } catch (JsonProcessingException e) {
            log.error("消息序列化失败", e);
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "消息发送失败"));
        }
    }

    /**
     * 发送自定义消息
     */
    @PostMapping("/send")
    public ResponseEntity<Map<String, Object>> sendMessage(
            @RequestBody WebSocketMessage message,
            @RequestParam(value = "deviceId", required = false) String deviceId) {

        try {
            String messageString = objectMapper.writeValueAsString(message);

            // 如果指定了设备ID，只发送给特定设备
            if (deviceId != null && !deviceId.isEmpty()) {
                WebSocketServer.sendMessageToClient(deviceId, messageString);
                log.info("已向设备 {} 发送消息: {}", deviceId, message.getType());
            } else {
                // 否则广播给所有设备
                WebSocketServer.broadcastMessage(messageString);
                log.info("已广播消息: {}", message.getType());
            }

            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "消息发送成功");
            return ResponseEntity.ok(result);

        } catch (JsonProcessingException e) {
            log.error("消息序列化失败", e);
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "消息发送失败"));
        }
    }

}

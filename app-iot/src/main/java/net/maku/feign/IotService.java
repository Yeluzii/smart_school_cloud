package net.maku.feign;

import com.alibaba.fastjson2.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author: krislorem
 * @Package: net.maku.feign
 * @Project: smart_school_cloud
 * @name: IotService
 * @Date: 2025/6/11 11:30
 * @FileName: IotService
 * @description:
 */
@FeignClient(value = "screen")
public interface IotService {
    @PostMapping("api/alert")
    ResponseEntity<JSONObject> checkAndSendAlerts(@RequestParam("uid") String uid, @RequestParam(value = "temperature") Float temperature);
}

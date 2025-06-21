package net.maku.feign;

import net.maku.framework.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "maku-cloud-new")
public interface AlertLogService {
    @PostMapping("alert/log/add")
    Result<String> addAlertLog(@RequestParam Long deviceId,@RequestParam Object info);
}

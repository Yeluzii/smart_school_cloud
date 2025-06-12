package net.maku.feign;

import org.springframework.cloud.openfeign.FeignClient;

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
}

package net.maku.iot.vo;

import lombok.Data;

/**
 * @Author: krislorem
 * @Package: net.maku.iot.vo
 * @Project: smart_school_cloud
 * @name: UserDeviceVo
 * @Date: 2025/6/10 8:27
 * @FileName: UserDeviceVo
 * @description:
 */
@Data
public class UserDeviceVO {
    private Long id;
    private String name;
    private Integer runningStatus;
}

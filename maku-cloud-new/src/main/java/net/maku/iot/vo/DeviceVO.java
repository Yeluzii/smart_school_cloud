package net.maku.iot.vo;

import lombok.Data;

/**
 * @Author: krislorem
 * @Package: net.maku.iot.vo
 * @Project: smart_school_cloud
 * @name: DeviceVO
 * @Date: 2025/6/6 12:53
 * @FileName: DeviceVO
 * @description:
 */
@Data
public class DeviceVO {
    private Long id;
    private String code;
    private String name;
    private String uid;
}

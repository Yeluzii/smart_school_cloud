package net.maku.iot.vo;

import lombok.Data;

/**
 * @Author: krislorem
 * @Package: net.maku.iot.vo
 * @Project: smart_school_cloud
 * @name: RoleVO
 * @Date: 2025/6/6 14:09
 * @FileName: RoleVO
 * @description:
 */
@Data
public class RoleVO {
    private Long id;
    private String name;
    private String roleCode;
    private String remark;
}

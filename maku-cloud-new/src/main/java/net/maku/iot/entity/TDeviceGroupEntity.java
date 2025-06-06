package net.maku.iot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: krislorem
 * @Package: net.maku.iot.entity
 * @Project: smart_school_cloud
 * @name: TDeviceGroupEntity
 * @Date: 2025/6/5 18:59
 * @FileName: TDeviceGroupEntity
 * @description: 设备分组管理表
 */
@Data
@TableName(value = "t_device_group")
public class TDeviceGroupEntity {
    /**
     * 分组名称
     */
    @TableField(value = "id")
    private Long id;
    @TableField(value = "device_id")
    private Long deviceId;
    @TableField(value = "group_id")
    private Long groupId;

    @TableField(value = "tenant_id")
    private Long tenantId;

}

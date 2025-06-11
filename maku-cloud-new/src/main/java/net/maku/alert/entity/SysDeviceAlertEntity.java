package net.maku.alert.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 * d
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("sys_device_alert")
public class SysDeviceAlertEntity {
    @TableId
    @TableField(value = "id")
    private Long id;

    @TableField(value = "alert_id")
    private Long alertId;

    @TableField(value = "device_id")
    private Long deviceId;

    @TableField(value = "deleted", fill = FieldFill.INSERT)
    private Integer deleted;

}

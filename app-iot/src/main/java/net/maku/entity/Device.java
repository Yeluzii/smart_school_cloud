package net.maku.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.maku.framework.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("iot_device")
public class Device extends BaseEntity {
    private String code;
    private String name;
    private Integer type;
    private String protocolType;
    private String uid;
    private String secret;
    private String appVersion;
    private String batteryPercent;
    private String temperature;
    private Integer status;
    private Boolean runningStatus;
    private LocalDateTime upTime;
    private LocalDateTime downTime;
    private Long tenantId;
    private String pullUrl;
}

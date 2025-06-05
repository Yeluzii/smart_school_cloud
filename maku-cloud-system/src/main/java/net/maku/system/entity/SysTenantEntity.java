package net.maku.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.mybatis.entity.BaseEntity;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_tenant")
public class SysTenantEntity extends BaseEntity {
    private String tenantName;
    private String username;
    private String password;
    private String mobile;
    private String packageId;
    private LocalDateTime expireTime;
    private Integer status;
    private String info;
}

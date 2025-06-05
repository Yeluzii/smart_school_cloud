package net.maku.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.maku.framework.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class UserEntity extends BaseEntity {
    private String username;
    private String password;
    private String realName;
    private String avatar;
    private Integer gender;
    private String email;
    private String mobile;
    private Long orgId;
    private Integer superAdmin;
    private Integer status;
    private Long tenantId;
}

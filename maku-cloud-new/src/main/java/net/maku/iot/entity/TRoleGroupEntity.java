package net.maku.iot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: krislorem
 * @Package: net.maku.iot.entity
 * @Project: smart_school_cloud
 * @name: TRoleGroupEntity
 * @Date: 2025/6/5 19:04
 * @FileName: TRoleGroupEntity
 * @description: 角色分组关联表
 */
@Data
@TableName("t_role_group")
public class TRoleGroupEntity {
    @TableField(value = "id")
    private Long id;

    @TableField(value = "role_id")
    private Long roleId;

    @TableField(value = "group_id")
    private Long groupId;

    @TableField(value = "tenant_id")
    private Long tenantId;
}

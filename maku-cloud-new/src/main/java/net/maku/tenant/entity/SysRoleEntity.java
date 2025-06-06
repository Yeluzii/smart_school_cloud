package net.maku.tenant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 * 角色管理
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("sys_role")
public class SysRoleEntity {
	/**
	* id
	*/
	@TableId
	@TableField(value = "id")
	private Long id;

	/**
	* 角色名称
	*/
	@TableField(value = "name")
	private String name;

	/**
	* 角色编码
	*/
	@TableField(value = "role_code")
	private String roleCode;

	/**
	* 备注
	*/
	@TableField(value = "remark")
	private String remark;

	/**
	* 数据范围  0：全部数据  1：本机构及子机构数据  2：本机构数据  3：本人数据  4：自定义数据
	*/
	@TableField(value = "data_scope")
	private Integer dataScope;

	/**
	* 机构ID
	*/
	@TableField(value = "org_id")
	private Long orgId;

	/**
	* 租户ID
	*/
	@TableField(value = "tenant_id")
	private Long tenantId;

	/**
	* 版本号
	*/
	@TableField(value = "version", fill = FieldFill.INSERT)
	private Integer version;

	/**
	* 删除标识  0：正常   1：已删除
	*/
	@TableField(value = "deleted", fill = FieldFill.INSERT)
	private Integer deleted;

	/**
	* 创建者
	*/
	@TableField(value = "creator", fill = FieldFill.INSERT)
	private Long creator;

	/**
	* 创建时间
	*/
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	/**
	* 更新者
	*/
	@TableField(value = "updater", fill = FieldFill.INSERT_UPDATE)
	private Long updater;

	/**
	* 更新时间
	*/
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
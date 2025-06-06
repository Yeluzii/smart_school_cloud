package net.maku.tenant.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import net.maku.framework.mybatis.entity.BaseEntity;

/**
 * 租户相关
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("sys_tenant")
public class SysTenantEntity extends BaseEntity {

	/**
	* 租户名称
	*/
	@TableField(value = "tenant_name")
	private String tenantName;

	/**
	* 用户名
	*/
	@TableField(value = "username")
	private String username;

	/**
	* 密码
	*/
	@TableField(value = "password")
	private String password;

	/**
	* 手机号
	*/
	@TableField(value = "mobile")
	private String mobile;

	/**
	* 租户套餐
	*/
	@TableField(value = "package_id")
	private Long packageId;

	/**
	* 过期时间
	*/
	@TableField(value = "expire_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date expireTime;

	/**
	* 状态 0未启用 1启用
	*/
	@TableField(value = "status")
	private Integer status;

	/**
	* 备注
	*/
	@TableField(value = "info")
	private String info;







}
package net.maku.tenant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import net.maku.framework.mybatis.entity.BaseEntity;

/**
 * 套餐管理
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("sys_package")
public class SysPackageEntity extends BaseEntity {

	/**
	* 套餐名称
	*/
	@TableField(value = "package_name")
	private String packageName;

	/**
	* 角色id
	*/
	@TableField(value = "role_id")
	private Integer roleId;

	/**
	* 备注
	*/
	@TableField(value = "info")
	private String info;






}
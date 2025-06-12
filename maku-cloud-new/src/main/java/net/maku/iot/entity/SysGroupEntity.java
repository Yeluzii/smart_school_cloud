package net.maku.iot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import net.maku.framework.mybatis.entity.BaseEntity;

/**
 * group
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("sys_group")
public class SysGroupEntity extends BaseEntity {

	/**
	* 分组名称
	*/
	@TableField(value = "name")
	private String name;


	@TableField(value = "tenant_id")
	private Long tenantId;

	@TableField(value = "updater")
	private Long updater;


	@TableField(value = "org_id")
	private Long orgId;


	/**
	* 备注
	*/
	@TableField(value = "info")
	private String info;

}

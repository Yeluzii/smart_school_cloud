package net.maku.alert.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 * 告警配置表
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("sys_alert")
public class SysAlertEntity {
	/**
	* 告警id
	*/
	@TableId
	@TableField(value = "id")
	private Long id;

	/**
	* 告警名称
	*/
	@TableField(value = "alert_name")
	private String alertName;

	/**
	* 租户id
	*/
	@TableField(value = "tenant_id")
	private Long tenantId;

	/**
	* 状态 0：禁用 1：启用
	*/
	@TableField(value = "status")
	private Integer status;

	/**
	* 告警级别 0：提醒通知 1：轻微问题 2：严重警告
	*/
	@TableField(value = "alert_level")
	private Integer alertLevel;

	/**
	* 备注信息
	*/
	@TableField(value = "notes")
	private String notes;
	/**
	* 删除标识 0：正常 1：已删除
	*/
	@TableField(value = "deleted", fill = FieldFill.INSERT)
	private Integer deleted;

}

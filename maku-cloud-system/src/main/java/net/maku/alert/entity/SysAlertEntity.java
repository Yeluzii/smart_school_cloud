package net.maku.alert.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import net.maku.framework.mybatis.entity.BaseEntity;

/**
 * 告警配置表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("sys_alert")
public class SysAlertEntity extends BaseEntity {

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
	* 租户名称
	*/
	@TableField(value = "tenant_name")
	private String tenantName;

	/**
	* 设备id
	*/
	@TableField(value = "device_id")
	private Long deviceId;

	/**
	* 设备名称
	*/
	@TableField(value = "device_name")
	private String deviceName;

	/**
	* 状态
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





}
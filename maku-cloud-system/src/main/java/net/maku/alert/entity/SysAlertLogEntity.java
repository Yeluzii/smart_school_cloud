package net.maku.alert.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 * 告警记录表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("sys_alert_log")
public class SysAlertLogEntity {
	/**
	* 告警记录id
	*/
	@TableId
	@TableField(value = "id")
	private Long id;

	/**
	* 告警id
	*/
	@TableField(value = "alert_id")
	private Long alertId;

	/**
	* 告警名称
	*/
	@TableField(value = "alert_name")
	private String alertName;

	/**
	* 设备编号
	*/
	@TableField(value = "device_id")
	private Long deviceId;

	/**
	* 设备名称
	*/
	@TableField(value = "device_name")
	private String deviceName;

	/**
	* 唯一标识码
	*/
	@TableField(value = "uid")
	private String uid;

	/**
	* 告警级别 0：提醒通知 1：轻微问题 2：严重警告
	*/
	@TableField(value = "alert_level")
	private Integer alertLevel;

	/**
	* 告警时间
	*/
	@TableField(value = "alert_time")
	private Date alertTime;

	/**
	* 告警数据
	*/
	@TableField(value = "alert_info")
	private Object alertInfo;

	/**
	* 处理状态 0：未处理 1：已处理
	*/
	@TableField(value = "status")
	private Integer status;

}
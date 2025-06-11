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
	* 告警记录
	*/
	@TableId
	@TableField(value = "id")
	private Long id;

	/**
	* 设备id
	*/
	@TableField(value = "device_id")
	private Long deviceId;

	/**
	* 告警数据
	*/
	@TableField(value = "alert_info")
	private Object alertInfo;

}

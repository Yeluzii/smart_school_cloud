package net.maku.alert.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.util.Date;

/**
 * 告警记录表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "告警记录表")
public class SysAlertLogVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "告警记录id")
	private Long id;

	@Schema(description = "告警id")
	private Long alertId;

	@Schema(description = "告警名称")
	private String alertName;

	@Schema(description = "设备编号")
	private Long deviceId;

	@Schema(description = "设备名称")
	private String deviceName;

	@Schema(description = "唯一标识码")
	private String uid;

	@Schema(description = "告警级别 0：提醒通知 1：轻微问题 2：严重警告")
	private Integer alertLevel;

	@Schema(description = "告警时间")
	private Date alertTime;

	@Schema(description = "告警数据")
	private Object alertInfo;

	@Schema(description = "处理状态 0：未处理 1：已处理")
	private Integer status;

}
package net.maku.alert.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.util.Date;

/**
 * 告警配置表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "告警配置表")
public class SysAlertVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "告警id")
	private Long id;

	@Schema(description = "告警名称")
	private String alertName;

	@Schema(description = "租户id")
	private Long tenantId;

	@Schema(description = "租户名称")
	private String tenantName;

	@Schema(description = "设备id")
	private Long deviceId;

	@Schema(description = "设备名称")
	private String deviceName;

	@Schema(description = "状态")
	private Integer status;

	@Schema(description = "告警级别 0：提醒通知 1：轻微问题 2：严重警告")
	private Integer alertLevel;

	@Schema(description = "创建者")
	private Long creator;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "备注信息")
	private String notes;

	@Schema(description = "更新者")
	private Long updater;

	@Schema(description = "更新时间")
	private Date updateTime;

	@Schema(description = "版本号")
	private Integer version;

	@Schema(description = "删除标识 0：正常 1：已删除")
	private Integer deleted;

}
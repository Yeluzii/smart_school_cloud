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

	@Schema(description = "告警记录")
	private Long id;

	@Schema(description = "设备id")
	private Long deviceId;

	@Schema(description = "告警数据")
	private Object alertInfo;

}

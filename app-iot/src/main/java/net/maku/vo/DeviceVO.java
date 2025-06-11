package net.maku.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.maku.framework.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Schema(description = "设备VO")
public class DeviceVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 6667948772845433610L;
    @Schema(description = "id")
    private Long id;
    @Schema(description = "设备编码")
    private String code;
    @Schema(description = "设备名称")
    private String name;
    @Schema(description = "设备类型")
    private Integer type;
    @Schema(description = "设备唯一标识")
    private String uid;
    @Schema(description = "温度")
    private Float temperature;
    @Schema(description = "湿度")
    private Float humidity;
    @Schema(description = "门的开关状态")
    private Boolean door;
    @Schema(description = "风扇的开关状态")
    private Boolean fan;
    @Schema(description = "设备在线状态")
    private Boolean runningStatus;
}

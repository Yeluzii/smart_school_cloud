package net.maku.alert.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 告警记录表查询
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "告警记录表查询")
public class SysAlertLogQuery extends Query {
    @Schema(description = "告警名称")
    private String alertName;

    @Schema(description = "告警级别 0：提醒通知 1：轻微问题 2：严重警告")
    private Integer alertLevel;

    @Schema(description = "处理状态 0：未处理 1：已处理")
    private Integer status;

}
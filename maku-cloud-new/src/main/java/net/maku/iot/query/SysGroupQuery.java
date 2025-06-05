package net.maku.iot.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * group查询
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "group查询")
public class SysGroupQuery extends Query {
    @Schema(description = "分组名称")
    private String name;

    private Long tenantId;

    @Schema(description = "备注")
    private String info;

}
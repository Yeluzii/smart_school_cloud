package net.maku.business.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 资讯表查询
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "资讯表查询")
public class TNewsQuery extends Query {
    @Schema(description = "轮播状态 0不轮播 1轮播")
    private Integer banner;

    @Schema(description = "发布状态 0未发布 1已发布")
    private Integer status;

    @Schema(description = "置顶状态 0不置顶 1置顶")
    private Integer istop;

    @Schema(description = "内容类型 0公告 1校园信息")
    private Integer type;
}
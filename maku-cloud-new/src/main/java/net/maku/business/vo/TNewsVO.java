package net.maku.business.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.util.Date;

/**
 * 资讯表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "资讯表")
public class TNewsVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "咨讯id")
	private Long id;

	@Schema(description = "租户id")
	private Long tenantId;

	@Schema(description = "内容")
	private String content;

	@Schema(description = "封面")
	private String cover;

	@Schema(description = "0不轮播 1轮播")
	private Integer banner;

	@Schema(description = "0未发布 1已发布")
	private Integer status;

	@Schema(description = "0不置顶 1置顶")
	private Integer istop;

	@Schema(description = "作者")
	private String author;

	@Schema(description = "0公告 1校园信息")
	private Integer type;

	@Schema(description = "标题")
	private String title;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "更新时间")
	private Date updateTime;

	@Schema(description = "0未删除 1已删除")
	private Integer deleted;

	@Schema(description = "创建者")
	private Long creator;

	@Schema(description = "更新者")
	private Long updater;

	@Schema(description = "版本号")
	private Integer version;

}
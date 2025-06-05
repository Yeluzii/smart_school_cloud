package net.maku.business.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.util.Date;

/**
 * 资讯表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class TNewsExcelVO implements TransPojo {
	@ExcelProperty("咨讯id")
	private Long id;

	@ExcelProperty("租户id")
	private Long tenantId;

	@ExcelProperty("内容")
	private String content;

	@ExcelProperty("封面")
	private String cover;

	@ExcelProperty("0不轮播 1轮播")
	private Integer banner;

	@ExcelProperty("0未发布 1已发布")
	private Integer status;

	@ExcelProperty("0不置顶 1置顶")
	private Integer istop;

	@ExcelProperty("作者")
	private String author;

	@ExcelProperty("0公告 1校园信息")
	private Integer type;

	@ExcelProperty("标题")
	private String title;

}
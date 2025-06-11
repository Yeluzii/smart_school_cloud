package net.maku.alert.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.util.Date;

/**
 * 告警配置表
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class SysAlertExcelVO implements TransPojo {
	@ExcelIgnore
	private Long id;

	@ExcelProperty("告警名称")
	private String alertName;

	@ExcelProperty("状态 0：禁用 1：启用")
	private Integer status;

	@ExcelProperty("告警级别 0：提醒通知 1：轻微问题 2：严重警告")
	private Integer alertLevel;

	@ExcelProperty("备注信息")
	private String notes;

}

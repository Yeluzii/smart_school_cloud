package net.maku.alert.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.util.Date;

/**
 * 告警记录表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class SysAlertLogExcelVO implements TransPojo {
	@ExcelIgnore
	private Long id;

	@ExcelProperty("告警名称")
	private String alertName;

	@ExcelProperty("设备编号")
	private Long deviceId;

	@ExcelProperty("设备名称")
	private String deviceName;

	@ExcelProperty("告警级别 0：提醒通知 1：轻微问题 2：严重警告")
	private Integer alertLevel;

	@ExcelProperty("告警时间")
	private Date alertTime;

	@ExcelProperty("告警数据")
	private Object alertInfo;

	@ExcelProperty("处理状态 0：未处理 1：已处理")

	private Integer status;

}
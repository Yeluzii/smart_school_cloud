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

	@ExcelProperty("设备id")
	private Long deviceId;

	@ExcelProperty("告警数据")
	private Object alertInfo;

}
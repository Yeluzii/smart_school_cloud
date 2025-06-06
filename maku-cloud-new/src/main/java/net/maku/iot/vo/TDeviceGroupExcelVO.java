package net.maku.iot.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;

/**
 * tdg
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class TDeviceGroupExcelVO implements TransPojo {
	@ExcelIgnore
	private Long id;

	@ExcelProperty("设备")
	private Long deviceId;

	@ExcelProperty("分组")
	private Long groupId;

	private Long tenantId;

}

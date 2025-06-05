package net.maku.iot.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.util.Date;

/**
 * group
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class SysGroupExcelVO implements TransPojo {
	@ExcelIgnore
	private Long id;


	@ExcelProperty("分组名称")
	private String name;

	private Long tenantId;

	@ExcelProperty("备注")
	private String info;

}

package net.maku.tenant.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.util.Date;

/**
 * 套餐管理
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class SysPackageExcelVO implements TransPojo {
	@ExcelProperty("套餐id")
	private Long id;

	@ExcelProperty("套餐名称")
	private String packageName;

	@ExcelProperty("角色id")
	private Integer roleId;

	@ExcelProperty("备注")
	private String info;

}
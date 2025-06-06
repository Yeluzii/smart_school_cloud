package net.maku.iot.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.fhs.core.trans.vo.TransPojo;

/**
 * trg
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class TRoleGroupExcelVO implements TransPojo {
	@ExcelIgnore
	private Long id;

	private Long roleId;

	private Long groupId;

	private Long tenantId;

}

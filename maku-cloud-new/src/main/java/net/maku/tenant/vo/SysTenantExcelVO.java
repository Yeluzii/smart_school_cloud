package net.maku.tenant.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.util.Date;

/**
 * 租户相关
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class SysTenantExcelVO implements TransPojo {
	@ExcelProperty("租户id")
	private Long id;

	@ExcelProperty("租户名称")
	private String tenantName;

	@ExcelProperty("用户名")
	private String username;

	@ExcelProperty("密码")
	private String password;

	@ExcelProperty("手机号")
	private String mobile;

	@ExcelProperty("租户套餐")
	private Long packageId;

	@ExcelProperty("过期时间")
	private Date expireTime;

	@ExcelProperty("状态 0未启用 1启用")
	private Integer status;

	@ExcelProperty("备注")
	private String info;

}
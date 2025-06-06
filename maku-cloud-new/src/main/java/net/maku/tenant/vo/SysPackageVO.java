package net.maku.tenant.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.util.Date;

/**
 * 套餐管理
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "套餐管理")
public class SysPackageVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "套餐id")
	private Long id;

	@Schema(description = "套餐名称")
	private String packageName;

	@Schema(description = "角色id")
	private Integer roleId;

	@Schema(description = "备注")
	private String info;

	@Schema(description = "创建者")
	private Long creator;

	@Schema(description = "更新者")
	private Long updater;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "更新时间")
	private Date updateTime;

	@Schema(description = "逻辑删除")
	private Integer deleted;

}
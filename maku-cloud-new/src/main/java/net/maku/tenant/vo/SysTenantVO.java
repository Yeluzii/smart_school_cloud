package net.maku.tenant.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.util.Date;

/**
 * 租户相关
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "租户相关")
public class SysTenantVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "租户id")
	private Long id;

	@Schema(description = "租户名称")
	private String tenantName;

	@Schema(description = "用户名")
	private String username;

	@Schema(description = "手机号")
	private String mobile;

	@Schema(description = "租户套餐")
	private Long packageId;

	@Schema(description = "过期时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date expireTime;

	@Schema(description = "状态 0未启用 1启用")
	private Integer status;

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

	@Schema(description = "版本")
	private Integer version;

}
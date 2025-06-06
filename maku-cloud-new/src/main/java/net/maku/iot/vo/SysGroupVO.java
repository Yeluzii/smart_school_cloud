package net.maku.iot.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.util.Date;

/**
 * group
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "group")
public class SysGroupVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@Schema(description = "分组名称")
	private String name;

	private Long creator;

	private Long updater;

	private Date createTime;

	private Date updateTime;

	private Long tenantId;

	@Schema(description = "备注")
	private String info;

	private Integer deleted;

	private Long orgId;

	private Integer version;
}

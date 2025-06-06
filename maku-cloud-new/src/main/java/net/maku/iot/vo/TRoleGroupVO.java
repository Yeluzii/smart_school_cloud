package net.maku.iot.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * trg
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "trg")
public class TRoleGroupVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long roleId;

	private Long groupId;

	private Long tenantId;
	private Integer deleted;

	private Long orgId;
	private Long creator;

	private Long updater;

	private Date createTime;

	private Date updateTime;

	private Integer version;
}

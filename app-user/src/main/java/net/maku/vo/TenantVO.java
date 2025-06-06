package net.maku.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "租户名称vo")
public class TenantVO {
    @Schema(description = "租户id")
    private Long id;
    @Schema(description = "租户名称")
    private String tenantName;
}

package net.maku.tenant.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
public class SysTenantDTO {
    @Schema(description = "租户id")
    private Long id;

    @Schema(description = "租户名称")
    private String tenantName;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "租户套餐")
    private Long packageId;

    @Schema(description = "状态 0未启用 1启用")
    private Integer status;

    @Schema(description = "备注")
    private String info;

}

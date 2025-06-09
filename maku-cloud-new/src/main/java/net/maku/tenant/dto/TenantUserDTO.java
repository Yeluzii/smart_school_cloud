package net.maku.tenant.dto;

import lombok.Data;

@Data
public class TenantUserDTO {
    private Long tenantId;
    private String username;
    private String password;
}

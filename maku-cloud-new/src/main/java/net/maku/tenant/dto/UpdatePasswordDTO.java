package net.maku.tenant.dto;

import lombok.Data;

@Data
public class UpdatePasswordDTO {
    private Long tenantId;
    private String newPassword;
}

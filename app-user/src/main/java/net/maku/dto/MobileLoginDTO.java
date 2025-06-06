package net.maku.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Schema(description = "手机号登录")
public class MobileLoginDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 6445069602454130022L;
    @Schema(description = "⼿机号")
    private String mobile;
    @Schema(description = "验证码")
    private String code;
}

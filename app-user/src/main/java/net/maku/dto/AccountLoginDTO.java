package net.maku.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Schema(description = "账号登录")
public class AccountLoginDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 8266797648637162410L;
    @Schema(description = "⽤户名")
    private String username;
    @Schema(description = "密码")
    private String password;
}

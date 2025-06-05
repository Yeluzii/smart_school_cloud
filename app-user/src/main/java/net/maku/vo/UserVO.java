package net.maku.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Schema(description = "用户vo")
public class UserVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -7483922209213744585L;

    @Schema(description = "id")
    private Long id;
    @Schema(description = "⽤户名")
    private String username;
    @Schema(description = "姓名")
    private String realName;
    @Schema(description = "⼿机号")
    private String mobile;
    @Schema(description = "头像")
    private String avatar;
    @Schema(description = "性别 0：男 1：⼥ 2：未知")
    private Integer gender;
    @Schema(description = "邮箱")
    private String email;
}

package net.maku.query;

import net.maku.framework.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "用户查询参数")
public class UserQuery extends Query {
    @Schema(description = "⽤户名")
    private String username;
    @Schema(description = "⼿机号")
    private String mobile;
}

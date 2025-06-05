package net.maku.framework.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误编码
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNAUTHORIZED(401, "还未授权，不能访问"),
    FORBIDDEN(403, "没有权限，禁止访问"),
    REFRESH_TOKEN_INVALID(400, "refresh_token 已失效"),
    INTERNAL_SERVER_ERROR(500, "服务器异常，请稍后再试"),
    SMS_CODE_ERROR(3004,"短信验证码错误" ),
    PARAMS_ERROR(3003,"参数异常" ),
    CODE_SEND_FAIL(3002,"短信发送失败" );

    private final int code;
    private final String msg;
}

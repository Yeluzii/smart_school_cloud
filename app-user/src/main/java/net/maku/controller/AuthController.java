package net.maku.controller;

import net.maku.dto.MobileRegisterDTO;
import net.maku.service.UserRoleService;
import net.maku.sms.service.AliyunSmsService;
import lombok.AllArgsConstructor;
import net.maku.dto.AccountLoginDTO;
import net.maku.dto.MobileLoginDTO;
import net.maku.framework.common.exception.ErrorCode;
import net.maku.framework.common.utils.Result;
import net.maku.framework.security.utils.TokenUtils;
import net.maku.service.AuthService;
import net.maku.vo.AccountLoginVO;
import net.maku.vo.MobileLoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@Tag(name = "认证模块")
@AllArgsConstructor
public class AuthController {
    private  AuthService authService;
    private  AliyunSmsService smsService;
    private UserRoleService userRoleService;

    @PostMapping("login")
    @Operation(summary = "账号密码登录")
    public Result<AccountLoginVO> accountLogin(@RequestBody AccountLoginDTO login) {
        AccountLoginVO accountLoginVO = authService.loginByAccount(login);
        return Result.ok(accountLoginVO);
    }

    @PostMapping("send/code")
    @Operation(summary = "发送短信验证码")
    public Result<String> sendCode(String mobile) {
        boolean flag = smsService.sendSms(mobile);
        if (!flag) {
            return Result.error(ErrorCode.CODE_SEND_FAIL);
        }
        return Result.ok();
    }

    @PostMapping("mobile/register")
    @Operation(summary = "⼿机号注册")
    public Result<MobileLoginVO> mobileRegister(@RequestBody MobileRegisterDTO register) {
        try {
        MobileLoginVO mobileLoginVO = authService.registerByMobile(register);
        if (userRoleService.add(mobileLoginVO.getId())){
            return Result.ok(mobileLoginVO);
        }else {
            return Result.error(ErrorCode.INTERNAL_SERVER_ERROR);
        }
        }catch (Exception e){
            return Result.error(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("mobile/login")
    @Operation(summary = "⼿机号登录")
    public Result<MobileLoginVO> mobileLogin(@RequestBody MobileLoginDTO login) {
        MobileLoginVO mobileLoginVO = authService.loginByMobile(login);
        return Result.ok(mobileLoginVO);
    }

    @PostMapping("logout")
    @Operation(summary = "退出")
    public Result<String> logout(HttpServletRequest request) {
        authService.logout(TokenUtils.getAccessToken(request));
        return Result.ok();
    }
}

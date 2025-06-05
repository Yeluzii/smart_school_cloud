package net.maku.controller;

import cn.hutool.core.util.StrUtil;
import net.maku.convert.UserConvert;
import net.maku.dto.UserDTO;
import net.maku.framework.common.utils.Result;
import net.maku.framework.security.user.SecurityUser;
import net.maku.service.UserService;
import net.maku.vo.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Tag(name = "用户模块")
@RequestMapping("user")
public class UserController {
    private final UserService sysUserService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("info")
    @Operation(summary = "获取⽤户信息")
    public Result<UserVO> getUserInfo() {
        UserVO user = UserConvert.INSTANCE.convert(SecurityUser.getUser());
        return Result.ok(user);
    }

    @PostMapping("register")
    @Operation(summary = "注册⽤户")
    public Result<String> register(@RequestBody @Valid UserDTO dto) {
        // 新增密码不能为空
        if (StrUtil.isBlank(dto.getPassword())) {
            return Result.error("密码不能为空");
        }
        // 密码加密
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        // 保存
        sysUserService.save(dto);
        return Result.ok();
    }

    @PutMapping("update")
    @Operation(summary = "修改⽤户信息")
    public Result<String> updateUser(@RequestBody @Valid UserDTO dto) {
        sysUserService.update(dto);
        return Result.ok();
    }

    @GetMapping("getUserById")
    @Operation(summary = "根据id获取⽤户")
    public Result<UserVO> getUserById(Long id) {
        return Result.ok(sysUserService.getById(id));
    }

    @GetMapping("getUserByMobile")
    @Operation(summary = "根据⼿机号获取⽤户")
    public Result<UserVO> getUserByMobile(String mobile) {
        return Result.ok(sysUserService.getByMobile(mobile));
    }
}

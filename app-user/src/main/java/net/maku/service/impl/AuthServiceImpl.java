package net.maku.service.impl;

import net.maku.convert.UserConvert;
import net.maku.dto.AccountLoginDTO;
import net.maku.dto.MobileLoginDTO;
import net.maku.dto.MobileRegisterDTO;
import net.maku.entity.UserEntity;
import net.maku.framework.common.exception.ServerException;
import net.maku.framework.security.cache.TokenStoreCache;
import net.maku.framework.security.mobile.MobileAuthenticationToken;
import net.maku.framework.security.user.UserDetail;
import net.maku.framework.security.utils.JwtUtil;
import net.maku.service.AuthService;
import net.maku.service.UserService;
import net.maku.vo.AccountLoginVO;
import net.maku.vo.MobileLoginVO;
import net.maku.vo.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final TokenStoreCache tokenStoreCache;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AccountLoginVO loginByAccount(AccountLoginDTO login) {
        Authentication authentication;
        try {
            // ⽤户认证
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        } catch (BadCredentialsException e) {
            throw new ServerException("⽤户名或密码错误");
        }
        // ⽤户信息
        UserDetail user = (UserDetail) authentication.getPrincipal();
        // ⽣成 accessToken
        String accessToken = JwtUtil.createToken(user.getId());
        // 保存⽤户信息到缓存
        tokenStoreCache.saveUser(accessToken, user);
        AccountLoginVO accountLoginVO = new AccountLoginVO();
        accountLoginVO.setId(user.getId());
        accountLoginVO.setAccessToken(accessToken);
        accountLoginVO.setUsername(user.getUsername());
        return accountLoginVO;
    }

    @Override
    public MobileLoginVO loginByMobile(MobileLoginDTO login) {
        UserVO userVO = userService.getByMobile(login.getMobile());
        if (userVO == null) {
            throw new ServerException("⽤户不存在");
        }
        Authentication authentication;
        try {
            // ⽤户认证
            authentication = authenticationManager.authenticate(new MobileAuthenticationToken(login.getMobile(), login.getCode()));
        } catch (BadCredentialsException e) {
            throw new ServerException("⼿机号或验证码错误");
        }
        // ⽤户信息
        UserDetail userDetail = (UserDetail) authentication.getPrincipal();
        // ⽣成 accessToken
        String accessToken = JwtUtil.createToken(userDetail.getId());
        // 保存⽤户信息到缓存
        tokenStoreCache.saveUser(accessToken, userDetail);
        MobileLoginVO mobileLoginVO = new MobileLoginVO();
        mobileLoginVO.setId(userDetail.getId());
        mobileLoginVO.setAccessToken(accessToken);
        mobileLoginVO.setMobile(login.getMobile());
        return mobileLoginVO;
    }

    @Override
    public MobileLoginVO registerByMobile(MobileRegisterDTO register) {
        UserVO userVO = userService.getByMobile(register.getMobile());
        if (userVO == null) {
            UserEntity entity = UserConvert.INSTANCE.convert(register);
            entity.setStatus(1);
            entity.setUsername(register.getMobile());
            entity.setPassword(passwordEncoder.encode("123456"));
            entity.setRealName("新⽤户");
            entity.setAvatar("https://yeluzi08-bucket.oss-cn-nanjing.aliyuncs.com/507586d3-22ae-417a-aaaf-ca9af87046c6_child1.jpg");
            userService.save(entity);
        }
        Authentication authentication;
        try {
            // ⽤户认证
            authentication = authenticationManager.authenticate(new MobileAuthenticationToken(register.getMobile(), register.getCode()));
        } catch (BadCredentialsException e) {
            throw new ServerException("⼿机号或验证码错误");
        }
        // ⽤户信息
        UserDetail userDetail = (UserDetail) authentication.getPrincipal();
        // ⽣成 accessToken
        String accessToken = JwtUtil.createToken(userDetail.getId());
        // 保存⽤户信息到缓存
        tokenStoreCache.saveUser(accessToken, userDetail);
        MobileLoginVO mobileLoginVO = new MobileLoginVO();
        mobileLoginVO.setId(userDetail.getId());
        mobileLoginVO.setAccessToken(accessToken);
        mobileLoginVO.setMobile(register.getMobile());
        return mobileLoginVO;
    }

    @Override
    public void logout(String accessToken) {
        // 删除⽤户信息
        tokenStoreCache.deleteUser(accessToken);
    }
}

package net.maku.service;

import net.maku.dto.AccountLoginDTO;
import net.maku.dto.MobileLoginDTO;
import net.maku.dto.MobileRegisterDTO;
import net.maku.vo.AccountLoginVO;
import net.maku.vo.MobileLoginVO;

public interface AuthService {
    /**
     * 账号密码登录
     *
     * @param login 登录信息
     */
    AccountLoginVO loginByAccount(AccountLoginDTO login);
    /**
     * ⼿机短信登录
     *
     * @param login 登录信息
     */
    MobileLoginVO loginByMobile(MobileLoginDTO login);
    /**
     * ⼿机短信注册
     *
     * @param register 注册信息
     */
    MobileLoginVO registerByMobile(MobileRegisterDTO register);
    /**
     * 退出登录
     *
     * @param accessToken accessToken
     */
    void logout(String accessToken);
}

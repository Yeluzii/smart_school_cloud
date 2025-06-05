package net.maku.service.impl;

import net.maku.convert.UserConvert;
import net.maku.dao.UserDao;
import net.maku.entity.UserEntity;
import net.maku.framework.security.mobile.MobileUserDetailsService;
import net.maku.service.MyUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MobileUserDetailsServiceImpl implements MobileUserDetailsService {
    private final MyUserDetailsService myUserDetailsService;
    private final UserDao sysUserDao;

    @Override
    public UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        UserEntity userEntity = sysUserDao.getByMobile(mobile);
        if (userEntity == null) {
            throw new UsernameNotFoundException("⼿机号或验证码错误");
        }
        return myUserDetailsService.getUserDetails(UserConvert.INSTANCE.convertDetail(userEntity));
    }
}

package net.maku.service.impl;

import net.maku.convert.UserConvert;
import net.maku.dao.UserDao;
import net.maku.entity.UserEntity;
import net.maku.service.MyUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final MyUserDetailsService myUserDetailsService;
    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userDao.getByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("⽤户名或密码错误");
        }
        return myUserDetailsService.getUserDetails(UserConvert.INSTANCE.convertDetail(userEntity));
    }
}

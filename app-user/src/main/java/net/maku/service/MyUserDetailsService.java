package net.maku.service;

import net.maku.framework.security.user.UserDetail;
import org.springframework.security.core.userdetails.UserDetails;

public interface MyUserDetailsService {
    UserDetails getUserDetails(UserDetail userDetail);
}

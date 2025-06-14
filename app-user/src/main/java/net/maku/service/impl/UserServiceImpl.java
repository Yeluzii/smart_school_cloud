package net.maku.service.impl;

import net.maku.convert.UserConvert;
import net.maku.dao.UserDao;
import net.maku.dto.UserDTO;
import net.maku.entity.UserEntity;
import net.maku.framework.common.exception.ServerException;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.framework.security.cache.TokenStoreCache;
import net.maku.framework.security.user.SecurityUser;
import net.maku.framework.security.utils.TokenUtils;
import net.maku.service.UserService;
import net.maku.vo.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<UserDao, UserEntity> implements UserService {
    private final TokenStoreCache tokenStoreCache;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserDTO dto) {
        UserEntity entity = UserConvert.INSTANCE.convert(dto);
        // 判断⽤户名是否存在
        UserEntity user = baseMapper.getByUsername(entity.getUsername());
        if (user != null) {
            throw new ServerException("⽤户名已经存在");
        }
        // 判断⼿机号是否存在
        user = baseMapper.getByMobile(entity.getMobile());
        if (user != null) {
            throw new ServerException("⼿机号已经存在");
        }
        // 保存⽤户
        baseMapper.insert(entity);
    }

    @Override
    public void update(UserDTO dto) {
        UserEntity entity = UserConvert.INSTANCE.convert(dto);
        entity.setId(SecurityUser.getUser().getId());
        if (dto.getPassword() != null) {
            entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        // 更新⽤户
        updateById(entity);
        // 删除⽤户缓存
        tokenStoreCache.deleteUser(TokenUtils.getAccessToken());
    }

    @Override
    public UserVO getByMobile(String mobile) {
        UserEntity user = baseMapper.getByMobile(mobile);
        return UserConvert.INSTANCE.convert(user);
    }

    @Override
    public UserVO getById(Long id) {
        UserEntity user = baseMapper.getById(id);
        return UserConvert.INSTANCE.convert(user);
    }

    @Override
    @Transactional
    public boolean changePassword(Long userId, String newPassword) {
        UserEntity user = userDao.getById(userId);
        if (user != null) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userDao.updateById(user);
            return true;
        }
        return false;
    }
}

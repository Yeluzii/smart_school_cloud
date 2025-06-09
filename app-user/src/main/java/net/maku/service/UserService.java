package net.maku.service;

import net.maku.dto.UserDTO;
import net.maku.entity.UserEntity;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.vo.UserVO;

public interface UserService extends BaseService<UserEntity> {
    void save(UserDTO vo);

    void update(UserDTO dto);

    UserVO getByMobile(String mobile);

    UserVO getById(Long id);
    boolean changePassword(Long userId, String newPassword);
}

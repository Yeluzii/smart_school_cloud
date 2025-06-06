package net.maku.convert;

import net.maku.dto.MobileLoginDTO;
import net.maku.dto.MobileRegisterDTO;
import net.maku.dto.UserDTO;
import net.maku.entity.UserEntity;
import net.maku.framework.security.user.UserDetail;
import net.maku.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserVO convert(UserEntity entity);

    UserEntity convert(UserDTO dto);

    UserVO convert(UserDetail userDetail);

    UserEntity convert(MobileLoginDTO dto);
    UserEntity convert(MobileRegisterDTO dto);

    UserDetail convertDetail(UserEntity entity);
}

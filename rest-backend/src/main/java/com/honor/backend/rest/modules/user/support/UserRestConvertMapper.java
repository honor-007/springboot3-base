package com.honor.backend.rest.modules.user.support;

import com.honor.backend.core.modules.user.dao.criteria.UserCriteria;
import com.honor.backend.core.modules.user.service.bo.UserBO;
import com.honor.backend.rest.modules.user.controller.query.UserQuery;
import com.honor.backend.rest.modules.user.controller.ro.UserCreateRO;
import com.honor.backend.rest.modules.user.controller.ro.UserUpdateRO;
import com.honor.backend.rest.modules.user.controller.vo.UserVO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author honor
 */
@Mapper(builder = @Builder(disableBuilder = true))
public interface UserRestConvertMapper {
    UserRestConvertMapper INSTANT = Mappers.getMapper(UserRestConvertMapper.class);

    UserCriteria from(UserQuery args);

    UserVO from(UserBO args);

    UserBO from(UserCreateRO args);

    UserBO from(UserUpdateRO args);

    List<UserVO> fromList(List<UserBO> args);

}

package com.honor.backend.core.modules.user.support;

import com.honor.backend.core.modules.user.dao.entity.User;
import com.honor.backend.core.modules.user.service.bo.UserBO;
import com.honor.infrastructure.common.actor.Actor;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author honor
 */
@Mapper(builder = @Builder(disableBuilder = true))
public interface UserConvertMapper {
    UserConvertMapper INSTANCE = Mappers.getMapper(UserConvertMapper.class);

    List<UserBO> fromList(List<User> users);

    User from(UserBO args);

    UserBO from(User user);

    Actor userCnvToActor(UserBO userBO);

}

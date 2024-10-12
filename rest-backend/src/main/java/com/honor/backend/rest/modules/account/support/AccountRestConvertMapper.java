package com.honor.backend.rest.modules.account.support;

import com.honor.backend.core.modules.account.service.bo.AccountSignBO;
import com.honor.backend.core.modules.account.service.ro.AccountSignInRO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author honor
 */
@Mapper(builder = @Builder(disableBuilder = true))
public interface AccountRestConvertMapper {
    AccountRestConvertMapper INSTANT = Mappers.getMapper(AccountRestConvertMapper.class);

    AccountSignBO from(AccountSignInRO args);

}

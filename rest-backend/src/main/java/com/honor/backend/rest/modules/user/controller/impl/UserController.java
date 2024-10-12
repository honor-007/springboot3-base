package com.honor.backend.rest.modules.user.controller.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.honor.backend.core.modules.user.dao.criteria.UserCriteria;
import com.honor.backend.core.modules.user.service.UserService;
import com.honor.backend.core.modules.user.service.bo.UserBO;
import com.honor.backend.rest.modules.user.controller.ro.UserCreateRO;
import com.honor.backend.rest.modules.user.support.UserConstants;
import com.honor.backend.rest.modules.user.support.UserRestConvertMapper;
import com.honor.backend.rest.modules.user.controller.query.UserQuery;
import com.honor.backend.rest.modules.user.controller.ro.UserUpdateRO;
import com.honor.backend.rest.modules.user.controller.vo.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author honor
 */
@Tag(name = "用户")
@Validated
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = UserConstants.USER_URI + "users")
public class UserController {
    //    private final ActorContext actorContext;
    private final UserService userService;

    @Operation(summary = "分页查询")
    @GetMapping(value = "page")
    public IPage<UserBO> queryWithPage(UserQuery query) {
        UserCriteria criteria = UserRestConvertMapper.INSTANT.from(query);
        return userService.page(criteria);
    }

    @Operation(summary = "保存")
    @PostMapping
    public void save(@RequestBody @Validated UserCreateRO ro) {
        UserBO userBO = UserRestConvertMapper.INSTANT.from(ro);
        userService.save(userBO);
    }

    @Operation(summary = "根据ID更新")
    @PutMapping
    public void update(@RequestBody @Validated UserUpdateRO ro) {
        UserBO userBO = UserRestConvertMapper.INSTANT.from(ro);
        userService.updateById(userBO);
    }

    @Operation(summary = "根据ID获取详细信息")
    @GetMapping(value = "{id}")
    public UserVO getById(@PathVariable("id") String id) {
        UserBO userBO = userService.getById(id);
        if (Objects.isNull(userBO)) {
            return null;
        }
        return UserRestConvertMapper.INSTANT.from(userBO);
    }
//
//    @Operation(summary = "批量删除")
//    @DeleteMapping(value = "{ids}")
//    public void delete(@PathVariable("ids") List<String> ids) {
//        userService.removeById(ids);
//    }
//
//    @Operation(summary = "修改用户可用状态")
//    @PostMapping(value = "{id}/enable/{status}")
//    public void changeEnableStatus(@PathVariable("id") String id, @PathVariable("status") Integer status) {
//        boolean enable = BooleanUtils.toBoolean(status);
//        userService.changeUserEnableStatus(id, enable);
//    }
//
    @Operation(summary = "重置用户密码")
    @PostMapping(value = "{id}/password")
    public void resetPassword(@PathVariable("id") String id) {
        userService.resetPassword(id);
    }

//    @Operation(summary = "获取当前用户信息")
//    @GetMapping(value = "actor")
//    public UserVO queryActor() {
//        UserBO actor = userService.getActor(actorContext.getActorId());
//        return UserRestConvertMapper.INSTANT.from(actor);
//    }
}

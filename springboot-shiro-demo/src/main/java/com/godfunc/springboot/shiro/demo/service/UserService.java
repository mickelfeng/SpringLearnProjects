package com.godfunc.springboot.shiro.demo.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godfunc.springboot.shiro.demo.dao.UserDao;
import com.godfunc.springboot.shiro.demo.entity.RoleEntity;
import com.godfunc.springboot.shiro.demo.entity.UserEntity;
import com.godfunc.springboot.shiro.demo.entity.UserRoleEntity;
import com.godfunc.springboot.shiro.demo.user.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserService extends ServiceImpl<UserDao, UserEntity> {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;

    public UserDetail getUserDetail(Long userId) {
        UserEntity user = getById(userId);
        UserDetail userDetail = new UserDetail();
        userDetail.setId(user.getId());
        userDetail.setUserName(user.getName());
        userDetail.setPassword(user.getPassword());
        List<UserRoleEntity> userRoleList = userRoleService.list(Wrappers.<UserRoleEntity>lambdaQuery().eq(UserRoleEntity::getUserId, user.getId()));
        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        if (userRoleList.size() > 0) {
            Collection<RoleEntity> roleList = roleService.listByIds(userRoleList.stream().map(UserRoleEntity::getRoleId).collect(Collectors.toList()));
            roleList.forEach(r -> {
                roles.add(r.getName());
                permissions.addAll(Arrays.asList(r.getPermission().split(";")));
            });
        }
        userDetail.setPermissions(permissions);
        userDetail.setRoles(roles);
        return userDetail;
    }
}

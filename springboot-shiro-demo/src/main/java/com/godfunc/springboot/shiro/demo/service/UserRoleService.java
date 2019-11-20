package com.godfunc.springboot.shiro.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godfunc.springboot.shiro.demo.dao.RoleDao;
import com.godfunc.springboot.shiro.demo.dao.UserRoleDao;
import com.godfunc.springboot.shiro.demo.entity.RoleEntity;
import com.godfunc.springboot.shiro.demo.entity.UserRoleEntity;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService extends ServiceImpl<UserRoleDao, UserRoleEntity> {
}

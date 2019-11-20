package com.godfunc.springboot.shiro.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godfunc.springboot.shiro.demo.dao.RoleDao;
import com.godfunc.springboot.shiro.demo.entity.RoleEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends ServiceImpl<RoleDao, RoleEntity> {
}

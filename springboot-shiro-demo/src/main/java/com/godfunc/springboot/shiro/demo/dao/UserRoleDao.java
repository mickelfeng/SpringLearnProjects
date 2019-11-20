package com.godfunc.springboot.shiro.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.godfunc.springboot.shiro.demo.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleDao extends BaseMapper<UserRoleEntity> {
}

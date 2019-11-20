package com.godfunc.springboot.shiro.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.godfunc.springboot.shiro.demo.entity.UserEntity;
import com.godfunc.springboot.shiro.demo.entity.UserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTokenDao extends BaseMapper<UserTokenEntity> {
}

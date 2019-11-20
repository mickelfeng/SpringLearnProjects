package com.godfunc.springboot.shiro.demo.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godfunc.springboot.shiro.demo.dao.UserDao;
import com.godfunc.springboot.shiro.demo.dao.UserTokenDao;
import com.godfunc.springboot.shiro.demo.entity.UserEntity;
import com.godfunc.springboot.shiro.demo.entity.UserTokenEntity;
import com.godfunc.springboot.shiro.demo.user.UserDetail;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserTokenService extends ServiceImpl<UserTokenDao, UserTokenEntity> {
    public UserTokenEntity getByToken(String accessToken) {
        return getOne(Wrappers.<UserTokenEntity>lambdaQuery().eq(UserTokenEntity::getToken, accessToken));
    }
}

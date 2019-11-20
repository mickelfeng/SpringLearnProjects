package com.godfunc.springboot.shiro.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.godfunc.springboot.shiro.demo.entity.UserEntity;
import com.godfunc.springboot.shiro.demo.entity.UserTokenEntity;
import com.godfunc.springboot.shiro.demo.form.LoginForm;
import com.godfunc.springboot.shiro.demo.service.UserService;
import com.godfunc.springboot.shiro.demo.service.UserTokenService;
import com.godfunc.springboot.shiro.demo.util.JwtUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private UserTokenService userTokenService;


    @PostMapping("login")
    public R login(@RequestBody LoginForm form) {
        UserEntity user = userService.getOne(Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getName, form.getUserName()));
        if (user == null) {
            return R.failed("用户不存在");
        } else if (user.getPassword().equals(user.getPassword())) {
            UserTokenEntity userTokenEntity = new UserTokenEntity();
            userTokenEntity.setUserId(user.getId());
            userTokenEntity.setToken(jwtUtils.generateToken(user.getId().toString()));
            userTokenService.save(userTokenEntity);
            return R.ok(userTokenEntity.getToken());
        } else {
            return R.failed("请检查用户名或密码");
        }
    }

    @GetMapping("test")
    @RequiresPermissions("test")
    @RequiresRoles("root")
    public R test() {
        return R.ok("success");
    }

    @GetMapping("test2")
    @RequiresPermissions("test2")
    public R tes2t() {
        return R.ok("success");
    }

}

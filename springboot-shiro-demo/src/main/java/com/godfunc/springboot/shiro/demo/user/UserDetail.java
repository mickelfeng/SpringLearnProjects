package com.godfunc.springboot.shiro.demo.user;

import lombok.Data;

import java.util.Set;

@Data
public class UserDetail {

    private Long id;

    private String userName;

    private String password;

    private Set<String> roles;

    private Set<String> permissions;

}

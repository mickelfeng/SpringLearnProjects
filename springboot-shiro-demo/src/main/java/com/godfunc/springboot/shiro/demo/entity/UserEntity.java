package com.godfunc.springboot.shiro.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_user")
@Data
public class UserEntity {

    @TableId
    private Long id;

    private String name;

    private String password;


}

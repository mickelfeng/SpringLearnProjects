package com.godfunc.springboot.shiro.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_user_token")
@Data
public class UserTokenEntity {

    @TableId
    private Long id;

    private Long userId;

    private String token;
}

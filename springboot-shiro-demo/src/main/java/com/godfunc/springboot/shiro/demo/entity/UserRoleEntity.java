package com.godfunc.springboot.shiro.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_user_role")
@Data
public class UserRoleEntity {

    @TableId
    private Long id;

    private Long userId;

    private Long roleId;
}

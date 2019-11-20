package com.godfunc.springboot.shiro.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_role")
@Data
public class RoleEntity {

    @TableId
    private Long id;

    // 存放权限，每个权限用 ; 分割。test1;test2
    private String permission;

    private String name;
}

package com.hxs.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
//@TableName("tbl_user")
public class User {
    private Long id;
    private String name;
    @TableField(select = false)
    private String password;
    private Integer age;
    private String tel;
    @TableField(exist = false)
    private Integer online;
//    @TableLogic(value = "0", delval = "1")
    private Integer deleted;
    @Version
    private Integer version;
}

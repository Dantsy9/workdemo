package com.ffcs.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
@TableName("mptest")
public class Work {
    private Long id;
    private String username;
    private String password;
    private String realName;
    private Integer gender;

    @TableLogic
    private Integer state;

    @Version
    private Integer version;
}

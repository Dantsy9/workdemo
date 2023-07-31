package com.ffcs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
@TableName("human")
public class Human {
    private String local;
    private String birthday;
    private String username;

    @Version
    private Integer version;
}

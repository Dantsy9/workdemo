package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 日志表
 * </p>
 *
 * @author Zhuang
 * @since 2023-08-10
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 执行时间
     */
    private LocalDateTime operationTime;

    /**
     * 操作方法
     */
    private String method;

    /**
     * 操作对象
     */
    private String object;

    /**
     * 执行结果
     */
    private String consequence;

    /**
     * 创建人的用户id
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除标志（0 代表未删除，1 代表已删除）
     */
    private Integer delFlag;


}

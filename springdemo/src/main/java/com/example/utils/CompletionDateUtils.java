package com.example.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  时间补全工具类
 * </p>
 *
 * @author zmc
 * @since 2023-08-23
 */

public class CompletionDateUtils {
    public CompletionDateUtils() {
    }

    /**
     * 数据库查询出来的统计数据有时候日期是不连续的.
     * 但是前端展示要补全缺失的日期.
     * 此方法返回一个给定日期期间的所有日期字符串列表.
     * @date: 2023/8/23
     * @param: 开始时间startDate, 结束时间endDate
     * @return:
     **/
    public static List<String> completionDate(LocalDateTime startDate,LocalDateTime endDate) {
        //日期格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<String> dateList = new ArrayList<>();
        //遍历给定的日期期间的每一天
        for (int i = 0; !Duration.between(startDate.plusDays(i), endDate).isNegative(); i++) {
            //添加日期
            dateList.add(startDate.plusDays(i).format(formatter));
        }
        return dateList;
    }

}

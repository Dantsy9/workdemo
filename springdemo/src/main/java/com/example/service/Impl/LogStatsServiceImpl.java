package com.example.service.Impl;

import com.example.domain.AddlogDTO;
import com.example.mapper.AddlogMapper;
import com.example.service.LogStatsService;
import com.example.utils.CompletionDateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;


/**
 * <p>
 *  图表统计 业务层
 * </p>
 *
 * @author zmc
 * @since 2023-08-21
 */

@Service
@Slf4j
public class LogStatsServiceImpl implements LogStatsService {

    @Resource
    private AddlogMapper addlogMapper;

    @Override
    public List<AddlogDTO> operatorStats() {
        AddlogDTO addlogDTO = new AddlogDTO();
        //设置统计集合
        List<AddlogDTO> logStats = new ArrayList<>();
        //获得方法名字符串集合
        List<String> methodName = addlogMapper.selectMethod();
        addlogDTO.setMethodNameList(methodName);
        //自动补全日期
        List<String> dateHandles = dateHandle();
        addlogDTO.setDateList(dateHandles);
        //遍历获得全部方法在对应日期的调用次数总集合
        List<Object> methodFrequency = new ArrayList<>();
        for (String s : methodName) {
            List<AddlogDTO> methodAndOperationTimeByMethod = addlogMapper.getCountMethodAndOperationTimeByMethod(s);
            methodFrequency.add(methodFrequencyHandle(dateHandles,methodAndOperationTimeByMethod));
        }
        addlogDTO.setMethodFrequency(methodFrequency);
        logStats.add(addlogDTO);
        return logStats;
    }

    /**
     * 日期加工处理
     * @date: 2023/8/22
     * @param: 方法调用次数和日期的集合
     * @return: 补全后的时间集合
     **/
    private List<String> dateHandle() {
        //获得整体的日期集合
        List<LocalDateTime> timeData = addlogMapper.getAllOperationTime();

        //获得起始日期
        LocalDateTime begin = timeData.get(0);

        //获得最后日期
        LocalDateTime lastDate = timeData.get(timeData.size() - 1);

        //获得补全的日期集合
        List<String> dateList = CompletionDateUtils.completionDate(begin, lastDate);

        return dateList;
    }

    /**
     *
     * @date: 2023/8/24
     * @param: 补全的时间集合，所有的方法调用次数和对应的日期集合
     * @return: 补全所有日期的方法调用次数集合，即次数为0的日期补全
     **/
    private List<Integer> methodFrequencyHandle(List<String> dateHandles, List<AddlogDTO> methodAndOperationTimeByMethod){
        //判断数据是否存在标志
        boolean dbDateExist = false;

        //暂存methodAndOperationTimeByMethod的List<map>
        List<Map<String, Object>> table = new ArrayList<>();

        //遍历存入
        for (AddlogDTO addlogDTO : methodAndOperationTimeByMethod) {
            Map<String, Object> map = new HashMap<>();
            map.put("operationTime", addlogDTO.getOperationTime());
            map.put("countMethodByTime", addlogDTO.getCountMethodByTime());
            table.add(map);
        }

        List<Map<String, Object>> result = new ArrayList<>();

        //遍历日期
        for (String date : dateHandles) {
            //对table集合中日期进行遍历
            for (Map<String, Object> row : table) {
                String operationTimeStr = String.valueOf(row.get("operationTime"));
                if (operationTimeStr.equals(date)) {
                    //集合已包含该日期
                    dbDateExist = true;
                    result.add(row);
                    break;
                }
            }
            //添加补全的日期到最后结果集合，并补全次数
            if (!dbDateExist) {
                Map<String, Object> temp = new HashMap<>(2);
                temp.put("countMethodByTime", 0);
                temp.put("operationTime", date);
                result.add(temp);
            }
            //状态修改为不存在
            dbDateExist = false;
        }
        //最后的结果处理
        ArrayList<Integer> oneMethodName = new ArrayList<>();
        //遍历结果集合，取出日期对应次数并放入数组
        for (Map<String, Object> objectMap : result){
            int countMethodByTime = Integer.parseInt((objectMap.get("countMethodByTime")).toString());
            oneMethodName.add(countMethodByTime);
        }
        return oneMethodName;
    }
}


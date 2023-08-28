package com.example.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author zmc
 * @since 2023-08-21
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddlogDTO{

    /**
     * 执行时间
     */
    private LocalDate operationTime;

    /**
     * 操作方法
     */
    private String method;

    /**
     * 每天的方法使用次数
     */

    private String countMethodByTime;

    /**
     * 每天的方法使用次数和时间的集合
     */
    private List<Map<String, Object>>methodChildList;

    /**
     * 方法名集合DATA1
     */
    private List<String> methodNameList;

    /**
     * 时间集合DATA2，X轴
     */
    private List<String> dateList;

    /**
     * 方法调用的频率DATA2，Y轴
     */
    private List<Object> methodFrequency;

    public LocalDate getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDate operationTime) {
        this.operationTime = operationTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCountMethodByTime() {
        return countMethodByTime;
    }

    public void setCountMethodByTime(String countMethodByTime) {
        this.countMethodByTime = countMethodByTime;
    }

    public List<Map<String, Object>> getMethodChildList() {
        return methodChildList;
    }

    public void setMethodChildList(List<Map<String, Object>> methodChildList) {
        this.methodChildList = methodChildList;
    }

    public List<String> getMethodNameList() {
        return methodNameList;
    }

    public void setMethodNameList(List<String> methodNameList) {
        this.methodNameList = methodNameList;
    }

    public List<String> getDateList() {
        return dateList;
    }

    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }

    public List<Object> getMethodFrequency() {
        return methodFrequency;
    }

    public void setMethodFrequency(List<Object> methodFrequency) {
        this.methodFrequency = methodFrequency;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddlogDTO{");
        sb.append("operationTime=").append(operationTime);
        sb.append(", method='").append(method).append('\'');
        sb.append(", countMethodByTime='").append(countMethodByTime).append('\'');
        sb.append(", methodChildList=").append(methodChildList);
        sb.append(", methodNameList=").append(methodNameList);
        sb.append(", dateList=").append(dateList);
        sb.append(", methodFrequency=").append(methodFrequency);
        sb.append('}');
        return sb.toString();
    }
}

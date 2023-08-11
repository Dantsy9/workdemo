package com.example.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.Addlog;
import com.example.domain.UserMenu;
import com.example.mapper.AddlogMapper;
import com.example.service.IAddlogService;
import com.example.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 增加操作日志表 服务实现类
 * </p>
 *
 * @author Zhuang
 * @since 2023-08-11
 */
@Service
public class AddlogServiceImpl extends ServiceImpl<AddlogMapper, Addlog> implements IAddlogService {
    @Resource
    private HttpServletRequest request;

    @Resource
    private AddlogMapper addlogMapper;


    /**
     * 捕获日志上传至表AddLog
     * @date: 2023/8/11
     * @param: addPerms请求的list数组对象用户角色关联表，方法名，执行结果
     * @return:
     **/
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveAddLog(List<UserMenu> userMenu, String method, String consequence) {
        //解析token获取当前用户
        String token = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(token);
        String operator = (String) claims.get("username");

        String object = userMenu.toString();
        Addlog addlog = new Addlog();
        addlog.setOperator(operator);
        //获取当前时间
        addlog.setOperationTime(LocalDateTime.now());
        addlog.setMethod(method);
        addlog.setObject(object);
        addlog.setConsequence(consequence);

        addlogMapper.insert(addlog);
    }
}
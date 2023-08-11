package com.example.service.Impl;

import com.example.annn.Log;
import com.example.domain.UserMenu;
import com.example.mapper.MenuMapper;
import com.example.mapper.UserMenuMapper;
import com.example.service.IAddlogService;
import com.example.service.PermsService;
import com.example.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
public class PermsServiceImpl implements PermsService {

    @Resource
    private UserMenuMapper userMenuMapper;


    @Resource
    private IAddlogService iAddlogService;


    /**
     * 查询用户的权限typeId
     * @date: 2023/8/8
     * @param: []
     * @return: typeId
     **/


    /**
     * 查询所有用户菜单关联表
     * @date: 2023/8/8
     * @param:
     * @return: 用户菜单关联表
     **/
    @Override
    public List<UserMenu> getAllUserPerms() {
        return userMenuMapper.getAllUserPerms();
    }



    /**
     * 批量增加用户权限
     * @date: 2023/8/8
     * @param: List数组对象用户菜单关联表
     * @return: 空信息，成功信息
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)//开启事务
    public String addPerms(List<UserMenu> userMenus) {
        //先用传进来的数据和表的数据做对比，查看是否存在
        List<UserMenu> userMenus1 = getUserMenuByUserMenu(userMenus);
        String exception = "";
        try {
            //如果有查询到有相同的数据，则返回错误信息
            if (!userMenus1.isEmpty()) {
                return null;
            }
            //否则上传数据
            userMenuMapper.addUserPerms(userMenus);
//            int i = 1 / 0;

        } catch (Exception e) {
            //获取错误信息
            exception = "Failed, check the exception information :" + getExceptionMessage(e);
            e.printStackTrace();
            throw new RuntimeException();
        } finally {//执行log记录
            //获得当前执行的方法名
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            //如果没有捕获到异常，则方法执行成功
            if (Objects.equals(exception, "")){
                exception = methodName +  " , success";
            }
            //日志记录
            iAddlogService.saveAddLog(userMenus, methodName, exception);
        }
        return "添加成功！";
    }


    /**
     * 获取异常的具体信息转为String字符串
     * @date: 2023/8/11
     * @param: 异常类型
     * @return: 异常类型的String字符串
     **/
    public static String getExceptionMessage(Exception e) {
        return e.getMessage();
    }


        /**
         * 批量删除用户权限
         * @date: 2023/8/8
         * @param: List数组对象用户菜单关联表
         * @return: 空信息，成功信息
         **/
    @Override
    public String delPerms(List<UserMenu> userMenus) {
        //先用传进来的数据和表的数据做对比，查看是否存在
        List<UserMenu> userMenus1 = getUserMenuByUserMenu(userMenus);
        //如果没有查询到有需要删除的数据，则返回错误信息
        if (userMenus1.isEmpty()){
            return null;
        }
        userMenuMapper.delUserPerms(userMenus);
        return "删除成功！";
    }

    /**
     * 批量多条件查询
     * @date: 2023/8/8
     * @param: List数组对象用户菜单关联表
     * @return: 查询到的数组对象
     **/
    @Override
    @Transactional
    public List<UserMenu> getUserMenuByUserMenu(List<UserMenu> userMenus) {
        List<UserMenu> userMenus1 = userMenuMapper.getUserPermsByUserMenu(userMenus);
        return userMenus1;
    }


}

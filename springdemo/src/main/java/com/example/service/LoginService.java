package com.example.service;
import com.example.domain.User;


/**
 * <p>
 * 登录验证接口
 * </p>
 * @author zmc
 * @since 2023/8/7
 */
public interface LoginService {
    // 用文档注释 不用行注释，行注释使用时要写在代码上方
    /**
     * 验证用户名和密码，验证成功返回token
     * @date: 2023/8/9
     * @param: [user]
     * @return: token
     **/
    String login(User user);
    /**
     * 生成token
     * @date: 2023/8/9
     * @param: [user]
     * @return: token
     **/
    String jwt(User user);





}

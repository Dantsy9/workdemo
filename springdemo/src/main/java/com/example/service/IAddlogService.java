package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Addlog;
import com.example.domain.UserMenu;

import java.util.List;

/**
 * <p>
 * 增加操作日志表 服务类
 * </p>
 *
 * @author Zhuang
 * @since 2023-08-11
 */
public interface IAddlogService extends IService<Addlog> {
    /**
     * 获得用户操作信息
     * @date: 2023/8/11
     * @param: 用户菜单关联表
     * @return:
     **/
    void saveAddLog(List<UserMenu> userMenu, String method, String consequence);
}

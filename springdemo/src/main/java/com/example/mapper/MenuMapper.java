package com.example.mapper;

import com.example.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> selectAll();//展示全部菜单

    List<Menu> selectMenuByMenuId(Long[] menuId);//按照menuid展示
}

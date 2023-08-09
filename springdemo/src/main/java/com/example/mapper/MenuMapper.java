package com.example.mapper;

import com.example.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    //展示全部菜单
    List<Menu> selectAll();
    //按照menuId展示
    List<Menu> selectMenuByMenuId(Long[] menuId);

    List<Menu> selectMenuNameByMenuId(Long[] menuId);
}

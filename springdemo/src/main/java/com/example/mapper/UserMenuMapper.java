package com.example.mapper;

import com.example.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMenuMapper {

    //通过用户id查询对应展示的menuid，其中，如果用户为管理员则menuid=0，默认展示全部菜单id
    @Select("select menu_id from user_menu where user_id = #{user_id}")
    Long[] selectMenuIdByUserId(Long userId);
}

package com.example.mapper;



import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface UserMapper{
    //添加数据
    void add(User user);

    //更新数据
    void update(User user);

    //删除单个
    void delById(Long id);

    //批量删除
    void delByIds(@Param("ids")Long[] ids);

    //查询全部
    List<User> selectAll();

    //条件查询
    List<User> selectById(Long id);


    /**
     * 多条件查询
     * @param map
     * @return
     */
    List<User> selectByCondition(Map map);
    //List<User> selectByCondition(@Param("id")int id , @Param("tel")String tel , @Param("age")int age);


    //用户名密码匹配
    @Select("select * from user where username = #{username} and password = #{password}")
    User getByNameAndPassword(User user);

}

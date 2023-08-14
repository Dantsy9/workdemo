package com.example.mapper;



import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;



public interface UserMapper{
    //通过userid查询用户权限typeId
    @Select("select type from user where id = #{id}")
    Long getTypeIdById(Long id);

    //添加数据
    boolean add(User user);

    //更新数据
    int update(User user);

    //删除单个
    boolean delById(Long id);

    //批量删除
    // 没有特殊要求的情况下用集合作为出入参
    boolean delByIds(@Param("ids")List<Long> ids);

    //查询全部
    List<User> selectAll();

    //条件查询
    List<User> selectById(Long id);


    /**
     * 多条件查询
     * @param user
     * @return
     */
    // 避免用Map作为参数
    List<User> selectByCondition(User user);
//    List<User> selectByCondition(@Param("id")Long id , @Param("tel")String username , @Param("age")int age);


    //用户名密码匹配
    @Select("select * from user where username = #{username} and password = #{password}")
    User getByNameAndPassword(User user);

}

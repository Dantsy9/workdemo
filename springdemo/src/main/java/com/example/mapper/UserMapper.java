package com.example.mapper;



import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface UserMapper{
    //通过userid查询用户权限typeId
    @Select("select type from user where id = #{id}")
    Long getTypeIdById(Long id);

    //添加数据
    void add(User user);

    //更新数据
    void update(User user);

    //删除单个
    void delById(Long id);

    //批量删除
    //TODO 没有特殊要求的情况下用集合作为出入参
    void delByIds(@Param("ids")List<User> ids);

    //查询全部
    List<User> selectAll();

    //条件查询
    List<User> selectById(Long id);


    /**
     * 多条件查询
     * @param user
     * @return
     */
    //TODO 避免用Map作为参数
    List<User> selectByCondition(User user);
//    List<User> selectByCondition(@Param("id")Long id , @Param("tel")String username , @Param("age")int age);


    //用户名密码匹配
    @Select("select * from user where username = #{username} and password = #{password}")
    User getByNameAndPassword(User user);

}

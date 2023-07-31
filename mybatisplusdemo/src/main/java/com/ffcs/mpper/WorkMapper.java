package com.ffcs.mpper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ffcs.entity.MultiEntity;
import com.ffcs.entity.Work;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorkMapper extends BaseMapper<Work> {

    @Select("select w.id,w.username,w.password,w.real_name,w.gender,h.local,h.birthday " +
            "from mptest w,human h " +
            "where w.username = h.username " +
            "and w.username = #{username}"
    )
    List<MultiEntity> multiSelectAll(@Param("username") String username);

}

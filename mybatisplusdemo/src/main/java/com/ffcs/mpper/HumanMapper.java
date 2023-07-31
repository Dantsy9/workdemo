package com.ffcs.mpper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ffcs.entity.Human;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HumanMapper extends BaseMapper<Human> {
}

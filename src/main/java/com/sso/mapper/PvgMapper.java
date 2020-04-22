package com.sso.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sso.domain.Pvg;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PvgMapper extends BaseMapper<Pvg> {

    List<Pvg> selPvgByUserEid(@Param("userEid") Integer userEid);
}

package com.sso.service.impl;

import com.sso.domain.Pvg;
import com.sso.mapper.PvgMapper;
import com.sso.service.PvgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PvgServiceImpl implements PvgService {

    @Autowired
    private PvgMapper pvgMapper;

    @Override
    public List<Pvg> getPvgByUserEid(Integer userEid) {
        return pvgMapper.selPvgByUserEid(userEid);
    }
}

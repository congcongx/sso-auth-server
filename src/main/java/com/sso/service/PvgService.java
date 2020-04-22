package com.sso.service;

import com.sso.domain.Pvg;
import java.util.List;

public interface PvgService {

    List<Pvg> getPvgByUserEid(Integer userEid);
}

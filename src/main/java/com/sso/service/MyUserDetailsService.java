package com.sso.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sso.domain.MyUser;
import com.sso.domain.Pvg;
import com.sso.domain.User;
import com.sso.service.PvgService;
import com.sso.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private PvgService pvgService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName,username));
        if(user == null) {
            log.warn("用户{}不存在", username);
            throw new UsernameNotFoundException(username);
        }

        List<Pvg> pvgList = pvgService.getPvgByUserEid(user.getUserEid());
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(pvgList)) {
            for (Pvg pvg : pvgList) {
                authorityList.add(new SimpleGrantedAuthority(pvg.getPvgCode()));
            }
        }
        MyUser myUser = new MyUser(user.getUserName(), passwordEncoder.encode(user.getPassword()), authorityList);
        log.info("登录成功！用户: {}", JSON.toJSONString(myUser));
        return myUser;
    }
}

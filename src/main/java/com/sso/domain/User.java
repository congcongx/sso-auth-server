package com.sso.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {

    @TableId
    private Integer id;

    private Integer userEid;

    private String nickName;

    private String photo;

    private String userName;

    private String mobile;

    private String password;

    private Integer useable;

}

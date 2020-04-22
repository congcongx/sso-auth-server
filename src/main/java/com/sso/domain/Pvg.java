package com.sso.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Pvg {

    @TableId
    private Integer id;

    private String pvgCode;

    private String pvgName;

    private Integer isDisp;

    private Integer pvgLv;

    private String icon;

    private String url;

    private Integer prior;

    private String remark;

    private Integer pid;

    private Integer high;

    private Integer ver;

    private Integer creator;

    private Date crtTime;

    private Integer updator;

    private Date uptTime;

    private String pvgNode;

}

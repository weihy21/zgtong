package com.zgtong.web.account.dataobject;

import com.zgtong.web.account.domain.response.UserRoleVO;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Data
public class ManagerAccountDo {

    private Long    id;
    private String  userName;
    private String  password;
    private String  staffId;
    private String  staffName;
    private Integer status;
    private Integer type;
    private String  accessToken;
    private Date    accessTokenTimeout;
    private List<UserRoleVO> roleList;
    private Date    createTime;
    private Date    updateTime;

    private Integer departmentId;
    private String  departmentName;
    private Integer position;

    private Date passwordResetTime;


}

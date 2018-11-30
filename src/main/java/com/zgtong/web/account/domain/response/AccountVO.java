package com.zgtong.web.account.domain.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 */
@Data
public class AccountVO implements Serializable {


    private static final long serialVersionUID = -6370093743693750916L;
    /**
     * 用户id
     */
    private Long           id;
    /**
     * 用户名称
     */
    private String         userName;
    /**
     *
     */
    private String         password;
    /**
     * 员工编号
     */
    private String         staffId;
    /**
     * 员工姓名
     */
    private String         staffName;
    /**
     * 账户状态
     */
    private Integer        status;
    /**
     * 账户类型
     */
    private Integer        type;
    /**
     * 授权令牌
     */
    private String         accessToken;
    /**
     * 权限列表
     */
    private List<RightsVo> rightsList;
    /**
     * 角色列表
     */
    private List<UserRoleVO> roleList;

    /**
     * 部门ID
     */
    private Integer departmentId;

    /**
     * 部门名称
     */
    private String  departmentName;

    /**
     *  职位
     */
    private Integer position;



}

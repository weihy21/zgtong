package com.zgtong.web.domain.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by weihy on 2018/11/07.
 */
@Data
public class UserInfoRequest implements Serializable {

    private static final long serialVersionUID = -2113692209220334786L;
    private Long id;
    private Long userId;        /**用户ID**/
    private String userName;
    private String mobilePhone;
    private Date createTime;  /**创建时间**/
    private Date updatedTime; /**更新时间**/
}

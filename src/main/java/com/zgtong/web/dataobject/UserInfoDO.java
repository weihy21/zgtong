package com.zgtong.web.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by weihy on 2018/11/07.
 */
@Data
public class UserInfoDO implements Serializable {

    private static final long serialVersionUID = 6511139081410229887L;
    private Long id;
    private Long userId;        /**用户ID**/
    private String userName;
    private String mobilePhone;
    private Date createdTime;  /**创建时间**/
    private Date updatedTime; /**更新时间**/
}

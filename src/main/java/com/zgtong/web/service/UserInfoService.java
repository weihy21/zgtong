package com.zgtong.web.service;

import com.zgtong.web.common.domain.PageObject;
import com.zgtong.web.common.domain.ServiceResponse;
import com.zgtong.web.domain.request.UserInfoRequest;
import com.zgtong.web.domain.request.UserInfoSearchRequest;
import com.zgtong.web.domain.response.UserInfoVO;


/**
 * Created by weihy on 2018/11/07.
 *
 */
public interface UserInfoService {
    /**
     * 查询用户信息
     * @param
     * @return 用户信息
     */
    ServiceResponse<UserInfoVO> queryUserInfo(UserInfoRequest request);

    /**
     * 新建账户
     * @param
     * @return
     */
    ServiceResponse<Void> addUser(UserInfoRequest request);


    /**
     * 分页查询
     * @param
     * @return
     */
    ServiceResponse<PageObject<UserInfoVO>> pageQueryUser(UserInfoSearchRequest request);


}

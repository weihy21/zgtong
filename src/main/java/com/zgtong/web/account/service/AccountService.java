package com.zgtong.web.account.service;


import com.zgtong.web.account.domain.request.*;
import com.zgtong.web.account.domain.response.AccountVO;
import com.zgtong.web.common.domain.PageObject;
import com.zgtong.web.common.domain.ServiceResponse;
import com.zgtong.web.common.logger.annotation.AutoLogger;

/**
 * @author weihy
 * @create 2018-11-16
 */
public interface AccountService {


    /**
     * 添加账户请求
     * <br/>
     * <p>
     * <p>url:/manager/account/add
     *
     * @param addUserReq
     * @return
     */
    @AutoLogger
    ServiceResponse<Void> add(AddUserReq addUserReq);


    /**
     * <p>url:/manager/account/modify
     *
     * @param modifyUserInfoReq
     * @return
     */
    @AutoLogger
    ServiceResponse<Void> modify(ModifyUserInfoReq modifyUserInfoReq);

    /**
     * <p>url:/manager/account/remove
     *
     * @param removeUserReq
     * @return
     */
    @AutoLogger
    ServiceResponse<Void> remove(RemoveUserReq removeUserReq);

    /**
     * <p>url:/manager/account/login
     * <p>
     * <br/>
     * 密码登录请求
     *
     * @param loginReq
     * @return
     */
    @AutoLogger
    ServiceResponse<AccountVO> login(LoginReq loginReq);


    /**
     * url:/manager/account/query
     * <p>
     * <br/></>查询用户详细信息
     *
     * @param queryUserInfoReq
     * @return
     */
    @AutoLogger
    ServiceResponse<AccountVO> query(QueryUserInfoReq queryUserInfoReq);

    /**
     * <p>url:/manager/account/list
     * <p>
     * <br/></>查询用户列表
     *
     * @param queryUserListReq
     * @return
     */
    ServiceResponse<PageObject<AccountVO>> list(QueryUserListReq queryUserListReq);


}

package com.zgtong.web.controller;

import com.zgtong.web.common.domain.ServiceResponse;
import com.zgtong.web.common.error.CommonError;
import com.zgtong.web.domain.request.UserInfoRequest;
import com.zgtong.web.domain.request.UserInfoSearchRequest;
import com.zgtong.web.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author weihy
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {


    private static final Logger logger = LoggerFactory.getLogger("running");

    @Resource
    private UserInfoService userInfoService;

    /**
     * 新增用户
     * url: /user/add
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResponse<Void> add(@RequestBody UserInfoRequest request) {
        if (request.getUserId() == null) {
            return new ServiceResponse<>(CommonError.INVALID_PARAMTER);
        }

        return userInfoService.addUser(request);
    }



    /**
     * 查询用户
     * url: /user/queryById
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResponse queryById(@RequestBody UserInfoRequest request) {
        if (request.getUserId() == null) {
            return new ServiceResponse<>(CommonError.INVALID_PARAMTER);
        }
        return userInfoService.queryUserInfo(request);
    }


    /**
     * 分页查询用户列表
     * url: /user/list
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResponse queryList(@RequestBody UserInfoSearchRequest request) {
        if (null == request.getPageNumber() || request.getPageNumber() == 0)
        {
            request.setPageNumber(1);
        }
        if (null == request.getPageSize() || request.getPageSize() == 0)
        {
            request.setPageSize(10);
        }
        return userInfoService.pageQueryUser(request);
    }








}

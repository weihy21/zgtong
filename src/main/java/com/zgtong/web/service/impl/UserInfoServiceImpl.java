package com.zgtong.web.service.impl;

import com.zgtong.web.common.domain.PageObject;
import com.zgtong.web.common.domain.ServiceResponse;
import com.zgtong.web.common.error.CommonError;
import com.zgtong.web.dataobject.UserInfoDO;
import com.zgtong.web.domain.request.UserInfoRequest;
import com.zgtong.web.domain.request.UserInfoSearchRequest;
import com.zgtong.web.manager.UserInfoManager;
import com.zgtong.web.service.UserInfoService;
import com.zgtong.web.domain.response.UserInfoVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weihy
 * @date 2018/11/07
 */
public class UserInfoServiceImpl implements UserInfoService {



    private static final Logger logger = LoggerFactory.getLogger("running");


    @Resource
    private UserInfoManager userInfoManager;
    /**
     * 查询
     *
     * @param request r
     * @return pageObject
     */
    @Override
    public ServiceResponse<UserInfoVO> queryUserInfo(UserInfoRequest request){
        if(StringUtils.isEmpty(request.getUserId())){
            return new ServiceResponse<>(CommonError.INVALID_PARAMTER);
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        try {
            UserInfoDO userInfoDO = userInfoManager.queryById(request.getUserId());
            if(null != userInfoDO){
                BeanUtils.copyProperties(userInfoDO,userInfoVO);
            }
        }catch(Exception e){
            logger.error("UserInfoServiceImpl queryUserInfo error", e);
        }
        return new ServiceResponse<>(CommonError.SUCCESS, userInfoVO);

    }



    @Override
    public ServiceResponse<Void> addUser(UserInfoRequest request){
        if(StringUtils.isEmpty(request.getUserId())){
            return new ServiceResponse<>(CommonError.INVALID_PARAMTER);
        }
        try {
            userInfoManager.save(request);
        }catch(Exception e){
            logger.error("UserInfoServiceImpl addUser error", e);
        }

        return new ServiceResponse<>(CommonError.SUCCESS);
    }

    @Override
    public ServiceResponse<PageObject<UserInfoVO>> pageQueryUser(UserInfoSearchRequest request){

        PageObject<UserInfoVO> result = new PageObject<>();
        result.setPageSize(request.getPageSize());
        result.setCurrentPage(request.getPageNumber());
        try {
            int count = userInfoManager.queryUserCount(request);
            result.setTotalNumber(count);
            if (count > 0) {
                List<UserInfoDO> list = userInfoManager.pageQueryUser(request);
                if (!CollectionUtils.isEmpty(list)) {
                    List<UserInfoVO> responseList = new ArrayList<>();
                    for (UserInfoDO model : list) {
                        responseList.add(convertToModel(model));
                    }
                    result.setData(responseList);
                }
            }
        }catch(Exception e){
            logger.error("pageQuerySettlementOrder error", e);
            return new ServiceResponse<>(CommonError.UNKNOW_ERROR);
        }
        return new ServiceResponse<>(CommonError.SUCCESS, result);


    }


    public  UserInfoVO convertToModel(UserInfoDO model){
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(model,userInfoVO);
        return userInfoVO;
    }


}

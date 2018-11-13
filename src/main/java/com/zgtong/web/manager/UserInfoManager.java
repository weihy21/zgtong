package com.zgtong.web.manager;

import com.zgtong.web.dao.UserInfoDAO;
import com.zgtong.web.dataobject.UserInfoDO;
import com.zgtong.web.domain.request.UserInfoRequest;
import com.zgtong.web.domain.request.UserInfoSearchRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author weihy
 * @date 2018/11/07
 */
@Component
public class UserInfoManager {


    @Resource
    private UserInfoDAO userInfoDAO;


    public void save(UserInfoRequest req) {

        UserInfoDO userInfoDO = new UserInfoDO();
        BeanUtils.copyProperties(req,userInfoDO);

        UserInfoDO udo = userInfoDAO.queryById(req.getUserId());

        if(null == udo){
            userInfoDAO.save(userInfoDO);
        }else{
            userInfoDAO.update(userInfoDO);
        }

    }

    public UserInfoDO queryById(Long userId){

        return userInfoDAO.queryById(userId);

    }


    public Integer queryUserCount(UserInfoSearchRequest request){
        return userInfoDAO.queryUserCount(request);
    }

    public List<UserInfoDO> pageQueryUser(UserInfoSearchRequest request){

        return userInfoDAO.pageQueryUser(request);

    }





}

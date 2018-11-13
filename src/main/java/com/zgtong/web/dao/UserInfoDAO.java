package com.zgtong.web.dao;

import com.zgtong.web.dataobject.UserInfoDO;
import com.zgtong.web.domain.request.UserInfoSearchRequest;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by weihy on 18/11/07.
 */
@Component
public class UserInfoDAO {

    @Resource
    private SqlSessionTemplate zgtongSqlSessionTemplate;


    public int save(UserInfoDO userInfoDO){
        return zgtongSqlSessionTemplate.insert("addUserInfo", userInfoDO);
    }

    public int update(UserInfoDO userInfoDO){
        return zgtongSqlSessionTemplate.update("updateUserInfo", userInfoDO);
    }

    public UserInfoDO queryById(Long userId){
        Map<String, Object> param = new HashMap<>();
        param.put("userId",userId);
        return zgtongSqlSessionTemplate.selectOne("getByUserId",param);
    }


    public Integer queryUserCount(UserInfoSearchRequest request){
        Map<String, Object> param = new HashMap<>();
        /**
         * 封装参数
         */
        return zgtongSqlSessionTemplate.selectOne("queryUserCount",param);
    }

    public List<UserInfoDO> pageQueryUser(UserInfoSearchRequest request){
        Map<String, Object> param = new HashMap<>();
        /**
         * 封装参数
         */
        param.put("offset", request.offset());
        param.put("pageSize", request.getPageSize());
        return zgtongSqlSessionTemplate.selectList("pageQueryUser",param);

    }


}

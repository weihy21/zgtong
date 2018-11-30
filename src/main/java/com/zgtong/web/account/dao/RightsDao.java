package com.zgtong.web.account.dao;

import com.zgtong.web.account.dataobject.RightsDo;
import com.zgtong.web.account.domain.request.QueryRightsReq;
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
public class RightsDao {

    @Resource
    private SqlSessionTemplate zgtongSqlSessionTemplate;



    public List<RightsDo> selectRightById(List<Long> rightsIdList){

        return zgtongSqlSessionTemplate.selectList("selectRightById",rightsIdList);
    }


    public List<RightsDo> selectRightAll(){
        return zgtongSqlSessionTemplate.selectList("selectRightAll");
    }


    public List<RightsDo> selectByRight(QueryRightsReq req){

        return  zgtongSqlSessionTemplate.selectList("selectByRight",req);
    }


    public List<RightsDo> selectByUserId(Long userId,Integer type){
        Map<String, Object> param = new HashMap<>();
        param.put("userId",userId);
        return zgtongSqlSessionTemplate.selectList("selectByUserId",param);
    }

}

package com.zgtong.web.account.dao;

import com.zgtong.web.account.dataobject.AccountRightsDo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Component
public class AccountRightsDao {

    @Resource
    private SqlSessionTemplate zgtongSqlSessionTemplate;

    public int insert(List<AccountRightsDo> accountRightsDoList){
        return  zgtongSqlSessionTemplate.insert("insertAccountRights",accountRightsDoList);
    }

    public List<AccountRightsDo> selectAccountRightsByUserId(Long userId){
        return  zgtongSqlSessionTemplate.selectList("selectAccountRightsByUserId",userId);
    }

    public int deleteAccountRightsByUserId(Long userId){
        return  zgtongSqlSessionTemplate.delete("deleteAccountRightsByUserId",userId);
    }

}

package com.zgtong.web.account.dao;

import com.zgtong.web.account.domain.response.UserRoleVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Component
public class UserRoleDao {

    @Resource
    private SqlSessionTemplate zgtongSqlSessionTemplate;


    /**
     * 用户关联角色
     * @param model
     * @return
     */
    public Integer createUserRole(List<UserRoleVO> model){
        return zgtongSqlSessionTemplate.insert("createUserRole",model);
    }

    /**
     * 删除用户关联角色
     * @param model
     * @return
     */
    public Integer deleteUserRole(UserRoleVO model){
        return zgtongSqlSessionTemplate.delete("deleteUserRole",model);

    }


    /**
     * 查询用户关联角色
     * @param model
     * @return
     */
    public  List<UserRoleVO> findUserRole(UserRoleVO model){
        return zgtongSqlSessionTemplate.selectList("findUserRole",model);

    }

    /**
     * 查询用户已经关联角色
     * @return
     */
    public  List<UserRoleVO> findAccentRole(){
        return zgtongSqlSessionTemplate.selectList("findAccentRole");

    }

}

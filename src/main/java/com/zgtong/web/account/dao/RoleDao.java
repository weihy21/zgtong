package com.zgtong.web.account.dao;

import com.zgtong.web.account.domain.response.RoleVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Component
public class RoleDao {

    @Resource
    private SqlSessionTemplate zgtongSqlSessionTemplate;


    /**
     * 查询 角色
     * @param role
     * @return
     */
    public List<RoleVO> findRole(RoleVO role){
        return zgtongSqlSessionTemplate.selectList("findRole",role);
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    public Integer  updateRole(RoleVO role){
        return zgtongSqlSessionTemplate.update("updateRole",role);
    }

    /**
     * 删除角色
     * @param role
     * @return
     */
    public Integer  deleteRoleByCondition(RoleVO role){
        return zgtongSqlSessionTemplate.delete("deleteRoleByCondition",role);
    }


    /**
     * 创建角色
     * @param role
     * @return
     */
    public Integer  createRole(RoleVO role){
        return zgtongSqlSessionTemplate.insert("createRole",role);
    }
}

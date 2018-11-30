package com.zgtong.web.account.dao;

import com.zgtong.web.account.domain.response.RoleRightVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Component
public class RoleRightDao {

    @Resource
    private SqlSessionTemplate zgtongSqlSessionTemplate;


    /**
     * 查询ROLE 权限组
     * @param model
     * @return
     */
    public List<RoleRightVO> findRoleRight(RoleRightVO model){
        return zgtongSqlSessionTemplate.selectList("findRoleRight",model);

    }

    /**
     * 创建角色权限组
     * @param list
     * @return
     */
    public Integer createRoleRight(List<RoleRightVO> list){
        return zgtongSqlSessionTemplate.insert("createRoleRight",list);

    }

    /**
     * 删除角色权限组
     * @param list
     * @return
     */
    public Integer deleteRoleRight(RoleRightVO list){
        return zgtongSqlSessionTemplate.delete("deleteRoleRight",list);

    }
}

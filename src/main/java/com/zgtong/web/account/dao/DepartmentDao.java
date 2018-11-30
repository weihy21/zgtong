package com.zgtong.web.account.dao;

import com.zgtong.web.account.dataobject.DepartmentDo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 */
@Component
public class DepartmentDao {

    @Resource
    private SqlSessionTemplate zgtongSqlSessionTemplate;


    /**
     * 添加公司
     * @return
     */
    public long addDepartment(DepartmentDo departmentDo){
        return zgtongSqlSessionTemplate.insert("addDepartment",departmentDo);
    }

    /**
     * 修改公司
     * @param departmentDo
     * @return
     */
    public long updateDepartment(DepartmentDo departmentDo){
        return zgtongSqlSessionTemplate.update("updateDepartment",departmentDo);
    }

    /**
     * 删除公司
     * @param departmentDo
     * @return
     */
    public long deleteDepartment(DepartmentDo departmentDo){
        return zgtongSqlSessionTemplate.update("deleteDepartment",departmentDo);
    }

    /**
     * 公司集合
     * @return
     */
    public List<DepartmentDo> departmentList(DepartmentDo departmentDo){
        return zgtongSqlSessionTemplate.selectList("departmentList",departmentDo);
    }

    /**
     * 公司详细信息
     * @return
     */
    public DepartmentDo departmentDetail(DepartmentDo departmentDo){
        return zgtongSqlSessionTemplate.selectOne("departmentDetail",departmentDo);
    }

}

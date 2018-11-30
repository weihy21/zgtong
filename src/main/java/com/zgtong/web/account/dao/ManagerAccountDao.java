package com.zgtong.web.account.dao;

import com.zgtong.web.account.dataobject.ManagerAccountDo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Component
public class ManagerAccountDao {

    @Resource
    private SqlSessionTemplate zgtongSqlSessionTemplate;

    /**
     * 添加账户记录
     *
     * @param accountDo
     * @return
     */
    public long insert(ManagerAccountDo accountDo){
        return zgtongSqlSessionTemplate.insert("insertAccount", accountDo);
    }

    public int update(ManagerAccountDo accountDo){
        return zgtongSqlSessionTemplate.update("updateAccount", accountDo);
    }

    public ManagerAccountDo selectByUserName(String userName,Boolean status){
        Map<String, Object> param = new HashMap<>();
        param.put("userName",userName);
        param.put("status",status);
        return zgtongSqlSessionTemplate.selectOne("selectByUserName",param);
    }

    public ManagerAccountDo selectById(Long id,Boolean status){
        Map<String, Object> param = new HashMap<>();
        param.put("id",id);
        param.put("status",status);
        return zgtongSqlSessionTemplate.selectOne("selectAccountById",param);
    }

    public int deleteById(Long id,Integer isDelete,Long currentUserId){
        Map<String, Object> param = new HashMap<>();
        param.put("userId",id);
        param.put("isDelete",isDelete);
        param.put("currentUserId",currentUserId);
        return zgtongSqlSessionTemplate.update("deleteById",param);
    }


    /**
     * 查找用户信息
     *
     * @return
     */
    public  List<ManagerAccountDo> select(String phone, String username,Integer departmentId,int offset,int pageSize){
        Map<String, Object> param = new HashMap<>();
        param.put("phone",phone);
        param.put("userName",username);
        param.put("departmentId",departmentId);
        param.put("offset",offset);
        param.put("pageSize",pageSize);
        return zgtongSqlSessionTemplate.selectList("selectAccountList",param);
    }

    public int count(String phone,String username,Integer departmentId){
        Map<String, Object> param = new HashMap<>();
        param.put("phone",phone);
        param.put("userName",username);
        param.put("departmentId",departmentId);
        return zgtongSqlSessionTemplate.selectOne("selectAccountcount",param);
    }





}

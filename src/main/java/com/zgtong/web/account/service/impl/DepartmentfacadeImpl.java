package com.zgtong.web.account.service.impl;

import com.zgtong.web.account.dao.DepartmentDao;
import com.zgtong.web.account.dao.ManagerAccountDao;
import com.zgtong.web.account.dataobject.DepartmentDo;
import com.zgtong.web.account.dataobject.ManagerAccountDo;
import com.zgtong.web.account.domain.request.AddDepartmentReq;
import com.zgtong.web.account.domain.request.DeleteDepartmentReq;
import com.zgtong.web.account.domain.request.GetDepartmentReq;
import com.zgtong.web.account.domain.response.DepartmentRespons;
import com.zgtong.web.account.entity.AccountType;
import com.zgtong.web.account.entity.DepartmentStatus;
import com.zgtong.web.account.service.DepartmentFacade;
import com.zgtong.web.common.domain.ServiceResponse;
import com.zgtong.web.common.error.CommonError;
import com.zgtong.web.utils.ConvertUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service("departmentService")
public class DepartmentfacadeImpl implements DepartmentFacade {

    @Resource
    private DepartmentDao departmentDao;

    @Resource
    private ManagerAccountDao managerAccountDao;

    @Override
    public ServiceResponse<Long> addOrModifyDepartment(AddDepartmentReq addDepartmentReq) {

        DepartmentDo departmentDo = ConvertUtils.convertAddDepartment(addDepartmentReq);
        Long id = null;
        if(departmentDo.getId()==null){
            id =  departmentDao.addDepartment(departmentDo);
        }else {
            id =  departmentDao.updateDepartment(departmentDo);
        }
        return new ServiceResponse<>(CommonError.SUCCESS,id);
    }

    @Override
    public ServiceResponse<List<DepartmentRespons>> departmentList(GetDepartmentReq getDepartmentReq) {
        if(getDepartmentReq.getCurrentUserId()==null){
            return  new ServiceResponse<>(CommonError.INVALID_PARAMTER);
        }
        ManagerAccountDo accountDo = managerAccountDao.selectById(getDepartmentReq.getCurrentUserId(),null);
        DepartmentDo departmentDo = ConvertUtils.convertGetDepartment(getDepartmentReq);
        if(accountDo.getType()!=null && accountDo.getType().intValue()!= AccountType.ADMIN.code.intValue()){
            departmentDo.setId(accountDo.getDepartmentId());
        }
        List<DepartmentDo> list =  departmentDao.departmentList(departmentDo);
        return new ServiceResponse<>(CommonError.SUCCESS,ConvertUtils.convertToDepartmentResponseList(list));
    }

    @Override
    public ServiceResponse<Boolean> deleteDepartment(DeleteDepartmentReq deleteDepartmentReq) {

        DepartmentDo departmentDo = new DepartmentDo();
        departmentDo.setId(deleteDepartmentReq.getDepartmentId());
        departmentDo.setStatus(DepartmentStatus.OFF_LINE.getCode());
        Boolean result = false;
        Long row = departmentDao.deleteDepartment(departmentDo);
        if(row != null && row>0){
            result=true;
        }
        return new ServiceResponse<>(CommonError.SUCCESS,result);
    }

    @Override
    public ServiceResponse<DepartmentRespons> detailDepartment(GetDepartmentReq getDepartmentReq) {
        DepartmentDo departmentDo = new DepartmentDo();
        departmentDo.setId(getDepartmentReq.getDepartmentId());
        DepartmentDo department = departmentDao.departmentDetail(departmentDo);
        return new ServiceResponse<DepartmentRespons>(CommonError.SUCCESS, ConvertUtils.convertDepartmentResponse(department));
    }

}

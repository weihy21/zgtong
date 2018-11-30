package com.zgtong.web.account.service;



import com.zgtong.web.account.domain.request.AddDepartmentReq;
import com.zgtong.web.account.domain.request.DeleteDepartmentReq;
import com.zgtong.web.account.domain.request.GetDepartmentReq;
import com.zgtong.web.account.domain.response.DepartmentRespons;
import com.zgtong.web.common.domain.ServiceResponse;

import java.util.List;

/**
 *
 */
public interface DepartmentFacade {

    /**
     * 添加/修改公司
     * @param addDepartmentReq
     * @return
     */
    ServiceResponse<Long> addOrModifyDepartment(AddDepartmentReq addDepartmentReq);

    /**
     * 获取公司列表
     * @param getDepartmentReq
     * @return
     */
    ServiceResponse<List<DepartmentRespons>> departmentList(GetDepartmentReq getDepartmentReq);

    /**
     * 删除公司
     * @param deleteDepartmentReq
     * @return
     */
    ServiceResponse<Boolean> deleteDepartment(DeleteDepartmentReq deleteDepartmentReq);

    /**
     * 公司详情
     * @param getDepartmentReq
     * @return
     */
    ServiceResponse<DepartmentRespons> detailDepartment(GetDepartmentReq getDepartmentReq);
}

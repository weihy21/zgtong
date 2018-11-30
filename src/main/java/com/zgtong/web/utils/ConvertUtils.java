package com.zgtong.web.utils;


import com.zgtong.web.account.dataobject.DepartmentDo;
import com.zgtong.web.account.domain.request.AddDepartmentReq;
import com.zgtong.web.account.domain.request.GetDepartmentReq;
import com.zgtong.web.account.domain.response.DepartmentRespons;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ConvertUtils {


    public  static DepartmentDo convertAddDepartment(AddDepartmentReq addDepartmentReq){
        DepartmentDo departmentDo = new DepartmentDo();
        departmentDo.setId(addDepartmentReq.getDepartId());
        departmentDo.setName(addDepartmentReq.getDepartmentName());
        departmentDo.setDescription(addDepartmentReq.getDescription());
        return  departmentDo;
    }

    public  static DepartmentDo convertGetDepartment(GetDepartmentReq getDepartmentReq){
        DepartmentDo departmentDo = new DepartmentDo();
        departmentDo.setId(getDepartmentReq.getDepartmentId());
        departmentDo.setName(getDepartmentReq.getDepartmentName());
        return  departmentDo;
    }

    public static DepartmentRespons convertDepartmentResponse(DepartmentDo departmentDo){
        DepartmentRespons departmentRespons = new DepartmentRespons();
        departmentRespons.setDepartId(departmentDo.getId());
        departmentRespons.setDepartmentName(departmentDo.getName());
        departmentRespons.setDescription(departmentDo.getDescription());
        if(departmentDo.getCreateTime()!=null){
        departmentRespons.setCreateDate(DateUtil.dateToString(departmentDo.getCreateTime(),DateUtil.YYYYMMDDHHMMSS));
        }
        return  departmentRespons;
    }

    public static List<DepartmentRespons> convertToDepartmentResponseList( List<DepartmentDo> departmentDos){
        List<DepartmentRespons>   departmentRespons = new ArrayList<>();
        if(departmentDos != null && departmentDos.size()>0){
             for (DepartmentDo respons:departmentDos){
                departmentRespons.add(convertDepartmentResponse(respons));
            }
        }
        return  departmentRespons;
    }
}

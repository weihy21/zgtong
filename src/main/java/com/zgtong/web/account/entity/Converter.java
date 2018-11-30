package com.zgtong.web.account.entity;

import com.google.common.collect.Lists;
import com.zgtong.web.account.dataobject.ManagerAccountDo;
import com.zgtong.web.account.dataobject.RightsDo;
import com.zgtong.web.account.domain.response.AccountVO;
import com.zgtong.web.account.domain.response.RightsVo;
import com.zgtong.web.utils.EncryptUtil;
import com.zgtong.web.utils.ValidationUtil;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 各种对象之间的转换器
 *
 */
public class Converter {


    public static ManagerAccountDo accountVo2Do(AccountVO accountVo) {
        ManagerAccountDo managerAccountDo = new ManagerAccountDo();
        BeanUtils.copyProperties(accountVo, managerAccountDo);
        managerAccountDo.setPassword(EncryptUtil.encrypt(accountVo.getPassword()));
        return managerAccountDo;

    }

    public static AccountVO assembleAccountVo(ManagerAccountDo managerAccountDo, List<RightsDo> rightsDoList,Boolean needPassword) {
        AccountVO accountVo = new AccountVO();
        BeanUtils.copyProperties(managerAccountDo, accountVo);
        if(needPassword==null || needPassword==false){
        accountVo.setPassword(null);
        }
        if (!ValidationUtil.isNullOrEmpty(rightsDoList)) {
            List<RightsVo> rightsVos = Lists.newArrayList();
            for (RightsDo rightsDo : rightsDoList) {
                RightsVo rightsVo = new RightsVo();
                BeanUtils.copyProperties(rightsDo, rightsVo);
                rightsVos.add(rightsVo);
            }
            accountVo.setRightsList(rightsVos);
        }
        return accountVo;
    }

    public static List<AccountVO> AccountDo2Vo(List<ManagerAccountDo> managerAccountDos) {
        List<AccountVO> accountVos = Lists.newArrayList();
        for (ManagerAccountDo managerAccountDo : managerAccountDos) {
            accountVos.add(assembleAccountVo(managerAccountDo, null,false));
        }
        return accountVos;
    }


    public static List<RightsVo> rightsDos2Vos(List<RightsDo> rightsDos) {
        List<RightsVo> rightsVos = Lists.newArrayList();
        for (RightsDo rightsDo : rightsDos) {
            RightsVo rightsVo = new RightsVo();
            BeanUtils.copyProperties(rightsDo, rightsVo);
            rightsVos.add(rightsVo);
        }
        return rightsVos;
    }


}

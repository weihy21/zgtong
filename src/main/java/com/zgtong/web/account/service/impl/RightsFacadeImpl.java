package com.zgtong.web.account.service.impl;


import com.zgtong.web.account.dao.RightsDao;
import com.zgtong.web.account.dataobject.RightsDo;
import com.zgtong.web.account.domain.request.QueryRightsReq;
import com.zgtong.web.account.domain.response.Response;
import com.zgtong.web.account.domain.response.RightsVo;
import com.zgtong.web.account.entity.Converter;
import com.zgtong.web.account.service.RightsFacade;
import com.zgtong.web.common.domain.ServiceResponse;
import com.zgtong.web.common.logger.annotation.AutoLogger;
import com.zgtong.web.utils.ValidationUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ford
 * @create 2016-10-30 17:32
 */
@Service("rightsFacade")
public class RightsFacadeImpl implements RightsFacade {

    @Resource
    private RightsDao rightsDao;

    @AutoLogger
    @Override
    public ServiceResponse<List<RightsVo>> query(QueryRightsReq queryRightsReq) {
        List<RightsDo> rightsDos = rightsDao.selectRightAll();
        if (!ValidationUtil.isNullOrEmpty(rightsDos)) {
            List<RightsVo> rightsVos = Converter.rightsDos2Vos(rightsDos);
            return Response.build(Response.Entry.SUCCESS, rightsVos);
        }
        return Response.SUCCESS;
    }
}

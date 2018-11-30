package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class QueryRightsReq extends ServiceRequest {

    private static final long serialVersionUID = 7802322969475522358L;
    /**
     * URI
     */
    private String pathPrefix ;

    /**
     * 权限类型 1 菜单 2 页面 3 功能 4 文件
     */
    private Integer type;

    /**
     * 父ID
     */
    private Integer parentId;

    public QueryRightsReq() {
        super();
    }
    public QueryRightsReq(ServiceRequest base) {
        super(base);
    }

}

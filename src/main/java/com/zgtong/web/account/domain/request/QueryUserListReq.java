package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class QueryUserListReq extends ServiceRequest {


    public QueryUserListReq() {
        super();
    }

    public QueryUserListReq(ServiceRequest base) {
        super(base);
    }

    private Long currentUserId;

    private String userName;

    private String phone;

    private Integer pageSize ;

    private Integer pageNum;


    public int offset() {
        int offset = 0;
        if (pageNum != null && pageSize != null) {
            int temp = (pageNum - 1) * pageSize;
            if (temp > offset) {
                return temp;
            }
        }
        return offset;
    }

}

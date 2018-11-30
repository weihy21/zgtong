package com.zgtong.web.domain.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by weihy on 2018/11/07.
 */
@Data
public class UserInfoSearchRequest implements Serializable {

    private static final long serialVersionUID = 7010426337514675033L;
    private Integer pageSize = 10;
    private Integer pageNumber = 1;

    public int offset() {
        int offset = 0;
        if (pageNumber != null && pageSize != null) {
            int temp = (pageNumber - 1) * pageSize;
            if (temp > offset) {
                return temp;
            }
        }
        return offset;
    }
}

package com.zgtong.web.common.domain;


import java.io.Serializable;
import java.util.Collection;

/**
 * request基类
 */

public class PageObject<T> implements Serializable {


    private Integer totalPage;
    Integer currentPage = 1;
    Integer pageSize;
    Integer totalNumber;
    Collection<T> data;

    int offset() {
        int offset = 0;
        if (currentPage != null && pageSize != null) {
            int temp = (currentPage - 1) * pageSize;
            if (temp > offset) {
                return temp;
            }
        }
        return offset;
    }


    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage() {
        if (this.pageSize != null && this.totalNumber != null && this.pageSize > 0) {
            int p = this.totalNumber / this.pageSize;
            int q = this.totalNumber % this.pageSize;
            if (q > 0) {
                this.totalPage = p + 1;
            } else {
                this.totalPage = p;
            }

        }
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
        this.setTotalPage();
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }
}

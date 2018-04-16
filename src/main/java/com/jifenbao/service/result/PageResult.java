package com.jifenbao.service.result;

public class PageResult<T> extends ListResult<T> {

    /**
     * 
     */
    private static final long serialVersionUID = -3937934082228989908L;

    /**
     * 页码
     */
    private int pageNo;

    /**
     * 每页显示记录数
     */
    private int pageSize;

    /**
     * 总的记录数
     */
    private long totalCount;

    /**
     * 总页数
     */
    private int totalPageCount;

    public PageResult() {
        super();
    }

    public PageResult(boolean success, String errorCode, String errorMsg) {
        super(success, errorCode, errorMsg);
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

}

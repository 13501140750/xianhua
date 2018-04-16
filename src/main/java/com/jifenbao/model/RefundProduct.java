/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      RefundProduct
 * @Description
 * RefundProduct
 *
 * @author      liujing
 * @Date        2016-06-17 13:29:27
 * @version     1.0 
 *
 */
public class RefundProduct extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 原订单号       db_column: orderCode 
     */
    private String orderCode;
    /**
     * 退款单号       db_column: refundCode 
     */
    private String refundCode;
    /**
     * 更换前产品编号       db_column: oldProductCode 
     */
    private String oldProductCode;
    /**
     * 更换后的产品       db_column: productCode 
     */
    private String productCode;
    /**
     * 更换的产品数量       db_column: productCount 
     */
    private Integer productCount;
    /**
     * 退款类型       db_column: refundType 
     */
    private String refundType;
    /**
     * deleteYn       db_column: deleteYn 
     */
    private String deleteYn;
    /**
     * disabledYn       db_column: disabledYn 
     */
    private String disabledYn;
    /**
     * createUser       db_column: createUser 
     */
    private String createUser;
    /**
     * createTime       db_column: createTime 
     */
    private Date createTime;
    /**
     * updateUser       db_column: updateUser 
     */
    private String updateUser;
    /**
     * updateTime       db_column: updateTime 
     */
    private Date updateTime;
    //columns END


    public RefundProduct() {
    }

    public RefundProduct(
        Long id
    ) {
        this.id = id;
    }

    

    public RefundProduct(
        Long id,
        String orderCode,
        String refundCode,
        String oldProductCode,
        String productCode,
        Integer productCount,
        String refundType,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.orderCode = orderCode;
        this.refundCode = refundCode;
        this.oldProductCode = oldProductCode;
        this.productCode = productCode;
        this.productCount = productCount;
        this.refundType = refundType;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }


    public void setId(Long value) {
        this.id = value;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setIdEx(Long value) {
        this.idEx = value;
    }
    
    public Long getIdEx() {
        return this.idEx;
    }
    
    public String getOrderCode() {
        return this.orderCode;
    }
    
    public void setOrderCode(String value) {
        this.orderCode = value;
    }
    
    public String getRefundCode() {
        return this.refundCode;
    }
    
    public void setRefundCode(String value) {
        this.refundCode = value;
    }
    
    public String getOldProductCode() {
        return this.oldProductCode;
    }
    
    public void setOldProductCode(String value) {
        this.oldProductCode = value;
    }
    
    public String getProductCode() {
        return this.productCode;
    }
    
    public void setProductCode(String value) {
        this.productCode = value;
    }
    
    public Integer getProductCount() {
        return this.productCount;
    }
    
    public void setProductCount(Integer value) {
        this.productCount = value;
    }
    
    public String getRefundType() {
        return this.refundType;
    }
    
    public void setRefundType(String value) {
        this.refundType = value;
    }
    
    public String getDeleteYn() {
        return this.deleteYn;
    }
    
    public void setDeleteYn(String value) {
        this.deleteYn = value;
    }
    
    public String getDisabledYn() {
        return this.disabledYn;
    }
    
    public void setDisabledYn(String value) {
        this.disabledYn = value;
    }
    
    public String getCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(String value) {
        this.createUser = value;
    }
    
    public String getCreateTimeString() {
        return DateTimeUtil.format(getCreateTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setCreateTimeString(String value) {
        setCreateTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date value) {
        this.createTime = value;
    }
    
    public String getUpdateUser() {
        return this.updateUser;
    }
    
    public void setUpdateUser(String value) {
        this.updateUser = value;
    }
    
    public String getUpdateTimeString() {
        return DateTimeUtil.format(getUpdateTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setUpdateTimeString(String value) {
        setUpdateTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Date value) {
        this.updateTime = value;
    }
    
    
}


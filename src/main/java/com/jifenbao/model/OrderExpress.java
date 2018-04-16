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
 * @ClassName      OrderExpress
 * @Description
 * OrderExpress
 *
 * @author      liujing
 * @Date        2016-02-25 17:35:15
 * @version     1.0 
 *
 */
public class OrderExpress extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 订单号       db_column: orderCode 
     */
    private String orderCode;
    /**
     * 订单发货还是补发货情况       db_column: orderType 
     */
    private String orderType;
    /**
     * 快递公司编码       db_column: freightCode 
     */
    private String freightCode;
    /**
     * 快递单号       db_column: expressNumber 
     */
    private String expressNumber;
    /**
     * 实际运费       db_column: expressPrice 
     */
    private Double expressPrice;
    /**
     * 打印次数       db_column: printNum 
     */
    private Integer printNum;
    /**
     * 打印原因       db_column: printReason 
     */
    private String printReason;
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
    /**
     * string1       db_column: string1 
     */
    private String string1;
    /**
     * string2       db_column: string2 
     */
    private String string2;
    /**
     * string3       db_column: string3 
     */
    private String string3;
    /**
     * string4       db_column: string4 
     */
    private String string4;
    /**
     * string5       db_column: string5 
     */
    private String string5;
    /**
     * string6       db_column: string6 
     */
    private String string6;
    /**
     * string7       db_column: string7 
     */
    private String string7;
    /**
     * string8       db_column: string8 
     */
    private String string8;
    /**
     * string9       db_column: string9 
     */
    private String string9;
    /**
     * string10       db_column: string10 
     */
    private String string10;
    //columns END


    public OrderExpress() {
    }

    public OrderExpress(
        Long id
    ) {
        this.id = id;
    }

    

    public OrderExpress(
        Long id,
        String orderCode,
        String orderType,
        String freightCode,
        String expressNumber,
        Double expressPrice,
        Integer printNum,
        String printReason,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime,
        String string1,
        String string2,
        String string3,
        String string4,
        String string5,
        String string6,
        String string7,
        String string8,
        String string9,
        String string10
    ) {
        this.id = id;
        this.orderCode = orderCode;
        this.orderType = orderType;
        this.freightCode = freightCode;
        this.expressNumber = expressNumber;
        this.expressPrice = expressPrice;
        this.printNum = printNum;
        this.printReason = printReason;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.string1 = string1;
        this.string2 = string2;
        this.string3 = string3;
        this.string4 = string4;
        this.string5 = string5;
        this.string6 = string6;
        this.string7 = string7;
        this.string8 = string8;
        this.string9 = string9;
        this.string10 = string10;
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
    
    public String getOrderType() {
        return this.orderType;
    }
    
    public void setOrderType(String value) {
        this.orderType = value;
    }
    
    public String getFreightCode() {
        return this.freightCode;
    }
    
    public void setFreightCode(String value) {
        this.freightCode = value;
    }
    
    public String getExpressNumber() {
        return this.expressNumber;
    }
    
    public void setExpressNumber(String value) {
        this.expressNumber = value;
    }
    
    public Double getExpressPrice() {
        return this.expressPrice;
    }
    
    public void setExpressPrice(Double value) {
        this.expressPrice = value;
    }
    
    public Integer getPrintNum() {
        return this.printNum;
    }
    
    public void setPrintNum(Integer value) {
        this.printNum = value;
    }
    
    public String getPrintReason() {
        return this.printReason;
    }
    
    public void setPrintReason(String value) {
        this.printReason = value;
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
    
    public String getString1() {
        return this.string1;
    }
    
    public void setString1(String value) {
        this.string1 = value;
    }
    
    public String getString2() {
        return this.string2;
    }
    
    public void setString2(String value) {
        this.string2 = value;
    }
    
    public String getString3() {
        return this.string3;
    }
    
    public void setString3(String value) {
        this.string3 = value;
    }
    
    public String getString4() {
        return this.string4;
    }
    
    public void setString4(String value) {
        this.string4 = value;
    }
    
    public String getString5() {
        return this.string5;
    }
    
    public void setString5(String value) {
        this.string5 = value;
    }
    
    public String getString6() {
        return this.string6;
    }
    
    public void setString6(String value) {
        this.string6 = value;
    }
    
    public String getString7() {
        return this.string7;
    }
    
    public void setString7(String value) {
        this.string7 = value;
    }
    
    public String getString8() {
        return this.string8;
    }
    
    public void setString8(String value) {
        this.string8 = value;
    }
    
    public String getString9() {
        return this.string9;
    }
    
    public void setString9(String value) {
        this.string9 = value;
    }
    
    public String getString10() {
        return this.string10;
    }
    
    public void setString10(String value) {
        this.string10 = value;
    }
    
    
}


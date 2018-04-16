/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      OrderLog
 * @Description
 * OrderLog
 *
 * @author      liujing
 * @Date        2016-02-26 10:06:54
 * @version     1.0 
 *
 */
public class OrderLog extends BaseEntity<Long> {
    
    
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
     * 操纵人       db_column: exectPerson 
     */
    private String exectPerson;
    /**
     * 操作时间       db_column: exectTime 
     */
    private Date exectTime;
    /**
     * 物流状态       db_column: logStatusName 
     */
    private String logStatusName;
    /**
     * 满意度       db_column: satisfaction 
     */
    private Integer satisfaction;
    /**
     * 快递单号       db_column: expressNumber 
     */
    private String expressNumber;
    /**
     * 快递公司       db_column: expressCompany 
     */
    private String expressCompany;
    /**
     * 日志描述       db_column: logcomment 
     */
    private String logcomment;
    /**
     * logInfo       db_column: logInfo 
     */
    private String logInfo;
    /**
     * 配送方式       db_column: expressType 
     */
    private String expressType;
    /**
     * orderType       db_column: orderType 
     */
    private String orderType;
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


    public OrderLog() {
    }

    public OrderLog(
        Long id
    ) {
        this.id = id;
    }

    

    public OrderLog(
        Long id,
        String orderCode,
        String exectPerson,
        Date exectTime,
        String logStatusName,
        Integer satisfaction,
        String expressNumber,
        String expressCompany,
        String logcomment,
        String logInfo,
        String expressType,
        String orderType,
        String string2,
        String string3,
        String string4,
        String string5,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.orderCode = orderCode;
        this.exectPerson = exectPerson;
        this.exectTime = exectTime;
        this.logStatusName = logStatusName;
        this.satisfaction = satisfaction;
        this.expressNumber = expressNumber;
        this.expressCompany = expressCompany;
        this.logcomment = logcomment;
        this.logInfo = logInfo;
        this.expressType = expressType;
        this.orderType = orderType;
        this.string2 = string2;
        this.string3 = string3;
        this.string4 = string4;
        this.string5 = string5;
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
    
    public String getExectPerson() {
        return this.exectPerson;
    }
    
    public void setExectPerson(String value) {
        this.exectPerson = value;
    }
    
    public String getExectTimeString() {
        return DateTimeUtil.format(getExectTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setExectTimeString(String value) {
        setExectTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getExectTime() {
        return this.exectTime;
    }
    
    public void setExectTime(Date value) {
        this.exectTime = value;
    }
    
    public String getLogStatusName() {
        return this.logStatusName;
    }
    
    public void setLogStatusName(String value) {
        this.logStatusName = value;
    }
    
    public Integer getSatisfaction() {
        return this.satisfaction;
    }
    
    public void setSatisfaction(Integer value) {
        this.satisfaction = value;
    }
    
    public String getExpressNumber() {
        return this.expressNumber;
    }
    
    public void setExpressNumber(String value) {
        this.expressNumber = value;
    }
    
    public String getExpressCompany() {
        return this.expressCompany;
    }
    
    public void setExpressCompany(String value) {
        this.expressCompany = value;
    }
    
    public String getLogcomment() {
        return this.logcomment;
    }
    
    public void setLogcomment(String value) {
        this.logcomment = value;
    }
    
    public String getLogInfo() {
        return this.logInfo;
    }
    
    public void setLogInfo(String value) {
        this.logInfo = value;
    }
    
    public String getExpressType() {
        return this.expressType;
    }
    
    public void setExpressType(String value) {
        this.expressType = value;
    }
    
   
    
    public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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


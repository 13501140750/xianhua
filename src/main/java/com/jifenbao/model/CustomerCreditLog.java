/**
 * Copyright 2008 - 2018 Powered by OpenTide <br/>
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
 * @ClassName      CustomerCreditLog
 * @Description
 * CustomerCreditLog
 *
 * @author      wangyawei
 * @Date        2018-02-08 17:47:03
 * @version     1.0 
 *
 */
public class CustomerCreditLog extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * 主键       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 积分来源       db_column: source 
     */
    private String source;
    /**
     * sourceId       db_column: sourceId 
     */
    private Long sourceId;
    /**
     * 来源类型       db_column: sourceType 
     */
    private String sourceType;
    /**
     * 用户信息       db_column: customerId 
     */
    private Long customerId;
    /**
     * 操作类型       db_column: actionType 
     */
    private String actionType;
    /**
     * companyCode       db_column: companyCode 
     */
    private String companyCode;
    /**
     * cardNum       db_column: cardNum 
     */
    private String cardNum;
    /**
     * 积分数量       db_column: creditAmount 
     */
    private Double creditAmount;
    /**
     * blanceAmout       db_column: blanceAmout 
     */
    private Double blanceAmout;
    /**
     * 删除标识       db_column: deleteYn 
     */
    private String deleteYn;
    /**
     * 是否启用       db_column: disabledYn 
     */
    private String disabledYn;
    /**
     * 创建用户       db_column: createUser 
     */
    private String createUser;
    /**
     * 创建时间       db_column: createTime 
     */
    private Date createTime;
    /**
     * 修改用户       db_column: updateUser 
     */
    private String updateUser;
    /**
     * 修改时间       db_column: updateTime 
     */
    private Date updateTime;
    //columns END


    public CustomerCreditLog() {
    }

    public CustomerCreditLog(
        Long id
    ) {
        this.id = id;
    }

    

    public CustomerCreditLog(
        Long id,
        String source,
        Long sourceId,
        String sourceType,
        Long customerId,
        String actionType,
        String companyCode,
        String cardNum,
        Double creditAmount,
        Double blanceAmout,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.source = source;
        this.sourceId = sourceId;
        this.sourceType = sourceType;
        this.customerId = customerId;
        this.actionType = actionType;
        this.companyCode = companyCode;
        this.cardNum = cardNum;
        this.creditAmount = creditAmount;
        this.blanceAmout = blanceAmout;
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
    
    public String getSource() {
        return this.source;
    }
    
    public void setSource(String value) {
        this.source = value;
    }
    
    public Long getSourceId() {
        return this.sourceId;
    }
    
    public void setSourceId(Long value) {
        this.sourceId = value;
    }
    
    public String getSourceType() {
        return this.sourceType;
    }
    
    public void setSourceType(String value) {
        this.sourceType = value;
    }
    
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Long value) {
        this.customerId = value;
    }
    
    public String getActionType() {
        return this.actionType;
    }
    
    public void setActionType(String value) {
        this.actionType = value;
    }
    
    public String getCompanyCode() {
        return this.companyCode;
    }
    
    public void setCompanyCode(String value) {
        this.companyCode = value;
    }
    
    public String getCardNum() {
        return this.cardNum;
    }
    
    public void setCardNum(String value) {
        this.cardNum = value;
    }
    
    public Double getCreditAmount() {
        return this.creditAmount;
    }
    
    public void setCreditAmount(Double value) {
        this.creditAmount = value;
    }
    
    public Double getBlanceAmout() {
        return this.blanceAmout;
    }
    
    public void setBlanceAmout(Double value) {
        this.blanceAmout = value;
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


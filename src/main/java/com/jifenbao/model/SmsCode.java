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
 * @ClassName      SmsCode
 * @Description
 * SmsCode
 *
 * @author      liujing
 * @Date        2016-04-15 11:17:12
 * @version     1.0 
 *
 */
public class SmsCode extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 手机号       db_column: smsNum 
     */
    private String smsNum;
    /**
     * 短信验证码       db_column: smsCode 
     */
    private String smsCode;
    /**
     * 生成时间       db_column: ceateTime 
     */
    private Date ceateTime;
    //columns END


    public SmsCode() {
    }

    public SmsCode(
        Integer id
    ) {
        this.id = id;
    }

    

    public SmsCode(
        Integer id,
        String smsNum,
        String smsCode,
        Date ceateTime
    ) {
        this.id = id;
        this.smsNum = smsNum;
        this.smsCode = smsCode;
        this.ceateTime = ceateTime;
    }


    public void setId(Integer value) {
        this.id = value;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setIdEx(Integer value) {
        this.idEx = value;
    }
    
    public Integer getIdEx() {
        return this.idEx;
    }
    
    public String getSmsNum() {
        return this.smsNum;
    }
    
    public void setSmsNum(String value) {
        this.smsNum = value;
    }
    
    public String getSmsCode() {
        return this.smsCode;
    }
    
    public void setSmsCode(String value) {
        this.smsCode = value;
    }
    
    public String getCeateTimeString() {
        return DateTimeUtil.format(getCeateTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setCeateTimeString(String value) {
        setCeateTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getCeateTime() {
        return this.ceateTime;
    }
    
    public void setCeateTime(Date value) {
        this.ceateTime = value;
    }
    
    
}


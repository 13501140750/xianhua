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
 * @ClassName      LoggerInfo
 * @Description
 * LoggerInfo
 *
 * @author      liujing
 * @Date        2016-05-23 10:03:05
 * @version     1.0 
 *
 */
public class LoggerInfo extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 日志名称       db_column: logName 
     */
    private String logName;
    /**
     * 请求数据       db_column: logRequest 
     */
    private String logRequest;
    /**
     * 请求返回       db_column: logResponse 
     */
    private String logResponse;
    /**
     * 异常信息       db_column: logError 
     */
    private String logError;
    
    /**
     * 请求人 IP
     */
    private String createIp;
    /**
     * 请求人       db_column: createUser 
     */
    private String createUser;
    /**
     * 请求时间       db_column: createTime 
     */
    private Date createTime;
    //columns END


    public LoggerInfo() {
    }

    public LoggerInfo(
        Long id
    ) {
        this.id = id;
    }

    

    public LoggerInfo(
        Long id,
        String logName,
        String logRequest,
        String logResponse,
        String logError,
        String createUser,
        Date createTime
    ) {
        this.id = id;
        this.logName = logName;
        this.logRequest = logRequest;
        this.logResponse = logResponse;
        this.logError = logError;
        this.createUser = createUser;
        this.createTime = createTime;
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
    
    public String getLogName() {
        return this.logName;
    }
    
    public void setLogName(String value) {
        this.logName = value;
    }
    
    public String getLogRequest() {
        return this.logRequest;
    }
    
    public void setLogRequest(String value) {
        this.logRequest = value;
    }
    
    public String getLogResponse() {
        return this.logResponse;
    }
    
    public void setLogResponse(String value) {
        this.logResponse = value;
    }
    
    public String getLogError() {
        return this.logError;
    }
    
    public void setLogError(String value) {
        this.logError = value;
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

	public String getCreateIp() {
		return createIp;
	}

	public void setCreateIp(String createIp) {
		this.createIp = createIp;
	}
    
    
    
}


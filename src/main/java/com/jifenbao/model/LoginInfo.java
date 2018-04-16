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
 * @ClassName      LoginInfo
 * @Description
 * LoginInfo
 *
 * @author      liujing
 * @Date        2016-01-10 22:09:28
 * @version     1.0 
 *
 */
public class LoginInfo extends BaseEntity<String> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * 会员名       db_column: loginName 
     */
    private String loginName;
    /** id Exclude */
    private String loginNameEx;
    /**
     * 密码       db_column: password 
     */
    private String password;
    /**
     * 会员ID       db_column: customerId 
     */
    private Long customerId;
    /**
     * 公司       db_column: companyId 
     */
    private Long companyId;
    /**
     * 电子邮件       db_column: email 
     */
    private String email;
    /**
     * 手机       db_column: mobile 
     */
    private String mobile;
    /**
     * 最后登录时间       db_column: lastLoginTime 
     */
    private Date lastLoginTime;
    /**
     * 最后登录IP       db_column: lastLoginIp 
     */
    private String lastLoginIp;
    /**
     * 登录次数       db_column: loginCount 
     */
    private Integer loginCount;
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
    
    private String companyCode;
    /**
     * 验证码       db_column: validcode 
     */
    private String validcode;
    /**
     * 验证码失效时间       db_column: expiredTime 
     */
    private Date expiredTime;
    
    /**
     * 会员来源，默认是积分宝用户1，卡册兑换为2，电影注册用户为3       db_column: source 
     */
    private String source;
    //columns END


    public LoginInfo() {
    }

    public LoginInfo(
        String loginName
    ) {
        this.loginName = loginName;
    }

    

    public LoginInfo(
        String loginName,
        String password,
        Long customerId,
        Long companyId,
        String email,
        String mobile,
        Date lastLoginTime,
        String lastLoginIp,
        Integer loginCount,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime,
        String validcode,
        Date expiredTime
    ) {
        this.loginName = loginName;
        this.password = password;
        this.customerId = customerId;
        this.companyId = companyId;
        this.email = email;
        this.mobile = mobile;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
        this.loginCount = loginCount;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.validcode = validcode;
        this.expiredTime = expiredTime;
    }


    public void setLoginName(String value) {
        this.loginName = value;
    }
    
    public String getLoginName() {
        return this.loginName;
    }
    
    public void setLoginNameEx(String value) {
        this.loginNameEx = value;
    }
    
    public String getLoginNameEx() {
        return this.loginNameEx;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String value) {
        this.password = value;
    }
    
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Long value) {
        this.customerId = value;
    }
    
    public Long getCompanyId() {
        return this.companyId;
    }
    
    public void setCompanyId(Long value) {
        this.companyId = value;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String value) {
        this.email = value;
    }
    
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String value) {
        this.mobile = value;
    }
    
    public String getLastLoginTimeString() {
        return DateTimeUtil.format(getLastLoginTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setLastLoginTimeString(String value) {
        setLastLoginTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getLastLoginTime() {
        return this.lastLoginTime;
    }
    
    public void setLastLoginTime(Date value) {
        this.lastLoginTime = value;
    }
    
    public String getLastLoginIp() {
        return this.lastLoginIp;
    }
    
    public void setLastLoginIp(String value) {
        this.lastLoginIp = value;
    }
    
    public Integer getLoginCount() {
        return this.loginCount;
    }
    
    public void setLoginCount(Integer value) {
        this.loginCount = value;
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
    
    
    
    public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
    
    public String getValidcode() {
        return this.validcode;
    }
    
    public void setValidcode(String value) {
        this.validcode = value;
    }
    
    public String getExpiredTimeString() {
        return DateTimeUtil.format(getExpiredTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setExpiredTimeString(String value) {
        setExpiredTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getExpiredTime() {
        return this.expiredTime;
    }
    
    public void setExpiredTime(Date value) {
        this.expiredTime = value;
    }
    
    

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
    public String getId() {
        return this.loginName;
    }
}


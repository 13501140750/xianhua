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
 * @ClassName      User
 * @Description
 * User
 *
 * @author      liujing
 * @Date        2016-04-12 10:25:32
 * @version     1.0 
 *
 */
public class User extends BaseEntity<String> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * 登录名       db_column: name 
     */
    private String name;
    /** id Exclude */
    private String nameEx;
    /**
     * 密码       db_column: password 
     */
    private String password;
    /**
     * 性别       db_column: sex 
     */
    private Integer sex;
    /**
     * 真实姓名       db_column: realName 
     */
    private String realName;
    /**
     * 头像       db_column: picture 
     */
    private String picture;
    /**
     * 电子邮件       db_column: email 
     */
    private String email;
    /**
     * 手机       db_column: mobile 
     */
    private String mobile;
    /**
     * 电话       db_column: phone 
     */
    private String phone;
    /**
     * QQ       db_column: qq 
     */
    private String qq;
    /**
     * 职称       db_column: title 
     */
    private String title;
    /**
     * 最后登录时间       db_column: lastLoginTime 
     */
    private Date lastLoginTime;
    /**
     * 最后登录IP       db_column: lastLoginIp 
     */
    private String lastLoginIp;
    /**
     * loginCount       db_column: loginCount 
     */
    private Integer loginCount;
    /**
     * companyCode       db_column: companyCode 
     */
    private String companyCode;
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
    
    /**
     * 所属公司
     */
    private Company company;
    
    /**
     * 对应的角色
     */
    private List<Role> roles;


    public User() {
    }

    public User(
        String name
    ) {
        this.name = name;
    }

    

    public User(
        String name,
        String password,
        Integer sex,
        String realName,
        String picture,
        String email,
        String mobile,
        String phone,
        String qq,
        String title,
        Date lastLoginTime,
        String lastLoginIp,
        Integer loginCount,
        String companyCode,
        String string1,
        String string2,
        String string3,
        String string4,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.realName = realName;
        this.picture = picture;
        this.email = email;
        this.mobile = mobile;
        this.phone = phone;
        this.qq = qq;
        this.title = title;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
        this.loginCount = loginCount;
        this.companyCode = companyCode;
        this.string1 = string1;
        this.string2 = string2;
        this.string3 = string3;
        this.string4 = string4;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }


    public void setName(String value) {
        this.name = value;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setNameEx(String value) {
        this.nameEx = value;
    }
    
    public String getNameEx() {
        return this.nameEx;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String value) {
        this.password = value;
    }
    
    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer value) {
        this.sex = value;
    }
    
    public String getRealName() {
        return this.realName;
    }
    
    public void setRealName(String value) {
        this.realName = value;
    }
    
    public String getPicture() {
        return this.picture;
    }
    
    public void setPicture(String value) {
        this.picture = value;
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
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String value) {
        this.phone = value;
    }
    
    public String getQq() {
        return this.qq;
    }
    
    public void setQq(String value) {
        this.qq = value;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String value) {
        this.title = value;
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
    
    public String getCompanyCode() {
        return this.companyCode;
    }
    
    public void setCompanyCode(String value) {
        this.companyCode = value;
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
    
    
    
    public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
    public String getId() {
        return this.name;
    }
}


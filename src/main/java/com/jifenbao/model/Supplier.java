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
 * @ClassName      Supplier
 * @Description
 * Supplier
 *
 * @author      liujing
 * @Date        2016-04-13 10:13:48
 * @version     1.0 
 *
 */
public class Supplier extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * 主键       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 名称       db_column: name 
     */
    private String name;
    /**
     * 类型       db_column: type 
     */
    private Integer type;
    /**
     * 描述       db_column: description 
     */
    private String description;
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

    private String searchText;
    
    private Company company;//合作供应商

    public Supplier() {
    }

    public Supplier(
        Integer id
    ) {
        this.id = id;
    }

    

    public Supplier(
        Integer id,
        String name,
        Integer type,
        String description,
        String companyCode,
        String string1,
        String string2,
        String string3,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.companyCode = companyCode;
        this.string1 = string1;
        this.string2 = string2;
        this.string3 = string3;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
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
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String value) {
        this.name = value;
    }
    
    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer value) {
        this.type = value;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String value) {
        this.description = value;
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

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
    
    
}


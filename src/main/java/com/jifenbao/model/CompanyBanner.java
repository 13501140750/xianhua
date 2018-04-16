/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      Banner
 * @Description
 * Banner
 *
 * @author      liujing
 * @Date        2016-03-16 13:01:59
 * @version     1.0 
 *
 */
public class CompanyBanner extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 导航图片       db_column: image 
     */
    private String image;
    /**
     * 导航名称       db_column: bannername 
     */
    private String bannername;
    /**
     * 连接地址       db_column: link_url 
     */
    private String linkUrl;
    /**
     * 排序       db_column: sort 
     */
    private String sort;
    /**
     * 导航类型,1:礼品卡册兑换背景图，2，定制卡欢迎背景图 
     */
    private String type;
    /**
     * string1       db_column: string1 
     */
    private String companyCode;
    /**
     * 客户公司code     db_column: companyCode 
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
	public CompanyBanner() {
    }

    public CompanyBanner(
        Integer id
    ) {
        this.id = id;
    }

    public CompanyBanner(Integer id, String image, String bannername, String linkUrl, String sort, String type,
			String companyCode, String string1, String string2, String string3, String deleteYn, String disabledYn,
			String createUser, Date createTime, String updateUser, Date updateTime) {
		super();
		this.id = id;
		this.image = image;
		this.bannername = bannername;
		this.linkUrl = linkUrl;
		this.sort = sort;
		this.type = type;
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
    
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String value) {
        this.image = value;
    }
    
    public String getBannername() {
        return this.bannername;
    }
    
    public void setBannername(String value) {
        this.bannername = value;
    }
    
    public String getLinkUrl() {
        return this.linkUrl;
    }
    
    public void setLinkUrl(String value) {
        this.linkUrl = value;
    }
    
    public String getSort() {
        return StringUtils.isBlank(this.sort)?"0":this.sort;
    }
    
    public void setSort(String value) {
        this.sort = value;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String value) {
        this.type = value;
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

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	
    
   
}


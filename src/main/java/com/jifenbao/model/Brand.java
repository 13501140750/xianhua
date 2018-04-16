/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
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
 * @ClassName      Brand
 * @Description
 * Brand
 *
 * @author      liujing
 * @Date        2015-12-09 10:40:51
 * @version     1.0 
 *
 */
public class Brand extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * code       db_column: code 
     */
    private String code;
    /**
     * name       db_column: name 
     */
    private String name;
    /**
     * alias       db_column: alias 
     */
    private String alias;
    /**
     * engName       db_column: engName 
     */
    private String engName;
    /**
     * description       db_column: description 
     */
    private String description;
    /**
     * logo       db_column: logo 
     */
    private String logo;
    /**
     * 首页热门品牌       db_column: hotYn 
     */
    private String hotYn;
    /**
     * 是否在首页显示       db_column: showYn 
     */
    private String showYn;
    /**
     * 排序       db_column: sort 
     */
    private Integer sort;
    
    /**
     * 栏目品牌对应的栏目       db_column: navcatCode
     */
    private String navcatCode;
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
    String searchText;


    public Brand() {
    }

    public Brand(
        Long id
    ) {
        this.id = id;
    }

    

    public Brand(
            Long id,
            String code,
            String name,
            String alias,
            String engName,
            String description,
            String logo,
            String hotYn,
            String showYn,
            Integer sort,
            String deleteYn,
            String disabledYn,
            String createUser,
            Date createTime,
            String updateUser,
            Date updateTime
        ) {
            this.id = id;
            this.code = code;
            this.name = name;
            this.alias = alias;
            this.engName = engName;
            this.description = description;
            this.logo = logo;
            this.hotYn = hotYn;
            this.showYn = showYn;
            this.sort = sort;
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
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String value) {
        this.code = value;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String value) {
        this.name = value;
    }
    
    public String getAlias() {
        return this.alias;
    }
    
    public void setAlias(String value) {
        this.alias = value;
    }
    
    public String getEngName() {
        return this.engName;
    }
    
    public void setEngName(String value) {
        this.engName = value;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String value) {
        this.description = value;
    }
    
    public String getLogo() {
        return this.logo;
    }
    
    public void setLogo(String value) {
        this.logo = value;
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

	public String getSearchText() {
		return searchText;
	}

	public String getHotYn() {
		return hotYn;
	}

	public void setHotYn(String hotYn) {
		this.hotYn = hotYn;
	}

	public String getShowYn() {
		return showYn;
	}

	public void setShowYn(String showYn) {
		this.showYn = showYn;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getNavcatCode() {
		return navcatCode;
	}

	public void setNavcatCode(String navcatCode) {
		this.navcatCode = navcatCode;
	}

	
    
    
}


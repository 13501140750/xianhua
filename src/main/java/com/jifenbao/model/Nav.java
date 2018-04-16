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
 * @ClassName      Nav
 * @Description
 * Nav
 *
 * @author      wangyawei
 * @Date        2018-01-18 11:59:04
 * @version     1.0 
 *
 */
public class Nav extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * navName       db_column: navName 
     */
    private String navName;
    /**
     * icon       db_column: icon 
     */
    private String icon;
    /**
     * url       db_column: url 
     */
    private String url;
    /**
     * sort       db_column: sort 
     */
    private Integer sort;
    /**
     * type       db_column: type 
     */
    private String type;
    /**
     * deleteYn       db_column: deleteYn 
     */
    private String deleteYn;
    /**
     * disabledYn       db_column: disabledYn 
     */
    private String disabledYn;
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


    public Nav() {
    }

    public Nav(
        Integer id
    ) {
        this.id = id;
    }

    

    public Nav(
        Integer id,
        String navName,
        String icon,
        String url,
        Integer sort,
        String type,
        String deleteYn,
        String disabledYn,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.navName = navName;
        this.icon = icon;
        this.url = url;
        this.sort = sort;
        this.type = type;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
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
    
    public String getNavName() {
        return this.navName;
    }
    
    public void setNavName(String value) {
        this.navName = value;
    }
    
    public String getIcon() {
        return this.icon;
    }
    
    public void setIcon(String value) {
        this.icon = value;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String value) {
        this.url = value;
    }
    
    public Integer getSort() {
        return this.sort;
    }
    
    public void setSort(Integer value) {
        this.sort = value;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String value) {
        this.type = value;
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


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
 * @ClassName      Region
 * @Description
 * Region
 *
 * @author      wangyawei
 * @Date        2018-01-05 11:40:44
 * @version     1.0 
 *
 */
public class Region extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * code       db_column: code 
     */
    private Integer code;
    /** id Exclude */
    private Integer codeEx;
    /**
     * 父级       db_column: parent 
     */
    private Integer parent;
    /**
     * 名称       db_column: name 
     */
    private String name;
    /**
     * 简称       db_column: shortname 
     */
    private String shortname;
    /**
     * 经度       db_column: longitude 
     */
    private String longitude;
    /**
     * 纬度       db_column: latitude 
     */
    private String latitude;
    /**
     * 级别       db_column: level 
     */
    private Integer level;
    /**
     * 排序       db_column: sort 
     */
    private Integer sort;
    /**
     * 状态1有效       db_column: status 
     */
    private Boolean status;
    //columns END


    public Region() {
    }

    public Region(
        Integer code
    ) {
        this.code = code;
    }

    

    public Region(
        Integer code,
        Integer parent,
        String name,
        String shortname,
        String longitude,
        String latitude,
        Integer level,
        Integer sort,
        Boolean status
    ) {
        this.code = code;
        this.parent = parent;
        this.name = name;
        this.shortname = shortname;
        this.longitude = longitude;
        this.latitude = latitude;
        this.level = level;
        this.sort = sort;
        this.status = status;
    }


    public void setCode(Integer value) {
        this.code = value;
    }
    
    public Integer getCode() {
        return this.code;
    }
    
    public void setCodeEx(Integer value) {
        this.codeEx = value;
    }
    
    public Integer getCodeEx() {
        return this.codeEx;
    }
    
    public Integer getParent() {
        return this.parent;
    }
    
    public void setParent(Integer value) {
        this.parent = value;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String value) {
        this.name = value;
    }
    
    public String getShortname() {
        return this.shortname;
    }
    
    public void setShortname(String value) {
        this.shortname = value;
    }
    
    public String getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(String value) {
        this.longitude = value;
    }
    
    public String getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(String value) {
        this.latitude = value;
    }
    
    public Integer getLevel() {
        return this.level;
    }
    
    public void setLevel(Integer value) {
        this.level = value;
    }
    
    public Integer getSort() {
        return this.sort;
    }
    
    public void setSort(Integer value) {
        this.sort = value;
    }
    
    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean value) {
        this.status = value;
    }
    
    
    @Override
    public Integer getId() {
        return this.code;
    }
}


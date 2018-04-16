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
 * @ClassName Functionality
 * @Description Functionality
 *
 * @author liujing
 * @Date 2016-01-18 18:11:27
 * @version 1.0
 *
 */
public class Functionality extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    // columns START
    /**
     * 主键 db_column: id
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 权限编码 db_column: code
     */
    private String code;
    /**
     * 权限名称 db_column: name
     */
    private String name;
    /**
     * 操作 db_column: operation
     */
    private String operation;
    /**
     * 是否被选择
     * 
     * @return
     */
    private boolean selected;
    /**
     * 目录id db_column: menu_id
     */
    private Integer menuId;
    /**
     * 删除标识 db_column: deleteYn
     */
    private String deleteYn;
    /**
     * 是否启用 db_column: disabledYn
     */
    private String disabledYn;
    /**
     * 创建用户 db_column: createUser
     */
    private String createUser;
    /**
     * 创建时间 db_column: createTime
     */
    private Date createTime;
    /**
     * 修改用户 db_column: updateUser
     */
    private String updateUser;
    /**
     * 修改时间 db_column: updateTime
     */
    private Date updateTime;
    // columns END

    public Functionality() {
    }

    public Functionality(Integer id) {
        this.id = id;
    }

    public Functionality(Integer id, String code, String name, String operation, Integer menuId, String deleteYn, String disabledYn,
            String createUser, Date createTime, String updateUser, Date updateTime) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.operation = operation;
        this.menuId = menuId;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public String getJsonString() {
        return "{\"code\":\"" + getCode() + "\",\"name\":\"" + getName() + "\",\"operation\":\"" + getOperation() + "\"}";
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

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String value) {
        this.operation = value;
    }

    public Integer getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Integer value) {
        this.menuId = value;
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}

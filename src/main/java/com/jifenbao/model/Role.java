/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;
import java.util.List;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName Role
 * @Description Role
 *
 * @author liujing
 * @Date 2015-12-21 17:16:22
 * @version 1.0
 *
 */
public class Role extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    // columns START
    /**
     * 角色编码 db_column: code
     */
    private String code;
    /** id Exclude */
    private String codeEx;
    /**
     * 角色名称 db_column: name
     */
    private String name;
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

    private List<Menu> menus;

    public Role() {
    }

    public Role(String code) {
        this.code = code;
    }

    public Role(String code, String name, String deleteYn, String disabledYn, String createUser, Date createTime, String updateUser,
            Date updateTime) {
        this.code = code;
        this.name = name;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public void setCode(String value) {
        this.code = value;
    }

    public String getCode() {
        return this.code;
    }

    public void setCodeEx(String value) {
        this.codeEx = value;
    }

    public String getCodeEx() {
        return this.codeEx;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
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

    @Override
    public String getId() {
        return this.code;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}

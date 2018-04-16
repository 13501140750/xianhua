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
 * @ClassName RoleFunctionality
 * @Description RoleFunctionality
 *
 * @author liujing
 * @Date 2016-01-23 20:04:04
 * @version 1.0
 *
 */
public class RoleFunctionality extends BaseEntity<RoleFunctionalityId> {

    private static final long serialVersionUID = 1L;

    /**
     * id key
     */
    private RoleFunctionalityId id;
    /**
     * id Exclude
     */
    private RoleFunctionalityId idEx;
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

    public RoleFunctionality() {
    }

    public RoleFunctionality(RoleFunctionalityId id) {
        this.id = id;
    }

    public RoleFunctionality(RoleFunctionalityId id, String deleteYn, String disabledYn, String createUser,
            Date createTime, String updateUser, Date updateTime) {
        this.id = id;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public RoleFunctionalityId getId() {
        return this.id;
    }

    public void setId(RoleFunctionalityId id) {
        this.id = id;
    }

    public RoleFunctionalityId getIdEx() {
        return this.idEx;
    }

    public void setIdEx(RoleFunctionalityId idEx) {
        this.idEx = idEx;
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

}

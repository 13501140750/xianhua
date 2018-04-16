/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.jifenbao.service.result.ResultHelper;
import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName RoleMenu
 * @Description RoleMenu
 *
 * @author liujing
 * @Date 2015-12-27 22:04:02
 * @version 1.0
 *
 */
public class RoleMenu extends BaseEntity<RoleMenuId> {

    private static final long serialVersionUID = 1L;

    /**
     * id key
     */
    private RoleMenuId id;
    /**
     * id Exclude
     */
    private RoleMenuId idEx;
    /**
     * 功能 db_column: function
     */
    private String function;
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

    public RoleMenu() {
    }

    public RoleMenu(RoleMenuId id) {
        this.id = id;
    }

    public RoleMenu(RoleMenuId id, String function, String deleteYn, String disabledYn, String createUser,
            Date createTime, String updateUser, Date updateTime) {
        this.id = id;
        this.function = function;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public void setFunctionalities(List<Functionality> list) {
        setFunction(ResultHelper.jasonString(list));
    }

    public List<Functionality> getFunctionalities() throws Exception {
        if (getFunction() == null)
            return null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Functionality[] listArray = mapper.readValue(getFunction(), Functionality[].class);
            return Arrays.asList(listArray);
        } catch (Exception e) {
            throw e;
        }
    }

    public RoleMenuId getId() {
        return this.id;
    }

    public void setId(RoleMenuId id) {
        this.id = id;
    }

    public RoleMenuId getIdEx() {
        return this.idEx;
    }

    public void setIdEx(RoleMenuId idEx) {
        this.idEx = idEx;
    }

    public String getFunction() {   
        return this.function;
    }

    public void setFunction(String value) {
        this.function = value;
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

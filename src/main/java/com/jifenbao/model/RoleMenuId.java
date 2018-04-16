
/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @ClassName      RoleMenu
 * @Description
 * RoleMenu
 *
 * @author      liujing
 * @Date        2015-12-27 22:04:02
 * @version     1.0 
 *
 */

public class RoleMenuId implements Serializable{
    private static final long serialVersionUID = 5454155825314635342L;
    
    /**
     * 角色编码       db_column: role_code 
     */
    private String roleCode;
    /**
     * 目录id       db_column: menu_id 
     */
    private Integer menuId;

    public RoleMenuId() {
    }

    public RoleMenuId(
        String roleCode,
        Integer menuId
    ) {
        this.roleCode = roleCode;
        this.menuId = menuId;
    }

    
    
    public void setRoleCode(String value) {
        this.roleCode = value;
    }
    
    public String getRoleCode() {
        return this.roleCode;
    }
    
    public void setMenuId(Integer value) {
        this.menuId = value;
    }
    
    public Integer getMenuId() {
        return this.menuId;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }
}
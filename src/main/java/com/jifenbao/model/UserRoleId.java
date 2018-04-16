
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
 * @ClassName      UserRole
 * @Description
 * UserRole
 *
 * @author      liujing
 * @Date        2015-12-25 18:11:04
 * @version     1.0 
 *
 */

public class UserRoleId implements Serializable{
    private static final long serialVersionUID = 5454155825314635342L;
    
    /**
     * 用户名       db_column: user_name 
     */
    private String userName;
    /**
     * 角色编码       db_column: role_code 
     */
    private String roleCode;

    public UserRoleId() {
    }

    public UserRoleId(
        String userName,
        String roleCode
    ) {
        this.userName = userName;
        this.roleCode = roleCode;
    }

    
    
    public void setUserName(String value) {
        this.userName = value;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setRoleCode(String value) {
        this.roleCode = value;
    }
    
    public String getRoleCode() {
        return this.roleCode;
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
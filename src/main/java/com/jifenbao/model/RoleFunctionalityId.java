
/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
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
 * @ClassName      RoleFunctionality
 * @Description
 * RoleFunctionality
 *
 * @author      liujing
 * @Date        2016-01-23 20:04:04
 * @version     1.0 
 *
 */

public class RoleFunctionalityId implements Serializable{
    private static final long serialVersionUID = 5454155825314635342L;
    
    /**
     * 角色编码       db_column: role_code 
     */
    private String roleCode;
    /**
     * 权限id       db_column: functionality_id 
     */
    private Integer functionalityId;

    public RoleFunctionalityId() {
    }

    public RoleFunctionalityId(
        String roleCode,
        Integer functionalityId
    ) {
        this.roleCode = roleCode;
        this.functionalityId = functionalityId;
    }

    
    
    public void setRoleCode(String value) {
        this.roleCode = value;
    }
    
    public String getRoleCode() {
        return this.roleCode;
    }
    
    public void setFunctionalityId(Integer value) {
        this.functionalityId = value;
    }
    
    public Integer getFunctionalityId() {
        return this.functionalityId;
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
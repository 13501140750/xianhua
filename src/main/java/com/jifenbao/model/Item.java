/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import com.otc.framework.model.BaseEntity;

/**
 *
 * @ClassName      Item
 * @Description
 * Item
 *
 * @author      liujing
 * @Date        2015-11-27 16:21:44
 * @version     1.0 
 *
 */
public class Item extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * code       db_column: code 
     */
    private String code;
    /**
     * name       db_column: name 
     */
    private String name;
    /**
     * parent       db_column: parent 
     */
    private String parent;
    /**
     * isParent       db_column: is_parent 
     */
    private Integer isParent;
    //columns END


    public Item() {
    }

    public Item(
        Integer id
    ) {
        this.id = id;
    }

    

    public Item(
        Integer id,
        String code,
        String name,
        String parent,
        Integer isParent
    ) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.parent = parent;
        this.isParent = isParent;
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
    
    public String getParent() {
        return this.parent;
    }
    
    public void setParent(String value) {
        this.parent = value;
    }
    
    public Integer getIsParent() {
        return this.isParent;
    }
    
    public void setIsParent(Integer value) {
        this.isParent = value;
    }
    
    
}


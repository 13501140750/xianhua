/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import com.otc.framework.model.BaseEntity;

/**
 *
 * @ClassName      FreightCompany
 * @Description
 * FreightCompany
 *
 * @author      liujing
 * @Date        2016-04-29 10:31:20
 * @version     1.0 
 *
 */
public class FreightCompany extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 货运公司简码       db_column: freight_code 
     */
    private String freightCode;
    /**
     * 货运公司名称       db_column: freight_name 
     */
    private String freightName;
    /**
     * 联系方式       db_column: linktype 
     */
    private String linktype;
    /**
     * 网址       db_column: url 
     */
    private String url;
    /**
     * 排序       db_column: sort 
     */
    private Integer sort;
    /**
     * 1：已删除，0未删除       db_column: deleteYn 
     */
    private String deleteYn;
    //columns END


    public FreightCompany() {
    }

    public FreightCompany(
        Integer id
    ) {
        this.id = id;
    }

    

    public FreightCompany(
        Integer id,
        String freightCode,
        String freightName,
        String linktype,
        String url,
        Integer sort,
        String deleteYn
    ) {
        this.id = id;
        this.freightCode = freightCode;
        this.freightName = freightName;
        this.linktype = linktype;
        this.url = url;
        this.sort = sort;
        this.deleteYn = deleteYn;
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
    
    public String getFreightCode() {
        return this.freightCode;
    }
    
    public void setFreightCode(String value) {
        this.freightCode = value;
    }
    
    public String getFreightName() {
        return this.freightName;
    }
    
    public void setFreightName(String value) {
        this.freightName = value;
    }
    
    public String getLinktype() {
        return this.linktype;
    }
    
    public void setLinktype(String value) {
        this.linktype = value;
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
    
    public String getDeleteYn() {
        return this.deleteYn;
    }
    
    public void setDeleteYn(String value) {
        this.deleteYn = value;
    }
    
    
}


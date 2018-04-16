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
 * @ClassName      CommissionClickcount
 * @Description
 * CommissionClickcount
 *
 * @author      wangyawei
 * @Date        2018-01-22 16:07:00
 * @version     1.0 
 *
 */
public class CommissionClickcount extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * access_id       db_column: cid 
     */
    private Long cid;
    /**
     * access_key       db_column: from_cid 
     */
    private Long fromCid;
    /**
     * 来源       db_column: source 
     */
    private String source;
    /**
     * 商品id       db_column: productId 
     */
    private Long productId;
    /**
     * deleteYn       db_column: deleteYn 
     */
    private String deleteYn;
    /**
     * disabledYn       db_column: disabledYn 
     */
    private String disabledYn;
    /**
     * createUser       db_column: createUser 
     */
    private String createUser;
    /**
     * createTime       db_column: createTime 
     */
    private Date createTime;
    /**
     * updateUser       db_column: updateUser 
     */
    private String updateUser;
    /**
     * updateTime       db_column: updateTime 
     */
    private Date updateTime;
    //columns END


    public CommissionClickcount() {
    }

    public CommissionClickcount(
        Long id
    ) {
        this.id = id;
    }

    

    public CommissionClickcount(
        Long id,
        Long cid,
        Long fromCid,
        String source,
        Long productId,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.cid = cid;
        this.fromCid = fromCid;
        this.source = source;
        this.productId = productId;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }


    public void setId(Long value) {
        this.id = value;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setIdEx(Long value) {
        this.idEx = value;
    }
    
    public Long getIdEx() {
        return this.idEx;
    }
    
    public Long getCid() {
        return this.cid;
    }
    
    public void setCid(Long value) {
        this.cid = value;
    }
    
    public Long getFromCid() {
        return this.fromCid;
    }
    
    public void setFromCid(Long value) {
        this.fromCid = value;
    }
    
    public String getSource() {
        return this.source;
    }
    
    public void setSource(String value) {
        this.source = value;
    }
    
    public Long getProductId() {
        return this.productId;
    }
    
    public void setProductId(Long value) {
        this.productId = value;
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


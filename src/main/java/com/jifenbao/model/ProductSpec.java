/**
 * Copyright 2008 - 2017 Powered by OpenTide <br/>
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
 * @ClassName      ProductSpec
 * @Description
 * ProductSpec
 *
 * @author      wangyawei
 * @Date        2017-11-28 11:07:14
 * @version     1.0 
 *
 */
public class ProductSpec extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 商品ID       db_column: productId 
     */
    private Long productId;
    /**
     * 标题       db_column: title 
     */
    private String title;
    /**
     * 介绍       db_column: description 
     */
    private String description;
    /**
     * 显示类型       db_column: displayType 
     */
    private Integer displayType;
    /**
     * 内容       db_column: content 
     */
    private String content;
    /**
     * 显示ID       db_column: displayOrder 
     */
    private Integer displayOrder;
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
    
    private String idStr;
    
    public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	List<ProductSpecItem> specItems;
    
    public List<ProductSpecItem> getSpecItems() {
    	if(specItems == null){
    		specItems = new ArrayList<ProductSpecItem>();
    	}
		return specItems;
	}

	public void setSpecItems(List<ProductSpecItem> specItems) {
		this.specItems = specItems;
	}

	public ProductSpec() {
    }

    public ProductSpec(
        Long id
    ) {
        this.id = id;
    }

    

    public ProductSpec(
        Long id,
        Long productId,
        String title,
        String description,
        Integer displayType,
        String content,
        Integer displayOrder,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.displayType = displayType;
        this.content = content;
        this.displayOrder = displayOrder;
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
    
    public Long getProductId() {
        return this.productId;
    }
    
    public void setProductId(Long value) {
        this.productId = value;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String value) {
        this.title = value;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String value) {
        this.description = value;
    }
    
    public Integer getDisplayType() {
        return this.displayType;
    }
    
    public void setDisplayType(Integer value) {
        this.displayType = value;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String value) {
        this.content = value;
    }
    
    public Integer getDisplayOrder() {
        return this.displayOrder;
    }
    
    public void setDisplayOrder(Integer value) {
        this.displayOrder = value;
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


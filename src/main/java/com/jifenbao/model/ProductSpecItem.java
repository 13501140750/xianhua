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
 * @ClassName      ProductSpecItem
 * @Description
 * ProductSpecItem
 *
 * @author      wangyawei
 * @Date        2017-11-28 11:10:14
 * @version     1.0 
 *
 */
public class ProductSpecItem extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 规格ID       db_column: specId 
     */
    private Long specId;
    /**
     * 标题       db_column: title 
     */
    private String title;
    /**
     * 图片       db_column: thumb 
     */
    private String thumb;
    /**
     * 显示       db_column: isShow 
     */
    private Integer isShow;
    /**
     * 显示顺序       db_column: displayOrder 
     */
    private Integer displayOrder;
    /**
     * 虚拟物品       db_column: isVirtual 
     */
    private Integer isVirtual;
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

	public ProductSpecItem() {
    }

    public ProductSpecItem(
        Long id
    ) {
        this.id = id;
    }

    

    public ProductSpecItem(
        Long id,
        Long specId,
        String title,
        String thumb,
        Integer isShow,
        Integer displayOrder,
        Integer isVirtual,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.specId = specId;
        this.title = title;
        this.thumb = thumb;
        this.isShow = isShow;
        this.displayOrder = displayOrder;
        this.isVirtual = isVirtual;
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
    
    public Long getSpecId() {
        return this.specId;
    }
    
    public void setSpecId(Long value) {
        this.specId = value;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String value) {
        this.title = value;
    }
    
    public String getThumb() {
        return this.thumb;
    }
    
    public void setThumb(String value) {
        this.thumb = value;
    }
    
    public Integer getIsShow() {
        return this.isShow;
    }
    
    public void setIsShow(Integer value) {
        this.isShow = value;
    }
    
    public Integer getDisplayOrder() {
        return this.displayOrder;
    }
    
    public void setDisplayOrder(Integer value) {
        this.displayOrder = value;
    }
    
    public Integer getIsVirtual() {
        return this.isVirtual;
    }
    
    public void setIsVirtual(Integer value) {
        this.isVirtual = value;
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


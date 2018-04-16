/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;
import java.util.List;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      Cart
 * @Description
 * Cart
 *
 * @author      liujing
 * @Date        2016-01-31 00:15:05
 * @version     1.0 
 *
 */
public class Cart extends BaseEntity<String> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * 购物车ID,UUID       db_column: id 
     */
    private String id;
    /** id Exclude */
    private String idEx;
    /**
     * 用户ID       db_column: customerId 
     */
    private Long customerId;
    
    /**
     * 类型 0 会员 1 定制卡。默认0
     */
    private Integer type = 0;
    /**
     * 创建时间       db_column: createTime 
     */
    private Date createTime;
    /**
     * 修改时间       db_column: updateTime 
     */
    private Date updateTime;
    //columns END

    private List<CartDetail> details;

    public Cart() {
    }

    public Cart(
        String id
    ) {
        this.id = id;
    }

    

    public Cart(
        String id,
        Long customerId,
        Date createTime,
        Date updateTime
    ) {
        this.id = id;
        this.customerId = customerId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


    public void setId(String value) {
        this.id = value;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setIdEx(String value) {
        this.idEx = value;
    }
    
    public String getIdEx() {
        return this.idEx;
    }
    
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Long value) {
        this.customerId = value;
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

	public List<CartDetail> getDetails() {
		return details;
	}

	public void setDetails(List<CartDetail> details) {
		this.details = details;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		if(type==null){
			type = 0;
		}
		this.type = type;
	}
    
	
    
}


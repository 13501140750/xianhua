/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      FreightTemplate
 * @Description
 * FreightTemplate
 *
 * @author      liujing
 * @Date        2016-01-05 12:01:59
 * @version     1.0 
 *
 */
public class FreightTemplate extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 运费模版code       db_column: code 
     */
    private String code;
    /**
     * 模版名称       db_column: templateName 
     */
    private String templateName;
    /**
     * 计价方式       db_column: standard 
     */
    private String standard;
    /**
     * 免邮金额       db_column: postageFreeThreshold 
     */
    private Double postageFreeThreshold;
    /**
     * 运送范围       db_column: deliveryScope 
     */
    private String deliveryScope;
    /**
     * 首件计价       db_column: basePrice 
     */
    private Double basePrice;
    /**
     * 首件重量/数量       db_column: baseAmount 
     */
    private Double baseAmount;
    /**
     * 增加的单位量       db_column: deltaAmount 
     */
    private Double deltaAmount;
    /**
     * 单位增量价格       db_column: deltaPrice 
     */
    private Double deltaPrice;
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
    
    private String deliveryName;
    
    private String  standardName;


    public FreightTemplate() {
    }

    public FreightTemplate(
        Long id
    ) {
        this.id = id;
    }

    

    public FreightTemplate(
        Long id,
        String code,
        String templateName,
        String standard,
        Double postageFreeThreshold,
        String deliveryScope,
        Double basePrice,
        Double baseAmount,
        Double deltaAmount,
        Double deltaPrice,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.code = code;
        this.templateName = templateName;
        this.standard = standard;
        this.postageFreeThreshold = postageFreeThreshold;
        this.deliveryScope = deliveryScope;
        this.basePrice = basePrice;
        this.baseAmount = baseAmount;
        this.deltaAmount = deltaAmount;
        this.deltaPrice = deltaPrice;
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
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String value) {
        this.code = value;
    }
    
    public String getTemplateName() {
        return this.templateName;
    }
    
    public void setTemplateName(String value) {
        this.templateName = value;
    }
    
    public String getStandard() {
        return this.standard;
    }
    
    public void setStandard(String value) {
        this.standard = value;
    }
    
    public Double getPostageFreeThreshold() {
        return this.postageFreeThreshold;
    }
    
    public void setPostageFreeThreshold(Double value) {
        this.postageFreeThreshold = value;
    }
    
    public String getDeliveryScope() {
        return this.deliveryScope;
    }
    
    public void setDeliveryScope(String value) {
        this.deliveryScope = value;
    }
    
    public Double getBasePrice() {
        return this.basePrice;
    }
    
    public void setBasePrice(Double value) {
        this.basePrice = value;
    }
    
    public Double getBaseAmount() {
        return this.baseAmount;
    }
    
    public void setBaseAmount(Double value) {
        this.baseAmount = value;
    }
    
    public Double getDeltaAmount() {
        return this.deltaAmount;
    }
    
    public void setDeltaAmount(Double value) {
        this.deltaAmount = value;
    }
    
    public Double getDeltaPrice() {
        return this.deltaPrice;
    }
    
    public void setDeltaPrice(Double value) {
        this.deltaPrice = value;
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

	public String getDeliveryName() {
		if(StringUtils.isBlank(this.deliveryName)){
			deliveryName="全国";
		}
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getStandardName() {
		if(StringUtils.isNotBlank(this.getStandard()) && this.getStandard().equals("0")){
			standardName="物流重量";
		}else{
			standardName="产品数量";
		}
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}
    
    
}


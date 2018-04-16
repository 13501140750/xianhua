/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      ProductComment
 * @Description
 * ProductComment
 *
 * @author      liujing
 * @Date        2016-01-06 17:18:38
 * @version     1.0 
 *
 */
public class ProductComment extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 所属公司       db_column: companyCode 
     */
    private String companyCode;
    /**
     * 产品编码       db_column: productCode 
     */
    private String productCode;
    /**
     * 标题       db_column: title 
     */
    private String title;
    /**
     * 产品型号(产品显示编码)       db_column: showCode 
     */
    private String showCode;
    /**
     * 市场价       db_column: marketPrice 
     */
    private Double marketPrice;
    /**
     * salesPrice       db_column: salesPrice 
     */
    private Double salesPrice;
    /**
     * 公司采购价       db_column: purchasePrice 
     */
    private Double purchasePrice;
    /**
     * 卖点       db_column: features 
     */
    private String features;
    /**
     * 产品描述       db_column: description 
     */
    private String description;
    /**
     * 商品展示方式 1:积分 2：价格       db_column: prdShowPriceType 
     */
    private String prdShowPriceType;
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


    public ProductComment() {
    }

    public ProductComment(
        Long id
    ) {
        this.id = id;
    }

    

    public ProductComment(
        Long id,
        String companyCode,
        String productCode,
        String title,
        String showCode,
        Double marketPrice,
        Double salesPrice,
        Double purchasePrice,
        String features,
        String description,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.companyCode = companyCode;
        this.productCode = productCode;
        this.title = title;
        this.showCode = showCode;
        this.marketPrice = marketPrice;
        this.salesPrice = salesPrice;
        this.purchasePrice = purchasePrice;
        this.features = features;
        this.description = description;
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
    
    public String getCompanyCode() {
        return this.companyCode;
    }
    
    public void setCompanyCode(String value) {
        this.companyCode = value;
    }
    
    public String getProductCode() {
        return this.productCode;
    }
    
    public void setProductCode(String value) {
        this.productCode = value;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String value) {
        this.title = value;
    }
    
    public String getShowCode() {
        return this.showCode;
    }
    
    public void setShowCode(String value) {
        this.showCode = value;
    }
    
    public Double getMarketPrice() {
        return this.marketPrice;
    }
    
    public void setMarketPrice(Double value) {
        this.marketPrice = value;
    }
    
    public Double getSalesPrice() {
        return this.salesPrice;
    }
    
    public void setSalesPrice(Double value) {
        this.salesPrice = value;
    }
    
    public Double getPurchasePrice() {
        return this.purchasePrice;
    }
    
    public void setPurchasePrice(Double value) {
        this.purchasePrice = value;
    }
    
   
    
    public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String value) {
        this.description = value;
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

	public String getPrdShowPriceType() {
		return prdShowPriceType;
	}

	public void setPrdShowPriceType(String prdShowPriceType) {
		this.prdShowPriceType = prdShowPriceType;
	}
    
    
}


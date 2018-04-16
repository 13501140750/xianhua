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
 * @ClassName      ProductOption
 * @Description
 * ProductOption
 *
 * @author      wangyawei
 * @Date        2017-12-03 15:00:39
 * @version     1.0 
 *
 */
public class ProductOption extends BaseEntity<Long> {
    
    
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
     * 商品编号       db_column: productCode 
     */
    private String productCode;
    /**
     * 名称       db_column: title 
     */
    private String title;
    /**
     * 缩略图       db_column: thumb 
     */
    private String thumb;
    /**
     * 商品原价       db_column: productPrice 
     */
    private Double productPrice;
    /**
     * 商品现价       db_column: marketPrice 
     */
    private Double marketPrice;
    /**
     * 商品成本       db_column: costPrice 
     */
    private Double costPrice;
    /**
     * 商品库存 -1 永久可卖       db_column: stock 
     */
    private Integer stock;
    /**
     * 商品重量       db_column: weight 
     */
    private Double weight;
    /**
     * 显示顺序       db_column: displayOrder 
     */
    private Integer displayOrder;
    /**
     * 规格设置       db_column: specs 
     */
    private String specs;
    /**
     * skuId       db_column: skuId 
     */
    private String skuId;
    /**
     * 商品编号       db_column: goodsSn 
     */
    private String goodsSn;
    /**
     * 商品条码       db_column: productSn 
     */
    private String productSn;
    /**
     * 虚拟商品       db_column: isVirtual 
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

	public ProductOption() {
    }

    public ProductOption(
        Long id
    ) {
        this.id = id;
    }

    

    public ProductOption(
        Long id,
        Long productId,
        String productCode,
        String title,
        String thumb,
        Double productPrice,
        Double marketPrice,
        Double costPrice,
        Integer stock,
        Double weight,
        Integer displayOrder,
        String specs,
        String skuId,
        String goodsSn,
        String productSn,
        Integer isVirtual,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.productId = productId;
        this.productCode = productCode;
        this.title = title;
        this.thumb = thumb;
        this.productPrice = productPrice;
        this.marketPrice = marketPrice;
        this.costPrice = costPrice;
        this.stock = stock;
        this.weight = weight;
        this.displayOrder = displayOrder;
        this.specs = specs;
        this.skuId = skuId;
        this.goodsSn = goodsSn;
        this.productSn = productSn;
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
    
    public Long getProductId() {
        return this.productId;
    }
    
    public void setProductId(Long value) {
        this.productId = value;
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
    
    public String getThumb() {
        return this.thumb;
    }
    
    public void setThumb(String value) {
        this.thumb = value;
    }
    
    public Double getProductPrice() {
        return this.productPrice;
    }
    
    public void setProductPrice(Double value) {
        this.productPrice = value;
    }
    
    public Double getMarketPrice() {
        return this.marketPrice;
    }
    
    public void setMarketPrice(Double value) {
        this.marketPrice = value;
    }
    
    public Double getCostPrice() {
        return this.costPrice;
    }
    
    public void setCostPrice(Double value) {
        this.costPrice = value;
    }
    
    public Integer getStock() {
        return this.stock;
    }
    
    public void setStock(Integer value) {
        this.stock = value;
    }
    
    public Double getWeight() {
        return this.weight;
    }
    
    public void setWeight(Double value) {
        this.weight = value;
    }
    
    public Integer getDisplayOrder() {
        return this.displayOrder;
    }
    
    public void setDisplayOrder(Integer value) {
        this.displayOrder = value;
    }
    
    public String getSpecs() {
        return this.specs;
    }
    
    public void setSpecs(String value) {
        this.specs = value;
    }
    
    public String getSkuId() {
        return this.skuId;
    }
    
    public void setSkuId(String value) {
        this.skuId = value;
    }
    
    public String getGoodsSn() {
        return this.goodsSn;
    }
    
    public void setGoodsSn(String value) {
        this.goodsSn = value;
    }
    
    public String getProductSn() {
        return this.productSn;
    }
    
    public void setProductSn(String value) {
        this.productSn = value;
    }
    
    public Integer getIsVirtual() {
		return isVirtual;
	}

	public void setIsVirtual(Integer isVirtual) {
		this.isVirtual = isVirtual;
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


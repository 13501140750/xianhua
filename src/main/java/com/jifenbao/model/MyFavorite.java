/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
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
 * @ClassName      MyFavorite
 * @Description
 * MyFavorite
 *
 * @author      liujing
 * @Date        2016-03-29 14:33:06
 * @version     1.0 
 *
 */
public class MyFavorite extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 访问者IP       db_column: ip 
     */
    private String ip;
    /**
     * 会员name       db_column: customName 
     */
    private String customName;
    /**
     * 浏览的商品编码       db_column: productCode 
     */
    private String productCode;
    /**
     * 浏览的商品分类       db_column: productCatCode 
     */
    private String productCatCode;
    /**
     * 浏览时间       db_column: createTime 
     */
    private Date createTime;
    /**
     * string1       db_column: string1 
     */
    private String string1;
    /**
     * string2       db_column: string2 
     */
    private String string2;
    /**
     * string3       db_column: string3 
     */
    private String string3;
    /**
     * string4       db_column: string4 
     */
    private String string4;
    /**
     * string5       db_column: string5 
     */
    private String string5;
    //columns END


    public MyFavorite() {
    }

    public MyFavorite(
        Long id
    ) {
        this.id = id;
    }

    

    public MyFavorite(
        Long id,
        String ip,
        String customName,
        String productCode,
        String productCatCode,
        Date createTime,
        String string1,
        String string2,
        String string3,
        String string4,
        String string5
    ) {
        this.id = id;
        this.ip = ip;
        this.customName = customName;
        this.productCode = productCode;
        this.productCatCode = productCatCode;
        this.createTime = createTime;
        this.string1 = string1;
        this.string2 = string2;
        this.string3 = string3;
        this.string4 = string4;
        this.string5 = string5;
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
    
    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String value) {
        this.ip = value;
    }
    
    public String getCustomName() {
        return this.customName;
    }
    
    public void setCustomName(String value) {
        this.customName = value;
    }
    
    public String getProductCode() {
        return this.productCode;
    }
    
    public void setProductCode(String value) {
        this.productCode = value;
    }
    
    public String getProductCatCode() {
        return this.productCatCode;
    }
    
    public void setProductCatCode(String value) {
        this.productCatCode = value;
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
    
    public String getString1() {
        return this.string1;
    }
    
    public void setString1(String value) {
        this.string1 = value;
    }
    
    public String getString2() {
        return this.string2;
    }
    
    public void setString2(String value) {
        this.string2 = value;
    }
    
    public String getString3() {
        return this.string3;
    }
    
    public void setString3(String value) {
        this.string3 = value;
    }
    
    public String getString4() {
        return this.string4;
    }
    
    public void setString4(String value) {
        this.string4 = value;
    }
    
    public String getString5() {
        return this.string5;
    }
    
    public void setString5(String value) {
        this.string5 = value;
    }
    
    public Product product;


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
    
}


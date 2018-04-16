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
 * @ClassName      ProductRs
 * @Description
 * ProductRs
 *
 * @author      liujing
 * @Date        2016-03-16 17:23:30
 * @version     1.0 
 *
 */
public class ProductRs extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 产品编号       db_column: productCode 
     */
    private String productCode;
    /**
     * 排序       db_column: sort 
     */
    private Integer sort;
    /**
     * recommendId      db_column: recommendId 
     */
    private Integer recommendId;
    /**
     * pubImage       db_column: pubImage 
     */
    private String pubImage;
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
    private Product product;//对应的产品信息
    
    private String commentCompanyCode;//当前公司


    public ProductRs() {
    }

    public ProductRs(
        Integer id
    ) {
        this.id = id;
    }

    

    public ProductRs(
        Integer id,
        String productCode,
        Integer sort,
        Integer recommendId,
        String pubImage,
        String string2,
        String string3,
        String string4,
        String string5,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.productCode = productCode;
        this.sort = sort;
        this.recommendId = recommendId;
        this.pubImage = pubImage;
        this.string2 = string2;
        this.string3 = string3;
        this.string4 = string4;
        this.string5 = string5;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
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
    
   
    
    public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getSort() {
        return this.sort;
    }
    
    public void setSort(Integer value) {
        this.sort = value;
    }
    
    public Integer getRecommendId() {
        return this.recommendId;
    }
    
    public void setRecommendId(Integer value) {
        this.recommendId = value;
    }
    
    
    
    public String getPubImage() {
    	String pub = this.pubImage;
    	if(StringUtils.isBlank(pub)){
    		if(this.getProduct()!=null && StringUtils.isNotBlank(this.getProduct().getImage0())){
    			pub = this.getProduct().getImage0();
    		}
    	}
		return pub;
	}

	public void setPubImage(String pubImage) {
		this.pubImage = pubImage;
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
		return string4;
	}

	public void setString4(String string4) {
		this.string4 = string4;
	}

	public String getString5() {
        return this.string5;
    }
    
    public void setString5(String value) {
        this.string5 = value;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCommentCompanyCode() {
		return commentCompanyCode;
	}

	public void setCommentCompanyCode(String commentCompanyCode) {
		this.commentCompanyCode = commentCompanyCode;
	}
    
    
    
}


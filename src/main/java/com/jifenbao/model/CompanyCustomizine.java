/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.jifenbao.common.JfbUtil;
import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      CompanyCustomizine
 * @Description
 * CompanyCustomizine
 *
 * @author      liujing
 * @Date        2016-04-20 16:44:53
 * @version     1.0 
 *
 */
public class CompanyCustomizine extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 公司编码       db_column: companyCode 
     */
    private String companyCode;
    /**
     * 公司域名       db_column: companyDomain 
     */
    private String companyDomain;
    /**
     * companyLogo       db_column: companyLogo 
     */
    private String companyLogo;
    /**
     * 是否需要修改产品定价。Y是N否       db_column: modifyPrdPriceYn 
     */
    private String modifyPrdPriceYn;
    /**
     * 定价方式。1：按销售价  2：按采购价       db_column: madePriceType 
     */
    private String madePriceType;
    /**
     * 价格调整比例       db_column: madePriceRate 
     */
    private Double madePriceRate;
    /**
     * 产品价格展示方式 1：按积分 2：按价格       db_column: productShowType 
     */
    private String productShowType;
    /**
     * 积分与价格的兑换比例       db_column: priceExchangeRate 
     */
    private Double priceExchangeRate;
    /**
     * 价格微调       db_column: priceAdjust 
     */
    private Double priceAdjust;
    /**
     * 备注       db_column: comment 
     */
    private String comment;
    /**
     * 卡册兑换页背景图       db_column: string1 
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
    /**
     * 电影价格调整比例       db_column: filmPriceRate 
     */
    private Double filmPriceRate;
    /**
     * 电影价格调整       db_column: filmPriceAdjust 
     */
    private Double filmPriceAdjust;
    /**
     * 运动价格调整比例       db_column: sportPriceRate 
     */
    private Double sportPriceRate;
    /**
     * 运动价格调整       db_column: sportPriceAdjust 
     */
    private Double sportPriceAdjust;
    /**
     * 演出价格调整比例       db_column: showPriceRate 
     */
    private Double showPriceRate;
    /**
     * 演出价格调整       db_column: showPriceAdjust 
     */
    private Double showPriceAdjust;
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
    
    private Company company;
    
    private Integer notId;
    
    


    public CompanyCustomizine() {
    }

    public CompanyCustomizine(
        Integer id
    ) {
        this.id = id;
    }

    

    public CompanyCustomizine(
            Integer id,
            String companyCode,
            String companyDomain,
            String companyLogo,
            String modifyPrdPriceYn,
            String madePriceType,
            Double madePriceRate,
            String productShowType,
            Double priceExchangeRate,
            Double priceAdjust,
            String comment,
            String string1,
            String string2,
            String string3,
            String string4,
            String string5,
            Double filmPriceRate,
            Double filmPriceAdjust,
            Double sportPriceRate,
            Double sportPriceAdjust,
            Double showPriceRate,
            Double showPriceAdjust,
            String deleteYn,
            String disabledYn,
            String createUser,
            Date createTime,
            String updateUser,
            Date updateTime
        ) {
            this.id = id;
            this.companyCode = companyCode;
            this.companyDomain = companyDomain;
            this.companyLogo = companyLogo;
            this.modifyPrdPriceYn = modifyPrdPriceYn;
            this.madePriceType = madePriceType;
            this.madePriceRate = madePriceRate;
            this.productShowType = productShowType;
            this.priceExchangeRate = priceExchangeRate;
            this.priceAdjust = priceAdjust;
            this.comment = comment;
            this.string1 = string1;
            this.string2 = string2;
            this.string3 = string3;
            this.string4 = string4;
            this.string5 = string5;
            this.filmPriceRate = filmPriceRate;
            this.filmPriceAdjust = filmPriceAdjust;
            this.sportPriceRate = sportPriceRate;
            this.sportPriceAdjust = sportPriceAdjust;
            this.showPriceRate = showPriceRate;
            this.showPriceAdjust = showPriceAdjust;
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
    
    public String getCompanyCode() {
        return this.companyCode;
    }
    
    public void setCompanyCode(String value) {
        this.companyCode = value;
    }
    
    public String getCompanyDomain() {
        return this.companyDomain;
    }
    
    public void setCompanyDomain(String value) {
        this.companyDomain = value;
    }
    
    public String getCompanyLogo() {
        return this.companyLogo;
    }
    
    public void setCompanyLogo(String value) {
        this.companyLogo = value;
    }
    
    public String getModifyPrdPriceYn() {
    	return StringUtils.isBlank(this.modifyPrdPriceYn)?"N":this.modifyPrdPriceYn;
    }
    
    public void setModifyPrdPriceYn(String value) {
        this.modifyPrdPriceYn = value;
    }
    
    public String getMadePriceType() {
        return StringUtils.isBlank(this.madePriceType)?"":this.madePriceType;
    }
    
    public void setMadePriceType(String value) {
        this.madePriceType = value;
    }
    
    public Double getMadePriceRate() {
        return this.madePriceRate==null?0:this.madePriceRate;
    }
    
    public String  getMadePriceRateString(){
    	if(this.madePriceRate==null){
    		return "0";
    	}else{
    		return JfbUtil.doubleMult(this.madePriceRate, 100.0)+"";
    	}
    }
    
    public void setMadePriceRate(Double value) {
        this.madePriceRate = value;
    }
    
    public String getProductShowType() {
        return StringUtils.isBlank(this.productShowType)?"1":this.productShowType;
    }
    
    public void setProductShowType(String value) {
        this.productShowType = value;
    }
    
    public Double getPriceExchangeRate() {
        return this.priceExchangeRate==null?1:this.priceExchangeRate;
    }
    
    public void setPriceExchangeRate(Double value) {
        this.priceExchangeRate = value;
    }
    
    public Double getPriceAdjust() {
		return this.priceAdjust==null?0:this.priceAdjust;
	}

	public void setPriceAdjust(Double priceAdjust) {
		this.priceAdjust = priceAdjust;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
    
	/**
	 * 定制卡册兑换页背景图 
	 * @return
	 */
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
    
    public Double getFilmPriceRate() {
		return filmPriceRate;
	}

	public void setFilmPriceRate(Double filmPriceRate) {
		this.filmPriceRate = filmPriceRate;
	}

	public Double getFilmPriceAdjust() {
		return filmPriceAdjust;
	}

	public void setFilmPriceAdjust(Double filmPriceAdjust) {
		this.filmPriceAdjust = filmPriceAdjust;
	}

	public Double getSportPriceRate() {
		return sportPriceRate;
	}

	public void setSportPriceRate(Double sportPriceRate) {
		this.sportPriceRate = sportPriceRate;
	}

	public Double getSportPriceAdjust() {
		return sportPriceAdjust;
	}

	public void setSportPriceAdjust(Double sportPriceAdjust) {
		this.sportPriceAdjust = sportPriceAdjust;
	}

	public Double getShowPriceRate() {
		return showPriceRate;
	}

	public void setShowPriceRate(Double showPriceRate) {
		this.showPriceRate = showPriceRate;
	}

	public Double getShowPriceAdjust() {
		return showPriceAdjust;
	}

	public void setShowPriceAdjust(Double showPriceAdjust) {
		this.showPriceAdjust = showPriceAdjust;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getNotId() {
		return notId;
	}

	public void setNotId(Integer notId) {
		this.notId = notId;
	}

	
    
    
}


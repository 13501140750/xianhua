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
 * @ClassName      DeliveryAddress
 * @Description
 * DeliveryAddress
 *
 * @author      liujing
 * @Date        2016-02-12 20:23:47
 * @version     1.0 
 *
 */
public class DeliveryAddress extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * 主键       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 会员id       db_column: customerId 
     */
    private Long customerId;
    /**
     * 是否默认       db_column: defaulted 
     */
    private Boolean defaulted;
    /**
     * 收货人       db_column: name 
     */
    private String name;
    /**
     * 省份id       db_column: provinceCode 
     */
    private Integer provinceCode;
    /**
     * 省份名称       db_column: provinceName 
     */
    private String provinceName;
    /**
     * 城市id       db_column: cityCode 
     */
    private Integer cityCode;
    /**
     * 城市名称       db_column: cityName 
     */
    private String cityName;
    /**
     * 区县id       db_column: countyCode 
     */
    private Integer countyCode;
    /**
     * 区县名称       db_column: countyName 
     */
    private String countyName;
    /**
     * 城镇id       db_column: streetCode 
     */
    private Integer streetCode;
    /**
     * 街道       db_column: streetName 
     */
    private String streetName;
    /**
     * 详细地址       db_column: address 
     */
    private String address;
    /**
     * 收货人电话       db_column: tel 
     */
    private String tel;
    /**
     * 收货人手机       db_column: phone 
     */
    private String phone;
    /**
     * 删除标识       db_column: deleteYn 
     */
    private String deleteYn;
    /**
     * 是否启用       db_column: disabledYn 
     */
    private String disabledYn;
    /**
     * 创建用户       db_column: createUser 
     */
    private String createUser;
    /**
     * 创建时间       db_column: createTime 
     */
    private Date createTime;
    /**
     * 修改用户       db_column: updateUser 
     */
    private String updateUser;
    /**
     * 修改时间       db_column: updateTime 
     */
    private Date updateTime;
    //columns END
    //默认type 0 会员。 1 卡
    Integer   type = 0;

    /*
     * 预约配送时间
     */
    String deliveryDate;

    public DeliveryAddress() {
    }

    public DeliveryAddress(
        Long id
    ) {
        this.id = id;
    }


	public DeliveryAddress(Long id, Long customerId, Boolean defaulted, String name, Integer provinceCode,
			String provinceName, Integer cityCode, String cityName, Integer countyCode, String countyName,
			Integer streetCode, String streetName, String address, String tel, String phone, String deleteYn,
			String disabledYn, String createUser, Date createTime, String updateUser, Date updateTime) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.defaulted = defaulted;
		this.name = name;
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.countyCode = countyCode;
		this.countyName = countyName;
		this.streetCode = streetCode;
		this.streetName = streetName;
		this.address = address;
		this.tel = tel;
		this.phone = phone;
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
    
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Long value) {
        this.customerId = value;
    }
    
    public Boolean getDefaulted() {
        return this.defaulted;
    }
    
    public void setDefaulted(Boolean value) {
        this.defaulted = value;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String value) {
        this.name = value;
    }
    
    public Integer getProvinceCode() {
        return this.provinceCode;
    }
    
    public void setProvinceCode(Integer value) {
        this.provinceCode = value;
    }
    
    public String getProvinceName() {
        return this.provinceName;
    }
    
    public void setProvinceName(String value) {
        this.provinceName = value;
    }
    
    public Integer getCityCode() {
        return this.cityCode;
    }
    
    public void setCityCode(Integer value) {
        this.cityCode = value;
    }
    
    public String getCityName() {
        return this.cityName;
    }
    
    public void setCityName(String value) {
        this.cityName = value;
    }
    
    public Integer getCountyCode() {
        return this.countyCode;
    }
    
    public void setCountyCode(Integer value) {
        this.countyCode = value;
    }
    
    public String getCountyName() {
        return this.countyName;
    }
    
    public void setCountyName(String value) {
        this.countyName = value;
    }
    
    public String getStreetName() {
        return this.streetName;
    }
    
    public void setStreetName(String value) {
        this.streetName = value;
    }
    
    public String getAddress() {
        return this.address == null? "" : this.address;
    }
    
    public void setAddress(String value) {
        this.address = value;
    }
    
    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String value) {
        this.tel = value;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String value) {
        this.phone = value;
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

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
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

	public Integer getStreetCode() {
		return streetCode;
	}

	public void setStreetCode(Integer streetCode) {
		this.streetCode = streetCode;
	}

    
	
	
    
}


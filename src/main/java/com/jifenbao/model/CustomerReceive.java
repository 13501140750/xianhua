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
 * @ClassName      CustomerReceive
 * @Description
 * CustomerReceive
 *
 * @author      liujing
 * @Date        2016-02-03 10:57:03
 * @version     1.0 
 *
 */
public class CustomerReceive extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 会员ID       db_column: customerName 
     */
    private String customerName;
    /**
     * 收货人姓名       db_column: receiver 
     */
    private String receiver;
    /**
     * 收货人电话       db_column: phone 
     */
    private String phone;
    /**
     * 省       db_column: province 
     */
    private String province;
    /**
     * 市       db_column: city 
     */
    private String city;
    /**
     * 街道       db_column: street 
     */
    private String street;
    /**
     * 详细地址       db_column: address 
     */
    private String address;
    /**
     * 是否是默认地址       db_column: defaultYn 
     */
    private String defaultYn;
    /**
     * county       db_column: county 
     */
    private String county;
    /**
     * tel       db_column: tel 
     */
    private String tel;
    /**
     * string3       db_column: String3 
     */
    private String string3;
    /**
     * string4       db_column: String4 
     */
    private String string4;
    /**
     * string5       db_column: String5 
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


    public CustomerReceive() {
    }

    public CustomerReceive(
        Long id
    ) {
        this.id = id;
    }

    

    public CustomerReceive(
        Long id,
        String customerName,
        String receiver,
        String phone,
        String province,
        String city,
        String street,
        String address,
        String defaultYn,
        String county,
        String tel,
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
        this.customerName = customerName;
        this.receiver = receiver;
        this.phone = phone;
        this.province = province;
        this.city = city;
        this.street = street;
        this.address = address;
        this.defaultYn = defaultYn;
        this.county = county;
        this.tel = tel;
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
    
  
    
    public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getReceiver() {
        return this.receiver;
    }
    
    public void setReceiver(String value) {
        this.receiver = value;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String value) {
        this.phone = value;
    }
    
    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String value) {
        this.province = value;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String value) {
        this.city = value;
    }
    
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String value) {
        this.street = value;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String value) {
        this.address = value;
    }
    
    public String getDefaultYn() {
        return this.defaultYn;
    }
    
    public void setDefaultYn(String value) {
        this.defaultYn = value;
    }
    
    
    
    public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	
    
    public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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


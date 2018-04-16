/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.jifenbao.common.Constant;
import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      Company
 * @Description
 * Company
 *
 * @author      liujing
 * @Date        2016-01-08 15:59:49
 * @version     1.0 
 *
 */
public class Company extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * code       db_column: code 
     */
    private String code;
    /**
     * name       db_column: name 
     */
    private String name;
    /**
     * 公司类型,platform：平台,distributor：渠道商,client：普通客户       db_column: type 
     */
    private String type;
    /**
     * 公司logo       db_column: logo 
     */
    private String logo;
    /**
     * 所在省       db_column: province 
     */
    private String province;
    /**
     * 所在市       db_column: city 
     */
    private String city;
    /**
     * 所在区县       db_column: county 
     */
    private String county;
    /**
     * 所在乡镇街道       db_column: street 
     */
    private String street;
    /**
     * 详细地址       db_column: address 
     */
    private String address;
    /**
     * 固定电话       db_column: phone 
     */
    private String phone;
    /**
     * 传真       db_column: fax 
     */
    private String fax;
    /**
     * 手机       db_column: mobile 
     */
    private String mobile;
    /**
     * email       db_column: email 
     */
    private String email;
    /**
     * 微信       db_column: wechatNo 
     */
    private String wechatNo;
    /**
     * 指定联系人       db_column: customerNo 
     */
    private String customerNo;
    /**
     * 注册资本       db_column: registerdCapital 
     */
    private String registerdCapital;
    /**
     * 营业执照号       db_column: businessLicenceNo 
     */
    private String businessLicenceNo;
    /**
     * 组织结构号       db_column: organizationNo 
     */
    private String organizationNo;
    /**
     * 税务登记号       db_column: taxRegistrationNo 
     */
    private String taxRegistrationNo;
    /**
     * 默认仓库       db_column: defaultWarehouseCode 
     */
    private String defaultWarehouseCode;
    /**
     * 默认快递公司       db_column: defaultExpressCode 
     */
    private String defaultExpressCode;
    /**
     * smtp服务器地址       db_column: smtpAdress 
     */
    private String smtpAdress;
    /**
     * smtp服务器端口       db_column: smtpPort 
     */
    private String smtpPort;
    /**
     * 显示发件人       db_column: smtpSengder 
     */
    private String smtpSengder;
    /**
     * smtp是否需要认证       db_column: smtpAuth 
     */
    private String smtpAuth;
    /**
     * smtp用户名       db_column: smtpUser 
     */
    private String smtpUser;
    /**
     * smtp密码       db_column: smtpPassword 
     */
    private String smtpPassword;
    /**
     * 服务提供商       db_column: serviceCompanyCode 
     */
    private String serviceCompanyCode;
    
    /**
     * warehouseAddress       db_column: 仓库地址 
     */
    private String warehouseAddress;
    /**
     * 合作模式       db_column: coopModel 
     */
    private String coopModel;
    /**
     * 结算方式       db_column: paymentModel 
     */
    private String paymentModel;
    /**
     * 合同有效期       db_column: contractValidDate 
     */
    private String contractValidDate;
    /**
     * 合同编号       db_column: contractNo 
     */
    private String contractNo;
    /**
     * qq       db_column: qq 
     */
    private String qq;
    
    /**
     * string1       db_column: string1 
     */
    private String string1;
    /**
     * string2       db_column: String2 
     */
    private String string2;
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
    /**
     * 二级域名       db_column: subDomain 
     */
    private String subDomain;
    //columns END
    /***********************************************/
    private String typeString;
    
    private String searchText;


    public Company() {
    }

    public Company(
        Long id
    ) {
        this.id = id;
    }

    

    public Company(
        Long id,
        String code,
        String name,
        String type,
        String logo,
        String province,
        String city,
        String county,
        String address,
        String phone,
        String fax,
        String mobile,
        String email,
        String wechatNo,
        String customerNo,
        String registerdCapital,
        String businessLicenceNo,
        String organizationNo,
        String taxRegistrationNo,
        String defaultWarehouseCode,
        String defaultExpressCode,
        String smtpAdress,
        String smtpPort,
        String smtpSengder,
        String smtpAuth,
        String smtpUser,
        String smtpPassword,
        String serviceCompanyCode,
        String string1,
        String string2,
        String string3,
        String string4,
        String string5,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime,
        String subDomain
    ) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.logo = logo;
        this.province = province;
        this.city = city;
        this.county = county;
        this.address = address;
        this.phone = phone;
        this.fax = fax;
        this.mobile = mobile;
        this.email = email;
        this.wechatNo = wechatNo;
        this.customerNo = customerNo;
        this.registerdCapital = registerdCapital;
        this.businessLicenceNo = businessLicenceNo;
        this.organizationNo = organizationNo;
        this.taxRegistrationNo = taxRegistrationNo;
        this.defaultWarehouseCode = defaultWarehouseCode;
        this.defaultExpressCode = defaultExpressCode;
        this.smtpAdress = smtpAdress;
        this.smtpPort = smtpPort;
        this.smtpSengder = smtpSengder;
        this.smtpAuth = smtpAuth;
        this.smtpUser = smtpUser;
        this.smtpPassword = smtpPassword;
        this.serviceCompanyCode = serviceCompanyCode;
        this.string1 = string1;
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
        this.setSubDomain(subDomain);
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
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String value) {
        this.name = value;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String value) {
        this.type = value;
    }
    
    public String getLogo() {
        return this.logo;
    }
    
    public void setLogo(String value) {
        this.logo = value;
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
    
    public String getCounty() {
        return this.county;
    }
    
    public void setCounty(String value) {
        this.county = value;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String value) {
        this.address = value;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String value) {
        this.phone = value;
    }
    
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String value) {
        this.fax = value;
    }
    
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String value) {
        this.mobile = value;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String value) {
        this.email = value;
    }
    
    public String getWechatNo() {
        return this.wechatNo;
    }
    
    public void setWechatNo(String value) {
        this.wechatNo = value;
    }
    
    public String getCustomerNo() {
        return this.customerNo;
    }
    
    public void setCustomerNo(String value) {
        this.customerNo = value;
    }
    
    public String getRegisterdCapital() {
        return this.registerdCapital;
    }
    
    public void setRegisterdCapital(String value) {
        this.registerdCapital = value;
    }
    
    public String getBusinessLicenceNo() {
        return this.businessLicenceNo;
    }
    
    public void setBusinessLicenceNo(String value) {
        this.businessLicenceNo = value;
    }
    
    public String getOrganizationNo() {
        return this.organizationNo;
    }
    
    public void setOrganizationNo(String value) {
        this.organizationNo = value;
    }
    
    public String getTaxRegistrationNo() {
        return this.taxRegistrationNo;
    }
    
    public void setTaxRegistrationNo(String value) {
        this.taxRegistrationNo = value;
    }
    
    public String getDefaultWarehouseCode() {
        return this.defaultWarehouseCode;
    }
    
    public void setDefaultWarehouseCode(String value) {
        this.defaultWarehouseCode = value;
    }
    
    public String getDefaultExpressCode() {
        return this.defaultExpressCode;
    }
    
    public void setDefaultExpressCode(String value) {
        this.defaultExpressCode = value;
    }
    
    public String getSmtpAdress() {
        return this.smtpAdress;
    }
    
    public void setSmtpAdress(String value) {
        this.smtpAdress = value;
    }
    
    public String getSmtpPort() {
        return this.smtpPort;
    }
    
    public void setSmtpPort(String value) {
        this.smtpPort = value;
    }
    
    public String getSmtpSengder() {
        return this.smtpSengder;
    }
    
    public void setSmtpSengder(String value) {
        this.smtpSengder = value;
    }
    
    public String getSmtpAuth() {
        return this.smtpAuth;
    }
    
    public void setSmtpAuth(String value) {
        this.smtpAuth = value;
    }
    
    public String getSmtpUser() {
        return this.smtpUser;
    }
    
    public void setSmtpUser(String value) {
        this.smtpUser = value;
    }
    
    public String getSmtpPassword() {
        return this.smtpPassword;
    }
    
    public void setSmtpPassword(String value) {
        this.smtpPassword = value;
    }
    
    public String getServiceCompanyCode() {
        return this.serviceCompanyCode;
    }
    
    public void setServiceCompanyCode(String value) {
        this.serviceCompanyCode = value;
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
        return DateTimeUtil.format(getCreateTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HYPHEN.getPattern());
    }
    public void setCreateTimeString(String value) {
        setCreateTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HYPHEN.getPattern()));
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

	public String getTypeString() {
		if(StringUtils.isNotBlank(type)){
			typeString = Constant.COMPANT_TYPE.get(type);
		}
		return typeString;
	}

	public void setTypeString(String typeString) {
		
		this.typeString = typeString;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

    public String getSubDomain() {
        return subDomain;
    }

    public void setSubDomain(String subDomain) {
        this.subDomain = subDomain;
    }

	public String getWarehouseAddress() {
		return warehouseAddress;
	}

	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public String getCoopModel() {
		return coopModel;
	}

	public void setCoopModel(String coopModel) {
		this.coopModel = coopModel;
	}

	public String getPaymentModel() {
		return paymentModel;
	}

	public void setPaymentModel(String paymentModel) {
		this.paymentModel = paymentModel;
	}

	public String getContractValidDate() {
		return contractValidDate;
	}

	public void setContractValidDate(String contractValidDate) {
		this.contractValidDate = contractValidDate;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
   
    
    
}


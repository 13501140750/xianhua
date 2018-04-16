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
 * @ClassName      ExpressOrder
 * @Description
 * ExpressOrder
 *
 * @author      liujing
 * @Date        2016-04-29 13:13:48
 * @version     1.0 
 *
 */
public class ExpressOrder extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * 主键       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 订单号       db_column: order_code 
     */
    private String orderCode;
    /**
     * 快递公司编码       db_column: shipper_code 
     */
    private String shipperCode;
    /**
     * 快递单号       db_column: logistic_code 
     */
    private String logisticCode;
    /**
     * markDestination       db_column: mark_destination 
     */
    private String markDestination;
    /**
     * originCode       db_column: origin_code 
     */
    private String originCode;
    /**
     * originName       db_column: origin_name 
     */
    private String originName;
    /**
     * packageCode       db_column: package_code 
     */
    private String packageCode;
    /**
     * 打印模板       db_column: print_template 
     */
    private String printTemplate;
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
     * 创建用户       db_column: updateUser 
     */
    private String updateUser;
    /**
     * 创建时间       db_column: updateTime 
     */
    private Date updateTime;
    //columns END
    
    private  FreightCompany freightCompany;


    public ExpressOrder() {
    }

    public ExpressOrder(
        Long id
    ) {
        this.id = id;
    }

    

    public ExpressOrder(
        Long id,
        String orderCode,
        String shipperCode,
        String logisticCode,
        String markDestination,
        String originCode,
        String originName,
        String packageCode,
        String printTemplate,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.orderCode = orderCode;
        this.shipperCode = shipperCode;
        this.logisticCode = logisticCode;
        this.markDestination = markDestination;
        this.originCode = originCode;
        this.originName = originName;
        this.packageCode = packageCode;
        this.printTemplate = printTemplate;
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
    
    public String getOrderCode() {
        return this.orderCode;
    }
    
    public void setOrderCode(String value) {
        this.orderCode = value;
    }
    
    public String getShipperCode() {
        return this.shipperCode;
    }
    
    public void setShipperCode(String value) {
        this.shipperCode = value;
    }
    
    public String getLogisticCode() {
        return this.logisticCode;
    }
    
    public void setLogisticCode(String value) {
        this.logisticCode = value;
    }
    
    public String getMarkDestination() {
        return this.markDestination;
    }
    
    public void setMarkDestination(String value) {
        this.markDestination = value;
    }
    
    public String getOriginCode() {
        return this.originCode;
    }
    
    public void setOriginCode(String value) {
        this.originCode = value;
    }
    
    public String getOriginName() {
        return this.originName;
    }
    
    public void setOriginName(String value) {
        this.originName = value;
    }
    
    public String getPackageCode() {
        return this.packageCode;
    }
    
    public void setPackageCode(String value) {
        this.packageCode = value;
    }
    
    public String getPrintTemplate() {
        return this.printTemplate;
    }
    
    public void setPrintTemplate(String value) {
        this.printTemplate = value;
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

	public FreightCompany getFreightCompany() {
		return freightCompany;
	}

	public void setFreightCompany(FreightCompany freightCompany) {
		this.freightCompany = freightCompany;
	}
    
    
}


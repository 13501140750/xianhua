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
 * @ClassName      PayOrder
 * @Description
 * PayOrder
 *
 * @author      liujing
 * @Date        2016-05-24 09:17:44
 * @version     1.0 
 *
 */
public class PayOrder extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 付款人ID       db_column: appuserid 
     */
    private String appuserid;
    /**
     * 付款人对应的公司编码       db_column: companyCode 
     */
    private String companyCode;
    /**
     * 请求人IP       db_column: userIp 
     */
    private String userIp;
    /**
     * 商品ID       db_column: waresid 
     */
    private String waresid;
    /**
     * 商品名称       db_column: waresname 
     */
    private String waresname;
    /**
     * 订单号       db_column: cporderid 
     */
    private String cporderid;
    /**
     * 货币类型       db_column: currency 
     */
    private String currency;
    /**
     * price       db_column: price 
     */
    private Double price;
    /**
     * 请求字符集       db_column: charset 
     */
    private Double charset;
    /**
     * 支付类型, 401 alipay,402 tenpay,403 weixin,404 bank       db_column: paytype 
     */
    private String paytype;
    /**
     * 支付时间       db_column: sendtime 
     */
    private String sendtime;
    /**
     * 支付结果       db_column: result 
     */
    private String result;
    /**
     * 交易流水号       db_column: transid 
     */
    private String transid;
    /**
     * 交易完成时间       db_column: transtime 
     */
    private String transtime;
    /**
     * 平台交易流水号       db_column: platFormTransid 
     */
    private String platFormTransid;
    /**
     * 错误编码       db_column: returnCode 
     */
    private String returnCode;
    /**
     * 错误信息       db_column: errmsg 
     */
    private String errmsg;
    /**
     * 退款状态       db_column: refundStatus 
     */
    private String refundStatus;
    /**
     * 退款金额       db_column: refundPrice 
     */
    private Double refundPrice;
    /**
     * 退款原因       db_column: refundReason 
     */
    private String refundReason;
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

    private String returnUrl;
    
    private String buyerId;
    
    

    public PayOrder() {
    }

    public PayOrder(
        Long id
    ) {
        this.id = id;
    }

    

    public PayOrder(
        Long id,
        String appuserid,
        String companyCode,
        String userIp,
        String waresid,
        String waresname,
        String cporderid,
        String currency,
        Double price,
        Double charset,
        String paytype,
        String sendtime,
        String result,
        String transid,
        String transtime,
        String platFormTransid,
        String returnCode,
        String errmsg,
        String refundStatus,
        Double refundPrice,
        String refundReason,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.appuserid = appuserid;
        this.companyCode = companyCode;
        this.userIp = userIp;
        this.waresid = waresid;
        this.waresname = waresname;
        this.cporderid = cporderid;
        this.currency = currency;
        this.price = price;
        this.charset = charset;
        this.paytype = paytype;
        this.sendtime = sendtime;
        this.result = result;
        this.transid = transid;
        this.transtime = transtime;
        this.platFormTransid = platFormTransid;
        this.returnCode = returnCode;
        this.errmsg = errmsg;
        this.refundStatus = refundStatus;
        this.refundPrice = refundPrice;
        this.refundReason = refundReason;
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
    
    public String getAppuserid() {
        return this.appuserid;
    }
    
    public void setAppuserid(String value) {
        this.appuserid = value;
    }
    
    public String getCompanyCode() {
        return this.companyCode;
    }
    
    public void setCompanyCode(String value) {
        this.companyCode = value;
    }
    
    public String getUserIp() {
        return this.userIp;
    }
    
    public void setUserIp(String value) {
        this.userIp = value;
    }
    
    public String getWaresid() {
        return this.waresid;
    }
    
    public void setWaresid(String value) {
        this.waresid = value;
    }
    
    public String getWaresname() {
        return this.waresname;
    }
    
    public void setWaresname(String value) {
        this.waresname = value;
    }
    
    public String getCporderid() {
        return this.cporderid;
    }
    
    public void setCporderid(String value) {
        this.cporderid = value;
    }
    
    public String getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(String value) {
        this.currency = value;
    }
    
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double value) {
        this.price = value;
    }
    
    public Double getCharset() {
        return this.charset;
    }
    
    public void setCharset(Double value) {
        this.charset = value;
    }
    
    public String getPaytype() {
        return this.paytype;
    }
    
    public void setPaytype(String value) {
        this.paytype = value;
    }
    
    public String getSendtime() {
        return this.sendtime;
    }
    
    public void setSendtime(String value) {
        this.sendtime = value;
    }
    
    public String getResult() {
        return this.result;
    }
    
    public void setResult(String value) {
        this.result = value;
    }
    
    public String getTransid() {
        return this.transid;
    }
    
    public void setTransid(String value) {
        this.transid = value;
    }
    
    
    
    public String getTranstime() {
        return this.transtime;
    }
    
    public void setTranstime(String value) {
        this.transtime = value;
    }
    
    public String getPlatFormTransid() {
        return this.platFormTransid;
    }
    
    public void setPlatFormTransid(String value) {
        this.platFormTransid = value;
    }
    
    public String getReturnCode() {
        return this.returnCode;
    }
    
    public void setReturnCode(String value) {
        this.returnCode = value;
    }
    
    public String getErrmsg() {
        return this.errmsg;
    }
    
    public void setErrmsg(String value) {
        this.errmsg = value;
    }
    
    public String getRefundStatus() {
        return this.refundStatus;
    }
    
    public void setRefundStatus(String value) {
        this.refundStatus = value;
    }
    
    public Double getRefundPrice() {
        return this.refundPrice;
    }
    
    public void setRefundPrice(Double value) {
        this.refundPrice = value;
    }
    
    public String getRefundReason() {
        return this.refundReason;
    }
    
    public void setRefundReason(String value) {
        this.refundReason = value;
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

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	
    
	
    
}


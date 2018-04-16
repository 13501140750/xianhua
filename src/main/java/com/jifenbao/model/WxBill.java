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
 * @ClassName      WxBill
 * @Description
 * WxBill
 *
 * @author      wangyawei
 * @Date        2017-12-15 00:38:35
 * @version     1.0 
 *
 */
public class WxBill extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * 此处写你的注释       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 交易时间       db_column: tradeTime 
     */
    private String tradeTime;
    /**
     * 公众账号       db_column: ghId 
     */
    private String ghId;
    /**
     * 商户号       db_column: mchId 
     */
    private String mchId;
    /**
     * 子商户号       db_column: subMchNo 
     */
    private String subMchNo;
    /**
     * 设备号       db_column: deviceNo 
     */
    private String deviceNo;
    /**
     * 微信订单号       db_column: wxOrderCode 
     */
    private String wxOrderCode;
    /**
     * 商户订单号       db_column: bzOrderCode 
     */
    private String bzOrderCode;
    /**
     * 用户标识       db_column: openid 
     */
    private String openid;
    /**
     * 交易类型       db_column: tradeType 
     */
    private String tradeType;
    /**
     * 交易状态       db_column: tradeStatus 
     */
    private String tradeStatus;
    /**
     * 付款银行       db_column: bank 
     */
    private String bank;
    /**
     * 货币种类       db_column: currency 
     */
    private String currency;
    /**
     * 总金额       db_column: totalMoney 
     */
    private String totalMoney;
    /**
     * 代金券或立减优惠金额       db_column: redPacketMoney 
     */
    private String redPacketMoney;
    /**
     * 微信退款单号       db_column: wxRefundNo 
     */
    private String wxRefundNo;
    /**
     * 商户退款单号       db_column: bzRefundNo 
     */
    private String bzRefundNo;
    /**
     * 退款金额       db_column: refundMoney 
     */
    private String refundMoney;
    /**
     * 代金券或立减优惠退款金额       db_column: redPacketRefund 
     */
    private String redPacketRefund;
    /**
     * 退款类型       db_column: refundType 
     */
    private String refundType;
    /**
     * 退款状态       db_column: refundStatus 
     */
    private String refundStatus;
    /**
     * 商品名称       db_column: productName 
     */
    private String productName;
    /**
     * 商户数据包       db_column: bzDataPacket 
     */
    private String bzDataPacket;
    /**
     * 手续费       db_column: fee 
     */
    private String fee;
    /**
     * 费率       db_column: rate 
     */
    private String rate;
    //columns END


    public WxBill() {
    }

    public WxBill(
        Integer id
    ) {
        this.id = id;
    }

    

    public WxBill(
        Integer id,
        String tradeTime,
        String ghId,
        String mchId,
        String subMchNo,
        String deviceNo,
        String wxOrderCode,
        String bzOrderCode,
        String openid,
        String tradeType,
        String tradeStatus,
        String bank,
        String currency,
        String totalMoney,
        String redPacketMoney,
        String wxRefundNo,
        String bzRefundNo,
        String refundMoney,
        String redPacketRefund,
        String refundType,
        String refundStatus,
        String productName,
        String bzDataPacket,
        String fee,
        String rate
    ) {
        this.id = id;
        this.tradeTime = tradeTime;
        this.ghId = ghId;
        this.mchId = mchId;
        this.subMchNo = subMchNo;
        this.deviceNo = deviceNo;
        this.wxOrderCode = wxOrderCode;
        this.bzOrderCode = bzOrderCode;
        this.openid = openid;
        this.tradeType = tradeType;
        this.tradeStatus = tradeStatus;
        this.bank = bank;
        this.currency = currency;
        this.totalMoney = totalMoney;
        this.redPacketMoney = redPacketMoney;
        this.wxRefundNo = wxRefundNo;
        this.bzRefundNo = bzRefundNo;
        this.refundMoney = refundMoney;
        this.redPacketRefund = redPacketRefund;
        this.refundType = refundType;
        this.refundStatus = refundStatus;
        this.productName = productName;
        this.bzDataPacket = bzDataPacket;
        this.fee = fee;
        this.rate = rate;
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
    
    public String getTradeTime() {
        return this.tradeTime;
    }
    
    public void setTradeTime(String value) {
        this.tradeTime = value;
    }
    
    public String getGhId() {
        return this.ghId;
    }
    
    public void setGhId(String value) {
        this.ghId = value;
    }
    
    public String getMchId() {
        return this.mchId;
    }
    
    public void setMchId(String value) {
        this.mchId = value;
    }
    
    public String getSubMchNo() {
        return this.subMchNo;
    }
    
    public void setSubMchNo(String value) {
        this.subMchNo = value;
    }
    
    public String getDeviceNo() {
        return this.deviceNo;
    }
    
    public void setDeviceNo(String value) {
        this.deviceNo = value;
    }
    
    public String getWxOrderCode() {
        return this.wxOrderCode;
    }
    
    public void setWxOrderCode(String value) {
        this.wxOrderCode = value;
    }
    
    public String getBzOrderCode() {
        return this.bzOrderCode;
    }
    
    public void setBzOrderCode(String value) {
        this.bzOrderCode = value;
    }
    
    public String getOpenid() {
        return this.openid;
    }
    
    public void setOpenid(String value) {
        this.openid = value;
    }
    
    public String getTradeType() {
        return this.tradeType;
    }
    
    public void setTradeType(String value) {
        this.tradeType = value;
    }
    
    public String getTradeStatus() {
        return this.tradeStatus;
    }
    
    public void setTradeStatus(String value) {
        this.tradeStatus = value;
    }
    
    public String getBank() {
        return this.bank;
    }
    
    public void setBank(String value) {
        this.bank = value;
    }
    
    public String getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(String value) {
        this.currency = value;
    }
    
    public String getTotalMoney() {
        return this.totalMoney;
    }
    
    public void setTotalMoney(String value) {
        this.totalMoney = value;
    }
    
    public String getRedPacketMoney() {
        return this.redPacketMoney;
    }
    
    public void setRedPacketMoney(String value) {
        this.redPacketMoney = value;
    }
    
    public String getWxRefundNo() {
        return this.wxRefundNo;
    }
    
    public void setWxRefundNo(String value) {
        this.wxRefundNo = value;
    }
    
    public String getBzRefundNo() {
        return this.bzRefundNo;
    }
    
    public void setBzRefundNo(String value) {
        this.bzRefundNo = value;
    }
    
    public String getRefundMoney() {
        return this.refundMoney;
    }
    
    public void setRefundMoney(String value) {
        this.refundMoney = value;
    }
    
    public String getRedPacketRefund() {
        return this.redPacketRefund;
    }
    
    public void setRedPacketRefund(String value) {
        this.redPacketRefund = value;
    }
    
    public String getRefundType() {
        return this.refundType;
    }
    
    public void setRefundType(String value) {
        this.refundType = value;
    }
    
    public String getRefundStatus() {
        return this.refundStatus;
    }
    
    public void setRefundStatus(String value) {
        this.refundStatus = value;
    }
    
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String value) {
        this.productName = value;
    }
    
    public String getBzDataPacket() {
        return this.bzDataPacket;
    }
    
    public void setBzDataPacket(String value) {
        this.bzDataPacket = value;
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public void setFee(String value) {
        this.fee = value;
    }
    
    public String getRate() {
        return this.rate;
    }
    
    public void setRate(String value) {
        this.rate = value;
    }
    
    
}


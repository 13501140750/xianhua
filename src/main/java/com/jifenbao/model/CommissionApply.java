/**
 * Copyright 2008 - 2018 Powered by OpenTide <br/>
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
 * @ClassName      CommissionApply
 * @Description
 * CommissionApply
 *
 * @author      wangyawei
 * @Date        2018-02-05 10:01:50
 * @version     1.0 
 *
 */
public class CommissionApply extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 提现单号       db_column: applyNo 
     */
    private String applyNo;
    /**
     * 会员ID       db_column: customerId 
     */
    private Long customerId;
    /**
     * 提现类型 0 余额 1 微信钱包 2 支付宝 3 银行卡       db_column: type 
     */
    private Integer type;
    /**
     * 订单id集       db_column: orderIds 
     */
    private String orderIds;
    /**
     * 佣金金额       db_column: commission 
     */
    private Double commission;
    /**
     * 佣金支付金额       db_column: commissionPay 
     */
    private Double commissionPay;
    /**
     * 内容       db_column: content 
     */
    private String content;
    /**
     * 状态 -2 拒绝 -1 无效 0 未知 1 正在申请 2 审核通过 3 已经打款       db_column: status 
     */
    private Integer status;
    /**
     * 报名时间       db_column: applyTime 
     */
    private Date applyTime;
    /**
     * 审核时间       db_column: checkTime 
     */
    private Date checkTime;
    /**
     * 支付时间       db_column: payTime 
     */
    private Date payTime;
    /**
     * 拒绝时间       db_column: invalidTime 
     */
    private Date invalidTime;
    /**
     * v2 拒绝时间       db_column: refuseTime 
     */
    private Date refuseTime;
    /**
     * v2 实际到账       db_column: realMoney 
     */
    private Double realMoney;
    /**
     * v2 个人所得税       db_column: charge 
     */
    private Double charge;
    /**
     * v2 个人所得税金额       db_column: deductionMoney 
     */
    private Double deductionMoney;
    /**
     * v2 税前佣金       db_column: beginMoney 
     */
    private Double beginMoney;
    /**
     * v2 税后佣金       db_column: endMoney 
     */
    private Double endMoney;
    /**
     * v2 提现到支付宝帐号       db_column: alipay 
     */
    private String alipay;
    /**
     * v2 提现银行名       db_column: bankName 
     */
    private String bankName;
    /**
     * v2 提现到银行卡号       db_column: bankCard 
     */
    private String bankCard;
    /**
     * v2 银行实名       db_column: realName 
     */
    private String realName;
    /**
     * v2 支付宝1       db_column: alipay1 
     */
    private String alipay1;
    /**
     * v2 银行名1       db_column: bankName1 
     */
    private String bankName1;
    /**
     * v2 银行卡1       db_column: bankCard1 
     */
    private String bankCard1;
    /**
     * v2 回购       db_column: repurchase 
     */
    private Double repurchase;
    /**
     * v2 发送钱数       db_column: sendMoney 
     */
    private Double sendMoney;
    /**
     * v2 发送数据       db_column: sendData 
     */
    private String sendData;
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
	
	private List<ExchangeOrder> orderList;

    public List<ExchangeOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<ExchangeOrder> orderList) {
		this.orderList = orderList;
	}


    public CommissionApply() {
    }

    public CommissionApply(
    		Long id
    ) {
        this.id = id;
    }

    

    public CommissionApply(
    	Long id,
        String applyNo,
        Long customerId,
        Integer type,
        String orderIds,
        Double commission,
        Double commissionPay,
        String content,
        Integer status,
        Date applyTime,
        Date checkTime,
        Date payTime,
        Date invalidTime,
        Date refuseTime,
        Double realMoney,
        Double charge,
        Double deductionMoney,
        Double beginMoney,
        Double endMoney,
        String alipay,
        String bankName,
        String bankCard,
        String realName,
        String alipay1,
        String bankName1,
        String bankCard1,
        Double repurchase,
        Double sendMoney,
        String sendData,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.applyNo = applyNo;
        this.customerId = customerId;
        this.type = type;
        this.orderIds = orderIds;
        this.commission = commission;
        this.commissionPay = commissionPay;
        this.content = content;
        this.status = status;
        this.applyTime = applyTime;
        this.checkTime = checkTime;
        this.payTime = payTime;
        this.invalidTime = invalidTime;
        this.refuseTime = refuseTime;
        this.realMoney = realMoney;
        this.charge = charge;
        this.deductionMoney = deductionMoney;
        this.beginMoney = beginMoney;
        this.endMoney = endMoney;
        this.alipay = alipay;
        this.bankName = bankName;
        this.bankCard = bankCard;
        this.realName = realName;
        this.alipay1 = alipay1;
        this.bankName1 = bankName1;
        this.bankCard1 = bankCard1;
        this.repurchase = repurchase;
        this.sendMoney = sendMoney;
        this.sendData = sendData;
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
    
    public String getApplyNo() {
        return this.applyNo;
    }
    
    public void setApplyNo(String value) {
        this.applyNo = value;
    }
    
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    
    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer value) {
        this.type = value;
    }
    
    public String getOrderIds() {
        return this.orderIds;
    }
    
    public void setOrderIds(String value) {
        this.orderIds = value;
    }
    
    public Double getCommission() {
        return this.commission;
    }
    
    public void setCommission(Double value) {
        this.commission = value;
    }
    
    public Double getCommissionPay() {
        return this.commissionPay;
    }
    
    public void setCommissionPay(Double value) {
        this.commissionPay = value;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String value) {
        this.content = value;
    }
    
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer value) {
        this.status = value;
    }
    
    public String getApplyTimeString() {
        return DateTimeUtil.format(getApplyTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setApplyTimeString(String value) {
        setApplyTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getApplyTime() {
        return this.applyTime;
    }
    
    public void setApplyTime(Date value) {
        this.applyTime = value;
    }
    
    public String getCheckTimeString() {
        return DateTimeUtil.format(getCheckTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setCheckTimeString(String value) {
        setCheckTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getCheckTime() {
        return this.checkTime;
    }
    
    public void setCheckTime(Date value) {
        this.checkTime = value;
    }
    
    public String getPayTimeString() {
        return DateTimeUtil.format(getPayTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setPayTimeString(String value) {
        setPayTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getPayTime() {
        return this.payTime;
    }
    
    public void setPayTime(Date value) {
        this.payTime = value;
    }
    
    public String getInvalidTimeString() {
        return DateTimeUtil.format(getInvalidTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setInvalidTimeString(String value) {
        setInvalidTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getInvalidTime() {
        return this.invalidTime;
    }
    
    public void setInvalidTime(Date value) {
        this.invalidTime = value;
    }
    
    public String getRefuseTimeString() {
        return DateTimeUtil.format(getRefuseTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setRefuseTimeString(String value) {
        setRefuseTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getRefuseTime() {
        return this.refuseTime;
    }
    
    public void setRefuseTime(Date value) {
        this.refuseTime = value;
    }
    
    public Double getRealMoney() {
        return this.realMoney;
    }
    
    public void setRealMoney(Double value) {
        this.realMoney = value;
    }
    
    public Double getCharge() {
        return this.charge;
    }
    
    public void setCharge(Double value) {
        this.charge = value;
    }
    
    public Double getDeductionMoney() {
        return this.deductionMoney;
    }
    
    public void setDeductionMoney(Double value) {
        this.deductionMoney = value;
    }
    
    public Double getBeginMoney() {
        return this.beginMoney;
    }
    
    public void setBeginMoney(Double value) {
        this.beginMoney = value;
    }
    
    public Double getEndMoney() {
        return this.endMoney;
    }
    
    public void setEndMoney(Double value) {
        this.endMoney = value;
    }
    
    public String getAlipay() {
        return this.alipay;
    }
    
    public void setAlipay(String value) {
        this.alipay = value;
    }
    
    public String getBankName() {
        return this.bankName;
    }
    
    public void setBankName(String value) {
        this.bankName = value;
    }
    
    public String getBankCard() {
        return this.bankCard;
    }
    
    public void setBankCard(String value) {
        this.bankCard = value;
    }
    
    public String getRealName() {
        return this.realName;
    }
    
    public void setRealName(String value) {
        this.realName = value;
    }
    
    public String getAlipay1() {
        return this.alipay1;
    }
    
    public void setAlipay1(String value) {
        this.alipay1 = value;
    }
    
    public String getBankName1() {
        return this.bankName1;
    }
    
    public void setBankName1(String value) {
        this.bankName1 = value;
    }
    
    public String getBankCard1() {
        return this.bankCard1;
    }
    
    public void setBankCard1(String value) {
        this.bankCard1 = value;
    }
    
    public Double getRepurchase() {
        return this.repurchase;
    }
    
    public void setRepurchase(Double value) {
        this.repurchase = value;
    }
    
    public Double getSendMoney() {
        return this.sendMoney;
    }
    
    public void setSendMoney(Double value) {
        this.sendMoney = value;
    }
    
    public String getSendData() {
        return this.sendData;
    }
    
    public void setSendData(String value) {
        this.sendData = value;
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
	
	public String getTypeString(){
    	String typeString = null;
    	switch (this.type) {
		case 1001:
			typeString = "账户余额";
			break;
		case 1002:
			typeString = "微信红包";
			break;
		case 1003:
			typeString = "支付宝";
			break;

		default:
			break;
		}
    	return typeString;
    }
	
	
	public String getStatusString(){
		String statusStr = "";
		if(status == 1){
			statusStr =  "审核中";
		}else if(status == 2){
			statusStr = "待打款";
		}if(status == 3){
			statusStr = "已打款";
		}if(status == -1){
			statusStr = "无效";
		}if(status == -2){
			statusStr = "驳回";
		}
		return statusStr;
	}
	
	
	public String getDealTimeString(){
		String r = "";
		if(status == 1){
			r =  getApplyTimeString();
		}else if(status == 2){
			r = getCheckTimeString();
		}if(status == 3){
			r = getPayTimeString();
		}if(status == -1){
			r = getInvalidTimeString();
		}if(status == -2){
			r = getRefuseTimeString();
		}
		return r;
	}
    
    
}


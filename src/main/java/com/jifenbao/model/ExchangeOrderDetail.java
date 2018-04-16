/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;

import com.jifenbao.common.Constant;
import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      ExchangeOrderDetail
 * @Description
 * ExchangeOrderDetail
 *
 * @author      liujing
 * @Date        2016-02-03 16:43:08
 * @version     1.0 
 *
 */
public class ExchangeOrderDetail extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 订单号       db_column: orderCode 
     */
    private String orderCode;
    /**
     * subOrderCode       db_column: subOrderCode 
     */
    private String subOrderCode;
    /**
     * 会员ID       db_column: customerName 
     */
    private String customerName;
    /**
     * 兑换的product       db_column: productCode 
     */
    private String productCode;
    /**
     * optionId       db_column: optionId 
     */
    private Long optionId;
    /**
     * productCount       db_column: productCount 
     */
    private Integer productCount;
    /**
     * 价格，所需积分       db_column: price 
     */
    private Double price;
    /**
     * 优惠价格       db_column: discountPrice 
     */
    private Double discountPrice;
    /**
     * 消费的积分价格
     */
    private Integer jifenPrice;
    /**
     * 商品结算价格
     */
    private Double settlePrice;
    /**
     * 订单状态       db_column: orderStatus 
     */
    private String orderStatus;
    /**
     * 兑换数量       db_column: count 
     */
    private Integer count;
    /**
     * 预约配送时间       db_column: deliveryDate 
     */
    private String deliveryDate;
    /**
     * 发货类型       db_column: sendType 
     */
    private Integer sendType;
    /**
     * 发货时间       db_column: sendTime 
     */
    private Date sendTime;
    /**
     * 快递单号       db_column: expressNumber 
     */
    private String expressNumber;
    /**
     * 快递公司       db_column: expressCompany 
     */
    private String expressCompany;
    /**
     * 是否代发货 Y:供应商代发货 N：平台发货       db_column: dropshipYn 
     */
    private String dropshipYn;
    /**
     * 代发货商CODE       db_column: partnerCode 
     */
    private String partnerCode;
    /**
     * 审核状态       db_column: auditflag 
     */
    private String auditflag;
    /**
     * receiverPhone       db_column: receiverPhone 
     */
    private String receiverPhone;
    /**
     * refundStatus       db_column: refundStatus 
     */
    private String refundStatus;//退款状态
    /**
     * string3       db_column: 购买的礼品卡册ID 
     */
    private String string3;
    /**
     * string4       db_column: 换货新生成的子订单对应的退款单号 
     */
    private String string4;
    /**
     * string5       db_column: 申请售后的子订单对应的退款单号 
     */
    private String string5;
    /**
     * string6       db_column: String6 
     */
    private String string6;
    /**
     * string7       db_column: String7 
     */
    private String string7;
    /**
     * string8       db_column: String8 
     */
    private String string8;
    /**
     * string9       db_column: String9 
     */
    private String string9;
    /**
     * string10       db_column: String10 
     */
    private String string10;
    /**
     * 收货人地址       db_column: receiverAddress 
     */
    private String receiverAddress;
    /**
     * 收货人姓名       db_column: receiverName 
     */
    private String receiverName;
    /**
     * 收货人电话       db_column: receiverTel 
     */
    private String receiverTel;
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
    /**
     * 客户id
     */
    private Long customerId;
    /**
     * 实际佣金
     */
    private Double commission;
    /**
     * 实际佣金
     */
    private String commissions;
    /**
     * 应得佣金
     */
    private String commission1;
    /**
     * 应得佣金
     */
    private String commission2;
    /**
     * 应得佣金
     */
    private String commission3;
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
     * 审核备注
     */
    private String content1;
    /**
     * 申请状态，-2删除，-1无效，0未申请，1申请，2审核通过 3已打款
     */
    private Integer status1;
    
	//columns END
    private Product product;//订单对应的产品
    
    /**
     * 订单对应产品的规格
     */
    private ProductOption productOption;
    
    /**
     * 出库时对应的采购价格
     */
    private Double supplyPrice;
    /**
     * 订单对应的库存ID
     */
    private Integer stockLevelDetailId;
    
    /**
     * 未代发货前库存ID
     */
    private Integer  oldStockLevelDetailId;
    
    private StockLevelDetail stockLevelDetail;
    //是否评价 0未评价  1已评价
    private Integer isEvaluate;
    
    public Integer getIsEvaluate() {
		return isEvaluate;
	}

	public void setIsEvaluate(Integer isEvaluate) {
		this.isEvaluate = isEvaluate;
	}

	public ExchangeOrderDetail() {
    }

    public ExchangeOrderDetail(
        Long id
    ) {
        this.id = id;
    }

    

    public ExchangeOrderDetail(
        Long id,
        String orderCode,
        String subOrderCode,
        String customerName,
        String productCode,
        Integer productCount,
        Double price,
        Double discountPrice,
        String orderStatus,
        Integer count,
        String deliveryDate,
        String dropshipYn,
        String partnerCode,
        String auditflag,
        String receiverPhone,
        String refundStatus,
        String string3,
        String string4,
        String string5,
        String string6,
        String string7,
        String string8,
        String string9,
        String string10,
        String receiverAddress,
        String receiverName,
        String receiverTel,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.orderCode = orderCode;
        this.subOrderCode = subOrderCode;
        this.customerName = customerName;
        this.productCode = productCode;
        this.productCount = productCount;
        this.price = price;
        this.discountPrice = discountPrice;
        this.orderStatus = orderStatus;
        this.count = count;
        this.deliveryDate = deliveryDate;
        this.dropshipYn = dropshipYn;
        this.partnerCode = partnerCode;
        this.auditflag = auditflag;
        this.receiverPhone = receiverPhone;
        this.refundStatus = refundStatus;
        this.string3 = string3;
        this.string4 = string4;
        this.string5 = string5;
        this.string6 = string6;
        this.string7 = string7;
        this.string8 = string8;
        this.string9 = string9;
        this.string10 = string10;
        this.receiverAddress = receiverAddress;
        this.receiverName = receiverName;
        this.receiverTel = receiverTel;
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
    
    public String getSubOrderCode() {
        return this.subOrderCode;
    }
    
    public void setSubOrderCode(String value) {
        this.subOrderCode = value;
    }
    
    
    
    public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductCode() {
        return this.productCode;
    }
    
    public void setProductCode(String value) {
        this.productCode = value;
    }
    
    public Integer getProductCount() {
        return this.productCount;
    }
    
    public void setProductCount(Integer value) {
        this.productCount = value;
    }
    
    public Double getPrice() {
    	/*if(this.price==null){
    		this.price = 0.0;
    	}*/
        return this.price;
    }
    
    public void setPrice(Double value) {
        this.price = value;
    }
    
    /**
     * 商品单价
     * @return
     */
    public Double getDiscountPrice() {
        return this.discountPrice;
    }
    
    public void setDiscountPrice(Double value) {
        this.discountPrice = value;
    }
    
    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(String value) {
        this.orderStatus = value;
    }
    
    public Integer getCount() {
        return this.count;
    }
    
    public void setCount(Integer value) {
        this.count = value;
    }
    
    public String getDeliveryDate() {
        return this.deliveryDate;
    }
    
    public void setDeliveryDate(String value) {
        this.deliveryDate = value;
    }
    
    public String getDropshipYn() {
        return this.dropshipYn;
    }
    
    public void setDropshipYn(String value) {
        this.dropshipYn = value;
    }
    
    public String getPartnerCode() {
        return this.partnerCode;
    }
    
    public void setPartnerCode(String value) {
        this.partnerCode = value;
    }
    
    public String getAuditflag() {
        return this.auditflag;
    }
    
    public void setAuditflag(String value) {
        this.auditflag = value;
    }
    
   
    
    public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
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
    
    public String getString6() {
        return this.string6;
    }
    
    public void setString6(String value) {
        this.string6 = value;
    }
    
    public String getString7() {
        return this.string7;
    }
    
    public void setString7(String value) {
        this.string7 = value;
    }
    
    public String getString8() {
        return this.string8;
    }
    
    public void setString8(String value) {
        this.string8 = value;
    }
    
    public String getString9() {
        return this.string9;
    }
    
    public void setString9(String value) {
        this.string9 = value;
    }
    
    public String getString10() {
        return this.string10;
    }
    
    public void setString10(String value) {
        this.string10 = value;
    }
    
    public String getReceiverAddress() {
        return this.receiverAddress;
    }
    
    public void setReceiverAddress(String value) {
        this.receiverAddress = value;
    }
    
    public String getReceiverName() {
        return this.receiverName;
    }
    
    public void setReceiverName(String value) {
        this.receiverName = value;
    }
    
    public String getReceiverTel() {
        return this.receiverTel;
    }
    
    public void setReceiverTel(String value) {
        this.receiverTel = value;
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

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	
	
    
    public Integer getStockLevelDetailId() {
		return stockLevelDetailId;
	}

	public void setStockLevelDetailId(Integer stockLevelDetailId) {
		this.stockLevelDetailId = stockLevelDetailId;
	}

	public Double getSupplyPrice() {
		return supplyPrice;
	}

	public void setSupplyPrice(Double supplyPrice) {
		this.supplyPrice = supplyPrice;
	}
	
	

	public StockLevelDetail getStockLevelDetail() {
		return stockLevelDetail;
	}

	public void setStockLevelDetail(StockLevelDetail stockLevelDetail) {
		this.stockLevelDetail = stockLevelDetail;
	}
	
	

	public Integer getOldStockLevelDetailId() {
		return oldStockLevelDetailId;
	}

	public void setOldStockLevelDetailId(Integer oldStockLevelDetailId) {
		this.oldStockLevelDetailId = oldStockLevelDetailId;
	}

	public Double getTotleWeight(){
    	Double totleWeight = 0.0;
    	if(this.getProduct()!=null && getProduct().getWeight()!=null){
    		totleWeight  = this.getProduct().getWeight()*this.getProductCount();
    	}
    	return totleWeight;
    }

	
	public Double getTotlePrice(){
    	Double totlePrice = 0.0;
    	if(this.getProduct()!=null && getPrice()!=null){
    		totlePrice  = getPrice()*this.getProductCount();
    	}
    	return totlePrice;
    }

	public String getRefundStatusString(){
		return Constant.REFUND_ORDER_STATUS.get(this.refundStatus);
	}

	public Double getSettlePrice() {
		return settlePrice;
	}

	public void setSettlePrice(Double settlePrice) {
		this.settlePrice = settlePrice;
	}

	public Integer getJifenPrice() {
		return jifenPrice;
	}

	public void setJifenPrice(Integer jifenPrice) {
		this.jifenPrice = jifenPrice;
	}

	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}

	public String getExpressCompany() {
		return expressCompany;
	}

	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
	}
	
	public String getCommissions() {
		return commissions;
	}

	public void setCommissions(String commissions) {
		this.commissions = commissions;
	}

	public String getCommission1() {
		return commission1;
	}

	public void setCommission1(String commission1) {
		this.commission1 = commission1;
	}

	public String getCommission2() {
		return commission2;
	}

	public void setCommission2(String commission2) {
		this.commission2 = commission2;
	}

	public String getCommission3() {
		return commission3;
	}

	public void setCommission3(String commission3) {
		this.commission3 = commission3;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public Integer getStatus1() {
		return status1;
	}

	public void setStatus1(Integer status1) {
		this.status1 = status1;
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

		public String getContent1() {
			return content1;
		}

		public void setContent1(String content1) {
			this.content1 = content1;
		}

		public Long getOptionId() {
			return optionId;
		}

		public void setOptionId(Long optionId) {
			this.optionId = optionId;
		}

		public ProductOption getProductOption() {
			return productOption;
		}

		public void setProductOption(ProductOption productOption) {
			this.productOption = productOption;
		}
		
		
	
	    
	
}


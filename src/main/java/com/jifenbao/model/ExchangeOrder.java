/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jifenbao.common.Constant;
import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName ExchangeOrder
 * @Description ExchangeOrder
 *
 * @author liujing
 * @Date 2016-02-25 16:50:37
 * @version 1.0
 *
 */
public class ExchangeOrder extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	// columns START
	/**
	 * id db_column: id
	 */
	private Long id;
	/** id Exclude */
	private Long idEx;
	/**
	 * 订单号 db_column: orderCode
	 */
	private String orderCode;
	
	/**
	 * 订单类型：1：平台订单  2：电影订单 3：运动场馆订单
	 */
	private Integer orderType;
	
	/**
	 * 分享一级佣金的客户id
	 */
	private Long agentId;
	
	/** agentId Exclude */
	private Long agentIdEx;
	/**
	 * 会员id
	 */
	private Long customerId;
	/**
	 * 会员ID db_column: customerName
	 */
	private String customerName;
	/**
	 * 兑换的卡号 db_column: cardCode
	 */
	private String cardCode;
	/**
	 * 是否父订单 db_column: parentYn
	 */
	private String parentYn;
	/**
	 * 父订单id db_column: parentId
	 */
	private Long parentId;
	/**
	 * 兑换方式,J 积分兑换，C 卡号密码兑换 db_column: convertWay
	 */
	private String convertWay;
	/**
	 * 价格，所需积分 db_column: price
	 */
	private Double price;
	/**
	 * 优惠价格 db_column: discountPrice
	 */
	private Double discountPrice;
	/**
	 * 消费的积分价格
	 */
	private Integer jifenPrice;
	/**
	 * 订单状态 db_column: orderStatus
	 */
	private String orderStatus;
	/**
	 * 兑换数量 db_column: count
	 */
	private Integer count;
	/**
	 * 收货人姓名 db_column: receiverName
	 */
	private String receiverName;
	/**
	 * 收货人电话 db_column: receiverTel
	 */
	private String receiverTel;
	/**
	 * receiverStreet db_column: receiverStreet
	 */
	private String receiverStreet;
	/**
	 * receiverProvince db_column: receiverProvince
	 */
	private String receiverProvince;
	/**
	 * receiverCity db_column: receiverCity
	 */
	private String receiverCity;
	/**
	 * 收货人地址 db_column: receiverAddress
	 */
	private String receiverAddress;
	/**
	 * 预约配送日期 db_column: deliveryDate
	 */
	private String deliveryDate;
	
	/**
	 * 预约配送时间 db_column: deliveryDate
	 */
	private String deliveryTime;
	/**
	 * 是否代发货 Y:供应商代发货 N：平台发货 db_column: dropshipYn
	 */
	private String dropshipYn;
	/**
	 * 代发货商CODE db_column: supplierCode
	 */
	private String supplierCode;
	/**
	 * 审核状态 Y:审核通过，N ：审核未通过 db_column: auditflag
	 */
	private String auditflag;
	/**
	 * 备注 db_column: comment
	 */
	private String comment;
	/**
	 * 收货人信息ID db_column: receiverId
	 */
	private Long receiverId;
	/**
	 * auditComment db_column: auditComment
	 */
	private String auditComment;
	/**
	 * receiverCounty db_column: receiverCounty
	 */
	private String receiverCounty;
	/**
	 * receiverPhone db_column: receiverPhone
	 */
	private String receiverPhone;
	/**
	 * refundStatus db_column: refundStatus
	 */
	private String refundStatus;
	/**
	 * 快递公司 db_column: expressCompany
	 */
	private String expressCompany;
	/**
	 * 快递公司号码 db_column: expressNumber
	 */
	private String expressNumber;
	
	/**
     * 401 支付宝 402 微信       db_column: payType 
     */
    private String payType;
    /**
     * 支付时间       db_column: payTime 
     */
    private String payTime;
    /**
     * 交易号       db_column: transId 
     */
    private String transId;
	/**
	 * expressPrice db_column: 快递价格
	 */
	private Double expressPrice;
	/**
	 * sendType db_column: 发货类型
	 */
	private Integer sendType;
	/**
	 * 备货时间 db_column: stockuptime
	 */
	private Date stockuptime;
	/**
	 * 发货时间 db_column: sendtime
	 */
	private Date sendtime;
	/**
	 * 确认收货时间 db_column: confirmtime
	 */
	private Date confirmtime;
	/**
	 * 交易完成时间
	 */
	private Date finishtime;
	/**
	 * refundReason db_column: refundReason
	 */
	private String refundReason;
	/**
	 * wasehouseId db_column: wasehouseId
	 */
	private String wasehouseId;
	/**
	 * 订单对应的库存ID  db_column: oldWasehouseId
	 */
	private Integer oldWasehouseId;
	/**
	 * 订单对应的库存详情ID db_column: stockLevelDetailId
	 */
	private Integer stockLevelDetailId;
	
	 /**
     * 是否为售后订单 Y/N       db_column: afterSalesOrderYn 
     */
    private String afterSalesOrderYn;
    
	/**
	 * string5 db_column: string5
	 */
	private String string5;
	/**
	 * string6 db_column: string6
	 */
	private String string6;
	/**
	 * string7 db_column: String7
	 */
	private String string7;
	/**
	 * string8 db_column: String8
	 */
	private String string8;
	/**
	 * string9 db_column: String9
	 */
	private String string9;
	/**
	 * string10 db_column: String10
	 */
	private String string10;
	/**
	 * 删除标识 db_column: deleteYn
	 */
	private String deleteYn;
	/**
	 * 是否启用 db_column: disabledYn
	 */
	private String disabledYn;
	/**
	 * 创建用户 db_column: createUser
	 */
	private String createUser;
	/**
	 * 创建时间 db_column: createTime
	 */
	private Date createTime;
	/**
	 * 修改用户 db_column: updateUser
	 */
	private String updateUser;
	/**
	 * 修改时间 db_column: updateTime
	 */
	private Date updateTime;
	
	private String orderStatusEx;
	
	private String parentYnEx;
	// columns END

	//// ex//////////////////
	// private String orderStatusString;

	List<ExchangeOrderDetail> orderDetailList;// 子订单列表

	List<OrderLog> orderLogList; // 订单操作日志


	// 查询条件
	private String productTitle;
	
	/**
	 * 快递公司名称
	 */
	private String expressCompanyName;
	
	/**
	 * 快递公司
	 */
	private FreightCompany freightCompany;
	/**
	 * 供应关系
	 */
	private Supplier supplier;
	
	
	
	/*
	 * 仓库
	 */
	private Warehouse warehouse;
	
	/**
	 * 订单所属公司
	 */
	private Company company;
	
	/**
	 * 订单所属公司编码
	 */
	private String companyCode;
	
	/**
	 * 来自PC,移动端消费,1:PC,2:移动端
	 */
	private Integer platform;
	
	private String deliveryDateExSelect;
	
	public String getDeliveryDateExSelect() {
		return deliveryDateExSelect;
	}

	public void setDeliveryDateExSelect(String deliveryDateExSelect) {
		this.deliveryDateExSelect = deliveryDateExSelect;
	}

	public ExchangeOrder() {
	}

	public ExchangeOrder(Long id) {
		this.id = id;
	}

	public ExchangeOrder(Long id, String orderCode, String customerName, String cardCode, String convertWay,
			Double price, Double discountPrice, String orderStatus, Integer count, String receiverName,
			String receiverTel, String receiverStreet, String receiverProvince, String receiverCity,
			String receiverAddress, String deliveryDate, String dropshipYn, String supplierCode, String auditflag,
			String comment, Long receiverId, String auditComment, String receiverCounty, String receiverPhone,
			String refundStatus, String expressCompany, String expressNumber, Double expressPrice, Date stockuptime,
			Date sendtime, Date confirmtime, String refundReason, String wasehouseId, Integer oldWasehouseId, Integer stockLevelDetailId,
			String string5, String string6, String string7, String string8, String string9, String string10,
			String deleteYn, String disabledYn, String createUser, Date createTime, String updateUser,
			Date updateTime) {
		this.id = id;
		this.orderCode = orderCode;
		this.customerName = customerName;
		this.cardCode = cardCode;
		this.convertWay = convertWay;
		this.price = price;
		this.discountPrice = discountPrice;
		this.orderStatus = orderStatus;
		this.count = count;
		this.receiverName = receiverName;
		this.receiverTel = receiverTel;
		this.receiverStreet = receiverStreet;
		this.receiverProvince = receiverProvince;
		this.receiverCity = receiverCity;
		this.receiverAddress = receiverAddress;
		this.deliveryDate = deliveryDate;
		this.dropshipYn = dropshipYn;
		this.supplierCode = supplierCode;
		this.auditflag = auditflag;
		this.comment = comment;
		this.receiverId = receiverId;
		this.auditComment = auditComment;
		this.receiverCounty = receiverCounty;
		this.receiverPhone = receiverPhone;
		this.refundStatus = refundStatus;
		this.expressCompany = expressCompany;
		this.expressNumber = expressNumber;
		this.expressPrice = expressPrice;
		this.stockuptime = stockuptime;
		this.sendtime = sendtime;
		this.confirmtime = confirmtime;
		this.refundReason = refundReason;
		this.wasehouseId = wasehouseId;
		this.oldWasehouseId = oldWasehouseId;
		this.stockLevelDetailId = stockLevelDetailId;
		this.string5 = string5;
		this.string6 = string6;
		this.string7 = string7;
		this.string8 = string8;
		this.string9 = string9;
		this.string10 = string10;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCardCode() {
		return this.cardCode;
	}

	public void setCardCode(String value) {
		this.cardCode = value;
	}

	public String getConvertWay() {
		return this.convertWay;
	}

	public void setConvertWay(String value) {
		this.convertWay = value;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double value) {
		this.price = value;
	}

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

	public String getReceiverStreet() {
		return this.receiverStreet;
	}

	public void setReceiverStreet(String value) {
		this.receiverStreet = value;
	}

	public String getReceiverProvince() {
		return this.receiverProvince;
	}

	public void setReceiverProvince(String value) {
		this.receiverProvince = value;
	}

	public String getReceiverCity() {
		return this.receiverCity;
	}

	public void setReceiverCity(String value) {
		this.receiverCity = value;
	}

	public String getReceiverAddress() {
		return this.receiverAddress;
	}

	public void setReceiverAddress(String value) {
		this.receiverAddress = value;
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

	public String getAuditflag() {
		return this.auditflag;
	}

	public void setAuditflag(String value) {
		this.auditflag = value;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String value) {
		this.comment = value;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public Date getStockuptime() {
		return stockuptime;
	}

	public void setStockuptime(Date stockuptime) {
		this.stockuptime = stockuptime;
	}

	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public Date getConfirmtime() {
		return confirmtime;
	}

	public void setConfirmtime(Date confirmtime) {
		this.confirmtime = confirmtime;
	}

	

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getAuditComment() {
		return this.auditComment;
	}

	public void setAuditComment(String value) {
		this.auditComment = value;
	}

	public String getReceiverCounty() {
		return this.receiverCounty;
	}

	public void setReceiverCounty(String value) {
		this.receiverCounty = value;
	}

	public String getReceiverPhone() {
		return this.receiverPhone;
	}

	public void setReceiverPhone(String value) {
		this.receiverPhone = value;
	}

	public String getRefundStatus() {
		return this.refundStatus;
	}

	public void setRefundStatus(String value) {
		this.refundStatus = value;
	}

	public String getExpressCompany() {
		return this.expressCompany;
	}

	public void setExpressCompany(String value) {
		this.expressCompany = value;
	}

	public String getExpressNumber() {
		return this.expressNumber;
	}

	public void setExpressNumber(String value) {
		this.expressNumber = value;
	}

	

	public String getWasehouseId() {
		return wasehouseId;
	}

	public void setWasehouseId(String wasehouseId) {
		this.wasehouseId = wasehouseId;
	}

	
   

	
	
	public Integer getOldWasehouseId() {
		return oldWasehouseId;
	}

	public void setOldWasehouseId(Integer oldWasehouseId) {
		this.oldWasehouseId = oldWasehouseId;
	}

	public Integer getStockLevelDetailId() {
		return stockLevelDetailId;
	}

	public void setStockLevelDetailId(Integer stockLevelDetailId) {
		this.stockLevelDetailId = stockLevelDetailId;
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

	public Double getExpressPrice() {
		return expressPrice;
	}

	public void setExpressPrice(Double expressPrice) {
		this.expressPrice = expressPrice;
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
		return DateTimeUtil.format(getCreateTime(),
				DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
	}

	public void setCreateTimeString(String value) {
		setCreateTime(
				DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
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
		return DateTimeUtil.format(getUpdateTime(),
				DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
	}

	public void setUpdateTimeString(String value) {
		setUpdateTime(
				DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
	}
	/**
	 * 备货时间
	 * @return
	 */
	public String getStockuptimeString(){
		if(this.getStockuptime()!=null){
			return DateTimeUtil.format(getStockuptime(),
					DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
		}else{
			return "";
		}
	}
	/**
	 * 发货时间
	 * @return
	 */
	public String getSendtimeString(){
		if(this.getSendtime()!=null){
			return DateTimeUtil.format(getSendtime(),
					DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
		}else{
			return "";
		}
	}
	/**
	 * 确认收获时间
	 * @return
	 */
	public String getConfirmtimeString(){
		if(this.getConfirmtime()!=null){
			return DateTimeUtil.format(getConfirmtime(),
					DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
		}else{
			return "";
		}
	}
	/**
	 *  交易完成时间
	 * @return
	 */
	public String getFinishtimeString(){
		if(this.getFinishtime()!=null){
			return DateTimeUtil.format(getFinishtime(),
					DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
		}else{
			return "";
		}
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}

	public List<ExchangeOrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<ExchangeOrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public String getOrderStatusString() {
		String orderStatusString = "";
		if (StringUtils.isNotBlank(orderStatus)) {
			orderStatusString = Constant.ORDER_STATUS.get(orderStatus);
		}
		return orderStatusString;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public List<OrderLog> getOrderLogList() {
		return orderLogList;
	}

	public void setOrderLogList(List<OrderLog> orderLogList) {
		this.orderLogList = orderLogList;
	}

	public String getString10() {
		return string10;
	}

	public void setString10(String string10) {
		this.string10 = string10;
	}

	public String getSupplierCode() {
		return StringUtils.isBlank(supplierCode)?"":supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	
	

	public Double getTotleWeight() {
		Double totleWeight = 0.0;
		if (this.getOrderDetailList() != null && !this.getOrderDetailList().isEmpty()) {
			for (ExchangeOrderDetail detail : this.getOrderDetailList()) {
				totleWeight += detail.getTotleWeight();
			}
		}
		
		return totleWeight;
	}
	
	
	public String getAllProductCode() {
		String productCode = "";
		if (this.getOrderDetailList() != null && !this.getOrderDetailList().isEmpty()) {
			for (ExchangeOrderDetail detail : this.getOrderDetailList()) {
				if( detail.getProduct()!=null)
				   productCode += detail.getProduct().getShowCode()+"("+detail.getProductCount()+"份)"+";";
			}
		}
		if(productCode.endsWith(";")){
			productCode = productCode.substring(0, productCode.length()-1);
			
		}
		return productCode;
	}

	
    
	
	
	public int getProductCount() {
		int productCount = 0;
		if (this.getOrderDetailList() != null && !this.getOrderDetailList().isEmpty()) {
			for (ExchangeOrderDetail detail : this.getOrderDetailList()) {
				if(detail.getProduct()!=null && detail.getProduct().getPrdouctList()!=null && !detail.getProduct().getPrdouctList().isEmpty()){
					for(Product prd:detail.getProduct().getPrdouctList()){
						if(prd.getCount()!=null &&  detail.getProductCount()!=null){
							productCount +=  detail.getProductCount() * prd.getCount();
						}
					}
				}else{
					productCount += detail.getProductCount();
				}
				
			}
		}
		
		return productCount;
	}
	
	public Double getProductTotlePrice() {
		Double price = 0.0;
		if (this.getOrderDetailList() != null && !this.getOrderDetailList().isEmpty()) {
			for (ExchangeOrderDetail detail : this.getOrderDetailList()) {
				if(this.getConvertWay().equals("J")){
					if(detail.getJifenPrice()!=null && detail.getProductCount()!=null){
						price += detail.getJifenPrice()*detail.getProductCount();
					}
					
				}
				
			}
		}
		return price;
	}

	public String getExpressCompanyName() {
		return expressCompanyName;
	}

	public void setExpressCompanyName(String expressCompanyName) {
		this.expressCompanyName = expressCompanyName;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Date getFinishtime() {
		return finishtime;
	}

	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}

	public FreightCompany getFreightCompany() {
		return freightCompany;
	}

	public void setFreightCompany(FreightCompany freightCompany) {
		this.freightCompany = freightCompany;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	
	public String getRefundStatusString(){
		return Constant.REFUND_ORDER_STATUS.get(this.refundStatus);
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getAfterSalesOrderYn() {
		return afterSalesOrderYn;
	}

	public void setAfterSalesOrderYn(String afterSalesOrderYn) {
		this.afterSalesOrderYn = afterSalesOrderYn;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	/**
	 * 订单类型：1：平台订单  2：电影订单 3：运动场馆订单
	 */
	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public Integer getJifenPrice() {
		return jifenPrice;
	}

	public void setJifenPrice(Integer jifenPrice) {
		this.jifenPrice = jifenPrice;
	}


	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getParentYn() {
		return parentYn;
	}

	public void setParentYn(String parentYn) {
		this.parentYn = parentYn;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getOrderStatusEx() {
		return orderStatusEx;
	}

	public void setOrderStatusEx(String orderStatusEx) {
		this.orderStatusEx = orderStatusEx;
	}

	public String getParentYnEx() {
		return parentYnEx;
	}

	public void setParentYnEx(String parentYnEx) {
		this.parentYnEx = parentYnEx;
	}

	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public Long getAgentIdEx() {
		return agentIdEx;
	}

	public void setAgentIdEx(Long agentIdEx) {
		this.agentIdEx = agentIdEx;
	}
	
	public double getTotalCommission(){
		List<ExchangeOrderDetail> list = getOrderDetailList();
		double sum = 0;
		if(list != null && !list.isEmpty()){
			for (ExchangeOrderDetail d : list) {
				Double commission = d.getCommission();
				if(commission == null){
					commission = 0d;
				}
				sum += commission;
			}
		}
		return sum;
	}

	
	
}

/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jifenbao.common.Constant;
import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      Refund
 * @Description
 * Refund
 *
 * @author      liujing
 * @Date        2016-06-08 10:55:28
 * @version     1.0 
 *
 */
public class Refund extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
  //columns START
    /**
     * id       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 订单号       db_column: orderCode 
     */
    private String orderCode;
    /**
     * subOrderCode       db_column: subOrderCode 
     */
    private String subOrderCode;
    /**
     * 退款单号       db_column: refundCode 
     */
    private String refundCode;
    /**
     * 会员名       db_column: customerName 
     */
    private String customerName;
    /**
     * 申请退款时间       db_column: refundTime 
     */
    private Date refundTime;
    /**
     * 退款状态       db_column: refundStatus 
     */
    private String refundStatus;
    /**
     * 退款原因       db_column: refundReason 
     */
    private String refundReason;
    /**
     * 退还积分       db_column: refundPrice 
     */
    private Double refundPrice;
    /**
     * 退款类型（1: 仅退款 2:退换货 （不退款）3：退货（退款）4:补发货）       db_column: refundType 
     */
    private String refundType;
    /**
     * 退款阶段 onsales：卖家未收到货， aftersales:买家已收货       db_column: refundPhase 
     */
    private String refundPhase;
    /**
     * attch1       db_column: attch1 
     */
    private String attch1;
    /**
     * 退款证明2       db_column: attch2 
     */
    private String attch2;
    /**
     * 退款证明3       db_column: attch3 
     */
    private String attch3;
    /**
     * comment       db_column: comment 
     */
    private String comment;
    /**
     * productCode       db_column: productCode 
     */
    private String productCode;
    /**
     * 退还货物的快递公司       db_column: feightCompany 
     */
    private String feightCompany;
    /**
     * 退还货物的快递单号       db_column: feightNum 
     */
    private String feightNum;
    /**
     * 退还商品是否能重新销售       db_column: againSales 
     */
    private String againSales;
    /**
     * string1       db_column: string1 
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
     * string6       db_column: string6 
     */
    private String string6;
    /**
     * string7       db_column: string7 
     */
    private String string7;
    /**
     * string8       db_column: string8 
     */
    private String string8;
    /**
     * string9       db_column: string9 
     */
    private String string9;
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
    /**
     * 订单
     */
    public ExchangeOrder exchangeOrder;
    
    /**
     * 订单详情
     */
    public List<ExchangeOrderDetail> detailList;
    
    /**
     * 补发货或换货产品列表
     */
    public List<Product> productList;

    /**
     * 附件对象1
     */
    public Attch attchObj1;
    /**
     * 附件对象2
     */
    public Attch attchObj2;
    /**
     * 附件对象3
     */
    public Attch attchObj3;

    public Refund() {
    }

    public Refund(
        Integer id
    ) {
        this.id = id;
    }

    

    public Refund(
            Integer id,
            String orderCode,
            String subOrderCode,
            String refundCode,
            String customerName,
            Date refundTime,
            String refundStatus,
            String refundReason,
            Double refundPrice,
            String refundType,
            String refundPhase,
            String attch1,
            String attch2,
            String attch3,
            String comment,
            String productCode,
            String feightCompany,
            String feightNum,
            String string1,
            String string2,
            String string3,
            String string4,
            String string5,
            String string6,
            String string7,
            String string8,
            String string9,
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
            this.refundCode = refundCode;
            this.customerName = customerName;
            this.refundTime = refundTime;
            this.refundStatus = refundStatus;
            this.refundReason = refundReason;
            this.refundPrice = refundPrice;
            this.refundType = refundType;
            this.refundPhase = refundPhase;
            this.attch1 = attch1;
            this.attch2 = attch2;
            this.attch3 = attch3;
            this.comment = comment;
            this.productCode = productCode;
            this.feightCompany = feightCompany;
            this.feightNum = feightNum;
            this.string1 = string1;
            this.string2 = string2;
            this.string3 = string3;
            this.string4 = string4;
            this.string5 = string5;
            this.string6 = string6;
            this.string7 = string7;
            this.string8 = string8;
            this.string9 = string9;
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
    
    public String getRefundCode() {
        return this.refundCode;
    }
    
    public void setRefundCode(String value) {
        this.refundCode = value;
    }
    
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String value) {
        this.customerName = value;
    }
    
    public String getRefundTimeString() {
        return DateTimeUtil.format(getRefundTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setRefundTimeString(String value) {
        setRefundTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getRefundTime() {
        return this.refundTime;
    }
    
    public void setRefundTime(Date value) {
        this.refundTime = value;
    }
    
    public String getRefundStatus() {
        return this.refundStatus;
    }
    
    public void setRefundStatus(String value) {
        this.refundStatus = value;
    }
    
    public String getRefundReason() {
        return this.refundReason;
    }
    
    public void setRefundReason(String value) {
        this.refundReason = value;
    }
    
    public Double getRefundPrice() {
        return this.refundPrice;
    }
    
    public void setRefundPrice(Double value) {
        this.refundPrice = value;
    }
    
    public String getRefundType() {
        return this.refundType;
    }
    
    public void setRefundType(String value) {
        this.refundType = value;
    }
    
    public String getRefundPhase() {
        return this.refundPhase;
    }
    
    public void setRefundPhase(String value) {
        this.refundPhase = value;
    }
    
    public String getAttch1() {
        return this.attch1;
    }
    
    public void setAttch1(String value) {
        this.attch1 = value;
    }
    
    public String getAttch2() {
        return this.attch2;
    }
    
    public void setAttch2(String value) {
        this.attch2 = value;
    }
    
    public String getAttch3() {
        return this.attch3;
    }
    
    public void setAttch3(String value) {
        this.attch3 = value;
    }
    
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String value) {
        this.comment = value;
    }
    
    public String getProductCode() {
        return this.productCode;
    }
    
    public void setProductCode(String value) {
        this.productCode = value;
    }
    
    public String getFeightCompany() {
        return this.feightCompany;
    }
    
    public void setFeightCompany(String value) {
        this.feightCompany = value;
    }
    
    public String getFeightNum() {
        return this.feightNum;
    }
    
    public void setFeightNum(String value) {
        this.feightNum = value;
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
    
    
    

	public List<ExchangeOrderDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<ExchangeOrderDetail> detailList) {
		this.detailList = detailList;
	}

	public ExchangeOrder getExchangeOrder() {
		return exchangeOrder;
	}

	public void setExchangeOrder(ExchangeOrder exchangeOrder) {
		this.exchangeOrder = exchangeOrder;
	}
	
	public String getRefundStatusString(){
		return Constant.REFUND_STATUS.get(this.refundStatus);
	}
	
	
	

	public String getAgainSales() {
		return againSales;
	}

	public void setAgainSales(String againSales) {
		this.againSales = againSales;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public String getOrderRefundStatus(){
    	String refundStatus  = "";
    	if(StringUtils.isNotBlank(this.getRefundType())){
    		if(this.getRefundType().equals("4")){
    			refundStatus = "APPLYED_ADDED";
    		}else if(this.getRefundType().equals("3")){
    			refundStatus = "APPLYED_REFUND";
    		}else if(this.getRefundType().equals("2")){
    			refundStatus = "APPLYED_EXCHANGE";
    		}else if(this.getRefundType().equals("1")){
    			refundStatus = "APPLYED_RETURN";
    		}
    	}
    	return refundStatus;
    }

	public Attch getAttchObj1() {
		return attchObj1;
	}

	public void setAttchObj1(Attch attchObj1) {
		this.attchObj1 = attchObj1;
	}

	public Attch getAttchObj2() {
		return attchObj2;
	}

	public void setAttchObj2(Attch attchObj2) {
		this.attchObj2 = attchObj2;
	}

	public Attch getAttchObj3() {
		return attchObj3;
	}

	public void setAttchObj3(Attch attchObj3) {
		this.attchObj3 = attchObj3;
	}
	
	
	
}


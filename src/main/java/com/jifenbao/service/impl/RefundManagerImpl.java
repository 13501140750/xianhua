/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.common.Constant;
import com.jifenbao.common.DoubleUtil;
import com.jifenbao.common.JfbUtil;
import com.jifenbao.common.WxUtil;
import com.jifenbao.model.CustomerInfo;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.ExchangeOrderDetail;
import com.jifenbao.model.PayOrder;
import com.jifenbao.model.Refund;
import com.jifenbao.model.StockLog;
import com.jifenbao.service.CustomerInfoManager;
import com.jifenbao.service.ExchangeOrderDetailManager;
import com.jifenbao.service.ExchangeOrderManager;
import com.jifenbao.service.OrderLogManager;
import com.jifenbao.service.PayOrderManager;
import com.jifenbao.service.RefundManager;
import com.jifenbao.service.RefundProductManager;
import com.jifenbao.service.StockLevelManager;
import com.jifenbao.thirdAPI.WxPayConfig;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

/**
 *
 * @ClassName      RefundManagerImpl
 * @Description
 * Refund
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Refund对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-06-08 10:55:28
 * @version     1.0 
 *
 */

@Service(RefundManager.BEAN_NAME)
@Transactional
public class RefundManagerImpl extends MybatisServiceImpl<Refund, Integer> implements RefundManager {
    
	@Resource(name = StockLevelManager.BEAN_NAME)
    private StockLevelManager stockLevelManager;
	
	@Resource
	ExchangeOrderManager exchangeOrderManager;
	
	@Resource
	ExchangeOrderDetailManager detailManager;
	
	@Resource
	OrderLogManager orderLogManager;
	
	@Resource
    CustomerInfoManager customerInfoManager;
	
	
	@Resource
	RefundProductManager refundProductManager;
	
	
	@Resource
	PayOrderManager payOrderManager;
	
	/**
	 * 自动生成随机订单号
	 * @return
	 */
	 @Override
	 public String genCode() {
	        String code = JfbUtil.createCode();
	        Refund refund = new Refund();
	        refund.setRefundCode(code);
	        if (this.isExists(refund)) {
	            logger.info("code已存在");
	            return this.genCode();
	        } else {
	            logger.info("code为最新");
	            return code;
	        }
	 }
	
	/**
	 * 新增退款单
	 * @param refund
	 * @param orderId
	 */
	@Override
	@Transactional
	public void addEntity(Refund refund,Long orderId){
		String refundCode = this.genCode();
		refund.setRefundStatus("WAIT_SELLER_AGREE");
		refund.setRefundCode(refundCode);
		refund.setRefundTime(DateTimeUtil.now());
		this.addEntity(refund);
		ExchangeOrder order = new ExchangeOrder();
		order.setId(orderId);
		String refundStatus  = refund.getOrderRefundStatus();
		order.setOrderCode(refund.getOrderCode());
		order.setUpdateTime(DateTimeUtil.now());
		order.setUpdateUser(refund.getCreateUser());
		order.setRefundStatus(refundStatus);
		String info  = "订单"+Constant.REFUND_ORDER_STATUS.get(refundStatus);
		
		order.setOrderStatus(refundStatus);
		orderLogManager.addOrderLog(order, info);
		String subOrderCode = refund.getSubOrderCode();
		if(StringUtils.isNotBlank(subOrderCode)){//退换货修改子订单状态
			ExchangeOrderDetail subOrder = detailManager.getOrderDetailBysubOrderCode(subOrderCode);
			subOrder.setUpdateTime(DateTimeUtil.now());
			subOrder.setUpdateUser(refund.getCreateUser());
			subOrder.setRefundStatus(refundStatus);
			subOrder.setString5(refundCode);
			detailManager.modifyEntity(subOrder);
		}else{//补发货，修改主订单退款状态
			exchangeOrderManager.modifyEntity(order);
		}
		
	}

	@Override
	public void agreeRefund(Refund refund) {
		ExchangeOrder order = refund.getExchangeOrder();
		
		if(refund.getRefundType().equals("4")){//同意补发货生成新订单
			exchangeOrderManager.saveRefundOrder(order);
			ExchangeOrderDetail oldDetail=  new ExchangeOrderDetail();
			oldDetail.setOrderCode(order.getOrderCode());
			refundProductManager.saveExchangeProductInfo(oldDetail, refund);//保存换货信息
			ExchangeOrder newOrder = new ExchangeOrder();
			newOrder.setId(order.getId());
			newOrder.setRefundStatus("SUCCESS");
			newOrder.setUpdateTime(order.getUpdateTime());
			newOrder.setUpdateUser(order.getUpdateUser());
			exchangeOrderManager.modifyEntity(newOrder);
		}else if(refund.getRefundType().equals("3")){//同意退款
			this.backPriceOrCard(refund);
			order.setRefundStatus("SUCCESS");
			detailManager.modifySubOrderRefundStatus(order);
		}else if(refund.getRefundType().equals("2")){//同意换货
			//List<ExchangeOrderDetail> detailList = order.getOrderDetailList();//原子订单
			//List<ExchangeOrderDetail> newList = refund.getDetailList();//新子订单
			
			if(StringUtils.isNotBlank(order.getOrderStatus()) && (order.getOrderStatus().endsWith("WAIT_ADUIT")|| order.getOrderStatus().endsWith("WAIT_SELLER_SEND_GOODS") )){
				refund.setRefundStatus("SUCCESS");
				detailManager.exchangeProduct(order, refund);
			}else{//未发货前申请换货，不用客户退货，直接更换订单中的商品
				order.setRefundStatus("APPLYED_EXCHANGE_AGREE");
				detailManager.modifySubOrderRefundStatus(order);
			}
			
		}else  if(refund.getRefundType().equals("1")){//同意退货
			order.setRefundStatus("APPLYED_RETURN_AGREE");
			detailManager.modifySubOrderRefundStatus(order);
		}
		this.modifyEntity(refund);
	}

	@Override
	public void refuseRefund(Refund refund) {
		ExchangeOrder order = refund.getExchangeOrder();
		List<ExchangeOrderDetail> detailList  = order.getOrderDetailList();
		//String refundStatus  = refund.getRefundStatus();//原退款单状态
		
		ExchangeOrder updateOrder = new ExchangeOrder();
		updateOrder.setId(order.getId());
		updateOrder.setRefundStatus("FAILED");
		updateOrder.setUpdateTime(order.getUpdateTime());
		updateOrder.setUpdateUser(order.getUpdateUser());
		
		if(detailList!=null){
			order.setRefundStatus("FAILED");
			detailManager.modifySubOrderRefundStatus(order);
		}
		refund.setRefundStatus("SELLER_REFUSE_BUYER");
		this.modifyEntity(refund);
		exchangeOrderManager.modifyEntity(updateOrder);
	}

	@Override
	public void receiveGoods(Refund refund) {
		ExchangeOrder order = refund.getExchangeOrder();
		List<ExchangeOrderDetail> detailList  = refund.getDetailList();
		this.modifyEntity(refund);
		order.setRefundStatus("SUCCESS");
		if(refund.getRefundType().equals("1")){//收到退货
			this.backPriceOrCard(refund);
			detailManager.modifySubOrderRefundStatus(order);
		  }else if(refund.getRefundType().equals("2")){//收到退货，重新换货
			
			detailManager.modifySubOrderRefundStatus(order);
			ExchangeOrder newOrder = exchangeOrderManager.copyOrder(order);
			newOrder.setString5(refund.getRefundCode());
			
			if(StringUtils.isNotBlank(refund.getProductCode()) && refund.getProductCode().equals("0")){//原商品
				 detailList   = new ArrayList<ExchangeOrderDetail>();
				 for(ExchangeOrderDetail detail:order.getOrderDetailList()){
					 ExchangeOrderDetail newDetail = new ExchangeOrderDetail();
					 newDetail.setProductCode(detail.getProductCode());
					 newDetail.setProductCount(detail.getProductCount());
					 newDetail.setCount(detail.getCount());
					 newDetail.setSettlePrice(detail.getSettlePrice());
					 newDetail.setPrice(detail.getPrice());
					 detailList.add(newDetail);
				 }
    		}
			newOrder.setOrderDetailList(detailList);
			exchangeOrderManager.saveRefundOrder(newOrder);
			refund.setDetailList(detailList);
			ExchangeOrderDetail  oldDetail = order.getOrderDetailList().get(0);
			refundProductManager.saveExchangeProductInfo(oldDetail, refund);//保存换货信息
			
		  }
		
		//重新入库
		if(StringUtils.isNotBlank(refund.getAgainSales()) && refund.getAgainSales().equals("Y")){//重新入库
			 for(ExchangeOrderDetail detail:order.getOrderDetailList()){
				 String productCode = detail.getProductCode();//商品编码
		        	StockLog stockLog = new StockLog(); 
		        	stockLog.setExchangeOrderCode(order.getOrderCode());
		        	stockLog.setType(0);// 入库
		 	        stockLog.setCreateTime(DateTimeUtil.now());
		 	        stockLog.setCreateUser(refund.getUpdateUser());
		 	        stockLog.setReasonCode("1003");
		            stockLog.setReasonContent("退换货商品重新入库");
		            stockLevelManager.autoStockInOrOut(productCode, detail.getProductCount(), order.getWasehouseId(), stockLog);
			 }
			
			
			
			
		}
		
	}

	@Override
	public void backPriceOrCard(Refund refund) {
		ExchangeOrder bean = refund.getExchangeOrder();
        ExchangeOrder updateBean = new ExchangeOrder();
        updateBean.setId(bean.getId());
       
        updateBean.setUpdateTime(DateTimeUtil.now());
        updateBean.setUpdateUser(bean.getUpdateUser());
        updateBean.setRefundReason(bean.getRefundReason());
        // 如果审核通过，则将订单状态置为“等待卖家发货”
       // 交易关闭,需将卡号置为可用，如是积分需要退还
    
        // 查找会员信息
        CustomerInfo cusInfo = null;
       
        if(bean.getConvertWay().equals("WXPAY")){
            	//微信支付退款,将订单状态设置为
            	ExchangeOrder exchangeOrder = refund.getExchangeOrder();
            	PayOrder payOrder = payOrderManager.findUniqueByProperty("transid", exchangeOrder.getTransId());
            	//订单总金额
            	int totalPrice = (int) (payOrder.getPrice() * 100);
            	//需要退款的金额
            	Double dPrice = exchangeOrder.getOrderDetailList().get(0).getSettlePrice();
            	int refundPrice = (int) (exchangeOrder.getOrderDetailList().get(0).getSettlePrice() * 100);
            	Double refundPrice2 = refund.getRefundPrice();
            	if(refundPrice2!= null){
            		dPrice = refundPrice2;
            		int rPrice = (int) (refundPrice2 * 100);
            		if(rPrice > refundPrice){
            			throw new BusinessException("不能大于商品实收金额");
            		}
            	}
            	refund.setRefundPrice(dPrice);
            	//调用退款方法
            		wechatRefund(payOrder.getTransid(), refund.getRefundCode(), totalPrice, refundPrice);
            		
            	//手动退款
            }else {// 卡号兑换
            	updateBean.setOrderStatus("TRADE_CLOSED");
                String cardCode = bean.getCardCode();
//                cardManager.updateCardExchangeYn(cardCode, "N", bean.getUpdateUser());
            }

        // 添加订单日志信息
        String info = "订单申请售后成功";
        if(bean.getConvertWay().equals("J")){
        	info  += ",并已将"+ refund.getRefundPrice()+"积分退还至客户账户";
        }
        else if(bean.getConvertWay().equals("WXPAY")){
        	info  += ",并已将"+ refund.getRefundPrice()+"元退还至付款账户";
        }
        else if(bean.getConvertWay().equals("C")){
        	info  += ",您可以使用卡号"+ bean.getCardCode()+"重新兑换商品";
        }
        orderLogManager.addOrderLog(bean, info);
        this.update(updateBean);
    
		
	}
	
	/**
     * 退款函数，该方法可以对曾经部分退款的订单进行再次退款
     * @param out_trade_no 商户订单号
     * @param total_fee1 退款对应的订单的总金额（以“元”为单位）
     * @param refund_fee1 计划退款的金额（以“元”为单位）
     * @throws Exception
     */
	@Override
    public Map<String, String>  wechatRefund(String transaction_id, String out_refund_no, int all_total_fee, int refund_fee){
        Refund refund = new Refund();
    	String refundCode = refund.getOrderCode();
    	//组装参数，用户生成统一下单接口的签名  
    	Map<String, String> packageParams = new HashMap<String, String>();
        packageParams.put("appid",WxPayConfig.api_id);
        packageParams.put("mch_id",WxPayConfig.mch_id);
        packageParams.put("op_user_id",WxPayConfig.mch_id);
        packageParams.put("nonce_str", WxUtil.getRandomStringByLength(32));
        packageParams.put("transaction_id", transaction_id);
        packageParams.put("out_refund_no", out_refund_no);
        packageParams.put("total_fee",String.valueOf( all_total_fee));
        packageParams.put("refund_fee", String.valueOf( refund_fee));
        packageParams.put("refund_account", "REFUND_SOURCE_RECHARGE_FUNDS");
        
        
        //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口  
        String sign = WxUtil.sign(packageParams, WxPayConfig.key, "utf-8").toUpperCase();
        packageParams.put("sign", sign);
        String XML = WxUtil.getRequestXml(packageParams);
        try {
        	Map<String, String> result = WxUtil.doRefund(WxPayConfig.refund_url, XML,WxPayConfig.mch_id);
        	if("SUCCESS".equals(result.get("return_code"))){
        		if("SUCCESS".equals(result.get("result_code"))){
        			
        		}else{
        			//结果信息描述
        			throw new BusinessException(result.get("err_code_des"));
        		}
        	}else{
        		throw new BusinessException(result.get("err_code_des"));
        	}
        	return result;
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
    }
    
}

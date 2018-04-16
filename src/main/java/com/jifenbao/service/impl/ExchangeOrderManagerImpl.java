/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.jifenbao.common.Constant;
import com.jifenbao.common.DoubleUtil;
import com.jifenbao.common.JfbUtil;
import com.jifenbao.model.CommissionLevel;
import com.jifenbao.model.CommissionSetting;
import com.jifenbao.model.Company;
import com.jifenbao.model.CustomerInfo;
import com.jifenbao.model.DeliveryAddress;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.ExchangeOrderDetail;
import com.jifenbao.model.PayOrder;
import com.jifenbao.model.Product;
import com.jifenbao.model.ProductOption;
import com.jifenbao.model.StockLevelDetail;
import com.jifenbao.model.StockLog;
import com.jifenbao.model.SystemSetting;
import com.jifenbao.model.Warehouse;
import com.jifenbao.service.CommissionLevelManager;
import com.jifenbao.service.CommissionSettingManager;
import com.jifenbao.service.CompanyCustomizineManager;
import com.jifenbao.service.CompanyManager;
import com.jifenbao.service.CustomerInfoManager;
import com.jifenbao.service.DeliveryAddressManager;
import com.jifenbao.service.ExchangeOrderDetailManager;
import com.jifenbao.service.ExchangeOrderManager;
import com.jifenbao.service.ExpressOrderManager;
import com.jifenbao.service.PayOrderManager;
import com.jifenbao.service.ProductGroupManager;
import com.jifenbao.service.ProductManager;
import com.jifenbao.service.ProductOptionManager;
import com.jifenbao.service.RefundManager;
import com.jifenbao.service.StockLevelDetailManager;
import com.jifenbao.service.StockLevelManager;
import com.jifenbao.service.StockLogManager;
import com.jifenbao.service.SystemSettingManager;
import com.jifenbao.service.WarehouseManager;
import com.otc.framework.common.DataTransferKey;
import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.enums.YesNot;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

/**
 *
 * @ClassName ExchangeOrderManagerImpl
 * @Description ExchangeOrder 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对ExchangeOrder对象的CRUD函数.
 *
 * @author liujing
 * @Date 2016-02-02 14:56:30
 * @version 1.0
 *
 */

@Service(ExchangeOrderManager.BEAN_NAME)
@Transactional
public class ExchangeOrderManagerImpl extends MybatisServiceImpl<ExchangeOrder, Long> implements ExchangeOrderManager {

	@Resource
    ProductManager productManager;
	
	@Resource
    ProductGroupManager groupManager;
	 
    @Resource
    CustomerInfoManager customerInfoManager;

    @Resource
    DeliveryAddressManager deliveryAddressManager;

    @Resource
    ExchangeOrderDetailManagerImpl orderDetailManager;

    @Resource
    OrderLogManagerImpl orderLogManager;

    @Resource(name = ExchangeOrderDetailManager.BEAN_NAME)
    ExchangeOrderDetailManager exchangeOrderDetailManager;

    @Resource(name = StockLogManager.BEAN_NAME)
    StockLogManager stockLogManager;

    @Resource(name = StockLevelManager.BEAN_NAME)
    StockLevelManager stockLevelManager;
    
    @Resource(name = StockLevelDetailManager.BEAN_NAME)
    private StockLevelDetailManager stockLevelDetailManager;
    
    @Resource(name = WarehouseManager.BEAN_NAME)
    private WarehouseManager warehouseManager;
    
    @Resource(name = ExpressOrderManager.BEAN_NAME)
    private ExpressOrderManager expressOrderManager;
    
    @Resource(name = CompanyManager.BEAN_NAME)
    private CompanyManager companyManager;
    
    @Resource(name = CompanyCustomizineManager.BEAN_NAME)
    private CompanyCustomizineManager companyCustomizineManager;
    
    @Resource(name = RefundManager.BEAN_NAME)
    private RefundManager refundManager;
    
    @Resource(name = PayOrderManager.BEAN_NAME)
    private PayOrderManager payOrderManager;
    
    @Resource(name = SystemSettingManager.BEAN_NAME)
    private SystemSettingManager systemSettingManager;
    
    @Resource(name = ProductOptionManager.BEAN_NAME)
    private ProductOptionManager productOptionManager;
    
    

    @Override
    public String genCode() {
        String code = JfbUtil.createCode();
      
        ExchangeOrder order = new ExchangeOrder();
        order.setOrderCode(code);
        if (this.isExists(order)) {
            logger.info("code已存在");
            return this.genCode();
        } else {
            logger.info("code为最新");
            return code;
        }
    }

    @Override
    public String genSubCode() {
        // logger.info("生成code");
        String code = JfbUtil.createCode();
        ExchangeOrderDetail orderDetail = new ExchangeOrderDetail();
        orderDetail.setSubOrderCode(code);
        if (this.isExists(orderDetail)) {
            logger.info("code已存在");
            return this.genSubCode();
        } else {
            logger.info("code为最新");
            return code;
        }
    }
    
    
    @Override
    public ExchangeOrder getExchangeOrderByOrderCode(String orderCode) {
        return (ExchangeOrder) this.findUniqueBy(entityClass.getSimpleName() + ".selectOrderByOrderCode", orderCode);
    }
    
    @Override
    public ExchangeOrder getNoPayOrderByOrderCode(String orderCode) {
        return (ExchangeOrder) this.findUniqueBy(entityClass.getSimpleName() + ".selectNoPayOrderByOrderCode", orderCode);
    }
    
    
    
    
    @SuppressWarnings("unchecked")
	@Override
	public List<ExchangeOrder> exportOrder(Map<String, Object> map) {
		return this.findAll(entityClass.getSimpleName()+".selectByMapForExport", map);
	}

    /*
     * 商城订单处理，用礼品卡册卡号或会员积分支付
     * (non-Javadoc)
     * @see com.jifenbao.service.ExchangeOrderManager#saveOrder(com.jifenbao.model.ExchangeOrder)
     */
    @Override
    public void saveOrder(ExchangeOrder bean) {
    	
    	 CustomerInfo cusInfo = null;
    	 Date now = DateTimeUtil.now();
    	 String userName = "";
    	 // 查找会员信息
         if(StringUtils.isNotBlank(bean.getCustomerName())){
         	userName = bean.getCustomerName();
         }else{
         	userName = bean.getReceiverTel();//会员信息为空时默认用户为手机号
         }
         cusInfo = customerInfoManager.getEntity(bean.getCustomerId());
         
    	 if(StringUtils.isBlank(bean.getConvertWay())){
         	throw new BusinessException("支付方式不存在");
         }
    	
        
        bean.setAuditflag("N");// 默认商家未审核
        
       
    	if(bean.getOrderType()==null || bean.getOrderType()==1){//平台订单
			//组合产品则生成单品子订单
	    	bean.setOrderStatus("WAIT_ADUIT");// 等待商家确认
		}else{
			if(StringUtils.isBlank(bean.getOrderStatus())){
				bean.setOrderStatus("WAIT_BUYER_CONFIRM_GOODS");//商家已发货
			}
		}
    	
    	
        if(bean.getConvertWay().equals("WXPAY") ){//现金订单
        	if(bean.getOrderType()==null || bean.getOrderType()==1){//平台订单
        		bean.setOrderStatus("WAIT_ADUIT");
        		//组合产品则生成单品子订单
    	    	bean = orderDetailManager.getDetailListByProduct(bean);//.setOrderDetailList(orderDetailManager.getDetailListByProduct(bean.getOrderDetailList()));
            	//根据商品所在仓库拆分子订单
//                this.breakUpOrder(bean,cusInfo);
            }
        	this.saveCashPushOrder(bean);
        }
       
    }
    
    
    /**
     * 增加消费记录
     * 如卡兑换，则修改卡兑换信息
     * 如为积分兑换，则增加积分消费记录
     * 如为定制平台卡兑换，则增加定制卡消费记录
     * @param bean
     */
    public void addPayLog(ExchangeOrder bean, CustomerInfo cusInfo){
    	
    	  List<ExchangeOrderDetail>  detailList = bean.getOrderDetailList();
		  Double price = 0.0;
		  Integer jifenPrice = 0;
		  for(ExchangeOrderDetail d:detailList){
			  d.setOrderCode(bean.getOrderCode());
			  Double prdPrice = 0.0;
			  if(d.getPrice()!=null ) prdPrice= d.getPrice();
			  price += (prdPrice * d.getProductCount());
			  orderDetailManager.addDetailOrder(d);//保存子订单
			  if(d.getJifenPrice()!=null) jifenPrice += (d.getJifenPrice() * d.getProductCount() );
			  
		  }
		 
		 bean.setPrice(price);
		 bean.setJifenPrice(jifenPrice);
//		 this.addCardPayLogFromOrder(bean,cusInfo,jifenPrice);
		 this.createNewOrder(bean);//创建主订单
    }
    
    
    
    
    
    
    /*
     * 不拆分订单直接保存订单信息
     * (non-Javadoc)
     * @see com.jifenbao.service.ExchangeOrderManager#saveOrderForNotBreakUpOrder(com.jifenbao.model.ExchangeOrder, com.jifenbao.model.CustomerInfo)
     */
    @Override
	public void saveOrderForNotBreakUpOrder(ExchangeOrder bean, CustomerInfo cusInfo) {
    	this.addPayLog(bean, cusInfo);
	}
    
    /*
     * 通过仓库拆分订单并保存
     * (non-Javadoc)
     * @see com.jifenbao.service.ExchangeOrderManager#BreakUpOrder(com.jifenbao.model.ExchangeOrder)
     */
	@Override
	public void breakUpOrder(ExchangeOrder bean, CustomerInfo cusInfo) {
		 
		 List<ExchangeOrderDetail> orderDetailList = bean.getOrderDetailList();
		 Map<String,ExchangeOrder> orderMap = new HashMap<String,ExchangeOrder>();
		 if(orderDetailList!=null && !orderDetailList.isEmpty()){
			  List<ExchangeOrder> orderList = new ArrayList<ExchangeOrder>();
			  for(ExchangeOrderDetail detail:orderDetailList){//循环子订单
				  detail = this.getDeatilFromOrder(detail,bean);
				  Product product =  productManager.findUniqueByProperty("code", detail.getProductCode());
				  Integer wasehouseid = null;
				  Map<String, Object> map = new HashMap<String, Object>();
				  if(StringUtils.isNotBlank(product.getDefalutWarehouse())){
					  wasehouseid = Integer.parseInt(product.getDefalutWarehouse());
					  map.put("warehouseId", wasehouseid);
				  }
				 
				  map.put("productCode", detail.getProductCode());
				  StockLevelDetail levelDetail = stockLevelDetailManager.getStockDetailByProduct(map);
				  //StockLevel level = stockLevelManager.getStockLevelByProduct(map);
				  
				  if(levelDetail==null || levelDetail.getId()==null){
					  levelDetail = stockLevelManager.addStockLevelByProduct(product);
				  }
				 
				 wasehouseid = levelDetail.getStockLevel().getWarehouseId();
				 bean.setSupplierCode(levelDetail.getStockLevelId()+"");
				
				 
				  
				  if(wasehouseid==null){
					  Company company = companyManager.findUniqueByProperty("code", Constant.JIYUN_COMPANY_CODE);
					  if(company.getDefaultWarehouseCode()!=null){
						  wasehouseid = Integer.parseInt(company.getDefaultWarehouseCode());
					  }
				  }
				  bean.setWasehouseId(wasehouseid.toString());
				  bean.setOldWasehouseId(wasehouseid);
				  detail.setStockLevelDetailId(levelDetail.getId());
				  detail.setOldStockLevelDetailId(levelDetail.getId());
				  
				  if(this.isNotExWaseId(orderList, wasehouseid)){//新的仓库则添加一个订单
					  String orderCode = this.genCode();
					  bean.setOrderCode(orderCode);
					  ExchangeOrder newOrder = this.copyOrder(bean);
					  orderList.add(newOrder);
					  detail.setOrderCode(orderCode);
//					  bean.setOrderDetailList(orderDetailList);
					  List<ExchangeOrderDetail> detailList = new ArrayList<ExchangeOrderDetail>();
					  detailList.add(detail);
					  newOrder.setOrderDetailList(detailList);
					  orderMap.put(orderCode, newOrder);
					  //orderDetailManager.addEntity(detail);
					}else{//
						 for(ExchangeOrder order:orderList){
								if(order.getWasehouseId().equals(wasehouseid+"")){
									ExchangeOrder exsitOrder =  orderMap.get(order.getOrderCode());
									List<ExchangeOrderDetail> detailList = exsitOrder.getOrderDetailList();
									detailList.add(detail);
									//detail.setOrderCode(order.getOrderCode());
									//orderDetailManager.addEntity(detail);
									break;
								}
							}
					 }
			  }
			  //保存订单信息
			  if(orderMap!=null){
				  for(String orderCode:orderMap.keySet()){
					  ExchangeOrder saveOrder =  orderMap.get(orderCode);
					  this.addPayLog(saveOrder, cusInfo);
				  }
			  }
		  }else{
			  throw new BusinessException("订单异常");
		  }
	
	}
	
	public boolean isNotExWaseId(List<ExchangeOrder> orderList,Integer wasehouseid){
		if(orderList==null || orderList.isEmpty()){
			return true;
		}else if(wasehouseid==null){
			return true;
		}else{
			for(ExchangeOrder order:orderList){
				if(order.getWasehouseId()!=null && order.getWasehouseId().equals(wasehouseid.toString())){
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public ExchangeOrder copyOrder(ExchangeOrder order){
        ExchangeOrder newOrder = new ExchangeOrder();
        if(StringUtils.isBlank(order.getOrderCode())){
			String newOrderCode = this.genCode();
			newOrder.setOrderCode(newOrderCode);
		}else{
			newOrder.setOrderCode(order.getOrderCode());
		}
        newOrder.setParentYn(order.getParentYn());
        newOrder.setJifenPrice(order.getJifenPrice());
        newOrder.setPlatform(order.getPlatform());
        newOrder.setCompanyCode(order.getCompanyCode());
		newOrder.setCardCode(order.getCardCode());
        newOrder.setOrderStatus("WAIT_ADUIT");// 等待商家确认
        newOrder.setAuditflag("Y");// 默认商家未审核
        newOrder.setCreateTime(DateTimeUtil.now());
        newOrder.setCreateUser(order.getCreateUser());
        newOrder.setConvertWay(order.getConvertWay());// 卡号兑换
        newOrder.setReceiverStreet(order.getReceiverStreet());
        newOrder.setReceiverAddress(order.getReceiverAddress());
        newOrder.setReceiverCity(order.getReceiverCity());
        newOrder.setReceiverCounty(order.getReceiverCounty());
        newOrder.setReceiverProvince(order.getReceiverProvince());
        newOrder.setReceiverId(order.getReceiverId());
        newOrder.setCustomerName(order.getCustomerName());
        newOrder.setCustomerId(order.getCustomerId());
        if(StringUtils.isNotBlank(order.getWasehouseId()) ){
        	Warehouse hose = warehouseManager.getEntity(Integer.parseInt(order.getWasehouseId()));
        	if(hose.getType()!=0){//不是自有仓库则需要代发货
        		newOrder.setDropshipYn("Y");
        	}else{
        		newOrder.setDropshipYn("N");
        	}
        }
        newOrder.setPayTime(order.getPayTime());
        newOrder.setPayType(order.getPayType());
        newOrder.setTransId(order.getTransId());
        newOrder.setWasehouseId(order.getWasehouseId());
        newOrder.setOldWasehouseId(order.getOldWasehouseId());
        newOrder.setStockLevelDetailId(order.getStockLevelDetailId());
        newOrder.setSupplierCode(order.getSupplierCode());
        newOrder.setReceiverName(order.getReceiverName());
        newOrder.setReceiverPhone(order.getReceiverPhone());
        newOrder.setReceiverTel(order.getReceiverTel());
        newOrder.setDeliveryDate(order.getDeliveryDate());
        newOrder.setDisabledYn(YesNot.NOT.getCode());
        newOrder.setDeleteYn(YesNot.NOT.getCode());
        newOrder.setComment(order.getComment());
        newOrder.setCreateTime(order.getCreateTime());
        newOrder.setCreateUser(order.getCreateUser());
        newOrder.setUpdateTime(order.getCreateTime());
        newOrder.setUpdateUser(order.getUpdateUser());
        newOrder.setOrderType(order.getOrderType());
        newOrder.setPrice(order.getPrice());
        newOrder.setDiscountPrice(order.getDiscountPrice());
        
        return newOrder;
	
	}
	
	
	/**
	 * 通过主订单创建一个同样的主订单
	 * @param bean
	 */
	public ExchangeOrder createNewOrder(ExchangeOrder order){
		ExchangeOrder newOrder = new ExchangeOrder();
		if(StringUtils.isBlank(order.getOrderCode())){
			String newOrderCode = this.genCode();
			newOrder.setOrderCode(newOrderCode);
		}else{
			newOrder.setOrderCode(order.getOrderCode());
		}
		newOrder.setJifenPrice(order.getJifenPrice());
		newOrder.setPlatform(order.getPlatform());
		newOrder.setOrderType(order.getOrderType());
		newOrder.setCardCode(order.getCardCode());
		newOrder.setParentYn(order.getParentYn());
		newOrder.setParentId(order.getParentId());
        newOrder.setCompanyCode(order.getCompanyCode());
        newOrder.setConvertWay(order.getConvertWay());// 卡号兑换
        newOrder.setReceiverStreet(order.getReceiverStreet());
        newOrder.setReceiverAddress(order.getReceiverAddress());
        newOrder.setReceiverCity(order.getReceiverCity());
        newOrder.setReceiverCounty(order.getReceiverCounty());
        newOrder.setReceiverProvince(order.getReceiverProvince());
        newOrder.setReceiverId(order.getReceiverId());
        newOrder.setCustomerName(order.getCustomerName());
        newOrder.setCustomerId(order.getCustomerId());
        if(StringUtils.isNotBlank(order.getWasehouseId()) ){
        	Warehouse hose = warehouseManager.getEntity(Integer.parseInt(order.getWasehouseId()));
        	if(hose.getType()!=0){//不是自有仓库则需要代发货
        		newOrder.setDropshipYn("Y");
        	}else{
        		newOrder.setDropshipYn("N");
        	}
        }
        newOrder.setPayTime(order.getPayTime());
        newOrder.setPayType(order.getPayType());
        newOrder.setTransId(order.getTransId());
        newOrder.setWasehouseId(order.getWasehouseId());
        newOrder.setOldWasehouseId(order.getOldWasehouseId());
        newOrder.setStockLevelDetailId(order.getStockLevelDetailId());
        newOrder.setSupplierCode(order.getSupplierCode());
        newOrder.setReceiverName(order.getReceiverName());
        newOrder.setReceiverPhone(order.getReceiverPhone());
        newOrder.setReceiverTel(order.getReceiverTel());
        newOrder.setDeliveryDate(order.getDeliveryDate());
        newOrder.setComment(order.getComment());
        newOrder.setPrice(order.getPrice());
        newOrder.setDiscountPrice(order.getDiscountPrice());
        newOrder.setOrderStatus("WAIT_ADUIT");// 等待商家确认
        newOrder.setAuditflag("N");// 默认商家未审核
        newOrder.setCreateTime(DateTimeUtil.now());
        newOrder.setCreateUser(order.getCreateUser());
        newOrder.setUpdateTime(order.getCreateTime());
        newOrder.setUpdateUser(order.getUpdateUser());
        newOrder.setDisabledYn(YesNot.NOT.getCode());
        newOrder.setDeleteYn(YesNot.NOT.getCode());
        this.addEntity(newOrder);// 新建主订单
        
        // 添加订单日志信息
	    orderLogManager.addOrderLog(newOrder);
        return newOrder;
	}

	/**
	 * 通过主订单保存子订单订单
	 * @param detail
	 * @param bean
	 * @return
	 */
	@Override
	public  ExchangeOrderDetail getDeatilFromOrder(ExchangeOrderDetail detail,ExchangeOrder bean){
		String address = "";
		if(StringUtils.isNotBlank(bean.getReceiverProvince())){
			address +=bean.getReceiverProvince() ;
		}
		if(StringUtils.isNotBlank(bean.getReceiverCity())){
			address +=bean.getReceiverCity() ;
		}
		if(StringUtils.isNotBlank(bean.getReceiverAddress())){
			address +=bean.getReceiverAddress() ;
		}
		
		Date now = DateTimeUtil.now();
		
		//detail.setPrice(detail.getPrice());
		//detail.setJifenPrice(detail.getJifenPrice());
		detail.setCustomerId(bean.getCustomerId());
		detail.setCustomerName(bean.getCustomerName());
        detail.setReceiverTel(bean.getReceiverTel());
        detail.setReceiverName(bean.getReceiverName());
        detail.setReceiverAddress(address);
        detail.setDisabledYn(YesNot.NOT.getCode());
        detail.setDeleteYn(YesNot.NOT.getCode());
        detail.setCreateTime(now);
        detail.setUpdateTime(now);
        detail.setCreateUser(bean.getCreateUser());
        detail.setUpdateUser(bean.getUpdateUser());
        String subCode = exchangeOrderDetailManager.genSubCode();
        detail.setSubOrderCode(subCode);// 子订单编号
        detail.setString3(detail.getString3());
		return detail;
	}

    /**
     * 新增会员收获地址信息
     * 
     * @param customerId
     * @param bean
     */
    public Long saveReceiveInfo(ExchangeOrder bean,Long customerId) {
        Date now = DateTimeUtil.now();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("customerId", customerId);
        map.put("cityName", bean.getReceiverCity());
        map.put("provinceName", bean.getReceiverProvince());
        map.put("name", bean.getReceiverName());
        map.put("tel",bean.getReceiverTel());
        map.put("phone",bean.getReceiverPhone());
        map.put("street",bean.getReceiverStreet());
        //map.put("address",bean.getReceiverAddress());
       // map.put("deliveryDate", bean.getDeliveryDate());
        map.put("disabledYn", YesNot.NOT.getCode());
        map.put("deleteYn", YesNot.NOT.getCode());
        
        List<DeliveryAddress> list = deliveryAddressManager.findByMap(map);
        if(list!=null && !list.isEmpty()){//该地址以前配送过，则返回该地址id
        	return list.get(0).getId();
        }else{
        	DeliveryAddress receive = new DeliveryAddress();// 新增会员收获信息
        	receive.setCustomerId(customerId);//.setCustomerName(bean.getCustomerName());
            receive.setCityName(bean.getReceiverCity());
            receive.setProvinceName(bean.getReceiverProvince());
            receive.setCountyName(bean.getReceiverCounty());
            receive.setName(bean.getReceiverName());
            receive.setTel(bean.getReceiverTel());
            receive.setPhone(bean.getReceiverPhone());
            receive.setStreetName(bean.getReceiverStreet());
            receive.setAddress(bean.getReceiverAddress());
            receive.setDeliveryDate(bean.getDeliveryDate());
        	receive.setDisabledYn(YesNot.NOT.getCode());
            receive.setDeleteYn(YesNot.NOT.getCode());
            receive.setCreateTime(now);
            receive.setCreateUser(bean.getCreateUser());
            deliveryAddressManager.addEntity(receive);
            return receive.getId();
        }
        
       
    }


    @Override
    public void auditOrder(ExchangeOrder bean) {
    	String orderStatus = bean.getOrderStatus();
        ExchangeOrder updateBean = new ExchangeOrder();
        updateBean.setId(bean.getId());
        updateBean.setAuditflag(bean.getAuditflag());
        updateBean.setUpdateTime(DateTimeUtil.now());
        updateBean.setUpdateUser(bean.getUpdateUser());
        updateBean.setRefundReason(bean.getRefundReason());
        // 如果审核通过，则将订单状态置为“等待卖家发货”
        if (bean.getAuditflag().equals("Y")) {
            updateBean.setOrderStatus("WAIT_SELLER_SEND_GOODS");
            bean.setOrderStatus("WAIT_SELLER_SEND_GOODS");
            updateBean.setStockuptime(DateTimeUtil.now());
        } else {
        	//交易关闭
        	updateBean.setOrderStatus("TRADE_CLOSED");
        }

        // 添加订单日志信息
        this.update(updateBean);
        bean = this.findUniqueByProperty("orderCode", bean.getOrderCode());
        orderLogManager.addOrderLog(bean);
        if (!bean.getAuditflag().equals("Y")){
        	
        	if(!"NOT_PAY".equals(orderStatus)){
        		//退钱//微信支付退款,将订单状态设置为
        		if(StringUtils.isNotBlank(bean.getTransId())){
        			PayOrder payOrder = payOrderManager.findUniqueByProperty("transid", bean.getTransId());
            		//订单总金额
            		int totalPrice = (int)(payOrder.getPrice() * 100);
            		//需要退款的金额
            		//防止拆弹金额错误,判断下
            		Double total = 0.00;
            		for (ExchangeOrderDetail detail : bean.getOrderDetailList()) {
            			total = DoubleUtil.add(detail.getSettlePrice(), total);
            		}
            		if(total.equals(bean.getPrice())){
            			
            			//金额没问题,调用退款方法
            			refundManager.wechatRefund(payOrder.getTransid(), "QX" + bean.getOrderCode(), totalPrice, (int) (total*100));
            			
            		}else{
            			throw new BusinessException("订单详情金额总和和订单金额不对应,请联系管理员");
            		}
        		}
        		
        	}
        }
    }

    @Override
    public void operOrder(ExchangeOrder bean) {
        ExchangeOrder updateBean = new ExchangeOrder();
        updateBean.setId(bean.getId());
        // updateBean.setAuditflag(bean.getAuditflag());
        updateBean.setAuditComment(bean.getAuditComment());
        updateBean.setStockuptime(bean.getStockuptime());
        updateBean.setSendtime(bean.getSendtime());
        updateBean.setUpdateTime(DateTimeUtil.now());
        updateBean.setConfirmtime(bean.getConfirmtime());
        updateBean.setUpdateUser(bean.getUpdateUser());
        updateBean.setOrderStatus(bean.getOrderStatus());// 等待商家发货
        updateBean.setWasehouseId(bean.getWasehouseId());
        updateBean.setOldWasehouseId(bean.getOldWasehouseId());
        updateBean.setSupplierCode(bean.getSupplierCode());
        updateBean.setExpressCompany(bean.getExpressCompany());
        updateBean.setExpressNumber(bean.getExpressNumber());
        updateBean.setExpressPrice(bean.getExpressPrice());
        updateBean.setDropshipYn(bean.getDropshipYn());
        this.update(updateBean);// 修改订单状态
        // 增加订单操作信息
        //orderLogManager.addOrderLog(bean);
        // 点击发货操作增加产品出库信息，并添加快递信息
        if(bean.getOrderStatus().equals("WAIT_BUYER_CONFIRM_GOODS")){
        	this.addStockLog(bean);
        }
    }
    
    
    @Override
	public void operOrder(ExchangeOrder bean, boolean addLogFlag) {
		// TODO Auto-generated method stub
		this.operOrder(bean);
		if(addLogFlag){
			// 增加订单操作信息
	        orderLogManager.addOrderLog(bean);
		}
	}

    

    @Override
    public void operOrder(ExchangeOrder bean, String subOrderCode) {
        String orderCode = bean.getOrderCode();
        ExchangeOrder order = this.findUniqueByProperty("orderCode", orderCode);// 主订单
        ExchangeOrderDetail detail = orderDetailManager.findUniqueByProperty("subOrderCode", subOrderCode);
        
        List<ExchangeOrderDetail> orderDetailList = orderDetailManager.getOrderDetailByOrderCode(orderCode);
        
        if(!orderDetailList.isEmpty() && orderDetailList.size()==1){
		    //当前订单只有一个子订单，则将该主订单修改为代发货订单
			this.operOrder(order,false);//不用增加日志信息
		 }else{
			ExchangeOrder newOrder = this.createNewOrder(order)  ;//创建一个新的主订单
			detail.setOrderCode(newOrder.getOrderCode());//将需要原子订单对应的新的主订单上。原主订单不变
			orderLogManager.addOrderLog(newOrder);
		 }
       
         
       
    }

   

  
	
    @SuppressWarnings("all")
	/**
	 * 代发货,修改主订单的仓库信息，同时修改子订单对应的stockleveldetailid
	 * @param bean
	 * @param subOrderCoed 当前需要代发货的子订单
	 */
	@Override
	public void dropship(ExchangeOrder bean,String subOrderCoed){
		ExchangeOrder order = this.findUniqueByProperty("orderCode", bean.getOrderCode());// 主订单
		ExchangeOrderDetail detail = orderDetailManager.getOrderDetailBysubOrderCode(subOrderCoed);//当前需要操作的子订单
		String wasehoseId  = bean.getWasehouseId();
		if(StringUtils.isNotBlank(order.getWasehouseId())){//原仓库不为空
			order.setOldWasehouseId(Integer.parseInt(order.getWasehouseId()));//老仓库
		}
		order.setWasehouseId(wasehoseId);//新仓库ID
		List<ExchangeOrderDetail> detailList = orderDetailManager.getOrderDetailByOrderCode(order.getOrderCode());
		String info = "";
		if(StringUtils.isNotBlank(wasehoseId)){//仓库有改变
        	Warehouse  ware =   warehouseManager.getEntity(Integer.parseInt(wasehoseId));//新仓库
            if(ware.getType()==0){//只是传给平台其它仓库发货
            	info = "商品由平台转给:"+ware.getName() +"仓库发货";
            	order.setDropshipYn("N");
            }else{
            	info = "商品由平台转给供应商仓库发货，仓库名称:"+ware.getName() ;
            	order.setDropshipYn("Y");
            }
		}
		
		//for(ExchangeOrderDetail detail:order.getOrderDetailList()){//子订单
		
		
		if(!detailList.isEmpty() && detailList.size()==1){
		    //当前订单只有一个子订单，则将该主订单修改为代发货订单
			this.operOrder(order,false);//不用增加日志信息
	        orderLogManager.addOrderLog(order, info);
		 }else{
			order.setOrderCode(null);
			ExchangeOrder newOrder = this.createNewOrder(order)  ;//创建一个新的主订单
			
			//设置新订单的总积分
			newOrder.setPrice(detail.getPrice());
			newOrder.setJifenPrice(detail.getJifenPrice());
			this.modifyEntity(newOrder);
			detail.setOrderCode(newOrder.getOrderCode());//将需要代发货的子订单对应的新的主订单上。原主订单不变
			orderLogManager.addOrderLog(newOrder, info);
			
			
			//操作代发货,将原订单总积分减去代发货金额
			ExchangeOrder exchangeOrder = new ExchangeOrder();
			exchangeOrder.setId(order.getId());
			exchangeOrder.setPrice(order.getPrice() - detail.getPrice());
//			exchangeOrder.setJifenPrice(order.getJifenPrice() - detail.getJifenPrice());
			this.modifyEntity(exchangeOrder);
			
			
		 }
		 orderDetailManager.modifyEntity(detail);//修改子订单
		
	}

	/*
	 * 供应商转回平台发货
	 * (non-Javadoc)
	 * @see com.jifenbao.service.ExchangeOrderManager#backship(com.jifenbao.model.ExchangeOrder, java.lang.String)
	 */
	@Override
	public void backship(ExchangeOrder bean, String subOrderCoed) {

		ExchangeOrder order = this.findUniqueByProperty("orderCode", bean.getOrderCode());// 主订单
		ExchangeOrderDetail detail = orderDetailManager.getOrderDetailBysubOrderCode(subOrderCoed);//当前需要操作的子订单
		String info = "";
		String productCode = detail.getProductCode();//商品编码
		order.setDropshipYn("N");
		//order.setWasehouseId(order.getOldWasehouseId()+"");//原来的仓库
		if(StringUtils.isNotBlank(order.getWasehouseId()) && order.getWasehouseId().equals(order.getOldWasehouseId()+"")){//原仓库id=现在的仓库ID，则是默认代发货不是平台转过去的
        	Warehouse  ware =   warehouseManager.getEntity(Integer.parseInt(order.getWasehouseId()));
            Map<String, Object> map = new HashMap<String, Object>();
    		map.put("productCode", productCode);
    		map.put("type", "0");
    		StockLevelDetail levelDetail = stockLevelDetailManager.getStockDetailByProduct(map);//查询该产品所在平台仓库
    		
    		if(levelDetail!=null && levelDetail.getStockLevel()!=null && levelDetail.getStockLevel().getWarehouse()!=null){
    			order.setSupplierCode(levelDetail.getSupplierId()+"");
    			order.setOldWasehouseId(Integer.parseInt(order.getWasehouseId()));
    			order.setWasehouseId(levelDetail.getStockLevel().getWarehouseId()+"");//当前仓库
    			detail.setStockLevelDetailId(levelDetail.getId());
    			info = "商品由供应商从"+ware.getName()+"转到平台"+ levelDetail.getStockLevel().getWarehouse().getName() +"发货";
    		}else{
    			throw new BusinessException("商品由供应商转回平台发货，该发货仓库暂时无该产品,请先添加该产品的库存商品记录");
    		}
    		
		}else{
			Warehouse  ware =   warehouseManager.getEntity(Integer.parseInt(order.getWasehouseId()));
			Warehouse  ware2 =   warehouseManager.getEntity(order.getOldWasehouseId());
			info = "商品由仓库:"+ware.getName() +"转回平台"+ware2.getName()+"发货";
			order.setWasehouseId(order.getOldWasehouseId()+"");
			detail.setStockLevelDetailId(detail.getOldStockLevelDetailId());
		}
		
		
		List<ExchangeOrderDetail> detailList = orderDetailManager.getOrderDetailByOrderCode(order.getOrderCode());
		if(!detailList.isEmpty() && detailList.size()==1){
		    //当前订单只有一个子订单，则将该主订单修改为代发货订单
			this.operOrder(order,false);//不用增加日志信息
	        orderLogManager.addOrderLog(order, info);
		 }else{
			ExchangeOrder newOrder = this.createNewOrder(order)  ;//创建一个新的主订单
			detail.setOrderCode(newOrder.getOrderCode());//将需要代发货的子订单对应的新的主订单上。原主订单不变
		 }
		 orderDetailManager.modifyEntity(detail);//修改子订单
		
	
		
	}

	@Override
	public ExchangeOrder getExchangeOrderByCardCode(String cardCode) {
		 ExchangeOrder order = new ExchangeOrder();
	     order = (ExchangeOrder) this.findUniqueBy(entityClass.getSimpleName() + ".selectOrderByCardCode", cardCode);
	     return order;
	}

	
	@Resource(name = CommissionLevelManager.BEAN_NAME)
	private CommissionLevelManager commissionLevelManager;
	
	@Resource(name = CommissionSettingManager.BEAN_NAME)
	private CommissionSettingManager commissionSettingManager;
	
	
	
	/**
	 * 保存现金订单
	 * @param bean
	 */
	 @SuppressWarnings("all")
	public void saveCashPushOrder(ExchangeOrder bean){
		
		Map<String, Object> commissions = new HashMap<String, Object>();
		
		if(bean.getCustomerId() == null){
			throw new BusinessException("用户id为空");
		}
//		CustomerInfo customer = customerInfoManager.getEntity(bean.getAgentId());
		
		List<ExchangeOrderDetail> orderDetailList = bean.getOrderDetailList();
		if(orderDetailList == null || orderDetailList.isEmpty()){
			throw new BusinessException("订单商品为空");
		}
		
    	String orderCode = this.genCode();
    	Double price = 0.0;
    	
		//属于分销订单
		if(bean.getAgentId() != null && bean.getAgentId() > 0){
			//获得分销商等级信息
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
			map.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
			List<CommissionLevel> levels = commissionLevelManager.findByMap(map);
			
			CommissionSetting setting = commissionSettingManager.getConfig();
			//是否开启分销,几级
			Integer level = setting.getLevel();
			if(level == 0){
				bean.setAgentId(0L);
			}else{
				try {
					
				//1级分销
				CustomerInfo parent = null;
				CommissionLevel commissionLevel1 = null;
				
				parent = customerInfoManager.getEntity(bean.getAgentId());
					
				Double rebate = 0.00;
				//如果是审核过的
				if("1".equals(parent.getStatus()) && "1".equals(parent.getAgentYn())){
					//查询这个客户当前的分销等级
					if(parent.getAgentLevel() == 0){
						map.put("defaultYn", "1");
						List<CommissionLevel> list = commissionLevelManager.findByMap(map);
						if(list != null && list.size() > 0){
							CommissionLevel defaultLevel = list.get(0);
							
							rebate = defaultLevel.getCommission1();
						}else{
							throw new BusinessException("没有查找到默认等级信息");
						}
					}
					
				}else{
					//没审核的按默认设置的返利来计算
					map.clear();
					map.put(DataTransferKey.DELETE_YN, "N");
					map.put(DataTransferKey.DISABLED_YN, "N");
					map.put("systemKey", "rebate");
					List<SystemSetting> list2 = systemSettingManager.findByMap(map);
					
					if(list2 != null && list2.size() > 0){
						SystemSetting systemSetting = list2.get(0);
						String systemValue = systemSetting.getSystemValue();
						rebate = Double.parseDouble(systemValue);
					}else{
						throw new BusinessException("找不到默认的未审核返利配置信息");
					}
				}
					
					
				 for(ExchangeOrderDetail detail:orderDetailList){
					  String level1 = "";
					  String level2 = "";
					  String level3 = "";
					  
					  Product product = productManager.findUniqueByProperty("code", detail.getProductCode());
					  //如果没有设置产品的分销金额,走分销等级设置的比例
					  if(true){
						  
					  }
					  
					  //一级分销
					  if(level >= 1){
						 Map<String, Object> jMap = new HashMap<String, Object>();
						 
						//计算1级分销应得佣金
						 for (CommissionLevel item : levels) {
							 Double commission1 = DoubleUtil.mul(DoubleUtil.divide(item.getCommission1(), 100.0, 2), product.getSalesPrice());
							 jMap.put("1".equals(item.getDefaultYn())?"default":"level" + item.getId(), commission1);
						}
						 detail.setCommission1(JSONObject.toJSONString(jMap));;
						 jMap.clear();
						 
						 
						 
						 //计算实际佣金
						 Double mul = DoubleUtil.mul(DoubleUtil.divide(rebate, 100.0, 2), product.getSalesPrice());
						 
						 jMap.put("level1", mul);
						 
						 detail.setCommissions(JSONObject.toJSONString(jMap));
						 detail.setCommission(mul);
						 
						 
					  }
					  
					  detail = this.getDeatilFromOrder(detail,bean);
					  detail.setOrderCode(orderCode);
					  detail.setSettlePrice(detail.getPrice());
				      orderDetailManager.addEntity(detail);
				      if(detail.getPrice()!=null)
				        price += detail.getPrice()*detail.getProductCount();
			      }
				      
				
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				
		}else{
			  for(ExchangeOrderDetail detail:orderDetailList){
				  Product product = productManager.findUniqueByProperty("code", detail.getProductCode());
				  //有规格按规格价格保存
				  if("1".equals(product.getHasoption()) && detail.getOptionId() != null && detail.getOptionId() > 0){
					  ProductOption option = productOptionManager.getEntity(detail.getOptionId());
					  if(!product.getCode().equals(option.getProductCode())){
						  throw new BusinessException("规格id和商品code不一致");
					  }
					  detail.setPrice(option.getProductPrice());
					  detail.setSettlePrice(option.getProductPrice());
				  }else{
					  //否则按商品价格保存
					  detail.setPrice(product.getSalesPrice());
					  detail.setSettlePrice(product.getSalesPrice());
				  }
				  detail = this.getDeatilFromOrder(detail,bean);
				  detail.setOrderCode(orderCode);
			      orderDetailManager.addEntity(detail);
			      if(detail.getPrice()!=null){
			    	  price += detail.getPrice()*detail.getProductCount();
			      }
		      }
 			      
		}
		  bean.setPrice(price);
	      bean.setOrderCode(orderCode);
	      this.addEntity(bean);// 新建主订单
	      orderLogManager.addOrderLog(bean);
		
    	
    	
    	
	 }
	
	

	
	
	
	 /**
     * 增加出库信息
     * 
     * @param order
     */
    public void addStockLog(ExchangeOrder order) {
    
       ExchangeOrder bean = this.getEntity(order.getId());
       bean.setUpdateUser(order.getUpdateUser());
       String wasehoseId = bean.getWasehouseId();
       if(StringUtils.isNotBlank(wasehoseId) && !bean.getConvertWay().equals("P")){
        	List<ExchangeOrderDetail> detailList = orderDetailManager.getOrderDetailByOrderCode(bean.getOrderCode());
            for(ExchangeOrderDetail detail:detailList){
            	String productCode = detail.getProductCode();//商品编码
            	StockLog stockLog = new StockLog(); 
            	stockLog.setExchangeOrderCode(bean.getOrderCode());
            	stockLog.setType(1);// 出库
     	        stockLog.setCreateTime(DateTimeUtil.now());
     	        stockLog.setCreateUser(bean.getUpdateUser());
     	        if(bean.getConvertWay().equals("J")) {
   	              stockLog.setReasonCode("1001");
   	              stockLog.setReasonContent("积分兑换出库");
   	            } else if(bean.getConvertWay().equals("C")) {
   	              stockLog.setReasonCode("1002");
   	              stockLog.setReasonContent("礼品卡兑换出库");
   	            } else if(bean.getConvertWay().equals("S")){
   	            	stockLog.setReasonCode("1003");
     	            stockLog.setReasonContent("平台代发货出库");	
   	            } else if(bean.getConvertWay().equals("WXPAY")){
   	            	stockLog.setReasonCode("1004");
     	            stockLog.setReasonContent("平台代发货出库");	
   	            }
            	stockLevelManager.autoStockInOrOut(productCode, detail.getProductCount(), wasehoseId, stockLog);
            }
        }
    }
	
	
	

	@Override
	public void saveRefundOrder(ExchangeOrder bean) {
		
		String orderCode =  genCode() ;
		bean.setOrderCode(orderCode);
		if(bean.getOrderDetailList()!=null){
			for(ExchangeOrderDetail detail:bean.getOrderDetailList()){
				if(StringUtils.isNotBlank(detail.getProductCode())){
					detail.setOrderCode(orderCode);
					detail = this.getDeatilFromOrder(detail, bean);
					orderDetailManager.addEntity(detail);
				}
				
			}
		}
		this.addEntity(bean);
		String info="创建退换货订单";
		orderLogManager.addOrderLog(bean, info);
	}
		
	
	
	@Override
	public boolean updateExchangeOrderStatusByPay(PayOrder payOrder,double jifenRate,String payType ) {
		boolean result =false;
		//支付成功，修改订单支付状态
		if(StringUtils.isNotBlank(payOrder.getResult()) && payOrder.getResult().equals("0")){
			String ordercode = payOrder.getCporderid();
			ExchangeOrder exchangeOrder = this.getNoPayOrderByOrderCode(ordercode);
			if(exchangeOrder!=null){
				ExchangeOrder newOrder = new ExchangeOrder();
				newOrder.setId(exchangeOrder.getId());
				newOrder.setOrderStatus("WAIT_ADUIT");
				newOrder.setPayType(payType);
				newOrder.setPayTime(payOrder.getTranstime());
				newOrder.setTransId(payOrder.getTransid());
				newOrder.setUpdateTime(DateTimeUtil.now());
				newOrder.setUpdateUser(payOrder.getUpdateUser());
				
				orderLogManager.addOrderLog(exchangeOrder,"订单已支付完成");
				
				
				this.update(newOrder);
				ExchangeOrder findUniqueByProperty = this.findUniqueByProperty("orderCode", ordercode);
				CustomerInfo cusInfo = customerInfoManager.getEntity(exchangeOrder.getCustomerId());
				breakUpOrderNew(findUniqueByProperty, cusInfo);
				result  = true;
			}
			
			
		}
		return result;
		
	}

	@Override
	public void saveBaseOrder(ExchangeOrder bean) {
		Double totalCredit = 0.0;
		
		if(bean.getOrderType()==null || bean.getOrderType()==1){
			for (ExchangeOrderDetail detail : bean.getOrderDetailList()) {
	        	Double price = detail.getPrice();
	        	if(price==null && StringUtils.isNotBlank(detail.getProductCode())){
	        		Product  prd = productManager.findUniqueByProperty("code", detail.getProductCode()) ;
	        		price = prd.getSalesPrice();
	        	}
	        	if(price!=null){
	        		totalCredit += (price * detail.getProductCount());
	        	}
	        	detail = this.getDeatilFromOrder(detail,bean);
	    		detail.setOrderCode(bean.getOrderCode());
	    		orderDetailManager.addEntity(detail);
	        }
			if(bean.getPrice()==null){
				bean.setPrice(totalCredit);
			}
		}
		
		
		Date now = DateTimeUtil.now();
    	bean.setCreateTime(now);
        bean.setCreateUser(bean.getCreateUser());
        bean.setDisabledYn(YesNot.NOT.getCode());
		bean.setDeleteYn(YesNot.NOT.getCode());
    	this.addEntity(bean);// 新建主订单
         // 添加订单日志信息
 	    orderLogManager.addOrderLog(bean);
	}

	@Override
	public void payForOrder(ExchangeOrder bean) {
		Date now = DateTimeUtil.now();
		Integer totalCredit = (int)Math.ceil(bean.getPrice());
		CustomerInfo cusInfo = new CustomerInfo();
		if (bean.getConvertWay().equals("J")) {//会员信息不为空，而且是用积分兑换的订单，则需要保存积分兑换记录
		      if(StringUtils.isNotBlank(bean.getCustomerName())){
		        cusInfo = customerInfoManager.findUniqueByProperty("name", bean.getCustomerName());
		      }else{
		    	throw new BusinessException("会员账户不存在");  
		      }
	     }
		
		
//		this.addCardPayLogFromOrder(bean,cusInfo,totalCredit);
		
        /**
         * 修改订单状态
         */
		ExchangeOrder newOrder = new ExchangeOrder();
		newOrder.setOrderStatus(bean.getOrderStatus());
		newOrder.setId(bean.getId());
		newOrder.setPayTime(DateTimeUtil.format(now, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
		if(StringUtils.isNotBlank(bean.getConvertWay())){
			newOrder.setConvertWay(bean.getConvertWay());
		}
		
		newOrder.setUpdateTime(now);
		newOrder.setUpdateUser(bean.getUpdateUser());
		this.update(newOrder);
		
        //增加订单操作日志
		orderLogManager.addOrderLog(bean,"订单已支付完成");
		
	}

	


	@Override
	public ExchangeOrder getExchangeOrderAndDetailByOrderCode(String orderCode) {
		return (ExchangeOrder) this.findUniqueBy(entityClass.getSimpleName() + ".selectOrderAndDetailByCode", orderCode);
	}

	@Override
	public void saveOrderForDz(ExchangeOrder bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDisableYn(String orderCode, String updateUser) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void breakUpOrderNew(ExchangeOrder bean, CustomerInfo cusInfo) {
		ExchangeOrder od = new ExchangeOrder();
		od.setId(bean.getId());
		od.setParentYn(YesNot.YES.getCode());
		this.modifyEntity(od);
		//将订单进行拆分
		 List<ExchangeOrderDetail> orderDetailList = bean.getOrderDetailList();
		 Map<String,ExchangeOrder> orderMap = new HashMap<String,ExchangeOrder>();
		 if(orderDetailList!=null && !orderDetailList.isEmpty()){
			  List<ExchangeOrder> orderList = new ArrayList<ExchangeOrder>();
			  for(ExchangeOrderDetail detail:orderDetailList){//循环子订单
				  detail = this.getDeatilFromOrder(detail,bean);
				  Product product =  productManager.findUniqueByProperty("code", detail.getProductCode());
				  Integer wasehouseid = null;
				  Map<String, Object> map = new HashMap<String, Object>();
				  if(StringUtils.isNotBlank(product.getDefalutWarehouse())){
					  wasehouseid = Integer.parseInt(product.getDefalutWarehouse());
					  map.put("warehouseId", wasehouseid);
				  }
				 
				  map.put("productCode", detail.getProductCode());
				  StockLevelDetail levelDetail = stockLevelDetailManager.getStockDetailByProduct(map);
				  
				  if(levelDetail==null || levelDetail.getId()==null){
					  levelDetail = stockLevelManager.addStockLevelByProduct(product);
				  }
				 
				 wasehouseid = levelDetail.getStockLevel().getWarehouseId();
				 bean.setSupplierCode(levelDetail.getStockLevelId()+"");
				
				 
				  
				  if(wasehouseid==null){
					  Company company = companyManager.findUniqueByProperty("code", Constant.JIYUN_COMPANY_CODE);
					  if(company.getDefaultWarehouseCode()!=null){
						  wasehouseid = Integer.parseInt(company.getDefaultWarehouseCode());
					  }
				  }
				  bean.setWasehouseId(wasehouseid.toString());
				  bean.setOldWasehouseId(wasehouseid);
				  detail.setStockLevelDetailId(levelDetail.getId());
				  detail.setOldStockLevelDetailId(levelDetail.getId());
				  
				  if(this.isNotExWaseId(orderList, wasehouseid)){//新的仓库则添加一个订单
					  String orderCode = this.genCode();
					  bean.setOrderCode(orderCode);
					  ExchangeOrder newOrder = this.copyOrder(bean);
					  newOrder.setParentId(bean.getId());
					  newOrder.setParentYn(YesNot.NOT.getCode());
					  orderList.add(newOrder);
					  detail.setOrderCode(orderCode);
					  
					  List<ExchangeOrderDetail> detailList = new ArrayList<ExchangeOrderDetail>();
					  detailList.add(detail);
					  newOrder.setOrderDetailList(detailList);
					  orderMap.put(orderCode, newOrder);
					}else{//
						 for(ExchangeOrder order:orderList){
								if(order.getWasehouseId().equals(wasehouseid+"")){
									ExchangeOrder exsitOrder =  orderMap.get(order.getOrderCode());
									List<ExchangeOrderDetail> detailList = exsitOrder.getOrderDetailList();
									detailList.add(detail);
									break;
								}
							}
					 }
			  }
			  //保存订单信息
			  if(orderMap!=null){
				  for(String orderCode:orderMap.keySet()){
					  ExchangeOrder saveOrder =  orderMap.get(orderCode);
					  this.addPayLog2(saveOrder, cusInfo);
				  }
				  
				  
			  }
		  }else{
			  throw new BusinessException("订单异常");
		  }
	
	}
		 
	
	/**
     * 对于已经生成的订单进行拆分
     * @param bean
     * @param cusInfo
     */
    public void addPayLog2(ExchangeOrder bean, CustomerInfo cusInfo){
    	
  	  List<ExchangeOrderDetail>  detailList = bean.getOrderDetailList();
		  Double price = 0.0;
		  Integer jifenPrice = 0;
		  for(ExchangeOrderDetail d:detailList){
			  d.setOrderCode(bean.getOrderCode());
			  Double prdPrice = 0.0;
			  if(d.getPrice()!=null ) prdPrice= d.getPrice();
			  price += (prdPrice * d.getProductCount());
			  
			  ExchangeOrderDetail detail = new ExchangeOrderDetail();
			  detail.setId(d.getId());
			  detail.setOrderCode(d.getOrderCode());
			  detail.setPrice(d.getPrice());
			  orderDetailManager.modifyEntity(detail);//保存子订单
			  if(d.getJifenPrice()!=null) jifenPrice += (d.getJifenPrice() * d.getProductCount() );
			  
		  }
		 
		 bean.setPrice(price);
		 bean.setJifenPrice(jifenPrice);
		 this.createNewOrder(bean);//创建主订单
  }

	@Override
	public void splitOrder(Integer[] ids, ExchangeOrder bean) {
		if(bean.getOrderCode()==null){
			throw new BusinessException("需要操作的主订单号为空");
		}
		if(ids == null || ids.length < 1){
			throw new BusinessException("需要拆分的订单为空");
		}
		
		ExchangeOrder order = this.findUniqueByProperty("orderCode", bean.getOrderCode());// 主订单
		List<ExchangeOrderDetail> details = orderDetailManager.getOrderDetailByIds(ids);//当前需要操作的子订单
		List<ExchangeOrderDetail> detailList = orderDetailManager.getOrderDetailByOrderCode(order.getOrderCode());
		String info = "";
		
		if(detailList.isEmpty()){
			throw new BusinessException("原子订单列表为空,size=0");
		}else if(detailList.size()==1){
		    throw new BusinessException("当前订单只有一个子订单,无需拆分");
		 }else if(details.isEmpty() || details.size() < 1){
			    throw new BusinessException("获取要拆分的自订单为空");
		 }else if(details.size() == detailList.size()){
			    throw new BusinessException("选择了所有产品,拆分失败,没有变化");
		 }else{
			//获取新订单金额
			 Double totalPrice = 0.0;
			 for (ExchangeOrderDetail d : details) {
				totalPrice = DoubleUtil.add(totalPrice, d.getSettlePrice());
			}
			 
			order.setOrderCode(null);
			ExchangeOrder newOrder = this.createNewOrder(order)  ;//创建一个新的主订单
			
			//设置新订单的总积分
			newOrder.setPrice(totalPrice);
			this.modifyEntity(newOrder);
			for (ExchangeOrderDetail d : details) {
				d.setOrderCode(newOrder.getOrderCode());//将需要代发货的子订单对应的新的主订单上。原主订单不变
				orderDetailManager.modifyEntity(d);//修改子订单
			}
			orderLogManager.addOrderLog(newOrder, info);
			
			
			//操作代发货,修改原订单金额
			ExchangeOrder exchangeOrder = new ExchangeOrder();
			exchangeOrder.setId(order.getId());
			exchangeOrder.setPrice(DoubleUtil.sub(order.getPrice(), totalPrice));
			this.modifyEntity(exchangeOrder);
			
			
		 }
		
		 
		
	}
	
	public void saveOrderForXianhua(ExchangeOrder order){
    	 String userName = "";
    	 // 查找会员信息
         
    	 if(StringUtils.isBlank(order.getConvertWay())){
         	throw new BusinessException("支付方式不存在");
         }
    	
        
    	 order.setAuditflag("N");// 默认商家未审核
        
       
    	if(order.getOrderType()==null || order.getOrderType()==1){//平台订单
			//组合产品则生成单品子订单
    		order.setOrderStatus("WAIT_ADUIT");// 等待商家确认
		}else{
			if(StringUtils.isBlank(order.getOrderStatus())){
				order.setOrderStatus("WAIT_BUYER_CONFIRM_GOODS");//商家已发货
			}
		}
    	
    	
        if(order.getConvertWay().equals("WXPAY") ){//现金订单
        	if(order.getOrderType()==null || order.getOrderType()==1){//平台订单
        		order.setOrderStatus("NO_PAY");
            }
        	this.saveCashPushOrder(order);
        }
		
	}
	
	
	
	/**
	 * 保存现金订单
	 * @param bean
	 */
	 @SuppressWarnings("all")
	public void saveCashPushOrderBack(ExchangeOrder bean){
		
		Map<String, Object> commissions = new HashMap<String, Object>();
		
		if(bean.getCustomerId() == null){
			throw new BusinessException("用户id为空");
		}
		CustomerInfo customer = customerInfoManager.getEntity(bean.getAgentId());
		
		List<ExchangeOrderDetail> orderDetailList = bean.getOrderDetailList();
		if(orderDetailList == null || orderDetailList.isEmpty()){
			throw new BusinessException("订单商品为空");
		}
		
    	String orderCode = this.genCode();
    	Double price = 0.0;
    	
		//属于分销订单
		if(bean.getAgentId() != null && bean.getAgentId() > 0){
			//获得分销商等级信息
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
			map.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
			List<CommissionLevel> levels = commissionLevelManager.findByMap(map);
			
			List<CommissionSetting> settings = commissionSettingManager.findAll();
			if(settings == null){
				throw new BusinessException("分销配置信息为空,请添加配置信息");
			}
			CommissionSetting setting = settings.get(0);
			//是否开启分销,几级
			Integer level = setting.getLevel();
			if(level == 0){
				bean.setAgentId(0L);
			}else{
				try {
					
				
				CommissionLevel commissionLevel1 = commissionLevelManager.getEntity(customer.getAgentLevel());
				
				//2级分销
				CustomerInfo parent = null;
				CommissionLevel commissionLevel2 = null;
				//3级分销
				CustomerInfo parent_parent = null;
				CommissionLevel commissionLevel3 = null;
				
				if(customer.getAgentId() != null && customer.getAgentId() > 0){
					parent = customerInfoManager.getEntity(customer.getAgentId());
					if(parent != null && parent.getAgentLevel() != null ){
						commissionLevel2 = commissionLevelManager.getEntity(parent.getAgentLevel());
						
						if(parent.getAgentId() != null && parent.getAgentId() > 0){
							parent_parent = customerInfoManager.getEntity(parent.getAgentId());
							if(parent_parent != null && parent_parent.getAgentLevel() != null ){
								commissionLevel3 = commissionLevelManager.getEntity(parent_parent.getAgentLevel());
							}
						}
					}
					
					
				}
				 for(ExchangeOrderDetail detail:orderDetailList){
					  String level1 = "";
					  String level2 = "";
					  String level3 = "";
					  
					  Product product = productManager.findUniqueByProperty("code", detail.getProductCode());
					  //如果没有设置产品的分销金额,走分销等级设置的比例
					  if(true){
						  
					  }
					  
					  
					  
					  
					  //一级分销
					  if(level >= 1){
						 Map<String, Object> jMap = new HashMap<String, Object>();
						 
						//计算2级分销应得佣金
						 for (CommissionLevel item : levels) {
							 Double commission1 = DoubleUtil.mul(DoubleUtil.divide(item.getCommission1(), 100.0, 2), product.getSalesPrice());
							 jMap.put("1".equals(item.getDefaultYn())?"default":"level" + item.getId(), commission1);
						}
						 detail.setCommission1(JSONObject.toJSONString(jMap));;
						 jMap.clear();
						 
						 //计算2级分销应得佣金
						 for (CommissionLevel item : levels) {
							 Double commission1 = DoubleUtil.mul(DoubleUtil.divide(item.getCommission2(), 100.0, 2), product.getSalesPrice());
							 jMap.put("2".equals(item.getDefaultYn())?"default":"level" + item.getId(), commission1);
						}
						 detail.setCommission2(JSONObject.toJSONString(jMap));;
						 jMap.clear();
						 
						 //计算3级分销应得佣金
						 for (CommissionLevel item : levels) {
							 Double commission1 = DoubleUtil.mul(DoubleUtil.divide(item.getCommission3(), 100.0, 2), product.getSalesPrice());
							 jMap.put("3".equals(item.getDefaultYn())?"default":"level" + item.getId(), commission1);
						 }
						 detail.setCommission3(JSONObject.toJSONString(jMap));;
						 jMap.clear();
						 
						 //计算实际佣金
						
						 Double commission1 = 0.00;
						 Double commission2 = 0.00;
						 Double commission3 = 0.00;
						 //1级佣金
						 if(commissionLevel2 != null){
						 	 commission1 = DoubleUtil.mul(DoubleUtil.divide(commissionLevel1.getCommission1(), 100.0, 2), product.getSalesPrice());
						 }
						 
						 //2级佣金
						 if(commissionLevel2 != null){
							 commission2 = DoubleUtil.mul(DoubleUtil.divide(commissionLevel2.getCommission2(), 100.0, 2), product.getSalesPrice());
						 }
						 
						 //3级佣金
						 if(commissionLevel3 != null){
							 commission3 = DoubleUtil.mul(DoubleUtil.divide(commissionLevel3.getCommission2(), 100.0, 2), product.getSalesPrice());
						 }
						 
						 jMap.put("level1", commission1);
						 jMap.put("level2", commission2);
						 jMap.put("level3", commission3);
						 
						 detail.setCommissions(JSONObject.toJSONString(jMap));
						 
						 
					  }
					  
					  detail = this.getDeatilFromOrder(detail,bean);
					  detail.setOrderCode(orderCode);
					  detail.setSettlePrice(detail.getPrice());
				      orderDetailManager.addEntity(detail);
				      if(detail.getPrice()!=null)
				        price += detail.getPrice()*detail.getProductCount();
			      }
				      
				
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				
		}else{
			  for(ExchangeOrderDetail detail:orderDetailList){
				  Product product = productManager.findUniqueByProperty("code", detail.getProductCode());
				  detail = this.getDeatilFromOrder(detail,bean);
				  detail.setOrderCode(orderCode);
				  detail.setSettlePrice(product.getSalesPrice());
			      orderDetailManager.addEntity(detail);
			      if(detail.getPrice()!=null)
			        price += product.getSalesPrice()*detail.getProductCount();
		      }
 			      
		}
		  bean.setPrice(price);
	      bean.setOrderCode(orderCode);
	      this.addEntity(bean);// 新建主订单
	      orderLogManager.addOrderLog(bean);
		
    	
    	
    	
	 }

	@SuppressWarnings("unchecked")
	@Override
	public List<ExchangeOrder> seldectOrderByIds(Long[] idArr) {
		return this.findAll(entityClass.getSimpleName() + ".seldectOrderByIds", idArr);
	}

	@Override
	public void batchSendGoods(Long[] idArr, String operName) {
		if(idArr != null && idArr.length > 0){
			for (int i = 0; i < idArr.length; i++) {
				ExchangeOrder order = this.getEntity(idArr[i]);
				if(order != null && "WAIT_SELLER_SEND_GOODS".equals(order.getOrderStatus())){
					order.setOrderStatus("WAIT_BUYER_CONFIRM_GOODS");
					order.setUpdateTime(DateTimeUtil.now());
					order.setUpdateUser(operName);
					operOrder(order, true);
				}
			}
		}
		
	}
    
	
	
}

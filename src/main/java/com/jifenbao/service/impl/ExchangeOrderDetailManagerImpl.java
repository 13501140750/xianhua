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

import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;
import com.jifenbao.common.JfbUtil;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.ExchangeOrderDetail;
import com.jifenbao.model.Product;
import com.jifenbao.model.Refund;
import com.jifenbao.model.SystemSetting;
import com.jifenbao.service.ExchangeOrderDetailManager;
import com.jifenbao.service.ExchangeOrderManager;
import com.jifenbao.service.OrderLogManager;
import com.jifenbao.service.ProductGroupManager;
import com.jifenbao.service.ProductManager;
import com.jifenbao.service.RefundProductManager;
import com.jifenbao.service.SystemSettingManager;

/**
 *
 * @ClassName      ExchangeOrderDetailManagerImpl
 * @Description
 * ExchangeOrderDetail
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对ExchangeOrderDetail对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-02-02 14:27:56
 * @version     1.0 
 *
 */

@Service(ExchangeOrderDetailManager.BEAN_NAME)
@Transactional
public class ExchangeOrderDetailManagerImpl extends MybatisServiceImpl<ExchangeOrderDetail, Long> implements ExchangeOrderDetailManager {

	@Resource
    ProductManager productManager;
	
	@Resource
	RefundProductManager refundProductManager;
	
	
	@Resource
	ExchangeOrderManager exchangeOrderManager;
	
	
	@Resource
	OrderLogManager orderLogManager;
	
	
	@Resource
    ProductGroupManager groupManager;
	
	@Resource
	SystemSettingManager systemSettingManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ExchangeOrderDetail> getOrderDetailByOrderCode(String orderCode) {
		return this.findAll(entityClass.getSimpleName()+".selectOrderDetailByOrder", orderCode);
	}

	@Override
	public ExchangeOrderDetail getOrderDetailBysubOrderCode(String subOrderCode) {
		return (ExchangeOrderDetail) this.findUniqueBy(entityClass.getSimpleName()+".selectOrderDetailBysubOrderCode", subOrderCode);
	}

	@Override
	public void modifySubOrderRefundStatus(ExchangeOrder order) {
		if(order!=null && order.getOrderDetailList()!=null){
			for(ExchangeOrderDetail detail:order.getOrderDetailList()){
				ExchangeOrderDetail modifyBean = new ExchangeOrderDetail();
				modifyBean.setId(detail.getId());
				modifyBean.setRefundStatus(order.getRefundStatus());
				modifyBean.setUpdateTime(order.getUpdateTime());
				modifyBean.setUpdateUser(order.getUpdateUser());
				this.modifyEntity(modifyBean);
			}
		}
		
	}
	
	/*
	 * 计算子订单的价格
	 * (non-Javadoc)
	 * @see com.jifenbao.service.ExchangeOrderDetailManager#getDetailListByProduct(com.jifenbao.model.ExchangeOrder)
	 */
	@Override
	public ExchangeOrder getDetailListByProduct(ExchangeOrder order) {
		List<ExchangeOrderDetail> newDetailList = new ArrayList<ExchangeOrderDetail>();
		List<ExchangeOrderDetail> detailList = order.getOrderDetailList();
		
		if(detailList!=null){
			
			for(ExchangeOrderDetail detail :detailList){
				String productCode = detail.getProductCode();
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("commentCompanyCode", order.getCompanyCode());
				map.put("productCode", productCode);
				Product product = productManager.findUniqueByProperty("code", productCode);
				
				
				detail.setPrice(product.getSalesPrice());
//				if(detail.getPrice()==null) detail.setPrice(0.0);
				
				newDetailList.add(detail);
			}
		}
		order.setOrderDetailList(newDetailList);
		return order;
	}

	@Override
	public List<ExchangeOrderDetail> getDetailListByProduct(List<ExchangeOrderDetail> detailList) {
		List<ExchangeOrderDetail> newDetailList = new ArrayList<ExchangeOrderDetail>();
		if(detailList!=null){
			for(ExchangeOrderDetail detail :detailList){
				String productCode = detail.getProductCode();
				Integer productCount = detail.getProductCount();
				Product product = productManager.findUniqueByProperty("code", productCode);
				List<Product> prdList  = new ArrayList<Product>();
				if(product!=null && product.getType().equals("1")){//组合产品
					prdList = groupManager.getPrdListByGroupCode(productCode);	
					if(prdList!=null && !prdList.isEmpty()){
						for(Product subProduct:prdList){
							Integer count = subProduct.getCount()*productCount;//组合中的个数*兑换的个数为单品兑换总数
							ExchangeOrderDetail newDetail = new ExchangeOrderDetail();
							newDetail.setProductCode(subProduct.getCode());
							newDetail.setProductCount(count);
							newDetail.setCount(count);
							newDetail.setPrice(subProduct.getSalesPrice());
							newDetailList.add(newDetail);
						}
					}
				}else{
					ExchangeOrderDetail newDetail = new ExchangeOrderDetail();
					newDetail.setProductCode(product.getCode());
					newDetail.setProductCount(productCount);
					newDetail.setCount(productCount);
					if(detail.getPrice()!=null){
						newDetail.setJifenPrice((int)Math.ceil(detail.getPrice()));
					}
					newDetail.setPrice(product.getSalesPrice());
					newDetailList.add(detail);
				}
			}
		}
		return newDetailList;
	}

	@Override
	public void exchangeProduct(ExchangeOrder order,Refund refund) {
		List<ExchangeOrderDetail> newDetailList = refund.getDetailList();
		List<ExchangeOrderDetail> oldDetailList = order.getOrderDetailList();
		//将原子订单的退款状态置为成功
		String oldInfo = "";
		ExchangeOrderDetail oldDetail  =  oldDetailList.get(0);
		for(ExchangeOrderDetail detail:oldDetailList){//子订单只能是一个
			ExchangeOrderDetail modifyBean = new ExchangeOrderDetail();
			modifyBean.setDisabledYn(YesNot.YES.getCode());
			modifyBean.setId(detail.getId());
			modifyBean.setRefundStatus("SUCCESS");
			modifyBean.setUpdateTime(order.getUpdateTime());
			modifyBean.setUpdateUser(order.getUpdateUser());
			oldInfo +=  detail.getProduct().getTitle()+"("+detail.getProduct().getShowCode()+")"+";";
			this.modifyEntity(modifyBean);
		}
		if(StringUtils.isNotBlank(oldInfo)){
			oldInfo = oldInfo.substring(0,oldInfo.length()-1);
		}
		//添加新的子订单
		String newInfo = "";
		if(refund.getProductCode().equals("0")){
			if(newDetailList==null){
				newDetailList = new ArrayList<ExchangeOrderDetail>();
				ExchangeOrderDetail detail = new ExchangeOrderDetail();
				detail.setProductCode(oldDetail.getProductCode());
				detail.setProductCount(oldDetail.getProductCount());
				newDetailList.add(detail);
			}
		}
		for(ExchangeOrderDetail detail:newDetailList){
//			SystemSetting setting = systemSettingManager.findUniqueByProperty("systemKey", "EXCHANGE_RATE");
//			String rate = setting.getSystemValue();
			if(StringUtils.isNotBlank(detail.getProductCode())){
				detail = exchangeOrderManager.getDeatilFromOrder(detail, order);
				detail.setOrderCode(order.getOrderCode());
				detail.setString4(refund.getRefundCode());//对应的退款订单
				Product prd = productManager.findUniqueByProperty("code", detail.getProductCode());
				detail.setPrice(prd.getSalesPrice());
				detail.setSettlePrice(oldDetail.getSettlePrice());
				newInfo +=  prd.getTitle()+"("+prd.getShowCode()+")"+";";
				this.addEntity(detail);
			}
		}
		//保存更换商品信息
		refundProductManager.saveExchangeProductInfo(oldDetail, refund);
		//保存日志信息
		if(StringUtils.isNotBlank(newInfo)){
			newInfo = newInfo.substring(0,newInfo.length()-1);
		}
		String info="调换了订单中的商品，原商品为："+oldInfo+",调换后的新商品为："+newInfo;
		orderLogManager.addOrderLog(order, info);
		
	}

	@Override
	public void addDetailOrder(ExchangeOrderDetail detailOrder) {
		
		String productCode = detailOrder.getProductCode();
		Integer productCount = detailOrder.getProductCount();
		Product product = productManager.findUniqueByProperty("code", productCode);
		List<Product> prdList  = new ArrayList<Product>();
		if(product!=null && product.getType().equals("1")){//组合产品
			prdList = groupManager.getPrdListByGroupCode(productCode);	
			if(prdList!=null && !prdList.isEmpty()){
				for(Product subProduct:prdList){
					Integer count = subProduct.getCount()*productCount;//组合中的个数*兑换的个数为单品兑换总数
					ExchangeOrderDetail newDetail = this.copyDetailOrder(detailOrder);
					newDetail.setProductCode(subProduct.getCode());
					newDetail.setProductCount(count);
					newDetail.setCount(count);
					newDetail.setPrice(subProduct.getSalesPrice());
					newDetail.setJifenPrice(0);
					this.addEntity(newDetail);
				}
			}
		}else{
			this.addEntity(detailOrder);
		}
	
	}
    
	
	
	/**
	 * 通过主订单保存子订单订单
	 * @param detail
	 * @param bean
	 * @return
	 */
	
	public  ExchangeOrderDetail copyDetailOrder(ExchangeOrderDetail detail){
		ExchangeOrderDetail newDetail = new ExchangeOrderDetail();
		Date now = DateTimeUtil.now();
		
		//detail.setPrice(detail.getPrice());
		//detail.setJifenPrice(detail.getJifenPrice());
		newDetail.setStockLevelDetailId(detail.getStockLevelDetailId());
		newDetail.setOldStockLevelDetailId(detail.getOldStockLevelDetailId());
		newDetail.setAuditflag(detail.getAuditflag());
		newDetail.setCount(detail.getCount());
		newDetail.setOrderCode(detail.getOrderCode());
		newDetail.setDeliveryDate(detail.getDeliveryDate());
		newDetail.setDropshipYn(detail.getDropshipYn());
		newDetail.setOrderStatus(detail.getOrderStatus());
		newDetail.setPartnerCode(detail.getPartnerCode());
		newDetail.setProductCode(detail.getProductCode());
		newDetail.setProductCount(detail.getProductCount());
		newDetail.setSettlePrice(detail.getSettlePrice());
		newDetail.setJifenPrice(detail.getJifenPrice());
		newDetail.setRefundStatus(detail.getRefundStatus());
		newDetail.setPrice(detail.getPrice());
		newDetail.setDiscountPrice(detail.getDiscountPrice());
		newDetail.setCustomerName(detail.getCustomerName());
		newDetail.setReceiverTel(detail.getReceiverTel());
		newDetail.setReceiverName(detail.getReceiverName());
		newDetail.setReceiverAddress(detail.getReceiverAddress());
		newDetail.setDisabledYn(YesNot.NOT.getCode());
		newDetail.setDeleteYn(YesNot.NOT.getCode());
		newDetail.setCreateTime(now);
		newDetail.setUpdateTime(now);
		newDetail.setCreateUser(detail.getCreateUser());
		newDetail.setUpdateUser(detail.getUpdateUser());
        newDetail.setString3(detail.getString3());
        String subCode = exchangeOrderManager.genSubCode();
        newDetail.setSubOrderCode(subCode);// 子订单编号
		return newDetail;
	}

	@Override
	public String genSubCode() {
		 // logger.info("生成code");
        String code = JfbUtil.createCode();
        ExchangeOrderDetail orderDetail = new ExchangeOrderDetail();
        orderDetail.setSubOrderCode(code);
        if (this.isExists(orderDetail)) {
            logger.info("code已存在");
            this.genSubCode();
        } else {
            logger.info("code为最新");
            return code;
        }
        return null;
	}

	@SuppressWarnings("unchecked")
	public List<ExchangeOrderDetail> getOrderDetailByIds(Integer[] ids) {
		return super.findAll(entityClass.getSimpleName() + ".selectOrderDetailByIds", ids);
	}

	@Override
	public void updateCheckStatus(ExchangeOrderDetail entity) {
//		super.update(entityClass.getSimpleName() + "updateCheckStatus", entity);
		super.update(entityClass.getSimpleName() + ".updateAll", entity);
		
	}
    
}

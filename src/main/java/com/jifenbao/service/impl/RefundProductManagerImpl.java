/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.utils.DateTimeUtil;
import com.jifenbao.model.ExchangeOrderDetail;
import com.jifenbao.model.Product;
import com.jifenbao.model.Refund;
import com.jifenbao.model.RefundProduct;
import com.jifenbao.service.RefundProductManager;

/**
 *
 * @ClassName      RefundProductManagerImpl
 * @Description
 * RefundProduct
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对RefundProduct对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-06-17 13:28:25
 * @version     1.0 
 *
 */

@Service(RefundProductManager.BEAN_NAME)
@Transactional
public class RefundProductManagerImpl extends MybatisServiceImpl<RefundProduct, Long> implements RefundProductManager {

	@Override
	public void saveExchangeProductInfo(ExchangeOrderDetail detailOrder,Refund refund) {
		if(refund.getDetailList()!=null && !refund.getDetailList().isEmpty()){
			for(ExchangeOrderDetail detail:refund.getDetailList()){
				if(StringUtils.isNotBlank(detail.getProductCode())){
					RefundProduct refundProduct = new RefundProduct();
					refundProduct.setOrderCode(detailOrder.getOrderCode());
					refundProduct.setRefundCode(refund.getRefundCode());
					refundProduct.setProductCode(detail.getProductCode());
					refundProduct.setProductCount(detail.getProductCount());
					refundProduct.setOldProductCode(detailOrder.getProductCode());
					refundProduct.setRefundType(refund.getRefundType());
					refundProduct.setDeleteYn(YesNot.NOT.getCode());
					refundProduct.setDisabledYn(YesNot.NOT.getCode());
					refundProduct.setCreateTime(DateTimeUtil.now());
					refundProduct.setCreateUser(refund.getUpdateUser());
					this.addEntity(refundProduct);
				}
				
			}
		}
	}

	@Override
	public List<Product> getExchangeProduct(String refundCode,String orderCode) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("refundCode", refundCode);
		map.put("orderCode", orderCode);
		return this.findAll(entityClass.getSimpleName()+".selectRefundExchangeProductList", map);
	}
    
    
}

/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.ExpressOrder;
import com.jifenbao.model.Warehouse;
import com.jifenbao.service.ExpressOrderManager;
import com.jifenbao.thirdAPI.KDNiao.KdApiOrder;
import com.jifenbao.thirdAPI.KDNiao.model.KDNiaoDirective;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

/**
 *
 * @ClassName ExpressOrderManagerImpl
 * @Description ExpressOrder 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对ExpressOrder对象的CRUD函数.
 *
 * @author liujing
 * @Date 2016-04-29 13:13:48
 * @version 1.0
 *
 */

@Service(ExpressOrderManager.BEAN_NAME)
@Transactional
public class ExpressOrderManagerImpl extends MybatisServiceImpl<ExpressOrder, Long> implements ExpressOrderManager {
    private final static Logger LOG = Logger.getLogger(KdApiOrder.class);

    /**
     * 通过快递鸟 在线下单
     * 
     * @throws Exception
     */
    public ExpressOrder addExpressOrderByKDN(String userId, ExchangeOrder order, Warehouse warehouse, String filePath) throws Exception {
        ExpressOrder eo = null;
        KdApiOrder kdn = new KdApiOrder();
        String result = kdn.orderOnlineByJson(KDNiaoDirective.D_1007, order, warehouse);
        JSONObject j = new JSONObject(result);
        if (j.getBoolean("Success")) {
            eo = new ExpressOrder();
            String htmlContent = j.getJSONObject("Order").getString("PrintTemplate");
            String htmlPath = filePath + "/" + eo.getShipperCode() + "/" + eo.getOrderCode() + ".html";

            eo.setOrderCode(j.getJSONObject("Order").getString("OrderCode"));
            eo.setShipperCode(j.getJSONObject("Order").getString("ShipperCode"));
            eo.setLogisticCode(j.getJSONObject("Order").getString("LogisticCode"));
            eo.setMarkDestination(j.getJSONObject("Order").getString("MarkDestination"));
            eo.setOriginCode(j.getJSONObject("Order").getString("OriginCode"));
            eo.setOriginName(j.getJSONObject("Order").getString("OriginName"));
            eo.setPackageCode(j.getJSONObject("Order").getString("PackageCode"));
            // 先保存路径，如果为空，可以根据基本快递单信息再做处理
            eo.setPrintTemplate(htmlPath);
            eo.setCreateUser(userId);
            eo.setCreateTime(DateTimeUtil.now());

            // 保存快递单信息
            addEntity(eo);

            // 将打印信息输出到文件, 如果打印失败，基本信息已存入数据表中
            try {
                File targetFile = new File(htmlPath);
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                FileOutputStream fos = new FileOutputStream(targetFile);
                fos.write(htmlContent.getBytes());
                fos.close();
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }

        } else {
            throw new BusinessException(j.getString("Reason"));
        }
        return eo;
    }

	@Override
	public void addOrderExpressByOrder(ExchangeOrder bean) {
		String orderCode = bean.getOrderCode();
		ExpressOrder isExs = new ExpressOrder();
		isExs.setOrderCode(orderCode);
		ExpressOrder eo = new ExpressOrder();
		if(this.isExistsProperty(isExs)){
			 eo = this.findByProperty("orderCode", orderCode).get(0);
			 eo.setOrderCode(bean.getOrderCode());
			 eo.setShipperCode(bean.getExpressCompany());
			 eo.setLogisticCode(bean.getExpressNumber());
			 eo.setUpdateTime(DateTimeUtil.now());
			 eo.setUpdateUser(bean.getCreateUser());
			 eo.setDisabledYn("0");
			 eo.setDeleteYn("0");
			 this.modifyEntity(eo);
		}else{
			 eo.setOrderCode(bean.getOrderCode());
			 eo.setShipperCode(bean.getExpressCompany());
			 eo.setLogisticCode(bean.getExpressNumber());
			 eo.setCreateTime(DateTimeUtil.now());
			 eo.setCreateUser(bean.getCreateUser());
			 eo.setUpdateTime(DateTimeUtil.now());
			 eo.setUpdateUser(bean.getCreateUser());
			 eo.setDisabledYn("0");
			 eo.setDeleteYn("0");
			 this.addEntity(eo);
		}
		 
		
	}

}

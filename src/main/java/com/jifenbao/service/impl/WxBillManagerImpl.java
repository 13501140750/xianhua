/**
 * Copyright 2008 - 2017 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */

package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.common.WxUtil;
import com.jifenbao.model.WxBill;
import com.jifenbao.service.WxBillManager;
import com.otc.framework.enums.YesNot;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

/**
 *
 * @ClassName      WxBillManagerImpl
 * @Description
 * WxBill
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对WxBill对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2017-12-15 00:38:35
 * @version     1.0 
 *
 */

@Service(WxBillManager.BEAN_NAME)
@Transactional
public class WxBillManagerImpl extends MybatisServiceImpl<WxBill, Integer> implements WxBillManager {
    
    
    @Transactional(readOnly=true)
    public WxBill getByWxOrderCode(java.lang.String wxOrderCode) {
        return (WxBill) super.findUniqueBy("WxBill.getByWxOrderCode", wxOrderCode);
    }
    
    @Transactional(readOnly=true)
    public WxBill getByBzOrderCode(java.lang.String bzOrderCode) {
        return (WxBill) super.findUniqueBy("WxBill.getByBzOrderCode", bzOrderCode);
    }
    
	
	
	@Override
	public void batchDelete(Integer[] ids, String operUser) {
		for(Integer id:ids){
			WxBill bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDeleteYn(YesNot.YES.getCode());
  			this.modifyEntity(bean);
			}
		}
		
	}
	
	@Override
	public void batchDisabled(Integer[] ids, String operUser, String oper) {
		for(Integer id:ids){
			WxBill bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDisabledYn(oper);
  			this.modifyEntity(bean);
			}
		}
		
	}

	@Override
	public void downloadBill(String dateStr, String string) {
		try {
			String[] downloadBill = WxUtil.downloadBill(dateStr, string);
			for (String string2 : downloadBill) {
				String[] split = string2.split(",");
				insertWxBill(split);
			}
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	
	public  void insertWxBill(String[] tradeDetailArray){
    	WxBill entity = null;
        entity = new WxBill();
        entity.setId(null); // 自动生成id
        entity.setTradeTime(tradeDetailArray[0]);// 交易时间
        entity.setGhId(tradeDetailArray[1]);// 公众账号ID
        entity.setMchId(tradeDetailArray[2]);// 商户号
        entity.setSubMchNo(tradeDetailArray[3]);// 子商户号
        entity.setDeviceNo(tradeDetailArray[4]);// 设备号
        entity.setWxOrderCode(tradeDetailArray[5]);// 微信订单号
        entity.setBzOrderCode(tradeDetailArray[6]);// 商户订单号
        entity.setOpenid(tradeDetailArray[7]);// 用户标识
        entity.setTradeType(tradeDetailArray[8]);// 交易类型
        entity.setTradeStatus(tradeDetailArray[9]);// 交易状态
        entity.setBank(tradeDetailArray[10]);// 付款银行
        entity.setCurrency(tradeDetailArray[11]);// 货币种类
        entity.setTotalMoney(tradeDetailArray[12]);// 总金额
        entity.setRedPacketMoney(tradeDetailArray[13]);// 企业红包金额
        entity.setWxRefundNo(tradeDetailArray[14]);// 微信退款单号
        entity.setBzRefundNo(tradeDetailArray[15]);// 商户退款单号
        entity.setRefundMoney(tradeDetailArray[16]);// 退款金额
        entity.setRedPacketRefund(tradeDetailArray[17]);// 企业红包退款金额
        entity.setRefundType(tradeDetailArray[18]);// 退款类型
        entity.setRefundStatus(tradeDetailArray[19]);// 退款状态
        entity.setProductName(tradeDetailArray[20]);// 商品名称
        entity.setBzDataPacket(tradeDetailArray[21]);// 商户数据包
        entity.setFee(tradeDetailArray[22]);// 手续费
        entity.setRate(tradeDetailArray[23] + "%");// 费率
        entity.setCreateTime(DateTimeUtil.now());
        entity.setCreateUser("system");
        System.out.println(entity.toString());
        super.addEntity(entity);
    }
}

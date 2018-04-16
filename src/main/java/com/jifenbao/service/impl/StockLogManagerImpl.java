/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.StockLevel;
import com.jifenbao.model.StockLevelDetail;
import com.jifenbao.model.StockLog;
import com.jifenbao.service.StockLevelDetailManager;
import com.jifenbao.service.StockLevelManager;
import com.jifenbao.service.StockLogManager;
import com.otc.framework.enums.YesNot;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

/**
 *
 * @ClassName StockLogManagerImpl
 * @Description StockLog 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对StockLog对象的CRUD函数.
 *
 * @author liujing
 * @Date 2015-12-23 17:09:20
 * @version 1.0
 *
 */

@Service(StockLogManager.BEAN_NAME)
@Transactional
public class StockLogManagerImpl extends MybatisServiceImpl<StockLog, Integer> implements StockLogManager {

    @Resource(name = StockLevelManager.BEAN_NAME)
    private StockLevelManager stockLevelManager;

    @Resource(name = StockLevelDetailManager.BEAN_NAME)
    private StockLevelDetailManager stockLevelDetailManager;

    @Override
    public void modifySotckLog(StockLog stockLog) {
        stockLog.setDisabledYn(YesNot.NOT.getCode());
        stockLog.setDeleteYn(YesNot.NOT.getCode());
        StockLevel sk = stockLevelManager.getEntity(stockLog.getStockLevelId());
        StockLevelDetail skd = stockLevelDetailManager.getEntity(stockLog.getStockLevelDetailId());

        // 根据sotckLog.type类型判断出入库， 0是入库，1是出库
        if (stockLog.getType().equals(0)) {
            sk.setAmount(sk.getAmount() + stockLog.getAmount());
            skd.setAmount(skd.getAmount() + stockLog.getAmount());
            this.modifyStock(stockLog, sk, skd);
        } else {
            // 检查库存明细数量
            if (skd.getAmount() - stockLog.getAmount() < 0) {
            	int inCount = stockLog.getAmount()-skd.getAmount();//本次需要入库的数量
            	int amount = stockLog.getAmount();
            	String content = stockLog.getReasonContent();
            	stockLog.setAmount(inCount);
            	stockLog.setType(0);
            	stockLog.setCreateTime(DateTimeUtil.now());
            	stockLog.setReasonContent("当前库存不足时出库，自动添加不足部分的商品入库");
            	sk.setAmount(sk.getAmount() + inCount);
                skd.setAmount(skd.getAmount() + inCount);
                
                this.modifyStock(stockLog, sk, skd);//先入库
                //再出库
                stockLog.setAmount(amount);
            	stockLog.setId(null);
            	stockLog.setType(1);
            	stockLog.setReasonContent(content);
            	sk.setAmount(0);
                skd.setAmount(0);
                this.modifyStock(stockLog, sk, skd);//先添加库存信息
                //throw new BusinessException("out of stock");
            }else{
            	sk.setAmount(sk.getAmount() - stockLog.getAmount());
                skd.setAmount(skd.getAmount() - stockLog.getAmount());
                this.modifyStock(stockLog, sk, skd);
            }
            
        }

       
    }
    
    public void modifyStock(StockLog stockLog,StockLevel sk,  StockLevelDetail skd ){
    	 super.addEntity(stockLog);
    	 sk.setUpdateTime(DateTimeUtil.now());
    	 sk.setUpdateUser(stockLog.getCreateUser());
    	 skd.setUpdateTime(DateTimeUtil.now());
    	 skd.setUpdateUser(stockLog.getCreateUser());
         stockLevelManager.modifyEntity(sk);
         stockLevelDetailManager.modifyEntity(skd);
    }

}

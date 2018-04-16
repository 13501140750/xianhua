/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.exception.BusinessException;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.utils.DateTimeUtil;
import com.taobao.api.ApiException;
import com.taobao.api.internal.util.json.BufferErrorListener;
import com.jifenbao.common.BusinessErrorCodeEx;
import com.jifenbao.model.LoggerInfo;
import com.jifenbao.model.helper.TaobaoMessage;
import com.jifenbao.service.LoggerInfoManager;
import com.jifenbao.thirdAPI.TaobaoSendMessageApi;

/**
 *
 * @ClassName      LoggerInfoManagerImpl
 * @Description
 * LoggerInfo
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对LoggerInfo对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-05-23 10:03:05
 * @version     1.0 
 *
 */

@Service(LoggerInfoManager.BEAN_NAME)
@Transactional
public class LoggerInfoManagerImpl extends MybatisServiceImpl<LoggerInfo, Long> implements LoggerInfoManager {

	@Override
	public TaobaoMessage sendMsg(TaobaoMessage message) {
		LoggerInfo loggerInfo  = new LoggerInfo();
    	loggerInfo.setCreateUser(message.getRec_num());
    	loggerInfo.setLogName("发送短信"+message.getType());
    	try {
			message = TaobaoSendMessageApi.sendMessage(message);
			loggerInfo.setLogRequest(message.getMsgRequest());
	    	loggerInfo.setLogResponse(message.getMsgResponse());
	    	loggerInfo.setCreateTime(DateTimeUtil.now());
	    	loggerInfo.setCreateUser(message.getRec_num());
	    	this.addEntity(loggerInfo);
	    	
		} catch (ApiException e) {
			throw new BusinessException("发码失败");
		}
		return message;
	}
    
	
    
}

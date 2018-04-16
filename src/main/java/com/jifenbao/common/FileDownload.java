/**    
 * Copyright 2008-2012 OpenTide Inc. All Rights Reserved.
 * 
 * @ProjectName:  samsungshop common 
 * @Package:      com.otc.mall.common.util  
 * @FileName:     FileDownload.java   
 * @Description:  
 * @CreateUser:   liuyang   
 * @CreateDate:   2012-10-25 下午6:56:12  
 * @UpdateUser:   liuyang   
 * @UpdateDate:   2012-10-25 下午6:56:12   
 * @UpdateRemark: 
 *     
 */
package com.jifenbao.common;

import java.io.OutputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @ClassName FileDownload
 * @Description 多线程下载
 * 
 * @author yang.liu
 * @Date 2012-10-25 下午6:56:12
 * @version 1.0
 * 
 */
public class FileDownload {
    
    private static final Log logger = LogFactory.getLog(FileDownload.class);
    
    /**
     * 远程下载文件
     * 
     * @param url
     * @param outputStream
     */
    public static void saveToFile(String url, OutputStream outputStream) {
        HttpClient client = new HttpClient();
        GetMethod get = null;
        logger.info(" connect to URL:" + url);
        try {
            // hasActive();
            
            get = new GetMethod(url);
            int responseCode = client.executeMethod(get);
            if (200 == responseCode) {
                logger.info(" connect to URL success..");
                // 得到网络资源的字节数组,并写入文件
                outputStream.write(get.getResponseBody());
            }
            else {
                logger.info("Resources [" + url
                        + "] download failure, Non-OK the HTTP response code="
                        + responseCode);
            }
        }
        catch (Exception e) {
            logger.error("Unable to connect to URL:" + url, e);
        }
        finally {
            get.releaseConnection();
            client.getHttpConnectionManager().closeIdleConnections(0);
        }
    }
    
}

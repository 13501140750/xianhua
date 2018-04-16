package com.jifenbao.thirdAPI.KDNiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.jifenbao.common.JsonHelper;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.ExchangeOrderDetail;
import com.jifenbao.model.Warehouse;
import com.jifenbao.model.helper.Kuaidi;
import com.jifenbao.thirdAPI.KDNiao.model.Commodity;
import com.jifenbao.thirdAPI.KDNiao.model.KDNiaoDirective;
import com.jifenbao.thirdAPI.KDNiao.model.kdniaoOrderLine;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 *
 * 快递鸟物流轨迹即时查询接口
 *
 * @author: CQ
 * @qq: 1069712970
 * @see: http://www.kdniao.com/YundanChaxunAPI.aspx
 * @copyright: 深圳市快金数据技术服务有限公司
 *
 *             DEMO中的电商ID与私钥仅限测试使用，正式环境请单独注册账号 单日超过500单查询量，建议接入我方物流轨迹订阅推送接口
 * 
 *             ID和Key请到官网申请：http://www.kdniao.com/ServiceApply.aspx 测试ID和KEY已经关闭
 *             ID:1237100 KEY:518a73d8-1f7f-441a-b644-33e77b49d846
 */

@SuppressWarnings("restriction")
public class KdApiOrder {

    private final static Logger LOG = Logger.getLogger(KdApiOrder.class);
    // 电商ID
    private String EBusinessID = "1256095";
    // 电商加密私钥，快递鸟提供，注意保管，不要泄漏
    private String AppKey = "2e9a4707-6d65-4dea-9ec4-206e0943dd37";
    // 请求url
    private String ReqURL = "http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx";

    /**
     * Json方式 在线下单
     * 
     * @throws Exception
     */
    public String orderOnlineByJson(ExchangeOrder order, Warehouse warehouse) throws Exception {
        return orderOnlineByJson(KDNiaoDirective.D_1007, order, warehouse);
    }

    /**
     * Json方式 在线下单
     * 
     * @throws Exception
     */
    public String orderOnlineByJson(KDNiaoDirective directive, ExchangeOrder order, Warehouse warehouse) throws Exception {
        // 基本信息
        kdniaoOrderLine oLine = new kdniaoOrderLine(order.getExpressCompany(), order.getOrderCode(), null, 1, 2, null,
                order.getReceiverName(), order.getReceiverProvince(), order.getReceiverCity(), order.getReceiverCounty(),
                order.getReceiverStreet() + order.getReceiverAddress(), order.getReceiverTel(), order.getReceiverPhone(),
                warehouse.getContact(), warehouse.getProvinceName(), warehouse.getCityName(), warehouse.getCountyName(),
                warehouse.getAddress(), warehouse.getPhone(), null);
        List<Commodity> commoditys = new ArrayList<Commodity>();
        if (order.getOrderDetailList() != null && order.getOrderDetailList().size() > 0) {
            for (ExchangeOrderDetail od : order.getOrderDetailList()) {
                Commodity c = new Commodity();
                c.setGoodsName(od.getProduct().getTitle());
                c.setGoodsquantity(od.getCount());
                c.setGoodsWeight(od.getTotleWeight());
                commoditys.add(c);
            }
        }
        oLine.setCommoditys(commoditys);
        return orderOnlineByJson(directive, oLine);
    }

    /**
     * Json方式 在线下单
     * 
     * @throws Exception
     */
    public String orderOnlineByJson(KDNiaoDirective directive, kdniaoOrderLine orderLine) throws Exception {
        String commoditys = "[";

        if (orderLine.getCommoditys() != null && orderLine.getCommoditys().size() > 0) {
            for (Commodity c : orderLine.getCommoditys()) {
                commoditys += "{\"Goodsquantity\":" + c.getGoodsquantity() + "," + "\"GoodsName\":\"" + c.getGoodsName() + "\","
                        + "\"GoodsWeight\":" + c.getGoodsWeight() + "},";
            }
            commoditys = commoditys.substring(0, commoditys.length() - 1);
        }
        commoditys += "]";

        String requestData = "{\"IsReturnPrintTemplate\":\"1\",\"OrderCode\": \"" + orderLine.getOrderCode() + "\",\"ShipperCode\": \""
                + orderLine.getShipperCode() + "\",\"PayType\": " + orderLine.getPayType() + ",\"ExpType\": " + orderLine.getExpType()
                + ",\"Cost\": " + orderLine.getCost() + ",\"OtherCost\": " + orderLine.getOtherCost() + ",\"Sender\": {\"Company\": \""
                + orderLine.getFromCompanyString() + "\",\"Name\": \"" + orderLine.getFromName() + "\",\"Mobile\": \""
                + orderLine.getFromTel() + "\",\"ProvinceName\": \"" + orderLine.getFromProvinceID() + "\",\"CityName\": \""
                + orderLine.getFromCityID() + "\",\"ExpAreaName\": \"" + orderLine.getFromExpAreaID() + "\",\"Address\": \""
                + orderLine.getFromAddressArea() + "\"},\"Receiver\": {\"Company\": \"" + orderLine.getToCompanyString() + "\",\"Name\": \""
                + orderLine.getToName() + "\",\"Mobile\": \"" + orderLine.getToMobile() + "\",\"ProvinceName\": \""
                + orderLine.getToProvinceID() + "\",\"CityName\": \"" + orderLine.getToCityID() + "\",\"ExpAreaName\": \""
                + orderLine.getToExpAreaID() + "\",\"Address\": \"" + orderLine.getToAddressArea() + "\"},\"Commodity\":" + commoditys
                + ",\"AddService\":[{\"Name\":\"COD\",\"Value\":\"1020\"}],\"Weight\": " + orderLine.getWeightString()
                + ",\"Quantity\": 1,\"Volume\": " + orderLine.getVolumeString() + ",\"Remark\": \"" + orderLine.getRemarkString() + "\"}";
        // requestData =
        // "{\"OrderCode\":\"012657700387\",\"ShipperCode\":\"HTKY\",\"PayType\":1,\"ExpType\":1,\"Cost\":1,\"OtherCost\":1,\"Sender\":{\"Company\":\"LV\",\"Name\":\"Taylor\",\"Mobile\":\"15018442396\",\"ProvinceName\":\"上海\",\"CityName\":\"上海\",\"ExpAreaName\":\"青浦区\",\"Address\":\"明珠路\"},\"Receiver\":{\"Company\":\"GCCUI\",\"Name\":\"Yann\",\"Mobile\":\"15018442396\",\"ProvinceName\":\"北京\",\"CityName\":\"北京\",\"ExpAreaName\":\"朝阳区\",\"Address\":\"三里屯街道\"},\"Commodity\":[{\"GoodsName\":\"鞋子\",\"Goodsquantity\":1,\"GoodsWeight\":1}],\"AddService\":[{\"Name\":\"COD\",\"Value\":\"1020\"}],\"Weight\":1,\"Quantity\":1,\"Volume\":0,\"Remark\":\"小心轻放\"}";
        Map<String, String> params = new HashMap<String, String>();
        LOG.info(requestData);
        params.put("RequestData", urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", EBusinessID);
        params.put("RequestType", directive.getCode());
        String dataSign = encrypt(requestData, AppKey, "UTF-8");
        params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", "2");

        String result = sendPost(ReqURL, params);
        LOG.info(result);

        // 根据公司业务处理返回的信息......
        return result;
    }

    /**
     * Json方式 查询订单物流轨迹
     * 
     * @throws Exception
     */
    public String getOrderTracesByJson(String requestData) throws Exception {

        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", EBusinessID);
        params.put("RequestType", "1002");
        String dataSign = encrypt(requestData, AppKey, "UTF-8");
        params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", "2");

        String result = sendPost(ReqURL, params);

        // 根据公司业务处理返回的信息......

        return result;
    }

    /**
     * XML方式 查询订单物流轨迹
     * 
     * @throws Exception
     */
    public String getOrderTracesByXml() throws Exception {
        String requestData = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" + "<Content>" + "<OrderCode></OrderCode>"
                + "<ShipperCode>SF</ShipperCode>" + "<LogisticCode>589707398027</LogisticCode>" + "</Content>";

        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", EBusinessID);
        params.put("RequestType", "1002");
        String dataSign = encrypt(requestData, AppKey, "UTF-8");
        params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", "1");

        String result = sendPost(ReqURL, params);

        // 根据公司业务处理返回的信息......

        return result;
    }

    /**
     * MD5加密
     * 
     * @param str
     *            内容
     * @param charset
     *            编码方式
     * @throws Exception
     */

    private String MD5(String str, String charset) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes(charset));
        byte[] result = md.digest();
        StringBuffer sb = new StringBuffer(32);
        for (int i = 0; i < result.length; i++) {
            int val = result[i] & 0xff;
            if (val <= 0xf) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }
        return sb.toString().toLowerCase();
    }

    /**
     * base64编码
     * 
     * @param str
     *            内容
     * @param charset
     *            编码方式
     * @throws UnsupportedEncodingException
     */
    private String base64(String str, String charset) throws UnsupportedEncodingException {
        String encoded = Base64.encode(str.getBytes(charset));
        return encoded;
    }

    private String urlEncoder(String str, String charset) throws UnsupportedEncodingException {
        String result = URLEncoder.encode(str, charset);
        return result;
    }

    /**
     * 电商Sign签名生成
     * 
     * @param content
     *            内容
     * @param keyValue
     *            Appkey
     * @param charset
     *            编码方式
     * @throws UnsupportedEncodingException
     *             ,Exception
     * @return DataSign签名
     */

    private String encrypt(String content, String keyValue, String charset) throws UnsupportedEncodingException, Exception {
        if (keyValue != null) {
            return base64(MD5(content + keyValue, charset), charset);
        }
        return base64(MD5(content, charset), charset);
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param params
     *            请求的参数集合
     * @return 远程资源的响应结果
     */

    private String sendPost(String url, Map<String, String> params) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // POST方法
            conn.setRequestMethod("POST");
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.connect();
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数
            if (params != null) {
                StringBuilder param = new StringBuilder();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    if (param.length() > 0) {
                        param.append("&");
                    }
                    param.append(entry.getKey());
                    param.append("=");
                    param.append(entry.getValue());
                    // System.out.println(entry.getKey()+":"+entry.getValue());
                }
                // System.out.println("param:"+param.toString());
                out.write(param.toString());
            }
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }
    
    
    /**
     * 订单是否签收
     * @param requestData
     * @return
     * @throws Exception
     */
    public boolean  orderSignYn(String requestData) throws Exception {
    
    	boolean bl = false;
    	
        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", EBusinessID);
        params.put("RequestType", "1002");
        String dataSign = encrypt(requestData, AppKey, "UTF-8");
        params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", "2");

        String result = sendPost(ReqURL, params);
        if(StringUtils.isNotBlank(result)){
        	Map<String, String> map = JsonHelper.toMap(result);
            // 根据公司业务处理返回的信息......
            String trace = map.get("Traces");
            if(trace.indexOf("签收")>-1){//包含签收则返回true
            	bl = true;
            }else{
            	bl =  false;
            }
        }
        
        return bl;
    }


   
    
    
    
    public static void main(String[] args) {
        KdApiOrder demo = new KdApiOrder();
        try {
            String requestData = "{'OrderCode':'','ShipperCode':'ZJS','LogisticCode':'7950485955'}";
            String result = demo.getOrderTracesByJson(requestData);
            // System.out.println(result);
            Kuaidi kuaidi = new Kuaidi();
            @SuppressWarnings("unchecked")
            Map<String, String> map = JsonHelper.toMap(result);
            kuaidi = (Kuaidi) JsonHelper.toJavaBean(kuaidi, map);
            
            String trace = kuaidi.getTraces();
            trace = trace.substring(1,trace.length()-1);
            trace.replace("{", "");
      	  String[] logs = trace.split("},");
      	  for(String logss:logs){
      		 logss.replace("{", "");
      		//System.out.println("11："+logss);{"AcceptStation":"客户已签收","AcceptTime":"2016-03-04 11:50:31","Remark":""}
      		 String[] infos = logss.split(",");//"AcceptStation":"已取件，到达 [北京运转中心] "
      		 for(String infoc:infos){
      			//System.out.println("22："+infoc);//{"AcceptStation":"已取件，到达 [北京运转中心] "
      			if(infoc.indexOf("AcceptStation")>-1){
      				 String[] infod = infoc.split("\":"); 
      				if(infod.length==2){
   					 System.out.println("事件："+infod[1].replace("\"", ""));
   				   }
    			 }
    			if(infoc.indexOf("AcceptTime")>-1){
    				 String[] infod = infoc.split("\":"); 
    				 if(infod.length==2){
    					 System.out.println("时间："+infod[1].replace("\"", ""));
    				 }
   			    }
      			 
      			 
      		 }
      		 
      		 
      	  }
            /*
             * kuaidi.setEBusinessID(map.get("EBusinessID"));
             * kuaidi.setShipperCode(map.get("shipperCode"));
             * kuaidi.setLogisticCode(map.get("LogisticCode"));
             * kuaidi.setState(Integer.parseInt(map.get("State")));
             * kuaidi.setSuccess(map.get("Success"));
             * kuaidi.setReason(map.get("Reason")); // String trace =
             * kuaidi.getStateString();
             * 
             * 
             * // String trace = map.get("Traces");
             */
            //System.out.println(kuaidi.getTraces());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

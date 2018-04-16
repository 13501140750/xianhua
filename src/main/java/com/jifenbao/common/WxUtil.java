package com.jifenbao.common; 
/** 
* @author 作者 wangyawei: 
* @version 创建时间：2017年12月13日 下午3:41:15 
* 类说明 
*/
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStore;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.builder.BuilderException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.jifenbao.model.WxBill;
import com.jifenbao.thirdAPI.WxPayConfig;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.tools.util.DateTimeUtil;

@SuppressWarnings("all")
public class WxUtil {
	 /**  
     * 签名字符串  
     * @param text需要签名的字符串  
     * @param key 密钥  
     * @param input_charset编码格式  
     * @return 签名结果  
     */   
    public static String sign(String text, String key, String input_charset) {   
        text = text + "&key=" + key;   
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));   
    }   
    /**  
     * 签名字符串  
     * @param text需要签名的字符串  
     * @param key 密钥  
     * @param input_charset编码格式  
     * @return 签名结果  
     */   
    public static String sign(Map<String, String> params, String key, String input_charset) { 
    	String text = WxUtil.createLinkString(params);
        text = text + "&key=" + key;   
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));   
    } 
    /**  
     * 签名字符串  
     *  @param text需要签名的字符串  
     * @param sign 签名结果  
     * @param key密钥  
     * @param input_charset 编码格式  
     * @return 签名结果  
     */   
    public static boolean verify(String text, String sign, String key, String input_charset) {   
    	String mysign = WxUtil.sign(text, key, input_charset).toUpperCase();
        if (mysign.equals(sign)) {   
            return true;   
        } else {   
            return false;   
        }   
    }   
    /**  
     * @param content  
     * @param charset  
     * @return  
     * @throws SignatureException  
     * @throws UnsupportedEncodingException  
     */   
    public static byte[] getContentBytes(String content, String charset) {   
        if (charset == null || "".equals(charset)) {   
            return content.getBytes();   
        }   
        try {   
            return content.getBytes(charset);   
        } catch (UnsupportedEncodingException e) {   
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);   
        }   
    }   
    
    public static boolean isValidChar(char ch) {   
        if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))   
            return true;   
        if ((ch >= 0x4e00 && ch <= 0x7fff) || (ch >= 0x8000 && ch <= 0x952f))   
            return true;// 简体中文汉字编码   
        return false;   
    }   
    /**  
     * 除去数组中的空值和签名参数  
     * @param sArray 签名参数组  
     * @return 去掉空值与签名参数后的新签名参数组  
     */   
    public static Map<String, String> paraFilter(Map<String, String> sArray) {   
        Map<String, String> result = new HashMap<String, String>();   
        if (sArray == null || sArray.size() <= 0) {   
            return result;   
        }   
        for (String key : sArray.keySet()) {   
            String value = sArray.get(key);   
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")   
                    || key.equalsIgnoreCase("sign_type")) {   
                continue;   
            }   
            result.put(key, value);   
        }   
        return result;   
    }   
    /**  
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串  
     * @param params 需要排序并参与字符拼接的参数组  
     * @return 拼接后字符串  
     */   
    public static String createLinkString(Map<String, String> params) {   
        List<String> keys = new ArrayList<String>(params.keySet());   
        Collections.sort(keys);   
        String prestr = "";   
        for (int i = 0; i < keys.size(); i++) {   
            String key = keys.get(i);   
            String value = params.get(key);   
            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符   
                prestr = prestr + key + "=" + value;   
            } else {   
                prestr = prestr + key + "=" + value + "&";   
            }   
        }   
        return prestr;   
    }   
    /**  
     *  
     * @param requestUrl请求地址  
     * @param requestMethod请求方法  
     * @param outputStr参数  
     */   
    public static String httpRequest(String requestUrl,String requestMethod,String outputStr){   
        // 创建SSLContext   
        StringBuffer buffer = null;   
        try{   
	        URL url = new URL(requestUrl);   
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();   
	        conn.setRequestMethod(requestMethod);   
	        conn.setDoOutput(true);   
	        conn.setDoInput(true);   
	        conn.connect();   
	        //往服务器端写内容   
	        if(null !=outputStr){   
	            OutputStream os=conn.getOutputStream();   
	            os.write(outputStr.getBytes("utf-8"));   
	            os.close();   
	        }   
	        // 读取服务器端返回的内容   
	        InputStream is = conn.getInputStream();   
	        InputStreamReader isr = new InputStreamReader(is, "utf-8");   
	        BufferedReader br = new BufferedReader(isr);   
	        buffer = new StringBuffer();   
	        String line = null; 
	        while ((line = br.readLine()) != null) {   
	        	buffer.append(line);   
	        }   
        }catch(Exception e){   
            e.printStackTrace();   
        }
        return buffer.toString();
    }     
    public static String urlEncodeUTF8(String source){   
        String result=source;   
        try {   
            result=java.net.URLEncoder.encode(source, "UTF-8");   
        } catch (UnsupportedEncodingException e) {   
            // TODO Auto-generated catch block   
            e.printStackTrace();   
        }   
        return result;   
    } 
	/**
	 * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
	 * @param strxml
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static Map doXMLParse(String strxml) throws Exception {
		if(null == strxml || "".equals(strxml)) {
			return null;
		}
		
		Map m = new HashMap();
		InputStream in = String2Inputstream(strxml);
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(in);
		Element root = doc.getRootElement();
		List list = root.getChildren();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Element e = (Element) it.next();
			String k = e.getName();
			String v = "";
			List children = e.getChildren();
			if(children.isEmpty()) {
				v = e.getTextNormalize();
			} else {
				v = getChildrenText(children);
			}
			
			m.put(k, v);
		}
		
		//关闭流
		in.close();
		
		return m;
	}
	/**
	 * 获取子结点的xml
	 * @param children
	 * @return String
	 */
	public static String getChildrenText(List children) {
		StringBuffer sb = new StringBuffer();
		if(!children.isEmpty()) {
			Iterator it = children.iterator();
			while(it.hasNext()) {
				Element e = (Element) it.next();
				String name = e.getName();
				String value = e.getTextNormalize();
				List list = e.getChildren();
				sb.append("<" + name + ">");
				if(!list.isEmpty()) {
					sb.append(getChildrenText(list));
				}
				sb.append(value);
				sb.append("</" + name + ">");
			}
		}
		
		return sb.toString();
	}
	public static InputStream String2Inputstream(String str) {
		return new ByteArrayInputStream(str.getBytes());
	}
	
	/** 
     * StringUtils工具类方法 
     * 获取一定长度的随机字符串，范围0-9，a-z 
     * @param length：指定字符串长度 
     * @return 一定长度的随机字符串 
     */  
    public static String getRandomStringByLength(int length) {  
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";  
        Random random = new Random();  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < length; i++) {  
            int number = random.nextInt(base.length());  
            sb.append(base.charAt(number));  
        }  
        return sb.toString();  
       }  
    /** 
     * IpUtils工具类方法 
     * 获取真实的ip地址 
     * @param request 
     * @return 
     */  
    public static String getIpAddr(HttpServletRequest request) {  
        String ip = request.getHeader("X-Forwarded-For");  
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){  
             //多次反向代理后会有多个ip值，第一个ip才是真实ip  
            int index = ip.indexOf(",");  
            if(index != -1){  
                return ip.substring(0,index);  
            }else{  
                return ip;  
            }  
        }  
        ip = request.getHeader("X-Real-IP");  
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){  
           return ip;  
        }  
        return request.getRemoteAddr();  
    } 
    
    
    /**
     * 将请求参数转换为xml格式的string字符串，微信服务器接收的是xml格式的字符串
     * @param parameters
     * @return
     */
    public static String getRequestXml(Map<String, String> params) {
    	List<String> keys = new ArrayList<String>(params.keySet());   
        Collections.sort(keys); 
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        
        for (String k : keys) {
        	String v = params.get(k);
        	if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
            } else {
                sb.append("<" + k + ">" + v + "</" + k + ">");
            }
		}
        
        sb.append("</xml>");
        return sb.toString();
    }
    
    
    
    /**
     * 退款
     */
    @SuppressWarnings("all")
   public static Map<String, String> doRefund(String url,String data,String partner) throws Exception {
        //p12证书的位置
        //微信公众平台：“微信支付”--》“商户信息”--》“交易数据”--》“详情请登录微信支付商户平台查看”（登录）--》“API安全”--》“API证书”--》“下载证书”
        //下载证书后将apiclient_cert.p12放在src目录下面（出于安全考虑，请自行下载自己的证书）
        String apiclient_certLocation = "apiclient_cert.p12";
        KeyStore keyStore  = KeyStore.getInstance("PKCS12");
//        String p2Url = WxPayConfig.p2Url;
        String p2Url = "E:\\jifenbao\\cert\\apiclient_cert.p12";
//        String p2Url = "/root/cert/apiclient_cert.p12";
        FileInputStream instream = new FileInputStream(new File(p2Url));//P12文件目录
        try {
            keyStore.load(instream, partner.toCharArray());
        } finally {
            instream.close();
        }
        
		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, partner.toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,new String[] { "TLSv1" }, null,SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try {
            HttpPost httpost = new HttpPost(url); // 设置响应头信息
            httpost.addHeader("Connection", "keep-alive");
            httpost.addHeader("Accept", "*/*");
            httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpost.addHeader("Host", "api.mch.weixin.qq.com");
            httpost.addHeader("X-Requested-With", "XMLHttpRequest");
            httpost.addHeader("Cache-Control", "max-age=0");
            httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
            httpost.setEntity(new StringEntity(data, "UTF-8"));
            CloseableHttpResponse response = httpclient.execute(httpost);
            try {
                HttpEntity entity = response.getEntity();
                String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
                EntityUtils.consume(entity);
                return WxUtil.doXMLParse(jsonStr);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
    
    /**
     * 微信下载对账单
     * @return 
     * @throws Exception 
     */
    public static String[] downloadBill(String bill_date, String bill_type) throws Exception{
    	Map<String, String> packageParams = new HashMap<String, String>();
        packageParams.put("appid",WxPayConfig.api_id);
        packageParams.put("mch_id",WxPayConfig.mch_id);
        packageParams.put("op_user_id",WxPayConfig.mch_id);
        packageParams.put("nonce_str", WxUtil.getRandomStringByLength(32));
        packageParams.put("bill_date", bill_date);//生成的随机字符串  
        packageParams.put("bill_type",bill_type);
//        packageParams.put("tar_type","GZIP");
        String prestr = WxUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串   
        String sign = WxUtil.sign(prestr, WxPayConfig.key, "utf-8").toUpperCase();
        packageParams.put("sign", sign);
        String xml = WxUtil.getRequestXml(packageParams);

		String result = WxUtil.httpRequest(WxPayConfig.bill_url, "POST", xml);
		System.out.println(result);
		
		if(result.contains("<xml><return_code><![CDATA[FAIL]]></return_code>")){
			throw new BusinessException("查询失败");
		}
		
		//①把第一行表头去掉
		String tradeMsg = result.substring(result.indexOf("`"));
		System.out.println(tradeMsg);
		//②去掉汇总数据，并且去掉"`"这个符号
		String tradeInfo = tradeMsg.substring(0, tradeMsg.indexOf("总")).replace("`", "");// 去掉汇总数据，并且去掉'`'
		System.out.println(tradeInfo);
		//③用spilt方法拿出每一天数据放进数组里。之后再用spilt方法把数据放进二维数组里。
		String[] tradeArray = tradeInfo.split("%");  // 根据%来区分
		return tradeArray;
    }
    
    
    
    /**
     * 查询退款订单
     * @throws Exception 
     */
    public static Map<String, Object> refundQuery(String out_refund_no) throws Exception{
    	Map<String, String> packageParams = new HashMap<String, String>();
        packageParams.put("appid",WxPayConfig.api_id);
        packageParams.put("mch_id",WxPayConfig.mch_id);
        packageParams.put("nonce_str", WxUtil.getRandomStringByLength(32));
        packageParams.put("out_refund_no", out_refund_no);
        String prestr = WxUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串   
        String sign = WxUtil.sign(prestr, WxPayConfig.key, "utf-8").toUpperCase();
        packageParams.put("sign", sign);
        String xml = WxUtil.getRequestXml(packageParams);

		String xmlResult = WxUtil.httpRequest(WxPayConfig.refundquery_url, "POST", xml);
		Map map = WxUtil.doXMLParse(xmlResult);
		return map;
    }
    
    
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param requestUrlParam
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return String 所代表远程资源的响应结果
     */
    public static String get(String urlNameString){
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            /*for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }*/
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    
    /**  
     *   
     * 功能描述：去除字符串首部为"0"字符  
        
     * @param str 传入需要转换的字符串  
     * @return 转换后的字符串  
     */  
    public static String removeZero(String str){     
        char  ch;    
        String result = "";  
        if(str != null && str.trim().length()>0 && !str.trim().equalsIgnoreCase("null")){                  
            try{              
                for(int i=0;i<str.length();i++){  
                    ch = str.charAt(i);  
                    if(ch != '0'){                        
                        result = str.substring(i);  
                        break;  
                    }  
                }  
            }catch(Exception e){  
                result = "";  
            }     
        }else{  
            result = "";  
        }  
        return result;  
              
    }  
    
    
    /**  
     *   
     * 功能描述：金额字符串转换：单位元转成单分  
       
     * @param str 传入需要转换的金额字符串  
     * @return 转换后的金额字符串  
     */       
    public static String yuanToFen(Object o) {  
        if(o == null)  
            return "0";  
        String s = o.toString();  
        int posIndex = -1;  
        String str = "";  
        StringBuilder sb = new StringBuilder();  
        if (s != null && s.trim().length()>0 && !s.equalsIgnoreCase("null")){  
            posIndex = s.indexOf(".");  
            if(posIndex>0){  
                int len = s.length();  
                if(len == posIndex+1){  
                    str = s.substring(0,posIndex);  
                    if(str == "0"){  
                        str = "";  
                    }  
                    sb.append(str).append("00");  
                }else if(len == posIndex+2){  
                    str = s.substring(0,posIndex);  
                    if(str == "0"){  
                        str = "";  
                    }  
                    sb.append(str).append(s.substring(posIndex+1,posIndex+2)).append("0");  
                }else if(len == posIndex+3){  
                    str = s.substring(0,posIndex);  
                    if(str == "0"){  
                        str = "";  
                    }  
                    sb.append(str).append(s.substring(posIndex+1,posIndex+3));  
                }else{  
                    str = s.substring(0,posIndex);  
                    if(str == "0"){  
                        str = "";  
                    }  
                    sb.append(str).append(s.substring(posIndex+1,posIndex+3));  
                }  
            }else{  
                sb.append(s).append("00");  
            }  
        }else{  
            sb.append("0");  
        }  
        str = removeZero(sb.toString());  
        if(str != null && str.trim().length()>0 && !str.trim().equalsIgnoreCase("null")){  
            return str;  
        }else{  
            return "0";  
        }  
    }  
   
   
    
    public static void main(String[] args) {
//    	String randomStringByLength = WxUtil.getRandomStringByLength(32);
//    	System.out.println(randomStringByLength);
    	
    	String dateStr = DateTimeUtil.format(DateTimeUtil.addDay(-1), "YYYYMMdd");
		try {
			WxUtil.downloadBill(dateStr, "ALL");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	String resource = WxUtil.class.getClassLoader().getResource("/apiclient_cert.p12").getPath();
//    	System.out.println(resource);
    	/*try {
			Map<String, Object> refundQuery = WxUtil.refundQuery("tk0001");
			System.out.println(refundQuery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	
    	
	}
    
    
}
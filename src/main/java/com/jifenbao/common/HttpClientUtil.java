package com.jifenbao.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;

/**
 * Http客户端工具类<br/>
 * 这是内部调用类，请不要在外部调用。
 * @author miklchen
 *
 */
public class HttpClientUtil {
	
	/** 
     * @param args 
     * @throws IOException  
     * @throws ClientProtocolException  
     */  
    public static String sendGetHttpMethod(String url) 
    {  
    	String content = "";
        // 创建HttpClient实例     
        HttpClient httpclient = new HttpClient();  
        // 创建Get方法实例     
        GetMethod  getmethod=new GetMethod (url); 
        int sendStatus=0;  
        try {  
        	
            sendStatus = httpclient.executeMethod(getmethod); 
            if(sendStatus==200){
            	content = new String(getmethod.getResponseBody(),"UTF-8");
            }else{
            	System.out.println(new String(getmethod.getResponseBody(),"UTF-8"));
            }
            
        } catch (HttpException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            //释放  
        	getmethod.releaseConnection();  
        }
        return content;
    }  
      
    public static String sendPostHttpMethod(String url) { 
    	String content = "";
        // 创建HttpClient实例     
        HttpClient httpclient = new HttpClient();  
        // 创建Get方法实例     
        PostMethod  postmethod=new PostMethod (url); 
        int sendStatus=0;  
        try {  
            sendStatus=httpclient.executeMethod(postmethod);  
          
            content = new String(postmethod.getResponseBody(),"UTF-8"); 
        } catch (HttpException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }finally{  
            //释放  
            postmethod.releaseConnection();  
        }
        return content;
    }  
    
    
    public static void main(String[] args){
    	String url="http://api.map.baidu.com/location/ip?ak=sstRaZRnP4WMFlKYg8vMj6UFW1CB8OzO&ip=115.28.50.217&coor=bd09ll";
    	String content = HttpClientUtil.sendGetHttpMethod(url);
    	try {
    		Map<String,String> map = JsonHelper.toMap(content);
			Map<String,String> submap =  JsonHelper.toMap(map.get("content"));
			Map<String,String> submap1 =  JsonHelper.toMap(submap.get("address_detail"));
			System.out.println(submap1.get("province"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
    
    /** 
     * @param agentImgDownloadUrl 
     * @param reqUrl 
     *            基础的url地址 
     * @param params 
     *            查询参数 
     * @return 构建好的url 
     */  
           
       
    public static String httpPostWithJSON(String url, String json,String openid, String uploadSysUrl)  
            throws Exception {  
        String result = null;  
        // 将JSON进行UTF-8编码,以便传输中文  
        String encoderJson = URLEncoder.encode(json, HTTP.UTF_8);   
        DefaultHttpClient httpClient = new DefaultHttpClient();  
        HttpPost httpPost = new HttpPost(url);  
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");    
        StringEntity se = new StringEntity(json);  
        se.setContentType("application/json");  
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"UTF-8"));  
        httpPost.setEntity(se);  
        // httpClient.execute(httpPost);  
        HttpResponse response = httpClient.execute(httpPost);  
        if (response != null) {  
            HttpEntity resEntity = response.getEntity();  
            if (resEntity != null) {  
                InputStream instreams = resEntity.getContent();   
                File saveFile = new File(uploadSysUrl+openid+".jpg");  
                   // 判断这个文件（saveFile）是否存在  
                   if (!saveFile.getParentFile().exists()) {  
                       // 如果不存在就创建这个文件夹  
                       saveFile.getParentFile().mkdirs();  
                   }  
                saveToImgByInputStream(instreams, uploadSysUrl, openid+".jpg");  
            }  
        }  
        return result;  
    }   
       
    /* @param instreams 二进制流 
    * @param imgPath 图片的保存路径 
    * @param imgName 图片的名称 
    * @return 
    *      1：保存正常 
    *      0：保存失败 
    */  
   public static int saveToImgByInputStream(InputStream instreams,String imgPath,String imgName) throws FileNotFoundException{  
    
       int stateInt = 1;  
       File file=new File(imgPath,imgName);//可以是任何图片格式.jpg,.png等  
       FileOutputStream fos=new FileOutputStream(file);  
       if(instreams != null){  
           try {  
                                   
               byte[] b = new byte[1024];  
               int nRead = 0;  
               while ((nRead = instreams.read(b)) != -1) {  
                   fos.write(b, 0, nRead);  
               }  
                                
           } catch (Exception e) {  
               stateInt = 0;  
               e.printStackTrace();  
           } finally {  
                 
               try {  
                   fos.flush();  
                   fos.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }   
           }  
       }  
       return stateInt;  
   }        
   public static boolean exists(String imgPath){  
       File saveFile = new File(imgPath);  
       if (!saveFile.getParentFile().exists()) {  
           return false;  
       }else{  
           //如果存在判断这个文件的大小  
           if(saveFile.length()>0){  
               System.out.println("--------------------------------"+saveFile.length());  
               return true;  
           }else{  
               return false;  
           }  
       }  
       
   }        
   /** 
    * 向指定URL发送GET方法的请求 
    *  
    * @param url 
    *            发送请求的URL 
    * @param param 
    *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。 
    * @return URL 所代表远程资源的响应结果 
    */  
   public static String sendGet(String url, String param) {  
       String result = "";  
       BufferedReader in = null;  
       try {  
           String urlNameString = url + "?" + param;  
           System.out.println(urlNameString+"........");  
           URL realUrl = new URL(urlNameString);  
           // 打开和URL之间的连接  
           URLConnection connection = realUrl.openConnection();  
           // 设置通用的请求属性  
           connection.setRequestProperty("accept", "*/*");  
           connection.setRequestProperty("connection", "Keep-Alive");  
           connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");  
           // 建立实际的连接  
           connection.connect();  
           // 获取所有响应头字段  
           Map<String, List<String>> map = connection.getHeaderFields();  
           // 遍历所有的响应头字段  
           for (String key : map.keySet()) {  
               System.out.println(key + "--->" + map.get(key));  
           }  
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
   
     
     
   public static Object httpPostWithJSON2(String url, String json,String id)  
           throws Exception {  
       // 将JSON进行UTF-8编码,以便传输中文  
       InputStream instreams = null;  
       String encoderJson = URLEncoder.encode(json, HTTP.UTF_8);   
       DefaultHttpClient httpClient = new DefaultHttpClient();  
       HttpPost httpPost = new HttpPost(url);  
       httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");    
       StringEntity se = new StringEntity(json);  
       se.setContentType("application/json");  
       se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"UTF-8"));  
       httpPost.setEntity(se);  
       // httpClient.execute(httpPost);  
       HttpResponse response = httpClient.execute(httpPost);  
       if (response != null) {  
           HttpEntity resEntity = response.getEntity();  
           if (resEntity != null) {  
                instreams = resEntity.getContent();   
               
           }  
       }  
       return instreams;  
   }  
}

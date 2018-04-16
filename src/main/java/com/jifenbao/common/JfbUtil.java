package com.jifenbao.common;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;

import com.jifenbao.thirdAPI.CurrentPosModel;
import com.otc.framework.tools.util.DateTimeUtil;
import com.otc.framework.tools.util.security.MD5Util;


public class JfbUtil {

	public static String createCode(){
		StringBuffer bf = new StringBuffer();
		Date now =new Date();
		String curTime = DateTimeUtil.format(now, "yyyyMMdd");
		bf.append(curTime).append(RandomStringUtils.randomNumeric(4));
		return bf.toString();
	}
	
	public static String createCode(Integer number){
		StringBuffer bf = new StringBuffer();
		Date now =new Date();
		String curTime = DateTimeUtil.format(now, "yyyyMMddHHmmss");
		if(number == null){
			bf.append(curTime).append(RandomStringUtils.randomNumeric(4));
		}else{
			bf.append(curTime).append(RandomStringUtils.randomNumeric(number));
		}
		return bf.toString();
	}
	
	public static String getMd5 (String password){
		return MD5Util.getMD5String(password);
	}
	
	
	
	public static int  doubleMult(Double double1,Double double2){
    	
		BigDecimal a1 = new BigDecimal(Double.toString(double1));
		BigDecimal b1 = new BigDecimal(Double.toString(double2));
		BigDecimal result = a1.multiply(b1);
		return (int)Math.ceil(result.doubleValue());
    }
	
	 public static int  doubleMult(Double price,String rate){
	    	
			BigDecimal a1 = new BigDecimal(Double.toString(price));
			BigDecimal b1 = new BigDecimal(rate);
			BigDecimal result = a1.multiply(b1);
			return result.intValue();
	    }
	 
	 public static String getSearchUrl(String queryString,String queryType){
		 StringBuffer bf = new StringBuffer();
		 String url = "";
		 if(StringUtils.isNotBlank(queryString)){
			  String[] querys = queryString.split("&");
			  for(String query:querys){
				  if(query.indexOf(queryType)<0 && query.indexOf("pageNo")<0 ){
					  bf.append("&").append(query);
				  }
			  }
			  url =  bf.toString();
			  if(url.startsWith("&")){
				  url = url.substring(1);
			  }
		 }else{
			 url="1=1";
		 }
		
		
		 return url;
	 }
	
	 /**
	  * 通过星期数字获取对应的汉字
	  * @param weekNum
	  * @return
	  */
	 public static String getWeekFormNum(int weekNum){
		
		 switch(weekNum){
		 
		 case 1:
			 return "星期日";
		 case 2:
			 return "星期一";
		 case 3:
			 return "星期二";
		 case 4:
			 return "星期三";
		 case 5:
			 return "星期四";
		 case 6:
			 return "星期五";
		 case 7:
			 return "星期六";
		 }
			
		 return "";
	 }
	 
	 /**
	  * 通过访问者IP定位所在城市
	  * @param ip
	  */
	 @SuppressWarnings("unchecked")
	 public static CurrentPosModel  getClientCity(HttpServletRequest request){
		 CurrentPosModel currPos = new CurrentPosModel();
		 String ip = JfbUtil.getIpAddress(request);
		 String url = "http://api.map.baidu.com/location/ip?ak=sstRaZRnP4WMFlKYg8vMj6UFW1CB8OzO&ip="+ip+"&coor=bd09ll";
	     String content = HttpClientUtil.sendGetHttpMethod(url);
	     try {
	    	 if(StringUtils.isNotBlank(content)){
	    		 Map<String,String> map = JsonHelper.toMap(content);
	    		 if(map.get("status")!=null && map.get("status").equals("1")){
	    			 
	    		 }else{
	    			 currPos.setAddress(map.get("address"));
		    		 Map<String,String> submap =  JsonHelper.toMap(map.get("content"));
		    		 currPos.setSubAddress(submap.get("address"));
		    		 Map<String,String> submap1 =  JsonHelper.toMap(submap.get("address_detail"));
		    		 Map<String,String> point =  JsonHelper.toMap(submap.get("point"));
		    		 currPos.setCity(submap1.get("city"));
		    		 currPos.setCityCode(submap1.get("city_code"));
		    		 currPos.setDistrict(submap1.get("district"));
		    		 currPos.setProvince(submap1.get("province"));
		    		 currPos.setStreet(submap1.get("street"));
		    		 currPos.setStreetNumber(submap1.get("street_number"));
		    		 currPos.setPointX(point.get("x"));
		    		 currPos.setPointY(point.get("y"));
	    		 }
	    			 
	    		
	    		 
	    	 }
	    	 
	    	 
	    	 
	    	 
				//province = submap1.get("city");
//				city = submap1.get("city");
//				if(!province.equals(city)){
//					province = city;
//				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
	     return currPos;
	 }
	 
	 /**
	  * 获取访问者IP
	  * @param request
	  * @return
	  * @throws IOException
	  */
	 public static String getIpAddress(HttpServletRequest request)  {  
	        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址  
	  
	        String ip = request.getHeader("X-Forwarded-For");  
	         
	  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("Proxy-Client-IP");  
	              }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("WL-Proxy-Client-IP");  
	             }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("HTTP_CLIENT_IP");  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
	             }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getRemoteAddr();  
	             }  
	        } else if (ip.length() > 15) {  
	            String[] ips = ip.split(",");  
	            for (int index = 0; index < ips.length; index++) {  
	                String strIp = (String) ips[index];  
	                if (!("unknown".equalsIgnoreCase(strIp))) {  
	                    ip = strIp;  
	                    break;  
	                }  
	            }  
	        }
	        if(ip.equals("0:0:0:0:0:0:0:1") || ip.equals("127.0.0.1")){
	        	ip="123.117.83.24";
	        }
	       
	        
	        return ip;  
	    }
	 
	 
	 /** 
	     * 获取当前网络ip 
	     * @param request 
	     * @return 
	     */  
	    public static String getIpAddr(HttpServletRequest request){  
	        String ipAddress = request.getHeader("x-forwarded-for");  
	            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	                ipAddress = request.getHeader("Proxy-Client-IP");  
	            }  
	            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	                ipAddress = request.getHeader("WL-Proxy-Client-IP");  
	            }  
	            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	                ipAddress = request.getRemoteAddr();  
	                if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
	                    //根据网卡取本机配置的IP  
	                    InetAddress inet=null;  
	                    try {  
	                        inet = InetAddress.getLocalHost();  
	                    } catch (UnknownHostException e) {  
	                        e.printStackTrace();  
	                    }  
	                    ipAddress= inet.getHostAddress();  
	                }  
	            }  
	            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
	            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
	                if(ipAddress.indexOf(",")>0){  
	                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
	                }  
	            }  
	            return ipAddress;   
	    }
	 
	 public static  Integer  getIngerFromDouble(Double num){
		 return num.intValue();
	 }
	 
	 /**
	  * 对卡号密码加密
	  * @param cardNo
	  * @param pwd
	  * @return
	  */
	 public static String getSign(String cardNo,String pwd){
		 String key= "BJVDxlgUltYQsahL";
		 String signString="cardNo="+cardNo+"&pwd="+pwd+"key="+key;
		 return   MD5Util.getMD5String(signString);
	 }
	 
	public static void main(String[] args){
		System.out.println(JfbUtil.getMd5("0012"));
	}
}

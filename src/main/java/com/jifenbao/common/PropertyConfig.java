package com.jifenbao.common;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.support.ResourcePropertySource;

public class PropertyConfig {
	static Log log= LogFactory.getLog(PropertyConfig.class);
	/**
	 * 通过key值获取配置文件value值
	 * @param key
	 * @return
	 */
  public  static String getPropertyValue(String key){
	  String value="";
	  ResourcePropertySource propertySource;
		try {
			propertySource = new ResourcePropertySource("resource", "classpath:config/jfb_config.properties");
			value = propertySource.getProperty(key).toString();
			return value;
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			log.error(e.getMessage());
		}
      return  value;
  }
  
  /**
   * 通过key获取相应的value值
   * @param key  key name
   * @param defValue  为空时的默认值
   * @return
   */
  public  static String getPropertyValue(String key,String defValue){
	  String value="";
	  ResourcePropertySource propertySource;
		try {
			propertySource = new ResourcePropertySource("resource", "classpath:service.properties");
			value = propertySource.getProperty(key).toString();
			return value;
			
		} catch (IOException e) {
			log.error(e.getMessage());
		}
    return  defValue;
 }
  
  public  static  void  main(String[] args){
	  String value = PropertyConfig.getPropertyValue("upload.allowd.img");
	 // String devalue = PropertyConfig.getPropertyValue("userId","tmallInterface");
	  System.out.println(value);
	  //System.out.println(devalue);
  }
}

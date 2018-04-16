package com.jifenbao.common;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;

import com.otc.framework.utils.DateTimeUtil;

public class FileUploadConfig {
	/**
	 * 获取上传图片路径
	 * @param fileName
	 * @param fileType
	 * @return
	 */
  public static String getFilePath(String fileName,String fileType){
	 StringBuffer path = new StringBuffer();
	 StringBuffer imgPath = new StringBuffer();
	 String dir =  PropertyConfig.getPropertyValue("uploadDir");//上次目录
	 String datefolder =  DateTimeUtil.format(DateTimeUtil.now(), "yyyy-MM-dd");//当前日期文件夹
	 imgPath.append(PropertyConfig.getPropertyValue("uploadFloder")).append("/")
	       .append(fileType).append("/").append(datefolder);//保存到数据库中的图片路径
	 path.append(dir).append("/").append(imgPath.toString());
     File file = new File(path.toString()) ;
     if(!file.exists()){
    	 file.mkdirs();
     }
     
     int endInx = fileName.lastIndexOf(".");
     String endName = fileName.substring(endInx+1,fileName.length());
     String firstName = DateTimeUtil.getCurrentTimeMillis()+RandomStringUtils.randomNumeric(6);
     imgPath.append("/").append(firstName).append(".").append(endName);
	 return imgPath.toString();
  }
  
  public static void main(String[] args){
	  System.out.println(FileUploadConfig.getFilePath("11.jpg", "img"));
  }
}

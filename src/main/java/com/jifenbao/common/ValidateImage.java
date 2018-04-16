package com.jifenbao.common;

import java.io.File;
import java.util.Date;

import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.web.multipart.MultipartFile;

import com.otc.framework.utils.DateTimeUtil;

/*
 * 校验上传图片大小格式是否正确
 */
public class ValidateImage {
	
	/**
	 * validate  image size
	 * @param imageFile  
	 * @param maxSize 
	 * @return
	 */
   public Boolean validateSize(MultipartFile imageFile,Long maxSize){
	   Long imgSize = imageFile.getSize();
	   if(imgSize>maxSize)
	     return  false;
	   else
		 return true;
   }
   
   /**
    * validate  image type 
    * @param imageFile
    * @param type
    * @return
    */
   public Boolean  validateType(MultipartFile imageFile,String type){
	   String  imgType = imageFile.getContentType();
	   if(type.indexOf(imgType)>-1)
	     return true;
	   else return false;
   }
   
   /**
    * validate  image size  and  type
    * @param imageFile
    * @param maxSize
    * @param type
    * @return
    */
   public Boolean validateImg(MultipartFile imageFile,Long maxSize,String type){
	   if(validateSize(imageFile,maxSize)){
		   if(validateType(imageFile,type))
			   return true;
		   else return  false;
	   }else{
		   return false;
	   }
		   
   }
   
   /**
    * upload  image 
    * @param imageFile
    * @param uploadPath  
    * @return
    */
   public String uploadImg(MultipartFile imageFile,String uploadPath){
	    String imageUrlPath = "";
	    Date now = new Date();
	    String str = DateTimeUtil.format(now, "yyyyMMdd");
	    //create upload  floder
	    String floder = "/"+str;
	   
	    String imagePath  = uploadPath+floder;
		String tagFileName = "";
		
		String fileName = imageFile.getOriginalFilename();  
		if(fileName.indexOf(".")>-1){
			   tagFileName = this.getImageName(fileName);
		}else{
			return "";
		}
       File targetFile = new File(imagePath, tagFileName);  
       if(!targetFile.exists()){  
         targetFile.mkdirs();  
       }
       //保存  
       try {  
       	   imageFile.transferTo(targetFile); 
           imageUrlPath = floder+"/"+tagFileName;
       } catch (Exception e) {  
           e.printStackTrace();  
       }
     
		return imageUrlPath;
   }
   
   
   
   public String getImageName(String fileName) {
       Date date = new Date();
       Long d = date.getTime();
       String name = d + "";
       
       String endSring = fileName.substring(fileName.lastIndexOf("."),
               fileName.length());
       name += endSring;
       return name;
   }
	   
   public void deleteFile(String filePath){
	   File file = new File(filePath);
	   if(file.exists()){
		   file.delete();
	   }
   }
}

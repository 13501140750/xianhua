package com.jifenbao.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	
	String BEAN_NAME="fileUploadService";
	
	
	
	/**
	 * 校验图片格式大小等
	 * @param imgFile
	 * @return 
	 */
	Boolean checkFile(MultipartFile imgFile);
	
	
	/**
	 * 校验图片格式大小等
	 * @param imgFile
	 * @return 
	 */
	Boolean checkImage(MultipartFile imgFile) ;
	
	/**
	 * 获取上传的图片
	 * @param imgFile
	 * @return 显示图片的路径
	 */
	String getFile(MultipartFile imgFile,String fileType)  throws IOException; 
}

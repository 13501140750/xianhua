package com.jifenbao.service.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jifenbao.common.BusinessErrorCodeEx;
import com.jifenbao.common.FileUploadConfig;
import com.jifenbao.common.PropertyConfig;
import com.jifenbao.service.FileUploadService;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.utils.io.FileUtil;



@Service(FileUploadService.BEAN_NAME)
public class FileUploadServiceImpl implements FileUploadService{
	protected final transient Log logger = LogFactory.getLog(getClass());

	@Resource
	private Environment env;
	
	@Override
	public Boolean checkFile(MultipartFile imgFile) {
		String fileType = env.getProperty("upload.allowd.file");
		String fileSise = env.getProperty("web.file.maxUploadSize");
		if(imgFile!=null){
			String type = imgFile.getContentType();
			if(fileType.indexOf(type)<=-1){
				logger.info("文件格式不正确");
				throw new BusinessException(BusinessErrorCodeEx.MSG_JF_FILE_0001);
			}
			Long size = imgFile.getSize();
			Long maxSize = Long.parseLong(fileSise);
			if(maxSize<size){
				logger.info("文件超过允许的最大值"+(maxSize/1024/10)+"M");
				throw new BusinessException(BusinessErrorCodeEx.MSG_JF_FILE_0002);
			}
		}
		return true;
	}

	@Override
	public String getFile(MultipartFile imgFile,String fileType) throws IOException {
		  if(this.checkImage(imgFile)){
			String fileName = imgFile.getOriginalFilename();
		    String path = "";
			String dir =  PropertyConfig.getPropertyValue("uploadDir");
			String  filePath = FileUploadConfig.getFilePath(fileName,fileType);
			path = dir + "/" + filePath;
			logger.info("上传图片路径为："+path);
			File file = FileUtil.createFile(path);
			imgFile.transferTo(file);
			return filePath.toString();
		  }
		
		 return null;
	}

	@Override
	public Boolean checkImage(MultipartFile imgFile) throws BusinessException{
		String fileType = env.getProperty("upload.allowd.file");
		String fileSize = env.getProperty("web.file.maxUploadSize");
		logger.info("fileType"+fileType+"======="+"fileSize"+fileSize);
		
		String imgFileType = PropertyConfig.getPropertyValue("upload.allowd.imagetype");
		String imgMaxSise =  PropertyConfig.getPropertyValue("web.img.maxUploadSize");
		if(imgFile!=null){
			String type = imgFile.getContentType();
			if(imgFileType.indexOf(type)<=-1){
				logger.info("图片格式不正确");
				throw new BusinessException(BusinessErrorCodeEx.MSG_JF_IMG_0001);
			}
			Long size = imgFile.getSize();
			Long maxSize = Long.parseLong(imgMaxSise);
			if(maxSize<size){
				logger.info("图片超过允许的最大值"+(maxSize/1024/10)+"M");
				throw new BusinessException(BusinessErrorCodeEx.MSG_JF_IMG_0002);
			}
		}
		return true;
	}
	
	
}

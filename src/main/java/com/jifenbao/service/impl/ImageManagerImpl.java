/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jifenbao.common.BusinessErrorCodeEx;
import com.jifenbao.common.Constant;
import com.jifenbao.model.Image;
import com.jifenbao.service.FileUploadService;
import com.jifenbao.service.ImageManager;
import com.otc.framework.enums.YesNot;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.service.impl.MybatisServiceImpl;

/**
 *
 * @ClassName      ImageManagerImpl
 * @Description
 * Image
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Image对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-14 14:32:59
 * @version     1.0 
 *
 */

@Service(ImageManager.BEAN_NAME)
@Transactional
public class ImageManagerImpl extends MybatisServiceImpl<Image, Long> implements ImageManager {

	@Resource(name = FileUploadService.BEAN_NAME)
    private FileUploadService fileUploadService;
	
	@Override
	public Long saveAndUploadImage(MultipartFile imageFile,String source) throws IOException {
		
		Image image = new Image();
		String fileType = Constant.FILETYPE_IMG;
		if(imageFile!=null && imageFile.getSize()>0){
			String imgPath = fileUploadService.getFile(imageFile, fileType);
			image.setImagePath(imgPath);
			image.setCreateUser("systemUser");
			image.setCreateTime(new Date());
			image.setImageType(imageFile.getContentType());
			image.setSource(source);
			this.addEntity(image);
			return image.getId();
		}
		return null;
	}

	@Override
	public void updateImage(MultipartFile imageFile, Long imageId) throws IOException {
		Image image = this.getEntity(imageId);
		String fileType = Constant.FILETYPE_IMG;
		if(image==null){
			throw new BusinessException(BusinessErrorCodeEx.MSG_JF_IMG_0003);
		}else{
			//先删除原来的图片
			/*String dir =  PropertyConfig.getPropertyValue("uploadDir");
			String imagePath = dir  + image.getImagePath();
			FileUtil.deleteFile(imagePath);*/
			String newImgPath = fileUploadService.getFile(imageFile, fileType);
			image.setImagePath(newImgPath);
			image.setImageType(imageFile.getContentType());
			image.setUpdateUser("systemUser");
			image.setUpdateTime(new Date());
			this.modifyEntity(image);
		}
		
	}

	@Override
	public void deleteImage(Long imageId) throws IOException {
		Image image = this.getEntity(imageId);
		
		if(image==null){
			throw new BusinessException(BusinessErrorCodeEx.MSG_JF_IMG_0003);
		}else{
			//先删除原来的图片
			image.setUpdateUser("systemUser");
			image.setUpdateTime(new Date());
			image.setDeleteYn(YesNot.YES.getCode());
			this.modifyEntity(image);
		}
		
	}
    
    
}

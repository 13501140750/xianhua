/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.jifenbao.model.Image;

/**
 *
 * @ClassName      ImageManager
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

public interface ImageManager extends BaseManager<Image, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "imageManager";

    public Long saveAndUploadImage(MultipartFile imageFile,String file)  throws IOException;
    
    
    public void updateImage(MultipartFile imageFile,Long imageId) throws IOException;
    
    
    public void deleteImage(Long imageId) throws IOException;
}

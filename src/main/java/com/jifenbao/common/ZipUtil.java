package com.jifenbao.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.otc.framework.common.Constants;
import com.otc.framework.tools.util.io.FileUtil;
import com.otc.framework.utils.DateTimeUtil;

/**
 * @ClassName ZipUtil
 * @Description 压缩工具包
 * 
 * @author tx_ly
 * @version 1.0
 * 
 */
public final class ZipUtil {
    
    private static final Log logger = LogFactory.getLog(ZipUtil.class);
    
    /**
     * 创建压缩包
     * 
     * @param files
     */
    public static String zip(List<String> files) {
        // 上传路径
        String rootPath = Constant.UPLOAD_DIR;//未配置
        String filePath = File.separator + "zipFiles" + File.separator;
        filePath += DateTimeUtil.format(new Date(), "yyyyMMdd")
                + File.separator;
        String savePath = rootPath + filePath;
        
        String finalPath = "";
        try {
            FileUtil.createFile(savePath);
        }
        catch (IOException e) {
            logger.error(e.getMessage(), e);
            return finalPath;
        }
        ZipOutputStream zipStream = null;
        FileInputStream zipSource = null;
        BufferedInputStream bufferStream = null;
        
        try {
            String name = files.get(0).split(",")[2] + ".zip";// System.currentTimeMillis()+".zip";
            finalPath = savePath + name;
            File zipFile = new File(finalPath);// 最终打包的压缩包
            zipStream = new ZipOutputStream(new FileOutputStream(zipFile));// 用这个构造最终压缩包的输出流
            zipSource = null;// 将源头文件格式化为输入流
            
            byte[] bufferArea = new byte[1024 * 10];// 读写缓冲区
            
            // 压缩条目不是具体独立的文件，而是压缩包文件列表中的列表项，称为条目，就像索引一样
            for (int i = 0; i < files.size(); i++) {
                File file = new File(files.get(i).split(",")[0]);
                zipSource = new FileInputStream(rootPath
                        + files.get(i).split(",")[1]);
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipStream.putNextEntry(zipEntry);// 定位到该压缩条目位置，开始写入文件到压缩包中
            }
            
            bufferStream = new BufferedInputStream(zipSource, 1024 * 10);// 输入缓冲流
            int read = 0;
            
            // 在任何情况下，b[0] 到 b[off] 的元素以及 b[off+len] 到 b[b.length-1] 的元素都不会受到影响。
            while ((read = bufferStream.read(bufferArea, 0, 1024 * 10)) != -1) {
                zipStream.write(bufferArea, 0, read);
            }
            
            return finalPath;// finalPath+","+name;
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            return finalPath;
        }
        finally {
            // 关闭流
            try {
                if (null != bufferStream)
                    bufferStream.close();
                if (null != zipStream)
                    zipStream.close();
                if (null != zipSource)
                    zipSource.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
/**
 * Copyright 2008-2014 OpenTide Inc. All Rights Reserved.
 * 
 * @ProjectName:  sim dao
 * @Package:      com.otc.sim.common
 * @FileName:     FTPHelper.java
 * @Description:  
 * @CreateUser:   yang.liu
 * @CreateDate:   2014-4-18 下午7:47:30
 * @UpdateUser:   yang.liu
 * @UpdateDate:   2014-4-18 下午7:47:30
 * @UpdateRemark: 
 * 
 */
package com.jifenbao.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import com.google.common.base.Splitter;

/**
 * @ClassName FTPHelper
 * @Description FTP
 * 
 * @author yang.liu
 * @version 1.0
 * 
 */
public class FTPHelper {
    
    private static Log logger = LogFactory.getLog(FTPHelper.class.getName());
    /**
     * FTP客户端
     */
    
    private FTPClient  ftpClient;
    private String     strIp;
    private int        intPort;
    private String     user;
    private String     password;
    private String     path;
    
    /**
     * Ftp构造函数
     * 
     * @param strIp
     *            服务端地址
     * @param intPort
     *            端口号
     * @param user
     *            用户名
     * @param password
     *            密码
     */
    public FTPHelper(String strIp, int intPort, String user, String Password) {
        this.strIp = strIp;
        this.intPort = intPort;
        this.user = user;
        this.password = Password;
        this.ftpClient = new FTPClient();
    }
    
    /**
     * Ftp构造函数
     * 
     * @param strIp
     *            服务端地址
     * @param intPort
     *            端口号
     * @param user
     *            用户名
     * @param password
     *            密码
     * @param path
     *            远程路径 值可以为空
     */
    public FTPHelper(String strIp, int intPort, String user, String Password,
            String path) {
        this.strIp = strIp;
        this.intPort = intPort;
        this.user = user;
        this.password = Password;
        this.ftpClient = new FTPClient();
        this.path = path;
    }
    
    /**
     * 初始化客户端并完成对服务端的连接
     * 
     * @return 判断是否登入成功
     * */
    public boolean ftpLogin() {
        boolean isLogin = false;
        FTPClientConfig ftpClientConfig = new FTPClientConfig();
        ftpClientConfig.setServerTimeZoneId(TimeZone.getDefault().getID());
        this.ftpClient.setControlEncoding("GBK");
        this.ftpClient.configure(ftpClientConfig);
        try {
            // // 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            if (this.intPort > 0) {
                this.ftpClient.connect(this.strIp, this.intPort);
            }
            else {
                this.ftpClient.connect(this.strIp);
            }
            // FTP服务器连接回答 以2开头的返回值就会为真
            int reply = this.ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                this.ftpClient.disconnect();
                logger.error("登录FTP服务失败！");
                return isLogin;
            }
            this.ftpClient.login(this.user, this.password);
            // 设置传输协议
            this.ftpClient.enterLocalPassiveMode();
            this.ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            
            if (path != null && path.length() != 0) {
                boolean boo = this.ftpClient.changeWorkingDirectory(path);
                if (!boo)
                    logger.info("the directory does not exist ,"
                            + "or the user don't hava the enterence to this directory "
                            + path);
                
            }
            
            logger.info("恭喜" + this.user + "成功登陆FTP服务器");
            isLogin = true;
        }
        catch (Exception e) {
            logger.error(this.user + "登录FTP服务失败！" + e.getMessage(), e);
        }
        this.ftpClient.setBufferSize(1024 * 2);
        this.ftpClient.setDataTimeout(30 * 1000);
        return isLogin;
    }
    
    /**
     * @退出关闭服务器链接
     * */
    public void ftpLogOut() {
        if (null != this.ftpClient && this.ftpClient.isConnected()) {
            try {
                boolean reuslt = this.ftpClient.logout();// 退出FTP服务器
                if (reuslt) {
                    logger.info("成功退出服务器");
                }
            }
            catch (IOException e) {
                logger.warn("退出FTP服务器异常！" + e.getMessage(), e);
            }
            finally {
                try {
                    this.ftpClient.disconnect();// 关闭FTP服务器的连接
                }
                catch (IOException e) {
                    logger.warn("关闭FTP服务器的连接异常！", e);
                }
            }
        }
    }
    
    /**
     * 设置ftp的文件传输类型
     * 
     * @param fileType
     *            如:FTP.BINARY_FILE_TYPE
     * @throws IOException
     */
    public void setFileType(int fileType) throws IOException {
        this.ftpClient.setFileType(fileType);
    }
    
    /**
     * 改变ftp的工作目录
     * 
     * @param path
     * @return
     * @throws IOException
     */
    public boolean changeDirectory(String path) throws IOException {
        return this.ftpClient.changeWorkingDirectory(path);
    }
    
    /**
     * Changes working director
     * 
     * @param directory
     *            directory (relative to user home dir)
     * @throws IOException
     *             on error
     */
    public boolean changeToDir(final String directory) throws IOException {
        Iterable<String> iterable = Splitter.on('/').omitEmptyStrings()
                .split(directory);
        // note: important: we first go to user home
        // this.ftpClient.changeWorkingDirectory(path);
        boolean flag = true;
        for (String dir : iterable) {
            flag = this.ftpClient.changeWorkingDirectory(dir);
        }
        return flag;
    }
    
    /**
     * 在服务端创建目录
     * 
     * @param pathName
     *            可以是相对目录或绝对目录
     * @return
     * @throws IOException
     */
    public boolean createDirectory(String pathName) throws IOException {
        return this.ftpClient.makeDirectory(pathName);
    }
    
    /**
     * Creates directories on FTP server
     * 
     * @param directory
     *            directory to create
     * @return SimpleFtpClientResult.CREATED on succes
     *         SimpleFtpClientResult.ERROR on error
     * @throws IOException
     *             on error
     */
    public boolean createDirectories(final String directory) throws IOException {
        Iterable<String> iterable = Splitter.on('/').omitEmptyStrings()
                .split(directory);
        for (String dir : iterable) {
            boolean dirExists = this.ftpClient.changeWorkingDirectory(dir);
            if (!dirExists) {
                // try to create directory:
                this.ftpClient.makeDirectory(dir);
                dirExists = this.ftpClient.changeWorkingDirectory(dir);
            }
            if (!dirExists) {
                logger.error("failed to change FTP directory (forms), not doing anything");
                return false;
            }
        }
        return true;
    }
    
    /**
     * 删除一个FTP服务器上的目录（如果为空）
     * 
     * @param path
     *            目录路径
     * @return
     * @throws IOException
     */
    public boolean removeDirectory(String path) throws IOException {
        return this.ftpClient.removeDirectory(path);
    }
    
    /**
     * 删除一个FTP服务器上的目录
     * 
     * @param path
     *            目录路径
     * @param isAll
     *            是否删除所有子目录和文件,如果有
     * @return
     * @throws IOException
     */
    public boolean removeDirectory(String path, boolean isAll)
            throws IOException {
        
        if (!isAll) {
            return removeDirectory(path);
        }
        // 遍历子目录和文件
        FTPFile[] ftpFileArr = this.ftpClient.listFiles(path);
        if (ftpFileArr == null || ftpFileArr.length == 0) {
            return removeDirectory(path);
        }
        
        for (int i = 0; i < ftpFileArr.length; i++) {
            FTPFile ftpFile = ftpFileArr[i];
            String name = ftpFile.getName();
            if (ftpFile.isDirectory()) {
                removeDirectory(path + "/" + name, true);
            }
            else if (ftpFile.isFile()) {
                deleteFile(path + "/" + name);
            }
            else if (ftpFile.isSymbolicLink()) {
                
            }
            else if (ftpFile.isUnknown()) {
                
            }
        }
        return removeDirectory(path);
    }
    
    /**
     * 返回给定目录下的文件
     * 
     * @param path
     * @return FTPFile组成的集合
     * @throws IOException
     */
    public List<String> getFileList(String path) throws IOException {
        
        FTPFile[] ftpFiles = this.ftpClient.listFiles(path);
        
        List<String> retList = new ArrayList<String>();
        if (ftpFiles == null || ftpFiles.length == 0) {
            return retList;
        }
        for (int i = 0; i < ftpFiles.length; i++) {
            FTPFile ftpFile = ftpFiles[i];
            if (ftpFile.isFile()) {
                retList.add(ftpFile.getName());
            }
        }
        return retList;
    }
    
    /**
     * 删除文件
     * 
     * @param pathName
     *            文件名
     * @return 删除结果,是否成功.
     * @throws IOException
     */
    public boolean deleteFile(String pathName) throws IOException {
        return this.ftpClient.deleteFile(pathName);
    }
    
    /***
     * 上传Ftp文件
     * 
     * @param localFile
     *            当地文件
     * */
    public boolean uploadFile(String localFile) {
        File file = new File(localFile);
        return uploadFile(file, "/");
    }
    
    /***
     * 上传Ftp文件
     * 
     * @param localFile
     *            当地文件
     * @param romotUpLoadePath上传服务器路径
     *            - 应该以/结束
     * */
    public boolean uploadFile(String localFile, String romotUpLoadePath) {
        File file = new File(localFile);
        return uploadFile(file, romotUpLoadePath);
    }
    
    /***
     * 上传Ftp文件
     * 
     * @param localFile
     *            当地文件
     * @param romotUpLoadePath上传服务器路径
     *            - 应该以/结束
     * */
    public boolean uploadFile(File localFile, String romotUpLoadePath) {
        BufferedInputStream inStream = null;
        boolean success = false;
        try {
            this.ftpClient.changeWorkingDirectory(romotUpLoadePath);// 改变工作路径
            inStream = new BufferedInputStream(new FileInputStream(localFile));
            logger.info(localFile.getName() + " start upload .....");
            success = uploadFile(localFile.getName(), inStream);
            if (success == true) {
                logger.info(localFile.getName() + " upload success");
                return success;
            }
        }
        catch (FileNotFoundException e) {
            logger.error(localFile + " file not found ", e);
        }
        catch (IOException e) {
            logger.error(localFile + " file open error", e);
        }
        finally {
            if (inStream != null) {
                try {
                    inStream.close();
                }
                catch (IOException e) {
                    logger.error(localFile + " close error", e);
                }
            }
        }
        return success;
    }
    
    /**
     * 上传文件,从InputStream
     * 
     * @param fileName
     *            新的文件名
     * @param iStream
     *            文件流
     * @return 上传结果,是否成功.
     * @throws IOException
     */
    public boolean uploadFile(String fileName, InputStream iStream) {
        boolean flag = false;
        try {
            logger.info(fileName + " start upload .....");
            flag = this.ftpClient.storeFile(fileName, iStream);
            if (flag) {
                logger.info(fileName + " upload success");
            }
        }
        catch (IOException e) {
            logger.error(fileName + " file open error", e);
            flag = false;
            return flag;
        }
        finally {
            if (iStream != null) {
                try {
                    iStream.close();
                }
                catch (IOException e) {
                    logger.error(fileName + " close error", e);
                    
                }
            }
        }
        return flag;
    }
    
    /***
     * 下载文件
     * 
     * @param remoteFileName
     *            待下载文件名称
     * @param localDires
     *            下载到当地那个路径下
     * @param remoteDownLoadPath
     *            remoteFileName所在的路径
     * */
    
    public boolean downloadFile(String remoteFileName, String localDires,
            String remoteDownLoadPath) {
        String strFilePath = localDires + remoteFileName;
        BufferedOutputStream outStream = null;
        boolean success = false;
        try {
            // 设置文件的传输类型，默认是ASCII，修改为二进制
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            logger.info("ftpWorkingDirectory: "
                    + ftpClient.printWorkingDirectory());
            
            boolean changeResult = this.ftpClient
                    .changeWorkingDirectory(remoteDownLoadPath);
            
            if (!changeResult) {
                logger.info("the directory does not exist ,"
                        + "or the user don't hava the enterence to this directory "
                        + remoteDownLoadPath);
            }
            
            // 这个方法的意思就是每次数据连接之前,ftp client告诉ftp server开通一个端口来传输数据
            ftpClient.enterLocalPassiveMode();
            
            outStream = new BufferedOutputStream(new FileOutputStream(
                    strFilePath));
            logger.info(remoteFileName + " start download ....");
            success = this.ftpClient.retrieveFile(remoteFileName, outStream);
            if (success == true) {
                logger.info(remoteFileName + " download success to "
                        + strFilePath);
                return success;
            }
        }
        catch (Exception e) {
            logger.error(remoteFileName + " download error", e);
        }
        finally {
            if (null != outStream) {
                try {
                    outStream.flush();
                    outStream.close();
                }
                catch (IOException e) {
                    logger.error("file close error", e);
                }
            }
        }
        if (success == false) {
            logger.error(remoteFileName + " download error !!!");
        }
        return success;
    }
    
    /***
     * 下载文件
     * 
     * @param localFileName
     *            下载到当地文件
     * 
     * @param remoteFileName
     *            待下载文件名称
     * @param localDires
     *            下载到当地那个路径下
     * @param remoteDownLoadPath
     *            remoteFileName所在的路径
     * */
    
    public boolean downloadFile(String localFileNam, String remoteFileName,
            String localDires, String remoteDownLoadPath) {
        String strFilePath = localDires + localFileNam;
        BufferedOutputStream outStream = null;
        boolean success = false;
        try {
            this.ftpClient.changeWorkingDirectory(remoteDownLoadPath);
            outStream = new BufferedOutputStream(new FileOutputStream(
                    strFilePath));
            logger.info(remoteFileName + "start download ....");
            success = this.ftpClient.retrieveFile(remoteFileName, outStream);
            if (success == true) {
                logger.info(remoteFileName + " download success to "
                        + strFilePath);
                return success;
            }
        }
        catch (Exception e) {
            logger.error(remoteFileName + " download error", e);
        }
        finally {
            if (null != outStream) {
                try {
                    outStream.flush();
                    outStream.close();
                }
                catch (IOException e) {
                    logger.error("file close error", e);
                }
            }
        }
        if (success == false) {
            logger.error(remoteFileName + " download error !!!");
        }
        return success;
    }
    
    /***
     * @上传文件夹
     * @param localDirectory
     *            当地文件夹
     * @param remoteDirectory
     *            Ftp 服务器路径 以目录"/"结束
     * */
    public boolean
            uploadDirectory(String localDirectory, String remoteDirectory) {
        File src = new File(localDirectory);
        try {
            remoteDirectory = remoteDirectory + src.getName() + "/";
            this.ftpClient.makeDirectory(remoteDirectory);
            // ftpClient.listDirectories();
        }
        catch (IOException e) {
            logger.error(remoteDirectory + " dir create error", e);
        }
        File[] allFile = src.listFiles();
        String srcName = "";
        File file = null;
        for (int currentFile = 0; currentFile < allFile.length; currentFile++) {
            if (!allFile[currentFile].isDirectory()) {
                srcName = allFile[currentFile].getPath().toString();
                file = new File(srcName);
                uploadFile(file, remoteDirectory);
            }
        }
        for (int currentFile = 0; currentFile < allFile.length; currentFile++) {
            if (allFile[currentFile].isDirectory()) {
                // 递归
                uploadDirectory(allFile[currentFile].getPath().toString(),
                        remoteDirectory);
            }
        }
        return true;
    }
    
    /***
     * @下载文件夹
     * @param localDirectoryPath本地地址
     * @param remoteDirectory
     *            远程文件夹
     * */
    public boolean downLoadDirectory(String localDirectory,
            String remoteDirectory) {
        try {
            String fileName = new File(remoteDirectory).getName();
            localDirectory = localDirectory + fileName + "//";
            boolean b = new File(localDirectory).mkdirs();
            logger.info("create dir " + localDirectory + " result " + b);
            FTPFile[] allFile = this.ftpClient.listFiles(remoteDirectory);
            for (int currentFile = 0; currentFile < allFile.length; currentFile++) {
                if (!allFile[currentFile].isDirectory()) {
                    downloadFile(allFile[currentFile].getName(),
                            localDirectory, remoteDirectory);
                }
            }
            for (int currentFile = 0; currentFile < allFile.length; currentFile++) {
                if (allFile[currentFile].isDirectory()) {
                    String strremoteDirectoryPath = remoteDirectory + "/"
                            + allFile[currentFile].getName();
                    downLoadDirectory(localDirectory, strremoteDirectoryPath);
                }
            }
        }
        catch (IOException e) {
            logger.info("download file error", e);
            return false;
        }
        return true;
    }
    
    // FtpClient的Set 和 Get 函数
    public FTPClient getFtpClient() {
        return ftpClient;
    }
    
    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }
    
}

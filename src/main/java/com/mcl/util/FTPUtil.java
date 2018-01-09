package com.mcl.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * @Title FTP工具类
 * @Author Yz
 * 用于FTP的上传下载
 */
public class FTPUtil {

    private static  final Logger logger = LoggerFactory.getLogger(FTPUtil.class);

    private static String ftpIp = PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser = PropertiesUtil.getProperty("ftp.user");
    private static String ftpPass = PropertiesUtil.getProperty("ftp.pass");

    public FTPUtil(String ip,int port,String user,String pwd){
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }


    /**
     * 下载图片（注意是专门用来下载图片的）
     * @param downloadpath 下载到的路径
     * @param imgpath  图片路径
     * @param imgfilename 图片文件名
     * @return 返回下载结果
     * @throws IOException
     */
    public static boolean downloadImg(String downloadpath, String imgpath, String imgfilename)throws IOException{
        //创建一个ftpUtil实例并初始化
        FTPUtil ftpUtil = new FTPUtil(ftpIp,22,ftpUser,ftpPass);
        //写入日志
        logger.info("开始连接FTP服务器...");
        //执行下载操作
        boolean result = ftpUtil.download(imgpath.replaceAll(imgfilename,""),imgfilename,downloadpath);//把长路径减掉文件名
        logger.info("开始连接FTP服务器...结束下载");
        return result ;
    }

    /**
     * 下载文件
     * @param remotepath 目录
     * @param filename 文件名
     * @param downloadpath 下载路径
     * @return
     * @throws IOException
     */
    public boolean download(String remotepath,String filename,String downloadpath)throws IOException{
        //下载标志位
        boolean downloaded = true ;
        OutputStream os = null ;
        if(connectServer(this.ip,this.port,this.user,this.pwd)){
            try {
                //连接上FTP服务器后切换FTP目录
                ftpClient.changeWorkingDirectory(remotepath);
                //列出所有文件
                FTPFile[] ftpFiles = ftpClient.listFiles();
                //遍历
                for (FTPFile file:ftpFiles) {
                    //如果找到对应的那个文件
                    if(filename.equalsIgnoreCase(file.getName())){
                        //new一个File实例
                        File localFile = new File(downloadpath+"/"+file.getName());
                        //输出
                        os = new FileOutputStream(localFile);
                        //执行
                        ftpClient.retrieveFile(file.getName(),os);
                    }
                }
            }catch (IOException e){
                //输出到日志，设下载结果标志
                logger.info("下载文件异常",e);
                downloaded = false ;
                e.printStackTrace();
            }finally {
                //最终关闭流，关闭ftp连接
                os.close();
                ftpClient.disconnect();
            }
        }else{
            //连接不成功，直接设标志位
            downloaded = false ;
        }
        return downloaded;
    }

    public static boolean uploadFile(List<File> fileList) throws IOException {
        FTPUtil ftpUtil = new FTPUtil(ftpIp,22,ftpUser,ftpPass);
        logger.info("开始连接ftp服务器...");
        boolean result = ftpUtil.uploadFile(PropertiesUtil.getProperty("ftp.uploadimg.rootpath")+"/"+DateTimeUtil.dateToStr(new Date(),"yyyyMMdd")+"/",fileList);
        logger.info("开始连接ftp服务器,结束上传,上传结果:{}");
        return result;
    }

    /**
     * 创建目录(有则切换目录，没有则创建目录)
     * @param dir
     * @return
     */
    public boolean createDir(String dir){
        if(StringUtils.isBlank(dir))
            return true;
        String d = null ;
        try {
            //目录编码，解决中文路径问题
            d = new String(dir.toString());
            //尝试切入目录
            if(ftpClient.changeWorkingDirectory(d))
                return true;
            String[] arr =  dir.split("/");
            StringBuffer sbfDir=new StringBuffer();
            //循环生成子目录
            for(String s : arr){
                sbfDir.append("/");
                sbfDir.append(s);
                d = new String(sbfDir.toString());
                //尝试切入目录
                if(ftpClient.changeWorkingDirectory(d))
                    continue;
                if(!ftpClient.makeDirectory(d)){
                    logger.info("[失败]ftp创建目录："+sbfDir.toString());
                    return false;
                }
                logger.info("[成功]创建ftp目录："+sbfDir.toString());
            }
            //将目录切换至指定路径
            return ftpClient.changeWorkingDirectory(d);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean uploadFile(String remotePath,List<File> fileList) throws IOException {
        boolean uploaded = true;
        FileInputStream fis = null;
        //连接FTP服务器
        if(connectServer(this.ip,this.port,this.user,this.pwd)){
            try {
                createDir(remotePath);
                ftpClient.changeWorkingDirectory(remotePath);
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();
                for(File fileItem : fileList){
                    fis = new FileInputStream(fileItem);
                    ftpClient.storeFile(fileItem.getName(),fis);
                }

            } catch (IOException e) {
                logger.error("上传文件异常",e);
                uploaded = false;
                e.printStackTrace();
            } finally {
                fis.close();
                ftpClient.disconnect();
            }
        }else{
            uploaded = false ;
        }
        return uploaded;
    }


    /**
     * 连接FTPServer
     * @param ip
     * @param port
     * @param user
     * @param pwd
     * @return
     */
    private boolean connectServer(String ip,int port,String user,String pwd){
        boolean isSuccess = false;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess = ftpClient.login(user,pwd);
        } catch (IOException e) {
            logger.error("连接FTP服务器异常",e);
        }
        return isSuccess;
    }

    private String ip;

    private int port;

    private String user;

    private String pwd;

    private FTPClient ftpClient;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }


}

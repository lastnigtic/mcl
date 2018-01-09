package com.mcl.service.impl;

import com.google.common.collect.Lists;
import com.mcl.common.ServerResponse;
import com.mcl.service.IFileService;
import com.mcl.util.DateTimeUtil;
import com.mcl.util.FTPUtil;
import com.mcl.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/1/8 0008.
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService{

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String upload(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件，上传文件名为{},上传的路径{},新文件名{}",fileName,path,uploadFileName);

        //上传临时路径是否存在，不存在则要创建
        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);
        try {
            file.transferTo(targetFile);//上传上去临时目录了

            FTPUtil.uploadFile(Lists.newArrayList(targetFile));//上传到ftp
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传异常",e);
            return null;
        }
        //返回一个路径
        return PropertiesUtil.getProperty("ftp.uploadimg.rootpath")+"/"+ DateTimeUtil.dateToStr(new Date(),"yyyyMMdd")+"/"+targetFile.getName();
    }

    /**
     * 下载图片
     * @param downloadpath
     * @param imgpath
     * @return
     */
    @Override
    public boolean downloadImg(String downloadpath,String imgpath){

        //下载路径是否存在，不存在则要创建
        File fileDir = new File(downloadpath);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        //图片文件名
        String imgfilename = imgpath.substring(imgpath.lastIndexOf("/")+1);

        //写入日志
        logger.info("开始下载图片...下载文件名为{}，下载的路径为{}",imgfilename,downloadpath);

        try {
            //调用FTP工具类，执行下载
            if(FTPUtil.downloadImg(downloadpath,imgpath,imgfilename)){
                return true ;    //下载成功
            }
        } catch (IOException e) {
            logger.error("下载异常！");
            e.printStackTrace();
        }
        return false ;
    }
}

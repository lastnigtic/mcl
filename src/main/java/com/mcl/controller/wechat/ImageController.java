package com.mcl.controller.wechat;

import com.google.common.collect.Lists;
import com.mcl.common.ServerResponse;
import com.mcl.service.impl.FileServiceImpl;
import com.mcl.util.DateTimeUtil;
import com.mcl.util.FTPUtil;
import com.mcl.util.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Controller
@RequestMapping(value = "/image/")
public class ImageController {


    /**
     * 上传图片
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "upload.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse uploadImg(@RequestParam(value = "uploadfile",required = false) MultipartFile file, HttpServletRequest request){

        //存放路径
        String uploadpath = request.getSession().getServletContext().getRealPath(PropertiesUtil.getProperty("ftp.uploadimg.rootpath"))+"/"+DateTimeUtil.dateToStr(new Date(),"yyyyMMdd");
        //文件原始名
        String fileName = file.getOriginalFilename();
        //扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        //上传后的文件名
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        //上传临时路径是否存在，不存在则要创建
        File fileDir = new File(uploadpath);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(uploadpath,uploadFileName);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            return null;
        }
        //返回一个路径
        String backpath = DateTimeUtil.dateToStr(new Date(),"yyyyMMdd")+"/"+targetFile.getName();
        return ServerResponse.createBySuccess(backpath);
    }


    /**
     * 下载图片
     * @param imgpath
     * @param request
     * @param response
     */
    @RequestMapping(value = "getimg.do",method = RequestMethod.GET)
    @ResponseBody
    public void downloadImg(String imgpath, HttpServletRequest request, HttpServletResponse response) {
        if(!StringUtils.isBlank(imgpath)){
            //查看是否已经有这个图片了，有就直接下载
            File f = new File(request.getSession().getServletContext().getRealPath(PropertiesUtil.getProperty("upload.avatar.rootpath"))+"/"+imgpath);
            if(f.exists()){
                OutputStream outputStream = null ;
                FileInputStream fileInputStream = null ;
                try {
                    // 获取输出流
                    outputStream = response.getOutputStream();

                    fileInputStream = new FileInputStream(f);

                    // 读数据
                    byte[] data = new byte[fileInputStream.available()];

                    fileInputStream.read(data);

                    fileInputStream.close();

                    // 回写
                    response.setContentType("image/jpeg;charset=GB2312");

                    outputStream.write(data);

                    outputStream.flush();
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    if(outputStream!=null){
                        try {
                            outputStream.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    if (fileInputStream!=null){
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

package com.mcl.controller.wechat;

import com.github.pagehelper.StringUtil;
import com.google.common.collect.Maps;
import com.mcl.common.Const;
import com.mcl.common.ResponseCode;
import com.mcl.common.ServerResponse;
import com.mcl.service.IFileService;
import com.mcl.util.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/8 0008.
 */
@Controller
@RequestMapping(value = "/fileio/")
public class FileIOController {

    @Autowired
    private IFileService iFileService ;

    /**
     * 上传文件
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "upload.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse upload(@RequestParam(value = "uploadfile",required = false) MultipartFile file, HttpServletRequest request){
        //搞个临时目录来存放上传的临时图片，完毕后会自动删除
        String uploadtemp = request.getSession().getServletContext().getRealPath("uploadtemp");
        //执行上传，拿到上传的文件名
        String target = iFileService.upload(file,uploadtemp);
        String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+target;
        Map fileMap = Maps.newHashMap();
        fileMap.put("uri",target);
        fileMap.put("url",url);
        return ServerResponse.createBySuccess(fileMap);
    }

    /**
     * 查看图片接口
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "image.do",method = RequestMethod.POST)
    @ResponseBody
    public void downloadImg(String imgpath, HttpServletRequest request, HttpServletResponse response) {

        //搞一个临时的目录，用来存下载过来的图片，然后前端可以通过这个接口获取到图片
        String imgtemp = request.getSession().getServletContext().getRealPath("imgtemp");

        //拿到这个图片的文件名，因为传过来的imgpath可能是img/20170808/f94e1b2b-f33a-4027-bc0b-6dac0a556c77.jpg这个形式
        String imgfilename = imgpath.substring(imgpath.lastIndexOf("/")+1);

        //判断imgpath不为空
        if(!StringUtils.isBlank(imgpath)) {

            //那么先看看缓存目录里面有没有这个图片
            File file = new File(imgtemp + "\\" + imgfilename);

            boolean result = false ;
            if(!file.exists()){
                //不存在，则调用下载这个图片
                result = iFileService.downloadImg(imgtemp,imgpath);
            }
            if(!result) {
                //++++不成功，这里给他准备一个默认的图片吧++++
            }
            OutputStream outputStream = null ;
            FileInputStream fileInputStream = null ;
            try {
                // 获取输出流
                outputStream = response.getOutputStream();

                fileInputStream = new FileInputStream(file);

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

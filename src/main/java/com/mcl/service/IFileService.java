package com.mcl.service;

import com.mcl.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;

/**
 * Created by Administrator on 2018/1/8 0008.
 */
public interface IFileService {

    String upload(MultipartFile file, String path);

    boolean downloadImg(String downloadpath, String imgpath);


}

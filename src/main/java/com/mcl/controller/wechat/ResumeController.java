package com.mcl.controller.wechat;

import com.mcl.common.ServerResponse;
import com.mcl.pojo.Resume;
import com.mcl.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@RestController
@RequestMapping(value = "/resume/")
public class ResumeController {


    @Autowired
    private IResumeService iResumeService ;

    /**
     * 创建或修改简历
     * @param resume
     * @return
     */
    @RequestMapping(value = "saveorupdateresume.do" ,method = RequestMethod.POST)
    public ServerResponse saveOrUpdateResume(Resume resume){
        return iResumeService.saveOrUpdateResume(resume);
    }

    /**
     * 删除简历
     * @param id
     * @return
     */
    @RequestMapping(value = "delresume.do" ,method = RequestMethod.POST)
    public ServerResponse delResume(Integer id){
        return iResumeService.delResume(id);
    }

}

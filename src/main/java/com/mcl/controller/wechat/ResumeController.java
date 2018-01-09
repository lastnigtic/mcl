package com.mcl.controller.wechat;

import com.mcl.common.ServerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@RestController
@RequestMapping(value = "/resume/")
public class ResumeController {


    /**
     * 创建、修改简历
     * @param openid
     * @param reid
     * @return
     */
    @RequestMapping(value = "saveorupdateresume.do" ,method = RequestMethod.POST)
    public ServerResponse<Integer> saveOrUpdateResume(String openid, int reid){
        //判断reid是否为空，空则新建，不空则修改
        return null;
    }

    /**
     * 删除简历
     * @param openid
     * @param reid
     * @return
     */
    @RequestMapping(value = "delresume.do" ,method = RequestMethod.POST)
    public ServerResponse<Integer> delResume(String openid,int reid){
        //判断reid，openid是否为空，空则error，不空则删除
        return null;
    }

}

package com.mcl.controller.wechat;

import com.mcl.common.ServerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@RequestMapping(value = "/company/")
@RestController
public class CompanyController {

    /**
     * 查看公司的信息
     * @param joid
     * @return
     */
    @RequestMapping(value = "detail.do" ,method = RequestMethod.POST)
    public ServerResponse getCompanyDetail(int joid){
        return null;

    }

    /**
     * 公司给用户评分，这个接口的存放位置待定
     * @param openid
     * @param companyid
     * @param credit
     * @return
     */
    @RequestMapping(value = "ratetouser.do" ,method = RequestMethod.POST)
    public ServerResponse rateToUser(String openid,int companyid,double credit){
        //判断openid是否存在
        //判断是否有过面试完成记录
        //如有，则可以评分
        return null;
    }
}
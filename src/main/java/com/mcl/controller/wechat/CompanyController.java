package com.mcl.controller.wechat;

import com.mcl.common.ServerResponse;
import com.mcl.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@RequestMapping(value = "/company/")
@RestController
public class CompanyController {

    @Autowired
    private ICompanyService iCompanyService;

    /**
     * 查看公司的信息
     * @param id
     * @return
     */
    @RequestMapping(value = "detail.do" ,method = RequestMethod.POST)
    public ServerResponse detail(String id){
        return iCompanyService.getCompanyDetail(id);
    }


}

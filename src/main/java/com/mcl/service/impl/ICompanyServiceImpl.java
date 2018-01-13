package com.mcl.service.impl;

import com.mcl.common.ServerResponse;
import com.mcl.dao.CompanyMapper;
import com.mcl.pojo.Company;
import com.mcl.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Service("iCompanyService")
public class ICompanyServiceImpl implements ICompanyService {

    @Autowired
    private CompanyMapper companyMapper ;

    /**
     * 查看公司的信息
     * @param id
     * @return
     */
    @Override
    public ServerResponse getCompanyDetail(String id) {
        if(id!=null){
            Company c = companyMapper.selectByPrimaryKey(id);
            if(c!=null){
                return ServerResponse.createBySuccess(c);
            }
            return ServerResponse.createByErrorMessage("找不到公司信息！");
        }
        return ServerResponse.createByErrorMessage("传入参数错误！");

    }

    /**
     * 更新公司信息
     * @param company
     */
    @Override
    public void updateCompany(Company company) {
        companyMapper.updateByPrimaryKeySelective(company);
    }
}

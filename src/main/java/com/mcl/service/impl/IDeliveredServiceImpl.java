package com.mcl.service.impl;

import com.mcl.dao.ResDeliverStatusMapper;
import com.mcl.pojo.ResDeliverStatus;
import com.mcl.service.IDeliveredService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/25 0025.
 */
public class IDeliveredServiceImpl implements IDeliveredService {

    @Autowired
    private ResDeliverStatusMapper resDeliverStatusMapper ;

    @Override
    public boolean isUserHaveAuthorityScoreCompany(String openid, String companyid) {

        ResDeliverStatus deliverStatus = resDeliverStatusMapper.isUserHaveAuthorityScoreCompany(openid, companyid);

        if(deliverStatus==null)
            return false ;

        Date updatetime = deliverStatus.getUpdatetime();

        long subtractionResult = new Date().getTime()-updatetime.getTime();

        if(subtractionResult < 60*60*24*30){
            //小于30天
            return false;
        }
        return true ;

    }
}

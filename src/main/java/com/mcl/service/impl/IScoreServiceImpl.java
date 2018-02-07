package com.mcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import com.mcl.dao.CompanyScoreMapper;
import com.mcl.dao.JobOffersMapper;
import com.mcl.dao.UserBaseInfoMapper;
import com.mcl.dao.UserScoreMapper;
import com.mcl.pojo.*;
import com.mcl.service.IJobOffersServcie;
import com.mcl.service.IScoreService;
import com.mcl.vo.CompScoreVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/3 0003.
 */
@Service("iScoreService")
public class IScoreServiceImpl implements IScoreService {


    @Autowired
    private UserScoreMapper userScoreMapper ;

    @Autowired
    private CompanyScoreMapper companyScoreMapper ;

    @Autowired
    private JobOffersMapper jobOffersMapper ;

    @Autowired
    private IJobOffersServcie iJobOffersServcie ;

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper ;

    /**
     * 获取用户的六种能力分数
     * @param openid
     * @return
     */
    @Override
    public ServerResponse getUserAvgAbility(String openid) {
        if(StringUtils.isBlank(openid))
            return ServerResponse.createByErrorMessage("参数为空");

        UserAvgAbility avgAbility = userScoreMapper.getUserAvgAbility(openid);

        if(avgAbility==null)
            return ServerResponse.createByErrorMessage("无记录");

        return ServerResponse.createBySuccess(avgAbility);
    }
    /**
     * 获取企业的几种能力评分
     * @param companyid
     * @return
     */
    @Override
    public ServerResponse getCompAvgAbility(String companyid) {
        if(StringUtils.isBlank(companyid))
            return ServerResponse.createByErrorMessage("参数为空");

        CompAvgAbility avgAbility = companyScoreMapper.getCompAvgAbitlity(companyid);
        if(avgAbility==null)
            return ServerResponse.createByErrorMessage("无记录");

        return ServerResponse.createBySuccess(avgAbility);
    }

    /**
     * 获取企业评分的列表
     * @param pageNum
     * @param pageSize
     * @param companyid
     * @param companyScore
     * @return
     */
    @Override
    public ServerResponse getCompRateList(int pageNum, int pageSize, String companyid, CompanyScore companyScore) {

        if(StringUtils.isBlank(companyid))
            return ServerResponse.createByErrorMessage("参数为空");

        PageHelper.startPage(pageNum,pageSize);

        PageHelper.orderBy("updatetime desc");

        if(companyScore==null)
            companyScore = new CompanyScore();

        companyScore.setCompanyid(companyid);

        List<CompanyScore> list = companyScoreMapper.selectList(companyScore);

        PageInfo pageInfo = new PageInfo(list);

        List<CompScoreVO> voList = new ArrayList<>();

        /**
         * 组装volist
         */
        for (CompanyScore c:list){
            CompScoreVO vo = new CompScoreVO();
            vo.setCompanyScore(c);
            if(c.getJoid()!=null){
                JobOffers jobOffers = jobOffersMapper.selectByPrimaryKey(c.getJoid());
                if(jobOffers!=null){
                    vo.setJobOffersVO(iJobOffersServcie.getJobOffersVOFromJobOffers(jobOffers));
                }
            }
            if(StringUtils.isNotBlank(c.getOpenid())){
                UserBaseInfo userBaseInfo = userBaseInfoMapper.selectByPrimaryKey(c.getOpenid());
                if(userBaseInfo!=null){
                    vo.setUserBaseInfo(userBaseInfo);
                }
            }
        }

        pageInfo.setList(voList);

        return ServerResponse.createBySuccess(pageInfo);
    }


    /**
     * 获取用户的评分列表
     * @param pageNum
     * @param pageSize
     * @param userScore
     * @return
     */
    @Override
    public ServerResponse getUserRateList(int pageNum, int pageSize, UserScore userScore) {

        if(userScore==null||StringUtils.isBlank(userScore.getOpenid()))
            return ServerResponse.createByErrorMessage("参数为空");

        PageHelper.startPage(pageNum,pageSize);

        PageHelper.orderBy("updatetime desc");

        List<UserScore> list = userScoreMapper.selectList(userScore);

        PageInfo pageInfo = new PageInfo(list);

        return ServerResponse.createBySuccess(pageInfo);
    }
}

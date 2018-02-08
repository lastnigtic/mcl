package com.mcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mcl.common.Const;
import com.mcl.common.ServerResponse;
import com.mcl.dao.*;
import com.mcl.pojo.*;
import com.mcl.service.IJobOffersServcie;
import com.mcl.service.IMsgService;
import com.mcl.service.IScoreService;
import com.mcl.service.IUserService;
import com.mcl.vo.JobOffersVO;
import com.mcl.vo.MsgVO;
import com.mcl.vo.UserDetailVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Service("iUserService")
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper ;

    @Autowired
    private UserCollectionMapper userCollectionMapper ;

    @Autowired
    private CompanyMapper companyMapper ;

    @Autowired
    private ResDeliverStatusMapper resDeliverStatusMapper;

    @Autowired
    private JobOffersMapper jobOffersMapper;

    @Autowired
    private OpinionMapper opinionMapper ;

    @Autowired
    private ResumeMapper resumeMapper ;

    @Autowired
    private UserMsgMapper userMsgMapper ;

    @Autowired
    private CompanyScoreMapper companyScoreMapper ;

    @Autowired
    private IJobOffersServcie iJobOffersServcie ;

    @Autowired
    private IMsgService iMsgService ;

    @Autowired
    private IScoreService iScoreService;


    /**
     * 更新或新增用户的基础信息
     * @param userBaseInfo
     * @return
     */
    @Override
    public ServerResponse saveOrUpdateUser(UserBaseInfo userBaseInfo) {
        if(userBaseInfo!=null){
            if(StringUtils.isNotBlank(userBaseInfo.getOpenid())){

                //查询数据库是否存在该用户的基本信息
                int rowCount = userBaseInfoMapper.checkUserByOpenid(userBaseInfo.getOpenid());

                if(rowCount>0){
                    //存在该用户的信息，update
                    int r = userBaseInfoMapper.updateByPrimaryKeySelective(userBaseInfo);
                    if(r>0){
                        return ServerResponse.createBySuccess("更新用户信息成功！");
                    }
                    return ServerResponse.createByErrorMessage("更新用户信息失败");
                }else{
                    //不存在，insert
                    int r = userBaseInfoMapper.insertSelective(userBaseInfo);
                    if(r>0){
                        return ServerResponse.createBySuccess("新增用户信息成功！");
                    }
                    return ServerResponse.createByErrorMessage("新增用户信息失败！");
                }
            }else{
                return ServerResponse.createByErrorMessage("传入参数有误！");
            }
        }else {
            return ServerResponse.createByErrorMessage("传入参数有误！");
        }
    }

    /**
     * 查询用户收藏的招聘信息条数
     * @param openid
     * @return
     */
    @Override
    public ServerResponse getUserCollectJobCount(String openid) {
        if(StringUtils.isNotBlank(openid)){
            //查询数据库是否存在该用户的基本信息
            int rowCount = userBaseInfoMapper.checkUserByOpenid(openid);
            if(rowCount>0){
                //存在
                int count = userCollectionMapper.countUserCollectByOpenid(openid);
                return ServerResponse.createBySuccess(count);
            }else{
                return ServerResponse.createByErrorMessage("传入参数有误!");
            }
        }else {
            return ServerResponse.createByErrorMessage("传入参数有误!");
        }
    }

    /**
     * 查询用户收藏的招聘信息列表
     * @param openid
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getUserCollectJobList(String openid, int pageNum, int pageSize) {

        if(StringUtils.isNotBlank(openid)){
            //查询数据库是否存在该用户的基本信息
            int rowCount = userBaseInfoMapper.checkUserByOpenid(openid);
            if(rowCount>0){
                PageHelper.startPage(pageNum,pageSize);
                //联表查询已收藏的招聘信息
                List<JobOffers> jobOffersList = userCollectionMapper.selectUserCollectedJobOffersList(openid);
                List<JobOffersVO> list = Lists.newArrayList();
                for(JobOffers jo:jobOffersList){
                    JobOffersVO vo = iJobOffersServcie.getJobOffersVOFromJobOffers(jo);
                    list.add(vo);
                }
                PageInfo pageResult = new PageInfo(jobOffersList);
                //将封装好的volist放进去
                pageResult.setList(list);
                return ServerResponse.createBySuccess(pageResult);
            }else{
                return ServerResponse.createByErrorMessage("不存在该用户信息!");
            }
        }else{
            return ServerResponse.createByErrorMessage("传入参数有误!");
        }
    }

    /**
     *  本用户查看该条招聘信息是否已收藏
     * @param openid
     * @param joid
     * @return
     */
    @Override
    public ServerResponse checkJobIsCollect(String openid, Integer joid) {
        if(StringUtils.isNotBlank(openid)&&joid!=null){
            //查询数据库是否存在该用户的基本信息
            int rowCount = userBaseInfoMapper.checkUserByOpenid(openid);
            if(rowCount>0){
                int r = userCollectionMapper.countUserCollectByOpenidJoid(openid,joid);
                if(r>0){
                    return ServerResponse.createBySuccess("已收藏");
                }
                return ServerResponse.createByErrorMessage("未收藏");
            }
            return ServerResponse.createByErrorMessage("传入参数有误!");
        }else {
            return ServerResponse.createByErrorMessage("传入参数有误!");
        }
    }

    /**
     * 本用户查看该条招聘信息是否已投递
     * @param openid
     * @param joid
     * @return
     */
    @Override
    public ServerResponse checkJobIsDeliver(String openid, Integer joid) {
        if(StringUtils.isNotBlank(openid)&&joid!=null) {
            //查询数据库是否存在该用户的基本信息
            int rowCount = userBaseInfoMapper.checkUserByOpenid(openid);
            if (rowCount > 0) {
                int r = resDeliverStatusMapper.checkUserDelivered(openid,joid);
                if(r>0){
                    return ServerResponse.createBySuccess("已投递");
                }
                return ServerResponse.createByErrorMessage("未投递");
            }
            return ServerResponse.createByErrorMessage("传入参数有误!");
        }else {
            return ServerResponse.createByErrorMessage("传入参数有误!");
        }

    }

    /**
     * 用户收藏某条招聘信息
     * @param openid
     * @param joid
     * @return
     */
    @Override
    public ServerResponse collectJob(String openid, Integer joid) {
        if(StringUtils.isNotBlank(openid)&&joid!=null) {
            //查询数据库是否存在该用户的基本信息
            int rowCount = userBaseInfoMapper.checkUserByOpenid(openid);
            if(rowCount>0){
                //存在用户
                int rb = jobOffersMapper.checkOffersByJoid(joid);
                if(rb>0){
                    //存在该招聘信息
                    int r = userCollectionMapper.countUserCollectByOpenidJoid(openid,joid);
                    if(r>0){
                        //已收藏
                        return  ServerResponse.createBySuccess("已收藏");
                    }else{
                        JobOffers jobOffers = jobOffersMapper.selectByPrimaryKey(joid);
                        if(jobOffers.getChecked()==0){
                            return ServerResponse.createByErrorMessage("无法收藏");
                        }
                        UserCollection uc = new UserCollection();
                        uc.setJoid(joid);
                        uc.setOpenid(openid);
                        int rowInsert = userCollectionMapper.insert(uc);
                        if (rowInsert>0){
                            return ServerResponse.createBySuccess("已收藏");
                        }
                        return ServerResponse.createByErrorMessage("收藏失败");
                    }
                }else {
                    return ServerResponse.createByErrorMessage("招聘信息不存在");
                }
            }else{
                return ServerResponse.createByErrorMessage("用户信息不存在");
            }
        }else{
            return ServerResponse.createByErrorMessage("传入参数错误！");
        }
    }

    /**
     * 用户取消收藏某条招聘信息
     * @param openid
     * @param joid
     * @return
     */
    @Override
    public ServerResponse uncollectJob(String openid, Integer joid) {
        if(StringUtils.isNotBlank(openid)&&joid!=null) {
            //存在该招聘信息
            int r = userCollectionMapper.countUserCollectByOpenidJoid(openid,joid);
            if(r>0){
                int rowDel = userCollectionMapper.deleteByOpenidJoid(openid,joid);
                if(rowDel>0){
                    return ServerResponse.createBySuccess("取消收藏成功");
                }
                return ServerResponse.createByErrorMessage("取消收藏失败");
            }
            return ServerResponse.createByErrorMessage("找不到收藏记录");
        }
        return ServerResponse.createByErrorMessage("传入参数错误！");
    }

    /**
     * 用户给某条招聘信息投递简历
     * @param openid
     * @param joid
     * @param reid
     * @return
     */
    @Override
    public ServerResponse deliverResume(String openid, Integer joid, Integer reid) {
        if(StringUtils.isNotBlank(openid)&&joid!=null&&reid!=null) {
            //参数无误
            int rowUser = userBaseInfoMapper.checkUserByOpenid(openid);
            if(rowUser>0){
                //用户存在
                int rowOffers = jobOffersMapper.checkOffersByJoid(joid);
                if(rowOffers>0){
                    //招聘信息存在
                    if(resDeliverStatusMapper.checkUserDelivered(openid,joid)>0){
                        //已经投递过了
                        return ServerResponse.createByErrorMessage("已经投递过了");
                    }
                    if(checkResumeCompleted(openid,reid)){
                        //可以投递
                        ResDeliverStatus rds = new ResDeliverStatus();
                        rds.setJoid(joid);
                        rds.setStatus(1);
                        rds.setOpenid(openid);
                        rds.setReid(reid);
                        int rowResd = resDeliverStatusMapper.insertSelective(rds);
                        if(rowResd>0){
                            //投递成功
                            return ServerResponse.createBySuccess("投递成功");
                        }
                        return ServerResponse.createByErrorMessage("投递失败！");
                    }
                    return ServerResponse.createByErrorMessage("投递失败！简历未完善！");
                }
                return ServerResponse.createByErrorMessage("投递失败！招聘信息不存在！");
            }
            return ServerResponse.createByErrorMessage("投递失败！用户不存在！");
        }
        return ServerResponse.createByErrorMessage("传入参数错误！");
    }

    /**
     * 用户提交意见反馈
     * @param opinion
     * @return
     */
    @Override
    public ServerResponse submitOpinion(Opinion opinion) {
        if(opinion!=null){
            if(StringUtils.isNotBlank(opinion.getOpenid())&&StringUtils.isNotBlank(opinion.getDescription())) {
                //参数正确
                int rowUser = userBaseInfoMapper.checkUserByOpenid(opinion.getOpenid());
                if(rowUser>0){
                    int r = opinionMapper.insert(opinion);
                    if(r>0){
                        return ServerResponse.createBySuccess("提交成功");
                    }
                    return ServerResponse.createByErrorMessage("提交失败！");
                }
                return ServerResponse.createByErrorMessage("找不到用户信息！");
            }
            return ServerResponse.createByErrorMessage("传入参数错误！");
        }
        return ServerResponse.createByErrorMessage("传入参数错误！");
    }

    /**
     * 用户查看投递过的招聘信息
     * @param openid
     * @param pageNum
     * @param pageSize @return
     * @param status
     */
    @Override
    public ServerResponse getUserDeliveredList(String openid, int pageNum, int pageSize, Integer status) {
        if(StringUtils.isNotBlank(openid)){
            //参数不为空
            int rowUser = userBaseInfoMapper.checkUserByOpenid(openid);
            if(rowUser>0){
                //用户存在
                PageHelper.startPage(pageNum,pageSize);
                List<JobOffers> jobOffersList = null ;
                if(status!=null&&status>0&&status<5){
                    //查看其他状态的已经投递的招聘信息，(被查看，通过，未通过，面试邀约等..)
                    jobOffersList = jobOffersMapper.selectUserDeliveredJobOffersListByStatus(openid,status);
                }else{
                    //联表查询已投递的招聘信息（全部）
                    jobOffersList = jobOffersMapper.selectUserDeliveredJobOffersList(openid);
                }
                List<JobOffersVO> list = Lists.newArrayList();
                for(JobOffers jo:jobOffersList){
                    JobOffersVO vo = iJobOffersServcie.getJobOffersVOFromJobOffers(jo);
                    list.add(vo);
                }
                PageInfo pageResult = new PageInfo(jobOffersList);
                //将封装好的volist放进去
                pageResult.setList(list);
                return ServerResponse.createBySuccess(pageResult);
            }
        }

        return null;
    }


    /**
     * 判断是否初次登录
     * @param openid
     * @return
     */
    @Override
    public ServerResponse isUserFirstLogin(String openid) {
        if(StringUtils.isNotBlank(openid)){
            int rowUser = userBaseInfoMapper.checkUserByOpenid(openid);
            if(rowUser>0){
                return ServerResponse.createBySuccess("有这个人的信息了，可以做其他事情了！");
            }
            return ServerResponse.createByErrorMessage("没有这个人，快写信息进来！");
        }
        return ServerResponse.createByErrorMessage("传入参数错误！");
    }


    /**
     * 查询个人基本信息
     * @param openid
     * @return
     */
    @Override
    public ServerResponse info(String openid) {
        if(StringUtils.isBlank(openid)){
            return ServerResponse.createByErrorMessage("传入参数错误");
        }
        int rowUser = userBaseInfoMapper.checkUserByOpenid(openid);
        if(rowUser>0){
            //存在
            UserBaseInfo u = userBaseInfoMapper.selectByPrimaryKey(openid);
            if(u!=null){
                return ServerResponse.createBySuccess(u);
            }
            return ServerResponse.createByErrorMessage("查询失败");
        }
        return ServerResponse.createByErrorMessage("查询失败");
    }

    /**
     * 获取个人简历列表
     * @param openid
     * @return
     */
    @Override
    public ServerResponse myResumeList(String openid) {
        if (StringUtils.isBlank(openid)){
            return ServerResponse.createByErrorMessage("传入参数错误");
        }
        int rowUser = userBaseInfoMapper.checkUserByOpenid(openid);
        if(rowUser>0) {
            //存在
            List<Resume> list = resumeMapper.selectList(openid);
            if(list!=null){
                return ServerResponse.createBySuccess(list);
            }
            return ServerResponse.createByErrorMessage("该用户简历为空");
        }
        return ServerResponse.createByErrorMessage("找不到用户信息");
    }





    /**
     * 是否存在用户
     * @param openid
     * @return
     */
    @Override
    public boolean checkOpenid(String openid) {
        return  userBaseInfoMapper.checkUserByOpenid(openid)>0?true:false;
    }


    /**
     * 判断用户是否有权限对企业评分
     * @param openid
     * @param companyid
     * @return
     */
    public boolean isUserHaveAuthorityScoreCompany(String openid, String companyid,Integer joid) {

        //已经评分的就不能再评
        int row = companyScoreMapper.isUserScoredCompany(openid,companyid);

        if(row>0)
            return false;

        ResDeliverStatus deliverStatus = resDeliverStatusMapper.isUserHaveAuthorityScoreCompany(openid, companyid, Const.DeliveryStatus.PassInterview, joid);

        if(deliverStatus==null)
            return false ;

        Date entrytime = deliverStatus.getEntrytime();


        long subtractionResult = new Date().getTime()-entrytime.getTime();

        JobOffers jobOffers  = jobOffersMapper.selectByPrimaryKey(joid);
        if(jobOffers==null||jobOffers.getDuration()==null)
            return false;



        if(subtractionResult < Const.RatingDuration.Day30*jobOffers.getDuration())//小于规定天数
            return false;

        return true ;

    }

    /**
     * 获取用户的详细信息（包括多份简历）
     * @param openid
     * @return
     */
    @Override
    public ServerResponse getUserDetailInfo(String openid) {
        if(StringUtils.isBlank(openid))
            return ServerResponse.createByErrorMessage("参数为空");

        int rowUser = userBaseInfoMapper.checkUserByOpenid(openid);

        if(rowUser==0)
            return ServerResponse.createByErrorMessage("用户不存在");

        //查询基本信息
        UserBaseInfo userBaseInfo = userBaseInfoMapper.selectByPrimaryKey(openid);

        UserDetailVO vo = new UserDetailVO() ;

        if(userBaseInfo!=null)
            vo.setUserBaseInfo(userBaseInfo);

        List<Resume> list = resumeMapper.selectList(openid);

        if(list!=null)
            vo.setResumeList(list);

        ServerResponse scoreResponse = iScoreService.getUserAvgAbility(openid);

        if(scoreResponse.isSuccess()){
            vo.setAvgAbility((UserAvgAbility) scoreResponse.getData());
        }

        return ServerResponse.createBySuccess(vo);
    }

    @Override
    public UserBaseInfo getUserBaseInfo(String openid) {
        if(StringUtils.isBlank(openid))
            return null;
        return userBaseInfoMapper.selectByPrimaryKey(openid);
    }


    /**
     * 用户向公司评分
     * @param companyScore
     * @return
     */
    @Override
    @Transactional
    public ServerResponse rateToCompany(CompanyScore companyScore) {

        if(companyScore==null||StringUtils.isBlank(companyScore.getCompanyid())||StringUtils.isBlank(companyScore.getOpenid()))
            return ServerResponse.createByErrorMessage("参数为空");


        int rowUser = userBaseInfoMapper.checkUserByOpenid(companyScore.getOpenid());

        if(rowUser==0)
            return ServerResponse.createByErrorMessage("找不到用户");

        Company company = companyMapper.selectByPrimaryKey(companyScore.getCompanyid());

        if(company==null)
            return ServerResponse.createByErrorMessage("找不到公司");

        boolean havaAuthority = isUserHaveAuthorityScoreCompany(companyScore.getOpenid(),companyScore.getCompanyid(),companyScore.getJoid());

        if(havaAuthority){

            int rowInsert = companyScoreMapper.insert(companyScore);//插入一条评分记录

            if(rowInsert>0){
                return ServerResponse.createBySuccess("评分成功");
            }
            return ServerResponse.createByErrorMessage("评分失败");
        }else{
            return ServerResponse.createByErrorMessage("无权评分");
        }
    }


    /**
     * 检查某用户的某个简历是否完善，是否可以投递
     * @param openid
     * @param id
     * @return
     */
    private boolean checkResumeCompleted(String openid,Integer id){
        //检查简历是否完整
        Resume resume = resumeMapper.selectByPrimaryKey(id);
        if(resume==null){
            return false ;
        }else {
            if(StringUtils.isBlank(resume.getResumename())){
                return false;
            }
            if(StringUtils.isBlank(resume.getOpenid())){
                return false;
            }
            if(StringUtils.isBlank(resume.getEducation())){
                return false;
            }
            if(StringUtils.isBlank(resume.getMajor())){
                return false;
            }
            if(StringUtils.isBlank(resume.getAvatarurl())){
                return false;
            }
            if(StringUtils.isBlank(resume.getSchoolname())){
                return false;
            }
            if(resume.getGraduationtime()==null){
                return false;
            }
            if(resume.getFrequencyapplied()==null){
                return false;
            }
            if(resume.getDurationapplied()==null){
                return false;
            }
            if(StringUtils.isBlank(resume.getCityapplied())){
                return false;
            }
            if(resume.getWageapplied()==null){
                return false;
            }
            if(StringUtils.isBlank(resume.getJobapplied())){
                return false;
            }
//            if(StringUtils.isBlank(resume.getSkills())){
//                return false;
//            }
//            if(StringUtils.isBlank(resume.getSelfevaluation())){
//                return false;
//            }
        }
        //检查个人基本信息是否完整
        if(StringUtils.isBlank(openid)){
            return false;
        }else {
            UserBaseInfo u = userBaseInfoMapper.selectByPrimaryKey(openid);
            if(u==null){
                return false;
            }
//            if(StringUtils.isBlank(u.getCity())){
//                return false;
//            }
//            if (u.getEndschooltime()!=null){
//                return false;
//            }
//            if(StringUtils.isBlank(u.getMajortype())){
//                return false;
//            }
//            if(StringUtils.isBlank(u.getEmail())){
//                return false;
//            }
//            if(StringUtils.isBlank(u.getPhone())){
//                return false;
//            }
//            if(StringUtils.isBlank(u.getRealname())){
//                return false;
//            }
//            if(u.getBirthday()==null){
//                return false;
//            }
        }
        return true ;
    }


}

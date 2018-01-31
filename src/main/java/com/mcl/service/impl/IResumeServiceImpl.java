package com.mcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mcl.common.Const;
import com.mcl.common.ServerResponse;
import com.mcl.dao.*;
import com.mcl.pojo.*;
import com.mcl.service.IResumeService;
import com.mcl.util.MsgTemplate;
import com.mcl.vo.ResumeVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Service("iResumeService")
public class IResumeServiceImpl implements IResumeService {

    @Autowired
    private ResumeMapper resumeMapper ;

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper ;

    @Autowired
    private ResDeliverStatusMapper resDeliverStatusMapper ;

    @Autowired
    private UserMsgMapper userMsgMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private JobOffersMapper jobOffersMapper;

    /**
     * 创建或修改简历
     * @param resume
     * @return
     */
    @Override
    public ServerResponse saveOrUpdateResume(Resume resume) {
        if(resume!=null&&StringUtils.isNotBlank(resume.getOpenid())){
            //参数不为空
            int rowUser = userBaseInfoMapper.checkUserByOpenid(resume.getOpenid());
            if(rowUser>0){
                //存在用户
                if(resume.getId()!=null){
                    //参数id不为空
                    int rowResume = resumeMapper.checkResumeExist(resume.getId());
                    if(rowResume>0){
                        //存在则修改
                        int rowUpdateResume = resumeMapper.updateByPrimaryKeySelective(resume);
                        if(rowUpdateResume>0){
                            return ServerResponse.createBySuccess("更新成功");
                        }
                        return ServerResponse.createByErrorMessage("更新失败");
                    }
                    //不存在又传个简历id进来就是搞错了
                    return ServerResponse.createByErrorMessage("参数错误");
                }
                //简历id是空的那就创建
                int rowInsertResume = resumeMapper.insert(resume);
                if(rowInsertResume>0){
                    return ServerResponse.createBySuccess("创建成功");
                }
                return ServerResponse.createByErrorMessage("创建失败");
            }
        }
        return ServerResponse.createByErrorMessage("参数错误");
    }

    /**
     * 删除简历
     *
     * @param openid
     * @param id
     * @return
     */
    @Override
    public ServerResponse delResume(String openid, Integer id) {
        if(id!=null){
            //参数不为空
            int rowResume = resumeMapper.checkResumeExist(id);
            if(rowResume>0){
                //存在该简历
                Resume resume = resumeMapper.selectByPrimaryKey(id);
                if(resume.getOpenid().equals(openid)){
                    int rowDel = resumeMapper.deleteByPrimaryKey(id);
                    if(rowDel>0){
                        return ServerResponse.createBySuccess("删除成功");
                    }
                    return ServerResponse.createByErrorMessage("删除失败");
                }
                return ServerResponse.createByErrorMessage("不存在该简历");
            }
            return ServerResponse.createByErrorMessage("不存在该简历");
        }
        return ServerResponse.createByErrorMessage("参数错误");
    }


    /**
     * 查看简历详情
     * @param id
     * @return
     */
    @Override
    public ServerResponse detail(Integer id) {
        if(id!=null){
            int rowResume = resumeMapper.checkResumeExist(id);
            if(rowResume>0){
                Resume resume = resumeMapper.selectByPrimaryKey(id);
                return ServerResponse.createBySuccess(resume);
            }
            return ServerResponse.createByErrorMessage("不存在该简历");
        }
        return ServerResponse.createByErrorMessage("传入参数错误");
    }

    /**
     * 获取我的简历箱
     * @param pageNum
     * @param pageSize
     * @param resume
     * @param account
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getResumeBox(int pageNum, int pageSize, Resume resume, Account account) {

        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("updatetime desc");
        List<ResDeliverStatus> list_deliver = resDeliverStatusMapper.getResumeStatusBox(account.getCompanyid());

        //List<Resume> list = resumeMapper.getResumeBox(account.getCompanyid());
        PageInfo pageResult = new PageInfo(list_deliver);
        List<ResumeVO> rtlist = Lists.newArrayList();
        for (ResDeliverStatus rds :list_deliver){
            ResumeVO vo = getResumeVOlist(rds);
            rtlist.add(vo);
        }
        pageResult.setList(rtlist);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 封装简历VO
     * @param rds
     * @return
     */
    private ResumeVO getResumeVOlist(ResDeliverStatus rds){
        Resume r = resumeMapper.selectByPrimaryKey(rds.getReid());
        if(r==null)return null ;
        JobOffers jobOffers = null ;
        ResumeVO vo = new ResumeVO() ;
        if(rds!=null){
            jobOffers = jobOffersMapper.selectByPrimaryKey(rds.getJoid());
            vo.setJobOffers(jobOffers);
        }
        vo.setResDeliverStatus(rds);
        vo.setOpenid(r.getOpenid());
        vo.setMajorclass(r.getMajorclass());
        vo.setResumename(r.getResumename());
        vo.setAvatarurl(r.getAvatarurl());
        vo.setAwards(r.getAwards());
        vo.setCampusexp(r.getCampusexp());
        vo.setCertificate(r.getCertificate());
        vo.setCity(r.getCity());
        vo.setJobapplied(r.getJobapplied());
        vo.setCityapplied(r.getCityapplied());
        vo.setCompanyname(r.getCompanyname());
        vo.setDurationapplied(r.getDurationapplied());
        vo.setEducation(r.getEducation());
        vo.setEntrytime(r.getEntrytime());
        vo.setId(r.getId());
        vo.setFrequencyapplied(r.getFrequencyapplied());
        vo.setJobdesc(r.getJobdesc());
        vo.setWageapplied(r.getWageapplied());
        vo.setUpdatetime(r.getUpdatetime());
        vo.setSkills(r.getSkills());
        vo.setSchoolname(r.getSchoolname());
        vo.setSelfevaluation(r.getSelfevaluation());
        vo.setProvince(r.getProvince());
        vo.setJobstarttime(r.getJobstarttime());
        vo.setJobendtime(r.getJobendtime());
        vo.setMajor(r.getMajor());
        vo.setGraduationtime(r.getGraduationtime());
        vo.setJobname(r.getJobname());
        vo.setGraduationtime(r.getGraduationtime());
        UserBaseInfo userBaseInfo = userBaseInfoMapper.selectByPrimaryKey(r.getOpenid());
        vo.setUserBaseInfo(userBaseInfo);
        return vo;
    }

    /**
     * 从简历箱中查看简历
     * @param resumeid
     * @param companyid
     * @return
     */
    @Override
    @Transactional
    public ServerResponse getResumeFromBox(Integer id,Integer resumeid, String companyid) {
        if(resumeid ==null||StringUtils.isBlank(companyid)){
            return ServerResponse.createByErrorMessage("传入参数错误");
        }
        int row = resumeMapper.checkResumeCanGet(resumeid,companyid);//看看有无权限获取该简历
        if(row>0){
            //有权限
            Resume resume = resumeMapper.selectByPrimaryKey(resumeid);  //获取简历信息
            //判断是否需要更改状态为被查看
            ResDeliverStatus rds = resDeliverStatusMapper.selectByPrimaryKey(id);
            if(rds.getViewed()==null||rds.getViewed()!=1||rds.getStatus()==null||rds.getStatus()==0){
                int rowView = resDeliverStatusMapper.viewedByResumeId(resumeid);  //更改状态为被查看
                if(rowView>0){
                    //更改成功后，发一条消息到这个用户那里
                    UserMsg userMsg = new UserMsg();
                    userMsg.setOpenid(rds.getOpenid());
                    userMsg.setReadstatus(0);
                    userMsg.setMsgtitle("简历已被查看");
                    userMsg.setMsg("您的简历已被查看");
                    userMsg.setType("系统消息");
                    userMsgMapper.insert(userMsg);
                }
            }
            ResumeVO resumeVO = getResumeVO(resume);
            resumeVO = getResumeStatusById(resumeVO, id); // 获取简历状态
            return ServerResponse.createBySuccess(resumeVO);
        }
        return ServerResponse.createByErrorMessage("没有权限");
    }
    /**
     *
     *根据res简历的id去查状态
     * @param vo
     * @param id
     * @return
     */
    public ResumeVO getResumeStatusById(ResumeVO vo,Integer id){
        if(id==null||vo==null|vo.getId()==null)return vo;
        ResDeliverStatus status = resDeliverStatusMapper.getStatusById(id);
        if(status!=null){
            vo.setResDeliverStatus(status);
        }
        return vo ;
    }

    public ResumeVO getResumeVO(Resume r) {
        ResumeVO vo = new ResumeVO();
        vo.setOpenid(r.getOpenid());
        vo.setMajorclass(r.getMajorclass());
        vo.setResumename(r.getResumename());
        vo.setAvatarurl(r.getAvatarurl());
        vo.setAwards(r.getAwards());
        vo.setCampusexp(r.getCampusexp());
        vo.setCertificate(r.getCertificate());
        vo.setCity(r.getCity());
        vo.setJobapplied(r.getJobapplied());
        vo.setCityapplied(r.getCityapplied());
        vo.setCompanyname(r.getCompanyname());
        vo.setDurationapplied(r.getDurationapplied());
        vo.setEducation(r.getEducation());
        vo.setEntrytime(r.getEntrytime());
        vo.setId(r.getId());
        vo.setFrequencyapplied(r.getFrequencyapplied());
        vo.setJobdesc(r.getJobdesc());
        vo.setWageapplied(r.getWageapplied());
        vo.setUpdatetime(r.getUpdatetime());
        vo.setSkills(r.getSkills());
        vo.setSchoolname(r.getSchoolname());
        vo.setSelfevaluation(r.getSelfevaluation());
        vo.setProvince(r.getProvince());
        vo.setJobstarttime(r.getJobstarttime());
        vo.setJobendtime(r.getJobendtime());
        vo.setMajor(r.getMajor());
        vo.setGraduationtime(r.getGraduationtime());
        vo.setJobname(r.getJobname());
        vo.setGraduationtime(r.getGraduationtime());
        UserBaseInfo userBaseInfo = userBaseInfoMapper.selectByPrimaryKey(r.getOpenid());
        if(userBaseInfo!=null)vo.setUserBaseInfo(userBaseInfo);
        return vo;
    }


    /**
     * 对投递到自己岗位的简历进行邀约面试，通过面试，更改为不合适
     * @param id
     * @param joid
     *@param companyid
     * @param status
     * @param msg    @return
     */
    @Override
    @Transactional
    public ServerResponse changeResumeStatus(Integer id, Integer joid, String companyid, Integer status, String msg) {
        if(id==null||status==null)
            return ServerResponse.createByErrorMessage("传入的参数为空");

        Integer reid = resDeliverStatusMapper.selectReIdById(id);

        if(reid==null)return ServerResponse.createByErrorMessage("找不到数据");

        //TODO 待完善
        int row = resDeliverStatusMapper.checkResumeCanGet(reid,joid,id);//看看有无权限获取该简历

        if(row > 0){
            //有权限
            ResDeliverStatus rds = resDeliverStatusMapper.selectByPrimaryKey(id);

            UserMsg userMsg = null ;

            Company company = companyMapper.selectByPrimaryKey(companyid);

            JobOffers jobOffers = jobOffersMapper.selectByPrimaryKey(joid);

            String openid = rds.getOpenid();

            Integer currentStatus = rds.getStatus() ;

            if(status<=currentStatus){
                return ServerResponse.createByErrorMessage("无法修改status");
            }

            if(status == Const.DeliveryStatus.InvitedToInterview){

                userMsg = new UserMsg(openid,StringUtils.isNotBlank(msg)?msg:"",MsgTemplate.MsgType.JobDeliveryMsg);

                userMsg.setMsgtitle(MsgTemplate.interviewMsg(company,jobOffers));

            }else if(status == Const.DeliveryStatus.PassInterview){

                userMsg = new UserMsg(openid,MsgTemplate.passInterviewMsg(jobOffers),MsgTemplate.MsgType.JobDeliveryMsg);

            }else if(status == Const.DeliveryStatus.FailInterview){

                userMsg = new UserMsg(openid,MsgTemplate.failInterviewMsg(jobOffers),MsgTemplate.MsgType.JobDeliveryMsg);

            }else if(status == Const.DeliveryStatus.AlreadyViewed){
                if(rds.getStatus()==null||rds.getStatus()==1){

                    userMsg = new UserMsg(openid,MsgTemplate.alreadyViewedMsg(jobOffers),MsgTemplate.MsgType.JobDeliveryMsg);

                }else{

                    return ServerResponse.createByErrorMessage("无法修改status");

                }
            }else {

                return ServerResponse.createByErrorMessage("非法参数");

            }

            int rowInsert = userMsgMapper.insert(userMsg);

            int rowUpdate = resDeliverStatusMapper.updateStatusById(id,status);

            if(rowInsert>0&&rowUpdate>0){

                return ServerResponse.createBySuccess("更新成功");

            }else {

                return ServerResponse.createByErrorMessage("更新失败");

            }
        }
        return ServerResponse.createByErrorMessage("没有权限");
    }
    /**
     * 根据id查简历
     * @param pageNum
     * @param pageSize
     * @param id
     * @param companyid
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getResumeByJobId(int pageNum, int pageSize, Integer id, @RequestParam(required = false) String companyid) {

        PageHelper.startPage(pageNum,pageSize);
        //PageHelper.orderBy("updatetime desc");
        List<Integer> list_reids = resDeliverStatusMapper.getResumeIdListByJobId(id);
        //List<ResDeliverStatus> ls_status = resDeliverStatusMapper.getResumeStatusListByJobId(id);
        List<Resume> ls = null ;
        List<ResumeVO> vols = null ;
        if(list_reids!=null&&list_reids.size()!=0){
            ls = resumeMapper.getResumeByReIdList(list_reids);
            if(ls!=null){
                PageInfo pageInfo = new PageInfo(list_reids);

                vols = new ArrayList<>(ls.size());
                for(Resume resume :ls){
                    ResumeVO resumeVO = getResumeVO(resume);
                    resumeVO = getResumeStatusByJobIdAndReId(resumeVO,id);
                    vols.add(resumeVO);
                }
                pageInfo.setList(vols);
                return ServerResponse.createBySuccess(pageInfo);
            }
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse getResumeVOByRdsIdAndResId(Integer id, Integer resumeid) {
        if(id==null||resumeid==null)
            return ServerResponse.createByErrorMessage("传入参数错误");
        Resume resume = resumeMapper.selectByPrimaryKey(resumeid);
        ResDeliverStatus rds = resDeliverStatusMapper.selectByPrimaryKey(id);
        if(resume!=null){
            ResumeVO resumeVO = getResumeVO(resume);
            if(rds!=null){
                resumeVO.setResDeliverStatus(rds);
                return ServerResponse.createBySuccess(resumeVO);
            }
        }
        return ServerResponse.createByErrorMessage("查询错误");
    }

    /**
     *
     * 加一个简历投递状态的信息
     * @param vo
     * @param joid
     * @return
     */
    public ResumeVO getResumeStatusByJobIdAndReId(ResumeVO vo,Integer joid){
        if(joid==null||vo==null|vo.getId()==null)return vo;
        ResDeliverStatus rds = resDeliverStatusMapper.getStatusByJobIdAndReId(vo.getId(),joid);
        if(rds!=null){
            vo.setResDeliverStatus(rds);
        }
        return vo ;
    }

}

package com.mcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcl.common.Const;
import com.mcl.common.ServerResponse;
import com.mcl.dao.*;
import com.mcl.pojo.*;
import com.mcl.service.IAccountService;
import com.mcl.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/1/13 0013.
 */
@Service(value = "iAccountService")
public class IAccountServiceImpl implements IAccountService {


    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private CompanyMapper companyMapper ;

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;

    @Autowired
    private UserScoreMapper userScoreMapper;

    @Autowired
    private ResDeliverStatusMapper resDeliverStatusMapper;

    @Autowired
    private CompanyMsgMapper companyMsgMapper ;

    @Autowired
    private JobOffersMapper jobOffersMapper ;


    /**
     * 商家登录
     * @param uname
     * @param upass
     * @return
     */
    @Override
    public ServerResponse<Account> login(String uname, String upass) {
        if(StringUtils.isBlank(uname)||StringUtils.isBlank(upass)){
            return ServerResponse.createByErrorMessage("参数为空");
        }
        int resultCount = accountMapper.checkUname(uname);
        if(resultCount == 0 ){
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String md5Password = MD5Util.MD5EncodeUtf8(upass);
        Account account  = accountMapper.selectLogin(uname,md5Password);
        if(account == null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        account.setUpass(org.apache.commons.lang3.StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功",account);
    }


    /**
     * 商家注册
     * @param account
     * @return
     */
    @Override
    public ServerResponse<String> register(Account account) {
        if(account!=null&& StringUtils.isNotBlank(account.getUname())&&StringUtils.isNotBlank(account.getUpass())){
            int rowCount = accountMapper.checkUname(account.getUname());
            if(rowCount>0){
                return ServerResponse.createByErrorMessage("账号名已存在");
            }
            //MD5加密
            account.setUpass(MD5Util.MD5EncodeUtf8(account.getUpass()));
            int resultCount = accountMapper.insert(account);
            if(resultCount == 0){
                return ServerResponse.createByErrorMessage("注册失败");
            }
            return ServerResponse.createBySuccessMessage("注册成功");
        }
        return ServerResponse.createByErrorMessage("传入参数错误");
    }

    /**
     * 创建或者更新公司信息
     *
     * @param id
     * @param company
     * @return
     */
    @Override
    @Transactional
    public ServerResponse saveOrUpdateCompany(Integer id, Company company) {
        if(company!=null&&id!=null){
            String cid = accountMapper.selectCompanyIdById(id);
            if(StringUtils.isBlank(company.getId())&&StringUtils.isBlank(cid)){
                //创建
                if(checkCompanyInfoComplete(company)){
                    //信息完整
                    String uuid = UUID.randomUUID().toString();  //随机id作为companyid
                    Account account = accountMapper.selectByPrimaryKey(id);//获取该商家用户实例
                    company.setId(uuid);
                    company.setChecked(0);
                    account.setCompanyid(uuid);
                    int rowInsert = companyMapper.insert(company);  //插入一条公司信息
                    int rowAccount = accountMapper.updateByPrimaryKeySelective(account);  //更新商家的companyid
                    if(rowInsert>0&&rowAccount>0){
                        return ServerResponse.createBySuccess("创建成功");
                    }
                    return ServerResponse.createByErrorMessage("创建失败");
                }
                return ServerResponse.createByErrorMessage("信息不完整");
            }
            if(StringUtils.isNotBlank(company.getId())&&StringUtils.isNotBlank(cid)&&cid.equals(company.getId())){
                //这是更新的
                if(checkCompanyInfoComplete(company)){
                    int rowUpdate = companyMapper.updateByPrimaryKeySelective(company);
                    if(rowUpdate>0){
                        return ServerResponse.createBySuccess("创建成功");
                    }
                    return ServerResponse.createByErrorMessage("创建失败");
                }
                return ServerResponse.createByErrorMessage("信息不完整");
            }
            return ServerResponse.createByErrorMessage("错误！不可编辑修改！");
        }
        return ServerResponse.createByErrorMessage("传入参数错误");
    }


    /**
     * 根据商家的id找到公司的信息
     * @param id
     * @return
     */
    @Override
    public Company getCompanyByAccount(Integer id) {
        if(id==null){
            return null;
        }
        return companyMapper.selectByPrimaryKey(accountMapper.selectCompanyIdById(id));
    }


    /**
     * 判断是否已经认证
     * @param id
     * @return
     */
    @Override
    public ServerResponse isPassVerified(Integer id) {
        if(id==null)
            return ServerResponse.createByErrorMessage("传入参数错误");
        Company company = companyMapper.selectByPrimaryKey(accountMapper.selectCompanyIdById(id));
        if(company==null){
            return ServerResponse.createByErrorMessage("找不到信息");
        }
        if(company.getChecked()==1){
            return ServerResponse.createBySuccess("已认证",1);
        }
        if(company.getChecked()==0){
            return ServerResponse.createBySuccess("未认证",0);
        }
        return ServerResponse.createByErrorMessage("错误！");
    }


    /**
     * 判断企业是否有权限对用户评分
     * @param openid
     * @param companyid
     * @return
     */
    @Override
    public boolean isCompanyHaveAuthorityScoreUser(String openid, String companyid,Integer joid) {

        //已经评分的就不能再评
        int row  = userScoreMapper.isCompanyHaveAuthorityScoreUser(openid,companyid,joid);

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
     * 对用户评分
     * @param userScore
     * @return
     */
    @Override
    public ServerResponse rateToUser(UserScore userScore) {
        if(userScore==null||
                StringUtils.isBlank(userScore.getOpenid())||
                StringUtils.isBlank(userScore.getCompanyid())||
                userScore.getJoid()==null)
            return ServerResponse.createByErrorMessage("参数错误");

        if(userBaseInfoMapper.checkUserByOpenid(userScore.getOpenid())==0)
            return ServerResponse.createByErrorMessage("找不到用户");

        boolean havaAuthority = isCompanyHaveAuthorityScoreUser(userScore.getOpenid(),userScore.getCompanyid(),userScore.getJoid());

        if(havaAuthority){
            //有权评分
            int rowInsert = userScoreMapper.insert(userScore);

            if(rowInsert>0){
                return ServerResponse.createBySuccess("评分成功");
            }
            return ServerResponse.createByErrorMessage("评分失败");
        }
        return ServerResponse.createByErrorMessage("无权评分");
    }


    /**
     * 检验提交的公司信息是否完整
     * @param company
     * @return
     */
    private boolean checkCompanyInfoComplete(Company company) {
        if(company==null){
            return false;
        }
        if(StringUtils.isBlank(company.getAddress())){
            return false;
        }
        if(StringUtils.isBlank(company.getCompanyname())){
            return false;
        }
        if (StringUtils.isBlank(company.getCompanysize())){
            return false;
        }
        if(StringUtils.isBlank(company.getIntroduction())){
            return false;
        }
        if(StringUtils.isBlank(company.getCity())){
            return false;
        }
        return true;
    }


}

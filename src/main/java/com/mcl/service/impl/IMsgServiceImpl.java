package com.mcl.service.impl;

import com.mcl.dao.JobOffersMapper;
import com.mcl.dao.UserMsgMapper;
import com.mcl.pojo.JobOffers;
import com.mcl.pojo.UserMsg;
import com.mcl.service.IJobOffersServcie;
import com.mcl.service.IMsgService;
import com.mcl.vo.JobOffersVO;
import com.mcl.vo.MsgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/2/5 0005.
 */
@Service("iMsgService")
public class IMsgServiceImpl implements IMsgService {

    @Autowired
    private UserMsgMapper userMsgMapper ;

    @Autowired
    private JobOffersMapper jobOffersMapper ;

    @Autowired
    private IJobOffersServcie iJobOffersServcie ;

    /**
     * 组装消息VO返回给小程序端
     * @param userMsg
     * @return
     */
    @Override
    public MsgVO getMsgVOFromUserMsg(UserMsg userMsg) {

        if(userMsg==null)
            return null;

        JobOffers job = null ;

        JobOffersVO jobvo = null ;

        MsgVO msgVO = new MsgVO();

        msgVO.setUserMsg(userMsg);

        if(userMsg.getJoid()!=null){

            job = jobOffersMapper.selectByPrimaryKey(userMsg.getJoid());

            jobvo = iJobOffersServcie.getJobOffersVOFromJobOffers(job);

            if(jobvo!=null)
                msgVO.setJob(jobvo);
        }

        return msgVO;
    }
}

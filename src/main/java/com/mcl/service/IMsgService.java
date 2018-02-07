package com.mcl.service;

import com.mcl.common.ServerResponse;
import com.mcl.pojo.CompanyMsg;
import com.mcl.pojo.UserMsg;
import com.mcl.vo.MsgVO;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/2/5 0005.
 */

public interface IMsgService {
    MsgVO getMsgVOFromUserMsg(UserMsg userMsg);

    MsgVO getMsgVOFromCompMsg(CompanyMsg companyMsg);

    ServerResponse getCompMsgList(int pageNum, int pageSize, CompanyMsg companyMsg);

    ServerResponse readCompMsg(Integer id);

    ServerResponse getCompMsg(Integer id);

    ServerResponse readCompMsg(String openid, Integer id);

    ServerResponse myMsg(String openid, int pageNum, int pageSize, Integer readstatus);

    ServerResponse msg(Integer id, String openid);

    ServerResponse delUserMsg(Integer id, String openid);

    ServerResponse delCompMsg(Integer id);
}

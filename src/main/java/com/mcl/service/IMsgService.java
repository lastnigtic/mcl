package com.mcl.service;

import com.mcl.pojo.UserMsg;
import com.mcl.vo.MsgVO;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/2/5 0005.
 */

public interface IMsgService {
    MsgVO getMsgVOFromUserMsg(UserMsg userMsg);
}

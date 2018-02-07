package com.mcl.vo;

/**
 * Created by yz on 2018/2/7.
 */

import com.mcl.pojo.Resume;
import com.mcl.pojo.UserAvgAbility;
import com.mcl.pojo.UserBaseInfo;

import java.util.List;

/**
 * 用于页面展示用户的详细信息，基本信息+简历信息
 */
public class UserDetailVO {

    private UserBaseInfo userBaseInfo ;

    private List<Resume> resumeList ;

    private UserAvgAbility avgAbility ;

    public UserAvgAbility getAvgAbility() {
        return avgAbility;
    }

    public void setAvgAbility(UserAvgAbility avgAbility) {
        this.avgAbility = avgAbility;
    }

    public UserBaseInfo getUserBaseInfo() {
        return userBaseInfo;
    }

    public void setUserBaseInfo(UserBaseInfo userBaseInfo) {
        this.userBaseInfo = userBaseInfo;
    }

    public List<Resume> getResumeList() {
        return resumeList;
    }

    public void setResumeList(List<Resume> resumeList) {
        this.resumeList = resumeList;
    }
}

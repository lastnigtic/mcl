package com.mcl.pojo;

import java.util.Date;

/**
 * Created by Administrator on 2018/2/3 0003.
 */
public class CompAvgAbility {

    private String companyid;

    private Date updatetime;

    private String comment;

    private Integer creditrate;

    private Integer atmosphererate;

    private Integer environmentrate;

    private Integer wagerate;

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCreditrate() {
        return creditrate;
    }

    public void setCreditrate(Integer creditrate) {
        this.creditrate = creditrate;
    }

    public Integer getAtmosphererate() {
        return atmosphererate;
    }

    public void setAtmosphererate(Integer atmosphererate) {
        this.atmosphererate = atmosphererate;
    }

    public Integer getEnvironmentrate() {
        return environmentrate;
    }

    public void setEnvironmentrate(Integer environmentrate) {
        this.environmentrate = environmentrate;
    }

    public Integer getWagerate() {
        return wagerate;
    }

    public void setWagerate(Integer wagerate) {
        this.wagerate = wagerate;
    }
}

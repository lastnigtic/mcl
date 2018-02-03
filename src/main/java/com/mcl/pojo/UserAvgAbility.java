package com.mcl.pojo;

import java.util.Date;

/**
 * Created by Administrator on 2018/2/3 0003.
 */
public class UserAvgAbility {

    private String openid;

    private Double organizationability;

    private Double communicateability;

    private Double technicalability;

    private Double adaptability;

    private Double innovationability;

    private Double learnability;

    private Date updatetime;

    private String comment;

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Double getOrganizationability() {
        return organizationability;
    }

    public void setOrganizationability(Double organizationability) {
        this.organizationability = organizationability;
    }

    public Double getCommunicateability() {
        return communicateability;
    }

    public void setCommunicateability(Double communicateability) {
        this.communicateability = communicateability;
    }

    public Double getTechnicalability() {
        return technicalability;
    }

    public void setTechnicalability(Double technicalability) {
        this.technicalability = technicalability;
    }

    public Double getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(Double adaptability) {
        this.adaptability = adaptability;
    }

    public Double getInnovationability() {
        return innovationability;
    }

    public void setInnovationability(Double innovationability) {
        this.innovationability = innovationability;
    }

    public Double getLearnability() {
        return learnability;
    }

    public void setLearnability(Double learnability) {
        this.learnability = learnability;
    }
}

package com.mcl.pojo;

import java.util.Date;

public class UserMsg {
    private Integer id;

    private String openid;

    private String type;

    private String msgtime;

    private Integer readstatus;

    private String msgtitle;

    private Date updatetime;

    private String msg;

    public UserMsg(Integer id, String openid, String type, String msgtime, Integer readstatus, String msgtitle, Date updatetime, String msg) {
        this.id = id;
        this.openid = openid;
        this.type = type;
        this.msgtime = msgtime;
        this.readstatus = readstatus;
        this.msgtitle = msgtitle;
        this.updatetime = updatetime;
        this.msg = msg;
    }

    public UserMsg() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getMsgtime() {
        return msgtime;
    }

    public void setMsgtime(String msgtime) {
        this.msgtime = msgtime == null ? null : msgtime.trim();
    }

    public Integer getReadstatus() {
        return readstatus;
    }

    public void setReadstatus(Integer readstatus) {
        this.readstatus = readstatus;
    }

    public String getMsgtitle() {
        return msgtitle;
    }

    public void setMsgtitle(String msgtitle) {
        this.msgtitle = msgtitle == null ? null : msgtitle.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}
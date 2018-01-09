package com.mcl.pojo;

public class UserCollection {
    private Integer id;

    private String openid;

    private Integer joid;

    public UserCollection(Integer id, String openid, Integer joid) {
        this.id = id;
        this.openid = openid;
        this.joid = joid;
    }

    public UserCollection() {
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

    public Integer getJoid() {
        return joid;
    }

    public void setJoid(Integer joid) {
        this.joid = joid;
    }
}
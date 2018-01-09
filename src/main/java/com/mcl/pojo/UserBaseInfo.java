package com.mcl.pojo;

import java.util.Date;

public class UserBaseInfo {
    private String openid;

    private String nickname;

    private String avatarurl;

    private Integer gender;

    private String language;

    private String city;

    private String province;

    private String country;

    private String realname;

    private Date birthday;

    private String email;

    private String phone;

    public UserBaseInfo(String openid, String nickname, String avatarurl, Integer gender, String language, String city, String province, String country, String realname, Date birthday, String email, String phone) {
        this.openid = openid;
        this.nickname = nickname;
        this.avatarurl = avatarurl;
        this.gender = gender;
        this.language = language;
        this.city = city;
        this.province = province;
        this.country = country;
        this.realname = realname;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
    }

    public UserBaseInfo() {
        super();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}
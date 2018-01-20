package com.mcl.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserBaseInfo {
    private String openid;

    private String nickname;

    private String avatarurl;

    private Integer gender;

    private String language;

    private String city;

    private String province;

    private String realname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String email;

    private String phone;

    private Double credit;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startschooltime;

    private String education;

    private String schoolname;

    private String majortype;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endschooltime;

    private Date updatetime;

    private Integer isworking;

    public UserBaseInfo(String openid, String nickname, String avatarurl, Integer gender, String language, String city, String province, String realname, Date birthday, String email, String phone, Double credit, Date startschooltime, String education, String schoolname, String majortype, Date endschooltime, Date updatetime, Integer isworking) {
        this.openid = openid;
        this.nickname = nickname;
        this.avatarurl = avatarurl;
        this.gender = gender;
        this.language = language;
        this.city = city;
        this.province = province;
        this.realname = realname;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.credit = credit;
        this.startschooltime = startschooltime;
        this.education = education;
        this.schoolname = schoolname;
        this.majortype = majortype;
        this.endschooltime = endschooltime;
        this.updatetime = updatetime;
        this.isworking = isworking;
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

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Date getStartschooltime() {
        return startschooltime;
    }

    public void setStartschooltime(Date startschooltime) {
        this.startschooltime = startschooltime;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public String getMajortype() {
        return majortype;
    }

    public void setMajortype(String majortype) {
        this.majortype = majortype == null ? null : majortype.trim();
    }

    public Date getEndschooltime() {
        return endschooltime;
    }

    public void setEndschooltime(Date endschooltime) {
        this.endschooltime = endschooltime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getIsworking() {
        return isworking;
    }

    public void setIsworking(Integer isworking) {
        this.isworking = isworking;
    }
}
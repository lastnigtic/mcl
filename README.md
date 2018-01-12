# 文档v1.0



[TOC]



### 基础需求

**首页**
1. 定位 根据定位查找该城市的职位
2. 查询实习
3. 根据分类查看分类列表
4. 列表主体(类别，条件筛选)
5. 具体页面（岗位名称，公司，地址，等等等）——可以投递，收藏

**投递反馈**
1. 列表(被查看，初步筛选，面试，不合适)
2. 具体详情

**我的**
1. 我的简历（编辑，修改）
2. 我的收藏
3. 职位邀约(消息)
4. 意见反馈


---



### 数据库

1. 用户表(微信个人信息)

2. 用户收藏表

3. 用户消息表

4. 简历表

   基础子表
   校园经历子表
   实习经历子表
   求职意向表
   ...

5. 招聘信息表

6. 企业表

7. 企业标签表

8. 简历投递状态表

9. 面试邀约信息表

10. 意见表

11. 配置表



##### 数据库详情

**1. 用户表-userbaseinfo**

| 变量名         | 类型       | 长度   | 备注       |
| ----------- | -------- | ---- | -------- |
| openid      | varchar  | 50   | 微信用户唯一标识 |
| nickname    | varchar  | 30   | 昵称       |
| avatarurl   | varchar  | 200  | 头像地址     |
| gender      | int      | 1    | 性别 1男 0女 |
| language    | varchar  | 10   | 语言       |
| city        | varchar  | 10   | 城市       |
| province    | varchar  | 10   | 省份       |
| country     | varchar  | 20   | 国家       |
| realname(+) | varchar  | 10   | 真实名字     |
| birthday(+) | datetime | -    | 出生日期     |
| email(+)    | varchar  | 50   | 邮箱       |
| phone(+)    | varchar  | 13   | 手机号      |



##### 2. 用户收藏表-usercollection

| 变量名    | 类型      | 长度   | 备注     |
| ------ | ------- | ---- | ------ |
| id     | int     | 11   | -      |
| openid | varchar | 50   | 用户id   |
| joid   | int     | 11   | 招聘信息id |



##### 3. 用户消息表-usermsg

| 变量名        | 类型       | 长度   | 备注           |
| ---------- | -------- | ---- | ------------ |
| id         | int      | 11   | -            |
| openid     | varchar  | 50   | 用户id         |
| msg        | text     | -    | 消息内容         |
| type       | varchar  | 10   | 消息类型         |
| msgtime    | datetime | -    | 消息时间         |
| readstatus | int      | 1    | 消息状态 1已读 0未读 |
| msgtitle   | varchar  | 15   | 消息题目         |
| updatetime | datetime | -    | 更新时间         |



##### 4.简历表-resume

| 变量名             | 类型       | 长度   | 备注   |
| --------------- | -------- | ---- | ---- |
| id              | int      | 11   | -    |
| openid          | varchar  | 50   | 用户id |
| skills          | varchar  | 255  | 技能描述 |
| hobbies         | varchar  | 255  | 爱好描述 |
| selfevaluation  | varchar  | 255  | 个人评价 |
| updatetime      | datetime | -    | 更新时间 |
| schoolname      | varchar  | 20   | 学校名称 |
| major           | varchar  | 20   | 专业   |
| startschooltime | datetime | -    | 入学时间 |
| endschooltime   | datetime | -    | 毕业时间 |
| education       | varchar  | 2    | 学历   |
| majorclass      | varchar  | 100  | 主修课程 |
| certificate     | varchar  | 255  | 证书   |
| awards          | varchar  | 255  | 奖项   |
| campusexp       | varchar  | 255  | 校园经历 |
|                 |          |      |      |



##### 5. 招聘信息表-joboffers

| 变量名           | 类型       | 长度   | 备注                 |
| ------------- | -------- | ---- | ------------------ |
| id            | int      | 11   | -                  |
| jobname       | varchar  | 20   | 职位名称               |
| temptation    | varchar  | 30   | 职位诱惑               |
| tag           | varchar  | 30   | 职位标签               |
| type          | varchar  | 30   | 类型（互联网/通信）         |
| wage          | int      | 6    | 工资                 |
| companyid     | int      | 11   | 公司id               |
| city/county   | varchar  | 10   | 城市（广东-广州）          |
| address       | varchar  | 30   | 地址                 |
| education     | varchar  | 2    | 学历限制（本科）           |
| duration      | int      | 2    | 时间长度（n个月）          |
| workfrequency | int      | 1    | 上班频率（n天/周）         |
| description   | text     | -    | 描述                 |
| updatetime    | datetime | -    | 更新时间               |
| checked(++)   | int      | 1    | 审核状态，1通过 2不通过 0待审核 |



##### 6. 企业/公司表-company

| 变量名          | 类型       | 长度   | 备注                 |
| ------------ | -------- | ---- | ------------------ |
| id           | int      | 11   | -                  |
| city         | varchar  | 10   | 城市                 |
| imgurl       | varchar  | 200  | 公司图片地址             |
| companysize  | varchar  | 10   | 公司规模               |
| industrytype | varchar  | 20   | 行业类型               |
| companytag   | varchar  | 40   | 公司标签               |
| introduction | text     | -    | 介绍                 |
| address      | varchar  | 30   | 地址                 |
| updatetime   | datetime | -    | 更新时间               |
| checked(++)  | int      | 1    | 审核状态，1通过 2不通过 0待审核 |
| credit(++)   | double   | 4    | 信用平均分              |
|              |          |      |                    |





##### 7. 企业/职位标签表(配置表)-tagproperty

| 变量名  | 类型      | 长度   | 备注                             |
| ---- | ------- | ---- | ------------------------------ |
| id   | int     | 11   | -                              |
| type | varchar | 10   | 类型 （-行业类型 -公司标签 -职位诱惑 -招聘信息类型） |
| name | varchar | 20   | 名称                             |





##### 8. 简历投递状态表-resdeliverstatus

| 变量名         | 类型       | 长度   | 备注                    |
| ----------- | -------- | ---- | --------------------- |
| id          | int      | 11   |                       |
| joid        | int      | 11   | 招聘信息id                |
| reid        | int      | 11   | 简历id                  |
| status      | int      | 1    | 简历状态（投递，查看，面试，初筛，不合适） |
| viewed      | int      | 1    | 被查看（保留）               |
| description | text     | -    | 描述                    |
| updatetime  | datetime | -    | 更新时间                  |
| openid(++)  | varchar  | 50   | 用户id                  |



##### 9. 面试邀约信息表-interviewinfo

| 变量名           | 类型       | 长度   | 备注             |
| ------------- | -------- | ---- | -------------- |
| id            | int      | 11   | -              |
| interviewtime | datetime | -    | 面试时间           |
| description   | text     | -    | 描述             |
| openid        | varchar  | 50   | 用户id           |
| joid          | int      | 11   | 招聘信息id         |
| updatetime    | datetime | -    | 更新时间           |
| viewed(++)    | int      | 1    | 被用户查看(0未看，1已看) |
|               |          |      |                |



##### 10. 意见表-opinion

| 变量名             | 类型       | 长度   | 备注       |
| --------------- | -------- | ---- | -------- |
| id              | int      | 11   | -        |
| openid          | varchar  | 50   | 用户id     |
| description     | text     | -    | 描述       |
| updatetime      | datetime | -    | 更新时间     |
| contactinfo(++) | varchar  | 30   | 联系方式(保留) |
|                 |          |      |          |



##### 11.配置表(待定，首页轮播图，广告内容等...)



##### 12.用户对公司信用评分表usercompanycredit

| 变量名        | 类型       | 长度   | 备注   |
| ---------- | -------- | ---- | ---- |
| id         | int      | 11   |      |
| companyid  | int      | 11   | 公司id |
| openid     | varchar  | 50   | 用户id |
| credit     | double   | 5    | 信用分数 |
| updatetime | datetime | -    | 更新时间 |
|            |          |      |      |



##### 13.用户对公司信用评分表companyusercredit

| 变量名        | 类型       | 长度   | 备注   |
| ---------- | -------- | ---- | ---- |
| id         | int      | 11   |      |
| companyid  | int      | 11   | 公司id |
| openid     | varchar  | 50   | 用户id |
| credit     | double   | 5    | 信用分数 |
| updatetime | datetime | -    | 更新时间 |
|            |          |      |      |





### 功能描述

1. 用户首次使用，将用户的openid,nickname等基本信息写入数据库，如果不是首次，也要检查是否存在该用户的基本信息，写入userbaseinfo表
2. 用户点击“我的”底部导航栏按钮后，可查询我收藏的招聘信息(usercollection表)，可修改创建自己的简历(resume表)
3. 点击查看招聘信息，可显示是否已经收藏，点击收藏(usercollection表)，是否已经投递，点击投递(resdeliverstatus表)。招聘信息具体内容(joboffers表)，可点击查看公司详情(company表)
4. web端的公司HR登录后，首次注册要填写公司基本信息。<u>审核</u>通过后。可<u>发布</u>新的招聘信息。可<u>查看本公司的投递情况</u>，<u>更改简历的投递状态</u>，<u>邀约面试</u>等。简历的投递状态一旦改变，用户的消息表要新增一条通知记录(usermsg)
5. 用户可以提交意见，管理员登录web端后可以<u>查看</u>，管理员可以<u>审核HR注册</u>，<u>招聘信息发布的审核</u>
6. 用户可以查看自己投递过的招聘岗位，按最新的时间排序
7. 用户可以填写求职意向表(该表待定)，然后根据求职意向为用户推荐职位
8. (++)信用评级评分



### 系统架构

​	微信小程序+SSM+MySQL+(ngnix)Tomcat



### 接口描述

| function          | url                             | method | param                                    | return          |
| ----------------- | ------------------------------- | ------ | ---------------------------------------- | --------------- |
| 查看商家的详细信息         | /company/detail.do              | POST   | id                                       | obj             |
| 公司给用户评分(还没写)      | /company/ratetouser.do          | POST   |                                          | -               |
| 获取招聘列表/包含搜索，筛选功能  | /offers/list.do                 | POST   | （参数全部选填）pageNum,pageSize,keywords(搜索关键词),wage（月工资下限）,type,city,duration（工作几个月）,workfrequency（一周几天） | pageinfo        |
| 获取推荐招聘列表（按工资高的在前） | /offers/recommendlist.do        | POST   | （参数全部选填）pageNum,pageSize                 | pageinfo        |
| 获取某个招聘信息的详情       | /offers/detail.do               | POST   | id                                       | obj             |
| 进入小程序后存储或更新用户基本信息 | /user/saveorupdateuser.do       | POST   | openid,nickname,avatarurl,gender,language,city,province,country,realname,birthday("yyyy-MM-dd"),email,phone | 成功status=0 失败=1 |
| 判断是否初次登录          | /user/isfirstlogin.do           | POST   | openid                                   | 成功status=0 失败=1 |
| 查询用户收藏的招聘信息条数     | /user/getusercollectjobcount.do | POST   | openid                                   | 成功则返回一个数        |
| 查询用户收藏的招聘信息列表     | /user/getusercollectjoblist.do  | POST   | openid,(pageNum,pageSize选填)              | pageinfo        |
| 本用户查看该条招聘信息是否已收藏  | /user/checkjobiscollect.do      | POST   | openid,joid                              | 成功status=0 失败=1 |
| 本用户查看该条招聘信息是否已投递  | /user/checkjobisdeliver.do      | POST   | openid,joid                              | 成功status=0 失败=1 |
| 用户收藏某条招聘信息        | /user/collectjob.do             | POST   | openid,joid                              | 成功status=0 失败=1 |
| 用户取消收藏某条招聘信息      | /user/uncollectjob.do           | POST   | openid,joid                              | 成功status=0 失败=1 |
| 用户给某条招聘信息投递简历     | /user/deliverresume.do          | POST   | openid,joid,reid                         | 成功status=0 失败=1 |
| 用户提交意见反馈          | /user/submitopinion.do          | POST   | openid,contactinfo,description           | 成功status=0 失败=1 |
| 用户查看投递过的招聘信息      | /user/getuserdeliveredlist.do   | POST   | openid,pageNum,pageSize,status(选填)       | pageinfo        |
| 获取个人基本信息          | /user/info.do                   | POST   | openid                                   | obj             |
| 获取个人简历列表          | /user/myresumelist.do           | POST   | openid                                   | pageinfo        |
| 获取个人消息            | /user/mymsg.do                  | POST   | openid,pageNum,pageSize,readstatus(选填)   | pageinfo        |
| 获取个人消息详情          | /user/msg.do                    | POST   | id,openid                                | obj             |
| 删除自己的某条消息         | /user/delmsg.do                 | POST   | id,openid                                | 成功status=0 失败=1 |
| 用户给公司评分(还没写)      | /user/ratetocompany.do          | POST   |                                          | -               |
| 用户创建或修改简历         | /resume/saveorupdateresume.do   | POST   | id(选),openid,skills,hobbies,selfevaluation,schoolname,major,startschooltime,endschooltime,education,majorclass,certificate,awards,campusexp | 成功status=0 失败=1 |
| 用户删除简历            | /resume/delresume.do            | POST   | openid,id                                | 成功status=0 失败=1 |
| 查看某份简历详情          | /resume/detail.do               | POST   | id                                       | obj             |
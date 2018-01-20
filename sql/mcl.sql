# MySQL-Front 5.0  (Build 1.0)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: 111.230.22.94    Database: mcl
# ------------------------------------------------------
# Server version 5.7.20

DROP DATABASE IF EXISTS `mcl`;
CREATE DATABASE `mcl` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mcl`;

#
# Table structure for table account
#

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(30) NOT NULL DEFAULT '',
  `upass` varchar(50) NOT NULL DEFAULT '',
  `companyid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
INSERT INTO `account` VALUES (1,'scnuyz','e9c5e2b15eea403a04e00e4160589b54','082df506-72ae-4fc1-bbb6-40fed11b89ec');
INSERT INTO `account` VALUES (2,'scnuyp','e10adc3949ba59abbe56e057f20f883e',NULL);
INSERT INTO `account` VALUES (3,'scnulw','E99A18C428CB38D5F260853678922E03',NULL);

#
# Table structure for table company
#

CREATE TABLE `company` (
  `id` varchar(50) NOT NULL,
  `city` varchar(10) DEFAULT NULL COMMENT '城市',
  `imgurl` varchar(200) DEFAULT NULL COMMENT '公司图片地址',
  `companysize` varchar(10) DEFAULT NULL COMMENT '公司规模',
  `introduction` varchar(255) DEFAULT NULL COMMENT '介绍',
  `address` varchar(30) DEFAULT NULL COMMENT '地址',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `checked` int(1) DEFAULT NULL COMMENT '审核状态 1通过 2不通过',
  `credit` double(5,2) DEFAULT NULL COMMENT '信用平均分',
  `companyname` varchar(30) DEFAULT NULL COMMENT '公司名',
  `companylicense` varchar(255) DEFAULT NULL COMMENT '公司证书图片',
  `setuptime` datetime DEFAULT NULL COMMENT '成立时间',
  `registeredcapital` int(11) DEFAULT NULL COMMENT '注册资本',
  `legalrepresentative` varchar(10) DEFAULT NULL COMMENT '法人代表',
  `website` varchar(255) DEFAULT NULL COMMENT '公司网站首页',
  `financingstage` varchar(20) DEFAULT NULL COMMENT '融资阶段',
  `industry` varchar(30) DEFAULT NULL COMMENT '行业',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业/公司表';
INSERT INTO `company` VALUES ('082df506-72ae-4fc1-bbb6-40fed11b89ec','广州','20180113/7c24dfcd-21e4-4d2f-a6cf-5e1f465ebe64.png','1000人','','华天国际广场','2018-01-13 18:26:35',1,NULL,'世纪龙','20180113/a3d20757-9337-4927-b221-c1cce3a06a01.png',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `company` VALUES ('1','广州','/sad/asdasd','1000人','\r\n','中山大道西89-93号华景软件园b','2017-11-11',1,90,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

#
# Table structure for table companyusercredit
#

CREATE TABLE `companyusercredit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` varchar(50) DEFAULT NULL COMMENT '公司id',
  `openid` varchar(50) DEFAULT NULL COMMENT '用户id',
  `credit` float(5,2) DEFAULT NULL COMMENT '信用分数',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `comment` varchar(255) DEFAULT NULL COMMENT '评论',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司对用户信用评分表';

#
# Table structure for table interviewinfo
#

CREATE TABLE `interviewinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `interviewtime` datetime DEFAULT NULL COMMENT '面试时间',
  `description` text COMMENT '描述',
  `joid` int(11) DEFAULT NULL COMMENT '招聘信息id',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `viewd` int(1) DEFAULT NULL COMMENT '被用户查看（0未看 1已看）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='面试邀约信息表';

#
# Table structure for table joboffers
#

CREATE TABLE `joboffers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jobname` varchar(20) NOT NULL DEFAULT '' COMMENT '职位名称',
  `temptation` varchar(50) DEFAULT NULL COMMENT '职位诱惑',
  `tag` varchar(30) DEFAULT NULL COMMENT '职位标签',
  `type` varchar(30) DEFAULT NULL COMMENT '岗位类型（互联网/通信）',
  `wage` int(6) DEFAULT NULL COMMENT '月工资',
  `companyid` varchar(50) DEFAULT NULL COMMENT '公司id',
  `city` varchar(10) DEFAULT NULL COMMENT '工作地点的城市',
  `address` varchar(30) DEFAULT NULL COMMENT '工作地点',
  `education` varchar(2) DEFAULT NULL COMMENT '学历限制（本科）',
  `duration` int(2) DEFAULT NULL COMMENT '时间长度（n个月）',
  `workfrequency` int(1) DEFAULT NULL COMMENT '上班频率（n天/周)',
  `description` text COMMENT '描述',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `checked` int(1) DEFAULT NULL COMMENT '审核状态0未审核 1通过 2不通过 3过期',
  `requirements` varchar(255) DEFAULT NULL COMMENT '任职要求',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='招聘信息表';
INSERT INTO `joboffers` VALUES (1,'亚信java开发','没有诱惑','五险一金','通信行业',6,'082df506-72ae-4fc1-bbb6-40fed11b89ec','广州','大学城信息枢纽楼','本科',10,4,'过来做政企门户\r\n','2017-03-15',1,NULL);
INSERT INTO `joboffers` VALUES (2,'美团前端开发','五险一金，免费班车，免费体检，节日福利，试用期全薪，绩效奖金多，优秀团队，周末双休，办公环境好','大企业','互联网',6,'082df506-72ae-4fc1-bbb6-40fed11b89ec','厦门','望京东路6号','本科',3,5,'职位职责：\r\n⼯作职责\r\n在移动设备上，追求极致的⽤户体验\r\n负责开发与⽤户和服务器的交互界面\r\n建设企业级和移动前端的技术和工程架构\r\n知识分享者，善于总结、乐于对内外分享\r\n低级别⼯程师的导师，辅导新人\r\n\r\n基本要求\r\n2年以上前端领域开发经验\r\n熟练阅读英⽂原版技术⽂档和书刊\r\n深⼊掌握HTML+CSS+JavaScript等前端技术，代码符合W3C标准、兼容主流浏览器\r\n熟练使⽤⾄少⼀种JS框架，掌握其原理\r\n掌握⾄少⼀种其他语⾔（如Java/PHP/Python/Ruby/Go），有实战经验\r\n本科及以上学历，计算机相关专业毕业（或计算机基础⾮常扎实）\r\n做事认真细心，有一份用心的简历\r\n\r\n优先条件\r\n熟悉Mobile Web/Hybrid Web App/小程序开发/基于Canvas的游戏等开发\r\n利⽤开源代码打造⾃有效率⼯具的经验\r\n熟悉Linux/Unix/Mac平台下的软件开发环境\r\n多终端的开发经验（Android/iOS/Mac/Windows）\r\nNodejs下项目开发经验\r\n技术社区的活跃份⼦\r\n品质优秀的开源作品\r\n妥善经营的技术博客\r\n团队管理经验','2017-11-11',1,NULL);
INSERT INTO `joboffers` VALUES (5,'前端1','诱惑1',NULL,'互联网1',1111,'082df506-72ae-4fc1-bbb6-40fed11b89ec','广州','bbbbcc',NULL,12,2,'desc111','2018-01-13 23:44:34',0,NULL);
INSERT INTO `joboffers` VALUES (6,'åç«¯12','è¯±æ12',NULL,'äºèç½12',11112,'082df506-72ae-4fc1-bbb6-40fed11b89ec','å¹¿å·2','bbbbcc2',NULL,122,22,'desc1112','2018-01-13 23:45:35',0,NULL);

#
# Table structure for table opinion
#

CREATE TABLE `opinion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(50) DEFAULT NULL COMMENT '用户id',
  `description` text COMMENT '描述',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `contactinfo` varchar(30) DEFAULT NULL COMMENT '联系方式（保留）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='意见表';
INSERT INTO `opinion` VALUES (1,'asdasdwqeqr324234sadad12','12345',NULL,NULL);
INSERT INTO `opinion` VALUES (2,'asdasdwqeqr324234sadad12','12345','2018-01-10 16:44:17',NULL);
INSERT INTO `opinion` VALUES (3,'asdasdwqeqr324234sadad12','12345','2018-01-10 16:44:27',NULL);
INSERT INTO `opinion` VALUES (4,'o4THs0Hu3H_e-ZMfVzEGf85VefK8','fdasfaf','2018-01-18 11:51:20','null');
INSERT INTO `opinion` VALUES (5,'o4THs0Hu3H_e-ZMfVzEGf85VefK8','fdasfaf','2018-01-18 11:51:21','null');
INSERT INTO `opinion` VALUES (6,'o4THs0Hu3H_e-ZMfVzEGf85VefK8','afadfadfda','2018-01-18 11:51:27','null');

#
# Table structure for table resdeliverstatus
#

CREATE TABLE `resdeliverstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `joid` int(11) DEFAULT NULL COMMENT '招聘信息id',
  `reid` int(11) DEFAULT NULL COMMENT '简历id',
  `status` int(1) DEFAULT NULL COMMENT '简历状态（投递，查看，面试，通过,不合适）',
  `viewed` int(11) DEFAULT NULL COMMENT '被查看（保留）',
  `description` text COMMENT '描述',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `openid` varchar(50) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='简历投递状态表';
INSERT INTO `resdeliverstatus` VALUES (1,2,1,2,1,'232213213','2017-11-11','asdasdwqeqr324234sadad12');
INSERT INTO `resdeliverstatus` VALUES (2,1,2,1,NULL,NULL,'2018-01-10 16:18:10','asdasdwqeqr324234sadad12');
INSERT INTO `resdeliverstatus` VALUES (3,2,1,1,NULL,NULL,NULL,'o4THs0Hu3H_e-ZMfVzEGf85VefK8');

#
# Table structure for table resume
#

CREATE TABLE `resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(50) NOT NULL DEFAULT '' COMMENT '用户id',
  `resumename` varchar(20) DEFAULT NULL COMMENT '简历名称',
  `avatarurl` varchar(255) DEFAULT NULL COMMENT '简历头像',
  `province` varchar(10) DEFAULT NULL COMMENT '现在省份',
  `city` varchar(20) DEFAULT NULL COMMENT '现在城市',
  `skills` varchar(255) DEFAULT NULL COMMENT '技能爱好描述',
  `selfevaluation` varchar(255) DEFAULT NULL COMMENT '个人评价',
  `schoolname` varchar(20) DEFAULT NULL COMMENT '学校',
  `major` varchar(20) DEFAULT NULL COMMENT '专业类别',
  `graduationtime` datetime DEFAULT NULL COMMENT '毕业时间',
  `education` varchar(5) DEFAULT NULL COMMENT '学历(必填)',
  `majorclass` varchar(50) DEFAULT NULL COMMENT '主修课程',
  `certificate` varchar(255) DEFAULT NULL COMMENT '所获证书',
  `awards` varchar(255) DEFAULT NULL COMMENT '所获奖项',
  `campusexp` varchar(255) DEFAULT NULL COMMENT '校园经历',
  `jobapplied` varchar(30) DEFAULT NULL COMMENT '期望职位',
  `cityapplied` varchar(20) DEFAULT NULL COMMENT '期望城市',
  `wageapplied` int(6) DEFAULT NULL COMMENT '期望薪资',
  `frequencyapplied` int(1) DEFAULT NULL COMMENT '期望实习天数',
  `durationapplied` int(2) DEFAULT NULL COMMENT '实习时长（月）',
  `entrytime` datetime DEFAULT NULL COMMENT '入职时间',
  `companyname` varchar(255) DEFAULT NULL COMMENT '实习公司名称',
  `jobname` varchar(255) DEFAULT NULL COMMENT '职位名称',
  `jobdesc` varchar(255) DEFAULT NULL COMMENT '实习描述',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `jobstarttime` datetime DEFAULT NULL COMMENT '实习经历，开始时间',
  `jobendtime` datetime DEFAULT NULL COMMENT '实习经历，结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='简历表';
INSERT INTO `resume` VALUES (1,'asdasdwqeqr324234sadad12',NULL,NULL,NULL,NULL,'java','well , good ,confidence','scnu','IE','2018-07-01','本科','量子力学','计算机三级','软件设计三等奖','院学生会',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-01-12 14:39:45',NULL,NULL);
INSERT INTO `resume` VALUES (2,'asdasdwqeqr324234sadad12',NULL,NULL,NULL,NULL,NULL,'well , good ,confidence','scnu','IE','2018-07-01','本科','量子力学','计算机三级','软件设计三等奖','院学生会',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-01-12 14:41:19',NULL,NULL);
INSERT INTO `resume` VALUES (5,'asdasdwqeqr324234sadad12',NULL,NULL,NULL,NULL,NULL,'well , good ,confidence','scnu','IE',NULL,'本科','量子力学','计算机三级','软件设计三等奖','院学生会',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-01-20 13:27:11',NULL,NULL);

#
# Table structure for table tagproperty
#

CREATE TABLE `tagproperty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) DEFAULT NULL COMMENT '类型（-行业-公司标签-职位诱惑-招聘信息内容）',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业/职位标签表';

#
# Table structure for table userbaseinfo
#

CREATE TABLE `userbaseinfo` (
  `openid` varchar(50) NOT NULL DEFAULT '' COMMENT '微信用户唯一标识',
  `nickname` varchar(30) DEFAULT NULL COMMENT '昵称',
  `avatarurl` varchar(200) DEFAULT NULL COMMENT '头像地址',
  `gender` int(1) DEFAULT NULL COMMENT '性别 1男0女',
  `language` varchar(10) DEFAULT NULL COMMENT '语言',
  `city` varchar(10) DEFAULT NULL COMMENT '城市',
  `province` varchar(10) DEFAULT NULL COMMENT '省份',
  `realname` varchar(10) DEFAULT NULL COMMENT '真实名字',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(13) DEFAULT NULL COMMENT '手机',
  `credit` double(5,0) DEFAULT NULL COMMENT '信用平均分',
  `startschooltime` datetime DEFAULT NULL COMMENT '入学时间',
  `education` varchar(30) DEFAULT NULL COMMENT '学历',
  `schoolname` varchar(100) DEFAULT NULL COMMENT '学校名称',
  `majortype` varchar(20) DEFAULT NULL COMMENT '专业类型',
  `endschooltime` datetime DEFAULT NULL COMMENT '毕业时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `isworking` int(1) DEFAULT NULL COMMENT '是否在职',
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
INSERT INTO `userbaseinfo` VALUES ('asdasdwqeqr324234sadad12','xiaozhi2','/aosdjaoi/asdajsid2.jpg2',1,'zh-ch2','guangzhou2','guangdong2','小智','1996-05-04','scnuyz@gmail.com','15521195093',100,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `userbaseinfo` VALUES ('o4THs0Hu3H_e-ZMfVzEGf85VefK8','undefined','undefined',1,'zh_cn','shantou','guangdong','郑泳智','1996-01-16','scnuyz@21cn.com','15589632485',NULL,NULL,'博士研究生','世纪龙','哲学',NULL,NULL,NULL);

#
# Table structure for table usercollection
#

CREATE TABLE `usercollection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(50) DEFAULT NULL COMMENT '用户id',
  `joid` int(11) DEFAULT NULL COMMENT '招聘信息id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户收藏表';
INSERT INTO `usercollection` VALUES (1,'asdasdwqeqr324234sadad12',1);
INSERT INTO `usercollection` VALUES (2,'asdasdwqeqr324234sadad12',2);
INSERT INTO `usercollection` VALUES (3,'asdasdwqeqr324234sadad12',4);

#
# Table structure for table usercompanycredit
#

CREATE TABLE `usercompanycredit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` varchar(50) DEFAULT NULL COMMENT '公司id',
  `openid` varchar(50) DEFAULT NULL COMMENT '用户id',
  `credit` double(5,2) DEFAULT NULL COMMENT '信用分数',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `comment` varchar(255) DEFAULT NULL COMMENT '评论',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户对公司信用评分表';

#
# Table structure for table usermsg
#

CREATE TABLE `usermsg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(50) DEFAULT NULL COMMENT '用户id',
  `msg` text COMMENT '消息内容',
  `type` varchar(10) DEFAULT NULL COMMENT '消息类型',
  `msgtime` varchar(10) DEFAULT NULL COMMENT '消息类型',
  `readstatus` int(1) DEFAULT NULL COMMENT '消息状态 1已读 0未读',
  `msgtitle` varchar(15) DEFAULT NULL COMMENT '消息题目',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户消息表';

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

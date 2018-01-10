# MySQL-Front 5.0  (Build 1.0)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: localhost    Database: mcl
# ------------------------------------------------------
# Server version 5.7.20-log

DROP DATABASE IF EXISTS `mcl`;
CREATE DATABASE `mcl` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mcl`;

#
# Table structure for table company
#

CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(10) DEFAULT NULL COMMENT '城市',
  `imgurl` varchar(200) DEFAULT NULL COMMENT '公司图片地址',
  `companysize` varchar(10) DEFAULT NULL COMMENT '公司规模',
  `introduction` text COMMENT '介绍',
  `address` varchar(30) DEFAULT NULL COMMENT '地址',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `checked` int(1) DEFAULT NULL COMMENT '审核状态 1通过 2不通过',
  `credit` double(5,2) DEFAULT NULL COMMENT '信用平均分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业/公司表';
INSERT INTO `company` VALUES (1,'广州','/sad/asdasd','1000人','亚信是在美国纳斯达克成功上市的第一家中国高科技企业(NASDAQ交易代码:ASIA)。总部设在北京，在成都、广州、上海、杭州、南京、福州、沈阳等地设有分支... ','中山大道西89-93号华景软件园b','2017-11-11',1,90);

#
# Table structure for table companyusercredit
#

CREATE TABLE `companyusercredit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) DEFAULT NULL COMMENT '公司id',
  `openid` varchar(50) DEFAULT NULL COMMENT '用户id',
  `credit` float(5,2) DEFAULT NULL COMMENT '信用分数',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
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
  `jobname` varchar(20) DEFAULT NULL COMMENT '职位名称',
  `temptation` varchar(50) DEFAULT NULL COMMENT '职位诱惑',
  `tag` varchar(30) DEFAULT NULL COMMENT '职位标签',
  `type` varchar(30) DEFAULT NULL COMMENT '类型（互联网/通信）',
  `wage` varchar(10) DEFAULT NULL COMMENT '工资（10k-20k）',
  `companyid` int(11) DEFAULT NULL COMMENT '公司id',
  `city` varchar(10) DEFAULT NULL COMMENT '城市（广州）',
  `address` varchar(30) DEFAULT NULL COMMENT '地址',
  `education` varchar(2) DEFAULT NULL COMMENT '学历限制（本科）',
  `duration` varchar(10) DEFAULT NULL COMMENT '时间长度（10个月）',
  `workfrequency` varchar(10) DEFAULT NULL COMMENT '上班频率（4天/周)',
  `description` text COMMENT '描述',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `checked` int(1) DEFAULT NULL COMMENT '审核状态0未审核 1通过 2不通过 3过期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='招聘信息表';
INSERT INTO `joboffers` VALUES (1,'亚信java开发','没有诱惑','五险一金','通信行业','6k',1,'广州','大学城信息枢纽楼','本科','10个月','4天/周','过来做政企门户\r\n','2017-03-15',0);
INSERT INTO `joboffers` VALUES (2,'美团前端开发','五险一金，免费班车，免费体检，节日福利，试用期全薪，绩效奖金多，优秀团队，周末双休，办公环境好','大企业','互联网','面议',2,'厦门','望京东路6号','本科','3年','5天/周','职位职责：\r\n⼯作职责\r\n在移动设备上，追求极致的⽤户体验\r\n负责开发与⽤户和服务器的交互界面\r\n建设企业级和移动前端的技术和工程架构\r\n知识分享者，善于总结、乐于对内外分享\r\n低级别⼯程师的导师，辅导新人\r\n\r\n基本要求\r\n2年以上前端领域开发经验\r\n熟练阅读英⽂原版技术⽂档和书刊\r\n深⼊掌握HTML+CSS+JavaScript等前端技术，代码符合W3C标准、兼容主流浏览器\r\n熟练使⽤⾄少⼀种JS框架，掌握其原理\r\n掌握⾄少⼀种其他语⾔（如Java/PHP/Python/Ruby/Go），有实战经验\r\n本科及以上学历，计算机相关专业毕业（或计算机基础⾮常扎实）\r\n做事认真细心，有一份用心的简历\r\n\r\n优先条件\r\n熟悉Mobile Web/Hybrid Web App/小程序开发/基于Canvas的游戏等开发\r\n利⽤开源代码打造⾃有效率⼯具的经验\r\n熟悉Linux/Unix/Mac平台下的软件开发环境\r\n多终端的开发经验（Android/iOS/Mac/Windows）\r\nNodejs下项目开发经验\r\n技术社区的活跃份⼦\r\n品质优秀的开源作品\r\n妥善经营的技术博客\r\n团队管理经验','2017-11-11',1);
INSERT INTO `joboffers` VALUES (3,'开发实习生','优秀团队，弹性工作制，节日福利，周末双休','六险一金','互联网','3k',3,'北京','海淀区小营西路33号金山软件大厦','本科','2年','4天/周','招聘人数：4 人 实习天数：4 天 / 周\r\n职位职责：\r\n职位描述：\r\n1. 参与基于云端的 HTML5 产品前端/后端/移动端开发 \r\n2. 调研和学习新技术。\r\n\r\n职位要求：\r\n1、熟悉常用的浏览器内核Chromium/WebKit/Webview；\r\n2、理解并掌握Javascript语言核心技术DOM、BOM、Ajax、JSON等，对Javascript框架应用(如jQuery/bootstrap等)有一定的经验；\r\n3、有 Vue.js/Angular.js/React.js/Webpack.js 等前端框架实践经验是加分项；\r\n4、熟悉 Node.js 是加分项   \r\n5、工作习惯良好：自驱动，擅合作，代码清晰整洁；\r\n6. 本科大四或者研二的学生，每周工作至少4天，实习时间3-6个月。\r\n\r\n实习福利：\r\n不打卡，包三餐，转正机会多。\r\n适合能够立即上岗并能保证实习时间的同学\r\n','2017-11-23',1);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='意见表';
INSERT INTO `opinion` VALUES (1,'asdasdwqeqr324234sadad12','12345',NULL,NULL);
INSERT INTO `opinion` VALUES (2,'asdasdwqeqr324234sadad12','12345','2018-01-10 16:44:17',NULL);
INSERT INTO `opinion` VALUES (3,'asdasdwqeqr324234sadad12','12345','2018-01-10 16:44:27',NULL);

#
# Table structure for table rescampus
#

CREATE TABLE `rescampus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reid` int(11) DEFAULT NULL COMMENT '简历id',
  `organizationname` varchar(20) DEFAULT NULL COMMENT '组织名称',
  `position` varchar(20) DEFAULT NULL COMMENT '职位',
  `starttime` datetime DEFAULT NULL COMMENT '开始时间',
  `endtime` datetime DEFAULT NULL COMMENT '结束时间',
  `description` text COMMENT '经历描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='校园经历子表';

#
# Table structure for table resdeliverstatus
#

CREATE TABLE `resdeliverstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `joid` int(11) DEFAULT NULL COMMENT '招聘信息id',
  `reid` int(11) DEFAULT NULL COMMENT '简历id',
  `status` int(1) DEFAULT NULL COMMENT '简历状态（投递，查看，面试，初筛，不合适）',
  `viewed` int(11) DEFAULT NULL COMMENT '被查看（保留）',
  `description` text COMMENT '描述',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `openid` varchar(50) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='简历投递状态表';
INSERT INTO `resdeliverstatus` VALUES (1,2,1,2,1,'232213213','2017-11-11','asdasdwqeqr324234sadad12');
INSERT INTO `resdeliverstatus` VALUES (2,1,2,1,NULL,NULL,'2018-01-10 16:18:10','asdasdwqeqr324234sadad12');

#
# Table structure for table resedu
#

CREATE TABLE `resedu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reid` int(11) DEFAULT NULL COMMENT '简历id',
  `schoolname` varchar(20) DEFAULT NULL COMMENT '学校名称',
  `major` varchar(10) DEFAULT NULL COMMENT '专业',
  `startschooltime` datetime DEFAULT NULL COMMENT '入学时间',
  `endschooltime` datetime DEFAULT NULL COMMENT '毕业时间',
  `education` varchar(2) DEFAULT NULL COMMENT '学历',
  `majorclass` varchar(100) DEFAULT NULL COMMENT '主修课程',
  `certificate` varchar(255) DEFAULT NULL COMMENT '证书',
  `awards` varchar(255) DEFAULT NULL COMMENT '奖项',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教育经历子表';

#
# Table structure for table resume
#

CREATE TABLE `resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(50) DEFAULT NULL COMMENT '用户id',
  `skills` varchar(255) DEFAULT NULL COMMENT '技能描述',
  `hobbies` varchar(255) DEFAULT NULL COMMENT '爱好描述',
  `selfevaluation` varchar(255) DEFAULT NULL COMMENT '个人评价',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简历表';

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
  `country` varchar(20) DEFAULT NULL COMMENT '国家',
  `realname` varchar(10) DEFAULT NULL COMMENT '真实名字',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(13) DEFAULT NULL COMMENT '手机',
  `credit` double(5,2) DEFAULT NULL COMMENT '信用平均分',
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
INSERT INTO `userbaseinfo` VALUES ('asdasdwqeqr324234sadad12','xiaozhi2','/aosdjaoi/asdajsid2.jpg2',1,'zh-ch2','guangzhou2','guangdong2','china2',NULL,NULL,NULL,NULL,NULL);

#
# Table structure for table usercollection
#

CREATE TABLE `usercollection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(50) DEFAULT NULL COMMENT '用户id',
  `joid` int(11) DEFAULT NULL COMMENT '招聘信息id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户收藏表';
INSERT INTO `usercollection` VALUES (1,'asdasdwqeqr324234sadad12',1);
INSERT INTO `usercollection` VALUES (2,'asdasdwqeqr324234sadad12',2);
INSERT INTO `usercollection` VALUES (3,'asdasdwqeqr324234sadad12',4);

#
# Table structure for table usercompanycredit
#

CREATE TABLE `usercompanycredit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) DEFAULT NULL COMMENT '公司id',
  `openid` varchar(50) DEFAULT NULL COMMENT '用户id',
  `credit` double(5,2) DEFAULT NULL COMMENT '信用分数',
  `uodatetime` datetime DEFAULT NULL COMMENT '更新时间',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户消息表';

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

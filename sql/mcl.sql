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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业/公司表';

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
  `temptation` varchar(20) DEFAULT NULL COMMENT '职位诱惑',
  `tag` varchar(30) DEFAULT NULL COMMENT '职位标签',
  `type` varchar(30) DEFAULT NULL COMMENT '类型（互联网/通信）',
  `wage` varchar(10) DEFAULT NULL COMMENT '工资（10k-20k）',
  `companyid` int(11) DEFAULT NULL COMMENT '公司id',
  `city/country` varchar(10) DEFAULT NULL COMMENT '城市（广东-广州）',
  `address` varchar(30) DEFAULT NULL COMMENT '地址',
  `education` varchar(2) DEFAULT NULL COMMENT '学历限制（本科）',
  `duration` varchar(10) DEFAULT NULL COMMENT '时间长度（10个月）',
  `workfrequency` varchar(10) DEFAULT NULL COMMENT '上班频率（4天/周)',
  `description` text COMMENT '描述',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `checkd` int(1) DEFAULT NULL COMMENT '审核状态 1通过 2不通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招聘信息表';

#
# Table structure for table opinion
#

CREATE TABLE `opinion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(20) DEFAULT NULL COMMENT '用户id',
  `description` text COMMENT '描述',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `contactinfo` varchar(30) DEFAULT NULL COMMENT '联系方式（保留）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='意见表';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简历投递状态表';

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
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Table structure for table usercollection
#

CREATE TABLE `usercollection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(50) DEFAULT NULL COMMENT '用户id',
  `joid` int(11) DEFAULT NULL COMMENT '招聘信息id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏表';

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

/*
Navicat MySQL Data Transfer

Source Server         : BiYeSheJi
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : hrs

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2017-06-01 21:18:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adjustrestinfo
-- ----------------------------
DROP TABLE IF EXISTS `adjustrestinfo`;
CREATE TABLE `adjustrestinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `stuffDepart` varchar(50) NOT NULL,
  `adjustType` varchar(10) DEFAULT NULL,
  `adjustBefore` varchar(10) NOT NULL,
  `adjustAfter` varchar(10) NOT NULL,
  `adjustApprover` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adjustrestinfo
-- ----------------------------
INSERT INTO `adjustrestinfo` VALUES ('1', 'test001', 'test1', 'qq', 'ww', '2017-06-01', '2017-06-02', null);

-- ----------------------------
-- Table structure for admininfo
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `resignDate` varchar(10) NOT NULL,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES ('1', 'test001', 'test1', '2017-06-01', 'aaa', '123');
INSERT INTO `admininfo` VALUES ('3', 'HR001', 'aa', '2017-6-1', 'qqq', '123');
INSERT INTO `admininfo` VALUES ('4', 'HR001', 'aa', '2017-6-1', 'qqq', '123');

-- ----------------------------
-- Table structure for allowance
-- ----------------------------
DROP TABLE IF EXISTS `allowance`;
CREATE TABLE `allowance` (
  `id` int(10) NOT NULL,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `stuffDepart` varchar(50) NOT NULL,
  `allowanceMonth` int(5) NOT NULL,
  `transAwce` double(10,0) DEFAULT NULL,
  `foodAwce` double(10,0) DEFAULT NULL,
  `houseAwce` double(10,0) DEFAULT NULL,
  ` cmuAwce` double(10,0) DEFAULT NULL,
  `accountAwce` double(10,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of allowance
-- ----------------------------

-- ----------------------------
-- Table structure for applicantinfo
-- ----------------------------
DROP TABLE IF EXISTS `applicantinfo`;
CREATE TABLE `applicantinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `apName` varchar(20) NOT NULL,
  `apDuty` varchar(20) NOT NULL,
  `apAge` int(5) NOT NULL,
  `apEdu` varchar(50) NOT NULL,
  `apSkill` varchar(225) DEFAULT NULL,
  `apExperience` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applicantinfo
-- ----------------------------
INSERT INTO `applicantinfo` VALUES ('1', '董一傻', '软件测试工程师', '3', '本科', 'loadrunner', '无');
INSERT INTO `applicantinfo` VALUES ('2', '董二傻', '网页设计助理', '5', '本科', 'html', '半年');
INSERT INTO `applicantinfo` VALUES ('3', '董三傻', '前端实习生', '8', '本科', 'css', '10个月');
INSERT INTO `applicantinfo` VALUES ('5', '董三', 'java工程师', '0', '研究生', 'js', '1年');
INSERT INTO `applicantinfo` VALUES ('6', '董六', 'java工程师', '0', '研究生', 'js', '1年');

-- ----------------------------
-- Table structure for checkinfo
-- ----------------------------
DROP TABLE IF EXISTS `checkinfo`;
CREATE TABLE `checkinfo` (
  `id` int(10) NOT NULL,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `stuffDepart` varchar(50) NOT NULL,
  `stuffShift` varchar(10) NOT NULL,
  `workHour` double(10,2) NOT NULL,
  `workDate` varchar(10) NOT NULL,
  `lateHour` double(10,2) DEFAULT NULL,
  `absentHour` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkinfo
-- ----------------------------
INSERT INTO `checkinfo` VALUES ('1', 'test001', 'test1', 'qq', '白班', '12.00', '0', '0.00', '0.00');
INSERT INTO `checkinfo` VALUES ('2', 'test002', 'test2', 'qq', '白班', '12.00', '0', '0.00', '0.00');

-- ----------------------------
-- Table structure for departmentinfo
-- ----------------------------
DROP TABLE IF EXISTS `departmentinfo`;
CREATE TABLE `departmentinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `departID` varchar(20) NOT NULL,
  `departName` varchar(50) NOT NULL,
  `departPrince` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of departmentinfo
-- ----------------------------
INSERT INTO `departmentinfo` VALUES ('3', 'OPN', '运营部', '王新昊');
INSERT INTO `departmentinfo` VALUES ('4', 'FNS', '财务部', '王影');
INSERT INTO `departmentinfo` VALUES ('5', 'PSDT', '总经理', '宁禄乔');
INSERT INTO `departmentinfo` VALUES ('6', 'MKTG', '市场部', '李月强');
INSERT INTO `departmentinfo` VALUES ('16', 'test', '测试', '木头人');
INSERT INTO `departmentinfo` VALUES ('17', '11', '112', '11');
INSERT INTO `departmentinfo` VALUES ('15', 'HR', '人力资源部', '王雅婷');

-- ----------------------------
-- Table structure for dimissioninfo
-- ----------------------------
DROP TABLE IF EXISTS `dimissioninfo`;
CREATE TABLE `dimissioninfo` (
  `id` int(10) NOT NULL,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `stuffDepart` varchar(50) NOT NULL,
  `stuffDuty` varchar(20) NOT NULL,
  `dimissInterface` varchar(20) NOT NULL,
  `dimissReason` varchar(225) DEFAULT NULL,
  `dimissDate` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dimissioninfo
-- ----------------------------
INSERT INTO `dimissioninfo` VALUES ('1', 'test001', 'test', 'ABC', 'web', '啊啊', '啊啊啊看看', '2017-05-13');
INSERT INTO `dimissioninfo` VALUES ('2', 'test002', 'test2', 'ABC', 'web', 'she', 'no', '2017-06-01');

-- ----------------------------
-- Table structure for jobinfo
-- ----------------------------
DROP TABLE IF EXISTS `jobinfo`;
CREATE TABLE `jobinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `stuffDepart` varchar(50) NOT NULL,
  `stuffDuty` varchar(20) NOT NULL,
  `stuffStatus` varchar(20) NOT NULL,
  `stuffEntryDate` varchar(10) NOT NULL,
  `contractBegin` varchar(10) DEFAULT NULL,
  `contractEnd` varchar(10) DEFAULT NULL,
  `stuffMoney` double(20,2) NOT NULL,
  `adjustJob` varchar(10) DEFAULT NULL,
  `adjustMoney` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jobinfo
-- ----------------------------
INSERT INTO `jobinfo` VALUES ('22', 'HR001', 'aa', '人力资源部', '软件测试工程师', '试用期', '2017-05-20', null, null, '0.00', null, null);
INSERT INTO `jobinfo` VALUES ('18', 'OPN007', '董傻', '运营部', '软件测试工程师', '试用期', '2017-05-20', '', '', '8000.00', null, '2017-05-03');
INSERT INTO `jobinfo` VALUES ('19', 'OPN005', '董一傻', '运营部', '软件测试工程师', '试用期', '2017-05-25', '', '', '6000.00', '', '');
INSERT INTO `jobinfo` VALUES ('20', 'MKTG002', '董一傻', '市场部', '软件测试工程师', '试用期', '2017-05-20', '', '', '6000.00', '', '');
INSERT INTO `jobinfo` VALUES ('21', 'OPN006', '董一傻', '运营部', '软件测试工程师', '试用期', '2017-05-20', '', '', '6000.00', '', '');

-- ----------------------------
-- Table structure for overworkinfo
-- ----------------------------
DROP TABLE IF EXISTS `overworkinfo`;
CREATE TABLE `overworkinfo` (
  `id` int(10) NOT NULL,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `stuffDepart` varchar(50) NOT NULL,
  `overworkStart` varchar(10) DEFAULT NULL,
  `overworkEnd` varchar(10) DEFAULT NULL,
  `overworkHours` double(10,2) NOT NULL,
  `overworkReason` varchar(500) DEFAULT NULL,
  `overworkMoney` double(10,2) NOT NULL,
  `overworkApprover` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of overworkinfo
-- ----------------------------
INSERT INTO `overworkinfo` VALUES ('0', 'test001', 'test1', 'qq', '2017-06-01', '2017-06-02', '2.00', null, '40.00', 'aa');
INSERT INTO `overworkinfo` VALUES ('2', 'test002', 'test2', 'qq', '2017-06-01', '2017-06-02', '2.00', '', '40.00', 'aa');

-- ----------------------------
-- Table structure for recruitinfo
-- ----------------------------
DROP TABLE IF EXISTS `recruitinfo`;
CREATE TABLE `recruitinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `demandJob` varchar(20) NOT NULL,
  `demandNum` int(10) NOT NULL,
  `existNum` int(10) NOT NULL,
  `jobRequest` text NOT NULL,
  `arrivalDate` varchar(10) DEFAULT NULL,
  `recruitStatus` varchar(20) NOT NULL,
  `applycant` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recruitinfo
-- ----------------------------
INSERT INTO `recruitinfo` VALUES ('1', '前端', '2', '10', 'css', '2017-06-01', '发布', '宝贝');

-- ----------------------------
-- Table structure for retireinfo
-- ----------------------------
DROP TABLE IF EXISTS `retireinfo`;
CREATE TABLE `retireinfo` (
  `id` int(10) NOT NULL,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `stuffDepart` varchar(50) NOT NULL,
  `stuffDuty` varchar(20) NOT NULL,
  `stuffEntryDate` varchar(10) NOT NULL,
  `retireDate` varchar(10) NOT NULL,
  `retireInterface` varchar(20) NOT NULL,
  `retireMoney` double(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of retireinfo
-- ----------------------------
INSERT INTO `retireinfo` VALUES ('0', 'test001', 'test1', '人力资源部', '职工', '2017-06-12', '2017-06-05', '啊啊', '2000.00');

-- ----------------------------
-- Table structure for rewardpunish
-- ----------------------------
DROP TABLE IF EXISTS `rewardpunish`;
CREATE TABLE `rewardpunish` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `stuffDepart` varchar(50) NOT NULL,
  `happenDate` varchar(10) NOT NULL,
  `happenType` varchar(10) NOT NULL,
  `happenReason` varchar(225) DEFAULT NULL,
  `changeMoney` double(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rewardpunish
-- ----------------------------
INSERT INTO `rewardpunish` VALUES ('1', 'test001', 'test1', '人力资源部', '2017-06-01', '奖', '好', '100.00');

-- ----------------------------
-- Table structure for salaryinfo
-- ----------------------------
DROP TABLE IF EXISTS `salaryinfo`;
CREATE TABLE `salaryinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `stuffDepart` varchar(50) NOT NULL,
  `stuffDuty` varchar(20) DEFAULT NULL,
  `basicSalary` double(10,2) DEFAULT NULL,
  `delSalary` double(10,2) DEFAULT NULL,
  `addSalary` double(10,2) DEFAULT NULL,
  `accountAwce` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salaryinfo
-- ----------------------------
INSERT INTO `salaryinfo` VALUES ('1', 'test001', 'test1', '人力资源部', '职工', '4000.00', '0.00', '0.00', '0.00');

-- ----------------------------
-- Table structure for stuffinfo
-- ----------------------------
DROP TABLE IF EXISTS `stuffinfo`;
CREATE TABLE `stuffinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stuffID` varchar(20) CHARACTER SET utf8 NOT NULL,
  `stuffName` varchar(20) CHARACTER SET utf8 NOT NULL,
  `stuffBirth` varchar(10) NOT NULL,
  `stuffSex` varchar(5) CHARACTER SET utf8 NOT NULL,
  `stuffNation` varchar(20) CHARACTER SET utf8 NOT NULL,
  `stuffAddress` varchar(100) CHARACTER SET utf8 NOT NULL,
  `stuffTel` varchar(20) CHARACTER SET utf8 NOT NULL,
  `stuffEmail` varchar(50) CHARACTER SET utf8 NOT NULL,
  `stuffEdu` varchar(50) CHARACTER SET utf8 NOT NULL,
  `stuffColleage` varchar(50) CHARACTER SET utf8 NOT NULL,
  `stuffProfession` varchar(100) CHARACTER SET utf8 NOT NULL,
  `stuffGrade` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `stuffWedding` varchar(5) CHARACTER SET utf8 NOT NULL,
  `stuffSkill` varchar(225) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stuffinfo
-- ----------------------------
INSERT INTO `stuffinfo` VALUES ('6', 'MKTG001', '董傻', '2017-05-12', 'M', '汉族', '海的那边', '18888888888', '188@163.com', '2', '山东工商学院', '信管', '', '0', 'loadrunner');
INSERT INTO `stuffinfo` VALUES ('7', 'OPN005', '董不傻', '2017-05-10', 'M', '打发', '大得多', '18888888888', '188@163.com', '研究生', 'dfdffdfa', 'dfddfd', '', '0', 'loadrunner');
INSERT INTO `stuffinfo` VALUES ('8', 'MKTG002', '董一傻', '2017-05-11', 'M', '汉', '滨海中路', '18888888888', '188@163.com', '2', '山东工商学院', '信管', '', '0', 'loadrunner');
INSERT INTO `stuffinfo` VALUES ('9', 'OPN006', '董一傻', '2017-05-03', 'M', '汉', '滨海中路', '18888888888', '188@163.com', '2', '山东工商学院', '信管', '', '0', 'loadrunner');

-- ----------------------------
-- Table structure for traininfo
-- ----------------------------
DROP TABLE IF EXISTS `traininfo`;
CREATE TABLE `traininfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `stuffDepart` varchar(50) NOT NULL,
  `trainType` varchar(20) DEFAULT NULL,
  `trainBegin` varchar(10) DEFAULT NULL,
  `trainEnd` varchar(10) DEFAULT NULL,
  `trainTeacher` varchar(20) DEFAULT NULL,
  `trainResult` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traininfo
-- ----------------------------
INSERT INTO `traininfo` VALUES ('1', 'test001', 'test1', 'aa', 'bb', '2017-06-03', '2017-06-03', 'cc', '99');
INSERT INTO `traininfo` VALUES ('2', 'test002', 'test2', 'aa', 'bb', '2017-06-03', '2017-06-03', 'cc', 'dd');
INSERT INTO `traininfo` VALUES ('4', '', '董傻', '运营部', 'ww', '2016-05-30', '2017-05-09', 'qq', null);
INSERT INTO `traininfo` VALUES ('5', 'OPN005', '董一傻', '运营部', 'dw', '2017-05-24', '2017-05-27', 'ww', null);

-- ----------------------------
-- Table structure for workleaveinfo
-- ----------------------------
DROP TABLE IF EXISTS `workleaveinfo`;
CREATE TABLE `workleaveinfo` (
  `id` int(10) NOT NULL,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `stuffDepart` varchar(50) NOT NULL,
  `leaveBegin` varchar(10) NOT NULL,
  `leaveEnd` varchar(10) NOT NULL,
  `leaveHours` double(10,2) NOT NULL,
  `leaveType` varchar(10) NOT NULL,
  `leaveReason` varchar(225) DEFAULT NULL,
  `approver` varchar(20) NOT NULL,
  `leaveMoney` double(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workleaveinfo
-- ----------------------------
INSERT INTO `workleaveinfo` VALUES ('0', 'test001', 'test1', 'qq', '2017-06-01', '2017-06-02', '8.00', '事假', null, 'aa', '160.00');
INSERT INTO `workleaveinfo` VALUES ('2', 'test002', 'test2', 'qq', '2017-06-01', '2017-06-02', '8.00', '事假', '', 'aa', '160.00');

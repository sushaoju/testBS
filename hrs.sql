/*
Navicat MySQL Data Transfer

Source Server         : BiYeSheJi
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : hrs

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2017-05-07 13:35:10
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
  `adjustType` varchar(10) NOT NULL,
  `adjustBefore` date NOT NULL,
  `adjustAfter` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adjustrestinfo
-- ----------------------------

-- ----------------------------
-- Table structure for admininfo
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `resignDate` date NOT NULL,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admininfo
-- ----------------------------

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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applicantinfo
-- ----------------------------

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
  `workDate` date NOT NULL,
  `lateHour` double(10,2) DEFAULT NULL,
  `absentHour` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkinfo
-- ----------------------------

-- ----------------------------
-- Table structure for departmentinfo
-- ----------------------------
DROP TABLE IF EXISTS `departmentinfo`;
CREATE TABLE `departmentinfo` (
  `id` int(10) NOT NULL,
  `departID` varchar(20) NOT NULL,
  `departName` varchar(50) NOT NULL,
  `departPrince` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of departmentinfo
-- ----------------------------

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
  `dimissReason` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dimissioninfo
-- ----------------------------

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
  `stuffEntryDate` date NOT NULL,
  `contractBegin` date DEFAULT NULL,
  `contactEnd` date DEFAULT NULL,
  `stuffMoney` double(20,2) NOT NULL,
  `adjustJob` date DEFAULT NULL,
  `adjustMoney` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jobinfo
-- ----------------------------

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
  `arrivalDate` date DEFAULT NULL,
  `recruitStatus` varchar(20) NOT NULL,
  `applycant` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recruitinfo
-- ----------------------------

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
  `stuffEntryDate` date NOT NULL,
  `retireDate` date NOT NULL,
  `retireInterface` varchar(20) NOT NULL,
  `retireMoney` double(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of retireinfo
-- ----------------------------

-- ----------------------------
-- Table structure for rewardpunish
-- ----------------------------
DROP TABLE IF EXISTS `rewardpunish`;
CREATE TABLE `rewardpunish` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `stuffDepart` varchar(50) NOT NULL,
  `happenDate` date NOT NULL,
  `happenType` varchar(10) NOT NULL,
  `happenReason` text,
  `changeMoney` double(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rewardpunish
-- ----------------------------

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
  `salaryStatus` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salaryinfo
-- ----------------------------

-- ----------------------------
-- Table structure for stuffinfo
-- ----------------------------
DROP TABLE IF EXISTS `stuffinfo`;
CREATE TABLE `stuffinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stuffID` varchar(20) CHARACTER SET utf8 NOT NULL,
  `stuffName` varchar(20) CHARACTER SET utf8 NOT NULL,
  `stuffAge` int(5) NOT NULL,
  `stuffSex` varchar(5) CHARACTER SET utf8 NOT NULL,
  `stuffNation` varchar(20) CHARACTER SET utf8 NOT NULL,
  `stuffAddress` varchar(100) CHARACTER SET utf8 NOT NULL,
  `stuffTel` varchar(20) CHARACTER SET utf8 NOT NULL,
  `stuffEmail` varchar(50) CHARACTER SET utf8 NOT NULL,
  `stuffEdu` varchar(50) CHARACTER SET utf8 NOT NULL,
  `stuffcolleage` varchar(50) CHARACTER SET utf8 NOT NULL,
  `stuffProfession` varchar(100) CHARACTER SET utf8 NOT NULL,
  `stuffGrade` varchar(200) CHARACTER SET utf8 NOT NULL,
  `stuffWedding` varchar(5) CHARACTER SET utf8 NOT NULL,
  `stuffSkill` varchar(225) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stuffinfo
-- ----------------------------

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
  `trainBegin` date DEFAULT NULL,
  `trainEnd` date DEFAULT NULL,
  `trainTeacher` varchar(20) DEFAULT NULL,
  `trainResult` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traininfo
-- ----------------------------

-- ----------------------------
-- Table structure for workleaveinfo
-- ----------------------------
DROP TABLE IF EXISTS `workleaveinfo`;
CREATE TABLE `workleaveinfo` (
  `id` int(10) NOT NULL,
  `stuffID` varchar(20) NOT NULL,
  `stuffName` varchar(20) NOT NULL,
  `stuffDepart` varchar(50) NOT NULL,
  `leaveBegin` date NOT NULL,
  `leaveEnd` date NOT NULL,
  `leaveHours` double(10,2) NOT NULL,
  `leaveType` varchar(10) NOT NULL,
  `leaveReason` text,
  `approver` varchar(20) NOT NULL,
  `leaveMoney` double(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workleaveinfo
-- ----------------------------

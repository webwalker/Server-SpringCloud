/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : xujian

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 05/08/2019 18:09:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for T_USER
-- ----------------------------
DROP TABLE IF EXISTS `T_USER`;
CREATE TABLE `T_USER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(20) DEFAULT NULL,
  `PASSWD` varchar(128) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `STATUS` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_USER
-- 密码都是：123456
-- ----------------------------
BEGIN;
INSERT INTO `T_USER` VALUES (1, 'mrbird', '42ee25d1e43e9f57119a00d0a39e5250', '2017-11-19 10:52:48', '1');
INSERT INTO `T_USER` VALUES (2, 'test', '7a38c13ec5e9310aed731de58bbc4214', '2017-11-19 17:20:21', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

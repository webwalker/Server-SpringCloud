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

 Date: 05/08/2019 18:09:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for T_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `T_ROLE`;
CREATE TABLE `T_ROLE` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `MEMO` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_ROLE
-- ----------------------------
BEGIN;
INSERT INTO `T_ROLE` VALUES (1, 'admin', '超级管理员');
INSERT INTO `T_ROLE` VALUES (2, 'test', '测试账户');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

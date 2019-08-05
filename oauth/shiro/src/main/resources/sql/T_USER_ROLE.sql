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

 Date: 05/08/2019 18:10:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for T_USER_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `T_USER_ROLE`;
CREATE TABLE `T_USER_ROLE` (
  `USER_ID` int(10) DEFAULT NULL,
  `RID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_USER_ROLE
-- ----------------------------
BEGIN;
INSERT INTO `T_USER_ROLE` VALUES (1, 1);
INSERT INTO `T_USER_ROLE` VALUES (2, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

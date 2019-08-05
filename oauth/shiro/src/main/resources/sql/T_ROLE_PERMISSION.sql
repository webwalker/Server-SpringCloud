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

 Date: 05/08/2019 18:09:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for T_ROLE_PERMISSION
-- ----------------------------
DROP TABLE IF EXISTS `T_ROLE_PERMISSION`;
CREATE TABLE `T_ROLE_PERMISSION` (
  `RID` int(10) NOT NULL,
  `PID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_ROLE_PERMISSION
-- ----------------------------
BEGIN;
INSERT INTO `T_ROLE_PERMISSION` VALUES (1, 2);
INSERT INTO `T_ROLE_PERMISSION` VALUES (1, 3);
INSERT INTO `T_ROLE_PERMISSION` VALUES (2, 1);
INSERT INTO `T_ROLE_PERMISSION` VALUES (1, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

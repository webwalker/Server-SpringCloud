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

 Date: 05/08/2019 18:09:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for T_PERMISSION
-- ----------------------------
DROP TABLE IF EXISTS `T_PERMISSION`;
CREATE TABLE `T_PERMISSION` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `URL` varchar(255) DEFAULT NULL,
  `NAME` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of T_PERMISSION
-- ----------------------------
BEGIN;
INSERT INTO `T_PERMISSION` VALUES (1, '/user', 'user:user');
INSERT INTO `T_PERMISSION` VALUES (2, '/user/add', 'user:add');
INSERT INTO `T_PERMISSION` VALUES (3, '/user/delete', 'user:delete');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

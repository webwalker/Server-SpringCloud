-- ----------------------------
-- Table structure for shiro_user
-- ----------------------------
DROP TABLE IF EXISTS `shiro_user`;
CREATE TABLE `shiro_user` (
                              `ID` int(11) NOT NULL AUTO_INCREMENT,
                              `USERNAME` varchar(20) DEFAULT NULL,
                              `PASSWD` varchar(128) DEFAULT NULL,
                              `CREATE_TIME` datetime DEFAULT NULL,
                              `STATUS` char(1) DEFAULT NULL,
                              PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of shiro_user
-- 密码都是：123456
-- ----------------------------
BEGIN;
INSERT INTO `shiro_user` VALUES (1, 'mrbird', '42ee25d1e43e9f57119a00d0a39e5250', '2017-11-19 10:52:48', '1');
INSERT INTO `shiro_user` VALUES (2, 'test', '7a38c13ec5e9310aed731de58bbc4214', '2017-11-19 17:20:21', '0');
COMMIT;

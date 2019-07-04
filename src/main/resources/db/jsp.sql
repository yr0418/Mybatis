/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : jsp

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 04/07/2019 19:12:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, 1, '我的世界', '你的爱情');
INSERT INTO `blog` VALUES (2, 1, '我的天堂', '你的世界');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '你在说啥', 1);
INSERT INTO `comment` VALUES (2, '我的天啊', 1);
INSERT INTO `comment` VALUES (3, '呜呜呜呜呜呜', 2);
INSERT INTO `comment` VALUES (4, '哈哈哈哈哈哈哈', 2);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `price` double(10, 2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '红烧排骨', 25.00);
INSERT INTO `menu` VALUES (2, '红烧肉', 25.00);
INSERT INTO `menu` VALUES (3, '辣椒炒肉', 20.00);
INSERT INTO `menu` VALUES (4, '鸡公煲', 45.00);
INSERT INTO `menu` VALUES (5, '剁椒鱼头', 50.00);
INSERT INTO `menu` VALUES (6, '卤牛肉', 45.00);
INSERT INTO `menu` VALUES (7, '皮蛋瘦肉粥', 3.00);
INSERT INTO `menu` VALUES (8, '煲仔饭', 10.00);
INSERT INTO `menu` VALUES (9, '玉米火腿炒饭', 8.00);
INSERT INTO `menu` VALUES (14, '牛肉面', 12.00);
INSERT INTO `menu` VALUES (20, '羊杂汤', 12.00);

-- ----------------------------
-- Table structure for reserve
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `food` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `sumprice` double(10, 2) DEFAULT NULL,
  `times` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `YN` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of reserve
-- ----------------------------
INSERT INTO `reserve` VALUES (6, '123456', '红烧肉,辣椒炒肉,', 45.00, '2019-06-12 00:06:42', '3期公寓', '已签收');
INSERT INTO `reserve` VALUES (7, '123456', '红烧排骨,红烧肉,辣椒炒肉,', 70.00, '2019-06-12 00:41:24', '3期公寓', '已签收');
INSERT INTO `reserve` VALUES (8, 'root', '红烧排骨,红烧肉,', 50.00, '2019-06-20 18:14:26', '3期', '未签收');

-- ----------------------------
-- Table structure for u
-- ----------------------------
DROP TABLE IF EXISTS `u`;
CREATE TABLE `u`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u
-- ----------------------------
INSERT INTO `u` VALUES (1, '12344445555', '111111', 1);

-- ----------------------------
-- Table structure for u_details
-- ----------------------------
DROP TABLE IF EXISTS `u_details`;
CREATE TABLE `u_details`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` int(10) DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_details
-- ----------------------------
INSERT INTO `u_details` VALUES (1, 1, '111', '111');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'root', 'root', '01');
INSERT INTO `user` VALUES (3, 'test', 'test', '02');
INSERT INTO `user` VALUES (11, '111', '11234567', '杨睿');
INSERT INTO `user` VALUES (12, '123456', '111', '111');
INSERT INTO `user` VALUES (13, '22', '22', '王小旭');
INSERT INTO `user` VALUES (14, '1234', '11234567', '杨睿');
INSERT INTO `user` VALUES (15, '杨睿', '11234567', '杨睿');
INSERT INTO `user` VALUES (16, '111', '111', '王睿');

SET FOREIGN_KEY_CHECKS = 1;

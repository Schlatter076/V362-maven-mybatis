/*
 Navicat Premium Data Transfer

 Source Server         : mySQL
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : v362

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 10/05/2019 09:27:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type`  (
  `num` int(11) NULL DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES (1, 'V362侧拉门开关');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'v36200');

-- ----------------------------
-- Table structure for v362
-- ----------------------------
DROP TABLE IF EXISTS `v362`;
CREATE TABLE `v362`  (
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upper` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lower` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of v362
-- ----------------------------
INSERT INTO `v362` VALUES ('Number', 'Item', 'Upper', 'Lower', 'Value', 'Unit', 'Result');
INSERT INTO `v362` VALUES ('1', 'Left_PIN1-PIN2绝缘', '10', '1', '?', '兆欧', '?');
INSERT INTO `v362` VALUES ('2', 'Left_PIN2-PIN3绝缘', '10', '1', '?', '兆欧', '?');
INSERT INTO `v362` VALUES ('3', 'Right_PIN1-PIN2绝缘', '10', '1', '?', '兆欧', '?');
INSERT INTO `v362` VALUES ('4', 'Right_PIN2-PIN3绝缘', '10', '1', '?', '兆欧', '?');
INSERT INTO `v362` VALUES ('5', '产品负载电压', '13.5', '13', '?', 'V', '?');
INSERT INTO `v362` VALUES ('6', 'PIN1电压降', '125', '0', '?', 'mV', '?');
INSERT INTO `v362` VALUES ('7', 'PIN2电压降', '125', '0', '?', 'mV', '?');
INSERT INTO `v362` VALUES ('8', 'PIN3电压降', '125', '0', '?', 'mV', '?');
INSERT INTO `v362` VALUES ('9', '产品断电', '1', '0', '?', 'V', '?');

-- ----------------------------
-- Table structure for v362_product_num
-- ----------------------------
DROP TABLE IF EXISTS `v362_product_num`;
CREATE TABLE `v362_product_num`  (
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of v362_product_num
-- ----------------------------
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');
INSERT INTO `v362_product_num` VALUES ('你好');

-- ----------------------------
-- Table structure for v362_recordtd
-- ----------------------------
DROP TABLE IF EXISTS `v362_recordtd`;
CREATE TABLE `v362_recordtd`  (
  `recordname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recordsum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recordok` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recordng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recordts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recordtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of v362_recordtd
-- ----------------------------
INSERT INTO `v362_recordtd` VALUES ('v362', '100', '95', '5', '32', '2019-05-08');
INSERT INTO `v362_recordtd` VALUES ('v362', '250', '249', '1', '25.8', '2019-05-09');

-- ----------------------------
-- Table structure for v362_testdata
-- ----------------------------
DROP TABLE IF EXISTS `v362_testdata`;
CREATE TABLE `v362_testdata`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `items` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upper` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lower` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `times` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of v362_testdata
-- ----------------------------
INSERT INTO `v362_testdata` VALUES (1, 'fkodfk', '1', 'dajiba', '', '', '5.2', 'V', 'PASS', '10:30', '2019-05-08', '');
INSERT INTO `v362_testdata` VALUES (2, '789456', '1', 'cdvd', '52.3', '45.2', '50.1', 'V', 'PASS', '13:42', '2019-05-09', '');
INSERT INTO `v362_testdata` VALUES (3, '789456', '2', 'cdvd', '52.3', '45.2', '50.2', 'V', 'PASS', '13:42', '2019-05-09', '');
INSERT INTO `v362_testdata` VALUES (4, '789456', '3', 'cdvd', '52.3', '45.2', '50.3', 'V', 'PASS', '13:42', '2019-05-09', '');
INSERT INTO `v362_testdata` VALUES (5, '789456', '4', 'cdvd', '52.3', '45.2', '50.4', 'V', 'PASS', '13:42', '2019-05-09', '');
INSERT INTO `v362_testdata` VALUES (6, '789456', '5', 'cdvd', '52.3', '45.2', '50.5', 'V', 'PASS', '13:42', '2019-05-09', '');
INSERT INTO `v362_testdata` VALUES (7, '789456', '6', 'cdvd', '52.3', '45.2', '50.6', 'V', 'PASS', '13:42', '2019-05-09', '');
INSERT INTO `v362_testdata` VALUES (8, '789456', '7', 'cdvd', '52.3', '45.2', '50.7', 'V', 'PASS', '13:42', '2019-05-09', '');
INSERT INTO `v362_testdata` VALUES (9, '789456', '8', 'cdvd', '52.3', '45.2', '50.8', 'V', 'PASS', '13:42', '2019-05-09', '');
INSERT INTO `v362_testdata` VALUES (10, '789456', '9', 'cdvd', '52.3', '45.2', '50.9', 'V', 'PASS', '13:42', '2019-05-09', '');

-- ----------------------------
-- Table structure for v362_testdata_copy1
-- ----------------------------
DROP TABLE IF EXISTS `v362_testdata_copy1`;
CREATE TABLE `v362_testdata_copy1`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `items` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upper` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lower` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `times` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

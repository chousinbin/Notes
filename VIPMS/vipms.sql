/*
 Navicat Premium Dump SQL

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 50742 (5.7.42)
 Source Host           : localhost:3306
 Source Schema         : vipms

 Target Server Type    : MySQL
 Target Server Version : 50742 (5.7.42)
 File Encoding         : 65001

 Date: 27/08/2025 21:53:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for convert_records
-- ----------------------------
DROP TABLE IF EXISTS `convert_records`;
CREATE TABLE `convert_records`  (
  `gift_records_id` int(6) NOT NULL AUTO_INCREMENT,
  `member_id` int(6) NULL DEFAULT NULL,
  `gift_id` int(6) NULL DEFAULT NULL,
  `gift_quantity` int(6) NULL DEFAULT NULL,
  `reward_used` decimal(10, 2) NULL DEFAULT NULL,
  `gift_record_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`gift_records_id`) USING BTREE,
  INDEX `member_id_1`(`member_id`) USING BTREE,
  INDEX `gift_id_1`(`gift_id`) USING BTREE,
  CONSTRAINT `gift_id_1` FOREIGN KEY (`gift_id`) REFERENCES `gifts` (`gift_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `member_id_1` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of convert_records
-- ----------------------------

-- ----------------------------
-- Table structure for gifts
-- ----------------------------
DROP TABLE IF EXISTS `gifts`;
CREATE TABLE `gifts`  (
  `gift_id` int(6) NOT NULL AUTO_INCREMENT,
  `gift_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gift_stock` int(6) NULL DEFAULT NULL,
  `gift_value` int(6) NULL DEFAULT NULL,
  `gift_status` enum('1','0') CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '1',
  PRIMARY KEY (`gift_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gifts
-- ----------------------------
INSERT INTO `gifts` VALUES (5, '白面5KG', 9, 1000, '1');

-- ----------------------------
-- Table structure for members
-- ----------------------------
DROP TABLE IF EXISTS `members`;
CREATE TABLE `members`  (
  `member_id` int(10) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `member_simple_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `member_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `member_birthday` date NULL DEFAULT NULL,
  `member_balance` decimal(10, 2) UNSIGNED NULL DEFAULT 0.00,
  `member_reward_times` int(10) NULL DEFAULT 0,
  `member_total_reward` decimal(10, 2) NULL DEFAULT 0.00,
  `member_available_reward` decimal(10, 2) NULL DEFAULT 0.00,
  `member_status` enum('0','1') CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '1',
  PRIMARY KEY (`member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of members
-- ----------------------------
INSERT INTO `members` VALUES (1, '周成林', 'zcl', '15175533129', '2025-02-09', 0.00, 110, 5760.00, 760.00, '1');
INSERT INTO `members` VALUES (2, '李国', 'lg', '13932591431', '2025-02-08', 0.00, 59, 2677.00, 1677.00, '1');
INSERT INTO `members` VALUES (3, '周进忠', 'zjz', '15076523734', '2025-02-08', 0.00, 83, 7813.00, 613.00, '1');
INSERT INTO `members` VALUES (5, '史平锐', 'spr', '13582841821', '2025-02-08', 0.00, 46, 824.00, 424.00, '1');
INSERT INTO `members` VALUES (6, '周海忠', 'zhz', '13463572937', '2025-02-19', 0.00, 172, 4819.00, 1819.00, '1');
INSERT INTO `members` VALUES (7, '居丽红', 'jlh', '13653156329', '2025-02-26', 0.00, 100, 3792.00, 792.00, '1');
INSERT INTO `members` VALUES (8, '金怀', 'jh', '15032926318', '2025-02-26', 0.00, 105, 3269.00, 769.00, '1');
INSERT INTO `members` VALUES (9, '王强', 'wq', '15027626253', NULL, 0.00, 293, 10884.00, 1330.00, '1');
INSERT INTO `members` VALUES (10, '李国艳', 'lgy', '18332784328', NULL, 0.00, 0, 3866.00, 866.00, '1');
INSERT INTO `members` VALUES (11, '高兴', 'gx', NULL, NULL, 0.00, 18, 245.00, 245.00, '1');

-- ----------------------------
-- Table structure for reward_records
-- ----------------------------
DROP TABLE IF EXISTS `reward_records`;
CREATE TABLE `reward_records`  (
  `record_id` int(10) NOT NULL AUTO_INCREMENT,
  `member_id` int(10) NOT NULL,
  `record_amount` decimal(10, 2) NOT NULL,
  `record_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `record_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`record_id`) USING BTREE,
  INDEX `member_id`(`member_id`) USING BTREE,
  CONSTRAINT `reward_records_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reward_records
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` enum('admin','saler','casher') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'admin');

SET FOREIGN_KEY_CHECKS = 1;

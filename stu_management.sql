/*
 Navicat Premium Data Transfer

 Source Server         : TL_connection
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : stu_management

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 14/06/2020 14:25:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for achievement
-- ----------------------------
DROP TABLE IF EXISTS `achievement`;
CREATE TABLE `achievement`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `count` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`count`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of achievement
-- ----------------------------
INSERT INTO `achievement` VALUES ('36d2c5469d4343189b51180db253de59', '数据结构', '95.5', '2020-05-10 19:59:30', 1);
INSERT INTO `achievement` VALUES ('36d2c5469d4343189b51180db253de59', '离散数学', '87', '2020-05-10 19:59:54', 2);
INSERT INTO `achievement` VALUES ('36d2c5469d4343189b51180db253de59', '计算机导论', '95', '2020-05-11 16:22:53', 3);
INSERT INTO `achievement` VALUES ('2c491eef605b4c2b950c7e20bb253f63', '大学英语一', '76', '2020-05-11 17:11:58', 5);
INSERT INTO `achievement` VALUES ('2c491eef605b4c2b950c7e20bb253f63', '大学英语二', '59', '2020-05-11 17:12:13', 6);
INSERT INTO `achievement` VALUES ('36d2c5469d4343189b51180db253de59', '计算机专业英语', '83', '2020-05-12 13:38:31', 8);
INSERT INTO `achievement` VALUES ('884926d3bc0c4165bc14bb8cab7660ef', 'fwafawfaw', '134212', '2020-05-12 13:40:38', 9);
INSERT INTO `achievement` VALUES ('fa9f45f0087744c2935d2945f50fa8ee', 'afaw1', '11112', '2020-05-13 09:12:55', 10);

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'admin',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '乐歌歌', 'root', 'qqq111', 'admin');

-- ----------------------------
-- Table structure for appendix
-- ----------------------------
DROP TABLE IF EXISTS `appendix`;
CREATE TABLE `appendix`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appendix
-- ----------------------------
INSERT INTO `appendix` VALUES ('36d2c5469d4343189b51180db253de59', 'E:/STS/WorkSpase/SSM-project/WebContent/upload/CoreJava试卷1589280698529.docx', '2020-05-12 18:51:39');
INSERT INTO `appendix` VALUES ('860924840ee44f99b540081a99d8bb1d', 'E:/STS/WorkSpase/SSM-project/WebContent/upload/tl-sendshortmessage1589281076676.jar', '2020-05-12 18:57:57');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '计算机科学与工程学院', '2020-05-10 20:01:24');
INSERT INTO `department` VALUES (2, '外国语学院', '2020-05-11 09:49:10');
INSERT INTO `department` VALUES (3, '经济学院', '2020-05-11 18:10:59');
INSERT INTO `department` VALUES (11, '教育科学学院', '2020-05-13 09:12:42');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `department_id` int(11) NOT NULL,
  `achievement_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `appendix_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'student',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (3, '谭乐', '男', '1700130417', 'qqq111', '15014077321', '1976087502@qq.com', '2020-05-12 12:17:17', 1, '36d2c5469d4343189b51180db253de59', '36d2c5469d4343189b51180db253de59', 'student');
INSERT INTO `student` VALUES (4, '小明', '男', '1234556', '1234556', '15014077333', '123456789@qq.com', '2020-05-11 17:11:40', 2, '2c491eef605b4c2b950c7e20bb253f63', '2c491eef605b4c2b950c7e20bb253f63', 'student');
INSERT INTO `student` VALUES (5, '李华', '男', '1700130433', '1700130433', '2134562', '12345613@qq.com', '2020-05-11 17:39:44', 2, '23a71f332fd447cfbed5206de84ad006', '23a71f332fd447cfbed5206de84ad006', 'student');
INSERT INTO `student` VALUES (10, '李四', '男', '123456', '123456', '12345678910', '13513515@qq.com', '2020-05-12 18:56:26', 1, '17e50c31cc6d459fb1e7441597badd74', '17e50c31cc6d459fb1e7441597badd74', 'student');
INSERT INTO `student` VALUES (11, 'q', '男', 'q', 'q', 'q', 'q', '2020-05-13 09:05:11', 3, '0458cfa79a244aabaa76f8214f4f1631', '0458cfa79a244aabaa76f8214f4f1631', 'student');
INSERT INTO `student` VALUES (13, 'qqw', '男', '1231', '1231', '3312', '123', '2020-05-13 09:10:37', 11, 'fa9f45f0087744c2935d2945f50fa8ee', 'fa9f45f0087744c2935d2945f50fa8ee', 'student');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `appendix_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `department_id` int(11) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'teacher',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (10, '黄老师', '男', '1613', '1613', '15713513513153', '151151531313@qq.com', '860924840ee44f99b540081a99d8bb1d', 1, '2020-05-11 18:35:53', 'teacher');
INSERT INTO `teacher` VALUES (11, '马老师', '男', '1317', '1317', '151561313@qq.com', '151351531@qq.com', '8da865af77fc45c7bdd57a8fe6e24de0', 1, '2020-05-11 18:36:16', 'teacher');

SET FOREIGN_KEY_CHECKS = 1;

/*
Navicat MySQL Data Transfer

Source Server         : me
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : exam_jsp

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-01-05 11:18:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cnum` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `upload` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`cnum`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '毕业设计选题管理', '李老师', null, '2016-12-26');
INSERT INTO `course` VALUES ('2', '课堂考勤管理系统', '黄老师', '1', '2016-10-10');
INSERT INTO `course` VALUES ('3', '劳动课管理系统', '张老师', '2', '2016-10-12');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(255) NOT NULL AUTO_INCREMENT,
  `studentId` varchar(255) DEFAULT NULL,
  `sname` varchar(255) DEFAULT NULL,
  `spwd` varchar(255) DEFAULT NULL,
  `ssex` varchar(255) DEFAULT NULL,
  `specialities` varchar(255) DEFAULT NULL COMMENT '学生专业',
  `college` varchar(255) DEFAULT NULL COMMENT '所属学院',
  `semail` varchar(255) DEFAULT NULL,
  `sphone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `steacher` varchar(255) DEFAULT NULL COMMENT '所属教师',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=2017 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2', '201602', 'sgsd', '123', '男', '16文学', '信电学院', '2341154125@qq.com', '123456678905262', '梧州', '黄老师');
INSERT INTO `student` VALUES ('3', '201603', 'test04', '123', '女', '15电子', '信电学院', '1024@gmail.com', '110', '南宁', '张老师');
INSERT INTO `student` VALUES ('5', '201605', 'test', '123', '女', '15电子', '师范学院', '1025@gmail.com', '423423', '桂林', '张老师');
INSERT INTO `student` VALUES ('6', '2014002', '黎明', '123', '女', '16文学', '文法学院', '1024@gmail.com', '12345667890', '北京', '黄老师');
INSERT INTO `student` VALUES ('7', '2014002', '问题提供', '123', '男', '15电子', '经济管理学院', '1024@gmail.com', '110', '南宁', '张老师');
INSERT INTO `student` VALUES ('8', '201602', 'sgsd', '123', '女, 女', '16文学', '经济管理学院', '2341154125@qq.com', '123456678905262', '梧州', '黄老师');
INSERT INTO `student` VALUES ('2016', '201400208205', '黎明', '123', '女', '15电子', '经济管理学院', '1026@gmail.com', '110', '梧州', '张老师');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` varchar(11) NOT NULL COMMENT '工号',
  `tname` varchar(255) DEFAULT NULL COMMENT '教师姓名',
  `pcourse` varchar(255) DEFAULT NULL COMMENT '发布课题',
  `tpwd` varchar(255) DEFAULT NULL,
  `departments` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '黄老师', '课程设计', '123', '师范学院', '讲师');
INSERT INTO `teacher` VALUES ('2', '王老吉', '数据库设计', '123', '文法学院', '教授');
INSERT INTO `teacher` VALUES ('2016001', '单身狗', '数据库设计', '123', '经济管理学院', '高级教授');
INSERT INTO `teacher` VALUES ('2016002', '王老吉', '数据库设计', '123', '经济管理学院', '高级教授');
INSERT INTO `teacher` VALUES ('2016003', '单身狗', '数据库设计', '123', '经济管理学院', '高级教授');
INSERT INTO `teacher` VALUES ('3', '水电费', '数据库设计', '123', '信电学院', '高级教授');
INSERT INTO `teacher` VALUES ('4', '的说法是公司', 'c++程序设计', '123', '文法学院', '高级教授');
INSERT INTO `teacher` VALUES ('5', '三国杀', 'c语言程序设计', '123', '师范学院', '高级教授');
INSERT INTO `teacher` VALUES ('7', 'sdfsags', '数据库设计', '123', '师范学院', '高级教师');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '111');
INSERT INTO `user` VALUES ('2', 'qq', '123');
INSERT INTO `user` VALUES ('3', 'xiaomi', '123');

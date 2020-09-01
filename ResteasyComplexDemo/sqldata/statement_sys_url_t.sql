/*
Navicat MySQL Data Transfer

Source Server         : 甘肃测试数据库-192.168.20.162
Source Server Version : 50630
Source Host           : 192.168.20.162:3306
Source Database       : statement

Target Server Type    : MYSQL
Target Server Version : 50630
File Encoding         : 65001

Date: 2017-11-13 17:36:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `statement_sys_url_t`
-- ----------------------------
DROP TABLE IF EXISTS `statement_sys_url_t`;
CREATE TABLE `statement_sys_url_t` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(5) NOT NULL COMMENT 'url地址编码',
  `url` varchar(500) NOT NULL,
  `url_desc` varchar(200) NOT NULL COMMENT '地址描述',
  `isuse` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '是否禁用:0禁用1可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of statement_sys_url_t
-- ----------------------------
INSERT INTO `statement_sys_url_t` VALUES ('1', 'lcmsg', 'http://221.130.6.212:2688/classSpace/app/xkapi/sendMessageCount', '教师短信量统计数据上传地址', '1');
INSERT INTO `statement_sys_url_t` VALUES ('2', 'apia', 'http://192.168.20.154:70/TSB_ISCHOOL2_EXTERNAL_API/xkexternalimport/getCurrentProvince', '接口返回本平台所属省级编码', '1');
INSERT INTO `statement_sys_url_t` VALUES ('3', 'apib', 'http://192.168.20.154:70/TSB_ISCHOOL2_EXTERNAL_API/xkexternalimport/addschoolInfo', '创建学校', '1');
INSERT INTO `statement_sys_url_t` VALUES ('4', 'apic', 'http://192.168.20.154:70/TSB_ISCHOOL2_EXTERNAL_API/xkexternalimport/addClassInfo', '创建班级', '1');
INSERT INTO `statement_sys_url_t` VALUES ('5', 'apid', 'http://192.168.20.154:70/TSB_ISCHOOL2_EXTERNAL_API/xkexternalimport/addteachersInfo', '导入教师', '1');
INSERT INTO `statement_sys_url_t` VALUES ('6', 'apie', 'http://192.168.20.154:70/TSB_ISCHOOL2_EXTERNAL_API/xkexternalimport/addParentAndStudentINFO', '导入学生家长', '1');
INSERT INTO `statement_sys_url_t` VALUES ('7', 'apif', 'http://192.168.20.154:70/TSB_ISCHOOL2_EXTERNAL_API/xkexternalimport/orderUnsubscribe', '订购、退订', '1');
INSERT INTO `statement_sys_url_t` VALUES ('8', 'apig', 'http://192.168.20.154:70/TSB_ISCHOOL2_EXTERNAL_API/xkexternalimport/addTeacher', '导入教师(盐城)', '1');
INSERT INTO `statement_sys_url_t` VALUES ('9', 'apih', 'http://localhost:8888/TSB_ISCHOOL2_EXTERNAL_API/xkexternalimport/addParentAndStudentINFO', '导入家长（江苏）', '1');

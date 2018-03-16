/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306 10.0.10.195
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : statement

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-03-16 17:45:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for statement_sys_menu_t
-- ----------------------------
DROP TABLE IF EXISTS `statement_sys_menu_t`;
CREATE TABLE `statement_sys_menu_t` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_code` varchar(20) NOT NULL COMMENT '菜单编码',
  `menu_name` varchar(20) NOT NULL COMMENT '菜单显示的名字',
  `menu_parent` varchar(20) NOT NULL DEFAULT '0' COMMENT '父级菜单的编码，顶级为0',
  `menu_url` varchar(100) NOT NULL COMMENT '菜单的相对路径',
  `menu_images` varchar(100) NOT NULL DEFAULT '0' COMMENT '只有顶级菜单有图标，有图标的写地址没有的默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='业支平台功能菜单表';

-- ----------------------------
-- Records of statement_sys_menu_t
-- ----------------------------
INSERT INTO `statement_sys_menu_t` VALUES ('1', 'yhxxgl', '用户信息管理', '0', '0', 'icon-user');
INSERT INTO `statement_sys_menu_t` VALUES ('2', 'sjtjbb', '数据统计报表', '0', '0', 'icon-bar-chart');
INSERT INTO `statement_sys_menu_t` VALUES ('3', 'yhglxt', '用户系统管理', '0', '0', 'icon-cog');
INSERT INTO `statement_sys_menu_t` VALUES ('4', 'yhzlxg', '用户资料修改', 'yhxxgl', '/webpage/pages/xkuser/xkUser.html', '0');

-- ----------------------------
-- Table structure for statement_sys_role_menu_t
-- ----------------------------
DROP TABLE IF EXISTS `statement_sys_role_menu_t`;
CREATE TABLE `statement_sys_role_menu_t` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(10) unsigned NOT NULL COMMENT '角色id',
  `menu_id` int(10) unsigned NOT NULL COMMENT '菜单id',
  `creater` varchar(32) DEFAULT NULL COMMENT '创建者',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updator` varchar(32) DEFAULT NULL COMMENT '修改者',
  `updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

-- ----------------------------
-- Records of statement_sys_role_menu_t
-- ----------------------------
INSERT INTO `statement_sys_role_menu_t` VALUES ('1', '8', '1', null, '2018-03-16 15:08:11', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_role_menu_t` VALUES ('2', '8', '2', null, '2018-03-16 15:09:30', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_role_menu_t` VALUES ('3', '8', '3', null, '2018-03-16 15:09:38', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_role_menu_t` VALUES ('4', '8', '4', null, '2018-03-16 15:09:44', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_role_menu_t` VALUES ('5', '7', '1', null, '2018-03-16 15:10:49', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_role_menu_t` VALUES ('6', '7', '2', null, '2018-03-16 15:10:54', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_role_menu_t` VALUES ('7', '6', '1', null, '2018-03-16 15:11:00', null, '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for statement_sys_role_t
-- ----------------------------
DROP TABLE IF EXISTS `statement_sys_role_t`;
CREATE TABLE `statement_sys_role_t` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_code` varchar(10) DEFAULT NULL COMMENT '角色编码',
  `role_name` varchar(20) NOT NULL COMMENT '角色名称',
  `role_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '角色类型，1：系统角色；2：自定义角色',
  `creater` varchar(32) DEFAULT NULL COMMENT '创建者',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updator` varchar(32) DEFAULT NULL COMMENT '修改者',
  `updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='分系统和业务角色';

-- ----------------------------
-- Records of statement_sys_role_t
-- ----------------------------
INSERT INTO `statement_sys_role_t` VALUES ('1', '100', 'VP1', '2', null, '2018-03-16 14:56:31', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_role_t` VALUES ('2', '200', 'VP2', '2', null, '2018-03-16 14:56:50', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_role_t` VALUES ('3', '300', 'VP_TOP', '2', null, '2018-03-16 14:57:07', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_role_t` VALUES ('4', '400', '会员', '2', null, '2018-03-16 14:57:28', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_role_t` VALUES ('5', '500', '白金会员', '2', null, '2018-03-16 14:57:44', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_role_t` VALUES ('6', '600', '黄金会员', '2', null, '2018-03-16 14:58:01', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_role_t` VALUES ('7', '700', '钻石会员', '2', null, '2018-03-16 14:58:19', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_role_t` VALUES ('8', '-100', '系统管理员', '1', null, '2018-03-16 14:59:06', null, '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for statement_sys_url_t
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

-- ----------------------------
-- Table structure for statement_sys_user_audit_t
-- ----------------------------
DROP TABLE IF EXISTS `statement_sys_user_audit_t`;
CREATE TABLE `statement_sys_user_audit_t` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(32) NOT NULL,
  `operation_type` varchar(50) NOT NULL,
  `operation_content` varchar(200) NOT NULL,
  `operation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=626 DEFAULT CHARSET=utf8 COMMENT='业支平台用户操作日志表';

-- ----------------------------
-- Records of statement_sys_user_audit_t
-- ----------------------------

-- ----------------------------
-- Table structure for statement_sys_user_role_t
-- ----------------------------
DROP TABLE IF EXISTS `statement_sys_user_role_t`;
CREATE TABLE `statement_sys_user_role_t` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户id',
  `role_id` int(10) unsigned NOT NULL COMMENT '角色id',
  `creater` varchar(32) DEFAULT NULL COMMENT '创建者',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updator` varchar(32) DEFAULT NULL COMMENT '修改者',
  `updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of statement_sys_user_role_t
-- ----------------------------
INSERT INTO `statement_sys_user_role_t` VALUES ('1', '7', '8', null, '2018-03-16 15:13:57', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_user_role_t` VALUES ('2', '8', '7', null, '2018-03-16 15:14:13', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_user_role_t` VALUES ('3', '9', '6', null, '2018-03-16 15:14:45', null, '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for statement_sys_user_t
-- ----------------------------
DROP TABLE IF EXISTS `statement_sys_user_t`;
CREATE TABLE `statement_sys_user_t` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_name` varchar(20) NOT NULL COMMENT '登录名',
  `login_pass` varchar(32) NOT NULL COMMENT '登录密码MD5存储',
  `full_name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '性别：1:男；0:女',
  `creater` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updator` varchar(32) DEFAULT NULL COMMENT '修改人',
  `updatet_ime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of statement_sys_user_t
-- ----------------------------
INSERT INTO `statement_sys_user_t` VALUES ('7', '1', 'c4ca4238a0b923820dcc509a6f75849b', '李生波', '0', null, '2018-03-14 08:58:11', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_user_t` VALUES ('8', '2', 'c4ca4238a0b923820dcc509a6f75849b', '李生', '0', null, '2018-03-16 15:12:27', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_user_t` VALUES ('9', '3', 'c4ca4238a0b923820dcc509a6f75849b', '李昌', '0', null, '2018-03-16 15:12:40', null, '0000-00-00 00:00:00');
INSERT INTO `statement_sys_user_t` VALUES ('91', '4', 'c4ca4238a0b923820dcc509a6f75849b', '李海', '0', null, '2018-03-16 15:12:50', null, '0000-00-00 00:00:00');



-- 基础用户表====

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;



--
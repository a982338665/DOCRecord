

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


show CREATE TABLE statement_sys_role_t;
show CREATE TABLE statement_sys_role_menu_t;
show CREATE TABLE statement_sys_menu_t;
show CREATE TABLE statement_sys_user_role_t;
show CREATE TABLE statement_sys_url_t;
show CREATE TABLE statement_sys_user_audit_t;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分系统和业务角色';

CREATE TABLE `statement_sys_role_menu_t` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(10) unsigned NOT NULL COMMENT '角色id',
  `menu_id` int(10) unsigned NOT NULL COMMENT '菜单id',
  `creater` varchar(32) DEFAULT NULL COMMENT '创建者',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updator` varchar(32) DEFAULT NULL COMMENT '修改者',
  `updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

CREATE TABLE `statement_sys_menu_t` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_code` varchar(20) NOT NULL COMMENT '菜单编码',
  `menu_name` varchar(20) NOT NULL COMMENT '菜单显示的名字',
  `menu_parent` varchar(20) NOT NULL DEFAULT '0' COMMENT '父级菜单的编码，顶级为0',
  `menu_url` varchar(100) NOT NULL COMMENT '菜单的相对路径',
  `menu_images` varchar(100) NOT NULL DEFAULT '0' COMMENT '只有顶级菜单有图标，有图标的写地址没有的默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='业支平台功能菜单表';

CREATE TABLE `statement_sys_user_role_t` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户id',
  `role_id` int(10) unsigned NOT NULL COMMENT '角色id',
  `creater` varchar(32) DEFAULT NULL COMMENT '创建者',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updator` varchar(32) DEFAULT NULL COMMENT '修改者',
  `updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

CREATE TABLE `statement_sys_url_t` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(5) NOT NULL COMMENT 'url地址编码',
  `url` varchar(500) NOT NULL,
  `url_desc` varchar(200) NOT NULL COMMENT '地址描述',
  `isuse` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '是否禁用:0禁用1可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `statement_sys_user_audit_t` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(32) NOT NULL,
  `operation_type` varchar(50) NOT NULL,
  `operation_content` varchar(200) NOT NULL,
  `operation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=626 DEFAULT CHARSET=utf8 COMMENT='业支平台用户操作日志表';




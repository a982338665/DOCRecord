-- 数据库初始化脚本

-- 创建数据库
create database customrelation;

-- 使用数据库
use customrelation;

-- 创建用户基本信息表
CREATE TABLE t_u_user(
  sid INT NOT NULL  AUTO_INCREMENT COMMENT   '主键id',
  c_loginname VARCHAR(15) NOT NULL  COMMENT  '登录名',
  c_loginpass VARCHAR(15) NOT NULL  COMMENT  '登录密码',
  c_name      VARCHAR(15) NOT NULL  COMMENT  '真实姓名',
  c_age       TINYINT NOT NULL  COMMENT      '真实年龄',
  c_sex       TINYINT NOT NULL DEFAULT 1 COMMENT      '性别:0女 1男',
  c_isuse       TINYINT NOT NULL DEFAULT 1 COMMENT  '是否禁用：1启用，0禁用',
  c_creater        VARCHAR(15) NOT NULL DEFAULT 'system' COMMENT  '创建人',
  c_createtime TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  c_desc      VARCHAR(200)   COMMENT '用户描述',
  PRIMARY KEY(sid),
  KEY idx_validlogin(c_loginname),
  KEY idx_login(c_loginname,c_loginpass),
  KEY idx_sex(c_sex),
  key idx_create_time(c_createtime)
)Engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET =utf8 COMMENT ='用户基础信息表';

-- 初始化数据
insert into t_u_user(c_loginname, c_loginpass, c_name, c_age, c_creater) VALUES
  ('lishengbo','qazwsx123','李生波',25,'system'),
  ('xuesheng','111111','李生龙',28,'system'),
  ('teacher','888888','李生虎',15,'system'),
  ('family','qazwsx123','李生波',25,'system');

-- 创建角色限定表
CREATE TABLE t_u_role(
  sid INT NOT NULL  AUTO_INCREMENT COMMENT   '主键id-角色id',
  c_rolename VARCHAR(15) NOT NULL  COMMENT   '角色名称',
  c_roledesc VARCHAR(15) NOT NULL  COMMENT   '角色描述',
  c_creater        VARCHAR(15) NOT NULL DEFAULT 'system' COMMENT  '创建人',
  c_updater       TINYINT   COMMENT  '修改人',
  c_isuse       TINYINT NOT NULL DEFAULT 1 COMMENT  '是否禁用：1启用，0禁用',
  c_createtime TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  c_updatetime TIMESTAMP  DEFAULT current_timestamp COMMENT '修改时间',
  PRIMARY KEY(sid),
  KEY idx_sid(sid),
  key idx_create_time(c_createtime)
)Engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET =utf8 COMMENT ='角色基础信息表';

-- 初始化数据
INSERT INTO t_u_role(c_rolename, c_roledesc, c_creater) VALUES
  ('system','系统管理员','system'),
  ('CEO','公司法人','system'),
  ('CTO','公司总裁','system'),
  ('manager','经理','CTO'),
  ('worker','公司职员','manager')
  ;

-- 用户角色关联表
CREATE TABLE t_r_user_role(
  sid INT NOT NULL  AUTO_INCREMENT COMMENT   '主键id',
  c_userid INT NOT NULL  COMMENT   '用户id',
  c_roleid INT NOT NULL  COMMENT   '角色id',
  c_creater        VARCHAR(15) NOT NULL DEFAULT 'system' COMMENT  '创建人',
  c_updater       TINYINT   COMMENT  '修改人',
  c_isuse       TINYINT NOT NULL DEFAULT 1 COMMENT  '是否禁用：1启用，0禁用',
  c_createtime TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  c_updatetime TIMESTAMP  DEFAULT current_timestamp COMMENT '修改时间',
  PRIMARY KEY(sid),
  KEY idx_sid(sid),
  KEY idx_c_userid(c_userid),
  KEY idx_c_roleid(c_roleid),
  key idx_create_time(c_createtime)
)Engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET =utf8 COMMENT ='用户角色关联表';

-- 初始化数据
INSERT INTO t_r_user_role (c_userid, c_roleid)VALUES
  (1,1),
  (2,2),
  (3,3),
  (4,4);

-- 菜单定义表
CREATE TABLE t_u_menu (
  `sid` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `c_menu_code` varchar(20) NOT NULL COMMENT '菜单编码',
  `c_menu_name` varchar(20) NOT NULL COMMENT '菜单显示的名字',
  `c_menu_parent` varchar(20) NOT NULL DEFAULT '0' COMMENT '父级菜单的编码，顶级为0',
  `c_menu_url` varchar(100) NOT NULL COMMENT '菜单的相对路径',
  `c_menu_images` varchar(100) NOT NULL DEFAULT '0' COMMENT '只有顶级菜单有图标，有图标的写地址没有的默认为0',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='平台功能菜单表'


-- 角色菜单配置关联表
-- 用户角色关联表
CREATE TABLE t_r_menu_role(
  sid INT NOT NULL  AUTO_INCREMENT COMMENT   '主键id',
  c_menu_code INT NOT NULL  COMMENT   '菜单id',
  c_roleid INT NOT NULL  COMMENT   '角色id',
  c_createtime TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  PRIMARY KEY(sid),
  KEY idx_sid(sid),
  KEY idx_c_userid(c_menu_code),
  KEY idx_c_roleid(c_roleid),
  key idx_create_time(c_createtime)
)Engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET =utf8 COMMENT ='菜单角色关联表';
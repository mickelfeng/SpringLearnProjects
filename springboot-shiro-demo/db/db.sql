CREATE DATABASE shiro_demo;
USE shiro_demo;
-- 用户表
CREATE TABLE t_user (
  id BIGINT(16) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  PRIMARY KEY(id)
);

-- 用户token表
CREATE TABLE t_user_token (
  id BIGINT(16) NOT NULL AUTO_INCREMENT,
  user_id BIGINT(16) NOT NULL,
  token VARCHAR(1024) NOT NULL,
  PRIMARY KEY(id)
);

-- 用户角色表
CREATE TABLE t_role (
  id BIGINT(16) NOT NULL AUTO_INCREMENT,
  `permission` VARCHAR(4096) DEFAULT NULL,
  `name` VARCHAR(128) NOT NULL,
  PRIMARY KEY(id)
);

-- 用户角色关联表
CREATE TABLE t_user_role (
  id BIGINT(16) NOT NULL AUTO_INCREMENT,
  user_id BIGINT(16) NOT NULL,
  role_id BIGINT(16) NOT NULL,
  PRIMARY KEY(id)
);


/*
 Navicat Premium Data Transfer

 Source Server         : mysql.ark.com
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : mysql.ark.com:3308
 Source Schema         : ark

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 21/11/2022 22:31:24
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ark_identify_account
-- ----------------------------
DROP TABLE IF EXISTS `ark_identify_account`;
CREATE TABLE `ark_identify_account`
(
    `id`             bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
    `account_status` tinyint(0) NULL DEFAULT NULL COMMENT '账户状态',
    `user_name`      varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
    `password`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码密文',
    `phone_number`   varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
    `creater`        bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '创建人',
    `create_time`    datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `modifier`       bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '修改人',
    `modify_time`    datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
    `is_deleted`     tinyint(0) UNSIGNED NULL DEFAULT NULL COMMENT '删除标志',
    `version`        bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '版本号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ark_identify_department
-- ----------------------------
DROP TABLE IF EXISTS `ark_identify_department`;
CREATE TABLE `ark_identify_department`
(
    `id`                   bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
    `tenant_id`            bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户id',
    `department_id`        int(0) NULL DEFAULT NULL COMMENT '部门id',
    `department_name`      varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
    `department_index`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门索引',
    `department_parent_id` int(0) NULL DEFAULT NULL COMMENT '父部门id',
    `creater`              bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '创建人',
    `create_time`          datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `modifier`             bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '修改人',
    `modify_time`          datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
    `is_deleted`           tinyint(0) UNSIGNED NULL DEFAULT NULL COMMENT '删除标志',
    `version`              bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '版本号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ark_identify_tenant
-- ----------------------------
DROP TABLE IF EXISTS `ark_identify_tenant`;
CREATE TABLE `ark_identify_tenant`
(
    `id`            bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
    `tenant_name`   varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '租户名称',
    `tenant_status` tinyint(0) NULL DEFAULT NULL COMMENT '租户状态',
    `creater`       bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '创建人',
    `create_time`   datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `modifier`      bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '修改人',
    `modify_time`   datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
    `is_deleted`    tinyint(0) UNSIGNED NULL DEFAULT NULL COMMENT '删除标志',
    `version`       bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '版本号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ark_identify_unique_user
-- ----------------------------
DROP TABLE IF EXISTS `ark_identify_unique_user`;
CREATE TABLE `ark_identify_unique_user`
(
    `id`            bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
    `tenant_id`     bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户id',
    `account_id`    bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '账户id',
    `department_id` int(0) NULL DEFAULT NULL COMMENT '部门id',
    `creater`       bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '创建人',
    `create_time`   datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `modifier`      bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '修改人',
    `modify_time`   datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
    `is_deleted`    tinyint(0) UNSIGNED NULL DEFAULT NULL COMMENT '删除标志',
    `version`       bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '版本号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '唯一用户表，表明账户和租户的关系' ROW_FORMAT = Dynamic;

SET
FOREIGN_KEY_CHECKS = 1;

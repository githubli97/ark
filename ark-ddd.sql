/*
 Navicat Premium Data Transfer

 Source Server         : mysql.ark.com
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : mysql.ark.com:3308
 Source Schema         : ark-ddd

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 07/04/2023 16:40:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ark_identify_account
-- ----------------------------
DROP TABLE IF EXISTS `ark_identify_account`;
CREATE TABLE `ark_identify_account`  (
  `id` bigint(0) NOT NULL,
  `CREATOR` bigint(0) NOT NULL,
  `MODIFIER` bigint(0) NOT NULL,
  `CREATED_TIME` datetime(0) NOT NULL,
  `MODIFIED_TIME` datetime(0) NOT NULL,
  `IS_DELETED` tinyint(0) NOT NULL,
  `VERSION` bigint(0) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `account_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` bigint(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ark_identify_organization
-- ----------------------------
DROP TABLE IF EXISTS `ark_identify_organization`;
CREATE TABLE `ark_identify_organization`  (
  `id` bigint(0) NOT NULL,
  `CREATOR` bigint(0) NOT NULL,
  `MODIFIER` bigint(0) NOT NULL,
  `CREATED_TIME` datetime(0) NOT NULL,
  `MODIFIED_TIME` datetime(0) NOT NULL,
  `IS_DELETED` tinyint(0) NOT NULL,
  `VERSION` bigint(0) NOT NULL,
  `tenant_id` bigint(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `responsible_user_id` bigint(0) NULL DEFAULT NULL,
  `parent_id` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ark_identify_tenant
-- ----------------------------
DROP TABLE IF EXISTS `ark_identify_tenant`;
CREATE TABLE `ark_identify_tenant`  (
  `id` bigint(0) NOT NULL,
  `CREATOR` bigint(0) NOT NULL,
  `MODIFIER` bigint(0) NOT NULL,
  `CREATED_TIME` datetime(0) NOT NULL,
  `MODIFIED_TIME` datetime(0) NOT NULL,
  `IS_DELETED` tinyint(0) NOT NULL,
  `VERSION` bigint(0) NOT NULL,
  `NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ark_identify_user
-- ----------------------------
DROP TABLE IF EXISTS `ark_identify_user`;
CREATE TABLE `ark_identify_user`  (
  `id` bigint(0) NOT NULL,
  `CREATOR` bigint(0) NOT NULL,
  `MODIFIER` bigint(0) NOT NULL,
  `CREATED_TIME` datetime(0) NOT NULL,
  `MODIFIED_TIME` datetime(0) NOT NULL,
  `IS_DELETED` tinyint(0) NOT NULL,
  `VERSION` bigint(0) NOT NULL,
  `tenant_id` bigint(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `organization_id` bigint(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

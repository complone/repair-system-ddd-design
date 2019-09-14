/*
 Navicat Premium Data Transfer

 Source Server         : sym
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : guide

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 28/11/2018 13:11:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lz_md_editor
-- ----------------------------
DROP TABLE IF EXISTS `lz_md_editor`;
CREATE TABLE `lz_md_editor`  (
  `editor_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '本次编辑记录id',
  `editor_document_id` bigint(20) NULL DEFAULT NULL COMMENT '面向所编辑的文档id',
  `editor_document_markdown` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '编辑器显示的markdown文本',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`editor_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lz_md_editor
-- ----------------------------
INSERT INTO `lz_md_editor` VALUES (1, 3, '### Hello Editor.md !\r\n - fgdfg\r\n - ghfghgfh', '2018-11-26 14:33:10', '2018-11-26 14:33:12');
INSERT INTO `lz_md_editor` VALUES (2, 7, ' - fghghghg\n - fggfhfghgh\n - fghgfhgfh\n - gfhfghgh', '2018-11-26 19:05:25', '2018-11-26 19:05:25');
INSERT INTO `lz_md_editor` VALUES (3, 6, 'Welcome to Editor Document', NULL, NULL);
INSERT INTO `lz_md_editor` VALUES (4, 8, 'Welcome to Editor Document', NULL, NULL);
INSERT INTO `lz_md_editor` VALUES (5, 10, 'Welcome to Editor Document', NULL, NULL);
INSERT INTO `lz_md_editor` VALUES (6, 4, '- hfghfghffhfg\n- fghfghfghfg\n- fghgfhgfhfg', '2018-11-28 12:55:30', '2018-11-28 12:55:30');

-- ----------------------------
-- Table structure for lz_project_bug_commit
-- ----------------------------
DROP TABLE IF EXISTS `lz_project_bug_commit`;
CREATE TABLE `lz_project_bug_commit`  (
  `bug_commit_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '本次提交bug的id',
  `bug_commit_team_project_id` bigint(20) NULL DEFAULT NULL COMMENT 'bug提交对应的项目id',
  `bug_commit_reason` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'bug提交的原因',
  `bug_commit_info` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次提交时间',
  PRIMARY KEY (`bug_commit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lz_project_bug_commit
-- ----------------------------
INSERT INTO `lz_project_bug_commit` VALUES (1, 2, 'dc告警', '在dc中发生错误', '2018-11-13 11:52:44', '2018-11-27 11:52:47');
INSERT INTO `lz_project_bug_commit` VALUES (2, 2, '链接超时', '造成多个服务无法启动', '2018-11-27 11:53:25', '2018-11-27 11:53:27');
INSERT INTO `lz_project_bug_commit` VALUES (3, 2, 'dc错误', '错误原因不明', '2018-10-31 12:01:44', '2018-11-27 12:01:48');
INSERT INTO `lz_project_bug_commit` VALUES (4, 12, 'dc告警', '在dc中发生错误', '2018-11-27 16:59:33', NULL);

-- ----------------------------
-- Table structure for lz_project_document
-- ----------------------------
DROP TABLE IF EXISTS `lz_project_document`;
CREATE TABLE `lz_project_document`  (
  `document_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文档id',
  `document_content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文档编辑内容',
  `document_view_id` int(11) NULL DEFAULT NULL COMMENT '切换项目右上方的nav，对应document-respo-demo视图',
  `document_team_project_id` bigint(20) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`document_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lz_project_document
-- ----------------------------
INSERT INTO `lz_project_document` VALUES (1, '<p><li></li></p>', 2, 2, '2018-11-26 14:38:09', '2018-11-26 14:38:09');
INSERT INTO `lz_project_document` VALUES (2, '<p><li>欢阅文档内容</li></p>', 1, 12, '2018-11-25 13:01:11', '2018-11-26 10:33:04');
INSERT INTO `lz_project_document` VALUES (3, '<h3 id=\"h3-hello-editor-md-\"><a name=\"Hello Editor.md !\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Hello Editor.md !</h3><ul>\n<li>dfgdgdfgf</li><li>dfgdfgdfgd</li></ul>\n', 1, 13, '2018-11-26 10:21:52', '2018-11-26 10:50:55');
INSERT INTO `lz_project_document` VALUES (4, '<ul>\n<li>hfghfghffhfg</li><li>fghfghfghfg</li><li>fghgfhgfhfg</li></ul>\n', 2, 13, '2018-11-28 12:55:30', '2018-11-28 12:55:30');
INSERT INTO `lz_project_document` VALUES (5, 'Welcome editor project document', 3, 13, NULL, '2018-11-25 10:04:25');
INSERT INTO `lz_project_document` VALUES (6, 'Welcome editor project document', 1, 16, NULL, '2018-11-26 11:41:12');
INSERT INTO `lz_project_document` VALUES (7, '<ul>\n<li>fghghghg</li><li>fggfhfghgh</li><li>fghgfhgfh</li><li>gfhfghgh</li></ul>\n', 1, 17, '2018-11-26 18:03:21', '2018-11-26 19:05:25');
INSERT INTO `lz_project_document` VALUES (8, 'Welcome editor project document', 1, 1, NULL, '2018-11-26 17:44:42');
INSERT INTO `lz_project_document` VALUES (9, 'Welcome editor project document', 3, 17, NULL, '2018-11-27 15:59:29');
INSERT INTO `lz_project_document` VALUES (10, 'Welcome editor project document', 1, 19, NULL, '2018-11-28 10:25:32');
INSERT INTO `lz_project_document` VALUES (11, 'Welcome editor project document', 2, 17, NULL, '2018-11-28 13:02:58');
INSERT INTO `lz_project_document` VALUES (12, 'Welcome editor project document', 2, 19, NULL, '2018-11-28 13:07:09');
INSERT INTO `lz_project_document` VALUES (13, 'Welcome editor project document', 3, 19, NULL, '2018-11-28 13:07:11');

-- ----------------------------
-- Table structure for lz_project_record
-- ----------------------------
DROP TABLE IF EXISTS `lz_project_record`;
CREATE TABLE `lz_project_record`  (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目代码提交id',
  `record_team_project_id` bigint(20) NOT NULL COMMENT '项目id',
  `record_commit_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '此次发布的提交人名称',
  `record_commit_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '此次发布的提交信息',
  `record_commit_version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '此次发布的版本',
  `record_create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '本次发布的时间',
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lz_project_record
-- ----------------------------
INSERT INTO `lz_project_record` VALUES (1, 12, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (2, 13, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (3, 13, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (4, 13, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (5, 13, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (6, 13, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (7, 13, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (8, 13, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (9, 13, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (10, 13, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (11, 13, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (12, 13, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (13, 17, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (14, 17, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (15, 17, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (16, 13, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (17, 17, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (18, 17, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (19, 17, NULL, NULL, NULL, NULL);
INSERT INTO `lz_project_record` VALUES (20, 19, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for lz_role
-- ----------------------------
DROP TABLE IF EXISTS `lz_role`;
CREATE TABLE `lz_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色类型名',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lz_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `lz_role_permission`;
CREATE TABLE `lz_role_permission`  (
  `role_permission_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限关系id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`role_permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lz_team_info
-- ----------------------------
DROP TABLE IF EXISTS `lz_team_info`;
CREATE TABLE `lz_team_info`  (
  `team_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `team_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`team_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lz_team_info
-- ----------------------------
INSERT INTO `lz_team_info` VALUES (1, '基础研发部', '2018-11-06 10:01:16', '2018-11-21 10:01:21');
INSERT INTO `lz_team_info` VALUES (2, '直播业务组', '2018-11-23 10:01:41', '2018-11-23 10:01:46');
INSERT INTO `lz_team_info` VALUES (3, '点播业务组', '2018-11-23 10:01:58', '2018-11-23 10:02:01');

-- ----------------------------
-- Table structure for lz_team_project_info
-- ----------------------------
DROP TABLE IF EXISTS `lz_team_project_info`;
CREATE TABLE `lz_team_project_info`  (
  `team_project_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目id',
  `team_id` int(11) NOT NULL COMMENT '项目对应的部门id',
  `team_project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `team_project_charge` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目负责人',
  `team_project_descrption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目列表中项目的描述',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `team_project_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目gitlab地址',
  PRIMARY KEY (`team_project_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lz_team_project_info
-- ----------------------------
INSERT INTO `lz_team_project_info` VALUES (1, 1, 'lz_common_service', '张三', '这是一个人声上传的服务', '2018-11-23 10:04:34', '2018-11-23 10:04:36', 'http://www.baidu.com');
INSERT INTO `lz_team_project_info` VALUES (2, 1, 'lz_human_common_service', '李四', '人声上传dc层', '2018-11-23 10:04:39', '2018-11-23 10:04:42', 'http://www.baidu.com');
INSERT INTO `lz_team_project_info` VALUES (3, 2, 'lz_voice_service', '王五', '声音服务', '2018-11-23 10:04:45', '2018-11-23 10:04:47', 'http://www.baidu.com');
INSERT INTO `lz_team_project_info` VALUES (11, 2, 'activeMq', 'zhangsan', NULL, NULL, NULL, 'http://www.baidu.com');
INSERT INTO `lz_team_project_info` VALUES (12, 3, 'activeMq', 'zhangsan', 'cvbcvbv', NULL, NULL, 'http://www.baidu.com');
INSERT INTO `lz_team_project_info` VALUES (13, 1, 'chengxu', 'chengxu', NULL, NULL, NULL, 'http://www.baidu.com');
INSERT INTO `lz_team_project_info` VALUES (14, 1, 'chengxu', 'chengxu', '', NULL, NULL, 'http://www.baidu.com');
INSERT INTO `lz_team_project_info` VALUES (15, 3, 'activeMq', 'zhangsan', NULL, NULL, NULL, 'http://www.baidu.com');
INSERT INTO `lz_team_project_info` VALUES (16, 1, 'hfghfghhfgh', NULL, NULL, NULL, NULL, 'http://www.baidu.com');
INSERT INTO `lz_team_project_info` VALUES (17, 1, 'fhdfhdfhdf', 'dhdfhdfh', NULL, NULL, NULL, 'http://www.baidu.com');
INSERT INTO `lz_team_project_info` VALUES (18, 1, 'vhjghjgjgfj', NULL, 'jghjhjgh', '2018-11-28 10:04:58', '2018-11-28 10:04:58', NULL);
INSERT INTO `lz_team_project_info` VALUES (19, 1, 'argfhhfhgfh', NULL, 'fdgdfgd', '2018-11-28 10:05:30', '2018-11-28 10:05:30', NULL);

-- ----------------------------
-- Table structure for lz_user
-- ----------------------------
DROP TABLE IF EXISTS `lz_user`;
CREATE TABLE `lz_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lz_user_role
-- ----------------------------
DROP TABLE IF EXISTS `lz_user_role`;
CREATE TABLE `lz_user_role`  (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色关系id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

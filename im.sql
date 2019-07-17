/*
Navicat MySQL Data Transfer

Source Server         : p52-docker
Source Server Version : 100314
Source Host           : 192.168.56.101:3306
Source Database       : im

Target Server Type    : MYSQL
Target Server Version : 100314
File Encoding         : 65001

Date: 2019-07-18 00:28:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `friend_id` int(11) DEFAULT NULL COMMENT '好友id',
  `friend_group_id` int(11) DEFAULT NULL COMMENT '好友所在组',
  `create_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='好友表';

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('23', '1', '2', '1', '2019-07-17 08:04:55', '2019-07-17 08:05:31');
INSERT INTO `friend` VALUES ('24', '1', '3', '2', '2019-07-17 08:06:46', '0000-00-00 00:00:00');
INSERT INTO `friend` VALUES ('25', '1', '4', '3', '2019-07-17 08:06:53', '0000-00-00 00:00:00');
INSERT INTO `friend` VALUES ('26', '1', '5', '1', '2019-07-17 11:02:59', '0000-00-00 00:00:00');
INSERT INTO `friend` VALUES ('27', '2', '5', '4', '2019-07-17 12:49:03', '2019-07-17 12:49:27');
INSERT INTO `friend` VALUES ('28', '2', '1', '5', '2019-07-17 12:50:32', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for friend_group
-- ----------------------------
DROP TABLE IF EXISTS `friend_group`;
CREATE TABLE `friend_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `group_name` varchar(255) DEFAULT NULL COMMENT '分组名',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `is_default` int(11) DEFAULT 0 COMMENT '是否为默认分组：1为默认，0为不是默认分组',
  `create_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='好友分组';

-- ----------------------------
-- Records of friend_group
-- ----------------------------
INSERT INTO `friend_group` VALUES ('1', '大佬', '1', '0', '2019-07-17 08:06:03', '0000-00-00 00:00:00');
INSERT INTO `friend_group` VALUES ('2', '过气女优', '1', '0', '2019-07-17 08:06:15', '2019-07-17 11:00:52');
INSERT INTO `friend_group` VALUES ('3', '当红演员', '1', '0', '2019-07-17 08:06:31', '0000-00-00 00:00:00');
INSERT INTO `friend_group` VALUES ('4', '弟弟们', '2', '0', '2019-07-17 12:49:46', '0000-00-00 00:00:00');
INSERT INTO `friend_group` VALUES ('5', '有为青年', '2', '0', '2019-07-17 12:50:21', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_name` varchar(255) DEFAULT NULL COMMENT '帐号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `status` int(11) DEFAULT 0 COMMENT '线上状态 0离线 1在线 2隐身',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `gender` int(11) DEFAULT 0 COMMENT '性别：0为女，1为男',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `sign` varchar(255) DEFAULT NULL COMMENT '个性签名',
  `create_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'licai', null, '1', '李猜', '1', 'https://tva2.sinaimg.cn/crop.0.0.180.180.180/81398ca6jw1e8qgp5bmzyj2050050aa8.jpg', null, null, '不当键盘侠', '2019-07-17 07:57:11', '2019-07-17 10:36:01');
INSERT INTO `user` VALUES ('2', '马', null, '2', '马云', '1', 'http://tp4.sinaimg.cn/2145291155/180/5601307179/1', null, null, '让天下没有难做的生意', '2019-07-17 07:57:17', '2019-07-17 10:36:01');
INSERT INTO `user` VALUES ('3', '武藤兰', null, '0', '武藤兰', '0', 'https://tva1.sinaimg.cn/crop.0.0.511.511.180/86915470jw8eyrpdy4u0rj20e80e7wev.jpg', null, null, '退休中', '2019-07-17 07:58:23', '2019-07-17 10:36:01');
INSERT INTO `user` VALUES ('4', '新垣结衣', null, '1', '新垣结衣', '0', 'https://wx1.sinaimg.cn/thumb150/bd8849b6gy1g49bopibr2j20fk0ad76u.jpg', null, null, '请多多指教', '2019-07-17 08:02:17', '2019-07-17 10:36:01');
INSERT INTO `user` VALUES ('5', 'm', null, '0', '马化腾', '0', 'https://tvax1.sinaimg.cn/crop.0.0.1125.1125.180/6e0eaf15ly8frambt8hilj20v90v9gox.jpg', null, null, '你需要充值解决问题', '2019-07-17 11:01:23', '2019-07-17 11:02:50');

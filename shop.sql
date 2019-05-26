/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-05-23 10:45:55
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`
(
    `id`       int(11)                       NOT NULL AUTO_INCREMENT COMMENT '收货地址id',
    `province` varchar(255) COLLATE utf8_bin NOT NULL,
    `city`     varchar(255) COLLATE utf8_bin NOT NULL,
    `street`   varchar(255) COLLATE utf8_bin NOT NULL,
    `userID`   int(10)                       NOT NULL COMMENT '用户ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`
(
    `brand` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`
(
    `id`       int(13)                       NOT NULL,
    `relation` int(13)                       NOT NULL,
    `name`     varchar(255) COLLATE utf8_bin NOT NULL,
    `price`    double(10, 2)                 NOT NULL,
    `volume`   int(10)                       NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for relation
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation`
(
    `type`  varchar(255) COLLATE utf8_bin NOT NULL,
    `brand` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart`
(
    `productID` int(13) NOT NULL,
    `userID`    int(13) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`
(
    `type` varchar(255) COLLATE utf8_bin NOT NULL,
    PRIMARY KEY (`type`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          int(11)                                          NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    `password`    varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    `phonenumber` int(13)                                          NOT NULL,
    `email`       varchar(255) COLLATE utf8_bin                    NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-05-28 21:39:46
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
-- Records of address
-- ----------------------------

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
-- Records of brand
-- ----------------------------
INSERT INTO `brand`
VALUES ('华为');
INSERT INTO `brand`
VALUES ('小米');
INSERT INTO `brand`
VALUES ('三星');
INSERT INTO `brand`
VALUES ('苹果');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`
(
    `id`       int(13) unsigned              NOT NULL AUTO_INCREMENT,
    `relation` int(13)                       NOT NULL,
    `name`     varchar(255) COLLATE utf8_bin NOT NULL,
    `price`    double(10, 2)                 NOT NULL,
    `volume`   int(10)                       NOT NULL,
    `imagpath` varchar(255) COLLATE utf8_bin NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product`
VALUES ('1', '1', 'Apple苹果平板电脑iPad mini5平板电脑7.9英寸', '2638.00', '15', 'Appleipad.jpg');
INSERT INTO `product`
VALUES ('2', '2', '苹果手机Apple iPhone XS Max (A2104) 64GB', '8399.00', '12', 'ApplePhone.jpg');
INSERT INTO `product`
VALUES ('3', '3', '苹果智能手环AppleWatchApple S4，64位双核', '2799.00', '30', 'AppleWatch.jpg');
INSERT INTO `product`
VALUES ('4', '4', 'Apple苹果笔记本电脑苹果新款MacBook Pro 13英寸（MR9U2CH/A）', '125000.00', '14', 'AppleNoteBook.jpg');
INSERT INTO `product`
VALUES ('5', '5', '华为平板电脑M3 青春版 8英寸 3GB+32GB WiFi版', '1399.00', '48', 'HuaWeiPingBan.jpg');
INSERT INTO `product`
VALUES ('6', '6', '华为手机华为P30 Pro（全网通）', '5488.00', '58', 'HuaWeiPhone.jpg');
INSERT INTO `product`
VALUES ('7', '7', '小米手机小米9（6GB RAM/全网通）', '2899.00', '28', 'xiaomishouji.jpg');
INSERT INTO `product`
VALUES ('8', '8', '小米智能手环小米手环 3', '169.00', '16', 'xiaomishouhuan.jpg');
INSERT INTO `product`
VALUES ('9', '9', '三星手机三星Galaxy S10（全网通）', '5999.00', '5', 'sanxingshouji.jpg');
INSERT INTO `product`
VALUES ('10', '10', '三星智能手环 三星Gear Fit R350', '1056.00', '2', 'sanxingshouhuan.jpg');

-- ----------------------------
-- Table structure for relation
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation`
(
    `id`    int(13)                       NOT NULL AUTO_INCREMENT,
    `type`  varchar(255) COLLATE utf8_bin NOT NULL,
    `brand` varchar(255) COLLATE utf8_bin NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Records of relation
-- ----------------------------
INSERT INTO `relation`
VALUES ('1', '平板电脑', '苹果');
INSERT INTO `relation`
VALUES ('2', '手机', '苹果');
INSERT INTO `relation`
VALUES ('3', '智能手环', '苹果');
INSERT INTO `relation`
VALUES ('4', '笔记本电脑', '苹果');
INSERT INTO `relation`
VALUES ('5', '平板电脑', '华为');
INSERT INTO `relation`
VALUES ('6', '手机', '华为');
INSERT INTO `relation`
VALUES ('7', '手机', '小米');
INSERT INTO `relation`
VALUES ('8', '智能手环', '小米');
INSERT INTO `relation`
VALUES ('9', '手机', '三星');
INSERT INTO `relation`
VALUES ('10', '智能手环', '三星');

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart`
(
    `userID`    int(13) NOT NULL,
    `productID` int(13) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------
INSERT INTO `shoppingcart`
VALUES ('2', '2');
INSERT INTO `shoppingcart`
VALUES ('2', '1');
INSERT INTO `shoppingcart`
VALUES ('3', '2');
INSERT INTO `shoppingcart`
VALUES ('3', '1');
INSERT INTO `shoppingcart`
VALUES ('5', '1');
INSERT INTO `shoppingcart`
VALUES ('5', '2');
INSERT INTO `shoppingcart`
VALUES ('4', '1');
INSERT INTO `shoppingcart`
VALUES ('4', '2');

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
-- Records of type
-- ----------------------------
INSERT INTO `type`
VALUES ('平板电脑');
INSERT INTO `type`
VALUES ('手机');
INSERT INTO `type`
VALUES ('智能手环');
INSERT INTO `type`
VALUES ('笔记本电脑');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          int(11)                                          NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    `password`    varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    `phonenumber` varchar(11) COLLATE utf8_bin                     NOT NULL,
    `email`       varchar(255) COLLATE utf8_bin                    NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES ('1', '黄文威', '123456', '18390862072', '761764092@qq.com');
INSERT INTO `user`
VALUES ('2', '刘备', '206953', '13873879338', '761764092@gmail.com');
INSERT INTO `user`
VALUES ('3', '张飞', 'password', '13973879338', '761764092@163.com');
INSERT INTO `user`
VALUES ('4', '伊文斯', '225566', '13973879338', '761764092@163.com');
INSERT INTO `user`
VALUES ('5', '陈平安', '778899', '778899', '761764092@250.com');
INSERT INTO `user`
VALUES ('6', '齐静春', '256789', '256789', '761764092@fire.com');
INSERT INTO `user`
VALUES ('10', '左右', '123456', '110', 'LGD@gmail.com');
DROP TRIGGER IF EXISTS `addVolume`;
DELIMITER ;;
CREATE TRIGGER `addVolume`
    AFTER INSERT
    ON `shoppingcart`
    FOR EACH ROW UPDATE product
                 SET product.volume = product.volume + 1
                 WHERE product.id = NEW.productID
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `cutVolume`;
DELIMITER ;;
CREATE TRIGGER `cutVolume`
    AFTER DELETE
    ON `shoppingcart`
    FOR EACH ROW UPDATE product
                 SET product.volume = product.volume - 1
                 WHERE product.id = OLD.productID
;;
DELIMITER ;

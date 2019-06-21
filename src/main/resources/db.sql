/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.7.23 : Database - shopping
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shopping` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shopping`;

/*Table structure for table `mmall_cart` */

DROP TABLE IF EXISTS `mmall_cart`;

CREATE TABLE `mmall_cart` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `checked` int(11) DEFAULT NULL COMMENT '是否选择 1=已勾选 0=未勾选',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '跟新时间',
  PRIMARY KEY (`id`),
  KEY `user_id_index` (`user_id`) USING BTREE,
  KEY `product_id` (`product_id`),
  CONSTRAINT `mmall_cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `mmall_user` (`id`),
  CONSTRAINT `mmall_cart_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `mmall_poduct` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表';

/*Data for the table `mmall_cart` */

/*Table structure for table `mmall_category` */

DROP TABLE IF EXISTS `mmall_category`;

CREATE TABLE `mmall_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类别id 当id=0时说明是根节点，一级类别',
  `name` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `status` tinyint(1) DEFAULT '1' COMMENT '类别状态1-正常 2-已放弃',
  `sort_order` int(4) DEFAULT NULL COMMENT '排序序号，同类展示顺序，数值相同则自然排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='分类表';

/*Data for the table `mmall_category` */

/*Table structure for table `mmall_order` */

DROP TABLE IF EXISTS `mmall_order`;

CREATE TABLE `mmall_order` (
  `id` int(11) NOT NULL COMMENT '订单id',
  `order_no` bigint(20) DEFAULT NULL COMMENT '订单号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) DEFAULT NULL,
  `payment` int(20) DEFAULT NULL COMMENT '单位是分',
  `payment_type` int(4) DEFAULT NULL COMMENT '支付类型 1-在线支付',
  `postage` int(10) DEFAULT NULL COMMENT '运费，单位是分',
  `status` int(10) DEFAULT NULL COMMENT '订单状态0-取消 10-未支付 20-已支付 40-已发货 50-交易成功 60-交易关闭',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime DEFAULT NULL COMMENT '交易完成时间',
  `close_time` datetime DEFAULT NULL COMMENT '交易关闭时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_no_index` (`order_no`) USING BTREE,
  KEY `user_id` (`user_id`),
  KEY `shipping_id` (`shipping_id`),
  CONSTRAINT `mmall_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `mmall_user` (`id`),
  CONSTRAINT `mmall_order_ibfk_2` FOREIGN KEY (`shipping_id`) REFERENCES `mmall_shipping` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

/*Data for the table `mmall_order` */

/*Table structure for table `mmall_order_item` */

DROP TABLE IF EXISTS `mmall_order_item`;

CREATE TABLE `mmall_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单子表id',
  `user_id` int(11) DEFAULT NULL,
  `order_no` bigint(20) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `product_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `product_image` varchar(500) DEFAULT NULL COMMENT '商品图片地址',
  `current_unit_price` int(20) DEFAULT NULL COMMENT '生成订单时的商品单价 单位的分',
  `quantity` int(10) DEFAULT NULL COMMENT '商品数量',
  `total_price` int(20) DEFAULT NULL COMMENT '商品总价 单位是分',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `order_no_index` (`order_no`) USING BTREE,
  KEY `order_no_user_id_index` (`user_id`,`order_no`) USING BTREE,
  CONSTRAINT `mmall_order_item_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `mmall_user` (`id`),
  CONSTRAINT `mmall_order_item_ibfk_2` FOREIGN KEY (`order_no`) REFERENCES `mmall_order` (`order_no`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='订单明细表';

/*Data for the table `mmall_order_item` */

/*Table structure for table `mmall_pay_info` */

DROP TABLE IF EXISTS `mmall_pay_info`;

CREATE TABLE `mmall_pay_info` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `order_no` bigint(20) DEFAULT NULL COMMENT '订单号',
  `pay_platform` int(10) DEFAULT NULL COMMENT '支付平台 1-支付宝 2-微信',
  `platform_number` varchar(200) DEFAULT NULL COMMENT '支付流水号',
  `platform_status` varchar(20) DEFAULT NULL COMMENT '支付状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `order_no` (`order_no`),
  CONSTRAINT `mmall_pay_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `mmall_user` (`id`),
  CONSTRAINT `mmall_pay_info_ibfk_2` FOREIGN KEY (`order_no`) REFERENCES `mmall_order` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付信息表';

/*Data for the table `mmall_pay_info` */

/*Table structure for table `mmall_poduct` */

DROP TABLE IF EXISTS `mmall_poduct`;

CREATE TABLE `mmall_poduct` (
  `id` int(11) NOT NULL COMMENT '商品id',
  `category_id` int(11) NOT NULL COMMENT '分类id 对应mmall_categoryb表的主键',
  `name` varchar(100) NOT NULL COMMENT '商品名称',
  `subtitle` varchar(200) DEFAULT NULL COMMENT '商品副标题',
  `main_image` varchar(500) DEFAULT NULL COMMENT '产品主图 url路径',
  `sub_images` text COMMENT '图片地址 json格式 扩展用',
  `detail` text COMMENT '商品详情',
  `price` int(20) NOT NULL COMMENT '价格 单位 分',
  `stock` int(11) DEFAULT NULL COMMENT '库存数量',
  `status` int(6) DEFAULT '1' COMMENT '商品状态 1-在售 2-下架 3-删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `mmall_poduct_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `mmall_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品表';

/*Data for the table `mmall_poduct` */

/*Table structure for table `mmall_shipping` */

DROP TABLE IF EXISTS `mmall_shipping`;

CREATE TABLE `mmall_shipping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `receiver_name` varchar(20) DEFAULT NULL COMMENT '收货名称',
  `receiver_phone` varchar(20) DEFAULT NULL COMMENT '收货固定电话',
  `receiver_mobile` varchar(20) DEFAULT NULL COMMENT '收货移动电话',
  `receiver_province` varchar(20) DEFAULT NULL COMMENT '省份',
  `receiver_city` varchar(20) DEFAULT NULL COMMENT '城市',
  `receiver_district` varchar(20) DEFAULT NULL COMMENT '区/县',
  `receiver_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `receiver_zip` varchar(6) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `mmall_shipping_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `mmall_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='收货地址表';

/*Data for the table `mmall_shipping` */

/*Table structure for table `mmall_user` */

DROP TABLE IF EXISTS `mmall_user`;

CREATE TABLE `mmall_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `recipient` varchar(50) DEFAULT NULL COMMENT '昵称',
  `question` varchar(100) DEFAULT NULL COMMENT '找回密码问题',
  `answer` varchar(100) DEFAULT NULL COMMENT '找回密码问题',
  `role` int(4) NOT NULL COMMENT '角色0-管理员 1-普通用户',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新',
  `gender` tinyint(1) DEFAULT '1' COMMENT '1=男 0=女',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `mmall_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

DROP TABLE IF EXISTS `mmall_guestbook`;
CREATE TABLE `mmall_guestbook` (
  `id` int(11) NOT NULL,
  `ask_content` varchar(255) DEFAULT NULL COMMENT '询问内容',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `created_time` datetime DEFAULT NULL COMMENT '询问时间',
  `is_reply` smallint(5) DEFAULT '0' COMMENT '是否回复',
  `reply_content` varchar(255) DEFAULT NULL COMMENT '回复内容',
  `reply_time` datetime DEFAULT NULL COMMENT '回复时间',
  `admin_id` varchar(255) DEFAULT NULL COMMENT '管理员id',
  PRIMARY KEY (`id`),
  KEY `ask_user` (`user_id`),
  KEY `ask_product` (`product_id`),
  CONSTRAINT `ask_product` FOREIGN KEY (`product_id`) REFERENCES `mmall_poduct` (`id`),
  CONSTRAINT `ask_user` FOREIGN KEY (`user_id`) REFERENCES `mmall_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='留言表';

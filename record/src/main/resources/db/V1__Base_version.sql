DROP TABLE IF EXISTS user ; 
CREATE TABLE `user` ( 
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键', 
  `name` varchar(20) NOT NULL COMMENT '姓名', 
  `age` int(5) DEFAULT NULL COMMENT '年龄', 
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4; 

DROP TABLE IF EXISTS appointments ; 
CREATE TABLE `appointments` ( 
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键', 
  `name` varchar(20) NOT NULL COMMENT '姓名', 
  `age` int(5) DEFAULT NULL COMMENT '年龄', 
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4; 


DROP TABLE IF EXISTS customer ; 
CREATE TABLE `customer` ( 
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键', 
  `name` varchar(20) NOT NULL COMMENT '姓名', 
  `age` int(5) DEFAULT NULL COMMENT '年龄', 
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4; 

DROP TABLE IF EXISTS order ; 
CREATE TABLE `order` ( 
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键', 
  `name` varchar(20) NOT NULL COMMENT '姓名', 
  `age` int(5) DEFAULT NULL COMMENT '年龄', 
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4; 


DROP TABLE IF EXISTS arrive ; 
CREATE TABLE `arrive` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键', 
  `name` varchar(20) NOT NULL COMMENT '姓名', 
  `age` int(5) DEFAULT NULL COMMENT '年龄', 
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4; 

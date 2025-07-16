DROP SCHEMA IF EXISTS `rpa-control-room`;

CREATE SCHEMA `rpa-control-room`;

use `rpa-control-room`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `client`;
DROP TABLE IF EXISTS `bot`;

CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `vm_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `bot` (
  `id` int NOT NULL AUTO_INCREMENT,
  `file_path` varchar(255) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `file_type` varchar(45) DEFAULT NULL,
  `upload_time` DATETIME DEFAULT NULL,
  `client_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_BOT_CLIENT_DETAIL_idx` (`client_id`),
  CONSTRAINT `FK_BOT_CLIENT` FOREIGN KEY (`client_id`) 
  REFERENCES `client` (`id`) ON DELETE SET NULL 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

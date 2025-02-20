CREATE DATABASE  IF NOT EXISTS `rpacontrolroom`;
USE `rpacontrolroom`;

--
-- Template table structure
--

DROP TABLE IF EXISTS `bot`;

CREATE TABLE `bot` (
  `id` int NOT NULL AUTO_INCREMENT,
  `file_path` varchar(225) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `file_type` varchar(45) DEFAULT NULL,
  `upload_time` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


CREATE DATABASE  IF NOT EXISTS `cvpooldb`;
USE `cvpooldb`;

--
-- Template table structure
--

DROP TABLE IF EXISTS `document`;

CREATE TABLE `document` (
  `id` int NOT NULL AUTO_INCREMENT,
  `file_path` varchar(225) DEFAULT NULL,
  `file_name` varchar(45) DEFAULT NULL,
  `file_type` varchar(45) DEFAULT NULL,
  `uploader_first_name` varchar(45) DEFAULT NULL,
  `uploader_last_name` varchar(45) DEFAULT NULL,
  `nominator_first_name` varchar(45) DEFAULT NULL,
  `nominator_last_name` varchar(45) DEFAULT NULL,
  `upload_time` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


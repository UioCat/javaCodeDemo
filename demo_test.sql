# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 116.62.4.111 (MySQL 8.0.23)
# Database: demo_test
# Generation Time: 2021-11-11 03:24:57 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table tb_consumer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_consumer`;

CREATE TABLE `tb_consumer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `telephone` varchar(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `tb_consumer` WRITE;
/*!40000 ALTER TABLE `tb_consumer` DISABLE KEYS */;

INSERT INTO `tb_consumer` (`id`, `telephone`, `username`, `password`)
VALUES
	(1,'12345678101','xiaoming','123456'),
	(2,'123456102','xiaoming','123456'),
	(3,'123456103','xiaoming','123456'),
	(4,'123456104','xiaoming','123456'),
	(5,'123456105','xiaoming','123456'),
	(6,'123456106','xiaoming','123456'),
	(7,'123456107','xiaoming','123456'),
	(8,'123456108','xiaoming','123456'),
	(9,'123456109','xiaoming','123456'),
	(10,'123456110','xiaoming','123456'),
	(11,'123456111','xiaoming','123456'),
	(12,'123456112','xiaoming','123456'),
	(13,'123456113','xiaoming','123456'),
	(14,'123456114','xiaoming','123456'),
	(15,'123456115','xiaoming','123456'),
	(16,'123456116','xiaoming','123456'),
	(17,'123456117','xiaoming','123456'),
	(18,'123456118','xiaoming','123456'),
	(19,'123456119','xiaoming','123456'),
	(20,'123456120','xiaoming','123456'),
	(21,'123456120','xiaoming','123456'),
	(22,'123456120','xiaoming','123456');

/*!40000 ALTER TABLE `tb_consumer` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

USE `ecommerce`;

SET foreign_key_checks = 0;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `id` smallint unsigned NOT NULL,
  `code` varchar(2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

--
-- Data for table `country`
--

INSERT INTO `country` VALUES 
(1,'SP','Spain'),
(2,'PT','Portugal'),
(3,'GR','Germany'),
(4,'FR','France');

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `country_id` smallint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_country` (`country_id`),
  CONSTRAINT `fk_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

--
-- Dumping data for table `state`
--

INSERT INTO `state` VALUES 
(1,'Andalucia',1),
(2,'Madrid',1),
(3,'Cantabria',1),
(4,'Valencia',1),
(5,'Extremadura',1),
(6,'Faro',2),
(7,'Lisbon',2),
(8,'Evora',2),
(9,'Porto',2),
(10,'Setubal',2),
(11,'Baden-Württemberg',3),
(12,'Bavaria',3),
(13,'Berlin',3),
(14,'Brandenburg',3),
(15,'Bremen',3),
(16,'Brittany',4),
(17,'Lorraine',4),
(18,'Rhone-Alpes',4),
(19,'Montpellier',4),
(20,'Alsace',4);

SET foreign_key_checks = 1;
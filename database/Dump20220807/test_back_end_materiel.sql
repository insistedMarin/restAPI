-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: test_back_end
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `materiel`
--

DROP TABLE IF EXISTS `materiel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materiel` (
  `materiel_id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `discription` text,
  `marque` varchar(45) NOT NULL DEFAULT 'test',
  `image_url` varchar(2048) DEFAULT NULL,
  `taille` enum('petit','moyen','grand') NOT NULL DEFAULT 'petit',
  `duree_location` int NOT NULL DEFAULT '10',
  `cout_location` decimal(10,3) NOT NULL DEFAULT '34.500',
  `cout_remplacement` decimal(10,3) NOT NULL DEFAULT '34.500',
  `categorie_id` int NOT NULL,
  `update_at` timestamp NOT NULL,
  PRIMARY KEY (`materiel_id`),
  KEY `categorie_id` (`categorie_id`),
  CONSTRAINT `materiel_ibfk_1` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`Categorie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiel`
--

LOCK TABLES `materiel` WRITE;
/*!40000 ALTER TABLE `materiel` DISABLE KEYS */;
INSERT INTO `materiel` VALUES (3,'MacBook Pro 2021',NULL,'test',NULL,'petit',10,34.500,34.500,1,'2022-08-07 00:06:18'),(4,'Samsung S10','null','Samsung','null','petit',18,33.500,34.500,1,'2022-08-07 07:50:01'),(8,'dell',NULL,'test',NULL,'petit',10,34.500,34.500,1,'2022-08-07 10:09:58');
/*!40000 ALTER TABLE `materiel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-07 15:41:26

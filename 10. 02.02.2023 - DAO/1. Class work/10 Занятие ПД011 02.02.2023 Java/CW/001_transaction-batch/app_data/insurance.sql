CREATE DATABASE  IF NOT EXISTS `insurance` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `insurance`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: insurance
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surname` varchar(60) NOT NULL,
  `name` varchar(40) NOT NULL,
  `patronymic` varchar(60) NOT NULL,
  `passport` varchar(12) NOT NULL,
  `discount` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `passport_UNIQUE` (`passport`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Морозова','Юлия','Ивановна','78 20 784122',0.5),(2,'Петров','Александр','Владимирович','78 20 789000',0.1),(3,'Грайко','Павел','Игоревич','78 20 982919',0.3),(4,'Иванилов','Денис','Федорович','77 19 341919',0.2),(5,'Васильев','Михаил','Сергеевич','79 17 891892',0.15),(6,'Авраимов','Павел','Андреевич','83 17 901111',0.4),(7,'Васильев','Николай','Павлович','77 19 911091',0.44999999999999996),(8,'Дерезуцких','Галина','Степановна','83 17 345421',0.7),(9,'Иванник','Дмитрий','Максимович','79 17 343499',0.5499999999999999),(10,'Горонкова','Таисия','Павловна','77 19 034002',4.929999999999999),(11,'Васильева','Раиса','Максимовна','79 17 981211',0.35),(12,'Куликова','Анастасия','Николаевна','83 17 111211',2.6500000000000004),(13,'Васильев','Леонид','Степанович','79 17 091090',0.51),(14,'Ивашкин','Владимир','Игоревич','78 20 342111',0.35),(15,'Колтунов','Павел','Ефимович','78 20 342588',0.41000000000000003);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-02 14:36:32

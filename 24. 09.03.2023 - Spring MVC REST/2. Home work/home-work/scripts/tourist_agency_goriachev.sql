CREATE DATABASE  IF NOT EXISTS `tourist_agency_goriachev` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tourist_agency_goriachev`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: tourist_agency_goriachev
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
  `surname` varchar(80) NOT NULL,
  `name` varchar(80) NOT NULL,
  `patronymic` varchar(80) NOT NULL,
  `passport` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `passport` (`passport`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Иванов','Владимир','Александрович','1234 567890'),(2,'Петров','Валерий','Витальевич','2345 678901'),(3,'Сидоров','Александр','Сергеевич','3456 789012'),(4,'Козлов','Андрей','Александрович','4567 890123'),(5,'Смирнова','Елена','Дмитриевна','5678 901234'),(6,'Федорова','Ольга','Андреевна','6789 012345'),(7,'Попов','Михаил','Сергеевич','7890 123456'),(8,'Александрова','Надежда','Павловна','8901 234567'),(9,'Кузнецова','Екатерина','Ивановна','9012 345678'),(10,'Николаева','Татьяна','Алексеевна','0123 456789'),(11,'Михайлов','Владимир','Геннадьевич','0987 654321'),(12,'Гаврилов','Анатолий','Сергеевич','9876 543210'),(13,'Полякова','Ирина','Владимировна','8765 432109'),(14,'Калинина','Оксана','Сергеевна','7654 321098'),(15,'Антонов','Дмитрий','Андреевич','6543 210987'),(16,'Лебедева','Марина','Ивановна','5432 109876'),(17,'Савельев','Виктор','Александрович','4321 098765'),(18,'Борисов','Георгий','Петрович','3210 987654'),(19,'Королева','Анастасия','Сергеевна','2109 876543'),(20,'Тихонов','Василий','Дмитриевич','1098 765432');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countries` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `cost_service` int NOT NULL,
  `cost_visa` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,'Франция',500,2000),(2,'Испания',600,2500),(3,'Италия',550,2200),(4,'Греция',450,1800),(5,'Хорватия',400,1600),(6,'Турция',400,1700),(7,'Таиланд',800,3000),(8,'Египет',350,1500),(9,'ОАЭ',1000,3500),(10,'США',1200,4000),(11,'Канада',1000,3500),(12,'Япония',1500,5000),(13,'Китай',700,2800),(14,'Австралия',1300,4500),(15,'Новая Зеландия',1200,4200);
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objectives`
--

DROP TABLE IF EXISTS `objectives`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `objectives` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objectives`
--

LOCK TABLES `objectives` WRITE;
/*!40000 ALTER TABLE `objectives` DISABLE KEYS */;
INSERT INTO `objectives` VALUES (9,'Активный отдых'),(4,'Знакомство с культурой'),(3,'Изучение языка'),(2,'Отдых'),(6,'Покупки'),(5,'Посещение достопримечательностей'),(1,'Путешествие'),(8,'Релаксация'),(10,'События и фестивали'),(7,'Спорт');
/*!40000 ALTER TABLE `objectives` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routes`
--

DROP TABLE IF EXISTS `routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country_id` int NOT NULL,
  `objective_id` int NOT NULL,
  `daily_cost` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_routes_countries` (`country_id`),
  KEY `fk_routes_objectives` (`objective_id`),
  CONSTRAINT `fk_routes_countries` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`),
  CONSTRAINT `fk_routes_objectives` FOREIGN KEY (`objective_id`) REFERENCES `objectives` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes`
--

LOCK TABLES `routes` WRITE;
/*!40000 ALTER TABLE `routes` DISABLE KEYS */;
INSERT INTO `routes` VALUES (1,5,1,2000),(2,2,10,1000),(3,8,4,1400),(4,3,1,3200),(5,12,4,2000),(6,1,7,4600),(7,9,3,2100),(8,4,8,1800),(9,7,1,2900),(10,14,10,3200),(11,6,5,4300),(12,10,9,1500),(13,1,4,2000),(14,13,2,2800),(15,11,1,3600),(16,3,5,4400),(17,15,5,5000),(18,9,2,3400),(19,7,2,1700),(20,2,6,2900);
/*!40000 ALTER TABLE `routes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visits`
--

DROP TABLE IF EXISTS `visits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visits` (
  `id` int NOT NULL AUTO_INCREMENT,
  `client_id` int NOT NULL,
  `route_id` int NOT NULL,
  `date_start` date NOT NULL,
  `duration` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_visits_clients` (`client_id`),
  KEY `fk_visits_routes` (`route_id`),
  CONSTRAINT `fk_visits_clients` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  CONSTRAINT `fk_visits_routes` FOREIGN KEY (`route_id`) REFERENCES `routes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visits`
--

LOCK TABLES `visits` WRITE;
/*!40000 ALTER TABLE `visits` DISABLE KEYS */;
INSERT INTO `visits` VALUES (1,10,5,'2023-03-11',7),(2,3,17,'2023-01-15',8),(3,8,10,'2023-02-09',2),(4,17,7,'2023-02-25',10),(5,1,6,'2023-02-08',14),(6,16,1,'2023-02-20',6),(7,13,19,'2023-02-17',3),(8,6,9,'2023-01-16',3),(9,2,13,'2023-02-04',10),(10,12,15,'2023-03-10',14),(11,18,7,'2023-02-14',6),(12,19,10,'2023-03-09',4),(13,4,2,'2023-01-29',5),(14,7,8,'2023-03-05',1),(15,20,3,'2023-02-23',6),(16,15,1,'2023-02-11',5),(17,11,16,'2023-01-09',4),(18,5,2,'2023-01-22',13),(19,14,14,'2023-02-22',3),(20,9,9,'2023-03-02',3);
/*!40000 ALTER TABLE `visits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tourist_agency_goriachev'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-05 13:44:40

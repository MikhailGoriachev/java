CREATE DATABASE  IF NOT EXISTS `sales_accounting_goriachev` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sales_accounting_goriachev`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: sales_accounting_goriachev
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
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'чехол защитный'),(2,'пиджак замшевый'),(3,'кинокамера импортная'),(4,'ручка гелевая'),(5,'маркер спиртовой'),(6,'блюдце фаянсовое'),(7,'подставка для горячего'),(8,'ботинки защитные'),(9,'зонтик автоматический'),(10,'галоши резиновые'),(11,'кружка алюминиевая'),(12,'рюкзак для ноутбука'),(13,'велосипед горный'),(14,'палатка туристическая'),(15,'лодка надувная'),(16,'ложка чайная'),(17,'шланг гофрированный'),(18,'шланг армированный'),(19,'провод черный'),(20,'реле прерыватель'),(21,'автомат защиты');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `people` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surname` varchar(60) NOT NULL,
  `name` varchar(50) NOT NULL,
  `patronymic` varchar(60) NOT NULL,
  `passport` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ck_people_passport` (`passport`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (1,'Юрковский','Марк','Максимилианович','12 21 345671'),(2,'Якубовская','Диана','Павловна','12 21 123452'),(3,'Шапиро','Федор','Федорович','12 21 456123'),(4,'Вожжаев','Сергей','Денисович','12 21 123122'),(5,'Хроменко','Игорь','Владимирович','12 21 342121'),(6,'Пелых','Марина','Ульяновна','11 21 121212'),(7,'Лапотникова','Тамара','Оскаровна','11 21 098181'),(8,'Огородников','Сергей','Иванович','12 21 091911'),(9,'Яйло','Екатерина','Николаевна','12 21 345675'),(10,'Лосева','Инна','Степановна','12 21 187651'),(11,'Михайлович','Анна','Валентиновна','09 20 000122'),(12,'Тарапата','Михаил','Исаакович','09 20 001981'),(13,'Трубихин','Эдуард','Михайлович','09 21 121921'),(14,'Чмыхало','Олег','Тарасович','12 20 021121'),(15,'Князьков','Степан','Сидорович','09 19 002165'),(16,'Потемкина','Наталья','Павловна','09 19 002213'),(17,'Гритченко','Степан','Романович','09 19 002129'),(18,'Селиванов','Александр','Михайлович','11 18 000503'),(19,'Царькова','Лариса','Ильинична','11 18 000523'),(20,'Яструб','Владимир','Данилович','14 21 091811');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchases`
--

DROP TABLE IF EXISTS `purchases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchases` (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_id` int NOT NULL,
  `unit_id` int NOT NULL,
  `purchase_date` date NOT NULL,
  `price` int NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_purchases_goods` (`goods_id`),
  KEY `fk_purchases_units` (`unit_id`),
  CONSTRAINT `fk_purchases_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`),
  CONSTRAINT `fk_purchases_units` FOREIGN KEY (`unit_id`) REFERENCES `units` (`id`),
  CONSTRAINT `ck_purchases_amount` CHECK ((`amount` > 0)),
  CONSTRAINT `ck_purchases_price` CHECK ((`price` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchases`
--

LOCK TABLES `purchases` WRITE;
/*!40000 ALTER TABLE `purchases` DISABLE KEYS */;
INSERT INTO `purchases` VALUES (1,1,1,'2022-10-01',1700,5),(2,1,1,'2022-10-02',1850,2),(3,1,1,'2022-10-02',1600,12),(4,3,1,'2022-10-03',8000,6),(5,4,9,'2022-10-03',2000,3),(6,5,9,'2022-10-04',2000,3),(7,6,1,'2022-10-04',400,10),(8,7,1,'2022-10-07',7900,10),(9,4,9,'2022-10-07',3000,3),(10,5,1,'2022-10-07',200,30),(11,3,1,'2022-10-07',8300,5),(12,7,4,'2022-10-17',36000,3),(13,6,1,'2022-10-17',380,60),(14,7,4,'2022-10-17',22000,2),(15,3,9,'2022-10-17',80000,2),(16,4,1,'2022-10-27',30,200),(17,7,4,'2022-10-27',12000,3),(18,1,1,'2022-10-27',1300,300),(19,2,10,'2022-10-27',1000000,1),(20,11,1,'2022-11-01',260,20),(21,12,7,'2022-11-01',60000,3),(22,11,1,'2022-11-07',250,30),(23,12,1,'2022-11-07',5200,10);
/*!40000 ALTER TABLE `purchases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `id` int NOT NULL AUTO_INCREMENT,
  `purchase_id` int NOT NULL,
  `unit_id` int NOT NULL,
  `seller_id` int NOT NULL,
  `sale_date` date NOT NULL,
  `price` int NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sales_purchases` (`purchase_id`),
  KEY `fk_sales_units` (`unit_id`),
  KEY `fk_sales_sellers` (`seller_id`),
  CONSTRAINT `fk_sales_purchases` FOREIGN KEY (`purchase_id`) REFERENCES `purchases` (`id`),
  CONSTRAINT `fk_sales_sellers` FOREIGN KEY (`seller_id`) REFERENCES `sellers` (`id`),
  CONSTRAINT `fk_sales_units` FOREIGN KEY (`unit_id`) REFERENCES `units` (`id`),
  CONSTRAINT `ck_sales_amount` CHECK ((`amount` > 0)),
  CONSTRAINT `ck_sales_price` CHECK ((`price` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,1,1,1,'2022-10-02',1900,2),(2,1,1,2,'2022-10-02',1950,3),(3,2,1,5,'2022-10-02',1960,13),(4,3,1,3,'2022-10-03',1900,6),(8,4,1,2,'2022-10-04',9200,1),(9,5,9,3,'2022-10-05',2500,2),(11,6,9,4,'2022-10-05',2300,1),(12,7,1,5,'2022-10-05',500,1),(14,6,9,3,'2022-10-07',2500,2),(15,7,1,6,'2022-10-07',500,8),(16,9,9,5,'2022-10-09',4300,2),(17,8,1,1,'2022-10-09',8300,4),(18,11,1,2,'2022-10-09',9000,3),(19,10,1,3,'2022-10-10',500,20),(20,11,1,4,'2022-10-10',9000,1),(21,10,1,3,'2022-10-11',450,8),(22,11,1,2,'2022-10-12',9000,1),(23,10,1,1,'2022-10-13',510,3),(25,10,1,6,'2022-10-16',480,6),(26,15,9,5,'2022-10-17',100000,26),(27,12,4,3,'2022-10-17',40000,1),(29,12,4,5,'2022-10-18',43000,1),(30,15,9,1,'2022-10-18',110000,1),(31,13,1,2,'2022-10-20',580,40),(33,14,4,1,'2022-10-21',27000,14),(34,12,4,3,'2022-10-23',45000,1),(35,13,1,2,'2022-10-25',650,10),(37,19,10,5,'2022-10-27',1600000,1),(38,16,1,4,'2022-10-27',60,100),(39,17,4,2,'2022-10-28',16000,1),(41,16,1,4,'2022-10-30',60,100),(42,17,4,3,'2022-10-30',16000,1),(43,17,4,2,'2022-10-30',16800,1),(44,18,1,6,'2022-10-31',580,200),(45,18,1,1,'2022-10-31',680,100),(47,20,1,5,'2022-11-03',380,2),(48,21,7,4,'2022-11-04',82000,1),(49,20,1,3,'2022-11-05',360,12),(50,21,7,4,'2022-11-06',80000,1),(51,20,1,3,'2022-11-07',380,6),(52,23,1,3,'2022-11-07',6600,3),(53,22,1,4,'2022-11-08',650,10),(54,23,1,5,'2022-11-08',6800,4),(55,22,1,5,'2022-11-08',600,15),(56,22,1,4,'2022-11-09',650,5),(57,23,1,3,'2022-11-09',6600,3),(58,19,4,3,'2023-03-07',700,4),(59,22,10,19,'2023-03-07',500,2),(60,3,1,2,'2023-03-07',600,6),(61,22,8,12,'2023-03-07',700,4),(62,19,10,17,'2023-03-07',400,6),(63,14,3,14,'2023-03-07',500,6),(64,6,9,9,'2023-03-07',600,3),(65,12,5,5,'2023-03-07',400,5);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sellers`
--

DROP TABLE IF EXISTS `sellers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sellers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `person_id` int NOT NULL,
  `interest` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sellers_people` (`person_id`),
  CONSTRAINT `fk_sellers_people` FOREIGN KEY (`person_id`) REFERENCES `people` (`id`),
  CONSTRAINT `ck_sellers_interest` CHECK ((`interest` between 1.0 and 15.0))
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sellers`
--

LOCK TABLES `sellers` WRITE;
/*!40000 ALTER TABLE `sellers` DISABLE KEYS */;
INSERT INTO `sellers` VALUES (1,1,3.5),(2,2,5.5),(3,3,5.5),(4,4,6.5),(5,5,8.5),(6,6,10.5),(7,7,8),(8,8,5),(9,9,8),(10,10,8),(11,11,3.5),(12,12,3),(13,13,4),(14,14,10),(15,15,5.5),(16,16,10),(17,17,8),(18,18,5),(19,19,4.5),(20,20,11);
/*!40000 ALTER TABLE `sellers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `units`
--

DROP TABLE IF EXISTS `units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `units` (
  `id` int NOT NULL AUTO_INCREMENT,
  `short` varchar(6) NOT NULL,
  `long` varchar(26) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (1,'шт','штук'),(2,'пак','пакет'),(3,'пал','палета'),(4,'ящ','ящик'),(5,'жб','жестяная банка'),(6,'бут','бутылка'),(7,'меш','мешок'),(8,'бл','блок'),(9,'кор','коробка'),(10,'конт','контейнер');
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sales_accounting_goriachev'
--

--
-- Dumping routines for database 'sales_accounting_goriachev'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-09 15:44:03

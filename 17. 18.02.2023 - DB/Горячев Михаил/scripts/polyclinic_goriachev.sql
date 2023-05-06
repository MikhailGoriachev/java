CREATE DATABASE  IF NOT EXISTS `polyclinic_goriachev` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `polyclinic_goriachev`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: polyclinic_goriachev
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
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `appointment_date` date NOT NULL,
  `id_patient` int NOT NULL,
  `id_doctor` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Appointments_patients` (`id_patient`),
  KEY `fk_Appointments_doctors` (`id_doctor`),
  CONSTRAINT `fk_Appointments_doctors` FOREIGN KEY (`id_doctor`) REFERENCES `doctors` (`id`),
  CONSTRAINT `fk_Appointments_patients` FOREIGN KEY (`id_patient`) REFERENCES `patients` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (1,'2022-10-21',1,1),(2,'2022-10-24',2,1),(3,'2022-10-26',3,2),(4,'2022-10-31',16,3),(5,'2022-10-22',4,5),(6,'2022-10-11',3,5),(7,'2022-12-25',14,6),(8,'2022-10-13',5,2),(9,'2022-10-26',18,5),(10,'2022-10-15',9,6),(11,'2022-12-22',7,6),(12,'2022-10-28',3,7),(13,'2022-10-26',14,8),(14,'2022-10-28',4,9),(15,'2022-11-05',18,9);
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `id` int NOT NULL,
  `id_person` int NOT NULL,
  `id_speciality` int NOT NULL,
  `price` int NOT NULL,
  `percent` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_doctors_persons` (`id_person`),
  KEY `fk_doctors_specialities` (`id_speciality`),
  CONSTRAINT `fk_doctors_persons` FOREIGN KEY (`id_person`) REFERENCES `persons` (`id`),
  CONSTRAINT `fk_doctors_specialities` FOREIGN KEY (`id_speciality`) REFERENCES `specialities` (`id`),
  CONSTRAINT `ck_doctors_percent` CHECK ((`percent` > 0)),
  CONSTRAINT `ck_doctors_price` CHECK ((`price` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,1,1,110,5),(2,2,2,300,9),(3,3,1,100,9),(4,4,3,300,6),(5,5,3,300,4.5),(6,6,2,200,6),(7,7,4,300,4),(8,8,5,250,3.5),(9,9,6,300,6),(10,10,6,100,5),(11,11,2,200,5),(12,12,1,120,6.2);
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `id` int NOT NULL,
  `id_person` int NOT NULL,
  `born_date` date NOT NULL,
  `address` varchar(80) NOT NULL,
  `passport` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Patients_persons` (`id_person`),
  CONSTRAINT `fk_Patients_persons` FOREIGN KEY (`id_person`) REFERENCES `persons` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,13,'2001-02-12','ул. Садовая, д. 123, кв. 12','ЕС45718'),(2,14,'1991-07-09','ул. Зайцева, д. 2','АВ34524'),(3,15,'1963-03-18','пр. Титова, д. 11, кв. 91','АТ65423'),(4,16,'1957-04-21','ул. Содовая, д. 9','ВО12312'),(5,17,'2001-02-12','ул. Челюскинцев, д. 112, кв. 211','СК67443'),(6,18,'1935-06-01','пр. Титова, д. 9, кв. 21','ВА12234'),(7,19,'1992-07-06','пл. Конституции, д. 3, кв. 75','СО54334'),(8,20,'1991-07-09','пр. Мира, д. 3, кв. 64','ВС89532'),(9,24,'1947-12-23','ул. Содовая, д. 9, кв. 6','СС34267'),(10,22,'1991-07-09','ул. Садовая, д. 10','АТ23414'),(11,23,'1956-09-29','ул. Судовая, д. 1, кв. 91','СО98751'),(12,24,'1963-04-13','пр. Титова, д. 31, кв. 42','ВА32456'),(13,25,'1957-04-21','ул. Челюскинцев, д. 3','ВО98412'),(14,26,'2001-02-12','пр. Содовая, д. 13','АТ15321'),(15,27,'2001-11-04','пл. Конституции, д. 1, кв. 50','СС75198'),(16,28,'2001-10-09','ул. Щорса, д. 23, кв. 17','ЕС98415'),(17,29,'1998-12-21','ул. Овнатаняна, д. 4, кв. 98','АВ51591'),(18,30,'1997-02-27','ул. Чкалова, д. 11','АТ57484');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persons` (
  `id` int NOT NULL,
  `surname` varchar(60) NOT NULL,
  `name` varchar(50) NOT NULL,
  `patronymic` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES (1,'Юрковский','Марк','Максимилианович'),(2,'Якубовская','Диана','Павловна'),(3,'Шапиро','Федор','Федорович'),(4,'Вожжаев','Сергей','Денисович'),(5,'Хроменко','Игорь','Владимирович'),(6,'Пелых','Марина','Ульяновна'),(7,'Лапотникова','Тамара','Оскаровна'),(8,'Огородников','Сергей','Иванович'),(9,'Яйло','Екатерина','Николаевна'),(10,'Лосева','Инна','Степановна'),(11,'Михайлович','Анна','Валентиновна'),(12,'Тарапата','Михаил','Исаакович'),(13,'Трубихин','Эдуард','Михайлович'),(14,'Чмыхало','Олег','Тарасович'),(15,'Князьков','Степан','Сидорович'),(16,'Потемкина','Наталья','Павловна'),(17,'Гритченко','Степан','Романович'),(18,'Селиванов','Александр','Михайлович'),(19,'Царькова','Лариса','Ильинична'),(20,'Яструб','Владимир','Данилович'),(21,'Мелашенко','Александр','Алексеевич'),(22,'Пономаренко','Владислов','Дмитриевич'),(23,'Хавалджи','Любовь','Амировна'),(24,'Пархоменко','Ирина','Владимировна'),(25,'Демидова','Алина','Александровна'),(26,'Лысенко','Елена','Егоровна'),(27,'Федосенко','Оксана','Владимировна'),(28,'Богатырева','Екатерина','Алексеевна'),(29,'Иванова','Валентина','Степановна'),(30,'Ильюшин','Сергей','Юрьевич');
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialities`
--

DROP TABLE IF EXISTS `specialities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialities` (
  `id` int NOT NULL,
  `name` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialities`
--

LOCK TABLES `specialities` WRITE;
/*!40000 ALTER TABLE `specialities` DISABLE KEYS */;
INSERT INTO `specialities` VALUES (1,'терапевт'),(2,'стоматолог'),(3,'окулист'),(4,'кардиолог'),(5,'пульманолог'),(6,'хирург'),(7,'акушер'),(8,'отоларинголог'),(9,'инфекционист'),(10,'физиотерпевт'),(11,'онколог'),(12,'венеролог'),(13,'уролог');
/*!40000 ALTER TABLE `specialities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_appointments`
--

DROP TABLE IF EXISTS `view_appointments`;
/*!50001 DROP VIEW IF EXISTS `view_appointments`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_appointments` AS SELECT 
 1 AS `id`,
 1 AS `appointment_date`,
 1 AS `id_doctor`,
 1 AS `doctor_surname`,
 1 AS `doctor_name`,
 1 AS `doctor_patronymic`,
 1 AS `id_speciality`,
 1 AS `speciality_name`,
 1 AS `price`,
 1 AS `percent`,
 1 AS `id_patient`,
 1 AS `patient_surname`,
 1 AS `patient_name`,
 1 AS `patient_patronymic`,
 1 AS `born_date`,
 1 AS `address`,
 1 AS `passport`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_doctors`
--

DROP TABLE IF EXISTS `view_doctors`;
/*!50001 DROP VIEW IF EXISTS `view_doctors`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_doctors` AS SELECT 
 1 AS `id`,
 1 AS `id_person`,
 1 AS `doctor_surname`,
 1 AS `doctor_name`,
 1 AS `doctor_patronymic`,
 1 AS `id_speciality`,
 1 AS `speciality_name`,
 1 AS `price`,
 1 AS `percent`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_patients`
--

DROP TABLE IF EXISTS `view_patients`;
/*!50001 DROP VIEW IF EXISTS `view_patients`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_patients` AS SELECT 
 1 AS `id`,
 1 AS `id_person`,
 1 AS `patient_surname`,
 1 AS `patient_name`,
 1 AS `patient_patronymic`,
 1 AS `born_date`,
 1 AS `address`,
 1 AS `passport`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'polyclinic_goriachev'
--

--
-- Dumping routines for database 'polyclinic_goriachev'
--

--
-- Final view structure for view `view_appointments`
--

/*!50001 DROP VIEW IF EXISTS `view_appointments`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_appointments` AS select `appointments`.`id` AS `id`,`appointments`.`appointment_date` AS `appointment_date`,`doctors`.`id` AS `id_doctor`,`doc`.`surname` AS `doctor_surname`,`doc`.`name` AS `doctor_name`,`doc`.`patronymic` AS `doctor_patronymic`,`specialities`.`id` AS `id_speciality`,`specialities`.`name` AS `speciality_name`,`doctors`.`price` AS `price`,`doctors`.`percent` AS `percent`,`patients`.`id` AS `id_patient`,`pat`.`surname` AS `patient_surname`,`pat`.`name` AS `patient_name`,`pat`.`patronymic` AS `patient_patronymic`,`patients`.`born_date` AS `born_date`,`patients`.`address` AS `address`,`patients`.`passport` AS `passport` from ((`appointments` join ((`doctors` join `persons` `doc` on((`doctors`.`id_person` = `doc`.`id`))) join `specialities` on((`doctors`.`id_speciality` = `specialities`.`id`))) on((`appointments`.`id_doctor` = `doctors`.`id`))) join (`patients` join `persons` `pat` on((`patients`.`id_person` = `pat`.`id`))) on((`appointments`.`id_patient` = `patients`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_doctors`
--

/*!50001 DROP VIEW IF EXISTS `view_doctors`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_doctors` AS select `doctors`.`id` AS `id`,`persons`.`id` AS `id_person`,`persons`.`surname` AS `doctor_surname`,`persons`.`name` AS `doctor_name`,`persons`.`patronymic` AS `doctor_patronymic`,`specialities`.`id` AS `id_speciality`,`specialities`.`name` AS `speciality_name`,`doctors`.`price` AS `price`,`doctors`.`percent` AS `percent` from ((`doctors` join `persons` on((`doctors`.`id_person` = `persons`.`id`))) join `specialities` on((`doctors`.`id_speciality` = `specialities`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_patients`
--

/*!50001 DROP VIEW IF EXISTS `view_patients`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_patients` AS select `patients`.`id` AS `id`,`persons`.`id` AS `id_person`,`persons`.`surname` AS `patient_surname`,`persons`.`name` AS `patient_name`,`persons`.`patronymic` AS `patient_patronymic`,`patients`.`born_date` AS `born_date`,`patients`.`address` AS `address`,`patients`.`passport` AS `passport` from (`patients` join `persons` on((`patients`.`id_person` = `persons`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-20 22:01:40

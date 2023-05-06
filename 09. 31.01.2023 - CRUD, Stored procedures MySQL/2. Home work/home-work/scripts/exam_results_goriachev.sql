CREATE DATABASE  IF NOT EXISTS `exam_results_goriachev` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `exam_results_goriachev`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: exam_results_goriachev
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
-- Table structure for table `academic_subjects`
--

DROP TABLE IF EXISTS `academic_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academic_subjects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academic_subjects`
--

LOCK TABLES `academic_subjects` WRITE;
/*!40000 ALTER TABLE `academic_subjects` DISABLE KEYS */;
INSERT INTO `academic_subjects` VALUES (1,'философия'),(2,'математика'),(3,'программирование'),(4,'литература'),(5,'физика'),(6,'алгебра'),(7,'геометрия'),(8,'астрономия'),(9,'история'),(10,'системное администрирование');
/*!40000 ALTER TABLE `academic_subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_types`
--

DROP TABLE IF EXISTS `exam_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_types` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_academic_subject` int NOT NULL,
  `name` varchar(120) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_exam_types_academic_subjects_idx` (`id_academic_subject`),
  CONSTRAINT `fk_exam_types_academic_subjects` FOREIGN KEY (`id_academic_subject`) REFERENCES `academic_subjects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_types`
--

LOCK TABLES `exam_types` WRITE;
/*!40000 ALTER TABLE `exam_types` DISABLE KEYS */;
INSERT INTO `exam_types` VALUES (1,1,'Философия древнего мира'),(2,2,'Простые числа'),(3,3,'C++ для WEB'),(4,3,'Entity Framework'),(5,3,'Web stack Junior'),(6,3,'PHP Laravel'),(7,3,'Unity C++'),(8,4,'Зарубежная поэзия'),(9,4,'Отечественные писали'),(10,8,'Планеты гиганты'),(11,8,'Планеты карлики'),(12,8,'Звёзды'),(13,9,'История древнего мира'),(14,9,'Античность'),(15,9,'Средневековье'),(16,6,'Уравнения'),(17,6,'Функции'),(18,1,'Философия древнего мира'),(19,2,'Простые числа'),(20,3,'C++ для WEB'),(21,3,'Entity Framework'),(22,3,'Web stack Junior'),(23,3,'PHP Laravel'),(24,3,'Unity C++'),(25,4,'Зарубежная поэзия'),(26,4,'Отечественные писали'),(27,8,'Планеты гиганты'),(28,8,'Планеты карлики'),(29,8,'Звёзды'),(30,9,'История древнего мира'),(31,9,'Античность'),(32,9,'Средневековье'),(33,6,'Уравнения'),(34,6,'Функции');
/*!40000 ALTER TABLE `exam_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `exam_types_view`
--

DROP TABLE IF EXISTS `exam_types_view`;
/*!50001 DROP VIEW IF EXISTS `exam_types_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `exam_types_view` AS SELECT 
 1 AS `id`,
 1 AS `academic_subject_name`,
 1 AS `name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `examiners`
--

DROP TABLE IF EXISTS `examiners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examiners` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_person` int NOT NULL,
  `exam_fee` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_exams_persons_idx` (`id_person`),
  CONSTRAINT `fk_examiners_people` FOREIGN KEY (`id_person`) REFERENCES `people` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examiners`
--

LOCK TABLES `examiners` WRITE;
/*!40000 ALTER TABLE `examiners` DISABLE KEYS */;
INSERT INTO `examiners` VALUES (1,1,300),(2,2,450),(3,3,730),(4,4,680),(5,5,320),(6,1,300),(7,2,450),(8,3,730),(9,4,680),(10,5,320);
/*!40000 ALTER TABLE `examiners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `examiners_view`
--

DROP TABLE IF EXISTS `examiners_view`;
/*!50001 DROP VIEW IF EXISTS `examiners_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `examiners_view` AS SELECT 
 1 AS `id`,
 1 AS `last_name`,
 1 AS `first_name`,
 1 AS `patronymic`,
 1 AS `exam_fee`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `exams`
--

DROP TABLE IF EXISTS `exams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exams` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_exam_type` int NOT NULL,
  `id_examiner` int NOT NULL,
  `id_student` int NOT NULL,
  `date` date NOT NULL,
  `score` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_exams_exams_types_idx` (`id_exam_type`),
  KEY `fk_exams_examiners_idx` (`id_examiner`),
  KEY `fk_exams_students_idx` (`id_student`),
  KEY `fk_exams_exam_types_idx` (`id_exam_type`),
  CONSTRAINT `fk_exams_exam_types` FOREIGN KEY (`id_exam_type`) REFERENCES `exam_types` (`id`),
  CONSTRAINT `fk_exams_examiners` FOREIGN KEY (`id_examiner`) REFERENCES `examiners` (`id`),
  CONSTRAINT `fk_exams_students` FOREIGN KEY (`id_student`) REFERENCES `students` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exams`
--

LOCK TABLES `exams` WRITE;
/*!40000 ALTER TABLE `exams` DISABLE KEYS */;
INSERT INTO `exams` VALUES (7,12,3,7,'2022-11-22',16),(8,4,2,8,'2022-11-16',45),(9,5,3,9,'2022-11-04',13),(11,3,3,11,'2022-11-01',81),(12,6,1,12,'2022-11-02',64),(13,12,1,13,'2022-11-03',38),(14,3,1,14,'2022-11-08',85),(15,5,4,15,'2022-11-04',96),(16,2,3,4,'2021-11-10',3),(17,3,4,2,'2021-11-01',10),(18,4,2,1,'2021-11-10',1),(19,1,5,1,'2021-11-02',2),(20,1,4,1,'2021-11-02',3),(21,1,2,2,'2021-11-02',1),(22,2,2,3,'2021-11-10',1),(23,5,3,2,'2021-11-05',2),(24,5,3,4,'2021-11-06',3),(25,1,2,4,'2021-11-06',4),(26,2,5,4,'2021-11-08',5),(27,2,3,3,'2021-11-06',5);
/*!40000 ALTER TABLE `exams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `exams_view`
--

DROP TABLE IF EXISTS `exams_view`;
/*!50001 DROP VIEW IF EXISTS `exams_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `exams_view` AS SELECT 
 1 AS `id`,
 1 AS `academic_subject_name`,
 1 AS `exam_type_id`,
 1 AS `exam_type_name`,
 1 AS `examiner_id`,
 1 AS `examiner_last_name`,
 1 AS `examiner_first_name`,
 1 AS `examiner_patronymic`,
 1 AS `examiner_exam_fee`,
 1 AS `student_id`,
 1 AS `student_last_name`,
 1 AS `student_first_name`,
 1 AS `student_patronymic`,
 1 AS `student_address`,
 1 AS `student_year_of_birth`,
 1 AS `student_passport`,
 1 AS `date`,
 1 AS `score`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `people` (
  `id` int NOT NULL AUTO_INCREMENT,
  `last_name` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `patronymic` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (1,'Денисов','Юстиниан','Митрофанович'),(2,'Новиков','Мирон','Богуславович'),(3,'Филиппов','Кондратий','Николаевич'),(4,'Савин','Геннадий','Филатович'),(5,'Лукин','Корнелий','Проклович'),(6,'Никитин','Семен','Григорьевич'),(7,'Соловьёв','Филипп','Альбертович'),(8,'Ширяев','Родион','Донатович'),(9,'Тихонов','Ипполит','Дамирович'),(10,'Одинцов','Аполлон','Тимофеевич'),(11,'Денисов','Юстиниан','Митрофанович'),(12,'Новиков','Мирон','Богуславович'),(13,'Филиппов','Кондратий','Николаевич'),(14,'Савин','Геннадий','Филатович'),(15,'Лукин','Корнелий','Проклович'),(16,'Никитин','Семен','Григорьевич'),(17,'Соловьёв','Филипп','Альбертович'),(18,'Ширяев','Родион','Донатович'),(19,'Тихонов','Ипполит','Дамирович'),(20,'Одинцов','Аполлон','Тимофеевич');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_person` int NOT NULL,
  `address` varchar(160) NOT NULL,
  `year_of_birth` int NOT NULL,
  `passport` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `passport_UNIQUE` (`passport`),
  KEY `fk_stundets_people_idx` (`id_person`),
  CONSTRAINT `fk_stundets_people` FOREIGN KEY (`id_person`) REFERENCES `people` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,6,'г.Донецк, ул.Ильича, 18/3',1990,'44773328'),(2,7,'г.Донецк, ул.Артёма, 3/12',1996,'33790923'),(3,8,'г.Донецк, ул.Петровского, 64/8',1998,'13721490'),(4,9,'г.Донецк, ул.Крамарчука, 32/4',1993,'29770384'),(5,10,'г.Донецк, ул.Ильича, 12/6',1994,'94535144'),(6,11,'г.Донецк, ул.Крамарчука, 53/1',1990,'17134204'),(7,12,'г.Донецк, ул.Артёма, 78/5',2002,'60796113'),(8,13,'г.Донецк, ул.Петровского, 43/23',2003,'81483503'),(9,14,'г.Донецк, ул.Артёма, 12/65',1994,'80847926'),(10,15,'г.Донецк, ул.Петровского, 48/4',1994,'34754110'),(11,16,'г.Донецк, ул.Ильича, 46/45',1999,'12930653'),(12,17,'г.Донецк, ул.Петровского, 56/34',1999,'68446173'),(13,18,'г.Донецк, ул.Крамарчука, 34/12',2000,'66546237'),(14,19,'г.Донецк, ул.Артёма, 65/4',2000,'56123465'),(15,20,'г.Донецк, ул.Ильича, 23/23',1999,'13653354');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `students_view`
--

DROP TABLE IF EXISTS `students_view`;
/*!50001 DROP VIEW IF EXISTS `students_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `students_view` AS SELECT 
 1 AS `id`,
 1 AS `last_name`,
 1 AS `first_name`,
 1 AS `patronymic`,
 1 AS `address`,
 1 AS `year_of_birth`,
 1 AS `passport`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'exam_results_goriachev'
--

--
-- Dumping routines for database 'exam_results_goriachev'
--
/*!50003 DROP PROCEDURE IF EXISTS `query01_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `query01_procedure`(in last_name varchar(45), in passport varchar(20))
begin
    select * from students_view where students_view.passport like passport and students_view.last_name like last_name;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `query02_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `query02_procedure`(in surname varchar(45))
begin
    select * from exams_view where exams_view.examiner_last_name like surname;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `query03_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `query03_procedure`(in passport varchar(20))
begin
    select * from exams_view where exams_view.student_passport like passport;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `query04_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `query04_procedure`(passport nvarchar(20))
begin
    select * from students_view where students_view.passport like passport;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `query05_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `query05_procedure`()
begin
    select * from exams_view;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `query06_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `query06_procedure`()
begin
    select students_view.year_of_birth,
           count(*) as amount
    from students_view
    group by students_view.year_of_birth;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `query07_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `query07_procedure`()
begin
    select exams_view.`date`,
           min(exams_view.score) as min_score,
           avg(exams_view.score) as avg_score,
           max(exams_view.score) as max_score,
           count(*)              as amount
    from exams_view
    group by exams_view.`date`;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `query08_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `query08_procedure`(in id_exam_type int, in id_examiner int, in id_student int, in `date` date, in score int)
BEGIN
	insert into exams
		(id_exam_type, id_examiner, id_student, `date`, score)
    values
		(id_exam_type, id_examiner, id_student, `date`, score);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `query09_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `query09_procedure`(in id int, in id_exam_type int, in id_examiner int, in id_student int, in `date` date, in score int)
BEGIN
	update exams
    set 
		exams.id_exam_type = id_exam_type,
        exams.id_examiner = id_examiner,
        exams.id_student = id_student,
        exams.`date` = `date`,
        exams.score = score
	where
		exams.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `query10_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `query10_procedure`(in id int)
BEGIN
	delete from exams
    where exams.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `exam_types_view`
--

/*!50001 DROP VIEW IF EXISTS `exam_types_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `exam_types_view` AS select `exam_types`.`id` AS `id`,`academic_subjects`.`name` AS `academic_subject_name`,`exam_types`.`name` AS `name` from (`exam_types` join `academic_subjects` on((`exam_types`.`id_academic_subject` = `academic_subjects`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `examiners_view`
--

/*!50001 DROP VIEW IF EXISTS `examiners_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `examiners_view` AS select `examiners`.`id` AS `id`,`people`.`last_name` AS `last_name`,`people`.`first_name` AS `first_name`,`people`.`patronymic` AS `patronymic`,`examiners`.`exam_fee` AS `exam_fee` from (`examiners` join `people` on((`examiners`.`id_person` = `people`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `exams_view`
--

/*!50001 DROP VIEW IF EXISTS `exams_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `exams_view` AS select `exams`.`id` AS `id`,`exam_types_view`.`academic_subject_name` AS `academic_subject_name`,`exam_types_view`.`id` AS `exam_type_id`,`exam_types_view`.`name` AS `exam_type_name`,`examiners_view`.`id` AS `examiner_id`,`examiners_view`.`last_name` AS `examiner_last_name`,`examiners_view`.`first_name` AS `examiner_first_name`,`examiners_view`.`patronymic` AS `examiner_patronymic`,`examiners_view`.`exam_fee` AS `examiner_exam_fee`,`students_view`.`id` AS `student_id`,`students_view`.`last_name` AS `student_last_name`,`students_view`.`first_name` AS `student_first_name`,`students_view`.`patronymic` AS `student_patronymic`,`students_view`.`address` AS `student_address`,`students_view`.`year_of_birth` AS `student_year_of_birth`,`students_view`.`passport` AS `student_passport`,`exams`.`date` AS `date`,`exams`.`score` AS `score` from (((`exams` join `exam_types_view` on((`exams`.`id_exam_type` = `exam_types_view`.`id`))) join `examiners_view` on((`exams`.`id_examiner` = `examiners_view`.`id`))) join `students_view` on((`exams`.`id_student` = `students_view`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `students_view`
--

/*!50001 DROP VIEW IF EXISTS `students_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `students_view` AS select `students`.`id` AS `id`,`people`.`last_name` AS `last_name`,`people`.`first_name` AS `first_name`,`people`.`patronymic` AS `patronymic`,`students`.`address` AS `address`,`students`.`year_of_birth` AS `year_of_birth`,`students`.`passport` AS `passport` from (`students` join `people` on((`students`.`id_person` = `people`.`id`))) */;
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

-- Dump completed on 2023-02-02 22:47:36

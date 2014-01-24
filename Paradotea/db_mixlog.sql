CREATE DATABASE  IF NOT EXISTS `db_mixlog` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_mixlog`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: db_mixlog
-- ------------------------------------------------------
-- Server version	5.6.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `critics`
--

DROP TABLE IF EXISTS `critics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `critics` (
  `ID` int(11) DEFAULT NULL,
  `Stars` int(11) DEFAULT NULL,
  `Review_Text` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `critics`
--

LOCK TABLES `critics` WRITE;
/*!40000 ALTER TABLE `critics` DISABLE KEYS */;
INSERT INTO `critics` VALUES (3,3,'poli kalo kai kali timi'),(1,1,'poli palio distixos'),(1,1,'πολυ παλιο δυστηχως'),(2,2,'poli argo'),(2,3,'mapa kai auto'),(3,4,'metrio'),(4,5,'aristo!'),(4,4,'akrivo para poli alla aksizei'),(5,1,'to pio sapio kinito'),(5,4,'mou exei pesei apeires fores kai den nio8ei'),(6,3,'kaloutsiko'),(6,4,'mou exei kratisei mia xara'),(7,4,'poli kalo'),(7,1,'den me exei eksipiretisei'),(8,5,'to pira se timi eukairias'),(8,1,'pio akrivo pe8aineis');
/*!40000 ALTER TABLE `critics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `Full_name` varchar(40) DEFAULT NULL,
  `ID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('Galaxy_S',1),('Galaxy_S2',2),('Galaxy_S3',3),('Galaxy_S4',4),('IPhone4',5),('IPhone4s',6),('IPhone5',7),('IPhone5s',8);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `Username` varchar(40) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `rights` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Grigoris','1990','User'),('Lefteris','1991','User'),('Pantelis','1992','User'),('Giannis','1982','Administrator');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-24 18:27:21

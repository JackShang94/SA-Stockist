CREATE DATABASE  IF NOT EXISTS `ims-sa45team3` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ims-sa45team3`;
-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
--
-- Host: localhost    Database: ims-sa45team3
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `partNumber` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(45) NOT NULL,
  `unitPrice` decimal(10,0) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `dimension` varchar(20) DEFAULT NULL,
  `reorderPoint` int(11) DEFAULT NULL,
  `minOrder` int(11) DEFAULT NULL,
  `supplierID` int(11) NOT NULL,
  `shelfLocation` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`partNumber`),
  UNIQUE KEY `productID_UNIQUE` (`partNumber`),
  KEY `supplierID_idx` (`supplierID`),
  CONSTRAINT `supplierID` FOREIGN KEY (`supplierID`) REFERENCES `suppliers` (`supplierID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1025 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1000,'SP1 Tyres',100,25,'Sport Tyres','yellow','',10,5,1,'3A'),(1001,'RD1 Tyres',80,20,'Road Tyres',NULL,NULL,10,5,2,'3B'),(1002,'Castrol1 EO',40,150,'Engine Oil (litre bottle)',NULL,NULL,50,25,7,'3C'),(1003,'Motul300 EO',45,132,'Engine Oil (litre bottle)',NULL,NULL,50,25,6,'3C'),(1010,'Subwoofer1000X',200,5,'Sound System',NULL,'15\"',5,10,3,'2A'),(1011,'Sports Spoiler',156,0,'Spoiler','White','54\"',5,10,3,'1A'),(1012,'Sports Spoiler',156,3,'Spoiler','Black','54\"',5,10,3,'1A'),(1013,'Sports Spoiler',156,11,'Spoiler','Red','54\"',5,10,3,'1A'),(1014,'Engine Block',899,12,'Engine Block',NULL,NULL,5,5,8,'4A'),(1015,'Sports Rims',124,16,'Sports Rims','Blue','16\"',10,8,1,'4B'),(1016,'Streetlegal Exhaust',300,17,'Exhaust system',NULL,NULL,14,10,4,'2A'),(1017,'Illegal Exhaust',600,7,'Exhaust system (illegal)',NULL,NULL,14,10,4,'2A'),(1018,'Xeon Headlight',75,24,'Headlights',NULL,NULL,15,10,4,'1A'),(1019,'LED Headlight',65,25,'Headlights',NULL,NULL,15,10,4,'1A'),(1021,'Budget rims',100,24,'Tyre rims','Plain','54\"',12,6,2,'3B'),(1022,'Airconditioner System',300,10,'Air-con',NULL,NULL,8,5,5,'1A');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reorder details`
--

DROP TABLE IF EXISTS `reorder details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reorder details` (
  `reorderID` int(11) NOT NULL,
  `partNumber` int(11) NOT NULL,
  `orderQuantity` int(11) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`reorderID`,`partNumber`),
  KEY `partNumber_idx` (`partNumber`),
  CONSTRAINT `partNumber` FOREIGN KEY (`partNumber`) REFERENCES `product` (`partNumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reorderID` FOREIGN KEY (`reorderID`) REFERENCES `reorders` (`reorderID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reorder details`
--

LOCK TABLES `reorder details` WRITE;
/*!40000 ALTER TABLE `reorder details` DISABLE KEYS */;
INSERT INTO `reorder details` VALUES (1,1000,20,''),(1,1001,20,''),(2,1010,20,NULL),(2,1011,30,NULL),(2,1014,30,NULL);
/*!40000 ALTER TABLE `reorder details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reorders`
--

DROP TABLE IF EXISTS `reorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reorders` (
  `reorderID` int(11) NOT NULL AUTO_INCREMENT,
  `staffID` int(11) NOT NULL,
  `dateOrdered` date DEFAULT NULL,
  PRIMARY KEY (`reorderID`),
  KEY `staffIDx_idx` (`staffID`),
  CONSTRAINT `staffID2` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reorders`
--

LOCK TABLES `reorders` WRITE;
/*!40000 ALTER TABLE `reorders` DISABLE KEYS */;
INSERT INTO `reorders` VALUES (1,8,'2017-08-08'),(2,7,'2017-12-01');
/*!40000 ALTER TABLE `reorders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `staffID` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `contactNumber` int(11) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`staffID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'123456','Boyka','Mechanic',93657813,1),(2,'123456','Jack','Mechanic',97235416,1),(3,'123456','Wei Han','Mechanic',98753251,1),(4,'123456','Alex','Mechanic',97534265,1),(5,'123456','Micheal','Mechanic',96543265,1),(6,'123456','Thiri','Admin',96345265,1),(7,'123456','Hnin2','Admin',76358172,1),(8,'123456','Delicia','Admin',98625172,0),(9,'123456','Hong Hai','Mechanic',96523182,0),(10,'123456','TonyStark','Mechanic',78451245,1);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suppliers` (
  `supplierID` int(11) NOT NULL AUTO_INCREMENT,
  `supplierName` varchar(45) NOT NULL,
  `contactNumber` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `contactPerson` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`supplierID`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'Castrol',45678912,'Bukit Batok 21','Michael'),(2,'Michellin Tyre',67254871,'98 West Coast Ferry Rd','Ah Yong'),(3,'Automobile Accessories',63746973,'891 Ang Mo Kio Ind Park A','Ah Chan'),(4,'AutoShack Pte Ltd',62719312,'77 Hougang St 11','Ah Boon'),(5,'ClarkandToyama',78451241,'56 Toa Payoh','Jeff Poh'),(6,'ah beng unlimited',67252491,'hougang ave 1','ah seng'),(7,'Castrol Racing',65423816,'23 Joo Koon Avenue','Ah Leow'),(8,'Mitsubishi Corp',67251921,'11 Tai Seng Avenue','Ah Mui');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usage details`
--

DROP TABLE IF EXISTS `usage details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usage details` (
  `recordID` int(11) NOT NULL,
  `partNumber` int(11) NOT NULL,
  `usedQuantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`recordID`,`partNumber`),
  KEY `partNumber_idx` (`partNumber`),
  CONSTRAINT `partNumber2` FOREIGN KEY (`partNumber`) REFERENCES `product` (`partNumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `recordID2` FOREIGN KEY (`recordID`) REFERENCES `usage records` (`recordID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usage details`
--

LOCK TABLES `usage details` WRITE;
/*!40000 ALTER TABLE `usage details` DISABLE KEYS */;
INSERT INTO `usage details` VALUES (1,1010,2),(1,1011,2),(2,1012,3),(2,1013,4),(3,1014,3),(3,1015,3),(3,1016,3),(4,1001,3),(4,1002,3),(4,1017,3),(5,1017,5),(6,1017,8),(7,1012,8),(8,1018,1),(9,1010,2),(10,1010,7),(11,1011,12);
/*!40000 ALTER TABLE `usage details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usage records`
--

DROP TABLE IF EXISTS `usage records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usage records` (
  `recordID` int(11) NOT NULL AUTO_INCREMENT,
  `staffID` int(11) NOT NULL,
  `usageDate` date DEFAULT NULL,
  `customerName` varchar(50) DEFAULT NULL,
  `contactNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`recordID`),
  KEY `staffID_idx` (`staffID`),
  CONSTRAINT `staffID` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usage records`
--

LOCK TABLES `usage records` WRITE;
/*!40000 ALTER TABLE `usage records` DISABLE KEYS */;
INSERT INTO `usage records` VALUES (1,1,'2017-06-29','Ben Tan',97351723),(2,2,'2017-08-30','Benjamin Lee',97537123),(3,3,'2017-09-12','Brandon Tan',91234714),(4,4,'2017-08-24','Brandon Lau',92347273),(5,1,'2017-12-13','jeff',78451245),(6,1,'2017-12-13','Jeff',84578120),(7,1,'2017-12-13','gina',12345678),(8,1,'2017-12-14','wes',45678912),(9,1,'2017-12-12','oppa',45678912),(10,1,'2017-12-06','wes',45678912),(11,1,'2017-12-13','mike',123456789);
/*!40000 ALTER TABLE `usage records` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-13 14:39:47

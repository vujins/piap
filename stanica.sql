-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: localhost    Database: stanica
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.18.04.1

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
-- Table structure for table `gradska`
--

DROP TABLE IF EXISTS `gradska`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gradska` (
  `linija` int(11) NOT NULL,
  `red_voznje` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKqwkc4b16jd11l2xaocd26yf82` FOREIGN KEY (`id`) REFERENCES `linija` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gradska`
--

LOCK TABLES `gradska` WRITE;
/*!40000 ALTER TABLE `gradska` DISABLE KEYS */;
INSERT INTO `gradska` VALUES (23,'nikad',1),(52,'ponekad',2);
/*!40000 ALTER TABLE `gradska` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `korisnik` (
  `username` varchar(255) NOT NULL,
  `admin` bit(1) DEFAULT b'0',
  `adresa` varchar(255) DEFAULT NULL,
  `grad` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `odobren` bit(1) DEFAULT b'0',
  `opstina` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `rodjendan` datetime DEFAULT NULL,
  `telefon` varchar(255) DEFAULT NULL,
  `zaposlen` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES ('milena',_binary '\0','Borova 1','Beograd','Milena',_binary '\0','Rakovica','milena123','Stevanovic','1996-06-26 00:00:00','065/8266996',2),('strahinja',_binary '','Tamiska 20','Zrenjanin','Strahinja',_binary '','Zrenjanin','strahinja123','Vujin','1995-02-15 00:00:00','062/1981-953',1);
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik_rezervacija`
--

DROP TABLE IF EXISTS `korisnik_rezervacija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `korisnik_rezervacija` (
  `korisnik_username` varchar(255) NOT NULL,
  `rezervacija_set_id` bigint(20) NOT NULL,
  PRIMARY KEY (`korisnik_username`,`rezervacija_set_id`),
  KEY `FK42ipl4cj5dl6e2es63dd4l9ri` (`rezervacija_set_id`),
  CONSTRAINT `FK42ipl4cj5dl6e2es63dd4l9ri` FOREIGN KEY (`rezervacija_set_id`) REFERENCES `medjugradska` (`id`),
  CONSTRAINT `FKhldumayrw8vevy4c85clm34oi` FOREIGN KEY (`korisnik_username`) REFERENCES `korisnik` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik_rezervacija`
--

LOCK TABLES `korisnik_rezervacija` WRITE;
/*!40000 ALTER TABLE `korisnik_rezervacija` DISABLE KEYS */;
/*!40000 ALTER TABLE `korisnik_rezervacija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linija`
--

DROP TABLE IF EXISTS `linija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linija` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `odrediste_id` bigint(20) NOT NULL,
  `polaziste_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjvvmh3tnpl202yu9gr059bw03` (`odrediste_id`),
  KEY `FKqjhbu9y1yi6dumvrdr2nlywqe` (`polaziste_id`),
  CONSTRAINT `FKjvvmh3tnpl202yu9gr059bw03` FOREIGN KEY (`odrediste_id`) REFERENCES `stajaliste` (`id`),
  CONSTRAINT `FKqjhbu9y1yi6dumvrdr2nlywqe` FOREIGN KEY (`polaziste_id`) REFERENCES `stajaliste` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linija`
--

LOCK TABLES `linija` WRITE;
/*!40000 ALTER TABLE `linija` DISABLE KEYS */;
INSERT INTO `linija` VALUES (1,1,2),(2,1,3);
/*!40000 ALTER TABLE `linija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linija_stajaliste`
--

DROP TABLE IF EXISTS `linija_stajaliste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linija_stajaliste` (
  `linija_id` bigint(20) NOT NULL,
  `stajaliste_id` bigint(20) NOT NULL,
  PRIMARY KEY (`linija_id`,`stajaliste_id`),
  KEY `FKl14x8ugjfrbwre487pealgp41` (`stajaliste_id`),
  CONSTRAINT `FKh21q8lvlkxnyn1n5vbnvwe47r` FOREIGN KEY (`linija_id`) REFERENCES `linija` (`id`),
  CONSTRAINT `FKl14x8ugjfrbwre487pealgp41` FOREIGN KEY (`stajaliste_id`) REFERENCES `stajaliste` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linija_stajaliste`
--

LOCK TABLES `linija_stajaliste` WRITE;
/*!40000 ALTER TABLE `linija_stajaliste` DISABLE KEYS */;
INSERT INTO `linija_stajaliste` VALUES (2,4),(1,5);
/*!40000 ALTER TABLE `linija_stajaliste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medjugradska`
--

DROP TABLE IF EXISTS `medjugradska`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medjugradska` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medjugradska`
--

LOCK TABLES `medjugradska` WRITE;
/*!40000 ALTER TABLE `medjugradska` DISABLE KEYS */;
/*!40000 ALTER TABLE `medjugradska` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stajaliste`
--

DROP TABLE IF EXISTS `stajaliste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stajaliste` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stajaliste`
--

LOCK TABLES `stajaliste` WRITE;
/*!40000 ALTER TABLE `stajaliste` DISABLE KEYS */;
INSERT INTO `stajaliste` VALUES (1,'Beograd'),(2,'Novi Sad'),(3,'Zrenjanin'),(4,'Perlez'),(5,'Batajnica');
/*!40000 ALTER TABLE `stajaliste` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-06 13:40:20

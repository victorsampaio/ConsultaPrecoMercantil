-- MySQL dump 10.11
--
-- Host: localhost    Database: scmp
-- ------------------------------------------------------
-- Server version	5.0.67-community-nt

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
-- Table structure for table `tbclientes`
--

DROP TABLE IF EXISTS `tbclientes`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `tbclientes` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `numero` varchar(6) NOT NULL,
  `cep` varchar(10) default NULL,
  `telefone` varchar(14) default NULL,
  `dtnasc` date NOT NULL,
  `renda` float NOT NULL,
  `cpf` varchar(14) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `tbclientes`
--

LOCK TABLES `tbclientes` WRITE;
/*!40000 ALTER TABLE `tbclientes` DISABLE KEYS */;
INSERT INTO `tbclientes` VALUES (1,'Ulisses','Rua Azevedo Bolão','1995','60.456-630','(85) 8662-6412','2008-05-26',300,'000.000.000-00'),(2,'Guedo','Rua Conego Penafort','415','60.455-620','(85) 8657-6603','1982-05-05',200,'924.501.643-91');
/*!40000 ALTER TABLE `tbclientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbmercantil`
--

DROP TABLE IF EXISTS `tbmercantil`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `tbmercantil` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(45) NOT NULL,
  `cnpj` varchar(18) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `numero` varchar(6) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `telefone` varchar(14) NOT NULL,
  `obs` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `tbmercantil`
--

LOCK TABLES `tbmercantil` WRITE;
/*!40000 ALTER TABLE `tbmercantil` DISABLE KEYS */;
INSERT INTO `tbmercantil` VALUES (1,'Pão de açucar','00.000.000/0000-01','Av Bezerra de Menezes','500','60.000-000','(85) 3256-1789',''),(2,'Center Box','00.000.000/0000-02','Pe. Guerra','323','60.455-620','(85) 3456-2890','');
/*!40000 ALTER TABLE `tbmercantil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbmovimentos`
--

DROP TABLE IF EXISTS `tbmovimentos`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `tbmovimentos` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `id_produto` int(10) unsigned NOT NULL,
  `data` date NOT NULL,
  `obs` varchar(45) NOT NULL,
  `preco` float NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_produto` (`id_produto`),
  CONSTRAINT `FK_produto` FOREIGN KEY (`id_produto`) REFERENCES `tbprodutos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `tbmovimentos`
--

LOCK TABLES `tbmovimentos` WRITE;
/*!40000 ALTER TABLE `tbmovimentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbmovimentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbprodutos`
--

DROP TABLE IF EXISTS `tbprodutos`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `tbprodutos` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(45) NOT NULL,
  `especificacao` varchar(45) NOT NULL,
  `preco` float NOT NULL,
  `obs` varchar(45) NOT NULL,
  `id_mercantil` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_mercantil` (`id_mercantil`),
  CONSTRAINT `FK_mercantil` FOREIGN KEY (`id_mercantil`) REFERENCES `tbmercantil` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `tbprodutos`
--

LOCK TABLES `tbprodutos` WRITE;
/*!40000 ALTER TABLE `tbprodutos` DISABLE KEYS */;
INSERT INTO `tbprodutos` VALUES (1,'Arroz','Branco Tipo 1',2.5,'',1),(2,'Feijão','Carioca',3.8,'',1),(3,'Farinha','Mandioca',1.5,'',2),(4,'Arroz','Branco Tipo 1',2.3,'',2);
/*!40000 ALTER TABLE `tbprodutos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbusuarios`
--

DROP TABLE IF EXISTS `tbusuarios`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `tbusuarios` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `tbusuarios`
--

LOCK TABLES `tbusuarios` WRITE;
/*!40000 ALTER TABLE `tbusuarios` DISABLE KEYS */;
INSERT INTO `tbusuarios` VALUES (1,'Administrador','adm','adm');
/*!40000 ALTER TABLE `tbusuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-11-15 21:09:50

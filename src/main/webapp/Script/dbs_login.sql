-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: dbs_login
-- ------------------------------------------------------
-- Server version	5.7.33-log

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
-- Table structure for table `tbl_roles`
--

DROP TABLE IF EXISTS `tbl_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_roles` (
  `rol_rol_id` int(11) NOT NULL AUTO_INCREMENT,
  `rol_nombre` varchar(45) DEFAULT NULL,
  `rol_descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rol_rol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_roles`
--

LOCK TABLES `tbl_roles` WRITE;
/*!40000 ALTER TABLE `tbl_roles` DISABLE KEYS */;
INSERT INTO `tbl_roles` VALUES (1,'Administrador','Controla Usuario, Inventario'),(2,'Cliente','Solicita pedidos'),(3,'Vendedor','Facturar ventas'),(4,'Usuario','Datos personales');
/*!40000 ALTER TABLE `tbl_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_usuario` (
  `usu_usuario_id` int(11) NOT NULL AUTO_INCREMENT,
  `usu_tipo_documento` varchar(45) DEFAULT NULL,
  `usu_documento` varchar(45) DEFAULT NULL,
  `usu_nombres` varchar(45) DEFAULT NULL,
  `usu_apellidos` varchar(45) DEFAULT NULL,
  `usu_correo` varchar(45) DEFAULT NULL,
  `usu_clave` varchar(8) DEFAULT NULL,
  `usu_estado` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`usu_usuario_id`),
  UNIQUE KEY `usu_correo_UNIQUE` (`usu_correo`),
  UNIQUE KEY `usu_documento_UNIQUE` (`usu_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
INSERT INTO `tbl_usuario` VALUES (1,'CC','10101010','Luis Emilio','Malagon','luism@misena.edu.co','1234',0),(4,'CC','10101011','David','Delgado','david@misena.edu.co','1234',1),(5,'CC','10101012','Andres','Hernandez','ahernandez@misena.edu.co','1234',1),(7,'CC','10101013','Daniel','Corzo','dcorzo@misena.edu.co','1234',1),(10,'Tarjeta de identidad','123456789','NombresUno','ApellidosUn','correouno@misena.edu.co','12345',1),(13,'Cedula','1234566','NombresDos','ApellidosDo','correodos@misena.edu.co','123456',1),(15,'Cedula','1234577','NombresTres','ApellidosTres','correotres@misena.edu.co','123456',1),(16,'Cedula','7999666','jose','sarta','josarta@gmail.com','123456',1);
/*!40000 ALTER TABLE `tbl_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario_has_roles`
--

DROP TABLE IF EXISTS `tbl_usuario_has_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_usuario_has_roles` (
  `fk_usu_ususario_id` int(11) DEFAULT NULL,
  `fk_rol_rol_id` int(11) DEFAULT NULL,
  KEY `fk_usu_usuario_idx` (`fk_usu_ususario_id`),
  KEY `fk_rol_rol_idx` (`fk_rol_rol_id`),
  CONSTRAINT `fk_rol_rol` FOREIGN KEY (`fk_rol_rol_id`) REFERENCES `tbl_roles` (`rol_rol_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usu_usuario` FOREIGN KEY (`fk_usu_ususario_id`) REFERENCES `tbl_usuario` (`usu_usuario_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario_has_roles`
--

LOCK TABLES `tbl_usuario_has_roles` WRITE;
/*!40000 ALTER TABLE `tbl_usuario_has_roles` DISABLE KEYS */;
INSERT INTO `tbl_usuario_has_roles` VALUES (1,1),(1,4),(4,4),(5,4),(7,3);
/*!40000 ALTER TABLE `tbl_usuario_has_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dbs_login'
--

--
-- Dumping routines for database 'dbs_login'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-02 20:09:28

-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: solicitud_tramites
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `grupos`
--

DROP TABLE IF EXISTS `grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupos` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `id_grupo` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `codigo_col` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos`
--

LOCK TABLES `grupos` WRITE;
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inv_grupos`
--

DROP TABLE IF EXISTS `inv_grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inv_grupos` (
  `id_grupos` int DEFAULT NULL,
  `id_investigadores` int DEFAULT NULL,
  KEY `id_grupos_idx` (`id_grupos`),
  KEY `id_investigadores_idx` (`id_investigadores`),
  CONSTRAINT `id_grupos` FOREIGN KEY (`id_grupos`) REFERENCES `grupos` (`codigo`),
  CONSTRAINT `id_investigadores` FOREIGN KEY (`id_investigadores`) REFERENCES `investigadores` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inv_grupos`
--

LOCK TABLES `inv_grupos` WRITE;
/*!40000 ALTER TABLE `inv_grupos` DISABLE KEYS */;
/*!40000 ALTER TABLE `inv_grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `investigadores`
--

DROP TABLE IF EXISTS `investigadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `investigadores` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `id_investigador` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefono` int NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investigadores`
--

LOCK TABLES `investigadores` WRITE;
/*!40000 ALTER TABLE `investigadores` DISABLE KEYS */;
/*!40000 ALTER TABLE `investigadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precotizaciones`
--

DROP TABLE IF EXISTS `precotizaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `precotizaciones` (
  `codigo` int NOT NULL,
  `codigo_prov` int NOT NULL,
  `codigo_sol` int NOT NULL,
  `valor` decimal(10,0) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `codigo_sol_idx` (`codigo_sol`),
  KEY `codigo_prov_idx` (`codigo_prov`),
  CONSTRAINT `codigo_prov` FOREIGN KEY (`codigo_prov`) REFERENCES `proveedores` (`codigo`),
  CONSTRAINT `codigo_sol` FOREIGN KEY (`codigo_sol`) REFERENCES `sol_tramites` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precotizaciones`
--

LOCK TABLES `precotizaciones` WRITE;
/*!40000 ALTER TABLE `precotizaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `precotizaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `id_proveedor` int DEFAULT NULL,
  `nit` int DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (25,11,98765421,'esto es un put',54831);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sol_tramites`
--

DROP TABLE IF EXISTS `sol_tramites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sol_tramites` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `id_gpp` int NOT NULL,
  `id_inv` int NOT NULL,
  `codigo_pom` int DEFAULT NULL,
  `necesidad` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `valor` decimal(10,0) NOT NULL,
  `verificacion` varchar(45) NOT NULL,
  `observaciones` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `id_grupos_idx` (`id_gpp`),
  KEY `id_inv_idx` (`id_inv`),
  CONSTRAINT `id_gpp` FOREIGN KEY (`id_gpp`) REFERENCES `grupos` (`codigo`),
  CONSTRAINT `id_inv` FOREIGN KEY (`id_inv`) REFERENCES `investigadores` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sol_tramites`
--

LOCK TABLES `sol_tramites` WRITE;
/*!40000 ALTER TABLE `sol_tramites` DISABLE KEYS */;
/*!40000 ALTER TABLE `sol_tramites` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-09 16:09:04

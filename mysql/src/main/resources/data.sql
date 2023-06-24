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

DROP TABLE IF EXISTS portalAyuntDB.file_palabras_clave;
DROP TABLE IF EXISTS portalAyuntDB.files;
-- Creación de la tabla 'productores'
DROP TABLE IF EXISTS portalAyuntDB.productores;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE portalAyuntDB.productores (
  id CHAR(36) NOT NULL UNIQUE,
  nif VARCHAR(9) NOT NULL UNIQUE,
  nombre VARCHAR(50) NOT NULL,
  tipo ENUM('fisica', 'juridica') NOT NULL,
  estado ENUM('pendiente', 'activo', 'inactivo') NOT NULL,
  cuota INT NOT NULL,
  email VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Creación de la tabla 'validadores'

DROP TABLE IF EXISTS portalAyuntDB.validadores;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE portalAyuntDB.validadores (
  id CHAR(36) NOT NULL UNIQUE,
  nombre VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Creación de la tabla 'files'
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE portalAyuntDB.files (
  id CHAR(36) NOT NULL UNIQUE,
  fecha_creacion DATE NOT NULL,
  titulo VARCHAR(255) NOT NULL,
  descripcion TEXT,
  tamano INT NOT NULL,
  previsualizaciones INT NOT NULL,
  descargas INT NOT NULL,
  estado ENUM('pendiente', 'activo') NOT NULL,
  fk_productor CHAR(36),
  fk_validador CHAR(36),
  PRIMARY KEY (id),
  FOREIGN KEY (fk_productor) REFERENCES portalAyuntDB.productores (id),
  FOREIGN KEY (fk_validador) REFERENCES portalAyuntDB.validadores (id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Creación de la tabla 'file_palabrasClave'
CREATE TABLE portalAyuntDB.file_palabras_clave (
  file_id CHAR(36) NOT NULL,
  palabras_clave VARCHAR(255) NOT NULL,
  PRIMARY KEY (file_id, palabras_clave),
  FOREIGN KEY (file_id) REFERENCES portalAyuntDB.files (id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Inserción de datos en la tabla 'productores'

LOCK TABLES portalAyuntDB.productores WRITE;
/*!40000 ALTER TABLE productores DISABLE KEYS */;
INSERT INTO portalAyuntDB.productores (id, nif, nombre, tipo, estado, cuota, email, password)
VALUES
  ('550e8400-e29b-41d4-a716-446655440000', '123456789', 'John Doe', 'fisica', 'pendiente', 1, 'john.doe@example.com', '$2a$10$TdfJZFO6Y1kyCU4IZl8wYOtWpeogzvSYkI0NgvXrsfRe9mVi6i4dm'), -- password1
  ('c5f86a9f-5c8f-47ad-89f6-446655440000', '987654321', 'Alice Smith', 'juridica', 'activo', 0, 'alice.smith@example.com', '$2a$10$7V3z5z9q5CqCwJq/7nnXxeAx14vDzgGIMXHm7ZM85at3l59zE/FwW'),
  ('8c55ec4b-80c2-4c3a-b0df-446655440000', '345678912', 'Michael Johnson', 'fisica', 'activo', 5, 'michael.johnson@example.com', '$2a$10$BRqXaSEuxmrlFdw7p0snzuRD6eFzFbJ2Zit.A4n15kZvMkJ5A02bW'),
  ('f63252d2-45d3-40c9-80e5-446655440000', '789123456', 'Emily Davis', 'juridica', 'pendiente', 2, 'emily.davis@example.com', '$2a$10$jDD1YusUqRL9pg5IXaJX6uFJcYNQAKoHNfqTo2hXVIIb.WWj0m0XW'),
  ('1c3274bc-b4d9-4cfd-b0e9-446655440000', '234567891', 'Daniel Wilson', 'fisica', 'activo', 1, 'daniel.wilson@example.com', '$2a$10$LdPMKT1F0IYLoQmJ4e7yqOh0twfMnWRlzeTVyIJBDG9dMUbLA3AqW'),
  ('b70669c6-7f9e-4ab0-b53f-446655440000', '678912345', 'Olivia Brown', 'juridica', 'inactivo', 2, 'olivia.brown@example.com', '$2a$10$q5XrGZwV1wt2I2J5sWeBCOxjsLmWJq7i27zn1eEpBPrx6Xx.7gSWC'),
  ('ed679d07-4417-4e76-9ff9-446655440000', '891234567', 'James Taylor', 'fisica', 'activo', 6, 'james.taylor@example.com', '$2a$10$6M9FqJ4mY2mm51eJYl.k3Oz62rr/Qzns1I1vN9pWnqGW9EqnH0oRa'),
  ('b4300a45-2433-4b8b-bf04-446655440000', '456789123', 'Sophia Martinez', 'juridica', 'pendiente', 4, 'sophia.martinez@example.com', '$2a$10$dhdI.xIggA0nqIhtWb8v5e0UkzXzVl3hJ7vBdqTnUg2E6j.AMK81q'),
  ('e7423ef2-1f01-4a5e-9e48-446655440000', '912345678', 'Jacob Anderson', 'fisica', 'activo', 9, 'jacob.anderson@example.com', '$2a$10$yq3d5M3do.EamVstirWTTOib6h.2wQ0IQt62C5FPOX8yINu1.WWDe'),
  ('e7c4f605-8a36-4a07-93d5-446655440000', '567891234', 'Mia Clark', 'juridica', 'inactivo', 3, 'mia.clark@example.com', '$2a$10$FOhG2LQCKrEp36Cf2ZSnbuvHqM58zqT47Fq/u4P.3XrkMef2qC94m'); -- password10

/*!40000 ALTER TABLE productores ENABLE KEYS */;
UNLOCK TABLES;

-- Inserción de datos en la tabla 'validadores'

LOCK TABLES portalAyuntDB.validadores WRITE;
/*!40000 ALTER TABLE validadores DISABLE KEYS */;
INSERT INTO portalAyuntDB.validadores (id, nombre, email, password)
VALUES
  ('550e8400-e29b-41d4-a716-446655440000', 'John Doe', 'john.doe@example.com', '$2a$10$TdfJZFO6Y1kyCU4IZl8wYOtWpeogzvSYkI0NgvXrsfRe9mVi6i4dm'), -- password1
  ('c5f86a9f-5c8f-47ad-89f6-446655440000', 'Alice Smith', 'alice.smith@example.com', '$2a$10$7V3z5z9q5CqCwJq/7nnXxeAx14vDzgGIMXHm7ZM85at3l59zE/FwW'), --password2
  ('8c55ec4b-80c2-4c3a-b0df-446655440000', 'Michael Johnson', 'michael.johnson@example.com', '$2a$10$BRqXaSEuxmrlFdw7p0snzuRD6eFzFbJ2Zit.A4n15kZvMkJ5A02bW'),
  ('f63252d2-45d3-40c9-80e5-446655440000', 'Emily Davis', 'emily.davis@example.com', '$2a$10$jDD1YusUqRL9pg5IXaJX6uFJcYNQAKoHNfqTo2hXVIIb.WWj0m0XW'),
  ('1c3274bc-b4d9-4cfd-b0e9-446655440000', 'Daniel Wilson', 'daniel.wilson@example.com', '$2a$10$LdPMKT1F0IYLoQmJ4e7yqOh0twfMnWRlzeTVyIJBDG9dMUbLA3AqW'),
  ('b70669c6-7f9e-4ab0-b53f-446655440000', 'Olivia Brown', 'olivia.brown@example.com', '$2a$10$q5XrGZwV1wt2I2J5sWeBCOxjsLmWJq7i27zn1eEpBPrx6Xx.7gSWC'),
  ('ed679d07-4417-4e76-9ff9-446655440000', 'James Taylor', 'james.taylor@example.com', '$2a$10$6M9FqJ4mY2mm51eJYl.k3Oz62rr/Qzns1I1vN9pWnqGW9EqnH0oRa'),
  ('b4300a45-2433-4b8b-bf04-446655440000', 'Sophia Martinez', 'sophia.martinez@example.com', '$2a$10$dhdI.xIggA0nqIhtWb8v5e0UkzXzVl3hJ7vBdqTnUg2E6j.AMK81q'),
  ('e7423ef2-1f01-4a5e-9e48-446655440000', 'Jacob Anderson', 'jacob.anderson@example.com', '$2a$10$yq3d5M3do.EamVstirWTTOib6h.2wQ0IQt62C5FPOX8yINu1.WWDe'),
  ('e7c4f605-8a36-4a07-93d5-446655440000', 'Mia Clark', 'mia.clark@example.com', '$2a$10$FOhG2LQCKrEp36Cf2ZSnbuvHqM58zqT47Fq/u4P.3XrkMef2qC94m'); -- password10

/*!40000 ALTER TABLE validadores ENABLE KEYS */;
UNLOCK TABLES;

-- Inserción de datos en la tabla 'ficheros'

LOCK TABLES portalAyuntDB.files WRITE;
/*!40000 ALTER TABLE ficheros DISABLE KEYS */;
INSERT INTO portalAyuntDB.files (id, fecha_creacion, titulo, descripcion, tamano, previsualizaciones, descargas, estado, fk_productor, fk_validador)
VALUES
  ('550e8400-e29b-41d4-a716-446655440000', NOW(), 'File 1', 'Description 1', 10,  500, 1000, 'pendiente', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440002'),
  ('c5f86a9f-5c8f-47ad-89f6-446655440000', '2023-06-02', 'File 2', 'Description 2', 5, 250, 500, 'activo', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440004'),
  ('8c55ec4b-80c2-4c3a-b0df-446655440000', '2023-06-03', 'File 3', 'Description 3', 8, 400, 800, 'pendiente', '550e8400-e29b-41d4-a716-446655440005', '550e8400-e29b-41d4-a716-446655440006'),
  ('f63252d2-45d3-40c9-80e5-446655440000', '2023-06-04', 'File 4', 'Description 4', 12, 600, 1200, 'activo', '550e8400-e29b-41d4-a716-446655440007', '550e8400-e29b-41d4-a716-446655440008'),
  ('1c3274bc-b4d9-4cfd-b0e9-446655440000', '2023-06-05', 'File 5', 'Description 5', 6, 300, 600, 'pendiente', '550e8400-e29b-41d4-a716-446655440009', '550e8400-e29b-41d4-a716-446655440010'),
  ('b70669c6-7f9e-4ab0-b53f-446655440000', '2023-06-06', 'File 6', 'Description 6', 15, 750, 1500, 'activo', '550e8400-e29b-41d4-a716-446655440011', '550e8400-e29b-41d4-a716-446655440012'),
  ('ed679d07-4417-4e76-9ff9-446655440000', '2023-06-07', 'File 7', 'Description 7', 9, 450, 900, 'pendiente', '550e8400-e29b-41d4-a716-446655440013', '550e8400-e29b-41d4-a716-446655440014'),
  ('b4300a45-2433-4b8b-bf04-446655440000', NOW(), 'File 8', 'Description 8', 7,  300, 600, 'activo', '550e8400-e29b-41d4-a716-446655440015', '550e8400-e29b-41d4-a716-446655440016'),
  ('e7423ef2-1f01-4a5e-9e48-446655440000', NOW(), 'File 9', 'Description 9', 11, 800, 400, 'pendiente', '550e8400-e29b-41d4-a716-446655440017', '550e8400-e29b-41d4-a716-446655440018'),
  ('e7c4f605-8a36-4a07-93d5-446655440000', NOW(), 'File 10', 'Description 10', 4, 450, 200, 'activo', '550e8400-e29b-41d4-a716-446655440019', '550e8400-e29b-41d4-a716-446655440020');

/*!40000 ALTER TABLE ficheros ENABLE KEYS */;
UNLOCK TABLES;

-- Inserción de datos en la tabla 'fichero_palabrasClave'
LOCK TABLES fichero_palabrasClave WRITE;
/*!40000 ALTER TABLE fichero_palabrasClave DISABLE KEYS */;
INSERT INTO portalAyuntDB.file_palabrasClave (file_id, palabras_clave)
VALUES
  ('550e8400-e29b-41d4-a716-446655440000', 'keyword1, keyword2'),
  ('c5f86a9f-5c8f-47ad-89f6-446655440000', 'keyword3, keyword4'),
  ('8c55ec4b-80c2-4c3a-b0df-446655440000', 'keyword5, keyword6'),
  ('f63252d2-45d3-40c9-80e5-446655440000', 'keyword7, keyword8'),
  ('1c3274bc-b4d9-4cfd-b0e9-446655440000', 'keyword9, keyword10'),
  ('b70669c6-7f9e-4ab0-b53f-446655440000', 'keyword11, keyword12'),
  ('ed679d07-4417-4e76-9ff9-446655440000', 'keyword13, keyword14'),
  ('b4300a45-2433-4b8b-bf04-446655440000', 'keyword15, keyword16'),
  ('e7423ef2-1f01-4a5e-9e48-446655440000', 'keyword17, keyword18'),
  ('e7c4f605-8a36-4a07-93d5-446655440000', 'keyword19, keyword20');

/*!40000 ALTER TABLE fichero_palabrasClave ENABLE KEYS */;
UNLOCK TABLES;
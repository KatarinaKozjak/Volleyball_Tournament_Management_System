/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 10.4.32-MariaDB : Database - odbojkaski_turnir
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`odbojkaski_turnir` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `odbojkaski_turnir`;

/*Table structure for table `analiticar` */

DROP TABLE IF EXISTS `analiticar`;

CREATE TABLE `analiticar` (
  `Id_Analiticar` bigint(10) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(30) NOT NULL,
  `Prezime` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Username` varchar(20) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_Analiticar`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `analiticar` */

insert  into `analiticar`(`Id_Analiticar`,`Ime`,`Prezime`,`Email`,`Username`,`Password`) values 
(1,'Katarina','Kozjak','kk@gmail.com','kaca','kaca'),
(2,'Nikola','Simic','nikis@gmail.com','nikola','simic');

/*Table structure for table `delegat` */

DROP TABLE IF EXISTS `delegat`;

CREATE TABLE `delegat` (
  `Id_Delegat` bigint(10) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(30) NOT NULL,
  `Prezime` varchar(30) NOT NULL,
  `Id_Mesto` bigint(10) NOT NULL,
  PRIMARY KEY (`Id_Delegat`),
  KEY `idMesto` (`Id_Mesto`),
  CONSTRAINT `idMesto` FOREIGN KEY (`Id_Mesto`) REFERENCES `mesto` (`Id_Mesto`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `delegat` */

insert  into `delegat`(`Id_Delegat`,`Ime`,`Prezime`,`Id_Mesto`) values 
(1,'Nenad','Kostic',1),
(2,'Mirjana','Zivkovic',1),
(3,'Luka','Markovic',2),
(4,'Milos','Zecevic',1),
(5,'Nikolina','Peric',2),
(6,'Aleksandra','Nikolic',2);

/*Table structure for table `igrac` */

DROP TABLE IF EXISTS `igrac`;

CREATE TABLE `igrac` (
  `Id_Igrac` bigint(10) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(30) NOT NULL,
  `Prezime` varchar(30) NOT NULL,
  `Pozicija` varchar(30) NOT NULL,
  PRIMARY KEY (`Id_Igrac`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `igrac` */

insert  into `igrac`(`Id_Igrac`,`Ime`,`Prezime`,`Pozicija`) values 
(1,'Milica','Nikolic','Srednjak'),
(2,'Nikolina','Savic','Korektor'),
(3,'Marija','Popovic','Primac'),
(4,'Kristina','Miletic','Primac'),
(5,'Natalija','Popovic','Dizac'),
(6,'Milena','Simovic','Libero'),
(7,'Lana','Draskovic','Korektor'),
(8,'Marina','Lekovski','Libero');

/*Table structure for table `kvalifikacija` */

DROP TABLE IF EXISTS `kvalifikacija`;

CREATE TABLE `kvalifikacija` (
  `Id_Kvalifikacija` bigint(10) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(30) NOT NULL,
  `Institucija` varchar(30) NOT NULL,
  PRIMARY KEY (`Id_Kvalifikacija`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `kvalifikacija` */

/*Table structure for table `kvalifikacija_analiticara` */

DROP TABLE IF EXISTS `kvalifikacija_analiticara`;

CREATE TABLE `kvalifikacija_analiticara` (
  `Id_Analiticar` bigint(10) NOT NULL,
  `Id_Kvalifikacija` bigint(10) NOT NULL,
  `Datum_Izdavanja` datetime NOT NULL,
  PRIMARY KEY (`Id_Analiticar`,`Id_Kvalifikacija`,`Datum_Izdavanja`),
  KEY `IDKva` (`Id_Kvalifikacija`),
  CONSTRAINT `IDAn` FOREIGN KEY (`Id_Analiticar`) REFERENCES `analiticar` (`Id_Analiticar`),
  CONSTRAINT `IDKva` FOREIGN KEY (`Id_Kvalifikacija`) REFERENCES `kvalifikacija` (`Id_Kvalifikacija`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `kvalifikacija_analiticara` */

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `Id_Mesto` bigint(10) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(30) NOT NULL,
  `Br_Stanovnika` int(15) NOT NULL,
  PRIMARY KEY (`Id_Mesto`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `mesto` */

insert  into `mesto`(`Id_Mesto`,`Naziv`,`Br_Stanovnika`) values 
(1,'Beograd',1681467),
(2,'Novi Sad',368000),
(3,'Subotica',230405),
(4,'Milanovac',103028),
(5,'Zrenjanin',56782),
(6,'Krusevac',78567),
(7,'Kraljevo',68234);

/*Table structure for table `sstavka_zapisnika` */

DROP TABLE IF EXISTS `sstavka_zapisnika`;

CREATE TABLE `sstavka_zapisnika` (
  `Id_Zapisnik` bigint(10) NOT NULL,
  `RB_Stavke` bigint(10) NOT NULL,
  `RB_SStavke` bigint(10) NOT NULL AUTO_INCREMENT,
  `MVP_Turnira` tinyint(1) NOT NULL,
  `Poeni_iz_bloka` int(10) NOT NULL,
  `Poeni_sa_servisa` int(10) NOT NULL,
  `Poeni_iz_igre` int(10) NOT NULL,
  `Ukupno_Poena` int(10) NOT NULL,
  `Id_Igrac` bigint(10) NOT NULL,
  PRIMARY KEY (`Id_Zapisnik`,`RB_Stavke`,`RB_SStavke`),
  KEY `RB_SStavke` (`RB_SStavke`),
  KEY `idIgrac` (`Id_Igrac`),
  KEY `rbStavka` (`RB_Stavke`),
  CONSTRAINT `idIgrac` FOREIGN KEY (`Id_Igrac`) REFERENCES `igrac` (`Id_Igrac`),
  CONSTRAINT `rbStavka` FOREIGN KEY (`RB_Stavke`) REFERENCES `stavka_zapisnika` (`RB_Stavke`),
  CONSTRAINT `zapID` FOREIGN KEY (`Id_Zapisnik`) REFERENCES `zapisnik` (`Id_Zapisnik`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `sstavka_zapisnika` */

insert  into `sstavka_zapisnika`(`Id_Zapisnik`,`RB_Stavke`,`RB_SStavke`,`MVP_Turnira`,`Poeni_iz_bloka`,`Poeni_sa_servisa`,`Poeni_iz_igre`,`Ukupno_Poena`,`Id_Igrac`) values 
(6,2,-1,0,3,2,6,11,2),
(7,1,1,1,5,6,12,22,5);

/*Table structure for table `stavka_zapisnika` */

DROP TABLE IF EXISTS `stavka_zapisnika`;

CREATE TABLE `stavka_zapisnika` (
  `Id_Zapisnik` bigint(10) NOT NULL,
  `RB_Stavke` bigint(10) NOT NULL AUTO_INCREMENT,
  `Mesto_na_rang_listi` int(10) NOT NULL,
  `Id_Tim` bigint(10) NOT NULL,
  PRIMARY KEY (`Id_Zapisnik`,`RB_Stavke`),
  KEY `RB_Stavke` (`RB_Stavke`),
  KEY `idTim` (`Id_Tim`),
  CONSTRAINT `IDzap` FOREIGN KEY (`Id_Zapisnik`) REFERENCES `zapisnik` (`Id_Zapisnik`),
  CONSTRAINT `idTim` FOREIGN KEY (`Id_Tim`) REFERENCES `tim` (`Id_Tim`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stavka_zapisnika` */

insert  into `stavka_zapisnika`(`Id_Zapisnik`,`RB_Stavke`,`Mesto_na_rang_listi`,`Id_Tim`) values 
(2,1,1,3),
(3,1,1,2),
(3,2,2,3),
(4,1,1,3),
(5,1,1,2),
(5,2,2,5),
(6,1,1,4),
(6,2,2,9),
(7,1,1,2),
(7,2,2,6);

/*Table structure for table `tim` */

DROP TABLE IF EXISTS `tim`;

CREATE TABLE `tim` (
  `Id_Tim` bigint(10) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(30) NOT NULL,
  `Broj_Clanova` int(10) NOT NULL,
  `Broj_Pobeda` int(10) NOT NULL,
  PRIMARY KEY (`Id_Tim`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tim` */

insert  into `tim`(`Id_Tim`,`Naziv`,`Broj_Clanova`,`Broj_Pobeda`) values 
(1,'Luky Star',8,4),
(2,'Dunav',7,3),
(3,'The big 5',5,3),
(4,'Zvezde',7,2),
(5,'Pobednici',6,2),
(6,'Marsovci',7,1),
(9,'Malci',7,0),
(10,'Svemir',8,2),
(11,'Klinci',6,3),
(12,'Vilenjaci',7,2);

/*Table structure for table `zapisnik` */

DROP TABLE IF EXISTS `zapisnik`;

CREATE TABLE `zapisnik` (
  `Id_Zapisnik` bigint(10) NOT NULL AUTO_INCREMENT,
  `Datum_Pocetka` date NOT NULL,
  `Datum_Zavrsetka` date NOT NULL,
  `Broj_Grupa` int(10) NOT NULL,
  `Id_Analiticar` bigint(10) NOT NULL,
  `Id_Delegat` bigint(10) NOT NULL,
  PRIMARY KEY (`Id_Zapisnik`),
  KEY `idAnaliticar` (`Id_Analiticar`),
  KEY `idDelegat` (`Id_Delegat`),
  CONSTRAINT `idAnaliticar` FOREIGN KEY (`Id_Analiticar`) REFERENCES `analiticar` (`Id_Analiticar`),
  CONSTRAINT `idDelegat` FOREIGN KEY (`Id_Delegat`) REFERENCES `delegat` (`Id_Delegat`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `zapisnik` */

insert  into `zapisnik`(`Id_Zapisnik`,`Datum_Pocetka`,`Datum_Zavrsetka`,`Broj_Grupa`,`Id_Analiticar`,`Id_Delegat`) values 
(1,'2025-04-12','2025-05-10',2,1,1),
(2,'2024-02-12','2024-03-10',3,1,3),
(3,'2025-07-02','2025-07-10',4,1,6),
(4,'2025-04-09','2025-04-19',2,1,3),
(5,'2025-10-19','2025-10-21',2,1,2),
(6,'2024-03-03','2024-03-13',3,2,2),
(7,'2025-10-01','2025-10-11',3,2,2),
(8,'2026-05-05','2026-05-15',3,1,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

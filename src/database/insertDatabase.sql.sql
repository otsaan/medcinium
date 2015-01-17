# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.20)
# Database: medcinium
# Generation Time: 2015-01-17 01:14:49 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table allergies
# ------------------------------------------------------------

LOCK TABLES `allergies` WRITE;
/*!40000 ALTER TABLE `allergies` DISABLE KEYS */;

INSERT INTO `allergies` (`id_allergie`, `nom_allergie`)
VALUES
	(1,'Acariens'),
	(2,'Pollens'),
	(3,'Lavande'),
	(4,'Oeufs'),
	(5,'Arachide'),
	(6,'Lait'),
	(7,'Soja'),
	(8,'Boeuf'),
	(9,'Noisette'),
	(10,'Ombellifères'),
	(11,'Poils de chat'),
	(12,'Blattes et cafards'),
	(13,'Poils de lapin');

/*!40000 ALTER TABLE `allergies` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table consultations
# ------------------------------------------------------------

LOCK TABLES `consultations` WRITE;
/*!40000 ALTER TABLE `consultations` DISABLE KEYS */;

INSERT INTO `consultations` (`id_consultation`, `type_consultation`, `desc_consultation`, `diagnostics`, `date_consultation`, `status`, `prix`, `id_patient`)
VALUES
	(1,'visite',NULL,NULL,'2015-01-17 00:14:38','pending',NULL,2),
	(2,'control',NULL,NULL,'2015-01-17 01:01:41','pending',NULL,8),
	(3,'visite','Toux grasse','Dysphagie douloureuse depuis 48h','2015-01-17 01:03:04','finished',300,1),
	(4,'visite','Conjonctivite bilatérale','pus à l\'angle interne ','2015-01-17 01:04:19','finished',NULL,3);

/*!40000 ALTER TABLE `consultations` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table contient
# ------------------------------------------------------------

LOCK TABLES `contient` WRITE;
/*!40000 ALTER TABLE `contient` DISABLE KEYS */;

INSERT INTO `contient` (`id_consultation`, `id_info`, `valeur`, `date_info`)
VALUES
	(3,1,'38','2015-01-17 01:13:19'),
	(3,2,'55/s','2015-01-17 01:13:19');

/*!40000 ALTER TABLE `contient` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table infos
# ------------------------------------------------------------

LOCK TABLES `infos` WRITE;
/*!40000 ALTER TABLE `infos` DISABLE KEYS */;

INSERT INTO `infos` (`id_info`, `propriete`)
VALUES
	(1,'Fièvre'),
	(2,'Fréquence cardiaque'),
	(3,'Pression artérielle'),
	(4,'Poids'),
	(5,'Taille'),
	(6,'Groupe sanguin'),
	(7,'Cholestérol'),
	(8,'Glycémie'),
	(9,'Créatinine'),
	(10,'IMC');

/*!40000 ALTER TABLE `infos` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table introduit
# ------------------------------------------------------------

LOCK TABLES `introduit` WRITE;
/*!40000 ALTER TABLE `introduit` DISABLE KEYS */;

INSERT INTO `introduit` (`id_consultation`, `id_medicament`, `desc_medicament`)
VALUES
	(3,1,'3 fois par jour'),
	(3,2,'1 fois avant dormir '),
	(4,5,'2 fois apres dejeuner pendant une semaine');

/*!40000 ALTER TABLE `introduit` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table medicaments
# ------------------------------------------------------------

LOCK TABLES `medicaments` WRITE;
/*!40000 ALTER TABLE `medicaments` DISABLE KEYS */;

INSERT INTO `medicaments` (`id_medicament`, `nom_medicament`)
VALUES
	(1,'ADVATE 1000 UI/2 '),
	(2,'AESCULUS COMPOSE suppos'),
	(3,'AFTOSIUM cp subling'),
	(4,'ALEVETABS 220 mg cp pellic'),
	(5,'AZZALURE 10 U Speywood/0,05 ml '),
	(6,'Metonia, Co. 5 mg');

/*!40000 ALTER TABLE `medicaments` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table paiements
# ------------------------------------------------------------

LOCK TABLES `paiements` WRITE;
/*!40000 ALTER TABLE `paiements` DISABLE KEYS */;

INSERT INTO `paiements` (`id_paiement`, `montant`, `date_paiement`, `id_patient`)
VALUES
	(1,200,'2015-01-16 01:11:53',1),
	(2,300,'2015-01-17 01:12:45',3);

/*!40000 ALTER TABLE `paiements` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table patients
# ------------------------------------------------------------

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;

INSERT INTO `patients` (`id_patient`, `nom_patient`, `prenom_patient`, `date_naissance`, `telephone`, `adresse`, `ville`, `sexe`, `cin`, `credit`)
VALUES
	(1,'Ahmed','Bakkali','1978-01-17','0678643589','RUE 23 ','Tanger','M','KB2323',100),
	(2,'Youness','Alami','1990-10-02','0643343329','N 32 HAY ASSALAM','Tanger','M','B32345',0),
	(3,'Nada','Alaoui','1985-10-20','0677382394','NUM 32 RUE MED 5','Tanger','F','838233',200),
	(4,'Mohammed','Temsamani','1991-03-30','0694394302','HAY AL MASSIRA RUE 6','Tanger','M','983723',0),
	(5,'Salwa','Taibi','1981-12-15','0637293923','RUE FADILA NUM 23','Tetouan','F','939233',350),
	(6,'Yassir','Jebari','1993-11-03','0632928382','NUM 24 HAY NASSR','Tanger','M','122490',0),
	(7,'Mouhssin','Naciri','1970-09-11','0688382393','RUE 3 HAY ALWAHDA','Tanger','M','932934',0),
	(8,'Badr','Benjelloun','1988-10-10','0649923023','RUE 3 NUM 32 BOULEVARD','Tanger','M','932553',0);

/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table rappels
# ------------------------------------------------------------

LOCK TABLES `rappels` WRITE;
/*!40000 ALTER TABLE `rappels` DISABLE KEYS */;

INSERT INTO `rappels` (`id_rappel`, `desc_rappel`, `date_rappel`, `id_patient`)
VALUES
	(1,'Resultat de teste','2015-01-18 00:14:00',2),
	(2,'Scanner ','2015-01-17 00:10:00',1),
	(3,'Visite','2015-01-17 00:13:30',3);

/*!40000 ALTER TABLE `rappels` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table renseigne
# ------------------------------------------------------------

LOCK TABLES `renseigne` WRITE;
/*!40000 ALTER TABLE `renseigne` DISABLE KEYS */;

INSERT INTO `renseigne` (`id_consultation`, `id_allergie`)
VALUES
	(3,1),
	(3,2),
	(4,5);

/*!40000 ALTER TABLE `renseigne` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table utilisateurs
# ------------------------------------------------------------

LOCK TABLES `utilisateurs` WRITE;
/*!40000 ALTER TABLE `utilisateurs` DISABLE KEYS */;

INSERT INTO `utilisateurs` (`id_utilisateur`, `nom_utilisateur`, `prenom_utilisateur`, `username`, `password`, `role`)
VALUES
	(1,'admin','admin','admin','admin','admin'),
	(2,'Wardi','Amal','amal','amal','secretaire'),
	(3,'Alaoui','Nizar','nizar','nizar','docteur');

/*!40000 ALTER TABLE `utilisateurs` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

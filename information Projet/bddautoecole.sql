-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 10 avr. 2025 à 19:42
-- Version du serveur : 9.1.0
-- Version de PHP : 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bddautoecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int NOT NULL,
  `mail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mot_de_passe` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `CodeCategorie` int NOT NULL,
  `Libelle` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `Prix` double(5,2) NOT NULL,
  PRIMARY KEY (`CodeCategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`CodeCategorie`, `Libelle`, `Prix`) VALUES
(1, 'Automobile', 34.95),
(2, 'Poids lourd', 43.00),
(3, 'Bateau', 51.25),
(4, 'Moto', 38.15),
(5, 'Transport en commun', 40.50);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `NumCompte` int NOT NULL,
  `login` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `mdp` varchar(50) NOT NULL,
  `statut` int NOT NULL,
  PRIMARY KEY (`NumCompte`),
  KEY `login` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`NumCompte`, `login`, `mdp`, `statut`) VALUES
(1, 'login0', 'password0', 0),
(2, 'login1', 'password1', 0),
(3, 'login2', 'password2', 0),
(4, 'login3', 'password3', 0),
(5, 'login4', 'password4', 0),
(6, 'login5', 'password5', 0),
(7, 'login6', 'password6', 0),
(8, 'login7', 'password7', 0),
(9, 'login8', 'password8', 0),
(10, 'login9', 'password9', 0),
(11, 'login10', 'password10', 0),
(12, 'login11', 'password11', 0),
(13, 'login12', 'password12', 0),
(14, 'login13', 'password13', 0),
(15, 'login14', 'password14', 0),
(16, 'login15', 'password15', 0),
(17, 'login16', 'password16', 0),
(18, 'login17', 'password17', 0),
(19, 'login18', 'password18', 0),
(20, 'login19', 'password19', 0),
(21, 'login20', 'password20', 0),
(22, 'login21', 'password21', 0),
(23, 'login22', 'password22', 0),
(24, 'login23', 'password23', 0),
(25, 'login24', 'password24', 0),
(35, 'login34', 'password34', 0),
(36, 'login35', 'password35', 0),
(37, 'login36', 'password36', 0),
(38, 'login37', 'password37', 0),
(39, 'login38', 'password38', 0),
(40, 'login39', 'password39', 0),
(41, 'login40', 'password40', 0),
(42, 'login41', 'password41', 0),
(43, 'login42', 'password42', 0),
(44, 'login43', 'password43', 0),
(45, 'login44', 'password44', 0),
(46, 'login45', 'password45', 0),
(47, 'login46', 'password46', 0),
(48, 'login47', 'password47', 0),
(49, 'login48', 'password48', 0),
(50, 'login49', 'password49', 0),
(51, 'login50', 'password50', 0),
(52, 'login51', 'password51', 0),
(53, 'login52', 'password52', 0),
(54, 'login53', 'password53', 0),
(55, 'login54', 'password54', 0),
(56, 'login55', 'password55', 0),
(57, 'login56', 'password56', 0),
(58, 'login57', 'password57', 0),
(59, 'login58', 'password58', 0),
(60, 'login59', 'password59', 0),
(61, 'login60', 'password60', 0),
(62, 'login61', 'password61', 0),
(63, 'login62', 'password62', 0),
(64, 'login63', 'password63', 0),
(65, 'login64', 'password64', 0),
(66, 'login65', 'password65', 0),
(67, 'login66', 'password66', 0),
(68, 'login67', 'password67', 0),
(69, 'login68', 'password68', 0),
(70, 'login69', 'password69', 1),
(71, 'login70', 'password70', 1),
(72, 'login71', 'password71', 1),
(73, 'login72', 'password72', 1);

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE IF NOT EXISTS `eleve` (
  `CodeEleve` int NOT NULL,
  `Nom` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `Prenom` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `Sexe` tinyint NOT NULL,
  `DateDeNaissance` date DEFAULT NULL,
  `Adresse1` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `CodePostal` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `Ville` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `Telephone` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `mail` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `NumCompte` int DEFAULT NULL,
  PRIMARY KEY (`CodeEleve`),
  KEY `idx_eleve_numcompte` (`NumCompte`),
  KEY `NumCompte` (`NumCompte`),
  KEY `NumCompte_2` (`NumCompte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `eleve`
--

INSERT INTO `eleve` (`CodeEleve`, `Nom`, `Prenom`, `Sexe`, `DateDeNaissance`, `Adresse1`, `CodePostal`, `Ville`, `Telephone`, `mail`, `NumCompte`) VALUES
(8, 'Gnocchi', 'Gwendoline', 1, '1964-04-12', '', '75008', 'Paris', '0104310779', 'gwendoline.gnocchi230@exemple.com', 1),
(16, 'Macaroni', 'Mazarine', 1, '1993-04-12', '', '75016', 'Paris', '0118060182', 'mazarine.macaroni84@exemple.com', 2),
(18, 'Ossobucco', 'Omer', 0, '1994-03-05', '', '75018', 'Paris', '0117070381', 'omer.ossobucco732@exemple.com', 3),
(22, 'Spaghetti', 'Sophie', 1, '2001-03-17', '', '75002', 'Paris', '0115090779', 'sophie.spaghetti407@exemple.com', 4),
(23, 'Tortellini', 'ThÃ©odule', 0, '1992-11-16', '', '75003', 'Paris', '0114210880', 'thÃ©odule.tortellini839@exemple.com', 5),
(41, 'Pomadoro', 'Pistache', 1, '2003-09-09', '', '75001', 'Paris', '0116141178', 'pistache.pomadoro977@exemple.com', 6),
(53, 'Cannelloni', 'CÃ©lestine', 1, '1987-04-01', '', '75003', 'Paris', '0171737579', 'cÃ©lestine.cannelloni368@exemple.com', 7),
(57, 'Ravioli', 'Romuald', 0, '1997-01-19', '', '75017', 'Paris', '0109210781', 'romuald.ravioli907@exemple.com', 8),
(63, 'BaccalaÃµ', 'Brutus', 0, '2004-05-16', '', '75003', 'Paris', '0145464748', 'brutus.baccalaÃµ434@exemple.com', 9),
(64, 'Tortilla', 'Tania', 1, '1976-11-09', '', '75004', 'Paris', '0122270181', 'tania.tortilla449@exemple.com', 10),
(70, 'Vermicellini', 'VÃ©ronique', 1, '1968-07-28', '', '75010', 'Paris', '0128220381', 'vÃ©ronique.vermicellini941@exemple.com', 11),
(71, 'Tagliatelli', 'Thomas', 0, '1994-06-17', '', '75011', 'Paris', '0129170482', 'thomas.tagliatelli361@exemple.com', 12),
(77, 'Ghappati', 'Gontrand', 0, '1987-06-02', '', '75017', 'Paris', '0135120281', 'gontrand.ghappati982@exemple.com', 13),
(84, 'Busecca', 'Bruce', 0, '1972-11-04', '', '75004', 'Paris', '0187868584', 'bruce.busecca826@exemple.com', 14),
(85, 'Carpaccio', 'ClÃ©mentine', 1, '1970-12-02', '', '75005', 'Paris', '0142130781', 'clÃ©mentine.carpaccio185@exemple.com', 15),
(87, 'Chipolata', 'Charlotte', 1, '1986-03-19', '', '75007', 'Paris', '0144220379', 'charlotte.chipolata449@exemple.com', 16),
(91, 'Broccoli', 'Basile', 0, '1976-07-20', '', '75011', 'Paris', '0176757473', 'basile.broccoli692@exemple.com', 17),
(92, 'Farfalle', 'Fernande', 1, '1974-09-03', '', '75012', 'Paris', '0148141281', 'fernande.farfalle110@exemple.com', 18),
(93, 'Lasagne', 'Lazare', 0, '1986-01-26', '', '75013', 'Paris', '0149130481', 'lazare.lasagne475@exemple.com', 19),
(96, 'Polenta', 'Paule', 1, '1973-09-08', '', '75016', 'Paris', '0152290379', 'paule.polenta803@exemple.com', 20),
(97, 'Tapioca', 'ThÃ©rÃ¨se', 1, '1999-02-01', '', '75017', 'Paris', '0153080580', 'thÃ©rÃ¨se.tapioca880@exemple.com', 21),
(100, 'Mozzarella', 'MilÃ¨ne', 1, '1974-09-13', '', '75020', 'Paris', '0156091079', 'milÃ¨ne.mozzarella992@exemple.com', 22),
(102, 'Caponata', 'Clovis', 0, '1964-08-07', '', '75002', 'Paris', '0158070680', 'clovis.caponata321@exemple.com', 23),
(112, 'Cappelletti', 'ClÃ©mence', 1, '1978-10-03', '', '75012', 'Paris', '0165091011', 'clÃ©mence.cappelletti496@exemple.com', 24),
(113, 'Antipasta', 'Amadeus', 0, '1966-07-21', '', '75013', 'Paris', '0123242526', 'amadeus.antipasta465@exemple.com', 25),
(123, 'Stracciatella', 'Sabrina', 1, '1969-09-24', '', '75003', 'Paris', '0131649728', 'sabrina.stracciatella361@exemple.com', 35),
(124, 'Minestrone', 'Martina', 1, '2001-02-10', '', '75004', 'Paris', '0195969798', 'martina.minestrone659@exemple.com', 36),
(125, 'Pavese', 'Pietro', 0, '1995-04-22', '', '75005', 'Paris', '0107080910', 'pietro.pavese214@exemple.com', 37),
(126, 'Fonduta', 'Florence', 1, '1971-11-02', '', '75006', 'Paris', '0103050709', 'florence.fonduta92@exemple.com', 38),
(127, 'Carozza', 'CunÃ©gonde', 1, '1984-06-24', '', '75007', 'Paris', '0105090307', 'cunÃ©gonde.carozza817@exemple.com', 39),
(128, 'Calzone', 'Corentin', 0, '1977-12-26', '', '75008', 'Paris', '0186848280', 'corentin.calzone813@exemple.com', 40),
(129, 'Tortino', 'Terrence', 0, '1985-10-17', '', '75009', 'Paris', '0104070205', 'terrence.tortino611@exemple.com', 41),
(130, 'Carciofi', 'Christian', 0, '1986-08-20', '', '75010', 'Paris', '0103060908', 'christian.carciofi619@exemple.com', 42),
(131, 'Scampi', 'Simone', 1, '1980-01-05', '', '75011', 'Paris', '0104050607', 'simone.scampi264@exemple.com', 43),
(132, 'Limone', 'LÃ©on', 0, '1973-06-24', '', '75012', 'Paris', '0192969498', 'lÃ©on.limone461@exemple.com', 44),
(133, 'Bisi', 'BÃ©nÃ©dicte', 1, '1966-02-26', '', '75013', 'Paris', '0165646362', 'bÃ©nÃ©dicte.bisi512@exemple.com', 45),
(134, 'Uova', 'Ursule', 1, '2005-07-13', '', '75014', 'Paris', '0103050709', 'ursule.uova180@exemple.com', 46),
(135, 'Carbonara', 'Camille', 1, '1974-05-18', '', '75015', 'Paris', '0151535759', 'camille.carbonara364@exemple.com', 47),
(136, 'Uccelletto', 'Ulla', 1, '2004-05-17', '', '75016', 'Paris', '0108060402', 'ulla.uccelletto279@exemple.com', 48),
(137, 'Cavoli', 'Constant', 0, '1965-12-01', '', '75017', 'Paris', '0104040404', 'constant.cavoli306@exemple.com', 49),
(138, 'Prosciutto', 'Priscilla', 1, '2001-08-20', '', '75018', 'Paris', '0151525354', 'priscilla.prosciutto693@exemple.com', 50),
(139, 'Peperonata', 'Patricia', 1, '1977-04-09', '', '75019', 'Paris', '0159575553', 'patricia.peperonata549@exemple.com', 51),
(140, 'Spinaci', 'Steve', 0, '1979-05-26', '', '75020', 'Paris', '0186848280', 'steve.spinaci663@exemple.com', 52),
(141, 'Parmigiana', 'Patrick', 0, '1988-05-22', '', '75001', 'Paris', '0102050809', 'patrick.parmigiana672@exemple.com', 53),
(142, 'Tegame', 'Thierry', 0, '1981-08-14', '', '75002', 'Paris', '0104060709', 'thierry.tegame370@exemple.com', 54),
(143, 'Zucchini', 'ZoÃ©', 1, '1988-10-14', '', '75003', 'Paris', '0108070504', 'zoÃ©.zucchini833@exemple.com', 55),
(144, 'Aragosta', 'Armande', 1, '2002-02-09', '', '75004', 'Paris', '0134353637', 'armande.aragosta57@exemple.com', 56),
(145, 'Trotelle', 'Teresa', 1, '2000-11-21', '', '75005', 'Paris', '0160824281', 'teresa.trotelle787@exemple.com', 57),
(146, 'Cacciucco', 'Christelle', 1, '2001-06-21', '', '57006', 'Paris', '0197959391', 'christelle.cacciucco765@exemple.com', 58),
(147, 'Ostriche', 'Ornella', 1, '1988-12-10', '', '75007', 'Paris', '0194989692', 'ornella.ostriche463@exemple.com', 59),
(148, 'Triglie', 'ThÃ©odule', 0, '1969-05-08', '', '75008', 'Paris', '0168646662', 'thÃ©odule.triglie20@exemple.com', 60),
(149, 'Pollo', 'Polo', 0, '1999-01-24', '', '75009', 'Paris', '0174859652', 'polo.pollo711@exemple.com', 61),
(150, 'Cacciatora', 'Carmen', 1, '1964-06-08', '', '75010', 'Paris', '0198979695', 'carmen.cacciatora498@exemple.com', 62),
(151, 'Peperoni', 'Pierre', 0, '1964-02-22', '', '75011', 'Paris', '0197643231', 'pierre.peperoni356@exemple.com', 63),
(152, 'Vitello', 'Vincent', 0, '1992-06-06', '', '75012', 'Paris', '0189452365', 'vincent.vitello287@exemple.com', 64),
(153, 'Cima', 'CÃ©line', 1, '1975-12-20', '', '75013', 'Paris', '0131649782', 'cÃ©line.cima368@exemple.com', 65),
(154, 'Polpette', 'Pauline', 1, '1983-08-19', '', '75014', 'Paris', '0148592615', 'pauline.polpette981@exemple.com', 66),
(155, 'Manzo', 'Marceline', 1, '1995-05-03', '', '75015', 'Paris', '0136353433', 'marceline.manzo801@exemple.com', 67),
(156, 'Abbacchio', 'Alberte', 1, '1994-03-04', '', '75016', 'Paris', '0102030405', 'alberte.abbacchio60@exemple.com', 68),
(157, 'Vaccinara', 'Valentine', 1, '1965-06-15', '', '75017', 'Paris', '0134373895', 'valentine.vaccinara899@exemple.com', 69);

-- --------------------------------------------------------

--
-- Structure de la table `lecon`
--

DROP TABLE IF EXISTS `lecon`;
CREATE TABLE IF NOT EXISTS `lecon` (
  `CodeLecon` int NOT NULL,
  `Date` date DEFAULT NULL,
  `Heure` varchar(50) DEFAULT NULL,
  `CodeMoniteur` int DEFAULT NULL,
  `CodeEleve` int DEFAULT NULL,
  `Immatriculation` varchar(50) DEFAULT NULL,
  `Reglee` int NOT NULL,
  PRIMARY KEY (`CodeLecon`),
  KEY `CodeMoniteur` (`CodeMoniteur`),
  KEY `CodeEleve` (`CodeEleve`),
  KEY `Immatriculation` (`Immatriculation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lecon`
--

INSERT INTO `lecon` (`CodeLecon`, `Date`, `Heure`, `CodeMoniteur`, `CodeEleve`, `Immatriculation`, `Reglee`) VALUES
(95, '2017-09-02', '14:09:00', 14, 64, '678 FG 21', 0),
(96, '2017-09-02', '15:00:00', 11, 70, '678 FG 21', 0),
(97, '2017-09-02', '14:13:00', 14, 84, '234 BC 21', 0),
(98, '2017-11-17', '09:15:00', 15, 156, '890 HJ 21', 0),
(99, '2017-08-23', '10:00:00', 8, 23, '567 EF 21', 0),
(100, '2017-09-02', '14:19:00', 11, 16, '567 EF 21', 0),
(101, '2017-09-02', '14:20:00', 14, 123, '345 CD 21', 0),
(102, '2017-09-02', '14:23:00', 14, 8, '456 DE 21', 0),
(103, '2017-09-02', '14:26:00', 11, 141, '456 DE 21', 0),
(104, '2017-09-02', '14:28:00', 8, 16, '345 CD 21', 0),
(105, '2017-09-02', '14:29:00', 11, 16, '456 DE 21', 0),
(106, '2017-09-02', '14:30:00', 14, 77, '345 CD 21', 0),
(107, '2017-09-02', '14:36:00', 14, 16, '234 BC 21', 0),
(108, '2017-09-02', '14:40:00', 14, 16, '234 BC 21', 0),
(109, '2017-09-05', '14:43:00', 11, 8, '456 DE 21', 0),
(110, '2017-09-02', '08:46:00', 11, 8, '345 CD 21', 0),
(111, '2017-09-05', '11:47:00', 8, 16, '345 CD 21', 0),
(112, '2017-09-02', '15:03:00', 11, 8, '456 DE 21', 0),
(113, '2017-09-29', '18:07:00', 11, 16, '234 BC 21', 0),
(114, '2017-11-14', '02:10:00', 11, 128, '789 GH 21', 0),
(115, '2017-09-02', '18:16:00', 11, 8, '345 CD 21', 0),
(116, '2017-09-02', '13:17:00', 11, 8, '345 CD 21', 0),
(117, '2017-11-02', '13:26:00', 11, 131, '345 CD 21', 0),
(118, '2015-11-11', '02:09:00', 15, 57, '789 GH 21', 0),
(119, '2020-09-09', '18:28:00', 11, 53, '456 DE 21', 0),
(120, '2017-09-22', '08:00:00', 8, 23, '567 EF 21', 0),
(121, '2017-09-22', '16:48:00', 11, 16, '345 CD 21', 0),
(122, '2017-09-22', '02:00:00', 11, 53, '567 EF 21', 0),
(123, '2017-09-27', '08:00:00', 14, 64, '678 FG 21', 0),
(124, '2018-08-17', '09:02:00', 11, 102, '456 DE 21', 0),
(125, '2020-06-24', '11:00:00', 14, 64, '789 GH 21', 0),
(126, '2020-12-16', '14:00:00', 14, 16, '345 CD 21', 0),
(127, '2020-12-16', '14:00:00', 15, 8, '678 FG 21', 0),
(128, '2020-12-16', '15:00:00', 14, 126, '567 EF 21', 0);

-- --------------------------------------------------------

--
-- Structure de la table `licence`
--

DROP TABLE IF EXISTS `licence`;
CREATE TABLE IF NOT EXISTS `licence` (
  `CodeLicence` int NOT NULL,
  `CodeMoniteur` int DEFAULT NULL,
  `CodeCategorie` int DEFAULT NULL,
  `DateObtention` date DEFAULT NULL,
  PRIMARY KEY (`CodeLicence`),
  KEY `CodeMoniteur` (`CodeMoniteur`,`CodeCategorie`),
  KEY `CodeCategorie` (`CodeCategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `licence`
--

INSERT INTO `licence` (`CodeLicence`, `CodeMoniteur`, `CodeCategorie`, `DateObtention`) VALUES
(1, 11, 1, NULL),
(2, 11, 4, NULL),
(3, 11, 5, NULL),
(4, 8, 3, NULL),
(5, 14, 1, NULL),
(6, 14, 2, NULL),
(7, 14, 5, NULL),
(8, 15, 1, NULL),
(9, 15, 3, NULL),
(10, 11, 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `moniteur`
--

DROP TABLE IF EXISTS `moniteur`;
CREATE TABLE IF NOT EXISTS `moniteur` (
  `CodeMoniteur` int NOT NULL,
  `Nom` varchar(50) DEFAULT NULL,
  `Prenom` varchar(50) DEFAULT NULL,
  `Sexe` tinyint DEFAULT NULL,
  `DateDeNaissance` date DEFAULT NULL,
  `Adresse1` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `CodePostal` varchar(50) DEFAULT NULL,
  `Ville` varchar(50) DEFAULT NULL,
  `Telephone` varchar(50) DEFAULT NULL,
  `mail` varchar(100) NOT NULL,
  `NumCompte` int NOT NULL,
  PRIMARY KEY (`CodeMoniteur`),
  KEY `NumCompte` (`NumCompte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `moniteur`
--

INSERT INTO `moniteur` (`CodeMoniteur`, `Nom`, `Prenom`, `Sexe`, `DateDeNaissance`, `Adresse1`, `CodePostal`, `Ville`, `Telephone`, `mail`, `NumCompte`) VALUES
(8, 'Béal', 'Géraldine', 1, '1972-01-23', '12, avenue du Collège', '75004', 'Paris', '0180123456', 'géraldine.béal108@exemple.com', 0),
(11, 'Ambrosi', 'Pierre', 2, '1969-01-04', '23, rue du Lycée', '75019', 'Paris', '0180234567', 'pierre.ambrosi566@exemple.com', 0),
(14, 'Catard', 'Olivier', 2, '1963-09-12', '34, boulevard de l\'Université', '75005', 'Paris', '0180345677', 'olivier.catard506@exemple.com', 0),
(15, 'Ezard', 'Régine', 1, '1978-04-06', '45, rue des Écoles', '75020', 'Paris', '0180456789', 'régine.ezard831@exemple.com', 0);

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
CREATE TABLE IF NOT EXISTS `vehicule` (
  `Immatriculation` varchar(50) NOT NULL,
  `Marque` varchar(50) DEFAULT NULL,
  `Modele` varchar(50) DEFAULT NULL,
  `Annee` int DEFAULT NULL,
  `CodeCategorie` int DEFAULT NULL,
  PRIMARY KEY (`Immatriculation`),
  KEY `CodeCategorie` (`CodeCategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`Immatriculation`, `Marque`, `Modele`, `Annee`, `CodeCategorie`) VALUES
('123 AB 21', 'Mercedes', 'Spania', 2000, 1),
('234 BC 21', 'Peugeot', 'Sisancys', 1996, 1),
('345 CD 21', 'Renault', 'Morgane', 1995, 1),
('456 DE 21', 'Peugeot', 'Catsansys', 1999, 1),
('567 EF 21', 'Kawasaki', 'Zephyr', 1997, 4),
('678 FG 21', 'Renault', 'Betton', 1999, 5),
('789 GH 21', 'Iveco', 'Roader', 1998, 2),
('890 HJ 21', 'Oceansea', 'Tempest', 1999, 3);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `eleve_ibfk_1` FOREIGN KEY (`NumCompte`) REFERENCES `compte` (`NumCompte`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `lecon`
--
ALTER TABLE `lecon`
  ADD CONSTRAINT `lecon_ibfk_1` FOREIGN KEY (`CodeMoniteur`) REFERENCES `moniteur` (`CodeMoniteur`),
  ADD CONSTRAINT `lecon_ibfk_2` FOREIGN KEY (`CodeEleve`) REFERENCES `eleve` (`CodeEleve`),
  ADD CONSTRAINT `lecon_ibfk_3` FOREIGN KEY (`Immatriculation`) REFERENCES `vehicule` (`Immatriculation`);

--
-- Contraintes pour la table `licence`
--
ALTER TABLE `licence`
  ADD CONSTRAINT `licence_ibfk_1` FOREIGN KEY (`CodeMoniteur`) REFERENCES `moniteur` (`CodeMoniteur`),
  ADD CONSTRAINT `licence_ibfk_2` FOREIGN KEY (`CodeCategorie`) REFERENCES `categorie` (`CodeCategorie`);

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `vehicule_ibfk_1` FOREIGN KEY (`CodeCategorie`) REFERENCES `categorie` (`CodeCategorie`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

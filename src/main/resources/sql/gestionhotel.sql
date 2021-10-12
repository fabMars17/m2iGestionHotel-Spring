-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  mar. 12 oct. 2021 à 12:06
-- Version du serveur :  10.2.14-MariaDB
-- Version de PHP :  7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestionhotel`
--

CREATE DATABASE `gestionhotel`

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_complet` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom_complet`, `telephone`, `email`, `adresse`) VALUES
(1, 'Martin Julie', '0240305060', 'mar@out.com', '5 bd Caravage, 28009, Madrid, Espagne'),
(2, 'Jean-Dominique Tremblay', '514-123-4567', 'jm.tremblay@in.ca', '6000 Richmond St W, M5H 2N2, Toronto, Canada'),
(3, 'Maire Arnaud', '0240305060', 'mar@out.com', '14 impasse du Cerf, 28009, Lyon, France'),
(5, 'Richard Stevenson Jr', '+44 7911 123456', 'rich.stevv@gmal.com', '48 P.M street, London, UK'),
(6, 'Juan Gimenez', '+54 9 223 123–4567', 'juangim@ul.ar', '4770 Av. Olazábal, Buenos Aires, Argentine'),
(8, 'aaa', '04 10 11 12 21', 'ddd@fff', '20 hammer street, London, UK'),
(9, 'Martin Bernard', '0280901020', 'marber@ulu.fr', '2 rue Salma, Bordeaux, France');

-- --------------------------------------------------------

--
-- Structure de la table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
CREATE TABLE IF NOT EXISTS `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `etoiles` tinyint(4) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `etoile` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hotel`
--

INSERT INTO `hotel` (`id`, `nom`, `etoiles`, `adresse`, `telephone`, `email`, `ville`, `etoile`) VALUES
(1, 'Hôtel Marignan Champs-Élysées', 5, '12 Rue de Marignan, 75008 Paris, France', '01 40 76 34 56', 'hotelmarignan.com', 'Paris', NULL),
(2, 'Grand Hotel de La Minerva', 4, 'Piazza della Minerva, 69, 00186 Roma RM, Italie', '+39 06 695201', 'hotelminerva.com', 'Rome', NULL),
(3, 'Three Seasons Hotel London at Ten Trinity Square', 3, '10 Trinity Grand Square , London EC3N 4AJ, Royaume-Uni', '+44 20 3297 9230', 'hoteltrinitysquare.uk', 'Bukimgam', NULL),
(5, 'Hotel New Otani Tokyo EXECUTIVE HOUSE ZEN-Bu', 3, 'Japon, 〒102-8578 Tokyo, Chiyoda City, Kioicho0000', '+81 3-3265-1112', 'www.newotani.co.jp', 'Tokyoo', NULL),
(7, 'Grand Hotel de La Minerva', 4, 'Piazza della Minerva, 69, 00186 Roma RM, Italie', '+39 06 695201', 'hotelminerva.com', 'Rome', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `resa`
--

DROP TABLE IF EXISTS `resa`;
CREATE TABLE IF NOT EXISTS `resa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client` int(11) NOT NULL,
  `hotel` int(11) NOT NULL,
  `datestart` date NOT NULL,
  `dateend` date NOT NULL,
  `no_chambre` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `hotel_ibfk_1` (`hotel`),
  KEY `client_ibfk_1` (`client`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `resa`
--

INSERT INTO `resa` (`id`, `client`, `hotel`, `datestart`, `dateend`, `no_chambre`) VALUES
(1, 2, 1, '2022-03-08', '2022-03-22', 62),
(2, 3, 3, '2021-12-29', '2022-01-15', 14),
(4, 3, 3, '2021-10-22', '2021-10-30', 56),
(5, 6, 5, '2021-10-14', '2021-10-22', 14),
(7, 3, 3, '2021-11-03', '2021-11-10', 56),
(10, 3, 3, '2021-10-08', '2021-10-12', 5),
(11, 1, 2, '2021-10-07', '2021-10-15', 56),
(12, 2, 2, '2021-10-07', '2021-10-08', 2),
(13, 5, 1, '2021-10-08', '2021-10-22', 5),
(14, 3, 3, '2021-11-11', '2021-11-12', 56),
(15, 6, 7, '2022-03-17', '2022-03-31', 5),
(16, 9, 7, '2022-04-06', '2022-04-13', 26),
(17, 2, 3, '2021-10-14', '2021-11-11', 2);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `role`) VALUES
(1, 'admin', '$2a$10$.HpL5s31dDEY1XzFcJoI0.rCK9E8qQwUYcodY.lewD3OTzsiXvHLS', 'ROLE_ADMIN');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `resa`
--
ALTER TABLE `resa`
  ADD CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`hotel`) REFERENCES `hotel` (`id`),
  ADD CONSTRAINT `resa_ibfk_1` FOREIGN KEY (`client`) REFERENCES `client` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 16 déc. 2020 à 00:01
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `crudprojet`
--

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `id_liv` int(11) NOT NULL,
  `nom_liv` varchar(20) NOT NULL,
  `genre_liv` varchar(20) DEFAULT NULL,
  `auteur_liv` varchar(20) NOT NULL,
  `date_par` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_liv`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id_liv`, `nom_liv`, `genre_liv`, `auteur_liv`, `date_par`) VALUES
(1, 'you', 'Policier', 'yuki one', '2020-12-09'),
(2, 'la mort heureuse', 'roman graphique', 'camus', '2020-12-23');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

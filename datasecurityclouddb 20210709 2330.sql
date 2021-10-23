-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.19


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema datasecuritycloud
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ datasecuritycloud;
USE datasecuritycloud;

--
-- Table structure for table `datasecuritycloud`.`login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datasecuritycloud`.`login`
--

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`username`,`password`) VALUES 
 ('admin','password123');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;


--
-- Table structure for table `datasecuritycloud`.`message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `sender` varchar(50) NOT NULL DEFAULT '',
  `receiver` varchar(50) DEFAULT NULL,
  `message` text,
  `date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `datasecuritycloud`.`message`
--

/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` (`sender`,`receiver`,`message`,`date`) VALUES 
 ('admin','megha@gmail.com','hi megha','Sat Nov 21 15:54:59 IST 2020'),
 ('admin','ravishkumarkl@gmail.com','jsyghemBUOyZs8+v6a2DdA==','Tue Jun 29 20:35:14 IST 2021');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;


--
-- Table structure for table `datasecuritycloud`.`registration`
--

DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `mac` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT 'pending',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `otp` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datasecuritycloud`.`registration`
--

/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` (`name`,`email`,`password`,`phone`,`mac`,`status`,`id`,`otp`) VALUES 
 ('ravi','ravishkumarkl@gmail.com','ravi123','9933993399','BC-A8-A6-5D-C0-0F','accepted',5,'8053'),
 ('megha','meghanabhat021@gmail.com','megha123','8869586985','BC-A8-A6-5D-C0-0F','accepted',6,NULL),
 ('deepa','deepa@gmail.com','deepa123','9933993939','BC-A8-A6-5D-C0-0F','accepted',7,NULL);
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

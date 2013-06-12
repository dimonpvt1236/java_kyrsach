-- phpMyAdmin SQL Dump
-- version 3.2.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 12, 2013 at 08:29 PM
-- Server version: 5.5.25
-- PHP Version: 5.3.3

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `java_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
CREATE TABLE IF NOT EXISTS `config` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `val` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `config`
--

INSERT INTO `config` (`id`, `name`, `val`) VALUES
(1, 'lastorder', '32');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordernumber` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ordernumber` (`ordernumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `ordernumber`, `user_id`, `date`) VALUES
(1, 0, 1, '2013-05-24 15:05:43'),
(3, 2, 1, '2013-06-01 00:00:00'),
(4, 3, 1, '2013-06-01 00:00:00'),
(5, 4, 1, '2013-06-01 00:00:00'),
(6, 5, 1, '2013-06-01 00:00:00'),
(7, 6, 4, '2013-06-01 17:37:53'),
(8, 7, 4, '2013-06-01 17:53:16'),
(9, 8, 4, '2013-06-01 18:20:41'),
(10, 9, 4, '2013-06-01 18:44:26'),
(11, 10, 4, '2013-06-01 18:45:38'),
(12, 11, 4, '2013-06-01 18:45:40'),
(13, 12, 4, '2013-06-01 18:45:41'),
(14, 13, 4, '2013-06-01 18:45:41'),
(15, 14, 4, '2013-06-01 18:45:42'),
(16, 15, 4, '2013-06-01 18:45:42'),
(17, 16, 4, '2013-06-01 18:45:43'),
(18, 17, 4, '2013-06-01 18:45:43'),
(19, 18, 4, '2013-06-01 18:45:44'),
(20, 19, 4, '2013-06-01 18:45:44'),
(21, 20, 4, '2013-06-01 18:45:45'),
(22, 21, 4, '2013-06-01 18:45:45'),
(23, 22, 4, '2013-06-01 18:45:46'),
(24, 23, 4, '2013-06-01 18:45:46'),
(25, 24, 4, '2013-06-01 18:45:46'),
(26, 25, 4, '2013-06-01 18:45:46'),
(27, 26, 4, '2013-06-01 18:45:47'),
(28, 27, 4, '2013-06-01 18:48:02'),
(29, 28, 4, '2013-06-01 18:49:16'),
(30, 29, 4, '2013-06-01 18:50:14'),
(31, 30, 4, '2013-06-01 18:52:09'),
(32, 31, 4, '2013-06-02 15:50:34');

-- --------------------------------------------------------

--
-- Table structure for table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
CREATE TABLE IF NOT EXISTS `order_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordernumber` int(11) NOT NULL,
  `prod_id` int(11) NOT NULL,
  `prod_name` varchar(200) NOT NULL,
  `prod_price` double NOT NULL,
  `prod_qty` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `order_product`
--

INSERT INTO `order_product` (`id`, `ordernumber`, `prod_id`, `prod_name`, `prod_price`, `prod_qty`) VALUES
(1, 8, 9, 'sadfasd', 123, 1),
(2, 8, 18, 'клавиатура', 123, 3),
(3, 9, 23, 'sdfgsd', 124.25, 34),
(4, 27, 13, 'fjghf', 0, 12),
(5, 28, 13, 'fjghf', 0, 1),
(6, 29, 8, 'sdf', 0, 12),
(7, 30, 8, 'sdf', 0, 1),
(8, 31, 18, 'клавиатура', 123, 1),
(9, 31, 19, 'asasd', 123, 1),
(10, 31, 23, 'sdfgsd', 124.25, 1);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` double(10,2) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `qty` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `description`, `qty`, `image`) VALUES
(17, 'TP-Link', 20.00, 'TL-WN722NC USB 802.11g, b, n, до 150Mbit, s, отсоединяемая антенна 4db', 14, '/images/126856_0.1362375066.jpg'),
(18, 'TP-Link2', 11.00, 'NC USB 802.11g, b, n, до 150Mbit, s, 20dBm(MAX EIRP)', 123, '/images/120429_0.1362375036.jpg'),
(19, 'ASUS', 19.00, 'PCI-N10\r\nPCI 802.11n, до 150Mbit, s', 123, '/images/141830_0.1328751137.jpg'),
(21, 'D-Link DAP-1360', 30.30, '802.11n, до 300Mbit, s, поддержка WISP (Wireless Internet Service Provider)', 123, '/images/117721_0.1366340602.jpg'),
(23, 'ZyXEL NWD2105 EE', 21.00, 'USB, 802.11n, до 150Mbit, s', 123, '/images/135644_0.1328772267.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `login` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `contry` varchar(100) NOT NULL,
  `region` varchar(200) NOT NULL,
  `city` varchar(100) NOT NULL,
  `addres` varchar(200) NOT NULL,
  `zip` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `login`, `pass`, `contry`, `region`, `city`, `addres`, `zip`, `phone`, `mail`, `status`) VALUES
(1, 'Dmitriy', 'dimon', '1236', 'Russia', 'Rostovskaiy obl', 'Taganrog', 'Petrovka', '346780', '12365478', 'dimonpvt@mail.ru', 1),
(2, 'starik', 'starik', '1234', 'asd', 'fgh', 'qwe', 'tyu', 'zxc334', '21341234', 'd@a.com', 1),
(4, 'starik1236', 'starik12', '12345', 'sasdf', 'asdfasd', 'asdfasd', 'dsfasdf', '12312', '234123', 'sasa@sdfsd.com', 0),
(5, 'admin', 'admin', 'admin', 'asdfas', 'asdf', 'asdf', 'asdf', '1231', '123123', 'a@a.com', 1),
(6, 'asdfasdfasd', 'asdfasdfasd', '1q2w3e4r', 'asdf', 'asdf', 'asdfasd', 'asdfasd', '23123', '1231231', 'a@a.com', 0);
SET FOREIGN_KEY_CHECKS=1;

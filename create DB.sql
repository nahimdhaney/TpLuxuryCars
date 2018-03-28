

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tienda` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;

USE `tienda`;

/*Table structure for table `categoria` */

DROP TABLE IF EXISTS `categoria`;

CREATE TABLE `categoria` (
  `categoriaId` int(6) NOT NULL AUTO_INCREMENT,
  `nombreCategoria` varchar(250) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`categoriaId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `categoria` */

insert  into `categoria`(`categoriaId`,`nombreCategoria`) values 

(2,'Alfa Romeo'),
(7,'Audi'),
(10,'Bentley'),
(12,'Bmw'),
(13,'Cadillac'),
(23,'Dodge'),
(24,'Ferrari'),
(31,'Hyundai'),
(32,'Infiniti'),
(37,'Jaguar'),
(38,'Jeep'),
(41,'Lamborghini'),
(43,'Land-rover'),
(45,'Lexus'),
(48,'Maserati'),
(51,'Mercedes-benz'),
(53,'Mini'),
(59,'Pontiac'),
(60,'Porsche'),
(62,'Rolls-royce');

/*Table structure for table `detallepedido` */

DROP TABLE IF EXISTS `detallepedido`;

CREATE TABLE `detallepedido` (
  `pedidoId` int(6) NOT NULL,
  `productoId` int(6) NOT NULL,
  `cantidad` int(6) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  KEY `pedidoId` (`pedidoId`),
  KEY `productoId` (`productoId`),
  CONSTRAINT `detallepedido_ibfk_1` FOREIGN KEY (`pedidoId`) REFERENCES `pedido` (`pedidoId`),
  CONSTRAINT `detallepedido_ibfk_2` FOREIGN KEY (`productoId`) REFERENCES `producto` (`productoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `detallepedido` */

/*Table structure for table `pedido` */

DROP TABLE IF EXISTS `pedido`;

CREATE TABLE `pedido` (
  `pedidoId` int(6) NOT NULL AUTO_INCREMENT,
  `usuarioId` int(6) NOT NULL,
  `fecha` datetime NOT NULL,
  `total` decimal(10,2) NOT NULL,
  PRIMARY KEY (`pedidoId`),
  KEY `usuarioId` (`usuarioId`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`usuarioId`) REFERENCES `usuario` (`usuarioId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `pedido` */

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `productoId` int(6) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` text COLLATE utf8_spanish_ci NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `categoriaId` int(11) NOT NULL,
  `Marca` varchar(20) NOT NULL,
  `Marca` varchar(20) NOT NULL,
  `imagen` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`productoId`),
  KEY `categoriaId` (`categoriaId`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`categoriaId`) REFERENCES `categoria` (`categoriaId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `producto` */

insert  into `producto`(`productoId`,`nombre`,`descripcion`,`precio`,`categoriaId`,`imagen`) values 

(1,'TV LG 42\'\'','Televisor LG Smart de 42\'\' Serie A','4200.00',1,''),

(2,'Heladera Electrolux','Heladera Electrolux con Hielo Seco','3500.00',2,''),

(3,'TV Samsung 52\'\'','Televisor Smart de 42\'\' Serie 8','4900.00',1,'');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `usuarioId` int(6) NOT NULL AUTO_INCREMENT,
  `nombreCompleto` varchar(250) COLLATE utf8_spanish_ci NOT NULL DEFAULT '',
  `nombreUsuario` varchar(50) COLLATE utf8_spanish_ci NOT NULL DEFAULT '',
  `password` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(500) COLLATE utf8_spanish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`usuarioId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `usuario` */

insert  into `usuario`(`usuarioId`,`nombreCompleto`,`nombreUsuario`,`password`,`direccion`) values 

(1,'Juan Perez','jperez','jperez','Av. Banzer'),

(2,'Mariel Coca','mcoca','mcoca','Av. Virgen de Cotoca');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;




select * from categoria;
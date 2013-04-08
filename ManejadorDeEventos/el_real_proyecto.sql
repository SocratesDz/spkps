CREATE DATABASE IF NOT EXISTS el_real_proyecto;

USE `el_real_proyecto` ;

DROP TABLE IF EXISTS `el_real_proyecto`.`Reservacion`;
DROP TABLE IF EXISTS `el_real_proyecto`.`Eventos`;
DROP TABLE IF EXISTS `el_real_proyecto`.`Cliente`;

-- -----------------------------------------------------

-- Table `el_real_proyecto`.`Eventos`

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `el_real_proyecto`.`Eventos` (

  `IDEvento` INT NOT NULL AUTO_INCREMENT,

  `NombreEvento` VARCHAR(45) NOT NULL ,

  `DescripcionEvento` TEXT,

  `FechaEvento` DATE,

  `HoraEvento` TIME,

  `PrecioBoleta` INT,

  PRIMARY KEY (`IDEvento`) );


-- -----------------------------------------------------

-- Table `el_real_proyecto`.`Cliente`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `el_real_proyecto`.`Cliente` (

  `IDCliente` INT NOT NULL AUTO_INCREMENT ,

  `NombreCliente` VARCHAR(45) NOT NULL ,

  `ApellidoCliente` VARCHAR(45) NOT NULL ,

  `SexoCliente` VARCHAR(1) NOT NULL ,

  `EdadCliente` INT NOT NULL ,

  PRIMARY KEY (`IDCliente`) );

-- -----------------------------------------------------

-- Table `el_real_proyecto`.`Reservacion`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `el_real_proyecto`.`Reservacion` (

  `IDReservacion` INT NOT NULL AUTO_INCREMENT ,

  `ClienteID` INT NOT NULL,

  `EventoID` INT NOT NULL,

  `CantidadBoletas` INT,

  `PrecioTotal` INT, 

  PRIMARY KEY (`IDReservacion`),

  FOREIGN KEY (`ClienteID`) REFERENCES `el_real_proyecto`.`Cliente` (`IDCliente`),

  FOREIGN KEY (`EventoID`) REFERENCES `el_real_proyecto`.`Eventos` (`IDEvento`));
  

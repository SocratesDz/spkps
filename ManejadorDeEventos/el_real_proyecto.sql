 
 
CREATE DATABASE IF NOT EXISTS el_real_proyecto;  -- ya tu saves como va blablabla

USE `el_real_proyecto` ;



-- -----------------------------------------------------

-- Table `el_real_proyecto`.`Eventos`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `el_real_proyecto`.`Eventos`;

CREATE TABLE IF NOT EXISTS `el_real_proyecto`.`Eventos` (

  `ID` INT NOT NULL AUTO_INCREMENT,

  `Nombre` VARCHAR(45) NOT NULL ,

  `Descripcion` VARCHAR(500),

  `Fecha` DATE,

  `Hora` TIME,

  `PrecioBoleta` INT,

  PRIMARY KEY (`ID`) );





-- -----------------------------------------------------

-- Table `el_real_proyecto`.`Cliente`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `el_real_proyecto`.`Cliente`;

CREATE  TABLE IF NOT EXISTS `el_real_proyecto`.`Cliente` (

  `ID` INT NOT NULL AUTO_INCREMENT ,

  `Nombre` VARCHAR(45) NOT NULL ,

  `Apellido` VARCHAR(45) NOT NULL ,

  `Sexo` VARCHAR(1) NOT NULL ,

  `Edad` INT NOT NULL ,

  PRIMARY KEY (`ID`) );






-- -----------------------------------------------------

-- Table `el_real_proyecto`.`Reservacion`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `el_real_proyecto`.`Reservacion`;

CREATE  TABLE IF NOT EXISTS `el_real_proyecto`.`Reservacion` (

  `ID` INT NOT NULL AUTO_INCREMENT ,

  `ClienteID` INT NOT NULL,

  `EventoID` INT NOT NULL,

  `CantidadBoletas` INT,

  `Precio` INT, 

  PRIMARY KEY (`ID`, `ClienteID`, `EventoID`) );

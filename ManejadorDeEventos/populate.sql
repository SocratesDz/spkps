-- Poblador de datos para la base de datos

USE `el_real_proyecto`;

INSERT INTO `Cliente` (ID, Nombre, Apellido, Sexo, Edad) VALUES (1, 'Joan', 'Pérez Cáceres', 'M', 20);
INSERT INTO `Cliente` (ID, Nombre, Apellido, Sexo, Edad) VALUES (2, 'Pedro', 'Almonte Ramos', 'M', 24);
INSERT INTO `Cliente` (ID, Nombre, Apellido, Sexo, Edad) VALUES (3, 'Johanna', 'García García', 'F', 19);
INSERT INTO `Cliente` (ID, Nombre, Apellido, Sexo, Edad) VALUES (4, 'Mateo', 'Otoniel Díaz', 'M', 21);
INSERT INTO `Cliente` (ID, Nombre, Apellido, Sexo, Edad) VALUES (5, 'María', 'Castillo Febrillé', 'F', 22);

INSERT INTO `Eventos` (ID, Nombre, Descripcion, Fecha, Hora, PrecioBoleta) VALUES (1, 'Marcha por la Patria',
	'Acompáñanos a marchar en pro de los ideales patrios.', 130623, 100000, 0);

INSERT INTO `Eventos` (ID, Nombre, Descripcion, Fecha, Hora, PrecioBoleta) VALUES (2, 'Festival de Música Electrónica',
	"Disfruta de los mejores DJ's nacionales e internacionales.", 130715, 110000, 300);

INSERT INTO `Eventos` (ID, Nombre, Descripcion, Fecha, Hora, PrecioBoleta) VALUES (3, 'GamerCon',
	'Conoce las novedades en el mundo de los videojuegos.', 130720, 110000, 500);

INSERT INTO `Reservacion` (ID, ClienteID, EventoID, CantidadBoletas, Precio) VALUES (1, 1, 2, 4, 1200);
INSERT INTO `Reservacion` (ID, ClienteID, EventoID, CantidadBoletas, Precio) VALUES (2, 2, 1, 6, 0);
INSERT INTO `Reservacion` (ID, ClienteID, EventoID, CantidadBoletas, Precio) VALUES (3, 3, 3, 2, 1500);
INSERT INTO `Reservacion` (ID, ClienteID, EventoID, CantidadBoletas, Precio) VALUES (4, 4, 3, 6, 3000);
INSERT INTO `Reservacion` (ID, ClienteID, EventoID, CantidadBoletas, Precio) VALUES (5, 5, 1, 1, 0);
INSERT INTO `Reservacion` (ID, ClienteID, EventoID, CantidadBoletas, Precio) VALUES (6, 3, 2, 3, 900);

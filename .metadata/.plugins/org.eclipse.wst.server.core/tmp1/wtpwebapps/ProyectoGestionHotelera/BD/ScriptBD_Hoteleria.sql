CREATE DATABASE BD_Hoteleria;
USE BD_Hoteleria;

/*
use test;
drop database BD_Hoteleria;
*/

-- DEliminar las tablas si existen
DROP TABLE IF EXISTS ACCESO;
DROP TABLE IF EXISTS MENU;
DROP TABLE IF EXISTS USUARIO;
DROP TABLE IF EXISTS Reserva;
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Habitacion;
DROP TABLE IF EXISTS EstadoHabitacion;
DROP TABLE IF EXISTS TipoHabitacion;

-- 
CREATE TABLE TipoHabitacion (
    ID_TipoH int NOT NULL AUTO_INCREMENT,
    Nom_TipoH VARCHAR(30) NOT NULL,
    PRIMARY KEY (ID_TipoH)
);

--
CREATE TABLE EstadoHabitacion (
    ID_EstadoH int NOT NULL AUTO_INCREMENT,
    Nom_EstadoH VARCHAR(30) NOT NULL,
    PRIMARY KEY (ID_EstadoH)
);

-- 
CREATE TABLE Habitacion (
    ID_Habitacion int NOT NULL AUTO_INCREMENT,
    ID_TipoH int NOT NULL,
    Precio DOUBLE NOT NULL,
    Comodidades VARCHAR(100) NOT NULL,
    ID_EstadoH int NOT NULL,
    PRIMARY KEY (ID_Habitacion),
    CONSTRAINT H_FK1 FOREIGN KEY (ID_TipoH) REFERENCES TipoHabitacion (ID_TipoH),
    CONSTRAINT H_FK2 FOREIGN KEY (ID_EstadoH) REFERENCES EstadoHabitacion (ID_EstadoH)
);

--
CREATE TABLE Cliente (
    ID_Cliente int(11) NOT NULL AUTO_INCREMENT,
    NombreC VARCHAR(30) NOT NULL,
    ApellidoC VARCHAR(30) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    DNI VARCHAR(10) NOT NULL,
    Telefono INT NOT NULL,
    PRIMARY KEY (ID_Cliente)
);

-- 
CREATE TABLE Reserva (
    ID_Reserva int NOT NULL AUTO_INCREMENT,
    ID_Cliente int(11) NOT NULL,
    ID_Habitacion int NOT NULL,
    FechaInicio DATE NOT NULL,
    FechaFin DATE NOT NULL,
    PRIMARY KEY (ID_Reserva),
    CONSTRAINT R_FK1 FOREIGN KEY (ID_Cliente) REFERENCES Cliente (ID_Cliente),
    CONSTRAINT R_FK2 FOREIGN KEY (ID_Habitacion) REFERENCES Habitacion (ID_Habitacion)
);

-- 
CREATE TABLE USUARIO (
    COD_USU INT NOT NULL AUTO_INCREMENT,
    LOG_USU VARCHAR(15) DEFAULT NULL,
    PAS_USU VARCHAR(15) DEFAULT NULL,
    NOM_USU VARCHAR(30) DEFAULT NULL,
    APE_USU VARCHAR(50) DEFAULT NULL,
    EST_USU CHAR(1) DEFAULT NULL,
    PRIMARY KEY (COD_USU)
);

-- 
CREATE TABLE MENU (
    COD_MEN INT NOT NULL AUTO_INCREMENT,
    DES_MEN VARCHAR(30) DEFAULT NULL,
    URL_MEN VARCHAR(400) DEFAULT NULL,
    PRIMARY KEY (COD_MEN)
);

--
CREATE TABLE ACCESO (
    COD_MENU int NOT NULL,
    COD_USU int NOT NULL,
    PRIMARY KEY (COD_MENU, COD_USU),
    KEY COD_USU (COD_USU),
    CONSTRAINT ACCESO_FK1 FOREIGN KEY (COD_MENU) REFERENCES MENU (COD_MEN),
    CONSTRAINT ACCESO_FK2 FOREIGN KEY (COD_USU) REFERENCES USUARIO (COD_USU)
);


select * from CLIENTE;
select * from Reserva;

-- Insertar en TipoHabitacion
INSERT INTO TipoHabitacion (Nom_TipoH) VALUES ('Doble');
INSERT INTO TipoHabitacion (Nom_TipoH) VALUES ('Simple');
INSERT INTO TipoHabitacion (Nom_TipoH) VALUES ('Matrimonial');
INSERT INTO TipoHabitacion (Nom_TipoH) VALUES ('Presidencial');
-- Insertar en EstadoHabitacion
INSERT INTO EstadoHabitacion (Nom_EstadoH) VALUES ('Disponible');
INSERT INTO EstadoHabitacion (Nom_EstadoH) VALUES ('Reservado');


-- Insertar en Habitacion
INSERT INTO Habitacion ( ID_TipoH, Precio, Comodidades, ID_EstadoH)
VALUES ( 1, 100.0, 'Wifi, TV, Baño privado', 1);
INSERT INTO Habitacion (ID_TipoH, Precio, Comodidades, ID_EstadoH)
VALUES (2, 200.0, 'vista al mar', 1);
INSERT INTO Habitacion (ID_TipoH, Precio, Comodidades, ID_EstadoH)
VALUES (1, 100.0, 'comodidades 3', 1);
INSERT INTO Habitacion (ID_TipoH, Precio, Comodidades, ID_EstadoH)
VALUES (2, 400.0, 'vista al mar y sofa cama', 1);

select * from habitacion;

-- Insertar en Cliente
INSERT INTO Cliente (NombreC, ApellidoC, Email, DNI, Telefono)
VALUES ('Mimi', 'grrr', 'mimi@gmail.com', '7256389', 987654321),
('Leyla', 'Diaz', 'leyla@gmail.com', '74128277', 994062228),
('Maemos', 'Cueto', 'maemosa@gmail.com', '75773314', 975441947),
('Stephanie', 'Garro', 'steph@gmail.com', '777777777', 999999999),
('Sebastian', 'Choque', 'sebas@gmail.com', '74128322', 994987652)
;

-- Insertar en Reserva
INSERT INTO Reserva (ID_Cliente, ID_Habitacion, FechaInicio, FechaFin)
VALUES (1, 1, '2024-07-05', '2024-07-10');

-- ------

-- Insertar en USUARIO
INSERT INTO USUARIO (LOG_USU, PAS_USU, NOM_USU, APE_USU, EST_USU)
VALUES ('admin', 'admin123', 'Bruno', 'Brunito', 'Activo');

select * from usuario;

-- Insertar en MENU
INSERT INTO MENU (DES_MEN, URL_MEN)
VALUES ('Listado Clientes', '/ListadoClientes.jsp');

-- Asignar acceso a los menús para los usuarios
INSERT INTO ACCESO (COD_MENU, COD_USU)
VALUES
    (1, 1), -- Menú 'Inicio' asignado al usuario 'admin'


-- Stored Procedure
DELIMITER //
CREATE PROCEDURE ListarHabitacionesConDetalles()
BEGIN
    SELECT h.ID_Habitacion, th.Nom_TipoH AS Tipo_Habitacion, h.Precio, h.Comodidades, eh.Nom_EstadoH AS Estado_Habitacion
    FROM Habitacion h
    INNER JOIN TipoHabitacion th ON h.ID_TipoH = th.ID_TipoH
    INNER JOIN EstadoHabitacion eh ON h.ID_EstadoH = eh.ID_EstadoH;
END //

DELIMITER ;

-- -----------
DELIMITER //

CREATE PROCEDURE ListarReservasConDetalles()
BEGIN
    SELECT r.ID_Reserva, c.NombreC AS Nombre_Cliente, h.ID_Habitacion, r.FechaInicio, r.FechaFin
    FROM Reserva r
    INNER JOIN Cliente c ON r.ID_Cliente = c.ID_Cliente
    INNER JOIN Habitacion h ON r.ID_Habitacion = h.ID_Habitacion;
END //

DELIMITER ;

CALL ListarReservasConDetalles();
CALL ListarHabitacionesConDetalles();


CREATE DATABASE IF NOT EXISTS CarteraDB;

USE CarteraDB;

CREATE TABLE IF NOT EXISTS Tarjetas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numeroDeCuenta VARCHAR(50) NOT NULL,
    valorApertura DOUBLE NOT NULL,
    mes VARCHAR(20) NOT NULL,
    tipo ENUM('Joven', 'Nomina', 'Visa') NOT NULL
);

-- Puedes agregar una tabla de descuentos si quieres almacenar tipos de descuentos de forma más flexible
CREATE TABLE IF NOT EXISTS Descuentos (
    tipo ENUM('BASICO', 'PLATINO', 'DIAMANTE') PRIMARY KEY,
    porcentaje DOUBLE NOT NULL
);

-- Inserta algunos descuentos predeterminados
INSERT INTO Descuentos (tipo, porcentaje) VALUES ('BASICO', 0.11), ('PLATINO', 0.15), ('DIAMANTE', 0.18);

select * from Tarjetas;
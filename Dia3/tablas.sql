-- Active: 1721826606613@@bhr9agww1d8bmr3zluxy-mysql.services.clever-cloud.com@3306@bhr9agww1d8bmr3zluxy
-- ################################
-- ###### Creacion de tablas ######
-- ################################

use bhr9agww1d8bmr3zluxy;

create table persona(
    id_persona int primary key,
    nombres varchar(100) not null,
    apellidos varchar(100) not null,
    titulo varchar(100) not null,
    nombre_pila varchar(100) not null,
    direccion varchar(225) not null
);

create table hospital(
    id_hospital int primary key,
    nombre varchar(100) not null,
    direccion varchar(225) not null
);

create table departamento(
    id_departamento int primary key,
    nombre varchar(100),
    id_hospital int not null,
    Foreign Key (id_hospital) REFERENCES hospital(id_hospital)
);

create table pabellon(
    id_pabellon int primary key,
    nombre varchar(100) not null,
    capacidad int(3) not null
);

create table paciente(
    id_paciente int primary key,
    id_persona int not null,
    Foreign Key (id_persona) REFERENCES persona(id_persona),
    fecha_nacimiento date,
    fecha_ingreso date,
    edad int,
    id_pabellon int not null,
    Foreign Key (id_pabellon) REFERENCES pabellon(id_pabellon)
);

create table personal(
    id_personal int primary key,
    id_persona int not null,
    Foreign Key (id_persona) REFERENCES persona(id_persona),
    fecha_vinculacion date not null,
    salario decimal(10,2) not null,
    id_departamento int not null,
    Foreign Key (id_departamento) REFERENCES departamento(id_departamento)
);

create table doctor(
    id_doctor int primary key,
    id_persona int not null,
    Foreign Key (id_persona) REFERENCES persona(id_persona),
    tipo varchar(50) not null
);

create table equipo(
    id_equipo int primary key,
    id_hospital int not null,
    Foreign Key (id_hospital) REFERENCES hospital(id_hospital)
);

create table doctor_equipo(
    id_equipo int,
    id_doctor int,
    primary key(id_equipo, id_doctor),
    Foreign Key (id_equipo) REFERENCES equipo(id_equipo),
    Foreign Key (id_doctor) REFERENCES doctor(id_doctor)
);
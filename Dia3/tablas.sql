-- Active: 1721855128002@@127.0.0.1@3306@Hospital

-- ################################
-- ###### Creacion de tablas ######
-- ################################

create database Hospital;

use Hospital;

create table persona (
    id int primary key,
    nombres varchar(255) not null,
    apellidos varchar(255) not null,
    direccion varchar(255) not null,
    fecha_nacimiento date not null, 
    titulo varchar(50)
);

create table hospital(
    id int primary key,
    nombre varchar(255) not null,
    direccion varchar(255) not null
)

create table pabellon (
    id int primary key,
    nombre varchar(255) not null,
    capacidad int,
    id_hospital int,
    Foreign Key (id_hospital) REFERENCES hospital(id_hospital)
)

create table paciente (
    id int primary key,
    fehca_ingreso date not null,
    diagnostico varchar(255) not null,
    id_pabellon int,
    Foreign Key (id) REFERENCES persona(id),
    Foreign Key (id_pabellon) REFERENCES pabellon(id)
)
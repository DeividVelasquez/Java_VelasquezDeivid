
-- ################################
-- ###### Creacion de tablas ######
-- ################################

create database Hospital;

use Hospital;

create table persona (
    id int auto_increment primary key,
    nombres varchar(255) not null,
    apellidos varchar(255) not null,
    direccion varchar(255) not null,
    fecha_nacimiento date not null, 
    titulo varchar(50)
);

create table hospital(
    id int auto_increment primary key,
    nombre varchar(255) not null,
    direccion varchar(255) not null
);

create table persona_hospital(
    id_persona int,
    id_hospital int,
    primary key(id_persona, id_hospital),
    Foreign Key (id_persona) REFERENCES persona(id),
    Foreign Key (id_hospital) REFERENCES hospital(id)
);

create table departamento(
    id int auto_increment primary key,
    nombre varchar(255) not null,
    id_hospital int not null,
    Foreign Key (id_hospital) REFERENCES hospital(id)
);

create table pabellon (
    id int auto_increment primary key,
    nombre varchar(255) not null,
    capacidad int not null,
    id_hospital int not null,
    Foreign Key (id_hospital) REFERENCES hospital(id)
);

create table paciente (
    id int auto_increment primary key,
    fehca_ingreso date not null,
    diagnostico varchar(255) not null,
    id_pabellon int not null,
    Foreign Key (id) REFERENCES persona(id),
    Foreign Key (id_pabellon) REFERENCES pabellon(id)
);

create table personal(
    id int auto_increment primary key,
    fecha_vinculacion date not null,
    salario decimal(10,2) not null,
    id_departamento int not null,
    tipo varchar(50),
    Foreign Key (id) REFERENCES persona(id),
    Foreign Key (id_departamento) REFERENCES departamento(id)
);

create table equipoMedico(
    id int auto_increment primary key,
    nombre varchar(255) not null,
    id_lider int not null,
    Key (id_lider)
);

create table doctor(
    id int auto_increment primary key,
    tipo varchar(50) not null,
    id_equipoMedico int not null,
    Foreign Key (id) REFERENCES personal(id),
    Foreign Key (id_equipoMedico) REFERENCES equipoMedico(id)
);

create table enfermera(
    id int auto_increment primary key,
    Foreign Key (id) REFERENCES personal(id)
);

create table tecnico(
    id int auto_increment primary key,
    tipo varchar(50) not null,
    Foreign Key (id) REFERENCES personal(id)
);

insert into persona values("1", "Deivid", "Velasquez", "Calle104a", "2007-04-21", "Bachiller");

select * from persona;
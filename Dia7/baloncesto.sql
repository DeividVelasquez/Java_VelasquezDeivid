-- Active: 1722888963083@@bicgnrjz9nek32oc7te0-mysql.services.clever-cloud.com@3306@bicgnrjz9nek32oc7te0

use bicgnrjz9nek32oc7te0;

create table partido(
    id int AUTO_INCREMENT PRIMARY KEY,
    equipoLocal varchar(225) not null,
    equipoVisitante varchar(225) not null,
    cestasLocal int not null,
    cestasVisitante int not null,
    estado enum("Activo", "Finalizado") not null,
    fechaPartido date not null
);

create table liga (
    id int AUTO_INCREMENT PRIMARY KEY,
    id_partido int not null,
    Foreign Key (id_partido) REFERENCES partido(id) ON DELETE CASCADE,
    jornada int not null
);

create table playOffs (
    id int AUTO_INCREMENT PRIMARY KEY,
    id_partido int not null,
    Foreign Key (id_partido) REFERENCES partido(id) ON DELETE CASCADE,
    ronda enum("Octavos", "Cuartos", "Final") not null
);




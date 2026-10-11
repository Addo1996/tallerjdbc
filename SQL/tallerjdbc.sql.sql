create table vehiculos(
placa varchar(10),
marca varchar(50) not null,
modelo varchar(50) not null,
anio int not null,
precio double precision not null,
color varchar (30),
disponible boolean not null,

constraint vehiculos_pk primary key(placa)
)


ALTER TABLE vehiculos ADD kilometraje INT;



SELECT * FROM vehiculos;

SELECT placa, marca, modelo, kilometraje FROM vehiculos;


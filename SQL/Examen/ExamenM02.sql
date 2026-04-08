create or replace TYPE Categoria AS OBJECT(
  idCat number(2),
  nom VARCHAR2(9),
  cubicatge number(4),
  minEdat number(2)
);
/
create table Categories of Categoria;
alter table Categories add constraint pk_Categories primary key (idCat);

create or replace TYPE Pilot AS OBJECT(
  nom VARCHAR2(20),
  cognom VARCHAR2(20),
  anyNaix number(4),
  nacionalitat VARCHAR2(3),
  numero number(2),
  categoria number(2)
);
/
create table Pilots of Pilot;
alter table Pilots add constraint pk_Pilots primary key (nom,cognom);

create or replace TYPE Escuderia AS OBJECT(
  nom VARCHAR2(40),
  motor VARCHAR2(20),
  categoria number(2)
);
/
create table Escuderies of Escuderia;
alter table Escuderies add constraint pk_Escuderia primary key (nom);


create table PilotEscuderia(
  temporada number(4),
  pilot Pilot,
  escuderia Escuderia,
  constraint chk_Escudieria check (escuderia.categoria = pilot.categoria)
);
/

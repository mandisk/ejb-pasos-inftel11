
CREATE TABLE Disponibilidad
(
	id                   INTEGER NOT NULL ,
	descripcion          VARCHAR2(200) NULL 
);

CREATE UNIQUE INDEX XPKDisponibilidad ON Disponibilidad
(id   ASC);

ALTER TABLE Disponibilidad
	ADD CONSTRAINT  XPKDisponibilidad PRIMARY KEY (id);

CREATE TABLE Empleados
(
	id_empleado          INTEGER NOT NULL ,
	id_persona           INTEGER NULL ,
	id_turno             INTEGER NULL 
);

CREATE UNIQUE INDEX XPKEmpleados ON Empleados
(id_empleado   ASC);

ALTER TABLE Empleados
	ADD CONSTRAINT  XPKEmpleados PRIMARY KEY (id_empleado);

CREATE TABLE Familiares
(
	idfamiliar           INTEGER NOT NULL ,
	id_disponibilidad    INTEGER NULL ,
	id_usuario           INTEGER NULL ,
	id_persona           INTEGER NULL 
);

CREATE UNIQUE INDEX XPKFamiliares ON Familiares
(idfamiliar   ASC);

ALTER TABLE Familiares
	ADD CONSTRAINT  XPKFamiliares PRIMARY KEY (idfamiliar);

CREATE TABLE Incidencias
(
	incidencia           INTEGER NOT NULL ,
	fecha                TIMESTAMP NULL ,
	longitud             VARCHAR2(20) NULL ,
	latitud              VARCHAR2(20) NULL ,
	altitud              VARCHAR2(20) NULL ,
	temperatura          FLOAT NULL ,
	nivel_bateria        INTEGER NULL ,
	num_satelites        INTEGER NULL ,
	id_tincidencia       INTEGER NULL ,
	id_usuario           INTEGER NULL 
);

CREATE UNIQUE INDEX XPKIncidencias ON Incidencias
(incidencia   ASC);

ALTER TABLE Incidencias
	ADD CONSTRAINT  XPKIncidencias PRIMARY KEY (incidencia);

CREATE TABLE Personas
(
	id_persona           INTEGER NOT NULL ,
	telefono             INTEGER NULL ,
	apellido1            VARCHAR2(50) NULL ,
	apellido2            VARCHAR2(50) NULL ,
	direccion            VARCHAR2(50) NULL ,
	localidad            VARCHAR2(100) NULL ,
	provincia            VARCHAR2(50) NULL ,
	codpostal            INTEGER NULL ,
	fecnacimiento        DATE NULL ,
	email                VARCHAR2(50) NULL 
);

CREATE UNIQUE INDEX XPKPersonas ON Personas
(id_persona   ASC);

ALTER TABLE Personas
	ADD CONSTRAINT  XPKPersonas PRIMARY KEY (id_persona);

CREATE TABLE Tipo_incidencias
(
	id                   INTEGER NOT NULL ,
	descripcion          VARCHAR2(200) NULL 
);

CREATE UNIQUE INDEX XPKTipo_incidencias ON Tipo_incidencias
(id   ASC);

ALTER TABLE Tipo_incidencias
	ADD CONSTRAINT  XPKTipo_incidencias PRIMARY KEY (id);

CREATE TABLE Turnos
(
	turno                INTEGER NOT NULL ,
	descripcion          VARCHAR2(200) NULL 
);

CREATE UNIQUE INDEX XPKTurnos ON Turnos
(turno   ASC);

ALTER TABLE Turnos
	ADD CONSTRAINT  XPKTurnos PRIMARY KEY (turno);

CREATE TABLE Usuarios
(
	IMEI                 INTEGER NOT NULL ,
	foto                 BLOB NULL ,
	id_persona           INTEGER NULL 
);

CREATE UNIQUE INDEX XPKUsuarios ON Usuarios
(IMEI   ASC);

ALTER TABLE Usuarios
	ADD CONSTRAINT  XPKUsuarios PRIMARY KEY (IMEI);

ALTER TABLE Empleados
	ADD (CONSTRAINT R_7 FOREIGN KEY (id_persona) REFERENCES Personas (id_persona) ON DELETE SET NULL);

ALTER TABLE Empleados
	ADD (CONSTRAINT R_8 FOREIGN KEY (id_turno) REFERENCES Turnos (turno) ON DELETE SET NULL);

ALTER TABLE Familiares
	ADD (CONSTRAINT R_2 FOREIGN KEY (id_disponibilidad) REFERENCES Disponibilidad (id) ON DELETE SET NULL);

ALTER TABLE Familiares
	ADD (CONSTRAINT R_3 FOREIGN KEY (id_usuario) REFERENCES Usuarios (IMEI) ON DELETE SET NULL);

ALTER TABLE Familiares
	ADD (CONSTRAINT R_6 FOREIGN KEY (id_persona) REFERENCES Personas (id_persona) ON DELETE SET NULL);

ALTER TABLE Incidencias
	ADD (CONSTRAINT R_4 FOREIGN KEY (id_tincidencia) REFERENCES Tipo_incidencias (id) ON DELETE SET NULL);

ALTER TABLE Incidencias
	ADD (CONSTRAINT R_5 FOREIGN KEY (id_usuario) REFERENCES Usuarios (IMEI) ON DELETE SET NULL);

ALTER TABLE Usuarios
	ADD (CONSTRAINT R_9 FOREIGN KEY (id_persona) REFERENCES Personas (id_persona) ON DELETE SET NULL);

/


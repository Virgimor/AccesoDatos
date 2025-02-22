DROP DATABASE EMPLEADOS;

CREATE DATABASE EMPLEADOS;

USE EMPLEADOS;

DROP DATABASE IF EXISTS EMPLEADOS;

CREATE DATABASE EMPLEADOS;

USE EMPLEADOS;

CREATE TABLE regiones (
    id_region DECIMAL(10,0) PRIMARY KEY, 
    nombre_region VARCHAR(25) 
);

CREATE TABLE paises ( 
    id_pais CHAR(2) PRIMARY KEY, 
    nombre_pais VARCHAR(40),
    id_region DECIMAL(10,0),
    CONSTRAINT fk_pais_region FOREIGN KEY (id_region) REFERENCES regiones(id_region)
); 

CREATE TABLE ubicaciones ( 
    id_ubicacion DECIMAL(4,0) PRIMARY KEY, 
    direccion VARCHAR(40),
    codigo_postal VARCHAR(12),
    ciudad VARCHAR(30) NOT NULL,
    estado_provincia VARCHAR(25),
    id_pais CHAR(2),
    CONSTRAINT fk_ubi_pais FOREIGN KEY (id_pais) REFERENCES paises(id_pais)
);

CREATE TABLE departamentos ( 
    id_departamento DECIMAL(4,0) PRIMARY KEY,
    nombre_departamento VARCHAR(30) NOT NULL,
    id_gerente DECIMAL(6, 0),
    id_ubicacion DECIMAL(4, 0),
    CONSTRAINT fk_dept_ubicacion FOREIGN KEY (id_ubicacion) REFERENCES ubicaciones(id_ubicacion)
);

CREATE TABLE puestos ( 
    id_puesto VARCHAR(10) PRIMARY KEY, 
    titulo_puesto VARCHAR(50) NOT NULL, 
    salario_min DECIMAL(6, 0), 
    salario_max DECIMAL(6, 0)
);

CREATE TABLE empleados ( 
    id_empleado DECIMAL(6, 0) PRIMARY KEY, 
    nombre VARCHAR(20), 
    apellido VARCHAR(25) NOT NULL,
    email VARCHAR(25) NOT NULL,
    telefono VARCHAR(20),
    fecha_contrato DATE NOT NULL,
    id_puesto VARCHAR(10),
    salario DECIMAL(8,2),
    comision_pct DECIMAL(2,2),
    id_gerente DECIMAL(6,0),
    id_departamento DECIMAL(4,0),
    CONSTRAINT fk_emp_puesto FOREIGN KEY (id_puesto) REFERENCES puestos(id_puesto),
    CONSTRAINT fk_emp_departamento FOREIGN KEY (id_departamento) REFERENCES departamentos(id_departamento),
    CONSTRAINT fk_emp_gerente FOREIGN KEY (id_gerente) REFERENCES empleados(id_empleado),
    CONSTRAINT emp_salario_min CHECK (salario > 0),
    CONSTRAINT emp_email_uk UNIQUE (email)
);

CREATE TABLE historial_puestos ( 
    id_empleado DECIMAL(6,0), 
    fecha_inicio DATE NOT NULL, 
    fecha_fin DATE NOT NULL, 
    id_puesto VARCHAR(10), 
    id_departamento DECIMAL(4,0), 
    CONSTRAINT fk_hist_empleado FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado),
    CONSTRAINT fk_hist_puesto FOREIGN KEY (id_puesto) REFERENCES puestos(id_puesto),
    CONSTRAINT fk_hist_departamento FOREIGN KEY (id_departamento) REFERENCES departamentos(id_departamento),
    CONSTRAINT hist_emp_fecha_pk PRIMARY KEY (id_empleado, fecha_inicio),
    CONSTRAINT hist_fecha_intervalo CHECK (fecha_fin > fecha_inicio)
);

ALTER TABLE departamentos ADD CONSTRAINT fk_departamentos_empleados_gerente FOREIGN KEY (id_gerente) REFERENCES empleados(id_empleado) ;

COMMIT;

INSERT INTO regiones VALUES (1, 'Europa');
INSERT INTO regiones VALUES (2, 'Américas');
INSERT INTO regiones VALUES (3, 'Asia');
INSERT INTO regiones VALUES (4, 'Medio Oriente y África');

INSERT INTO paises VALUES ('IT', 'Italia', 1);
INSERT INTO paises VALUES ('JP', 'Japón', 3);
INSERT INTO paises VALUES ('US', 'Estados Unidos de América', 2);
INSERT INTO paises VALUES ('CA', 'Canadá', 2);
INSERT INTO paises VALUES ('CN', 'China', 3);
INSERT INTO paises VALUES ('IN', 'India', 3);
INSERT INTO paises VALUES ('AU', 'Australia', 3);
INSERT INTO paises VALUES ('ZW', 'Zimbabue', 4);
INSERT INTO paises VALUES ('SG', 'Singapur', 3);
INSERT INTO paises VALUES ('UK', 'Reino Unido', 1);
INSERT INTO paises VALUES ('FR', 'Francia', 1);
INSERT INTO paises VALUES ('DE', 'Alemania', 1);
INSERT INTO paises VALUES ('ZM', 'Zambia', 4);
INSERT INTO paises VALUES ('EG', 'Egipto', 4);
INSERT INTO paises VALUES ('BR', 'Brasil', 2);
INSERT INTO paises VALUES ('CH', 'Suiza', 1);
INSERT INTO paises VALUES ('NL', 'Países Bajos', 1);
INSERT INTO paises VALUES ('MX', 'México', 2);
INSERT INTO paises VALUES ('KW', 'Kuwait', 4);
INSERT INTO paises VALUES ('IL', 'Israel', 4);
INSERT INTO paises VALUES ('DK', 'Dinamarca', 1);
INSERT INTO paises VALUES ('HK', 'Hong Kong', 3);
INSERT INTO paises VALUES ('NG', 'Nigeria', 4);
INSERT INTO paises VALUES ('AR', 'Argentina', 2);
INSERT INTO paises VALUES ('BE', 'Bélgica', 1);

COMMIT;

INSERT INTO ubicaciones VALUES ( 1000 , '1297 Via Cola di Rie' , '00989' , 'Roma' , NULL , 'IT' );

INSERT INTO ubicaciones VALUES ( 1100 , '93091 Calle della Testa' , '10934' , 'Venice' , NULL , 'IT' );

INSERT INTO ubicaciones VALUES ( 1200 , '2017 Shinjuku-ku' , '1689' , 'Tokyo' , 'Tokyo Prefecture' , 'JP' );

INSERT INTO ubicaciones VALUES ( 1300 , '9450 Kamiya-cho' , '6823' , 'Hiroshima' , NULL , 'JP' );

INSERT INTO ubicaciones VALUES ( 1400 , '2014 Jabberwocky Rd' , '26192' , 'Southlake' , 'Texas' , 'US' );

INSERT INTO ubicaciones VALUES ( 1500 , '2011 Interiors Blvd' , '99236' , 'South San Francisco' , 'California' , 'US' );

INSERT INTO ubicaciones VALUES ( 1600 , '2007 Zagora St' , '50090' , 'South Brunswick' , 'New Jersey' , 'US' );

INSERT INTO ubicaciones VALUES ( 1700 , '2004 Charade Rd' , '98199' , 'Seattle' , 'Washington' , 'US' );

INSERT INTO ubicaciones VALUES ( 1800 , '147 Spadina Ave' , 'M5V 2L7' , 'Toronto' , 'Ontario' , 'CA' );

INSERT INTO ubicaciones VALUES ( 1900 , '6092 Boxwood St' , 'YSW 9T2' , 'Whitehorse' , 'Yukon' , 'CA' );

INSERT INTO ubicaciones VALUES ( 2000 , '40-5-12 Laogianggen' , '190518' , 'Beijing' , NULL , 'CN' );

INSERT INTO ubicaciones VALUES ( 2100 , '1298 Vileparle (E)' , '490231' , 'Bombay' , 'Maharashtra' , 'IN' );

INSERT INTO ubicaciones VALUES ( 2200 , '12-98 Victoria Street' , '2901' , 'Sydney' , 'New South Wales' , 'AU' );

INSERT INTO ubicaciones VALUES ( 2300 , '198 Clementi North' , '540198' , 'Singapore' , NULL , 'SG' );

INSERT INTO ubicaciones VALUES ( 2400 , '8204 Arthur St' , NULL , 'London' , NULL , 'UK' );

INSERT INTO ubicaciones VALUES ( 2500 , 'Magdalen Centre, The Oxford Science Park' , 'OX9 9ZB' , 'Oxford' , 'Oxford' , 'UK' );

INSERT INTO ubicaciones VALUES ( 2600 , '9702 Chester Road' , '09629850293' , 'Stretford' , 'Manchester' , 'UK' );

INSERT INTO ubicaciones VALUES ( 2700 , 'Schwanthalerstr. 7031' , '80925' , 'Munich' , 'Bavaria' , 'DE' );

INSERT INTO ubicaciones VALUES ( 2800 , 'Rua Frei Caneca 1360 ' , '01307-002' , 'Sao Paulo' , 'Sao Paulo' , 'BR' );

INSERT INTO ubicaciones VALUES ( 2900 , '20 Rue des Corps-Saints' , '1730' , 'Geneva' , 'Geneve' , 'CH' );

INSERT INTO ubicaciones VALUES ( 3000 , 'Murtenstrasse 921' , '3095' , 'Bern' , 'BE' , 'CH' );

INSERT INTO ubicaciones VALUES ( 3100 , 'Pieter Breughelstraat 837' , '3029SK' , 'Utrecht' , 'Utrecht' , 'NL' );

INSERT INTO ubicaciones VALUES ( 3200 , 'Mariano Escobedo 9991' , '11932' , 'Mexico City' , 'Distrito Federal,' , 'MX' );

INSERT INTO departamentos VALUES (10, 'Administración', NULL, 1700);

INSERT INTO departamentos VALUES (20, 'Mercadotecnia', NULL, 1800);

INSERT INTO departamentos VALUES (30, 'Compras', NULL, 1700);

INSERT INTO departamentos VALUES (40, 'Recursos Humanos', NULL, 2400);

INSERT INTO departamentos VALUES (50, 'Envíos', NULL, 1500);

INSERT INTO departamentos VALUES (60, 'TI', NULL, 1400);

INSERT INTO departamentos VALUES (70, 'Relaciones Públicas', NULL, 2700);

INSERT INTO departamentos VALUES (80, 'Ventas', NULL, 2500);

INSERT INTO departamentos VALUES (90, 'Ejecutivo', NULL, 1700);

INSERT INTO departamentos VALUES (100, 'Finanzas', NULL, 1700);

INSERT INTO departamentos VALUES (110, 'Contabilidad', NULL, 1700);

INSERT INTO departamentos VALUES (120, 'Tesorería', NULL, 1700);

INSERT INTO departamentos VALUES (130, 'Impuestos Corporativos', NULL, 1700);

INSERT INTO departamentos VALUES (140, 'Control y Crédito', NULL, 1700);

INSERT INTO departamentos VALUES (150, 'Servicios a Accionistas', NULL, 1700);

INSERT INTO departamentos VALUES (160, 'Beneficios', NULL, 1700);

INSERT INTO departamentos VALUES (170, 'Manufactura', NULL, 1700);

INSERT INTO departamentos VALUES (180, 'Construcción', NULL, 1700);

INSERT INTO departamentos VALUES (190, 'Contratación', NULL, 1700);

INSERT INTO departamentos VALUES (200, 'Operaciones', NULL, 1700);

INSERT INTO departamentos VALUES (210, 'Soporte TI', NULL, 1700);

INSERT INTO departamentos VALUES (220, 'NOC', NULL, 1700);

INSERT INTO departamentos VALUES (230, 'Mesa de Ayuda TI', NULL, 1700);

INSERT INTO departamentos VALUES (240, 'Ventas Gubernamentales', NULL, 1700);

INSERT INTO departamentos VALUES (250, 'Ventas al Detal', NULL, 1700);

INSERT INTO departamentos VALUES (260, 'Reclutamiento', NULL, 1700);

INSERT INTO departamentos VALUES (270, 'Nómina', NULL, 1700);

INSERT INTO puestos VALUES ( 'AD_PRES' , 'Presidente' , 20000 , 40000 ); 

INSERT INTO puestos VALUES ( 'AD_VP' , 'Vicepresidente de Administración' , 15000 , 30000 );

INSERT INTO puestos VALUES ( 'AD_ASST' , 'Asistente de Administración' , 3000 , 6000 );

INSERT INTO puestos VALUES ( 'FI_MGR' , 'Gerente de Finanzas' , 8200 , 16000 );

INSERT INTO puestos VALUES ( 'FI_ACCOUNT' , 'Contador' , 4200 , 9000 );

INSERT INTO puestos VALUES ( 'AC_MGR' , 'Gerente de Contabilidad' , 8200 , 16000 );

INSERT INTO puestos VALUES ( 'AC_ACCOUNT' , 'Contador Público' , 4200 , 9000 ); 

INSERT INTO puestos VALUES ( 'SA_MAN' , 'Gerente de Ventas' , 10000 , 20000 );

INSERT INTO puestos VALUES ( 'SA_REP' , 'Representante de Ventas' , 6000 , 12000 );

INSERT INTO puestos VALUES ( 'PU_MAN' , 'Gerente de Compras' , 8000 , 15000 );

INSERT INTO puestos VALUES ( 'PU_CLERK' , 'Empleado de Compras' , 2500 , 5500 );

INSERT INTO puestos VALUES ( 'ST_MAN' , 'Gerente de Almacén' , 5500 , 8500 ); 

INSERT INTO puestos VALUES ( 'ST_CLERK' , 'Empleado de Almacén' , 2000 , 5000 );

INSERT INTO puestos VALUES ( 'SH_CLERK' , 'Empleado de Envíos' , 2500 , 5500 );

INSERT INTO puestos VALUES ( 'IT_PROG' , 'Programador' , 4000 , 10000 );

INSERT INTO puestos VALUES ( 'MK_MAN' , 'Gerente de Mercadotecnia' , 9000 , 15000 );

INSERT INTO puestos VALUES ( 'MK_REP' , 'Representante de Mercadotecnia' , 4000 , 9000 );

INSERT INTO puestos VALUES ( 'HR_REP' , 'Representante de Recursos Humanos' , 4000 , 9000 );

INSERT INTO puestos VALUES ( 'PR_REP' , 'Representante de Relaciones Públicas' , 4500 , 10500 );

INSERT INTO empleados VALUES 
	( 100, 'Steven', 'King', 'SKING', '515.123.4567', '1987-06-17', 'AD_PRES', 24000, NULL, NULL, 90);

INSERT INTO empleados VALUES 
    (101, 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', 17000, NULL, 100, 90);

INSERT INTO empleados VALUES 
    (102, 'Lex', 'De Haan', 'LDEHAAN', '515.123.4569', '1993-01-13', 'AD_VP', 17000, NULL, 100, 90);

INSERT INTO empleados VALUES 
    (103, 'Alexander', 'Hunold', 'AHUNOLD', '590.423.4567', '1990-01-03', 'IT_PROG', 9000, NULL, 102, 60);

INSERT INTO empleados VALUES 
    (104, 'Bruce', 'Ernst', 'BERNST', '590.423.4568', '1991-05-21', 'IT_PROG', 6000, NULL, 103, 60);

INSERT INTO empleados VALUES 
    (105, 'David', 'Austin', 'DAUSTIN', '590.423.4569', '1997-06-25', 'IT_PROG', 4800, NULL, 103, 60);

INSERT INTO empleados VALUES 
    (106, 'Valli', 'Pataballa', 'VPATABAL', '590.423.4560', '1998-02-05', 'IT_PROG', 4800, NULL, 103, 60);

INSERT INTO empleados VALUES 
    (107, 'Diana', 'Lorentz', 'DLORENTZ', '590.423.5567', '1999-02-07', 'IT_PROG', 4200, NULL, 103, 60);

INSERT INTO empleados VALUES 
    (108, 'Nancy', 'Greenberg', 'NGREENBE', '515.124.4569', '1994-08-17', 'FI_MGR', 12000, NULL, 101, 100);

INSERT INTO empleados VALUES 
    (109, 'Daniel', 'Faviet', 'DFAVIET', '515.124.4169', '1994-08-16', 'FI_ACCOUNT', 9000, NULL, 108, 100);

INSERT INTO empleados VALUES 
    (110, 'John', 'Chen', 'JCHEN', '515.124.4269', '1997-09-28', 'FI_ACCOUNT', 8200, NULL, 108, 100);

INSERT INTO empleados VALUES 
    (111, 'Ismael', 'Sciarra', 'ISCIARRA', '515.124.4369', '1997-09-30', 'FI_ACCOUNT', 7700, NULL, 108, 100);

INSERT INTO empleados VALUES 
    (112, 'Jose Manuel', 'Urman', 'JMURMAN', '515.124.4469', '1998-03-07', 'FI_ACCOUNT', 7800, NULL, 108, 100);

INSERT INTO empleados VALUES 
    (113, 'Luis', 'Popp', 'LPOPP', '515.124.4567', '1999-12-07', 'FI_ACCOUNT', 6900, NULL, 108, 100);

INSERT INTO empleados VALUES 
    (114, 'Den', 'Raphaely', 'DRAPHEAL', '515.127.4561', '1994-12-07', 'PU_MAN', 11000, NULL, 100, 30);

INSERT INTO empleados VALUES 
    (115, 'Alexander', 'Khoo', 'AKHOO', '515.127.4562', '1995-05-18', 'PU_CLERK', 3100, NULL, 114, 30);

INSERT INTO empleados VALUES 
    (116, 'Shelli', 'Baida', 'SBAIDA', '515.127.4563', '1997-12-24', 'PU_CLERK', 2900, NULL, 114, 30);

INSERT INTO empleados VALUES 
    (117, 'Sigal', 'Tobias', 'STOBIAS', '515.127.4564', '1997-07-24', 'PU_CLERK', 2800, NULL, 114, 30);

INSERT INTO empleados VALUES 
    (118, 'Guy', 'Himuro', 'GHIMURO', '515.127.4565', '1998-11-15', 'PU_CLERK', 2600, NULL, 114, 30);

INSERT INTO empleados VALUES 
    (119, 'Karen', 'Colmenares', 'KCOLMENA', '515.127.4566', '1999-08-10', 'PU_CLERK', 2500, NULL, 114, 30);

INSERT INTO empleados VALUES 
    (120, 'Matthew', 'Weiss', 'MWEISS', '650.123.1234', '1996-07-18', 'ST_MAN', 8000, NULL, 100, 50);

INSERT INTO empleados VALUES 
    (121, 'Adam', 'Fripp', 'AFRIPP', '650.123.2234', '1997-04-10', 'ST_MAN', 8200, NULL, 100, 50);

INSERT INTO empleados VALUES 
    (122, 'Payam', 'Kaufling', 'PKAUFLIN', '650.123.3234', '1995-05-01', 'ST_MAN', 7900, NULL, 100, 50);

INSERT INTO empleados VALUES 
    (123, 'Shanta', 'Vollman', 'SVOLLMAN', '650.123.4234', '1997-10-10', 'ST_MAN', 6500, NULL, 100, 50);

INSERT INTO empleados VALUES 
    (124, 'Kevin', 'Mourgos', 'KMOURGOS', '650.123.5234', '1999-11-16', 'ST_MAN', 5800, NULL, 100, 50);

INSERT INTO empleados VALUES 
    (125, 'Julia', 'Nayer', 'JNAYER', '650.124.1214', '1997-07-16', 'ST_CLERK', 3200, NULL, 120, 50);

INSERT INTO empleados VALUES 
    (126, 'Irene', 'Mikkilineni', 'IMIKKILI', '650.124.1224', '1998-09-28', 'ST_CLERK', 2700, NULL, 120, 50);

INSERT INTO empleados VALUES 
    (127, 'James', 'Landry', 'JLANDRY', '650.124.1334', '1999-01-14', 'ST_CLERK', 2400, NULL, 120, 50);

INSERT INTO empleados VALUES 
    (128, 'Steven', 'Markle', 'SMARKLE', '650.124.1434', '2000-03-08', 'ST_CLERK', 2200, NULL, 120, 50);

INSERT INTO empleados VALUES 
    (129, 'Laura', 'Bissot', 'LBISSOT', '650.124.5234', '1997-08-20', 'ST_CLERK', 3300, NULL, 121, 50);

INSERT INTO empleados VALUES 
    (130, 'Mozhe', 'Atkinson', 'MATKINSO', '650.124.6234', '1997-10-30', 'ST_CLERK', 2800, NULL, 121, 50);

INSERT INTO empleados VALUES 
    (131, 'James', 'Marlow', 'JAMRLOW', '650.124.7234', '1997-02-16', 'ST_CLERK', 2500, NULL, 121, 50);

INSERT INTO empleados VALUES 
    (132, 'TJ', 'Olson', 'TJOLSON', '650.124.8234', '1999-04-10', 'ST_CLERK', 2100, NULL, 121, 50);

INSERT INTO empleados VALUES 
    (133, 'Jason', 'Mallin', 'JMALLIN', '650.127.1934', '1996-06-14', 'ST_CLERK', 3300, NULL, 122, 50);

INSERT INTO empleados VALUES 
    (134, 'Michael', 'Rogers', 'MROGERS', '650.127.1834', '1998-08-26', 'ST_CLERK', 2900, NULL, 122, 50);

INSERT INTO empleados VALUES 
    (135, 'Ki', 'Gee', 'KGEE', '650.127.1734', '1999-12-12', 'ST_CLERK', 2400, NULL, 122, 50);

INSERT INTO empleados VALUES 
    (136, 'Hazel', 'Philtanker', 'HPHILTAN', '650.127.1634', '2000-02-06', 'ST_CLERK', 2200, NULL, 122, 50);

INSERT INTO empleados VALUES 
    (137, 'Renske', 'Ladwig', 'RLADWIG', '650.121.1234', '1995-07-14', 'ST_CLERK', 3600, NULL, 123, 50);

INSERT INTO empleados VALUES 
    (138, 'Stephen', 'Stiles', 'SSTILES', '650.121.2034', '1997-10-26', 'ST_CLERK', 3200, NULL, 123, 50);

INSERT INTO empleados VALUES 
    (139, 'John', 'Seo', 'JSEO', '650.121.2019', '1998-02-12', 'ST_CLERK', 2700, NULL, 123, 50);

INSERT INTO empleados VALUES 
    (140, 'Joshua', 'Patel', 'JPATEL', '650.121.1834', '1998-04-06', 'ST_CLERK', 2500, NULL, 123, 50);

INSERT INTO empleados VALUES 
    (141, 'Trenna', 'Rajs', 'TRAJS', '650.121.8009', '1995-10-17', 'ST_CLERK', 3500, NULL, 124, 50);

INSERT INTO empleados VALUES 
    (142, 'Curtis', 'Davies', 'CDAVIES', '650.121.2994', '1997-01-29', 'ST_CLERK', 3100, NULL, 124, 50);

INSERT INTO empleados VALUES 
    (143, 'Randall', 'Matos', 'RMATOS', '650.121.2874', '1998-03-15', 'ST_CLERK', 2600, NULL, 124, 50);

INSERT INTO empleados VALUES 
    (144, 'Peter', 'Vargas', 'PVARGAS', '650.121.2004', '1998-07-09', 'ST_CLERK', 2500, NULL, 124, 50);

INSERT INTO empleados VALUES 
    (145, 'John', 'Russell', 'JRUSSEL', '011.44.1344.429268', '1996-10-01', 'SA_MAN', 14000, 0.4, 100, 80);

INSERT INTO empleados VALUES 
    (146, 'Karen', 'Partners', 'KPARTNER', '011.44.1344.467268', '1997-01-05', 'SA_MAN', 13500, 0.3, 100, 80);

INSERT INTO empleados VALUES 
    (147, 'Alberto', 'Errazuriz', 'AERRAZUR', '011.44.1344.429278', '1997-03-10', 'SA_MAN', 12000, 0.3, 100, 80);

INSERT INTO empleados VALUES 
    (148, 'Gerald', 'Cambrault', 'GCAMBRAU', '011.44.1344.619268', '1999-10-15', 'SA_MAN', 11000, 0.3, 100, 80);

INSERT INTO empleados VALUES 
    (149, 'Eleni', 'Zlotkey', 'EZLOTKEY', '011.44.1344.429018', '2000-01-29', 'SA_MAN', 10500, 0.2, 100, 80);

INSERT INTO empleados VALUES 
    (150, 'Peter', 'Tucker', 'PTUCKER', '011.44.1344.129268', '1997-01-30', 'SA_REP', 10000, 0.3, 145, 80);

INSERT INTO empleados VALUES 
    (151, 'David', 'Bernstein', 'DBERNSTE', '011.44.1344.345268', '1997-03-24', 'SA_REP', 9500, 0.25, 145, 80);

INSERT INTO empleados VALUES 
    (152, 'Peter', 'Hall', 'PHALL', '011.44.1344.478968', '1997-08-20', 'SA_REP', 9000, 0.25, 145, 80);

INSERT INTO empleados VALUES 
    (153, 'Christopher', 'Olsen', 'COLSEN', '011.44.1344.498718', '1998-03-30', 'SA_REP', 8000, 0.2, 145, 80);

INSERT INTO empleados VALUES 
    (154, 'Nanette', 'Cambrault', 'NCAMBRAU', '011.44.1344.987668', '1998-12-09', 'SA_REP', 7500, 0.2, 145, 80);

INSERT INTO empleados VALUES 
    (155, 'Oliver', 'Tuvault', 'OTUVAULT', '011.44.1344.486508', '1999-11-23', 'SA_REP', 7000, 0.15, 145, 80);

INSERT INTO empleados VALUES 
    (156, 'Janette', 'King', 'JKING', '011.44.1345.429268', '1996-01-30', 'SA_REP', 10000, 0.35, 146, 80);

INSERT INTO empleados VALUES 
    (157, 'Patrick', 'Sully', 'PSULLY', '011.44.1345.929268', '1996-03-04', 'SA_REP', 9500, 0.35, 146, 80);

INSERT INTO empleados VALUES 
    (158, 'Allan', 'McEwen', 'AMCEWEN', '011.44.1345.829268', '1996-08-01', 'SA_REP', 9000, 0.35, 146, 80);

INSERT INTO empleados VALUES 
    (159, 'Lindsey', 'Smith', 'LSMITH', '011.44.1345.729268', '1997-03-10', 'SA_REP', 8000, 0.3, 146, 80);

INSERT INTO empleados VALUES 
    (160, 'Louise', 'Doran', 'LDORAN', '011.44.1345.629268', '1997-12-15', 'SA_REP', 7500, 0.3, 146, 80);

INSERT INTO empleados VALUES 
    (161, 'Sarath', 'Sewall', 'SSEWALL', '011.44.1345.529268', '1998-11-03', 'SA_REP', 7000, 0.25, 146, 80);

INSERT INTO empleados VALUES 
    (162, 'Clara', 'Vishney', 'CVISHNEY', '011.44.1346.129268', '1997-11-11', 'SA_REP', 10500, 0.25, 147, 80);

INSERT INTO empleados VALUES 
    (163, 'Danielle', 'Greene', 'DGREENE', '011.44.1346.229268', '1999-03-19', 'SA_REP', 9500, 0.15, 147, 80);

INSERT INTO empleados VALUES 
    (164, 'Mattea', 'Marvins', 'MMARVINS', '011.44.1346.329268', '2000-01-24', 'SA_REP', 7200, 0.10, 147, 80);

INSERT INTO empleados VALUES 
    (165, 'David', 'Lee', 'DLEE', '011.44.1346.529268', '2000-02-23', 'SA_REP', 6800, 0.1, 147, 80);

INSERT INTO empleados VALUES 
    (166, 'Sundar', 'Ande', 'SANDE', '011.44.1346.629268', '2000-03-24', 'SA_REP', 6400, 0.10, 147, 80);

INSERT INTO empleados VALUES 
    (167, 'Amit', 'Banda', 'ABANDA', '011.44.1346.729268', '2000-04-21', 'SA_REP', 6200, 0.10, 147, 80);

INSERT INTO empleados VALUES 
    (168, 'Lisa', 'Ozer', 'LOZER', '011.44.1343.929268', '1997-03-11', 'SA_REP', 11500, 0.25, 148, 80);

INSERT INTO empleados VALUES 
    (169, 'Harrison', 'Bloom', 'HBLOOM', '011.44.1343.829268', '1998-03-23', 'SA_REP', 10000, 0.20, 148, 80);

INSERT INTO empleados VALUES 
    (170, 'Tayler', 'Fox', 'TFOX', '011.44.1343.729268', '1998-01-24', 'SA_REP', 9600, 0.20, 148, 80);

INSERT INTO empleados VALUES 
    (171, 'William', 'Smith', 'WSMITH', '011.44.1343.629268', '1999-02-23', 'SA_REP', 7400, 0.15, 148, 80);

INSERT INTO empleados VALUES 
    (172, 'Elizabeth', 'Bates', 'EBATES', '011.44.1343.529268', '1999-03-24', 'SA_REP', 7300, 0.15, 148, 80);

INSERT INTO empleados VALUES 
    (173, 'Sundita', 'Kumar', 'SKUMAR', '011.44.1343.329268', '2000-04-21', 'SA_REP', 6100, 0.10, 148, 80);

INSERT INTO empleados VALUES 
    (174, 'Ellen', 'Abel', 'EABEL', '011.44.1644.429267', '1996-05-11', 'SA_REP', 11000, 0.30, 149, 80);

INSERT INTO empleados VALUES 
    (175, 'Alyssa', 'Hutton', 'AHUTTON', '011.44.1644.429266', '1997-03-19', 'SA_REP', 8800, 0.25, 149, 80);

INSERT INTO empleados VALUES 
    (176, 'Jonathon', 'Taylor', 'JTAYLOR', '011.44.1644.429265', '1998-03-24', 'SA_REP', 8600, 0.20, 149, 80);

INSERT INTO empleados VALUES 
    (177, 'Jack', 'Livingston', 'JLIVINGS', '011.44.1644.429264', '1998-04-23', 'SA_REP', 8400, 0.20, 149, 80);

INSERT INTO empleados VALUES 
    (178, 'Kimberely', 'Grant', 'KGRANT', '011.44.1644.429263', '1999-05-24', 'SA_REP', 7000, 0.15, 149, NULL);

INSERT INTO empleados VALUES 
    (179, 'Charles', 'Johnson', 'CJOHNSON', '011.44.1644.429262', '2000-01-04', 'SA_REP', 6200, 0.10, 149, 80);

INSERT INTO empleados VALUES 
    (180, 'Winston', 'Taylor', 'WTAYLOR', '650.507.9876', '1998-01-24', 'SH_CLERK', 3200, NULL, 120, 50);

INSERT INTO empleados VALUES 
    (181, 'Jean', 'Fleaur', 'JFLEAUR', '650.507.9877', '1998-02-23', 'SH_CLERK', 3100, NULL, 120, 50);

INSERT INTO empleados VALUES 
    (182, 'Martha', 'Sullivan', 'MSULLIVA', '650.507.9878', '1999-06-21', 'SH_CLERK', 2500, NULL, 120, 50);

INSERT INTO empleados VALUES 
    (183, 'Girard', 'Geoni', 'GGEONI', '650.507.9879', '2000-02-03', 'SH_CLERK', 2800, NULL, 120, 50);

INSERT INTO empleados VALUES 
    (184, 'Nandita', 'Sarchand', 'NSARCHAN', '650.509.1876', '1996-01-27', 'SH_CLERK', 4200, NULL, 121, 50);

INSERT INTO empleados VALUES 
    (185, 'Alexis', 'Bull', 'ABULL', '650.509.2876', '1997-02-20', 'SH_CLERK', 4100, NULL, 121, 50);

INSERT INTO empleados VALUES 
    (186, 'Julia', 'Dellinger', 'JDELLING', '650.509.3876', '1998-06-24', 'SH_CLERK', 3400, NULL, 121, 50);

INSERT INTO empleados VALUES 
    (187, 'Anthony', 'Cabrio', 'ACABRIO', '650.509.4876', '1999-02-07', 'SH_CLERK', 3000, NULL, 121, 50);

INSERT INTO empleados VALUES 
    (188, 'Kelly', 'Chung', 'KCHUNG', '650.505.1876', '1997-06-14', 'SH_CLERK', 3800, NULL, 122, 50);

INSERT INTO empleados VALUES 
    (189, 'Jennifer', 'Dilly', 'JDILLY', '650.505.2876', '1997-08-13', 'SH_CLERK', 3600, NULL, 122, 50);

INSERT INTO empleados VALUES 
    (190, 'Timothy', 'Gates', 'TGATES', '650.505.3876', '1998-07-11', 'SH_CLERK', 2900, NULL, 122, 50);

INSERT INTO empleados VALUES 
    (191, 'Randall', 'Perkins', 'RPERKINS', '650.505.4876', '1999-12-19', 'SH_CLERK', 2500, NULL, 122, 50);

INSERT INTO empleados VALUES 
    (192, 'Sarah', 'Bell', 'SBELL', '650.501.1876', '1996-02-04', 'SH_CLERK', 4000, NULL, 123, 50);

INSERT INTO empleados VALUES 
    (193, 'Britney', 'Everett', 'BEVERETT', '650.501.2876', '1997-03-03', 'SH_CLERK', 3900, NULL, 123, 50);

INSERT INTO empleados VALUES 
    (194, 'Samuel', 'McCain', 'SMCCAIN', '650.501.3876', '1998-07-01', 'SH_CLERK', 3200, NULL, 123, 50);

INSERT INTO empleados VALUES 
    (195, 'Vance', 'Jones', 'VJONES', '650.501.4876', '1999-03-17', 'SH_CLERK', 2800, NULL, 123, 50);

INSERT INTO empleados VALUES 
    (196, 'Alana', 'Walsh', 'AWALSH', '650.507.9811', '1998-04-24', 'SH_CLERK', 3100, NULL, 124, 50);

INSERT INTO empleados VALUES 
    (197, 'Kevin', 'Feeney', 'KFEENEY', '650.507.9822', '1998-05-23', 'SH_CLERK', 3000, NULL, 124, 50);

INSERT INTO empleados VALUES 
    (198, 'Donald', 'OConnell', 'DOCONNEL', '650.507.9833', '1999-06-21', 'SH_CLERK', 2600, NULL, 124, 50);

INSERT INTO empleados VALUES 
    (199, 'Douglas', 'Grant', 'DGRANT', '650.507.9844', '2000-01-13', 'SH_CLERK', 2600, NULL, 124, 50);

INSERT INTO empleados VALUES 
    (200, 'Jennifer', 'Whalen', 'JWHALEN', '515.123.4444', '1987-09-17', 'AD_ASST', 4400, NULL, 101, 10);

INSERT INTO empleados VALUES 
    (201, 'Michael', 'Hartstein', 'MHARTSTE', '515.123.5555', '1996-02-17', 'MK_MAN', 13000, NULL, 100, 20);

INSERT INTO empleados VALUES 
    (202, 'Pat', 'Fay', 'PFAY', '603.123.6666', '1997-08-17', 'MK_REP', 6000, NULL, 201, 20);

INSERT INTO empleados VALUES 
    (203, 'Susan', 'Mavris', 'SMAVRIS', '515.123.7777', '1994-06-07', 'HR_REP', 6500, NULL, 101, 40);

INSERT INTO empleados VALUES 
    (204, 'Hermann', 'Baer', 'HBAER', '515.123.8888', '1994-06-07', 'PR_REP', 10000, NULL, 101, 70);

INSERT INTO empleados VALUES 
    (205, 'Shelley', 'Higgins', 'SHIGGINS', '515.123.8080', '1994-06-07', 'AC_MGR', 12000, NULL, 101, 110);

INSERT INTO empleados VALUES 
    (206, 'William', 'Gietz', 'WGIETZ', '515.123.8181', '1994-06-07', 'AC_ACCOUNT', 8300, NULL, 205, 110);
    
UPDATE departamentos SET id_gerente = 200 WHERE id_departamento = 10;

UPDATE departamentos SET id_gerente = 201 WHERE id_departamento = 20;

UPDATE departamentos SET id_gerente = 114 WHERE id_departamento = 30;

UPDATE departamentos SET id_gerente = 203 WHERE id_departamento = 40;

UPDATE departamentos SET id_gerente = 121 WHERE id_departamento = 50;

UPDATE departamentos SET id_gerente = 103 WHERE id_departamento = 60;

UPDATE departamentos SET id_gerente = 204 WHERE id_departamento = 70;

UPDATE departamentos SET id_gerente = 145 WHERE id_departamento = 80;

UPDATE departamentos SET id_gerente = 100 WHERE id_departamento = 90;

UPDATE departamentos SET id_gerente = 108 WHERE id_departamento = 100;

UPDATE departamentos SET id_gerente = 205 WHERE id_departamento = 110;
		
INSERT INTO historial_puestos VALUES (102, '1993-01-13', '1998-07-24', 'IT_PROG', 60);

INSERT INTO historial_puestos VALUES (101, '1989-09-21', '1993-10-27', 'AC_ACCOUNT', 110);

INSERT INTO historial_puestos VALUES (101, '1993-10-28', '1997-03-15', 'AC_MGR', 110);

INSERT INTO historial_puestos VALUES (201, '1996-02-17', '1999-12-19', 'MK_REP', 20);

INSERT INTO historial_puestos VALUES (114, '1998-03-24', '1999-12-31', 'ST_CLERK', 50);

INSERT INTO historial_puestos VALUES (122, '1999-01-01', '1999-12-31', 'ST_CLERK', 50);

INSERT INTO historial_puestos VALUES (200, '1987-09-17', '1993-06-17', 'AD_ASST', 90);

INSERT INTO historial_puestos VALUES (176, '1998-03-24', '1998-12-31', 'SA_REP', 80);

INSERT INTO historial_puestos VALUES (176, '1999-01-01', '1999-12-31', 'SA_MAN', 80);

INSERT INTO historial_puestos VALUES (200, '1994-07-01', '1998-12-31', 'AC_ACCOUNT', 90);

COMMIT;
/*
SELECCION DE DATOS DE EMPLEADO DEL ESQUEMA CURSODB
*/
SELECT * FROM EMPLEADO;


/*
CREAR TABLA DE EMPLEADO DEL ESQUEMA CURSODB
*/
CREATE TABLE EMPLEADO
(
IDEMPLEADO NUMBER NOT NULL,
PATERNO VARCHAR2(50) NOT NULL,
MATERNO VARCHAR2(50) NOT NULL,
NOMBRE VARCHAR2(50) NOT NULL,
GENERO VARCHAR2(1) NOT NULL,
RFC VARCHAR2(13) NOT NULL,
CURP VARCHAR2(18) NOT NULL,
NUMIMSS VARCHAR2(11) NOT NULL,
FECHAALTA DATE NOT NULL,
CONSTRAINT EMPLEADO_PK PRIMARY KEY(IDEMPLEADO)
);


/*
BORRAR REGISTROS DE EMPLEADO DEL ESQUEMA CURSODB
*/
DELETE FROM EMPLEADO WHERE IDEMPLEADO=855;


/*
BORRAR CONTENIDO DE EMPLEADO DEL ESQUEMA CURSODB
*/
TRUNCATE TABLE EMPLEADO;



/*
BORRAR ESTRUCTURA Y CONTENIDO DE EMPLEADO DEL ESQUEMA CURSODB
*/
DROP TABLE EMPLEADO;
/*
AGREGAR UNA COLUMNA A LA TABLA
*/
ALTER TABLE EMPLEADO ADD FECHANACIMIENTO DEFAULT '01/01/1900' NOT NULL;

ALTER TABLE EMPLEADO ADD SUELDO NUMBER DEFAULT 100 NOT NULL;


SELECT * FROM EMPLEADO;

SELECT IDEMPLEADO, RFC,
SUBSTR(RFC,1,4) RFC_P1, 
SUBSTR(RFC,5,2) RFC_ANIO,
SUBSTR(RFC,7,2) RFC_MES,
SUBSTR(RFC,9,2) RFC_DIAS
FROM EMPLEADO WHERE IDEMPLEADO = 855;

SELECT SUBSTR(RFC,5,1) || '0s' DECADA, COUNT(DISTINCT IDEMPLEADO) CANT
FROM EMPLEADO
GROUP BY SUBSTR(RFC,5,1)
ORDER BY SUBSTR(RFC,5,1);

SELECT IDEMPLEADO, RFC, SUBSTR(RFC,9,2) || '/' || SUBSTR(RFC,7,2) || '/19' || SUBSTR(RFC,5,2) FECHANACIMIENTO
FROM EMPLEADO /*WHERE IDEMPLEADO = 855*/;

/*
ACTUALIZAR DATOS DE UNA TABLA
*/
UPDATE EMPLEADO SET FECHANACIMIENTO = TO_DATE('01/01/1900', 'DD/MM/YYYY') WHERE IDEMPLEADO = 855;
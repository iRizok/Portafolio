select COUNT(IDEMPLEADO) CANT from empleado WHERE genero = 'H';

select COUNT(IDEMPLEADO) CANT from empleado WHERE genero = 'M';

select GENERO
,CASE WHEN genero = 'H' THEN 1 ELSE 0 END T_HOMBRE
,CASE WHEN genero = 'M' THEN 1 ELSE 0 END T_MUJER
from empleado
;

select GENERO
,COUNT(CASE WHEN genero = 'H' THEN 1 END) T_HOMBRE
,COUNT(CASE WHEN genero = 'M' THEN 1 END) T_MUJER
from EMPLEADO
;

/*select fechaalta from empleado where fechaalta < 01/05/1979 and fechaalta > 25/10/1984;*/
select * from empleado where fechaalta BETWEEN TO_DATE('01/05/1979', 'DD/MM/YYYY') AND TO_DATE('25/10/1984', 'DD/MM/YYYY');

select * from empleado where substr(RFC,5,2) BETWEEN '60' AND '90';

select * from empleado ORDER BY paterno,materno;

select * from empleado ORDER BY fechaalta desc;

select * from empleado where fechaalta BETWEEN TO_DATE('01/01/1990', 'DD/MM/YYYY') AND TO_DATE('31/12/1999', 'DD/MM/YYYY');
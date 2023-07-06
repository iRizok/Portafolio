SELECT * FROM MARCA;
/* borrar tabla marca */
TRUNCATE TABLE MARCA;
select * from ARTICULO;

select * from articulo where precio>=COSTO;

select * from articulo where costo>=precio;

update articulo set COSTO=precio, precio=costo where costo>=precio;
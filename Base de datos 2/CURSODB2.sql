CREATE TYPE PERSONAJE AS OBJECT
(
  IDPERSONAJE INT, 
  IDCLASE INT, 
  IDARMA INT, 
  IDHABILIDAD INT, 
  IDETNIA INT,
  NOMBRE VARCHAR(10)
)
  
CREATE TYPE ARMA AS OBJECT
(
    IDARMA INT,
    NOMBRE VARCHAR(20),
    TIPOARMA VARCHAR(20),
    RANGO VARCHAR(2),
    DESCRIPCION VARCHAR(200)
)

CREATE TYPE ETNIA AS OBJECT
(
    IDETNIA INT,
    NOMBRE VARCHAR(20)
)

CREATE TYPE HABILIDAD AS OBJECT
(
    IDHABILIDAD INT,
    IDCLASE INT,
    NOMBRE VARCHAR(20),
    DESCRIPCION VARCHAR(200)
)

CREATE TYPE CLASE AS OBJECT
(
    IDCLASE INT,
    NOMBRE VARCHAR(10)
)

CREATE TABLE Clases OF CLASE(IDCLASE PRIMARY KEY);
    INSERT INTO Clases VALUES(CLASE (1, 'Hechicero'));
    INSERT INTO Clases VALUES(CLASE (2, 'Guerrero')); 
    INSERT INTO Clases VALUES(CLASE (3, 'Arquero')); 
    INSERT INTO Clases VALUES(CLASE (4, 'Asesino'));
    INSERT INTO Clases VALUES(CLASE (5, 'Cabellero'));

CREATE TABLE Etnias OF ETNIA(IDETNIA PRIMARY KEY);
    INSERT INTO Etnias VALUES(ETNIA (1, 'Humano'));
    INSERT INTO Etnias VALUES(ETNIA (2, 'Elfo'));
    INSERT INTO Etnias VALUES(ETNIA (3, 'Orco'));
    INSERT INTO Etnias VALUES(ETNIA (4, 'Enano'));
    INSERT INTO Etnias VALUES(ETNIA (5, 'Semielfo'));
    INSERT INTO Etnias VALUES(ETNIA (6, 'Gnomo'));
    INSERT INTO Etnias VALUES(ETNIA (7, 'Semiorco'));
    INSERT INTO Etnias VALUES(ETNIA (8, 'Minotauro'));
    INSERT INTO Etnias VALUES(ETNIA (9, 'Centauro'));
    INSERT INTO Etnias VALUES(ETNIA (10, 'Triton'));

CREATE TABLE Armas OF ARMA(IDARMA PRIMARY KEY);
    INSERT INTO Armas VALUES(ARMA (1, 'Espada', 'Media', 'C', 'Arma cuerpo a cuerpo comun de medio alcance'));
    INSERT INTO Armas VALUES(ARMA (2, 'Martillo', 'Corta', 'D', 'Arma cuerpo a cuerpo comun de corto alcance'));
    INSERT INTO Armas VALUES(ARMA (3, 'Lanza', 'Larga', 'A', 'Arma cuerpo a cuerpo rara de largo alcance'));
    INSERT INTO Armas VALUES(ARMA (4, 'Arco', 'De alcance', 'S', 'Arma de largo alcance comun'));
    INSERT INTO Armas VALUES(ARMA (5, 'Ballesta', 'De alcance', 'S+', 'Arma de largo alcance inusual'));
    INSERT INTO Armas VALUES(ARMA (6, 'Baculo', 'De alcance', 'S', 'Arma magica que permite a su portador realizar hechizos'));
    INSERT INTO Armas VALUES(ARMA (7, 'Hacha corta', 'Corta', 'B', 'Arma cuerpo a cuerpo rara de corto alcance'));
    INSERT INTO Armas VALUES(ARMA (8, 'Escudo', 'De proteccion', 'A', 'Arma cuya funcion principal es proteger a su portador'));
    INSERT INTO Armas VALUES(ARMA (9, 'Daga', 'Corta', 'C', 'Arma cuerpo a cuerpo comun de corto alcance'));
    INSERT INTO Armas VALUES(ARMA (10, 'Hacha larga', 'Larga', 'A', 'Arma cuerpo a cuerpo inusual de largo alcance'));

CREATE TABLE Habilidades OF HABILIDAD(IDHABILIDAD PRIMARY KEY, CONSTRAINT CLASE_fk FOREIGN KEY (IDCLASE) REFERENCES CLASES(IDCLASE));
    INSERT INTO Habilidades VALUES(HABILIDAD (1, 2, 'Grito de guerra', 'Aumenta sus defensas y las de su equipo'));
    INSERT INTO Habilidades VALUES(HABILIDAD (2, 1, 'Teletransportacion', 'Se teletransporta a algun lugar aleatorio del mapa'));
    INSERT INTO Habilidades VALUES(HABILIDAD (3, 1, 'Lluvia de meteoros', 'Provoca una rafaga de roca ardiente'));
    INSERT INTO Habilidades VALUES(HABILIDAD (4, 4, 'Azote de tigre', 'Aniade danio adicional con cada golpe'));
    INSERT INTO Habilidades VALUES(HABILIDAD (5, 3, 'Lluvia de flechas', 'Provoca una rafaga de flechas'));
    INSERT INTO Habilidades VALUES(HABILIDAD (6, 5, 'Vigor', 'Aumenta sus resistencias y defensas'));
    INSERT INTO Habilidades VALUES(HABILIDAD (7, 4, 'Punialada', 'Apuniala al enemigo mas cercano por la espalda'));
    INSERT INTO Habilidades VALUES(HABILIDAD (8, 2, 'Dominio', 'Aumenta el danio provocado a enemigos en una zona del mapa'));
    INSERT INTO Habilidades VALUES(HABILIDAD (9, 5, 'Plegaria', 'Regenera lentamente su vida'));
    INSERT INTO Habilidades VALUES(HABILIDAD (10, 3, 'Flecha bomba', 'Lanza una flecha que explota al instante'));

CREATE TABLE Personajes OF PERSONAJE
(
    IDPERSONAJE PRIMARY KEY,
    CONSTRAINT CLASEPER_fk FOREIGN KEY (IDCLASE) REFERENCES CLASES(IDCLASE),
    CONSTRAINT ARMA_fk FOREIGN KEY (IDARMA) REFERENCES ARMAS(IDARMA),
    CONSTRAINT HABILIDAD_fk FOREIGN KEY (IDHABILIDAD) REFERENCES HABILIDADES(IDHABILIDAD),
    CONSTRAINT ETNIA_fk FOREIGN KEY (IDETNIA) REFERENCES ETNIAS(IDETNIA)
);    
    INSERT INTO Personajes VALUES(PERSONAJE (1, 2, 10, 8, 3, 'Igrim'));
    INSERT INTO Personajes VALUES(PERSONAJE (2, 4, 9, 7, 5, 'Alvalor'));
    INSERT INTO Personajes VALUES(PERSONAJE (3, 5, 1, 6, 1, 'Virdim'));
    INSERT INTO Personajes VALUES(PERSONAJE (4, 3, 5, 5, 2, 'Elden'));
    INSERT INTO Personajes VALUES(PERSONAJE (5, 1, 6, 2, 4, 'Malvon'));

SELECT * FROM PERSONAJES WHERE NOMBRE = 'Igrim';

DROP TYPE ARMA;
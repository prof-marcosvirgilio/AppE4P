CREATE TABLE IF NOT EXISTS cor (
  idcor INT UNSIGNED NOT NULL,
  decor VARCHAR(150) NOT NULL,
  PRIMARY KEY (idcor),
  UNIQUE INDEX idcor_UNIQUE (idcor),
  UNIQUE INDEX decor_UNIQUE (decor));


CREATE TABLE IF NOT EXISTS porte (
  idporte INT UNSIGNED NOT NULL,
  deporte VARCHAR(150) NOT NULL,
  PRIMARY KEY (idporte),
  UNIQUE INDEX idporte_UNIQUE (idporte) ,
  UNIQUE INDEX deporte_UNIQUE (deporte));


CREATE TABLE IF NOT EXISTS animal (
  idanimal INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nmanimal VARCHAR(200) NULL,
  nmtutor VARCHAR(200) NULL,
  idcor INT UNSIGNED NOT NULL,
  idporte INT UNSIGNED NOT NULL,
  PRIMARY KEY (idanimal),
  UNIQUE INDEX idanimal_UNIQUE (idanimal),
  UNIQUE INDEX nmanimal_UNIQUE (nmanimal),
  INDEX fk_animal_cor_idx (idcor),
  INDEX fk_animal_porte1_idx (idporte));


  INSERT INTO cor (idcor,decor)
  VALUES(0, 'Caramelo');

  INSERT INTO cor (idcor,decor)
  VALUES(1, 'Preto');

  INSERT INTO cor (idcor,decor)
  VALUES(2, 'Branco');

  INSERT INTO cor (idcor,decor)
  VALUES(3, 'Marrom');



  INSERT INTO porte(idporte,deporte)
  VALUES(0,'PP');

  INSERT INTO porte(idporte,deporte)
  VALUES(1,'P');

  INSERT INTO porte(idporte,deporte)
  VALUES(2,'M');

  INSERT INTO porte(idporte,deporte)
  VALUES(3,'G');

  INSERT INTO porte(idporte,deporte)
  VALUES(4,'GG');



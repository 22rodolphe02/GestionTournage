CREATE database tournage;

\c tournage;

CREATE  TABLE actions (
	id                   serial  NOT NULL  ,
	idScene              integer    ,
	idActeur             integer    ,
	duree                time    ,
	temps                time    ,
	dialogue             text    ,
	CONSTRAINT pk_actions PRIMARY KEY ( id ),
	CONSTRAINT unq_actions_idscene UNIQUE ( idScene ) ,
	CONSTRAINT unq_actions_idacteur UNIQUE ( idActeur )
 );

CREATE  TABLE scene (
	id                   serial  NOT NULL  ,
	idPlateau            integer    ,
	CONSTRAINT pk_scen PRIMARY KEY ( id ),
	CONSTRAINT unq_scene_idplateau UNIQUE ( idPlateau ) ,
	CONSTRAINT fk_scene_actions FOREIGN KEY ( id ) REFERENCES actions( idScene )
 );

CREATE  TABLE acteur (
	id                   serial  NOT NULL  ,
	nom                  varchar(30)    ,
	age                  integer    ,
	surnom               varchar(50)    ,
	prenom               varchar(30)    ,
	CONSTRAINT pk_acteur PRIMARY KEY ( id ),
	CONSTRAINT fk_acteur_actions FOREIGN KEY ( id ) REFERENCES actions( idActeur )
 );

CREATE  TABLE plateau (
	id                   serial  NOT NULL  ,
	nom                  varchar(30)    ,
	lieu                 varchar(50)    ,
	CONSTRAINT pk_plateau PRIMARY KEY ( id ),
	CONSTRAINT fk_plateau_scene FOREIGN KEY ( id ) REFERENCES scene( idPlateau )
 );

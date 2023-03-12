CREATE database tournage;

\c tournage;

CREATE  TABLE actions (
	id                   serial  NOT NULL  ,
	idscene              integer    ,
	idacteur             integer    ,
	duree                time    ,
	temps                time    ,
	dialogue             text    ,
	CONSTRAINT pk_actions PRIMARY KEY ( id ),
	CONSTRAINT unq_actions_idscene UNIQUE ( idscene ) ,
	CONSTRAINT unq_actions_idacteur UNIQUE ( idacteur ) 
 );

CREATE  TABLE scene (
	id                   serial  NOT NULL  ,
	idplateau            integer    ,
	CONSTRAINT pk_scen PRIMARY KEY ( id ),
	CONSTRAINT unq_scene_idplateau UNIQUE ( idplateau ) ,
	CONSTRAINT fk_scene_actions FOREIGN KEY ( id ) REFERENCES actions( idscene )
 );

CREATE  TABLE acteur (
	id                   serial  NOT NULL  ,
	nom                  varchar(30)    ,
	age                  integer    ,
	surnom               varchar(50)    ,
	prenom               varchar(30)    ,
	CONSTRAINT pk_acteur PRIMARY KEY ( id ),
	CONSTRAINT fk_acteur_actions FOREIGN KEY ( id ) REFERENCES actions( idacteur )
 );

CREATE  TABLE plateau (
	id                   serial  NOT NULL  ,
	nom                  varchar(30)    ,
	lieu                 varchar(50)    ,
	CONSTRAINT pk_plateau PRIMARY KEY ( id ),
	CONSTRAINT fk_plateau_scene FOREIGN KEY ( id ) REFERENCES scene( idplateau )
 );

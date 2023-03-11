CREATE SCHEMA IF NOT EXISTS tournage;

CREATE  TABLE tournage.actions ( 
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

CREATE  TABLE tournage.scene ( 
	id                   serial  NOT NULL  ,
	idplateau            integer    ,
	CONSTRAINT pk_scen PRIMARY KEY ( id ),
	CONSTRAINT unq_scene_idplateau UNIQUE ( idplateau ) ,
	CONSTRAINT fk_scene_actions FOREIGN KEY ( id ) REFERENCES tournage.actions( idscene )   
 );

CREATE  TABLE tournage.acteur ( 
	id                   serial  NOT NULL  ,
	nom                  varchar(30)    ,
	age                  integer    ,
	surnom               varchar(50)    ,
	prenom               varchar(30)    ,
	CONSTRAINT pk_acteur PRIMARY KEY ( id ),
	CONSTRAINT fk_acteur_actions FOREIGN KEY ( id ) REFERENCES tournage.actions( idacteur )   
 );

CREATE  TABLE tournage.plateau ( 
	id                   serial  NOT NULL  ,
	nom                  varchar(30)    ,
	lieu                 varchar(50)    ,
	CONSTRAINT pk_plateau PRIMARY KEY ( id ),
	CONSTRAINT fk_plateau_scene FOREIGN KEY ( id ) REFERENCES tournage.scene( idplateau )   
 );

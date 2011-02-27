-- Creation de la base de données
-- Nous avons choisi de créer une base de données OO afin d'utiliser
-- cojointement les propriétés objet de la base et du langage java.

-- ECUE
create type TECUE as object (
	codeMatiere number,
	libelleECUE varchar2(20),
	nbheures number
);
/

create table ECUE of TECUE (
	constraint pkECUE primary key(codeECUE))
);
/

create type TECUEnt as table of TECUE;
/

-- UE
create type TUE as object (
	codeUE number,
	nbECTS number,
	libelleUE varchar2(),
	optionnel boolean,
	listeECUE TECUEnt
);
/

create table UE of TUE (
	constraint pkEtudiant primary key(codeUE)
) nested table listeECUE store as listeECUE_tab;

create type TUEnt as table of TUE;

-- Semestre

create type TSemestre as object (
	codesemestre number,
	libellesemestre varchar2(10),
	nbUEFacultatives number,
	listeUE TUEnt
);
/

create table Semestre of TSemestre (
	constraint pkSemestre primary key(codesemestre)
) nested table listeUE store as listeUE_tab;
/

create type TListeSemestre as varray(2) of TSemestre;
/

-- Etape

create type TEtape as object (
	versionEtape varchar2(10),
	listeSemestre TListeSemestre
);
/


create table Etape of TEtape (
	constraint pkEtape primary key(versionEtape)
);
/


create type TListeEtape as varray(3) of TEtape;
/

-- Departement

create type TDepartement as object (
	versionDiplome varchar2(10),
	nomDepartement varchar2(10),
	mnemo varchar2(10),
	listeEtape TListeEtape;
	
);
/

create table Departement of TDepartement(
	constraint pkDepartement primary key(mnemo)
);
/

create type TPersonne as object(
	id_personne number,
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(20)	
) NOT FINAL;
/

/*
create table Personne of TPersonne (
	constraint pkPersonne primary key(id_personne) 
);
/
*/

create type TEtudiant as object under TPersonne (
	pointjuryannee number,
	numINE varchar2(),
	numEtudiant number,
	scoreTOEIC number
);
/

create table Etudiant of TEtudiant (
	constraint pkEtudiant primary key(numINE)
)

create type TEnseignant as object under TPersonne (
	id_enseignant number
);
/

create table Enseignant of TEnseignant (
	constraint pkEnseignant primary key(id_enseignant)
);
/

-- Statuts

create type TStatut as object (
	libelle varchar2(20)
);
/

create table Statut of TStatut (
	constraint pkStatut primary key(libelle);
)

create type TStatutEtud(
	libelle varchar2(20)
);
/

create table StatusEtud of TStatutEtud (
	constraint pkStatusEtud primary key(libelle)
);
/

-- Notes
create type TNote (
	idnote number,
	noteSession1 number,
	noteSession2 number
);
/

create table Note of TNote (
	constraint pkNote primary key(idnote)
);
/

create type TPointJury (
	idPointJury number,
	nbPoints number
);
/

create table PointJury of TPointJury (
	constraint pkPointJury primary key(idPointJury)
);
/



 

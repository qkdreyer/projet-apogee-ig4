-- Creation de la base de données relationelles

-- Creation de la base de données
-- Nous avons choisi de créer une base de données OO afin d'utiliser
-- cojointement les propriétés objet de la base et du langage java.

select * from cat where table_name not like 'BIN%';
/

select type_name from user_types;

-- ECUE
create table ECUE (
	codeMatiere number,
	libelleECUE varchar2(20),
	nbheures number,
	constraint pkECUE primary key(codeMatiere)
);
/

-- UE
create table UE (
	codeUE number,
	nbECTS number,
	libelleUE varchar2(50),
	optionnel char(1),
	constraint pkUE primary key(codeUE) 
);
/

-- Semestre

create table Semestre (
	codesemestre number,
	libellesemestre varchar2(10),
	nbUEFacultatives number,
	constraint pkSemestre primary key(codesemestre)
);
/

-- Etape

create table Etape (
	versionEtape varchar2(10),
	listeSemestre TListeSemestre,
	constraint pkEtape primary key(versionEtape)
);
/

-- Departement

create table Departement (
	versionDiplome varchar2(10),
	nomDepartement varchar2(10),
	mnemo varchar2(10),
	constraint pkDepartement primary key(mnemo)	
);
/

create table Personne (
	id_personne number,
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(20),
	constraint pkPersonne primary key(id_personne)
);
/

create table Utilisateur (
	id_utilisateur number,
	mdp varchar2(10),
	login varchar2(20),
	constraint pkUtilisateur primary key(id_utilisateur)
);
/

create table Etudiant (
	id_etudiant number,
	pointjuryannee number,
	numINE varchar2(15),
	numEtudiant number,
	scoreTOEIC number,
	constraint pkEtudiant primary key(id_etudiant)
);
/

create table Enseignant (
	id_enseignant number,
	constraint pkEnseignant primary key(id_enseignant)
);
/

create type TSecretaire (
	
);
/


-- Statuts

create table Statut (
	id_statut number,
	libelle varchar2(20),
	constraint pkStatut primary key(id_statut)
);
/


-- Notes
create table Note (
	idnote number,
	noteSession1 number,
	noteSession2 number,
	constraint pkNote primary key(idnote)
);
/


create table PointJury (
	idPointJury number,
	nbPoints number,
	constraint pkPointJury primary key(idPointJury)
);
/

create Redoublant (
	id_redoublant number,
	moyenne number,
	constraint pkRedoublant primary key(id_redoublant)
);
/

create table Provenance (
	id_provenance number,
	libelleProvenance varchar2(20),
	constraint pkProvenance primary key(id_number)
);
/

create table etranger (
	id_etranger number,
	moyenne number,
	constraint pkEtranger primary key(id_etranger)
);
/

create table nationalite (
	id_nationalite number,
	libelleNationalite varchar2(20),
	constraint pkNationalite primary key(id_nationalite)
);
/

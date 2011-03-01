-- Creation de la base de données relationelles (20 tables)

-- Creation de la base de données
-- Nous avons choisi de créer une base de données OO afin d'utiliser
-- cojointement les propriétés objet de la base et du langage java.

--select * from cat where table_name not like 'BIN%';
--select constraint_name, table_name from user_constraints where constraint_name not like 'BIN%';

--select type_name from user_types;

-- ECUE
create table ECUE (
	codeMatiere number,
	libelleECUE varchar2(50),
	nbheures number,
	idenseignant number,
	codeue number,
	constraint pkECUE primary key(codeMatiere)
);


-- UE
create table UE (
	codeUE number,
	nbECTS number,
	libelleUE varchar2(50),
	optionnel char(1),
	idenseignant number,
	codesemestre number,
	constraint pkUE primary key(codeUE)
);



-- Semestre

create table Semestre (
	codesemestre number,
	libellesemestre varchar2(10),
	nbUEFacultatives number,
	codeEtape number,
	constraint pkSemestre primary key(codesemestre)	
);


-- Etape

-- mettre les deux semestre en clé étrangeres ici ?
create table Etape (
	codeEtape number,
	versionEtape varchar2(10), -- le chiffre de l'année ?
	idenseignant number,
	mnemo varchar2(10),
	constraint pkEtape primary key(codeEtape)	
);


-- Departement

create table Departement (
	versionDiplome varchar2(10),
	nomDepartement varchar2(10),
	mnemo varchar2(10),
	idenseignant number,
	constraint pkDepartement primary key(mnemo)
);


create table Personne (
	idpersonne number,
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(20),
	constraint pkPersonne primary key(idpersonne)
);


create table Utilisateur (
	idutilisateur number,
	mdp varchar2(10),
	login varchar2(20),
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(20),
	constraint pkUtilisateur primary key(idutilisateur)
);


create table Etudiant (
	numEtudiant number,
	pointjuryannee number,
	numINE varchar2(15),
	scoreTOEIC number,
	idpersonne number,
	idprovenance number,
	idstatut number,
	idnationalite number,
	codesemestre number,
	codeEtape number,
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(20),
	constraint pkEtudiant primary key(numEtudiant)
);


create table VAE (
	codeue number,
	numEtudiant number	
);

create table choixUE (
	codeue number,
	numEtudiant number	
);


create table APDJ (
	codeue number,
	numEtudiant number	
);

	
-- Qu'est ce que l'enseignant a en plus de la secretaire ?
create table Enseignant (
	idenseignant number,
	mdp varchar2(10),
	login varchar2(20),
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(20),
	constraint pkEnseignant primary key(idenseignant)
);


create table Secretaire (
	idsecretaire number,
	mdp varchar2(10),
	login varchar2(20),
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(20),
	constraint pkSecretaire primary key(idsecretaire)
);

-- Statuts

create table Statut (
	idstatut number,
	libelle varchar2(20),
	constraint pkStatut primary key(idstatut)
);


-- Notes
create table Note (
	idnote number,
	noteSession1 number,
	noteSession2 number,
	numEtudiant number,
	codeMatiere number,
	constraint pkNote primary key(idnote)	
);


create table PointsJury (
	idPointsJury number,
	nbPoints number,
	numEtudiant number,
	codesemestre number,
	constraint pkPointJury primary key(idPointsJury)
);


create table Redoublant (
	idredoublant number,
	moyenne number,
	numEtudiant number,
	codesemestre number,
	constraint pkRedoublant primary key(idredoublant)
);

	
create table Provenance (
	idprovenance number,
	libelleProvenance varchar2(20),
	constraint pkProvenance primary key(idprovenance)
);


create table etranger (
	idetranger number,
	moyenne number,
	numEtudiant number,
	codesemestre number,
	constraint pkEtranger primary key(idetranger)
);


create table nationalite (
	idnationalite number,
	libelleNationalite varchar2(20),
	constraint pkNationalite primary key(idnationalite)
);


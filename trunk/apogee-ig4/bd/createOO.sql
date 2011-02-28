-- Creation de la base de données
-- Nous avons choisi de créer une base de données OO afin d'utiliser
-- cojointement les propriétés objet de la base et du langage java.

select * from cat where table_name not like 'BIN%';
/

select type_name from user_types;

-- ECUE
create type TECUE as object (
	codeMatiere number,
	libelleECUE varchar2(20),
	nbheures number,
	UEparent ref TUE
);
/

create table ECUE of TECUE (
	constraint pkECUE primary key(codeMatiere)
);
/

create type TECUEnt as table of TECUE;
/

create type TECUEref_nt as table of ref TECUE;
/


-- Inscrit dans la table de l'UE parente la reference de l'ECUE inserée
create or replace trigger
after insert on ECUE
for each row
declare

begin
	insert into table(select listeECUE from UE where UE.codeUE = (deref(:new.UEparent)).codeUE)
	values(make_ref(:new));
end;
/

-- UE
create or replace type TUE as object (
	codeUE number,
	nbECTS number,
	libelleUE varchar2(50),
	optionnel char(1),
	listeECUE TECUEref_nt
);
/

create table UE of TUE (
	constraint pkUE primary key(codeUE),
	check (optionnel in ('T', 'F'))
) nested table listeECUE store as listeECUE_tab;
/

insert into ECUE values(10, 'ADA', 15);
/

insert into UE values(
	42,
	7,
	'INFO',
	'T',
	TECUEref_nt((select ref(e)
				from ecue e
				where e.codeMatiere = 10 ))
);
/

select codeUE, nbECTS, libelleUE, optionnel, ( select column_value from table(listeECUE)) as l_ECUE 
		
select (select deref(column_value) from table(u.listeECUE))
from ue u; 									

create or replace type TUEnt as table of TUE;
/

-- Semestre

create or replace type TSemestre as object (
	codesemestre number,
	libellesemestre varchar2(10),
	nbUEFacultatives number,
	listeUE TUEnt
);
/


-- NOT WORKING
-- @fix : Il faut nester les clause "nested table ... store as ..."
-- de la meme maniere que sont nesté les nested table entre elles
create table Semestre of TSemestre (
	constraint pkSemestre primary key(codesemestre)
) nested table listeUE store as listeUE_tab
	(nested table listeECUE store as listeECUE_tab_tab);
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
	listeEtape TListeEtape	
);
/

create table Departement of TDepartement(
	constraint pkDepartement primary key(mnemo)
);
/

create or replace type TPersonne as object(
	id_personne number,
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(20)	
) NOT FINAL;
/

create type TUtilisateur as object (
	mdp varchar2(10),
	login varchar2(20)
) NOT FINAL;
/

/*
create table Personne of TPersonne (
	constraint pkPersonne primary key(id_personne) 
);
/
*/

create or replace type TEtudiant under TPersonne (
	pointjuryannee number,
	numINE varchar2(15),
	numEtudiant number,
	scoreTOEIC number
);
/

create table Etudiant of TEtudiant (
	constraint pkEtudiant primary key(numINE)
);
/

create type TEnseignant under TUtilisateur (
	id_enseignant number
);
/

create table Enseignant of TEnseignant (
	constraint pkEnseignant primary key(id_enseignant)
);
/


create type TSecretaire under TUtilisateur (
	
);
/


-- Statuts

create type TStatut as object (
	libelle varchar2(20)
);
/

create table Statut of TStatut (
	constraint pkStatut primary key(libelle)
);
/

create type TStatutEtud as object(
	libelle varchar2(20)
);
/

create table StatutEtud of TStatutEtud (
	constraint pkStatusEtud primary key(libelle)
);
/

-- Notes
create type TNote as object(
	idnote number,
	noteSession1 number,
	noteSession2 number
);
/

create table Note of TNote (
	constraint pkNote primary key(idnote)
);
/

create type TPointJury as object (
	idPointJury number,
	nbPoints number
);
/

create table PointJury of TPointJury (
	constraint pkPointJury primary key(idPointJury)
);
/

create type tredoublant as object (
	moyenne number
);
/

create type tprovenance as object (
	libelleProvenance varchar2(20)
);
/

create type tetranger as object (
	moyenne number
);
/

create type tnationalite as object (
	libelleNationalite varchar2(20)
);
/

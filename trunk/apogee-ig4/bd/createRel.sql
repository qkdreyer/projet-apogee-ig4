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
	id_enseignant number,
	constraint pkECUE primary key(codeMatiere),
	constraint fkenseignant_ecue foreign key(id_enseignant) references enseignant(id_enseignant)
);
/

-- UE
create table UE (
	codeUE number,
	nbECTS number,
	libelleUE varchar2(50),
	optionnel char(1),
	id_enseignant number,
	constraint pkUE primary key(codeUE),
	constraint fkenseignant_ue foreign key(id_enseignant) references enseignant(id_enseignant)
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
	id_enseignant number,
	constraint pkEtape primary key(versionEtape),
	constraint fkenseignant_etape foreign key(id_enseignant) references enseignant(id_enseignant)
);
/

-- Departement

create table Departement (
	versionDiplome varchar2(10),
	nomDepartement varchar2(10),
	mnemo varchar2(10),
	id_enseignant number,
	constraint pkDepartement primary key(mnemo),
	constraint fkenseignant_departement foreign key(id_enseignant) references enseignant(id_enseignant)
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
	pointjuryannee number,
	numINE varchar2(15),
	numEtudiant number,
	scoreTOEIC number,
	id_personne number,
	id_provenance number,
	id_statut number,
	id_nationalite number,
	constraint pkEtudiant primary key(numEtudiant),
	constraint fkpersonne_etud foreign key(id_personne) references personne(id_personne),
	constraint fkprovenance_etud foreign key(id_provenance) references provenance(id_provenance),
	constraint fkstatut_etud foreign key(id_statut) references statut(id_statut),
	constraint fknationalite_etud foreign key(id_nationalite) references nationalite(id_nationalite)
);
/

create table Enseignant (
	id_enseignant number,
	id_utilisateur number,
	constraint pkEnseignant primary key(id_enseignant),
	constraint fkutilisateur_ens foreign key(id_utilisateur) references utilisateur(id_utilisateur)
);
/

create type TSecretaire (
	id_secretaire number,
	id_utilisateur number,
	constraint pkSecretaire primary key(id_secretaire),
	constraint fkutilisateur_sec foreign key(id_utilisateur) references utilisateur(id_utilisateur)
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
	numEtudiant number,
	codeMatiere number,
	constraint pkNote primary key(idnote),
	constraint fketudiant_note foreign key(numEtudiant) references etudiant(numEtudiant),
	constraint fkecue_note foreign key(codeMatiere) references ecue(codeMatiere)
);
/


create table PointJury (
	idPointJury number,
	nbPoints number,
	numEtudiant number,
	codesemestre number,
	constraint pkPointJury primary key(idPointJury),
	constraint fketudiant_pj foreign key(numEtudiant) references etudiant(numEtudiant),
	constraint fksemectre_pj foreign key(codeSemestre) references semestre(codeSemestre)
);
/

create Redoublant (
	id_redoublant number,
	moyenne number,
	numEtudiant number,
	codesemestre number,
	constraint pkRedoublant primary key(id_redoublant),
	constraint fketudiant_pj foreign key(numEtudiant) references etudiant(numEtudiant),
	constraint fksemectre_pj foreign key(codeSemestre) references semestre(codeSemestre)
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
	numEtudiant number,
	codesemestre number,
	constraint pkEtranger primary key(id_etranger),
	constraint fketudiant_pj foreign key(numEtudiant) references etudiant(numEtudiant),
	constraint fksemectre_pj foreign key(codeSemestre) references semestre(codeSemestre)
);
/

create table nationalite (
	id_nationalite number,
	libelleNationalite varchar2(20),
	constraint pkNationalite primary key(id_nationalite)
);
/

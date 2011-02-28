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
	codeue number,
	constraint pkECUE primary key(codeMatiere),
	constraint fkenseignant_ecue foreign key(id_enseignant) references enseignant(id_enseignant),
	constraint fkue_ecue foreign key(codeue) references ue(codeue),
);
/

-- UE
create table UE (
	codeUE number,
	nbECTS number,
	libelleUE varchar2(50),
	optionnel char(1),
	id_enseignant number,
	codesemestre number,
	constraint pkUE primary key(codeUE),
	constraint fkenseignant_ue foreign key(id_enseignant) references enseignant(id_enseignant),
	constraint fksemestre_ue foreign key(codesemestre) references semestre(codesemestre)
);
/

-- Semestre

create table Semestre (
	codesemestre number,
	libellesemestre varchar2(10),
	nbUEFacultatives number,
	codeEtape number,
	constraint pkSemestre primary key(codesemestre),
	constraint fketape_ue foreign key(codeetape) references etape(codeetape)
);
/

-- Etape

-- mettre les deux semestre en clé étrangeres ici ?
create table Etape (
	codeEtape number
	versionEtape varchar2(10), -- le chiffre de l'année ?
	id_enseignant number,
	mnemo varchar2(10),
	constraint pkEtape primary key(codeEtape),
	constraint fkenseignant_etape foreign key(id_enseignant) references enseignant(id_enseignant),
	constraint fkdepartement_etape foreign key(mnemo) references departement(mnemo)
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
	codesemestre number,
	codeUE number,
	constraint pkEtudiant primary key(numEtudiant),
	constraint fkpersonne_etud foreign key(id_personne) references personne(id_personne),
	constraint fkprovenance_etud foreign key(id_provenance) references provenance(id_provenance),
	constraint fkstatut_etud foreign key(id_statut) references statut(id_statut),
	constraint fknationalite_etud foreign key(id_nationalite) references nationalite(id_nationalite),
	constraint fksemestre_etud foreign key(codesemestre) references semestre(codesemestre)	
);
/

create table VAE (
	codeue number,
	numEtudiant number,
	constraint fkue_vae foreign key(codeue) references ue(codeue),
	constraint fketud_vae foreign key(numetudiant) references etudiant(numEtudiant)
);
/

create table choixUE (
	codeue number,
	numEtudiant number,
	constraint fkue_choixUE foreign key(codeue) references ue(codeue),
	constraint fketud_choixUE foreign key(numetudiant) references etudiant(numEtudiant)
);
/

create table APDJ (
	codeue number,
	numEtudiant number,
	constraint fkue_apdj foreign key(codeue) references ue(codeue),
	constraint fketud_apdj foreign key(numetudiant) references etudiant(numEtudiant)
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
	constraint fketudiant_red foreign key(numEtudiant) references etudiant(numEtudiant),
	constraint fksemestre_red foreign key(codeSemestre) references semestre(codeSemestre)
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
	constraint fketudiant_etr foreign key(numEtudiant) references etudiant(numEtudiant),
	constraint fksemestre_etr foreign key(codeSemestre) references semestre(codeSemestre)
);
/

create table nationalite (
	id_nationalite number,
	libelleNationalite varchar2(20),
	constraint pkNationalite primary key(id_nationalite)
);
/

-- Creation de la base de données relationelles (20 tables)

-- Creation de la base de données
-- Nous avons choisi de créer une base de données OO afin d'utiliser
-- cojointement les propriétés objet de la base et du langage java.

--select * from cat where table_name not like 'BIN%';
--select constraint_name, table_name from user_constraints where constraint_name not like 'BIN%';

--select type_name from user_types;

-- ECUE
create table ECUE (
	codeMatiere varchar2(10),
	libelleECUE varchar2(50),
	nbheures number,
	idenseignant number,
	codeue varchar2(10),
	constraint pkECUE primary key(codeMatiere)
);


-- UE
create table UE (
	codeUE varchar2(10),
	nbECTS number,
	libelleUE varchar2(50),
	optionnel char(1),
	idenseignant number,
	codesemestre varchar2(10),
	constraint pkUE primary key(codeUE)
);



-- Semestre

create table Semestre (
	codesemestre varchar2(10),
	libellesemestre varchar2(10),
	nbUEFacultatives number,
	codeEtape varchar2(10),
	constraint pkSemestre primary key(codesemestre)	
);


-- Etape

-- mettre les deux semestre en clé étrangeres ici ?
create table Etape (
	codeEtape varchar2(10),
	versionEtape varchar2(10), -- le chiffre de l'annee
	idenseignant number,
	versionDiplome varchar2(10),
	constraint pkEtape primary key(codeEtape)	
);


-- Departement

create table Departement (
	versionDiplome varchar2(10),
	nomDepartement varchar2(100),
	mnemo varchar2(10),
	idenseignant number,
	constraint pkDepartement primary key(versionDiplome)
);


create table Personne (
	idpersonne number,
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(20),
	constraint pkPersonne primary key(idpersonne)
);


create table Etudiant (
	numEtudiant number,
	pointjuryannee number(4,2),
	numINE varchar2(15),
	scoreTOEIC number,
	idprovenance number,
	idstatut number,
	idnationalite number,
	codeEtape varchar2(10),
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(40),
	constraint pkEtudiant primary key(numEtudiant)
);


create table VAE (
	codeue varchar2(10),
	numEtudiant number,
	constraint pkVAE primary key(codeue, numEtudiant)	
);

create table choixUE (
	codeue varchar2(10),
	numEtudiant number,
	constraint pkChoixUE primary key(codeue, numEtudiant)
);


create table APDJ (
	codeue varchar2(10),
	numEtudiant number,
	constraint pkAPDJ primary key(codeue, numEtudiant)	
);

	
create table Enseignant (
	idenseignant number,
	mdp varchar2(40),
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(40),
	constraint pkEnseignant primary key(idenseignant)
);

-- Statuts

create table Statut (
	idstatut number,
	libelle varchar2(20),
	constraint pkStatut primary key(idstatut)
);


-- Notes
create table Note (
	noteSession1 number(4,2),
	noteSession2 number(4,2),
	numEtudiant number,
	codeMatiere varchar2(10),
	constraint pkNote primary key(numEtudiant, codeMatiere)	
);


create table PointsJury (
	nbPoints number(4,2),
	numEtudiant number,
	codesemestre varchar2(10),
	constraint pkPointJury primary key(numEtudiant, codeSemestre)
);


create table Redoublant (
	moyenne number(4, 2),
	numEtudiant number,
	codesemestre varchar2(10),
	constraint pkRedoublant primary key(numEtudiant, codeSemestre)
);

	
create table Provenance (
	idprovenance number,
	libelleProvenance varchar2(20),
	constraint pkProvenance primary key(idprovenance)
);


create table etranger (
	moyenne number(4,2),
	numEtudiant number,
	codesemestre varchar2(10),
	constraint pkEtranger primary key(numEtudiant, codeSemestre)
);


create table nationalite (
	idnationalite number,
	libelleNationalite varchar2(20),
	constraint pkNationalite primary key(idnationalite)
);


------------ Sequence 
--@deprecated
--sequence pour les pk des notes
--create sequence note_pk_seq
--start with 1 
--increment by 1 
--nomaxvalue; 




-- Procedure

--Creation des procedures pl/sql

--------type table pour la recuperation d'etudiants
--une table de numeros d'etudiants

create type Etud_num as object (
	numEtudiant number
);
/

create type Etud_num_tab is table of Etud_num;
/



---------get_liste_etud_etape
--in: codeEtape
--out: [numEtudiant]

--require:
--	Le codeEtape corRESPond au code d'une etape
--	existante
--ensure:
--	[numEtudiant] contient tous les numeros 
--	d'etudiants qui sont inscrits a l'etape

create or replace function get_liste_etud_etape
( codeEtape_in IN Etape.codeEtape%type )
return Etud_num_tab
is
	--pour stocker la liste des etudiants
	liste_etud Etud_num_tab := Etud_num_tab();
	n integer := 0;
begin
	--recuperation de la liste des etudiants
	
	for r in (
	select numEtudiant
	from Etudiant etud
	where etud.codeetape = codeEtape_in
	)
	loop
		liste_etud.extend;
		n := n+1;
		liste_etud(n) := Etud_num(r.numEtudiant);
	end loop;
	return liste_etud;
end;
/



---------get_liste_etud_semestre
--in: codeSemestre
--out: [numEtudiant]

--require:
--	Le codeSemestre correspond au code d'un
--	semestre existante
--ensure:
--	[numEtudiant] contient tous les numeros 
--	d'etudiants qui sont inscrits au semestre

create or replace function get_liste_etud_semestre
( codeSemestre_in IN Semestre.codeSemestre%type )
return Etud_num_tab
is
	--pour stocker la liste des etudiants
	liste_etud Etud_num_tab := Etud_num_tab();
	--l'etape qui comporte le semestre concernee
	codeEtape_t Etape.codeEtape%type;
	
begin
	--recuperation de l'Etape
	select codeEtape into codeEtape_t
	from Semestre
	where codeSemestre = codeSemestre_in;

	--recuperation de la liste des etudiants
	liste_etud := get_liste_etud_etape(codeEtape_t);

	return liste_etud;
end;
/


---------get_liste_etud_ue
--in: codeUE
--out: [numEtudiant]

--require:
--	Le codeUE correspond au code d'une UE
--	existante
--ensure:
--	[numEtudiant] contient tous les numeros 
--	d'etudiants qui sont inscrits a l'UE

create or replace function get_liste_etud_UE
( codeUE_in IN UE.codeUE%type )
return Etud_num_tab
is
	--pour stocker la liste des etudiants
	liste_etud Etud_num_tab := Etud_num_tab();
	--le semestre qui comporte l'ue concerne
	codeSemestre_t Semestre.codeSemestre%type;
	--indique si l'UE est optionnel
	UEoptionnel UE.optionnel%type;
	--entier pour la boucle
	n integer := 0;
begin
	--recuperation de l'UE
	select optionnel into UEoptionnel
	from UE
	where codeUE = codeUE_in;

	--si l'UE est optionnel
	if UEoptionnel = 'T' then
		--on recupere les etudiants dans la 
		--relation choisir UE
		for r in (select numEtudiant from choixUE where codeUE = codeUE_in)
		loop
			liste_etud.extend;
			n := n + 1;
			--on ajoute les etudiants a la liste_etud
			liste_etud(n) := Etud_num(r.numetudiant);
		end loop;
		
	else
		--recuperation du code du semestre
		select codeSemestre
		into codeSemestre_t
		from UE
		where codeUE = codeUE_in;

		--on recupere la liste des etudiants
		--a partir du semestre
		liste_etud := get_liste_etud_semestre(codeSemestre_t);
	end if;
	return liste_etud;
end;
/



---------get_liste_etud_ecue
--in: codeMatiere
--out: [numEtudiant]

--require:
--	Le codeMatiere correspond au code d'une matiere
--	existante
--ensure:
--	[numEtudiant] contient tous les numeros 
--	d'etudiants qui sont inscrits a l'ECUE

create or replace function get_liste_etud_ecue(codeMatiere_in IN ECUE.codeMatiere%type)
return Etud_num_tab
is
	--pour stocker la liste des etudiants
	liste_etud Etud_num_tab := Etud_num_tab();
	--l'UE qui comporte l'ECUE concernee
	codeUE_t UE.codeUE%type;
begin
	--recuperation de l'UE
	select codeUE into codeUE_t
	from ECUE
	where codeMatiere = codeMatiere_in;

	--recuperation de la liste des etudiants
	liste_etud := get_liste_etud_ue(codeUE_t);

	return liste_etud;
end;
/

-- CreateView
-- Creation des vues nécessaires

--Vue VO_Departement
--pk: (VersionDiplome)
--
create or replace type TDepartement as object (
	versionDiplome varchar2(10),
	nomDepartement varchar2(100),
	mnemo varchar2(10),	
	nomResponsable varchar2(20),
	prenomResponsable varchar2(20)	
);
/

create or replace view VO_Departement of TDepartement
with object identifier(versionDiplome) as
select d.versionDiplome, d.nomDepartement, d.mnemo,
ens.nom as nomResponsable, ens.prenom as prenomResponsable
from Departement d, Enseignant ens
where d.idEnseignant = ens.idEnseignant;
/

--Vue VO_Etape
--pk: (codeEtape, codeSemestre)
--
create or replace type TEtape as object(
	codeEtape varchar2(10),
	versionEtape varchar2(10),
	versionDiplome varchar2(10),
	nomResponsable varchar2(20),
	prenomResponsable varchar2(20),
	codeSemestre varchar2(10),
	libelleSemestre varchar2(10),
	nbUEFacultatives number
);
/

create or replace view VO_Etape of TEtape
with object identifier( codeEtape, codeSemestre) as
select e.codeEtape, versionEtape, versionDiplome,
ens.nom as nomResponsable, ens.prenom as prenomResponsable,
s.codeSemestre, libelleSemestre, nbUEFacultatives
from Etape e, Semestre s, Enseignant ens
where e.codeEtape = s.codeEtape
and e.idEnseignant = ens.idEnseignant;
/


--Vue VO_EtudEtape
--pk: (numEtudiant, codeEtape)
--
create or replace type TEtudiantEtape as object(
	numEtudiant number,
	numIne varchar2(15),
	libelleProvenance varchar2(20),
	libelleStatut varchar2(10),
	libelleNationalite varchar2(20),
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(40),
	codeEtape varchar2(10),
	pointJuryAnnee number(4,2),
	scoreToeic number
);
/

create or replace view VO_EtudiantEtape of TEtudiantEtape
with object identifier( numEtudiant, codeEtape ) as 
select e.numEtudiant, e.numIne, p.libelleProvenance, s.libelle as libelleStatut,
n.libelleNationalite, e.nom, e.prenom, e.mail, et.codeEtape,
e.PointJuryAnnee, e.scoreTOEIC
from Etudiant e, Etape et, provenance p, statut s, nationalite n
where e.idProvenance = p.idProvenance
and e.idNationalite = n.idNationalite
and e.idStatut = s.idStatut
and e.numEtudiant in (
	select l.numEtudiant
	from table(get_liste_etud_etape(et.codeEtape)) l
);
/


--Vue EtudiantSemestre
--pk: ( numEtudiant, codeSemestre )
--
create or replace type TEtudiantSemestre as object(
	numEtudiant number,
	codeSemestre varchar2(10),
	numIne varchar2(15),
	libelleProvenance varchar2(20),
	libelleStatut varchar2(10),
	libelleNationalite varchar2(20),
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(40),
	pointJurySemestre number(4,2),
	moyenneEtranger number(4, 2),
	moyenneRedoublant number(4,2)
);
/

--function getPJSemestre
--in: numEtudiant, codeSemestre
--out: number
create or replace function getPJSemestre(
numetudiant_in IN Etudiant.numetudiant%type,
codeSemestre_in IN Semestre.codeSemestre%type) 
return number
is
	--commentaire
	num number;
begin
	select nbPoints into num
	from PointsJury pj
	where pj.numEtudiant = numEtudiant_in
	and pj.codeSemestre = codeSemestre_in;
	if (num > 0) then		
		return num;
	end if;
	return 0;
exception
	when others then
		return 0;
end;
/


--function getMoyenneEtr
--in: numEtudiant, codeSemestre
--out: number
create or replace function getMoyenneEtr(
numetudiant_in IN Etudiant.numetudiant%type,
codeSemestre_in IN Semestre.codeSemestre%type) 
return number
is
	--commentaire
	num number;
begin
	select moyenne into num
	from Etranger etr
	where etr.numEtudiant = numEtudiant_in
	and etr.codeSemestre = codeSemestre_in;
	if (num > 0) then		
		return num;
	end if;
	return null;
exception
	when others then
		return null;
end;
/


--function getMoyenneRed
--in: numEtudiant, codeSemestre
--out: number
create or replace function getMoyenneRed(
numetudiant_in IN Etudiant.numetudiant%type,
codeSemestre_in IN Semestre.codeSemestre%type) 
return number
is
	--commentaire
	num number;
begin
	select moyenne into num
	from Redoublant red
	where red.numEtudiant = numEtudiant_in
	and red.codeSemestre = codeSemestre_in;
	if (num > 0) then		
		return num;
	end if;
	return null;
exception
	when others then
		return null;
end;
/


create or replace view VO_EtudiantSemestre of TEtudiantSemestre
with object identifier( numEtudiant, codeSemestre ) as
select distinct e.numEtudiant, u.codeSemestre, e.numIne, p.libelleProvenance, s.libelle as libelleStatut,
n.libelleNationalite, e.nom, e.prenom, e.mail,
getPJSemestre(e.numetudiant, u.codeSemestre),
getMoyenneEtr(e.numetudiant, u.codeSemestre),
getMoyenneRed(e.numetudiant, u.codeSemestre)
from Etudiant e, UE u, provenance p, statut s, nationalite n
where e.idProvenance = p.idProvenance
and e.idNationalite = n.idNationalite
and e.idStatut = s.idStatut
and e.numEtudiant in (
	select l.numEtudiant
	from table(get_liste_etud_semestre(u.codeSemestre)) l
);
/

--Vue UE
--pk: ( codeUE, codeSemestre )
--
create or replace type TUE as object(
	codeUE varchar2(10),
	nbECTS number,
	libelleUE varchar2(50),
	optionnel char(1),
	nomResponsable varchar2(20),
	prenomResponsable varchar2(20),
	codeSemestre varchar2(10)
);
/

create or replace view VO_UE of TUE
with object identifier( codeUE, codeSemestre ) as
select u.codeUE, u.nbECTS, u.libelleUE, u.optionnel,
ens.nom, ens.prenom, u.codeSemestre
from UE u, Enseignant ens
where ens.idenseignant = u.idenseignant;
/


--Vue EtudUE
--pk: ( numEtudiant, codeUE)
--
create or replace type TEtudiantUE as object(
	numEtudiant number,
	numIne varchar2(15),
	libelleProvenance varchar2(20),
	libelleStatut varchar2(10),
	libelleNationalite varchar2(20),
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(40),
	codeUE varchar2(10),
	vae varchar2(1),
	apdj varchar2(1)
);
/


--function is_vae
--in: numEtudiant, codeUE
--out: 'T' ou 'F'
create or replace function is_vae(numEtudiant_in IN Etudiant.numetudiant%type, codeUE_in IN UE.codeUE%type) 
return varchar2
is
	--commentaire
	num number;
begin
	select count(*) into num
	from vae v
	where v.codeUE = codeUE_in
	and v.numEtudiant = numEtudiant_in;
	if (num = 0) then		
		return 'f';
	else
		return 't';
	end if;
end;
/	

--function is_apdj
--in: numEtudiant, codeUE
--out: 'T' ou 'F'
create or replace function is_apdj(numEtudiant_in IN Etudiant.numetudiant%type, codeUE_in IN UE.codeUE%type) 
return varchar2
is
	--commentaire
	num number;
begin
	select count(*) into num
	from apdj a
	where codeUE = codeUE_in
	and numEtudiant = numEtudiant_in;
	if (num = 0) then		
		return 'f';
	else
		return 't';
	end if;
end;
/

create or replace view VO_EtudiantUE of TEtudiantUE
with object identifier( numEtudiant, codeUE ) as
select e.numEtudiant, e.numINE, p.libelleProvenance,
s.libelle as libelleStatut, n.libelleNationalite, e.nom, e.prenom, 
e.mail, u.codeUE,
is_vae(numEtudiant, codeUE), is_apdj(numEtudiant, codeUE)
from Etudiant e, UE u, provenance p, statut s, nationalite n
where e.idprovenance = p.idprovenance
and e.idstatut = s.idstatut
and e.idnationalite = n.idnationalite
and e.numEtudiant in (
	select l.numEtudiant
	from table(get_liste_etud_ue(u.codeUE)) l
);
/


--Vue ECUE
--pk: ( codeMatiere, codeUE )
--
create or replace type TECUE as object (
	codeMatiere varchar2(10),
	libelleECUE varchar2(50),
	nbHeures number,
	nomResponsable varchar2(20),
	prenomResponsable varchar2(20),
	codeue varchar2(10)
);
/

create or replace view VO_ECUE of TECUE
with object identifier( codeMatiere, codeUE )as
select ec.codeMatiere, ec.libelleECUE, ec.nbHeures, en.nom, en.prenom, u.codeUE
from ECUE ec, Enseignant en, UE u
where ec.idEnseignant = en.idEnseignant
and ec.codeue = u.codeUE;
/

--vue EtudiantECUE
--pk: ( numEtudiant, codeMatiere)
--
create or replace type TEtudiantECUE as object (
	codeMatiere varchar2(10),
	numEtudiant number,
	numIne varchar2(15),
	libelleProvenance varchar2(20),
	libelleStatut varchar2(10),
	libelleNationalite varchar2(20),
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(40),
	noteSession1 number(4,2),
	noteSession2 number(4,2)
);
/

create or replace view VO_EtudiantECUE of TEtudiantECUE
with object identifier(codeMatiere, numEtudiant) as
select ec.codeMatiere, e.numetudiant, e.numINE,
p.libelleProvenance, s.libelle as libelleStatut, n.libelleNationalite,
e.nom, e.prenom, e.mail, n.noteSession1, n.noteSession2
from etudiant e, note n, ecue ec, provenance p, statut s, nationalite n
where e.numetudiant = n.numetudiant(+)
and n.codeMatiere = ec.codeMatiere
and p.idprovenance = e.idprovenance
and s.idstatut = e.idstatut
and n.idnationalite = e.idnationalite
UNION
select ec.codeMatiere, e.numetudiant, e.numINE,
p.libelleProvenance, s.libelle as libelleStatut, n.libelleNationalite,
e.nom, e.prenom, e.mail, null, null
from etudiant e, provenance p, statut s, nationalite n, ecue ec
where p.idprovenance = e.idprovenance
and s.idstatut = e.idstatut
and n.idnationalite = e.idnationalite
and e.numetudiant in (
	select le.numEtudiant
	from table(get_liste_etud_ecue(ec.codeMatiere)) le
)
MINUS (
	select ec.codeMatiere, e.numetudiant, e.numINE,
	p.libelleProvenance, s.libelle as libelleStatut, n.libelleNationalite,
	e.nom, e.prenom, e.mail, null, null
	from etudiant e, note n, ecue ec, provenance p, statut s, nationalite n
	where e.numetudiant = n.numetudiant(+)
	and n.codeMatiere = ec.codeMatiere
	and p.idprovenance = e.idprovenance
	and s.idstatut = e.idstatut
	and n.idnationalite = e.idnationalite
	INTERSECT
	select ec.codeMatiere, e.numetudiant, e.numINE,
	p.libelleProvenance, s.libelle as libelleStatut, n.libelleNationalite,
	e.nom, e.prenom, e.mail, null, null
	from etudiant e, provenance p, statut s, nationalite n, ecue ec
	where p.idprovenance = e.idprovenance
	and s.idstatut = e.idstatut
	and n.idnationalite = e.idnationalite
	and e.numetudiant in (
		select le.numEtudiant
		from table(get_liste_etud_ecue(ec.codeMatiere)) le
	)
);
/

---------------------------------------------------------------------
-----------------------------FIN DES VUES----------------------------
---------------------------------------------------------------------



--type responsable
create or replace type TResp as object (
  codeResponsabilite varchar2(10),
  libelle varchar2(20)
);
/

create or replace type Resp_tab as table of TResp;
/

---------get_liste_resp
--in: idEnseignant
--out: [codeResponsabilite, libelle]

--require:
--	Le l'id enseignant référence un ensaignant
--ensure:
--	[codeResponsabilite, libelle] contient la liste de 
--  toutes les responsabilités d'un enseignant

create or replace function get_liste_resp
( idEnseignant_in IN Enseignant.idEnseignant%type )
return Resp_tab
is
    --pour stocker la liste responsabilites
    liste_resp Resp_tab := Resp_tab();
    n integer := 0;
begin

    --liste de l'ECUE
    for r in (
        select ec.codeMatiere
        from ECUE ec
        where ec.idEnseignant = idEnseignant_in
    )
    loop
        liste_resp.extend;
        n := n+1;
        liste_resp(n) := TResp(r.codeMatiere, 'ECUE');
    end loop;
    
    --liste de l'UE
    for r in (
        select u.codeUE
        from UE u
        where u.idEnseignant = idEnseignant_in
    )
    loop
        liste_resp.extend;
        n := n+1;
        liste_resp(n) := TResp(r.codeUE, 'UE');
    end loop;
    
    --liste de l'Etape
    for r in (
        select e.codeEtape
        from Etape e
        where e.idEnseignant = idEnseignant_in
    )
    loop
        liste_resp.extend;
        n := n+1;
        liste_resp(n) := TResp(r.codeEtape, 'Etape');
    end loop;
    
    --liste du Departement
    for r in (
        select d.versionDiplome
        from Departement d
        where d.idEnseignant = idEnseignant_in
    )
    loop
        liste_resp.extend;
        n := n+1;
        liste_resp(n) := TResp(r.versionDiplome, 'Departement');
    end loop;
    
    --renvoie le resultat
    return liste_resp;
end get_liste_resp;
/


--vue utilisateur
create or replace type TUtilisateur as object(
    idEnseignant number,
    nom varchar2(20),
    prenom varchar2(20),
    mdp varchar2(10),
	mail varchar2(40),
    codeResponsabilite varchar2(10),
    libelle varchar2(10)
);
/

create or replace view VO_Utilisateur of TUtilisateur
with object identifier(idEnseignant, codeResponsabilite)
as
select en.idEnseignant, en.nom, en.prenom, en.mdp, mail,
resp.codeResponsabilite, resp.libelle
from Enseignant en, table(get_liste_resp(en.idEnseignant)) resp
UNION
select en.idEnseignant, en.nom, en.prenom, en.mdp, mail,
null, null
from Enseignant en
where en.nom='root'
and en.prenom='root'
;
/


-- Triggers

--Update sur vo_Etudiantecue
create or replace trigger vo_Etudiantecue_up
instead of update on vo_Etudiantecue
for each row
declare
begin
	update Note set
		noteSession1 = :new.noteSession1,
		noteSession2 = :new.noteSession2
	where numEtudiant = :new.numEtudiant
	and codeMatiere = :new.codeMatiere;
	if (sql%rowcount = 0) then
		insert into Note values(
			:new.noteSession1, :new.noteSession2, :new.numEtudiant, :new.codeMatiere
		);
	end if;
end vo_Etudiantecue_uP;
/



--Update sur vo_EtudiantSemestre
create or replace trigger vo_EtudiantSemestre_up
instead of update on vo_EtudiantSemestre
for each row
declare
begin
	update PointsJury set
		nbpoints = :new.pointJurySemestre
	where numEtudiant = :new.numEtudiant
	and codeSemestre = :new.codeSemestre;
	if (sql%rowcount = 0) then
		insert into PointsJury values(
			:new.pointJurySemestre, :new.numEtudiant, :new.codeSemestre
		);
	end if;
end vo_EtudiantSemestre_up;
/

--Update sur vo_EtudiantEtape
create or replace trigger vo_EtudiantEtape_up
instead of update on vo_EtudiantEtape
for each row
declare
begin
	update Etudiant set
		pointjuryannee = :new.pointJuryAnnee,
		scoreToeic = :new.scoreToeic
	where numEtudiant = :new.numEtudiant
	and codeEtape = :new.codeEtape;
	--Vu que les points sont stockés dans la table etudiant, théoriquement
	--si on update vo_etudiantecue, l'etudiant existe forcement, donc pas 
	--sql%rowcount bla bla bla ...
end vo_EtudiantEtape_up;
/



--Suppression de l'etudiant 
--Lors de la suppression, toutes les notes de l'etudiant sont supprime
create or replace trigger etudiant_del
	before delete
	on etudiant
	for each row
declare
begin
	delete from note where numetudiant = :old.numetudiant;
		
	--liaison a l'ue	
	delete from vae where numetudiant = :old.numetudiant;
	delete from choixUE where numetudiant = :old.numetudiant;
	delete from apdj where numetudiant = :old.numetudiant;
		
	--Liaison au semestre	
	delete from pointsjury where numetudiant = :old.numetudiant;
	delete from redoublant where numetudiant = :old.numetudiant;
	delete from etranger where numetudiant = :old.numetudiant;
		
end etudiant_del;
/

create sequence utilSeq start with 1 increment by 1 nomaxvalue;

create or replace function getHash(p_in varchar2)
return raw is
begin
	return DBMS_CRYPTO.HASH (src => UTL_RAW.cast_to_raw(p_in), typ => DBMS_CRYPTO.hash_sh1);
end;
/


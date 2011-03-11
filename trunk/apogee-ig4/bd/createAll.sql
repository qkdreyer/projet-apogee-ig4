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
	versionEtape varchar2(10), -- le chiffre de l'année ?
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


create table Utilisateur (
	idutilisateur number,
	mdp varchar2(20),
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
	numEtudiant number	
);

create table choixUE (
	codeue varchar2(10),
	numEtudiant number	
);


create table APDJ (
	codeue varchar2(10),
	numEtudiant number	
);

	
-- Qu'est ce que l'enseignant a en plus de la secretaire ?
create table Enseignant (
	idenseignant number,
	mdp varchar2(20),
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(40),
	constraint pkEnseignant primary key(idenseignant)
);


create table Secretaire (
	idsecretaire number,
	mdp varchar2(20),
	nom varchar2(20),
	prenom varchar2(20),
	mail varchar2(40),
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
	noteSession1 number(4,2),
	noteSession2 number(4,2),
	numEtudiant number,
	codeMatiere varchar2(10),
	constraint pkNote primary key(idnote)	
);


create table PointsJury (
	idPointsJury number,
	nbPoints number,
	numEtudiant number,
	codesemestre varchar2(10),
	constraint pkPointJury primary key(idPointsJury)
);


create table Redoublant (
	idredoublant number,
	moyenne number,
	numEtudiant number,
	codesemestre varchar2(10),
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
	codesemestre varchar2(10),
	constraint pkEtranger primary key(idetranger)
);


create table nationalite (
	idnationalite number,
	libelleNationalite varchar2(20),
	constraint pkNationalite primary key(idnationalite)
);


------------ Sequence 
--sequence pour les pk des notes
create sequence note_pk_seq
start with 1 
increment by 1 
nomaxvalue; 




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
--	Le codeEtape correspond au code d'une etape
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

create or replace function get_liste_etud_ecue
( codeMatiere_in IN ECUE.codeMatiere%type )
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

-- Creation des vues objets utilisant la base relationelle

-- Creation du type qui composera la vue;

create or replace type TEtud as object (
	numEtudiant number,
	nom varchar2(20),
	prenom varchar2(20),
	noteSession1 number(4,2),
	noteSession2 number(4,2)
);
/

create or replace type TEtud_nt as table of TEtud;
/

create or replace type TECUE as object (
	codeMatiere varchar2(10),
	libelleECUE varchar2(50),
	nbheures number,
	idenseignant number,
	codeue varchar2(10),
	listeEtud TEtud_nt
);
/

--TODO: Requete ne fonctionne que lorsque l'on
--met un where pour séléctioner une unique ECUE
--
--@fix(10/03/11) : rajout de la condition sur la jointure entre l'ecue
--et la note, sinon une note était valable pour toutes les ecue de l'etud
create or replace view VO_ECUE of TECUE
with object identifier(codeMatiere)
as
select ec.codeMatiere, ec.libelleECUE, ec.nbheures, ec.idenseignant, ec.codeue, cast( multiset(
	select distinct e.numEtudiant, e.nom, e.prenom,
		n.noteSession1, n.noteSession2
	from Etudiant e, Note n
	where n.codeMatiere(+) = ec.codeMatiere
	and n.numEtudiant(+)= e.numEtudiant
	and e.numEtudiant in (
		Select le.numEtudiant
		from table(get_liste_etud_ecue(ec.codeMatiere)) le
		)
	)as TEtud_nt)
from ECUE ec;
/

--TODO:vue etudiant, a supprimer?
--create or replace view VO_Etud of Tetud
--with object identifier(numEtudiant)
--as
--	select distinct e.numEtudiant, e.nom, e.prenom,
--		n.noteSession1, n.noteSession2
--	from Etudiant e, Note n
--	where n.numEtudiant(+)= e.numEtudiant
--	and e.numEtudiant in (
--		Select le.numEtudiant
--		from table(get_liste_etud_ecue(e.codeMatiere)) le
--		)
--;
--/


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
    codeResponsabilite varchar2(10),
    libelle varchar2(10)
);
/

create or replace view VO_Utilisateur of TUtilisateur
with object identifier(idEnseignant, codeResponsabilite)
as
select en.idEnseignant, en.nom, en.prenom, en.mdp,
resp.codeResponsabilite, resp.libelle
from Enseignant en, table(get_liste_resp(en.idEnseignant)) resp;
/





-- Triggers

--Insertion sur vo_ecue
create or replace trigger vo_ecue_up
    instead of update
    on vo_ecue
    for each row
declare
    idNote number;
begin
    if (:new.listeEtud is not null)
    and (:new.listeEtud.count > 0) then
        for i in :new.listeEtud.first .. :new.listeEtud.last loop
            update note
            set noteSession1 = :new.listeEtud(i).noteSession1,
            noteSession2 = :new.listeEtud(i).noteSession2
            where numEtudiant = :new.listeEtud(i).numEtudiant;
            if ( sql%rowcount = 0 ) then
                select note_pk_seq.nextval into idNote from dual;
                insert into note
                (idNote, noteSession1, noteSession2, numEtudiant, codeMatiere)
                values
                (idNote, :new.listeEtud(i).noteSession1, :new.listeEtud(i).noteSession2,
                :new.listeEtud(i).numEtudiant, :new.codeMatiere);
            end if;
        end loop;
    end if;
end vo_ecue_up;
/





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
	from Etudiant Etud
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
	liste_etud := table(
		get_liste_etud_etape(codeEtape_t)
	);

	return liste_etud;
end;


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
			liste_etud(n) := r;
		end loop;
		
	else
		--recuperation du code du semestre
		select codeSemestre
		into codeSemestre_t
		from UE
		where codeUE = codeUE_in;

		--on recupere la liste des etudiants
		--a partir du semestre
		liste_etud := table(
			get_liste_etud_semestre(codeSemestre)
		);
	end if;
	return liste_etud;
end;



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
	liste_etud := table(
		get_liste_etud_ue(codeUE_t)
	);

	return liste_etud;
end;

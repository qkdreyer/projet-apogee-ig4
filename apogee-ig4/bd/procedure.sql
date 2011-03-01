--Creation des procedures pl/sql

--------type table pour la recuperation d'etudiants
--une table de numeros d'etudiants
create type Etud_num_tab is table of
	Etudiant.numEtudiant%type;



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

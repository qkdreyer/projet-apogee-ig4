-- Creation des vues objets utilisant la base relationelle

-- Creation du type qui composera la vue;

create or replace type TEtud as object (
	numEtudiant number,
	nom varchar2(20),
	prenom varchar2(20),
	noteSession1 number,
	noteSession2 number
);

create or replace type TEtud_nt as table of TEtud;

create or replace type TECUE as object (
	codeMatiere number,
	libelleECUE varchar2(50),
	nbheures number,
	idenseignant number,
	codeue number,
	listeEtud TEtud_nt
);

create or replace view VO_ECUE of TECUE
with object identifier(codeMatiere)
as
select ec.codeMatiere, ec.libelleECUE, ec.nbheures, ec.idenseignant, ec.codeue, cast( multiset(
	select e.numEtudiant, e.nom, e.prenom,
		n.noteSession1, n.noteSession2
	from Etudiant e, Note n
	where n.numEtudiant = e.numEtudiant
	and e.numEtudiant in
		get_liste_etud_ecue(ec.codeMatiere)
	)as TEtud_nt)
from ECUE ec;


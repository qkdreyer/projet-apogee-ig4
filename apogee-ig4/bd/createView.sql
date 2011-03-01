-- Creation des vues objets utilisant la base relationelle

-- Creation du type qui composera la vue;

create type TEtud as object 

create type TEtud_nt as table of TEtud;

create type TECUE as object (
	codeMatiere number,
	libelleECUE varchar2(50),
	nbheures number,
	idenseignant number,
	codeue number
)

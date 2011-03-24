drop table vae;
drop table choixUE;
drop table apdj;
drop table note;
drop table pointsjury;
drop table redoublant;
drop table etranger;

drop table etudiant;

drop table provenance;
drop table statut;
drop table nationalite;

drop table ecue;
drop table ue;
drop table semestre;
drop table etape;
drop table departement;

drop table personne;
-- drop table utilisateur;

drop table enseignant;
-- drop table secretaire;

-- drop sequence note_pk_seq;
drop view vo_ecue;


drop type ETUD_NUM_TAB;
drop type ETUD_NUM;

drop type tecue;
-- drop type tetud_nt;
-- drop type tetud;


--drop 
drop view VO_Utilisateur;
drop type TUtilisateur;
drop function get_liste_resp;
drop type Resp_tab;
drop type TResp;

drop view VO_DEPARTEMENT;
drop view VO_ETAPE;
drop view VO_ETUDIANTECUE;
drop view VO_ETUDIANTETAPE;
drop view VO_ETUDIANTSEMESTRE;
drop view VO_ETUDIANTUE;
drop view VO_UE;


drop sequence utilseq;

purge recyclebin;
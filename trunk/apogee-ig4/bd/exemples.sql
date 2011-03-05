
--usage de update pour rajouter/mettre a jours des notes
update vo_ecue
set listeEtud = TEtud_nt(TEtud(20070009, 'meyer', 'lisa', 11, 4))
where codematiere = 'PSTIA502';

-- Remplissage de la avec des etudiants, professeur,ECUE,
-- UE, semestre, année, département

insert into Departement values ('PI01','Informatique et gestion','IG',1001);
insert into Departement values ('PI02','Sciences et Techniques des Industries Agroalimentaires','STIA',2176);

insert into Etape values ('10','3',1001,'PI01');
insert into Etape values ('20','3',2176,'PI02');
insert into Etape values ('11','4',1001,'PI01');

insert into Semestre values ('51','s05',0,'10');
insert into Semestre values ('61','s06',0,'10');
insert into Semestre values ('52','s05',0,'20');
insert into Semestre values ('62','s06',0,'20');
insert into Semestre values ('71','s07',0,'11');
insert into Semestre values ('81','s08',0,'11');

insert into ECUE values ('PIG501','algorithmique',100,1432,'PIGU51');
insert into ECUE values ('PIG502','Unix',15,1569,'PIGU51');
insert into ECUE values ('PIG503','Comptabilité',65,1001,'PIGU52');
insert into ECUE values ('PIG601','ADA',85,1569,'PIGU61');
insert into ECUE values ('PIG602','architecture',28,1999,'PIGU61');
insert into ECUE values ('PIG603','communication',10,1111,'PIGU62');
insert into ECUE values ('PIG701','conception objet',55,1859,'PIGU71');
insert into ECUE values ('PIG702','ingénierie objet',125,1321,'PIGU71');
insert into ECUE values ('PSTIA501','nutella',3,2176,'PSTIAU51');
insert into ECUE values ('PSTIA502','malakoff',5,2153,'PSTIAU51');
insert into ECUE values ('PSTIA601','beurre de cacahuètes',2,2384,'PSTIAU52');
insert into ECUE values ('PSTIA602','malakoff avancée',7,2153,'PSTIAU61');

insert into UE values ('PIGU51',9,'informatique imperative','f',1432,51);
insert into UE values ('PIGU52',3,'base comptable','f',1001,51);
insert into UE values ('PIGU61',5,'informatique sécuritaire','f',1569,61);
insert into UE values ('PIGU62',3,'langues et communication','f',1111,61);
insert into UE values ('PIGU71',8,'informatique objet','f',1321,71);
insert into UE values ('PSTIAU51',8,'pate a tartiner','f',2153,52);
insert into UE values ('PSTIAU52',5,'mode américaine','f',2384,52);
insert into UE values ('PSTIAU61',9,'pate a tartiner: concept avancés','f',2153,62);

insert into Enseignant values (0,getHash('root'),'root','root','');
insert into Enseignant values (1001,getHash('roux'),'villaret','anne-laure','alv@crepuq.fr');
insert into Enseignant values (1432,getHash('ada'),'vilarem','marie-catherine','mcv@lirmm.fr');
insert into Enseignant values (1569,getHash('cheveux'),'berry','vincent','vberry@lirmm.fr');
insert into Enseignant values (1999,getHash('mcdo'),'crepin','ludivine','ludivine@crepin.fr');
insert into Enseignant values (1111,getHash('ihouse'),'dumas','marc','marc@cool.fr');
insert into Enseignant values (1321,getHash('sr8'),'stratulat','tiberiu','tibi@pologne.ro');
insert into Enseignant values (1859,getHash('futurpierre'),'sala','michel','mimi@laposte.fr');
insert into Enseignant values (2176,getHash('nut'),'Donald','Mac','mcdo@quick.fr');
insert into Enseignant values (2153,getHash('ales'),'debombe','balle','nutellepuissance1000@gmail.com');
insert into Enseignant values (2384,getHash('breakingbad'),'white','walter','drogue@bang.com');
-- insert into Secretaire values (1000,getHash('pausecafe'),'tortosa','helene','helene@tortue.fr');

insert into Provenance values (01,'prepa intégré');
insert into Provenance values (02,'IUT');
insert into Provenance values (03,'fac');
insert into Provenance values (04,'chine');

insert into Statut values (03,'aucune statut');
insert into Statut values (69,'consanguin');

insert into Nationalite values (01,'france');
insert into Nationalite values (02,'chine');
insert into Nationalite values (03,'mexique');
insert into Nationalite values (04,'besseges');

insert into Etudiant values (20070001,0,'PUM20001',885,01,03,01,'11','puechlong','joris','joris@redoublant.com');
insert into Etudiant values (20070002,0,'PUM2002',990,01,03,01,'11','jambet','pierre','pierre@nicolas.con');
insert into Etudiant values (20070003,0,'PUM2003',255,01,03,01,'11','dreyer','quentin', 'quentin@dreyer.fr');
insert into Etudiant values (20070004,0,'PUM2004',010,04,03,02,'11','michel','benjamin','benji@china.cn');
insert into Etudiant values (20070005,0,'PUM2005',235,01,69,04,'11','coudsi','julien','besseges@uneseulerace.bes');

insert into Etudiant values (20070006,0,'PUM2006',700,01,03,01,'10','costanza','guillaume','gc@popo.fr');
insert into Etudiant values (20070007,0,'PUM2007',700,01,03,01,'10','rance','justine','rancitude@laposte.net');
insert into Etudiant values (20070008,0,'PUM2008',700,01,03,01,'10','paze','yannick','dieguito@pasderace.com');

insert into Etudiant values (20070009,0,'PUM2009',500,01,03,01,'20','meyer','lisa','jsuitrobonne@sex.xx');
insert into Etudiant values (20070010,0,'PUM2010',500,01,03,01,'20','asse','bomb','6@9.xnxx');

insert into Etudiant values (20079999,0,'PUM9999',700,01,03,02,'11','moreau','js','papa@bientot.com');
insert into Etudiant values (20060006,0,'PUM2200',900,02,03,01,'11','romand','olivier','olivier@met.fi');
	
insert into Note values(13,0,20070002,'PIG701');
insert into Note values(08,9,20070001,'PIG701');
insert into Note values(06,08,20070001,'PIG702');
insert into Note values(18,0,20070002,'PIG702');
insert into Note values(02,03,20070003,'PIG702');
insert into Note values(03,02,20070003,'PIG701');

-- UE Level
insert into APDJ values('PIGU71',20070001);
insert into VAE values('PIGU71',20079999);
insert into ChoixUE values('PIGU71',20070003);
	
--Sem Level
insert into PointsJury values(10,20070001,71);
insert into Etranger values(12.7, 20060006,71 );
insert into Redoublant values(3,20070003,71);
	

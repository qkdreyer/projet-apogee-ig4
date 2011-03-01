-- Remplissage de la table avec des etudiants, professeur,ECUE,
-- UE, semestre, année, département

insert into table Etape (10,3,1001,'IG');
insert into table Etape (20,3,1223,'STIA');
insert into table Etape (11,4,1001,'IG');

insert into table Semestre('51','s05',0,10);
insert into table Semestre('61','s06',0,10);
insert into table Semestre('52','s05',0,20);
insert into table Semestre('62','s06',0,20);
insert into table Semestre('71','s07',0,11);
insert into table Semestre('81','s08',0,11);

insert into Departement('PI01','Informatique et gestion','IG',1001);
insert into Departement('PIO2','Sciences et Techniques des l\'Industries Agroalimentaires','STIA',1223);


insert into ECUE('PIG501','algorithmique',100,1432,PIGU51);
insert into ECUE('PIG502','Unix',15,1569,PIGU51);
insert into ECUE('PIG503','Comptabilité',65,1001,PIGU52);
insert into ECUE('PIG601','ADA',85,1569,PIGU61);
insert into ECUE('PIG602','architecture',28,1999,PIGU61);
insert into ECUE('PIG603','communication',10,1111,PIGU62);
insert into ECUE('PIG701','conception objet',55,1859,PIGU71);
insert into ECUE('PIG702','ingénierie objet',125,1321,PIGU71);
insert into ECUE('PSTIA501','nutella',3,2176,PSTIAU51);
insert into ECUE('PSTIA502','malakoff',5,2153,PSTIAU51);
insert into ECUE('PSTIA601','beurre de cacahuètes',2,2384,PSTIAU52);
insert into ECUE('PSTIA602','malakoff avancée',7,2153,PSTIAU61);

insert into table UE('PIGU51',9,'informatique imperative',f,1432,51);
insert into table UE('PIGU52',3,'base comptable',f,1001,51);
insert into table UE('PIGU61',5,'informatique sécuritaire',f,1569,61);
insert into table UE('PIGU62',3,'langues et communication',f,1111,61);
insert into table UE('PIGU71',8,'informatique objet',f,1321,71);
insert into table UE('PSTIAU51',8,'pate a tartiner',f,2153,52);
insert into table UE('PSTIAU52',5,'mode américaine',f,2384,52);
insert into table UE('PSTIAU61',9,'pate a tartiner: concept avancés',f,2153,62);

insert into table Enseignant(1001,'roux','villaret','anne-laure','alv@crepuq.fr');
insert into table Enseignant(1432,'ada','vilarem','marie-catherine','mcv@lirmm.fr');
insert into table Enseignant(1569,'cheveux','berry','vincent','vberry@lirmm.fr');
insert into table Enseignant(1999,'mcdo','crepin','ludivine','ludivine@crepin.fr');
insert into table Enseignant(1111,'ihouse','dumas','marc','marc@cool.fr');
insert into table Enseignant(1321,'sr8','stratulat','tiberiu','tibi@pologne.ro');
insert into table Enseignant(1859,'futurpierre','sala','michel','mimi@laposte.fr');
insert into table Enseignant(2176,'nut','Donald','Mac','mcdo@quick.fr');
insert into table Enseignant(2153,'ales','debombe','balle','nutellepuissance1000@gmail.com');
insert into table Enseignant(2384,'breakingbad','white','walter','drogue@bang.com');
insert into table Secretaire(1000,'pausecafe','tortosa','helene','helene@tortue.fr');

insert into Etudiant(,,'',,,,,,,,'','','')





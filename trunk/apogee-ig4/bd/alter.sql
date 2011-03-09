alter table ECUE
add constraint fkenseignant_ecue foreign key(idenseignant) references enseignant(idenseignant);

alter table ECUE	
add	constraint fkue_ecue foreign key(codeue) references ue(codeue);

alter table UE
add constraint fkenseignant_ue foreign key(idenseignant) references enseignant(idenseignant);

alter table UE
add constraint fksemestre_ue foreign key(codesemestre) references semestre(codesemestre);

alter table semestre
add constraint fketape_semestre foreign key(codeetape) references etape(codeetape);

alter table etape
add constraint fkenseignant_etape foreign key(idenseignant) references enseignant(idenseignant);

alter table etape
add constraint fkdepartement_etape foreign key(mnemo) references departement(mnemo);

alter table departement
add constraint fkenseignant_departement foreign key(idenseignant) references enseignant(idenseignant);

alter table Etudiant
add constraint fketape_etud foreign key(codeetape) references etape(codeetape);

alter table Etudiant
add constraint fkprovenance_etud foreign key(idprovenance) references provenance(idprovenance);

alter table Etudiant
add constraint fkstatut_etud foreign key(idstatut) references statut(idstatut);

alter table Etudiant
add constraint fknationalite_etud foreign key(idnationalite) references nationalite(idnationalite);

--alter table Etudiant
--add constraint fksemestreetud foreign key(codesemestre) references semestre(codesemestre);

alter table vae
add constraint fkuevae foreign key(codeue) references ue(codeue);

alter table vae
add constraint fketudvae foreign key(numetudiant) references etudiant(numEtudiant);

alter table choixUE
add constraint fkue_choixUE foreign key(codeue) references ue(codeue);

alter table choixUE
add constraint fketud_choixUE foreign key(numetudiant) references etudiant(numEtudiant);

alter table apdj
add constraint fkue_apdj foreign key(codeue) references ue(codeue);

alter table apdj
add constraint fketud_apdj foreign key(numetudiant) references etudiant(numEtudiant);

--alter table enseignant
--add constraint fkutilisateur_ens foreign key(idutilisateur) references utilisateur(idutilisateur);

--alter table secretaire
--add constraint fkutilisateur_sec foreign key(idutilisateur) references utilisateur(idutilisateur);

alter table note
add constraint fketudiant_note foreign key(numEtudiant) references etudiant(numEtudiant);

alter table note
add constraint fkecue_note foreign key(codeMatiere) references ecue(codeMatiere);

alter table pointsjury
add constraint fketudiant_pj foreign key(numEtudiant) references etudiant(numEtudiant);

alter table pointsjury
add constraint fksemectre_pj foreign key(codeSemestre) references semestre(codeSemestre);

alter table redoublant 
add constraint fketudiant_red foreign key(numEtudiant) references etudiant(numEtudiant);

alter table redoublant
add constraint fksemestre_red foreign key(codeSemestre) references semestre(codeSemestre);

alter table etranger
add constraint fketudiant_etr foreign key(numEtudiant) references etudiant(numEtudiant);

alter table etranger
add constraint fksemestre_etr foreign key(codeSemestre) references semestre(codeSemestre);

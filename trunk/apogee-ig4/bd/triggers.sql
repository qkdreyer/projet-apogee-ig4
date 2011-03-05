
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


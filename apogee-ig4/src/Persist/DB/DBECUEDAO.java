/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persist.DB;

import POJO.ECUE;
import POJO.ECUE.EtudiantECUE;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Quentin
 */
public class DBECUEDAO extends DBDAO<ECUE> {

    public DBECUEDAO(Connection conn) {
	super(conn);
    }

    public void create(ECUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(ECUE ecue) throws Exception {
	try {
	    Iterator i = ecue.getListeEtud().iterator();
	    while (i.hasNext()) {
		EtudiantECUE etudiant = (EtudiantECUE) i.next();
		Statement s = this.conn.createStatement();
		s.executeUpdate("UPDATE VO_Ecue SET listeEtud = TEtud_NT("
			+ "TEtud(" + etudiant.getNumEtud() + ", null, null, "
			+ etudiant.getNoteSession1() + ", " + etudiant.getNoteSession2() + ")) "
			+ "WHERE codeMatiere = '" + ecue.getCodeMatiere() + "'");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void delete(ECUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }


    /**
     * La fonction, renvoie un POJO ECUE, a partir de l'id passé en parametre.<br>
     * Require : <br>
     * Ensure : <br>
     * @param id L'id de l'ecue,
     * @return L'ECUE correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public ECUE find(Object id) throws Exception {
	ECUE ecue = new ECUE();
	ArrayList<ECUE.EtudiantECUE> listeEtud;

	Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet result = s.executeQuery("SELECT codeMatiere, libelleECUE, nbHeures, idEnseignant,"
		+ "codeUE, numEtudiant, nom, prenom, noteSession1, noteSession2 from VO_Ecue e,"
		+ "TABLE(e.listeEtud) where codeMatiere = '" 
		+ (String) id + "'");
	if (result.first()) {            
	    ecue.setCodeMatiere(result.getString(1));
	    ecue.setLibelleECUE(result.getString(2));
	    ecue.setNbHeures(result.getInt(3));
	    ecue.setIdEnseignant(result.getInt(4));
	    ecue.setCodeUE(result.getString(5));

	    listeEtud = new ArrayList<ECUE.EtudiantECUE>();
	    do {                
		listeEtud.add(new EtudiantECUE(result.getInt(6),
			result.getString(7), result.getString(8), 
			result.getFloat(9), result.getFloat(10)));
	    } while (result.next());
	    ecue.setListeEtud(listeEtud);
	}
	return ecue;
    }

}

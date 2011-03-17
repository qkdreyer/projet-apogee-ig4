/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.BusinessLayer;

import fr.GCAM.StudentManager.POJO.Departement;
import fr.GCAM.StudentManager.POJO.Etape;
import java.util.ArrayList;

/**
 *
 * @author Jojo
 */
public class FacadeDepartement {

    Departement dpt;
    /*
     * L'on doit connaitre le departement et les années
     * dont l'utilisateur est responsable
     * Une fois sélectionné on redirige vers la fenetre d'etape correspondante
     */

    public String getNomDpt(){
        String nomd;
        nomd = this.dpt.getNomDepartement();
        return nomd;
    }

    public ArrayList getListeEtape(){
        ArrayList<Etape> listE;
        listE = this.dpt.getListeEtape();
        return listE;
    }

    /* conflict with quentin's version
     public FacadeEtape SelectEtape(Etape e){
        return FacadeEtape(e);
    }*/

}

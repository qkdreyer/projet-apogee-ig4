/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package POJO;

/**
 *
 * @author Quentin
 */
public class Utilisateur {

    public Utilisateur(String prenom, String nom, String password, String rights) {
	this.prenom = prenom;
	this.nom = nom;
	this.password = password;
	this.rights = rights;
    }

    private String prenom;
    private String nom;
    private String password;
    private String rights;

    public String getNom() {
	return nom;
    }

    public String getPassword() {
	return password;
    }

    public String getPrenom() {
	return prenom;
    }

    public String getRights() {
	return rights;
    }

}

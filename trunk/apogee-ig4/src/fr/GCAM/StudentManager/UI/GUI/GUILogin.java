/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Login.java
 *
 * Created on 18 févr. 2011, 18:36:56
 */
package fr.GCAM.StudentManager.UI.GUI;

import fr.GCAM.StudentManager.Business.Facade.FacadeUtilisateur;
import fr.GCAM.StudentManager.POJO.Utilisateur;
import fr.GCAM.StudentManager.UI.AbstractUIFactory;
import java.util.HashMap;
import javax.swing.JFrame;

/**
 *
 * @author pierre
 */
public class GUILogin extends GUI<Utilisateur> {

    private FacadeUtilisateur facadeUtilisateur;
    private String dao;

    /** Creates new form Login */
    public GUILogin(String dao) throws Exception {
	initComponents();
	this.dao = dao;
	facadeUtilisateur = new FacadeUtilisateur(dao);
        for (Utilisateur u : facadeUtilisateur.getListLogin()) {
            jComboBox1.addItem(u);
        }
        //jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(facadeUtilisateur.getListLogin()));
        setLocationRelativeTo(null);
	this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        identifiant = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        mdp = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GCAM StudentManager : Identification");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Identification"));

        jLabel1.setText("Identifiant");

        jLabel2.setText("Mot de passe");

        jButton1.setText("Connexion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onConnectionClick(evt);
            }
        });

        identifiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identifiantActionPerformed(evt);
            }
        });

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        mdp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mdpKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(mdp)
                            .addComponent(identifiant, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addComponent(errorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorLabel)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(mdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(identifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void identifiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identifiantActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_identifiantActionPerformed

    /**
     * Connecte l'utilisateur à la base de données, et fd
     */
    private void onConnectionClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onConnectionClick
	//if (identifiant.getText().split("\\.").length == 2) {

	    //identifier l'utilisateur, et récupère nouvelle fenêtre
	    HashMap<String, String> resp = facadeUtilisateur.login(identifiant.getText().split("\\.")[0],
                    identifiant.getText().split("\\.")[1], new String(mdp.getPassword()));
	    if (resp == null) {
		errorLabel.setText("Erreur d'identifiant ou de mot de passe");
	    } else {
		try {
		    this.setVisible(false);
		    if (resp.get("topResponsability").equals("root")) {
			((JFrame)AbstractUIFactory.getUIFactory("g").getUIAdmin(dao)).setDefaultCloseOperation(EXIT_ON_CLOSE);
		    } else  if (resp.get("topResponsability").equals("ECUE")) {
                        ((JFrame)AbstractUIFactory.getUIFactory("g").getUIECUE(dao, resp.get("codeResp"))).setDefaultCloseOperation(EXIT_ON_CLOSE);
		    } else if (resp.get("topResponsability").equals("UE")) {
			((JFrame)AbstractUIFactory.getUIFactory("g").getUIUE(dao, resp.get("codeResp"))).setDefaultCloseOperation(EXIT_ON_CLOSE);
		    } else if (resp.get("topResponsability").equals("Etape")) {
			((JFrame)AbstractUIFactory.getUIFactory("g").getUIEtape(dao, resp.get("codeResp"))).setDefaultCloseOperation(EXIT_ON_CLOSE);
		    } else if (resp.get("topResponsability").equals("Departement")) {
			((JFrame)AbstractUIFactory.getUIFactory("g").getUIDepartement(dao, resp.get("codeResp"))).setDefaultCloseOperation(EXIT_ON_CLOSE);
		    }
		} catch (Exception ex) {
		    System.err.println("Erreur : " + ex);
		    ex.printStackTrace();
		}
	    }
	/*} else {
	    errorLabel.setText("Utilisateur : prénom.nom");
	}*/
    }//GEN-LAST:event_onConnectionClick

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        identifiant.setText(jComboBox1.getSelectedItem().toString());
        mdp.requestFocusInWindow();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void mdpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mdpKeyReleased
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            onConnectionClick(null);
        }
    }//GEN-LAST:event_mdpKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JTextField identifiant;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField mdp;
    // End of variables declaration//GEN-END:variables
}

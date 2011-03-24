/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ManageEtape.java
 *
 * Created on 18 févr. 2011, 17:04:53
 */
package fr.GCAM.StudentManager.UI.GUI;

import fr.GCAM.StudentManager.Business.FacadeEtape;
import fr.GCAM.StudentManager.POJO.Etape;
import fr.GCAM.StudentManager.POJO.UE;
import fr.GCAM.StudentManager.UI.AbstractUIFactory;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pierre
 */
public class GUIEtape extends GUI<Etape> implements ActionListener {

    private FacadeEtape fetape;
    private String dao;

    /** Creates new form ManageEtape */
    public GUIEtape(String dao, String id) throws Exception {
        initComponents();
        this.dao = dao;
        fetape = new FacadeEtape(id, dao);

        nomResp.setText("Nom Responsable : " + fetape.getResponsable());
        versionEtape.setText("Version étape : " + fetape.getVersionEtape());
	codeEtape.setText("Code étape : " + fetape.getCodeEtape());
        codeSemestre1.setText(fetape.getCodeSemestre(1));
        codeSemestre2.setText(fetape.getCodeSemestre(2));
        libelleSemestre1.setText(fetape.getLibelleSemestre(1));
        libelleSemestre2.setText(fetape.getLibelleSemestre(2));
        
        listeEtudEtape.setModel(new ApogeeTableModel(
                new String[]{"Nom", "Prenom", "Moyenne", "PJ Année", "TOEIC"},
                fetape.getArrayOfEtudiantEtape()));

        listeEtudSem1.setModel(new ApogeeTableModel(
                new String[]{"Nom", "Prenom", "Moyenne", "PJ Sem"},
                fetape.getArrayOfEtudiantSemestre(1)));

        listeEtudSem2.setModel(new ApogeeTableModel(
                new String[]{"Nom", "Prenom", "Moyenne", "PJ Sem"},
                fetape.getArrayOfEtudiantSemestre(2)));

        listeEtudEtape.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                try {
                    if (listeEtudEtape.getSelectedColumn() == 3) {
                        fetape.setPJAnnee(listeEtudEtape.getSelectedRow(), Float.parseFloat(
                                listeEtudEtape.getValueAt(listeEtudEtape.getSelectedRow(),
                                listeEtudEtape.getSelectedColumn()).toString()));
                    } else if (listeEtudEtape.getSelectedColumn() == 4) {
                        fetape.setTOEIC(listeEtudEtape.getSelectedRow(), Integer.parseInt(
                                listeEtudEtape.getValueAt(listeEtudEtape.getSelectedRow(),
                                listeEtudEtape.getSelectedColumn()).toString()));
                    }
                } catch (Exception ex) {
                }
            }
        });

        listeEtudSem1.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                try {
                    if (listeEtudSem1.getSelectedColumn() == 3) {
                        fetape.setPJSem(1, listeEtudSem1.getSelectedRow(), Float.parseFloat(
                                listeEtudSem1.getValueAt(listeEtudSem1.getSelectedRow(),
                                listeEtudSem1.getSelectedColumn()).toString()));
                    }
                } catch (Exception ex) {
                    System.err.println("Erreur : " + ex);
                    ex.printStackTrace();
                }
            }
        });

        listeEtudSem2.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                try {
                    if (listeEtudSem2.getSelectedColumn() == 3) {
                        fetape.setPJSem(2, listeEtudSem2.getSelectedRow(), Float.parseFloat(
                                listeEtudSem2.getValueAt(listeEtudSem2.getSelectedRow(),
                                listeEtudSem2.getSelectedColumn()).toString()));
                    }
                } catch (Exception ex) {
                }
            }
        });

        JPanel ue, top, bot;
        JButton detail;
        for (UE e : fetape.getListeUE(1)) {
            ue = new JPanel();
	    ue.setLayout(new BoxLayout(ue, BoxLayout.Y_AXIS));
            ue.setBorder(javax.swing.BorderFactory.createTitledBorder(e.getCodeUE()));

            detail = new JButton("Détails...");
            detail.putClientProperty("id", e.getCodeUE());
            detail.addActionListener(this);

	    top = new JPanel(new GridLayout(2,1));
	    top.add(new JLabel(e.getLibelleUE()));
	    top.add(new JLabel(e.getResponsable()));
	    bot = new JPanel();
            bot.add(detail);
	    ue.add(top);
	    ue.add(bot);

            ueSemestre1.add(ue);
        }

        for (UE e : fetape.getListeUE(2)) {
            ue = new JPanel();
	    ue.setLayout(new BoxLayout(ue, BoxLayout.Y_AXIS));
            ue.setBorder(javax.swing.BorderFactory.createTitledBorder(e.getCodeUE()));

            detail = new JButton("Détails...");
            detail.putClientProperty("id", e.getCodeUE());
            detail.addActionListener(this);
	    ue.add(new JLabel(e.getLibelleUE()));
	    ue.add(new JLabel(e.getResponsable()));
            ue.add(detail);

            ueSemestre2.add(ue);
        }

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

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listeEtudEtape = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        versionEtape = new javax.swing.JLabel();
        nomResp = new javax.swing.JLabel();
        codeEtape = new javax.swing.JLabel();
        semestre = new javax.swing.JPanel();
        semestre1 = new javax.swing.JPanel();
        ueSemestre1 = new javax.swing.JPanel();
        infoSemestre1 = new javax.swing.JPanel();
        codeSemestre1 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        libelleSemestre1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeEtudSem1 = new javax.swing.JTable();
        semestre2 = new javax.swing.JPanel();
        ueSemestre2 = new javax.swing.JPanel();
        infoSemestre2 = new javax.swing.JPanel();
        codeSemestre2 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        libelleSemestre2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listeEtudSem2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GCAM StudentManager : Etape");
        setName("ListeEtudiant"); // NOI18N
        setResizable(false);

        listeEtudEtape.setDragEnabled(true);
        listeEtudEtape.setName("ListeEtudiants"); // NOI18N
        listeEtudEtape.getTableHeader().setResizingAllowed(false);
        listeEtudEtape.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(listeEtudEtape);

        jLabel11.setText("Année");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "4", "5" }));

        jLabel12.setText("Département : ");

        jTextField1.setEditable(false);
        jTextField1.setText("IG");
        jTextField1.setEnabled(false);

        versionEtape.setText("Version étape");

        nomResp.setText("Nom Enseignant");

        codeEtape.setText("Code étape");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomResp)
                    .addComponent(codeEtape)
                    .addComponent(versionEtape))
                .addContainerGap(318, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomResp)
                .addGap(18, 18, 18)
                .addComponent(codeEtape)
                .addGap(18, 18, 18)
                .addComponent(versionEtape)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        semestre1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Semestre 1"));
        semestre1.setPreferredSize(new java.awt.Dimension(599, 400));

        ueSemestre1.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste des UEs"));
        ueSemestre1.setPreferredSize(new java.awt.Dimension(400, 166));
        ueSemestre1.setLayout(new java.awt.GridLayout(0, 3));

        infoSemestre1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations"));

        jLabel56.setText("Code semestre :");

        jLabel57.setText("Libellé : ");

        javax.swing.GroupLayout infoSemestre1Layout = new javax.swing.GroupLayout(infoSemestre1);
        infoSemestre1.setLayout(infoSemestre1Layout);
        infoSemestre1Layout.setHorizontalGroup(
            infoSemestre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoSemestre1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addGroup(infoSemestre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoSemestre1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(codeSemestre1)
                        .addContainerGap(328, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoSemestre1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel57)
                        .addGap(14, 14, 14)
                        .addComponent(libelleSemestre1)
                        .addGap(122, 122, 122))))
        );
        infoSemestre1Layout.setVerticalGroup(
            infoSemestre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoSemestre1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoSemestre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(codeSemestre1)
                    .addComponent(jLabel57)
                    .addComponent(libelleSemestre1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(listeEtudSem1);

        javax.swing.GroupLayout semestre1Layout = new javax.swing.GroupLayout(semestre1);
        semestre1.setLayout(semestre1Layout);
        semestre1Layout.setHorizontalGroup(
            semestre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(semestre1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(semestre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ueSemestre1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addComponent(infoSemestre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        semestre1Layout.setVerticalGroup(
            semestre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(semestre1Layout.createSequentialGroup()
                .addGroup(semestre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(semestre1Layout.createSequentialGroup()
                        .addComponent(infoSemestre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ueSemestre1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addContainerGap())
        );

        ueSemestre1.getAccessibleContext().setAccessibleName("");

        semestre2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Semestre 2"));
        semestre2.setPreferredSize(new java.awt.Dimension(599, 400));

        ueSemestre2.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste des UEs"));
        ueSemestre2.setPreferredSize(new java.awt.Dimension(400, 166));
        ueSemestre2.setLayout(new java.awt.GridLayout(0, 3));

        infoSemestre2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations"));

        jLabel60.setText("Code semestre :");

        jLabel61.setText("Libellé : ");

        javax.swing.GroupLayout infoSemestre2Layout = new javax.swing.GroupLayout(infoSemestre2);
        infoSemestre2.setLayout(infoSemestre2Layout);
        infoSemestre2Layout.setHorizontalGroup(
            infoSemestre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoSemestre2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60)
                .addGroup(infoSemestre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoSemestre2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(codeSemestre2)
                        .addContainerGap(328, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoSemestre2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel61)
                        .addGap(14, 14, 14)
                        .addComponent(libelleSemestre2)
                        .addGap(127, 127, 127))))
        );
        infoSemestre2Layout.setVerticalGroup(
            infoSemestre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoSemestre2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoSemestre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(codeSemestre2)
                    .addComponent(jLabel61)
                    .addComponent(libelleSemestre2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(listeEtudSem2);

        javax.swing.GroupLayout semestre2Layout = new javax.swing.GroupLayout(semestre2);
        semestre2.setLayout(semestre2Layout);
        semestre2Layout.setHorizontalGroup(
            semestre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, semestre2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(semestre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(semestre2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoSemestre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(semestre2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ueSemestre2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)))
                .addContainerGap())
        );
        semestre2Layout.setVerticalGroup(
            semestre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(semestre2Layout.createSequentialGroup()
                .addGroup(semestre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, semestre2Layout.createSequentialGroup()
                        .addComponent(infoSemestre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ueSemestre2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout semestreLayout = new javax.swing.GroupLayout(semestre);
        semestre.setLayout(semestreLayout);
        semestreLayout.setHorizontalGroup(
            semestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(semestreLayout.createSequentialGroup()
                .addGroup(semestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(semestre1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semestre2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        semestreLayout.setVerticalGroup(
            semestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(semestreLayout.createSequentialGroup()
                .addComponent(semestre1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(semestre2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("Fichier");

        jMenuItem7.setText("jMenuItem7");
        jMenu1.add(jMenuItem7);

        jMenuItem5.setText("jMenuItem5");
        jMenu1.add(jMenuItem5);

        jMenuItem4.setText("jMenuItem4");
        jMenu1.add(jMenuItem4);

        jMenuItem3.setText("jMenuItem3");
        jMenu1.add(jMenuItem3);

        jMenuItem6.setText("jMenuItem6");
        jMenu1.add(jMenuItem6);

        jMenuItem1.setText("Quitter");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edition");

        jMenuItem2.setText("Preferences");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154)))
                .addGap(18, 18, 18)
                .addComponent(semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codeEtape;
    private javax.swing.JLabel codeSemestre1;
    private javax.swing.JLabel codeSemestre2;
    private javax.swing.JPanel infoSemestre1;
    private javax.swing.JPanel infoSemestre2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel libelleSemestre1;
    private javax.swing.JLabel libelleSemestre2;
    private javax.swing.JTable listeEtudEtape;
    private javax.swing.JTable listeEtudSem1;
    private javax.swing.JTable listeEtudSem2;
    private javax.swing.JLabel nomResp;
    private javax.swing.JPanel semestre;
    private javax.swing.JPanel semestre1;
    private javax.swing.JPanel semestre2;
    private javax.swing.JPanel ueSemestre1;
    private javax.swing.JPanel ueSemestre2;
    private javax.swing.JLabel versionEtape;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        try {
            AbstractUIFactory.getUIFactory("g").getUIUE(dao, ((JComponent) e.getSource()).getClientProperty("id").toString());
        } catch (Exception ex) {
        }
    }
}

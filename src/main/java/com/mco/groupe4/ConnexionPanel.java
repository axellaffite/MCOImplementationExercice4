package com.mco.groupe4;

import java.util.Random;

/**
 *
 * @author axel
 */
public class ConnexionPanel extends javax.swing.JFrame {
    
    private static String[] animals = {"Loutre", "Cheval", "Ornithorynque", "Poulpe", "Giraffe"};
    private static int n = 0;

    private Groupe groupe = new Groupe(new Historique(), new Analyse());
    
    
    public ConnexionPanel() {
        initComponents();
        genererNouveauPseudo();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        connexion = new javax.swing.JButton();
        pseudo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        connexion.setText("Se connecter");
        connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connexion, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(connexion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pseudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void connexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connexionActionPerformed
        String pseudoDeConnexion = pseudo.getText();
        genererNouveauPseudo();
        if (!pseudoDeConnexion.isBlank()) {
            new FenetreClient(groupe, pseudoDeConnexion).setVisible(true);
        }
    }//GEN-LAST:event_connexionActionPerformed

    
    private void genererNouveauPseudo() {
        pseudo.setText(animals[n] + " anonyme");
        n = (n + 1) % animals.length;
    }
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ConnexionPanel().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connexion;
    private javax.swing.JLabel pseudo;
    // End of variables declaration//GEN-END:variables
}

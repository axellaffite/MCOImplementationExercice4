package com.mco.groupe4;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


public class FenetreClient extends javax.swing.JFrame implements Membre {

    private static IDGenerator generator = new IDGenerator();
    
    private Integer id = generator.getNextID();
    
    private Groupe groupe;
    
    private String pseudo;
    
    
    public FenetreClient(Groupe groupe, String pseudo) {
        initComponents();
        
        messages.setLayout(new BoxLayout(messages, BoxLayout.Y_AXIS));
        
        this.groupe = groupe;
        this.pseudo = pseudo;
        
        setTitle(pseudo);
        
        groupe.ajouterMembre(this);
    }
    
    @Override
    public void traiterMessage(String message) {
        try {
            MessageForm form = new MessageForm(message);
        
            messages.add(form);
            messages.revalidate();
        } catch (ParseException ex) {
            Logger.getLogger(FenetreClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        pannelEdition = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        edition = new javax.swing.JTextArea();
        boutonPoster = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        messages = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jSplitPane1.setDividerLocation(299);
        jSplitPane1.setDoubleBuffered(true);
        jSplitPane1.setMinimumSize(new java.awt.Dimension(205, 100));
        jSplitPane1.setName(""); // NOI18N

        edition.setColumns(15);
        edition.setRows(5);
        edition.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        edition.setDoubleBuffered(true);
        jScrollPane1.setViewportView(edition);

        boutonPoster.setText("Poster le message");
        boutonPoster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonPosterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pannelEditionLayout = new javax.swing.GroupLayout(pannelEdition);
        pannelEdition.setLayout(pannelEditionLayout);
        pannelEditionLayout.setHorizontalGroup(
            pannelEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelEditionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boutonPoster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
                .addContainerGap())
        );
        pannelEditionLayout.setVerticalGroup(
            pannelEditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelEditionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boutonPoster, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(pannelEdition);

        javax.swing.GroupLayout messagesLayout = new javax.swing.GroupLayout(messages);
        messages.setLayout(messagesLayout);
        messagesLayout.setHorizontalGroup(
            messagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        messagesLayout.setVerticalGroup(
            messagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(messages);

        jSplitPane1.setLeftComponent(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonPosterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonPosterActionPerformed
        String messageAPoster = edition.getText();
        
        if (messageAPoster.isBlank()) {
            return;
        }
        
        groupe.posterMessage(signMessage(messageAPoster));
        
        edition.setText("");
    }//GEN-LAST:event_boutonPosterActionPerformed

    private String signMessage(String message) {
        JSONObject signedMessage = new JSONObject();
        signedMessage.put("pseudo", pseudo);
        signedMessage.put("date", new Date().getTime());
        signedMessage.put("message", message);
        
        return signedMessage.toJSONString();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonPoster;
    private javax.swing.JTextArea edition;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel messages;
    private javax.swing.JPanel pannelEdition;
    // End of variables declaration//GEN-END:variables

    @Override
    public int compareTo(Membre t) {
        if (t instanceof FenetreClient) {
            return id.compareTo(((FenetreClient) t).id);
        }
        
        return -1;
    }
    
    public boolean equals(Object other) {
        return other instanceof FenetreClient
                && ((FenetreClient) other).id.equals(id);
    }


    
}

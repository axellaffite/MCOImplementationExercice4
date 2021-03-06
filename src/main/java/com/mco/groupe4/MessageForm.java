package com.mco.groupe4;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class MessageForm extends javax.swing.JPanel {

    
    public MessageForm(String message) throws ParseException {
        initComponents();
        
        JSONObject msg = (JSONObject) new JSONParser().parse(message);
        this.message.setText((String) msg.get("message"));
        
        Date date = new Date((Long) msg.get("date"));
        this.date.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date));
        
        this.utilisateur.setText((String) msg.get("pseudo"));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        utilisateur = new javax.swing.JLabel();
        date = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        message.setText("Message");
        message.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        utilisateur.setText("Utilisateur");
        utilisateur.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        date.setText("Date");
        date.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(utilisateur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                        .addComponent(date)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utilisateur)
                    .addComponent(date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel message;
    private javax.swing.JLabel utilisateur;
    // End of variables declaration//GEN-END:variables
}

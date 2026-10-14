/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import Server.Server;
import java.net.*;
import java.io.*;
/**
 *
 * @author Katarina
 */
public class ServerForma extends javax.swing.JFrame {

    Server server;
    
    public ServerForma() {
        initComponents();
        server=new Server();
        jLabel2.setText("Server nije pokrenut");
        btnZaustaviServer.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPokreniServer = new javax.swing.JButton();
        btnZaustaviServer = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("STATUS :");

        jLabel2.setText("status");

        btnPokreniServer.setText("Pokreni server");
        btnPokreniServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniServerActionPerformed(evt);
            }
        });

        btnZaustaviServer.setText("Zaustavi server");
        btnZaustaviServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZaustaviServerActionPerformed(evt);
            }
        });

        jMenu1.setText("Konfiguracija");

        jMenuItem1.setText("Baza");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Port");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnPokreniServer)
                        .addGap(84, 84, 84)
                        .addComponent(btnZaustaviServer)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPokreniServer)
                    .addComponent(btnZaustaviServer))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPokreniServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniServerActionPerformed
        if (server == null || !server.isAlive()) {
            server = new Server();
            server.start();
            System.out.println("Server pokrenut.");
        } else {
            System.out.println("Server je već pokrenut.");
        }
            jLabel2.setText("Pokrenut server");
            btnPokreniServer.setEnabled(false);
            btnZaustaviServer.setEnabled(true);
    }//GEN-LAST:event_btnPokreniServerActionPerformed

    private void btnZaustaviServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZaustaviServerActionPerformed
        server.zaustaviServer();
        jLabel2.setText("Zaustavljen server");
        btnZaustaviServer.setEnabled(false);
        btnPokreniServer.setEnabled(true);
    }//GEN-LAST:event_btnZaustaviServerActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Konfig_Baza kb=new Konfig_Baza();
        kb.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Konfig_Port kp=new Konfig_Port();
        kp.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPokreniServer;
    private javax.swing.JButton btnZaustaviServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}

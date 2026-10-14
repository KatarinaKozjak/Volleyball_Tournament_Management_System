/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import javax.swing.JTextField;

/**
 *
 * @author Katarina
 */
public class GlavnaForma extends javax.swing.JFrame {

    
    public GlavnaForma() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        meni = new javax.swing.JMenuBar();
        zapisnikMeni = new javax.swing.JMenu();
        kreirajZapisnik = new javax.swing.JMenuItem();
        pretraziZapisnike = new javax.swing.JMenuItem();
        promeniZapisnik = new javax.swing.JMenuItem();
        analiticarMeni = new javax.swing.JMenu();
        delegatMeni = new javax.swing.JMenu();
        igracMeni = new javax.swing.JMenu();
        mestoMeni = new javax.swing.JMenu();
        timMeni = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Dobrodosli :");

        txtIme.setEditable(false);

        txtPrezime.setEditable(false);

        zapisnikMeni.setText("Zapisnik");
        zapisnikMeni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zapisnikMeniMouseClicked(evt);
            }
        });

        kreirajZapisnik.setText("KreirajZapisnik");
        kreirajZapisnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kreirajZapisnikActionPerformed(evt);
            }
        });
        zapisnikMeni.add(kreirajZapisnik);

        pretraziZapisnike.setText("PretraziZapisnike");
        pretraziZapisnike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pretraziZapisnikeActionPerformed(evt);
            }
        });
        zapisnikMeni.add(pretraziZapisnike);

        promeniZapisnik.setText("PromeniZapisnik");
        promeniZapisnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promeniZapisnikActionPerformed(evt);
            }
        });
        zapisnikMeni.add(promeniZapisnik);

        meni.add(zapisnikMeni);

        analiticarMeni.setText("Analiticar");
        analiticarMeni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                analiticarMeniMouseClicked(evt);
            }
        });
        meni.add(analiticarMeni);

        delegatMeni.setText("Delegat");
        delegatMeni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delegatMeniMouseClicked(evt);
            }
        });
        meni.add(delegatMeni);

        igracMeni.setText("Igrac");
        igracMeni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                igracMeniMouseClicked(evt);
            }
        });
        meni.add(igracMeni);

        mestoMeni.setText("Mesto");
        mestoMeni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mestoMeniMouseClicked(evt);
            }
        });
        meni.add(mestoMeni);

        timMeni.setText("Tim");
        timMeni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timMeniMouseClicked(evt);
            }
        });
        meni.add(timMeni);

        setJMenuBar(meni);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zapisnikMeniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zapisnikMeniMouseClicked
        //kordinatorFormi.Kordinator.getInstance().otvoriKreiranjeZapisnikaF();
    }//GEN-LAST:event_zapisnikMeniMouseClicked

    private void analiticarMeniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_analiticarMeniMouseClicked
        kordinatorFormi.Kordinator.getInstance().otvoriPretragaAnaliticaraF();
    }//GEN-LAST:event_analiticarMeniMouseClicked

    private void delegatMeniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delegatMeniMouseClicked
        kordinatorFormi.Kordinator.getInstance().otvoriBrisanjeDelegataF();
    }//GEN-LAST:event_delegatMeniMouseClicked

    private void timMeniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timMeniMouseClicked
        kordinatorFormi.Kordinator.getInstance().otvoriKreirajTimF();
    }//GEN-LAST:event_timMeniMouseClicked

    private void igracMeniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igracMeniMouseClicked
        kordinatorFormi.Kordinator.getInstance().otvoriUbacivanjeIgracaF();
    }//GEN-LAST:event_igracMeniMouseClicked

    private void mestoMeniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mestoMeniMouseClicked
        kordinatorFormi.Kordinator.getInstance().otvoriKreirajMestoF();
    }//GEN-LAST:event_mestoMeniMouseClicked

    private void kreirajZapisnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kreirajZapisnikActionPerformed
        kordinatorFormi.Kordinator.getInstance().otvoriKreiranjeZapisnikaF();
    }//GEN-LAST:event_kreirajZapisnikActionPerformed

    private void pretraziZapisnikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pretraziZapisnikeActionPerformed
        kordinatorFormi.Kordinator.getInstance().otvoriPretragaZapisnikaF();
    }//GEN-LAST:event_pretraziZapisnikeActionPerformed

    private void promeniZapisnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promeniZapisnikActionPerformed
        kordinatorFormi.Kordinator.getInstance().otvoriPromenaZapisnikaF();
    }//GEN-LAST:event_promeniZapisnikActionPerformed

    
    public JTextField getTxtIme() {
        return txtIme;
    }

    public void setTxtIme(JTextField txt) {
        this.txtIme = txt;
    }
     public JTextField getTxtPrezime() {
        return txtPrezime;
    }

    public void setTxtPrezime(JTextField txt) {
        this.txtPrezime = txt;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu analiticarMeni;
    private javax.swing.JMenu delegatMeni;
    private javax.swing.JMenu igracMeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem kreirajZapisnik;
    private javax.swing.JMenuBar meni;
    private javax.swing.JMenu mestoMeni;
    private javax.swing.JMenuItem pretraziZapisnike;
    private javax.swing.JMenuItem promeniZapisnik;
    private javax.swing.JMenu timMeni;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JMenu zapisnikMeni;
    // End of variables declaration//GEN-END:variables
}

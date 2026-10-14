/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import modeli.Mesto;
/**
 *
 * @author Katarina
 */
public class BrisanjeDelegataForma extends javax.swing.JFrame {

    
    public BrisanjeDelegataForma() {
        initComponents();
        /*btnObrisi.setEnabled(false);
        btnPotvrdi.setEnabled(false);*/
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIDDelegat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbMesto = new javax.swing.JComboBox<>();
        btnPretrazi = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnPotvrdi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDelegati = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Id Delegata");

        jLabel2.setText("Ime");

        jLabel3.setText("Prezime");

        jLabel4.setText("Mesto");

        cbMesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMestoItemStateChanged(evt);
            }
        });
        cbMesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMestoActionPerformed(evt);
            }
        });

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnPotvrdi.setText("Potvrdi");
        btnPotvrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPotvrdiActionPerformed(evt);
            }
        });

        tableDelegati.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDelegatiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDelegati);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDDelegat)
                            .addComponent(txtIme)
                            .addComponent(txtPrezime)
                            .addComponent(cbMesto, 0, 113, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addComponent(btnPretrazi)
                        .addContainerGap(414, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPotvrdi)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi)
                        .addGap(18, 18, 18))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDDelegat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cbMesto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObrisi)
                    .addComponent(btnPotvrdi))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnPotvrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPotvrdiActionPerformed
        
    }//GEN-LAST:event_btnPotvrdiActionPerformed

    private void tableDelegatiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDelegatiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableDelegatiMouseClicked

    private void cbMestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMestoActionPerformed

    private void cbMestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMestoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMestoItemStateChanged

   
    public void setCBMesta(JComboBox<Mesto> cb){
        this.cbMesto=cb;
    }
    
    public JComboBox<Mesto> getCBMesto(){
        return cbMesto;
    }
    
    public JTable getTableDelegati(){
        return tableDelegati;
    }
    
    public void setTableDelegati(JTable table){
        this.tableDelegati=table;
    }
    
    public JTextField getTxtId() {
        return txtIDDelegat;
    }

    public void setjTxtId(JTextField txt) {
        this.txtIDDelegat = txt;
    }

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
    
    public JButton getBtnObrisi() {
        return btnObrisi;
    }

    public void setBtnObrisi(JButton btn) {
        this.btnObrisi = btn;
    }
    
    public JButton getBtnPretrazi() {
        return btnPretrazi;
    }

    public void setBtnPretrazi(JButton btn) {
        this.btnPretrazi = btn;
    }
    
    public JButton getBtnPotvrdi() {
        return btnPotvrdi;
    }

    public void setBtnPotvrdi(JButton btn) {
        this.btnPotvrdi = btn;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPotvrdi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JComboBox<Mesto> cbMesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDelegati;
    private javax.swing.JTextField txtIDDelegat;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    public void addCBMestoActionListener(ActionListener actionListener){
        cbMesto.addActionListener(actionListener);
    }
    
    public void pretraziDelegateActionListener(ActionListener actionListener) {
      btnPretrazi.addActionListener(actionListener);
    }
    
    public void potvrdiDelegataActionListener(ActionListener actionListener) {
      btnPotvrdi.addActionListener(actionListener);
    }
    
    public void obrisiDelegataActionListener(ActionListener actionListener) {
      btnObrisi.addActionListener(actionListener);
    }
    
}

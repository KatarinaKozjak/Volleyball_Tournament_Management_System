/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import modeli.Analiticar;
import modeli.Delegat;
import modeli.SStavkaZapisnika;
import modeli.StavkaZapisnika;
import modeli.Zapisnik;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;


/**
 *
 * @author Katarina
 */
public class PromenaZapisnika extends javax.swing.JFrame {

    public PromenaZapisnika() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDatumOd = new javax.swing.JTextField();
        txtDatumDo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxAnaliticar = new javax.swing.JComboBox<>();
        cbxDelegat = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelStavkeZapisnika = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelZapisnici = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelSStavkeZapisnika = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnOdaberiZapisnik = new javax.swing.JButton();
        btnZapamtiIzmene = new javax.swing.JButton();
        btnOdaberiStavkuZapisnika = new javax.swing.JButton();
        btnOdaberiSStavkuZapisnika = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Datum od (yyyy-mm-dd):");

        jLabel2.setText("Datum do (yyyy-mm-dd):");

        txtDatumOd.setToolTipText("");
        txtDatumOd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatumOdActionPerformed(evt);
            }
        });

        jLabel3.setText("Analiticar :");

        jLabel4.setText("Delegat :");

        btnFilter.setText("Filtriraj");

        jScrollPane1.setViewportView(tabelStavkeZapisnika);

        jScrollPane2.setViewportView(tabelZapisnici);

        jLabel5.setText("Zapisnici");

        jLabel6.setText("Stavke zapisnika");

        jScrollPane3.setViewportView(tabelSStavkeZapisnika);

        jLabel7.setText("SStavke zapisnika");

        btnOdaberiZapisnik.setText("Odaberi zapisnik");
        btnOdaberiZapisnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaberiZapisnikActionPerformed(evt);
            }
        });

        btnZapamtiIzmene.setText("Sacuvaj sve izmene");

        btnOdaberiStavkuZapisnika.setText("Odaberi stavku zapisnika");
        btnOdaberiStavkuZapisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaberiStavkuZapisnikaActionPerformed(evt);
            }
        });

        btnOdaberiSStavkuZapisnika.setText("Odaberi sstavku zapisnika");
        btnOdaberiSStavkuZapisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaberiSStavkuZapisnikaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel3))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxAnaliticar, 0, 150, Short.MAX_VALUE)
                            .addComponent(cbxDelegat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(692, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOdaberiStavkuZapisnika)
                            .addComponent(btnOdaberiSStavkuZapisnika)
                            .addComponent(btnZapamtiIzmene, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 647, Short.MAX_VALUE)
                .addComponent(btnOdaberiZapisnik)
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(196, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbxAnaliticar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbxDelegat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFilter)
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(71, 71, 71)
                .addComponent(btnOdaberiZapisnik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnOdaberiStavkuZapisnika)))
                .addGap(44, 44, 44)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOdaberiSStavkuZapisnika)
                        .addGap(88, 88, 88)
                        .addComponent(btnZapamtiIzmene)
                        .addGap(14, 14, 14))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(165, 165, 165)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(484, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDatumOdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatumOdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatumOdActionPerformed

    private void btnOdaberiZapisnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaberiZapisnikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOdaberiZapisnikActionPerformed

    private void btnOdaberiStavkuZapisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaberiStavkuZapisnikaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOdaberiStavkuZapisnikaActionPerformed

    private void btnOdaberiSStavkuZapisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaberiSStavkuZapisnikaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOdaberiSStavkuZapisnikaActionPerformed

    
    //-------------------------------Tabele--------------------------------
    public JTable getTabelaZapisnici(){
        return tabelZapisnici;
    }
    
    public void setTableZapisnici(JTable tabela){
        this.tabelZapisnici = tabela;
    }
    
    public JTable getTabelaStavkaZapisnika(){
        return tabelStavkeZapisnika;
    }
    
    public void setTableStavkaZapisnika(JTable tabela){
        this.tabelStavkeZapisnika = tabela;
    }
    
    public JTable getTabelaSStavkaZapisnika(){
        return tabelSStavkeZapisnika;
    }
    
    public void setTableSStavkaZapisnika(JTable tabela){
        this.tabelSStavkeZapisnika = tabela;
    }
    
    //-------------------------------Dugmici-----------------------------------------------
    
    public JButton getBtnFilteri() {
        return btnFilter;
    }

    public void setBtnFilteri(JButton btn) {
        this.btnFilter = btn;
    }
    
    public JButton getBtnOdaberiZapisnik() {
        return btnOdaberiZapisnik;
    }

    public void setBtnOdaberiZapisnik(JButton btn) {
        this.btnOdaberiZapisnik = btn;
    }
    
    public JButton getBtnZapamtiIzmene() {
        return btnZapamtiIzmene;
    }

    public void setBtnZapamtiIzmene(JButton btn) {
        this.btnZapamtiIzmene = btn;
    }
    
    public JButton getBtnOdaberiStavkuZapisnika() {
        return btnOdaberiStavkuZapisnika;
    }

    public void setBtnOdaberiStavkuZapisnika(JButton btn) {
        this.btnOdaberiStavkuZapisnika = btn;
    }
    
    public JButton getBtnOdaberiSStavkuZapisnika() {
        return btnOdaberiSStavkuZapisnika;
    }

    public void setBtnOdaberiSStavkuZapisnika(JButton btn) {
        this.btnOdaberiSStavkuZapisnika = btn;
    }
    
    //--------------------------------Polja---------------------------------------------------
    
    public JTextField getTxtDatumOd() {
        return txtDatumOd;
    }

    public void setDatumOd(JTextField txtField) {
        this.txtDatumOd = txtField;
    }
    
    public JTextField getTxtDatumDo() {
        return txtDatumDo;
    }

    public void setDatumDo(JTextField txtField) {
        this.txtDatumOd = txtField;
    }
    
    //-----------------------------------------------Padajuce liste-------------------------------------
    
    public void setCBAnaliticar(JComboBox<Analiticar> cb){
        this.cbxAnaliticar=cb;
    }
    
    public JComboBox<Analiticar> getCBAnaliticar(){
        return cbxAnaliticar;
    }
    
    public void setCBDelegat(JComboBox<Delegat> cb){
        this.cbxDelegat=cb;
    }
    
    public JComboBox<Delegat> getCBDelegat(){
        return cbxDelegat;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnOdaberiSStavkuZapisnika;
    private javax.swing.JButton btnOdaberiStavkuZapisnika;
    private javax.swing.JButton btnOdaberiZapisnik;
    private javax.swing.JButton btnZapamtiIzmene;
    private javax.swing.JComboBox<Analiticar> cbxAnaliticar;
    private javax.swing.JComboBox<Delegat> cbxDelegat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelSStavkeZapisnika;
    private javax.swing.JTable tabelStavkeZapisnika;
    private javax.swing.JTable tabelZapisnici;
    private javax.swing.JTextField txtDatumDo;
    private javax.swing.JTextField txtDatumOd;
    // End of variables declaration//GEN-END:variables


    public void filtrirajZapisnike(ActionListener actionListener) {
        btnFilter.addActionListener(actionListener);
    }
    
    public void odaberiSelektovanZapisnik(ActionListener actionListener) {
        btnOdaberiZapisnik.addActionListener(actionListener);
    }
    
    public void odaberiSelektovanuStavkuZapisnika(ActionListener actionListener) {
        btnOdaberiStavkuZapisnika.addActionListener(actionListener);
    }
    
    public void odaberiSelektovanuSStavkuZapisnika(ActionListener actionListener) {
        btnOdaberiSStavkuZapisnika.addActionListener(actionListener);
    }
    
    public void zapamtiIzmene(ActionListener actionListener) {
        btnZapamtiIzmene.addActionListener(actionListener);
    }

}

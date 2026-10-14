/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import modeli.Analiticar;
import modeli.Delegat;
import modeli.SStavkaZapisnika;
import modeli.StavkaZapisnika;
import modeli.Tim;
import modeli.Zapisnik;
/**
 *
 * @author Katarina
 */
public class PregledZapisnika extends javax.swing.JFrame {

    
    public PregledZapisnika() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDatumOd = new javax.swing.JTextField();
        txtDatumDo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableZapisnici = new javax.swing.JTable();
        btnDetaljiZapisnika = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableStavke = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnPretraziZapisnike = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnDetaljiStavke = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSStavke = new javax.swing.JTable();
        cbAnaliticar = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbDelegat = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbTim = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Datum od (yyyy-mm-dd):");

        jLabel2.setText("Datum do (yyyy-mm-dd):");

        txtDatumOd.setToolTipText("");

        jScrollPane1.setViewportView(tableZapisnici);

        btnDetaljiZapisnika.setText("Prikazi detalje za zapisnik");
        btnDetaljiZapisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiZapisnikaActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(tableStavke);

        jLabel3.setText("Stavke zapisnika :");

        btnPretraziZapisnike.setText("Pretrazi zapisnike");
        btnPretraziZapisnike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziZapisnikeActionPerformed(evt);
            }
        });

        jLabel4.setText("SStavke zapisnika :");

        btnDetaljiStavke.setText("Prikazi detalje za stavku");
        btnDetaljiStavke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiStavkeActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(tableSStavke);

        cbAnaliticar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAnaliticarActionPerformed(evt);
            }
        });

        jLabel5.setText("Analiticar");

        jLabel6.setText("Delegat");

        jLabel7.setText("Tim");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(btnDetaljiZapisnika, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel4)
                            .addComponent(btnDetaljiStavke, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(26, 26, 26)
                                .addComponent(cbDelegat, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cbAnaliticar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cbTim, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                                .addComponent(btnPretraziZapisnike, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbAnaliticar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(cbDelegat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPretraziZapisnike)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDetaljiZapisnika)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDetaljiStavke)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetaljiZapisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiZapisnikaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetaljiZapisnikaActionPerformed

    private void btnPretraziZapisnikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziZapisnikeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPretraziZapisnikeActionPerformed

    private void btnDetaljiStavkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiStavkeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetaljiStavkeActionPerformed

    private void cbAnaliticarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnaliticarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAnaliticarActionPerformed

    //------------------------------------Tabele--------------------------------------
    public JTable getTableZapisnici() {
        return tableZapisnici;
    }

    public void setTableZapisnici(JTable table) {
        this.tableZapisnici = table;
    }
    
    public JTable getTableStavke() {
        return tableStavke;
    }

    public void setTableStavke(JTable table) {
        this.tableStavke = table;
    }
    
    public JTable getTableSStavke() {
        return tableSStavke;
    }

    public void setTableSStavke(JTable table) {
        this.tableSStavke = table;
    }
    
    //-----------------------------Dugmici----------------------------------------------
    public JButton getBtnDetaljiZapisnika() {
        return btnDetaljiZapisnika;
    }

    public void setBtnDetaljiZapisnika(JButton btn) {
        this.btnDetaljiZapisnika = btn;
    }
    
    public JButton getBtnPretraziZapisnike() {
        return btnPretraziZapisnike;
    }

    public void setBtnPretraziZapisnike(JButton btn) {
        this.btnPretraziZapisnike = btn;
    }
    
    public JButton getBtnDetaljiStavke() {
        return btnDetaljiStavke;
    }

    public void setBtnDetaljiStavke(JButton btn) {
        this.btnDetaljiStavke = btn;
    }
    
    //----------------------------Polja------------------------------------------
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
    
    //-------------------------Padajuce liste-----------------------------------------
    
    public void setCBAnaliticar(JComboBox<Analiticar> cb){
        this.cbAnaliticar=cb;
    }
    
    public JComboBox<Analiticar> getCBAnaliticar(){
        return cbAnaliticar;
    }
    
    public void setCBDelegat(JComboBox<Delegat> cb){
        this.cbDelegat=cb;
    }
    
    public JComboBox<Delegat> getCBDelegat(){
        return cbDelegat;
    }
    
    public void setCBTim(JComboBox<Tim> cb){
        this.cbTim=cb;
    }
    
    public JComboBox<Tim> getCBTim(){
        return cbTim;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetaljiStavke;
    private javax.swing.JButton btnDetaljiZapisnika;
    private javax.swing.JButton btnPretraziZapisnike;
    private javax.swing.JComboBox<Analiticar> cbAnaliticar;
    private javax.swing.JComboBox<Delegat> cbDelegat;
    private javax.swing.JComboBox<Tim> cbTim;
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
    private javax.swing.JTable tableSStavke;
    private javax.swing.JTable tableStavke;
    private javax.swing.JTable tableZapisnici;
    private javax.swing.JTextField txtDatumDo;
    private javax.swing.JTextField txtDatumOd;
    // End of variables declaration//GEN-END:variables

    
    public void prikaziDetaljeZapisnika(ActionListener actionListener) {
        btnDetaljiZapisnika.addActionListener(actionListener);
    }
    
    public void pretraziZapisnikePoKriterijumima(ActionListener actionListener) {
        btnPretraziZapisnike.addActionListener(actionListener);
    }
    
    public void prikaziDetaljeStavke(ActionListener actionListener) {
        btnDetaljiStavke.addActionListener(actionListener);
    }

}

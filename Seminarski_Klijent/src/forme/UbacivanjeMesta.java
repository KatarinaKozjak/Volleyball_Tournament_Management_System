/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Katarina
 */
public class UbacivanjeMesta extends javax.swing.JFrame {

    
    public UbacivanjeMesta() {
        initComponents();
        btnZapamti.setEnabled(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBrS = new javax.swing.JTextField();
        btnZapamti = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMesta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv :");

        jLabel2.setText("Broj stanovnika : ");

        btnZapamti.setText("UBACI MESTO");
        btnZapamti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZapamtiActionPerformed(evt);
            }
        });

        tableMesta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableMesta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtBrS, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(btnZapamti))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBrS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZapamti))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZapamtiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZapamtiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnZapamtiActionPerformed

    public JTextField getTxtNaziv() {
        return txtNaziv;
    }

    public void setTxtNaziv(JTextField txt) {
        this.txtNaziv = txt;
    }
    
    public JTextField getTxtBrS() {
        return txtBrS;
    }

    public void setTxtBrS(JTextField txt) {
        this.txtBrS = txt;
    }
    
    public JTable getTableMesta() {
        return tableMesta;
    }

    public void setTableMesta(JTable table) {
        this.tableMesta = table;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnZapamti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMesta;
    private javax.swing.JTextField txtBrS;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    /*public void BtnKreirajMestoActionListener(ActionListener actionListener) {
        btnKreiraj.addActionListener(actionListener);
    }*/
    
    public void BtnZapamtiMestoActionListener(ActionListener actionListener) {
        btnZapamti.addActionListener(actionListener);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import javax.swing.JOptionPane;

/**
 *
 * @author Katarina
 */
public class Konfig_Port extends javax.swing.JFrame {

    
    public Konfig_Port() {
        initComponents();
        txtPort.setText("3306");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btnSacuvajPort = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Broj porta :");

        btnSacuvajPort.setText("Sacuvaj");
        btnSacuvajPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajPortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSacuvajPort)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(btnSacuvajPort)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajPortActionPerformed
        int port=-1;
        try {
            port=Integer.parseInt(txtPort.getText());
            if(port>=0 && port<=9525){
            konfiguracija.Konfiguracija.getInstance().setProperty("port", port+"");
            JOptionPane.showMessageDialog(this, "Uspesno ste sačuvali broj porta.","USPEH",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Greška, uneli ste neispravan broj porta.","GRESKA",JOptionPane.ERROR_MESSAGE);
        }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Greška, dozvoljeno je da unesete samo broj.","GRESKA",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajPortActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvajPort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import modeli.Analiticar;
import modeli.Delegat;
import modeli.Igrac;
import modeli.StavkaZapisnika;
import modeli.Tim;

/**
 *
 * @author Katarina
 */
public class UbacivanjeZapisnika extends javax.swing.JFrame {

    
    public UbacivanjeZapisnika() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDatumPocetka = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDatumZavrsetka = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBrGrupa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbDelegati = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableZapisnici = new javax.swing.JTable();
        btnKreirajZapisnik = new javax.swing.JButton();
        btnZapamtiZapisnik = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbAnaliticari = new javax.swing.JComboBox<>();
        panelStavka = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbTimovi = new javax.swing.JComboBox<>();
        btnUbaciSStavke = new javax.swing.JButton();
        btnDodajStavkuUTabelu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableStavkeZapisnika = new javax.swing.JTable();
        btnUbaciStavke = new javax.swing.JButton();
        panelSStavka = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbIgraci = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtPoeniIzBloka = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPoeniSaServisa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPoeniIzIgre = new javax.swing.JTextField();
        btnDodajSStavkeUTabelu = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSStavkeZapisnika = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("DATUM POCETKA TURNIRA (yyyy-mm-dd):");

        txtDatumPocetka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatumPocetkaActionPerformed(evt);
            }
        });

        jLabel2.setText("DATUM ZAVRSETKA TURNIRA (yyyy-mm-dd): ");

        txtDatumZavrsetka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatumZavrsetkaActionPerformed(evt);
            }
        });

        jLabel3.setText("BROJ GRUPA NA TURNIRU :");

        txtBrGrupa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrGrupaActionPerformed(evt);
            }
        });

        jLabel4.setText("Izaberite Delegata");

        jScrollPane1.setViewportView(tableZapisnici);

        btnKreirajZapisnik.setText("UBACI ZAPISNIK");
        btnKreirajZapisnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajZapisnikActionPerformed(evt);
            }
        });

        btnZapamtiZapisnik.setText("ZAPAMTI ZAPISNIK");
        btnZapamtiZapisnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZapamtiZapisnikActionPerformed(evt);
            }
        });

        jLabel5.setText("Izaberite Analiticara");

        panelStavka.setBackground(new java.awt.Color(255, 255, 255));
        panelStavka.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Stavka zapisnika");

        jLabel7.setText("Izaberi Tim :");

        btnUbaciSStavke.setText("DODAJ SSTAVKE");
        btnUbaciSStavke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbaciSStavkeActionPerformed(evt);
            }
        });

        btnDodajStavkuUTabelu.setText("DODAJ NOVU STAVKU");

        jScrollPane2.setViewportView(tableStavkeZapisnika);

        javax.swing.GroupLayout panelStavkaLayout = new javax.swing.GroupLayout(panelStavka);
        panelStavka.setLayout(panelStavkaLayout);
        panelStavkaLayout.setHorizontalGroup(
            panelStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStavkaLayout.createSequentialGroup()
                .addGroup(panelStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStavkaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUbaciSStavke, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelStavkaLayout.createSequentialGroup()
                        .addGroup(panelStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelStavkaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(panelStavkaLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbTimovi, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnDodajStavkuUTabelu, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelStavkaLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 106, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelStavkaLayout.setVerticalGroup(
            panelStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStavkaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(panelStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbTimovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodajStavkuUTabelu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUbaciSStavke)
                .addContainerGap())
        );

        btnUbaciStavke.setText("DODAJ STAVKE");
        btnUbaciStavke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbaciStavkeActionPerformed(evt);
            }
        });

        panelSStavka.setBackground(new java.awt.Color(255, 255, 255));
        panelSStavka.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("SStavka zapisnika");

        jLabel9.setText("Izaberi igraca iz tima : ");

        jLabel11.setText("Poeni iz bloka : ");

        jLabel12.setText("Poeni sa servisa :");

        jLabel13.setText("Poeni iz igre :");

        btnDodajSStavkeUTabelu.setText("DODAJ NOVU SSTAVKU");
        btnDodajSStavkeUTabelu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajSStavkeUTabeluActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(tableSStavkeZapisnika);

        javax.swing.GroupLayout panelSStavkaLayout = new javax.swing.GroupLayout(panelSStavka);
        panelSStavka.setLayout(panelSStavkaLayout);
        panelSStavkaLayout.setHorizontalGroup(
            panelSStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSStavkaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(panelSStavkaLayout.createSequentialGroup()
                        .addGroup(panelSStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelSStavkaLayout.createSequentialGroup()
                                .addGroup(panelSStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDodajSStavkeUTabelu, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelSStavkaLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPoeniIzIgre, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelSStavkaLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPoeniIzBloka, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelSStavkaLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPoeniSaServisa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(65, 65, 65))
                            .addGroup(panelSStavkaLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbIgraci, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelSStavkaLayout.setVerticalGroup(
            panelSStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSStavkaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGroup(panelSStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSStavkaLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(panelSStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbIgraci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(panelSStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPoeniIzBloka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelSStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtPoeniSaServisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelSStavkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtPoeniIzIgre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addComponent(btnDodajSStavkeUTabelu)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSStavkaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnZapamtiZapisnik, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(29, 29, 29)
                                            .addComponent(txtBrGrupa))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(btnKreirajZapisnik)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(btnUbaciStavke, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtDatumZavrsetka, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGap(55, 55, 55)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbAnaliticari, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(28, 28, 28)
                                    .addComponent(cbDelegati, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(133, 133, 133))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelStavka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelSStavka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbDelegati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatumZavrsetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbAnaliticari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBrGrupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKreirajZapisnik)
                    .addComponent(btnUbaciStavke))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelStavka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelSStavka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnZapamtiZapisnik)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKreirajZapisnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajZapisnikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKreirajZapisnikActionPerformed

    private void btnZapamtiZapisnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZapamtiZapisnikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnZapamtiZapisnikActionPerformed

    private void txtDatumPocetkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatumPocetkaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatumPocetkaActionPerformed

    private void txtDatumZavrsetkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatumZavrsetkaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatumZavrsetkaActionPerformed

    private void txtBrGrupaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrGrupaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBrGrupaActionPerformed

    private void btnUbaciStavkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbaciStavkeActionPerformed
        //panelStavka.setVisible(true);
        //postaviListener();
        //btnUbaciSStavke.setEnabled(false);
    }//GEN-LAST:event_btnUbaciStavkeActionPerformed

    private void btnUbaciSStavkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbaciSStavkeActionPerformed
        //panelSStavka.setVisible(true);
    }//GEN-LAST:event_btnUbaciSStavkeActionPerformed

    private void btnDodajSStavkeUTabeluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajSStavkeUTabeluActionPerformed
        
    }//GEN-LAST:event_btnDodajSStavkeUTabeluActionPerformed

    ////////////////////////////Lista delegata/////////////////////////////////////////////
    public void setCBDelegati(JComboBox<Delegat> CBDelegati) {
        this.cbDelegati = CBDelegati;
    }
    public JComboBox<Delegat> getCBDelegati() {
        return cbDelegati;
    }
    
    public void CBDelegatiActionListener(ActionListener actionListener) {
        cbDelegati.addActionListener(actionListener);
    }
    
    ////////////////////////////Lista timova ///////////////////////////////////////
    public void setCBTimovi(JComboBox<Tim> CBTimovi) {
        this.cbTimovi = CBTimovi;
    }
    public JComboBox<Tim> getCBTimovi() {
        return cbTimovi;
    }
    
    public void CBTimoviActionListener(ActionListener actionListener) {
        cbTimovi.addActionListener(actionListener);
    }
    
    /////////////////////////Lista igraca //////////////////////////////////////////////
    public void setCBIgraci(JComboBox<Igrac> CBIgraci) {
        this.cbIgraci = CBIgraci;
    }
    public JComboBox<Igrac> getCBIgraci() {
        return cbIgraci;
    }
    
    public void CBIgraciActionListener(ActionListener actionListener) {
        cbIgraci.addActionListener(actionListener);
    }
    
    ////////////////////////////Lista analiticara/////////////////////////////////////////////
    public void setCBAnaliticari(JComboBox<Analiticar> CBAnaliticari) {
        this.cbAnaliticari = CBAnaliticari;
    }
    public JComboBox<Analiticar> getCBAnaliticari() {
        return cbAnaliticari;
    }
    
    public void CBAnaliticariActionListener(ActionListener actionListener) {
        cbAnaliticari.addActionListener(actionListener);
    }
    
    /////////////////////////////////Dugmici////////////////////////////////////////
    public JButton getBtnKreirajZpisnik() {
        return btnKreirajZapisnik;
    }

    public void setBtnKreirajZapisnik(JButton jButton) {
        this.btnKreirajZapisnik = jButton;
    }
    
    public JButton getBtnDodajStavkuUTabelu() {
        return btnDodajStavkuUTabelu;
    }

    public void setBtnDodajStavkuUTabelu(JButton jButton) {
        this.btnDodajStavkuUTabelu = jButton;
    }
    
    public JButton getBtnZapamtiZpisnik() {
        return btnZapamtiZapisnik;
    }

    public void setBtnZapamtiZapisnik(JButton jButton) {
        this.btnZapamtiZapisnik = jButton;
    }
    
    public JButton getBtnDodajSStavkeUTabelu() {
        return btnDodajSStavkeUTabelu;
    }

    public void setBtnDodajSStavkeUTabelu(JButton jButton) {
        this.btnDodajSStavkeUTabelu = jButton;
    }
    
    public JButton getBtnUbaciSStavke() {
        return btnUbaciSStavke;
    }

    public void setBtnUbaciSStavke(JButton jButton) {
        this.btnUbaciSStavke = jButton;
    }
    
    public JButton getBtnUbaciStavke() {
        return btnUbaciStavke;
    }

    public void setBtnUbaciStavke(JButton jButton) {
        this.btnUbaciStavke = jButton;
    }
    
    public void BtnKreirajZapisnikActionListener(ActionListener actionListener) {
        btnKreirajZapisnik.addActionListener(actionListener);
    }
    
    public void BtnZapamtiZapisnikActionListener(ActionListener actionListener) {
        btnZapamtiZapisnik.addActionListener(actionListener);
    }
    
    public void BtnUbaciStavkeActionListener(ActionListener actionListener) {
        btnUbaciStavke.addActionListener(actionListener);
    }
    
    public void BtnUbaciSStavkeActionListener(ActionListener actionListener) {
        btnUbaciStavke.addActionListener(actionListener);
    }
    
    public void BtnDodajStavkuUTabeluActionListener(ActionListener actionListener) {
        btnDodajStavkuUTabelu.addActionListener(actionListener);
    }
    
    public void BtnDodajSStavkuUTabeluActionListener(ActionListener actionListener) {
        btnDodajSStavkeUTabelu.addActionListener(actionListener);
    }
    
    /////////////////////////////////Tekstovi////////////////////////////////////////
    
    public JTextField getTxtDP() {
        return txtDatumPocetka;
    }

    public void setTxtDP(JTextField jTextField) {
        this.txtDatumPocetka = jTextField;
    }

    public JTextField getTxtDZ() {
        return txtDatumZavrsetka;
    }

    public void setTxtDZ(JTextField jTextField) {
        this.txtDatumZavrsetka = jTextField;
    }
    
    public JTextField getTxtBG() {
        return txtBrGrupa;
    }

    public void setTxtBG(JTextField jTextField) {
        this.txtBrGrupa = jTextField;
    }
    
    public JTextField getTxtPoeniIzBloka() {
        return txtPoeniIzBloka;
    }

    public void setTxtPoeniIzBloka(JTextField jTextField) {
        this.txtPoeniIzBloka = jTextField;
    }
    
    public JTextField getTxtPoeniSaServisa() {
        return txtPoeniSaServisa;
    }

    public void setTxtPoeniSaServisa(JTextField jTextField) {
        this.txtPoeniSaServisa = jTextField;
    }
    
    public JTextField getTxtPoeniIzIgre() {
        return txtPoeniIzIgre;
    }

    public void setTxtPoeniIzIgre(JTextField jTextField) {
        this.txtPoeniIzIgre = jTextField;
    }
    
    //////////////////////////////////Tabele////////////////////////////////////////
    
    public JTable getTableZapisnici() {
        return tableZapisnici;
    }

    public void setTableZapisnici(JTable jTable1) {
        this.tableZapisnici = jTable1;
    }
    
    public JTable getTableStavke() {
        return tableStavkeZapisnika;
    }

    public void setTableStavke(JTable jTable1) {
        this.tableStavkeZapisnika = jTable1;
    }
    
    public JTable getTableSStavke() {
        return tableSStavkeZapisnika;
    }

    public void setTableSStavke(JTable jTable1) {
        this.tableSStavkeZapisnika = jTable1;
    }
    
    //---------------------------Paneli-----------------------------------
    public JPanel getPanelStavke(){
        return panelStavka;
    }
    
    public void setPanelStavka(JPanel panel){
        this.panelStavka=panel;
    }
    
    public JPanel getPanelSStavke(){
        return panelSStavka;
    }
    
    public void setPanelSStavka(JPanel panel){
        this.panelSStavka=panel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajSStavkeUTabelu;
    private javax.swing.JButton btnDodajStavkuUTabelu;
    private javax.swing.JButton btnKreirajZapisnik;
    private javax.swing.JButton btnUbaciSStavke;
    private javax.swing.JButton btnUbaciStavke;
    private javax.swing.JButton btnZapamtiZapisnik;
    private javax.swing.JComboBox<Analiticar> cbAnaliticari;
    private javax.swing.JComboBox<Delegat> cbDelegati;
    private javax.swing.JComboBox<Igrac> cbIgraci;
    private javax.swing.JComboBox<Tim> cbTimovi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelSStavka;
    private javax.swing.JPanel panelStavka;
    private javax.swing.JTable tableSStavkeZapisnika;
    private javax.swing.JTable tableStavkeZapisnika;
    private javax.swing.JTable tableZapisnici;
    private javax.swing.JTextField txtBrGrupa;
    private javax.swing.JTextField txtDatumPocetka;
    private javax.swing.JTextField txtDatumZavrsetka;
    private javax.swing.JTextField txtPoeniIzBloka;
    private javax.swing.JTextField txtPoeniIzIgre;
    private javax.swing.JTextField txtPoeniSaServisa;
    // End of variables declaration//GEN-END:variables


}

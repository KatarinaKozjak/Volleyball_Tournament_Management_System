/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import forme.UbacivanjeIgraca;
import java.util.List;
import modeli.Igrac;
import forme.ModelTabeleIgrac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Katarina
 */
public class UbacivanjeIgracaController {
    private final UbacivanjeIgraca uif;
    
    public UbacivanjeIgracaController(UbacivanjeIgraca uif){
        this.uif=uif;
        addActionListener();
    }
    
    public void otvori(){
        pripremiFormu();
        uif.setVisible(true);
    }
    
    public void pripremiFormu(){
        List<Igrac> igraci = komunikacija.Komunikacija.getInstance().ucitajIgrace();
        
        ModelTabeleIgrac mti=new ModelTabeleIgrac(igraci);
        uif.getTableIgraci().setModel(mti);
    }
    
    private void addActionListener() {
       uif.ubaciIgraca(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   if(!uif.getjTxtIme().getText().isEmpty() && !uif.getTxtPrezime().getText().isEmpty() && !uif.getTxtPozicija().getText().isEmpty())
                   {
                        Igrac i = new Igrac(-1,uif.getjTxtIme().getText(),uif.getTxtPrezime().getText(),uif.getTxtPozicija().getText());
                        komunikacija.Komunikacija.getInstance().kreirajIgraca(i);
                        
                        /*List<Igrac> igraci = komunikacija.Komunikacija.getInstance().ucitajIgrace();
                        ModelTabeleIgrac mti = new ModelTabeleIgrac(igraci);
                        uif.getTableIgraci().setModel(mti);*/
                        JOptionPane.showMessageDialog(uif, "Sistem je zapamtio igraca.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                        uif.getjTxtIme().setText("");
                        uif.getTxtPrezime().setText("");
                        uif.getTxtPozicija().setText("");
                   }
                   else{
                        JOptionPane.showMessageDialog(uif, "Fale podaci za atribute igraca.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                   }
                  
               } catch (Exception ex) {
                       JOptionPane.showMessageDialog(uif, "Sistem ne moze da zapamti igraca .", "GRESKA", JOptionPane.ERROR_MESSAGE);
               }
           }
       });      
    }
    
}

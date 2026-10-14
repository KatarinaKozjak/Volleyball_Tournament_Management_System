/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import forme.BrisanjeDelegataForma;
import forme.ModelTabeleDelegat;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import modeli.Delegat;
import modeli.Mesto;
import modeli.Zapisnik;
/**
 *
 * @author Katarina
 */
public class BrisanjeDelegataController {
    private final BrisanjeDelegataForma bdf;
            
    public BrisanjeDelegataController(BrisanjeDelegataForma bdf){
        this.bdf=bdf;
        addActionListener();
    }
    
    private Delegat selektovanDelegat;
    
    private void addActionListener(){
   
        
        bdf.addWindowFocusListener(new WindowFocusListener(){
        
            @Override
            public void windowGainedFocus(WindowEvent e) {
                List<Mesto> listaMesta = komunikacija.Komunikacija.getInstance().ucitajMesta();
                bdf.getCBMesto().removeAllItems();
                for(int i=0;i<listaMesta.size();i++){
                   bdf.getCBMesto().addItem(listaMesta.get(i));
                }
                
                bdf.getCBMesto().setSelectedItem(null);
                //srediFormu();
            }


            @Override
            public void windowLostFocus(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        
        });
        
        bdf.pretraziDelegateActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    Map<String, Object> kriterijumi = new HashMap<>();
                    String id = bdf.getTxtId().getText();
                    String ime = bdf.getTxtIme().getText();
                    String prezime = bdf.getTxtPrezime().getText();
                    String mesto = "";
                    if(bdf.getCBMesto().getSelectedItem()!=null){
                        mesto = bdf.getCBMesto().getSelectedItem().toString();
                    }
                    
                    kriterijumi.put("delegat.Id_Delegat", id.trim().isEmpty()? null : id);
                    kriterijumi.put("delegat.Ime", ime.isEmpty()? null : ime);
                    kriterijumi.put("delegat.Prezime", prezime.isEmpty()? null : prezime);
                    kriterijumi.put("mesto.Naziv", mesto.isEmpty()? null : mesto);
                    
                    List<Delegat> delegati = komunikacija.Komunikacija.getInstance().pretragaDelegataPOKriterijumima(kriterijumi);
                    ModelTabeleDelegat mtd = new ModelTabeleDelegat(delegati);
                    bdf.getTableDelegati().setModel(mtd);
                    
                    srediFormu();
                    
                    if(bdf.getTableDelegati().getRowCount()==0){
                        JOptionPane.showMessageDialog(bdf, "Sistem ne moze da nadje delegate po zadatim kriterijumima.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(bdf, "Sistem je nasao delegate po zadatim kriterijumima.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(bdf, "Sistem ne moze da nadje delegate po zadatim kriterijumima.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
 
            }
        }); 
        
        bdf.getTableDelegati().getSelectionModel().addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting()){
                int row = bdf.getTableDelegati().getSelectedRow();
                if(row != -1){
                    ModelTabeleDelegat mtd = (ModelTabeleDelegat) bdf.getTableDelegati().getModel();
                    selektovanDelegat = mtd.getDelegatAt(row);
                    bdf.getBtnPotvrdi().setEnabled(true);
                }
            }
        });
        
        bdf.potvrdiDelegataActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    if(selektovanDelegat==null){
                        JOptionPane.showMessageDialog(bdf, "Morate da selektujete delegata.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(bdf, "Sistem je nasao selektovanog delegata.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        bdf.getBtnObrisi().setEnabled(true);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(bdf, "Sistem nije nasao selektovanog delegata.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        bdf.obrisiDelegataActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    /*int IdDelegata = (int)bdf.getTableDelegati().getValueAt(bdf.getTableDelegati().getSelectedRow(), 0);
                    String ime =(String)bdf.getTableDelegati().getValueAt(bdf.getTableDelegati().getSelectedRow(), 1);
                    String prezime =(String)bdf.getTableDelegati().getValueAt(bdf.getTableDelegati().getSelectedRow(), 2);
                    Mesto mesto =(Mesto)bdf.getTableDelegati().getValueAt(bdf.getTableDelegati().getSelectedRow(), 3);

                    Delegat d = new Delegat(IdDelegata,ime,prezime,mesto);*/
                    

                    boolean rezultat = komunikacija.Komunikacija.getInstance().obrisiDelegata(selektovanDelegat);
                    if(rezultat == true){
                        JOptionPane.showMessageDialog(bdf, "Sistem je obrisao delegata.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        List<Delegat> delegati = komunikacija.Komunikacija.getInstance().ucitajDelegate();
                        ModelTabeleDelegat mtd = new ModelTabeleDelegat(delegati);
                        bdf.getTableDelegati().setModel(mtd);
                    }
                    else{
                        JOptionPane.showMessageDialog(bdf, "Sistem ne moze da obrise delegata.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(bdf, "Sistem ne moze da obrise delegata.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public void srediFormu(){
        bdf.getTxtId().setText("");
        bdf.getTxtIme().setText("");
        bdf.getTxtPrezime().setText("");
        bdf.getCBMesto().setSelectedItem(null);
        bdf.getBtnObrisi().setEnabled(false);
        bdf.getBtnPotvrdi().setEnabled(false);
    }
    
    public void otvori()
    {
        bdf.setVisible(true);
        //srediFormu();
    }

}

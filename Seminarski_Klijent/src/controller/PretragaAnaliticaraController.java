/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import forme.ModelTabeleAnaliticari;
import forme.PretragaAnaliticara;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import modeli.Analiticar;
import modeli.Delegat;
/**
 *
 * @author Katarina
 */
public class PretragaAnaliticaraController {
    private final PretragaAnaliticara paf;
    
    public PretragaAnaliticaraController(PretragaAnaliticara paf){
        this.paf=paf;
        addActionListener();
    }
    
    public void addActionListener(){
    
        paf.pretraziAnaliticareActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    Map<String, Object> kriterijumi = new HashMap<>();
                    String id = paf.getTxtId().getText().trim();
                    String ime = paf.getTxtIme().getText().trim();
                    String prezime = paf.getTxtPrezime().getText().trim();
                    String mejl = paf.getTxtEmail().getText().trim();
                    Delegat de = (Delegat) paf.getCBDelegat().getSelectedItem();
                    
                    kriterijumi.put("Id_Analiticar", id.isEmpty() ? null : id);
                    kriterijumi.put("Ime", ime.isEmpty() ? null : ime);
                    kriterijumi.put("Prezime", prezime.isEmpty() ? null : prezime);
                    kriterijumi.put("Email", mejl.isEmpty() ? null : mejl);
                    kriterijumi.put("Id_Delegat", de==null? null:de.getIdDelegata());
                    
                    List<Analiticar> analiticari = komunikacija.Komunikacija.getInstance().pretraziAnaliticarePoKriterijumima(kriterijumi);
                    if(analiticari==null){
                        analiticari = new ArrayList<>();
                    }
                    ModelTabeleAnaliticari mta = new ModelTabeleAnaliticari(analiticari);
                    paf.getTableAnaliticari().setModel(mta);
                    
                    if(paf.getTableAnaliticari().getRowCount()==0){
                        JOptionPane.showMessageDialog(paf, "Sistem ne moze da nadje analiticare po zadatim kriterijumima.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        srediFormu();
                    }
                    else{
                        JOptionPane.showMessageDialog(paf, "Sistem je nasao analiticare po zadatim kriterijumima.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        srediFormu();
                    }
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(paf, "Sistem ne moze da nadje analiticare po zadatim kriterijumima.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    srediFormu();
                }
            }
        });
    }
    
    public void otvori(){
        paf.setVisible(true);
        pripremiCB();
        srediFormu();
    }
    
    private void pripremiCB(){
        List<Delegat> zaCBDelegat = komunikacija.Komunikacija.getInstance().ucitajDelegate();
        
        for(int i=0;i<zaCBDelegat.size();i++){
            paf.getCBDelegat().addItem(zaCBDelegat.get(i));
        }
    }
    
    public void srediFormu(){
        paf.getCBDelegat().setSelectedItem(null);
        paf.getTxtId().setText("");
        paf.getTxtIme().setText("");
        paf.getTxtPrezime().setText("");
        paf.getTxtEmail().setText("");
    }
}

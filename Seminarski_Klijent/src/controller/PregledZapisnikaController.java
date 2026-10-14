/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.sun.java.accessibility.util.AWTEventMonitor;
import modeli.Analiticar;
import forme.PregledZapisnika;
import forme.ModelTabeleZapisnici;
import forme.ModelTabeleStavka;
import forme.ModelTabeleSStavka;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import modeli.StavkaZapisnika;
import modeli.SStavkaZapisnika;
import modeli.Zapisnik;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import modeli.Delegat;
import modeli.Tim;

/**
 *
 * @author Katarina
 */
public class PregledZapisnikaController {
    private Analiticar ulogovan;
    private final PregledZapisnika pzf;

    List<Zapisnik> sviZapisnici = new LinkedList<>();
    List<Zapisnik> filterZapisnici = new LinkedList<>();
    List<StavkaZapisnika> filterStavke = new LinkedList<>();
    Zapisnik odabranZapisnik;
    StavkaZapisnika odabranaStavka;
    
    public PregledZapisnikaController(PregledZapisnika pzf)
    {
        this.pzf=pzf;
        addActionListener();
    }
    
    public void otvori(){
        pzf.setVisible(true);
        pripremiCB();
        srediFormu();
    }
    
    private void addActionListener(){
        
        pzf.getTableStavke().getSelectionModel().addListSelectionListener(e -> {
            pzf.getBtnDetaljiStavke().setEnabled(false);
            if(!e.getValueIsAdjusting()){
                int row = pzf.getTableStavke().getSelectedRow();
                if(row != -1){
                    ModelTabeleStavka mts = (ModelTabeleStavka) pzf.getTableStavke().getModel();
                    odabranaStavka = mts.getStavkaZapisnikaAt(row);
                    pzf.getBtnDetaljiStavke().setEnabled(true);
                }
            }
        });
        
        pzf.getTableZapisnici().getSelectionModel().addListSelectionListener(e -> {
            pzf.getBtnDetaljiZapisnika().setEnabled(false);
            pzf.getCBTim().setEnabled(false);
            if(!e.getValueIsAdjusting()){
                int row = pzf.getTableZapisnici().getSelectedRow();
                if(row != -1){
                    ModelTabeleZapisnici mtz = (ModelTabeleZapisnici) pzf.getTableZapisnici().getModel();
                    odabranZapisnik = mtz.getZapisnikAt(row);
                    pzf.getBtnDetaljiZapisnika().setEnabled(true);
                    pzf.getCBTim().setEnabled(true);
                }
            }
        });
        
        pzf.prikaziDetaljeZapisnika(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    odabranZapisnik.setIdZapisnika((int)pzf.getTableZapisnici().getValueAt(pzf.getTableZapisnici().getSelectedRow(), 0));
                    Map<String, Object> kriterijum = new HashMap<>();
                    kriterijum.put("Id_Zapisnik", odabranZapisnik.getIdZapisnika());
                    
                    //filterStavke = komunikacija.Komunikacija.getInstance().pretragaZapisnikaPOKriterijumu(kriterijum);
                    filterStavke = odabranZapisnik.getStavka();
                    

                    if(filterStavke == null || filterStavke.isEmpty()){
                        JOptionPane.showMessageDialog(pzf, "Selektovani zapisnik nema stavke.", "GRESKA", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(pzf, "Sistem je nasao stavke zapisnika.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        ModelTabeleStavka mts = new ModelTabeleStavka(filterStavke);
                        pzf.getTableStavke().setModel(mts);
                        pzf.getCBTim().setSelectedItem(null);
                    }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(pzf, "Sistem ne moze da nadje stavke zapisnika.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        pzf.prikaziDetaljeStavke(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    
                    //odabranZapisnik.setIdZapisnika((int)pzf.getTableZapisnici().getValueAt(pzf.getTableZapisnici().getSelectedRow(), 0));
                    odabranaStavka.setRedniBrojStavke((int)pzf.getTableStavke().getValueAt(pzf.getTableStavke().getSelectedRow(), 0));
                    
                    List<SStavkaZapisnika> listaSStavke = odabranaStavka.getSStavka();
                    
                    if(listaSStavke==null || listaSStavke.isEmpty()){
                        JOptionPane.showMessageDialog(pzf, "Izabrana stavka nema sstavke zapisnika.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(pzf, "Sistem je nasao sstavke zapisnika.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        ModelTabeleSStavka mtss = new ModelTabeleSStavka(listaSStavke);
                        pzf.getTableSStavke().setModel(mtss);
                    }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(pzf, "Sistem ne moze da nadje sstavke zapisnika.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        
        pzf.getTxtDatumDo().getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                validirajDatumDo();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                validirajDatumDo();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validirajDatumDo();
            }
        });
        
        pzf.getTxtDatumOd().getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                validirajDatumOd();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                validirajDatumOd();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validirajDatumOd();
            }
        });
        
        pzf.pretraziZapisnikePoKriterijumima(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    pzf.getTableStavke().setModel(new ModelTabeleStavka(new ArrayList<>()));
                    pzf.getTableSStavke().setModel(new ModelTabeleSStavka(new ArrayList<>()));
                    HashMap<String, Object> kriterijumi = new HashMap<>();
                    
                    String datumOd = pzf.getTxtDatumOd().getText();
                    String datumDo = pzf.getTxtDatumDo().getText();
                    
                    LocalDate Od=null;
                    LocalDate Do =null;
                    Analiticar an = null;
                    Delegat de = null;
                    
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    
                    if(!datumOd.isEmpty()){
                        Od = LocalDate.parse(datumOd, format);
                    }
                    
                    if(!datumDo.isEmpty()){
                        Do = LocalDate.parse(datumDo, format);
                    }
                    
                    if(Od !=null && Do != null && Od.isAfter(Do)){
                        JOptionPane.showMessageDialog(pzf, "Datum OD ne moze biti posle datuma DO.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if(pzf.getCBDelegat().getSelectedItem()!=null){
                        de = (Delegat) pzf.getCBDelegat().getSelectedItem();
                    }
                    
                    if(pzf.getCBAnaliticar().getSelectedItem()!=null){
                        an = (Analiticar)pzf.getCBAnaliticar().getSelectedItem();
                    }

                    kriterijumi.put("Datum_Pocetka", datumOd.isEmpty()? null : datumOd);
                    kriterijumi.put("Datum_Zavrsetka", datumDo.isEmpty()? null : datumDo);
                    kriterijumi.put("Id_Analiticar", an==null? null : an.getIdAnaliticara());
                    kriterijumi.put("Id_Delegat", de==null? null : de.getIdDelegata());
                    
                    filterZapisnici = komunikacija.Komunikacija.getInstance().pretragaZapisnikaPOKriterijumima(kriterijumi);
                    
                    if(filterZapisnici == null || filterZapisnici.isEmpty()){
                        JOptionPane.showMessageDialog(pzf, "Sistem ne moze da nadje zapisnike po zadatim kriterijumima .", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(pzf, "Sistem je nasao zapisnike po zadatim kriterijumima.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        ModelTabeleZapisnici mtz = new ModelTabeleZapisnici(filterZapisnici);
                        pzf.getTableZapisnici().setModel(mtz);
                        
                        pzf.getCBAnaliticar().setSelectedItem(null);
                        pzf.getCBDelegat().setSelectedItem(null);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(pzf, "Sistem ne moze da nadje zapisnike po zadatim kriterijumima .", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
    }
    
    private List<Zapisnik> ucitajSveZapisnike(){
        ulogovan = kordinatorFormi.Kordinator.getInstance().getUlogovani();
        sviZapisnici = komunikacija.Komunikacija.getInstance().ucitajZapisnike();
        return sviZapisnici;
    }
    
    private void pripremiCB(){
        List<Analiticar> zaCBAnaliticar = komunikacija.Komunikacija.getInstance().ucitajAnaliticare();
        List<Delegat> zaCBDelegat = komunikacija.Komunikacija.getInstance().ucitajDelegate();
        List<Tim> zaCBTim = komunikacija.Komunikacija.getInstance().ucitajTim();

        for(int i=0;i<zaCBAnaliticar.size();i++){
            pzf.getCBAnaliticar().addItem(zaCBAnaliticar.get(i));
        }
        
        for(int i=0;i<zaCBDelegat.size();i++){
            pzf.getCBDelegat().addItem(zaCBDelegat.get(i));
        }
        
        for(int i=0;i<zaCBTim.size();i++){
            pzf.getCBTim().addItem(zaCBTim.get(i));
        }
    }
    
    public void srediFormu(){
        ucitajSveZapisnike();
        
        pzf.getCBAnaliticar().setSelectedItem(null);
        pzf.getCBDelegat().setSelectedItem(null);
        pzf.getCBTim().setSelectedItem(null);
        pzf.getCBTim().setEnabled(false);
        
        pzf.getBtnDetaljiZapisnika().setEnabled(false);
        pzf.getBtnDetaljiStavke().setEnabled(false);
        
        pzf.getTableZapisnici().setModel(new ModelTabeleZapisnici(new ArrayList<>()));
        pzf.getTableStavke().setModel(new ModelTabeleStavka(new ArrayList<>()));
        pzf.getTableSStavke().setModel(new ModelTabeleSStavka(new ArrayList<>()));
        pzf.getTxtDatumDo().setText("");
        pzf.getTxtDatumOd().setText("");
    }
    
    private void validirajDatumOd() {
        String unos = pzf.getTxtDatumOd().getText().trim();
        if(unos.isEmpty()){return;}
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(unos, formatter);
            pzf.getTxtDatumOd().setBackground(Color.WHITE);
            pzf.getBtnPretraziZapisnike().setEnabled(true);
        } catch (Exception e) {
            pzf.getTxtDatumOd().setBackground(new Color(255, 150, 150));
            pzf.getBtnPretraziZapisnike().setEnabled(false);
        }
    }
    
    private void validirajDatumDo() {
        String unos = pzf.getTxtDatumDo().getText().trim();
        if(unos.isEmpty()){return;}
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(unos, formatter);
            pzf.getTxtDatumDo().setBackground(Color.WHITE);
            pzf.getBtnPretraziZapisnike().setEnabled(true);
        } catch (Exception e) {
            pzf.getTxtDatumDo().setBackground(new Color(255, 150, 150));
            pzf.getBtnPretraziZapisnike().setEnabled(false);
        }
    }
}

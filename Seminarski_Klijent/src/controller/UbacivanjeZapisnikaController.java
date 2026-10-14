/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import forme.UbacivanjeZapisnika;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

import modeli.Analiticar;
import modeli.Delegat;
import modeli.Zapisnik;
import forme.ModelTabeleZapisnici;
import forme.ModelTabeleStavka;
import forme.ModelTabeleSStavka;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modeli.Igrac;
import modeli.SStavkaZapisnika;
import modeli.StavkaZapisnika;
import modeli.Tim;

/**
 *
 * @author Katarina
 */
public class UbacivanjeZapisnikaController {
    private final UbacivanjeZapisnika kzf;
    
    
    public UbacivanjeZapisnikaController (UbacivanjeZapisnika kzf){
        this.kzf=kzf;
        addActionListener();
    }
    
    private Analiticar ulogovani = kordinatorFormi.Kordinator.getInstance().getUlogovani();
    Zapisnik zaUnos = new Zapisnik();
    StavkaZapisnika stavkaZaUnos = new StavkaZapisnika();
    SStavkaZapisnika sstavkaZaUnos = new SStavkaZapisnika();
    //List<Zapisnik> zapisniciSvi = komunikacija.Komunikacija.getInstance().ucitajZapisnike();
    List<Zapisnik> zapisnici = new ArrayList<>();;
    List<SStavkaZapisnika> listaSStavki = new ArrayList<>();
    List<StavkaZapisnika> listaStavki = new ArrayList<>();
    
    private StavkaZapisnika selektovanaStavka;
    private Zapisnik selektovanZapisnik;
    
    private void addActionListener() {
        
        
        kzf.BtnDodajSStavkuUTabeluActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    Igrac igrac = (Igrac)kzf.getCBIgraci().getSelectedItem();
                    /*int poeniIB = Integer.parseInt(kzf.getTxtPoeniIzBloka().getText());
                    int poeniII = Integer.parseInt(kzf.getTxtPoeniIzIgre().getText());
                    int poeniSS = Integer.parseInt(kzf.getTxtPoeniSaServisa().getText());*/
                    
                    String poeniIB = kzf.getTxtPoeniIzBloka().getText();
                    String poeniII = kzf.getTxtPoeniIzIgre().getText();
                    String poeniSS = kzf.getTxtPoeniSaServisa().getText();
                    
                    if(selektovanaStavka!=null){
                        if(kzf.getCBIgraci().getSelectedItem()!=null && !poeniIB.isEmpty() && !poeniII.isEmpty() && !poeniSS.isEmpty()){
                        
                            int pIB = Integer.parseInt(poeniIB);
                            int pII = Integer.parseInt(poeniII);
                            int pSS = Integer.parseInt(poeniSS);
                        
                            int ukupniPoeni = pIB + pII + pSS;
                            boolean mvp = false;
                    
                    
                            SStavkaZapisnika ss = new SStavkaZapisnika(zaUnos, selektovanaStavka, -1, mvp, pIB, pSS, pII, ukupniPoeni, igrac);
                            sstavkaZaUnos=ss;
                            listaSStavki.add(sstavkaZaUnos);
                            selektovanaStavka.setSStavka(listaSStavki);
                            ModelTabeleSStavka mssz = new ModelTabeleSStavka(listaSStavki);
                            kzf.getTableSStavke().setModel(mssz);
                            
                            kzf.getTxtPoeniIzBloka().setText("");
                            kzf.getTxtPoeniIzIgre().setText("");
                            kzf.getTxtPoeniSaServisa().setText("");
                            kzf.getCBIgraci().setSelectedItem(null);
                        }
                        else{
                            JOptionPane.showMessageDialog(kzf, "Mora da se popune sve vrednosti.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(kzf, "Mora da se selektuje stavka.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(kzf, "Sistem ne moze da sacuva sstavku.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
        
        kzf.getTableStavke().getSelectionModel().addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting()){
                int row = kzf.getTableStavke().getSelectedRow();
                if(row != -1){
                    ModelTabeleStavka mts = (ModelTabeleStavka) kzf.getTableStavke().getModel();
                    selektovanaStavka = mts.getStavkaZapisnikaAt(row);
                    kzf.getBtnUbaciSStavke().setEnabled(true);
                }
            }
        });
        
        /*kzf.getTableZapisnici().getSelectionModel().addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting()){
                int row = kzf.getTableZapisnici().getSelectedRow();
                if(row != -1){
                    ModelTabeleZapisnici mtz = (ModelTabeleZapisnici) kzf.getTableZapisnici().getModel();
                    selektovanZapisnik = mtz.getZapisnikAt(row);
                    kzf.getBtnUbaciStavke().setEnabled(true);
                }
            }
        });*/
        
        kzf.BtnUbaciSStavkeActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kzf.getBtnDodajSStavkeUTabelu().setEnabled(true);
                
            }
        });
        
        kzf.BtnDodajStavkuUTabeluActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    Tim tim = (Tim)kzf.getCBTimovi().getSelectedItem();
                    if(kzf.getCBTimovi().getSelectedItem()!=null){
                        StavkaZapisnika nova = new StavkaZapisnika();
                        nova.setTim(tim);
                        nova.setZapisnik(zaUnos);
                        nova.setSStavka(new ArrayList<>());
                        stavkaZaUnos = nova;
                        listaStavki.add(stavkaZaUnos);
                    
                        //racunamo rang za sve stavke
                        izracunajRang(listaStavki);
                        
                    
                        ModelTabeleStavka msz = new ModelTabeleStavka(listaStavki);
                        kzf.getTableStavke().setModel(msz);
                       
                    }
                    else{
                        JOptionPane.showMessageDialog(kzf, "Mora da se izabere tim.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception ex) {
                    //JOptionPane.showMessageDialog(kzf, "Sistem ne moze da sacuva stavku.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        
        kzf.BtnKreirajZapisnikActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    /*LocalDate datPoc = LocalDate.parse(kzf.getTxtDP().getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    LocalDate datZav = LocalDate.parse(kzf.getTxtDZ().getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    int brGrupa = Integer.parseInt(kzf.getTxtBG().getText());
                    Delegat delegat = (Delegat)kzf.getCBDelegati().getSelectedItem();
                    Analiticar analiticar = (Analiticar) kzf.getCBAnaliticari().getSelectedItem();*/
                    
                    
                    String datPoc = kzf.getTxtDP().getText();
                    String datZav = kzf.getTxtDZ().getText();
                    String brGrupa = kzf.getTxtBG().getText();
                    Delegat delegat =(Delegat) kzf.getCBDelegati().getSelectedItem();
                    Analiticar analiticar =(Analiticar) kzf.getCBAnaliticari().getSelectedItem();
                    
                    if(!datPoc.isEmpty() && !datZav.isEmpty() && !brGrupa.isEmpty() && kzf.getCBDelegati().getSelectedItem()!=null && kzf.getCBAnaliticari().getSelectedItem()!=null){
                        Zapisnik zapisnik = new Zapisnik(-1,LocalDate.parse(datPoc, DateTimeFormatter.ofPattern("yyyy-MM-dd")),LocalDate.parse(datZav, DateTimeFormatter.ofPattern("yyyy-MM-dd")),null,Integer.parseInt(brGrupa),analiticar,delegat);
                        zaUnos=zapisnik;
                        JOptionPane.showMessageDialog(kzf, "Sistem je kreirao zapisnik.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    
                        
                        zapisnici.add(zaUnos);
                        ModelTabeleZapisnici mtz = new ModelTabeleZapisnici(zapisnici);
                        kzf.getTableZapisnici().setModel(mtz);
                        
                        kzf.getBtnUbaciStavke().setEnabled(true);
                        kzf.getBtnKreirajZpisnik().setEnabled(false);
                        kzf.getBtnZapamtiZpisnik().setEnabled(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(kzf, "Moraju se uneti vrednosti za sva polja.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception er) {
                    JOptionPane.showMessageDialog(kzf, "Sistem ne moze da kreira zapisnik.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        kzf.BtnUbaciStavkeActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kzf.getBtnDodajStavkuUTabelu().setEnabled(true);
            }
        });
        
        kzf.BtnZapamtiZapisnikActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    
                    if(listaStavki!=null){
                        zaUnos.setStavka(listaStavki);
                        for(StavkaZapisnika s : listaStavki){
                            s.setZapisnik(zaUnos);
                            if(s.getSStavka()!=null && !s.getSStavka().isEmpty()){
                                for(SStavkaZapisnika ss : s.getSStavka()){
                                    ss.setStavkaZapisnika(s);
                                    ss.setMvp(false);
                                }
                            }
                        }
                    }
                    
                    komunikacija.Komunikacija.getInstance().kreirajZapisnik(zaUnos);
                    JOptionPane.showMessageDialog(kzf, "Sistem je zapamtio zapisinik.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                    
                    kzf.getTxtDP().setText("");
                    kzf.getTxtDZ().setText("");
                    kzf.getTxtBG().setText("");
                    kzf.getTxtPoeniIzBloka().setText("");
                    kzf.getTxtPoeniIzIgre().setText("");
                    kzf.getTxtPoeniSaServisa().setText("");
                    pripremiFormu();
                    
                } catch (Exception er) {
                    JOptionPane.showMessageDialog(kzf, "Sistem ne moze da zapamti zapisnik.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
       
        });
        
    }
    
    public void otvori(){
        kzf.setVisible(true);
        pripremiFormu();
    }
    
    
    
    private void pripremiFormu() {
        //List<Analiticar> analiticari = komunikacija.Komunikacija.getInstance().ucitajAnaliticare();
        List<Delegat> delegati = komunikacija.Komunikacija.getInstance().ucitajDelegate();
        List<Tim> timovi = komunikacija.Komunikacija.getInstance().ucitajTim();
        List<Igrac> igraci = komunikacija.Komunikacija.getInstance().ucitajIgrace();

        kzf.getCBAnaliticari().addItem(ulogovani);
        
        for (int i = 0; i < delegati.size(); i++) {
            kzf.getCBDelegati().addItem(delegati.get(i));
        }
        
        for (int i = 0; i < timovi.size(); i++) {
            kzf.getCBTimovi().addItem(timovi.get(i));
        }
        
        for (int i = 0; i < igraci.size(); i++) {
            kzf.getCBIgraci().addItem(igraci.get(i));
        }
        
        kzf.getCBDelegati().setSelectedItem(null);
        kzf.getCBAnaliticari().setSelectedItem(null);
        kzf.getCBIgraci().setSelectedItem(null);
        kzf.getCBTimovi().setSelectedItem(null);
        
        kzf.getBtnUbaciStavke().setEnabled(false);
        kzf.getBtnUbaciSStavke().setEnabled(false);
        kzf.getBtnZapamtiZpisnik().setEnabled(false);
        kzf.getBtnKreirajZpisnik().setEnabled(true);
        kzf.getBtnDodajStavkuUTabelu().setEnabled(false);
        kzf.getBtnDodajSStavkeUTabelu().setEnabled(false);
        
        kzf.getTableZapisnici().setModel(new ModelTabeleZapisnici(new ArrayList<>()));
        kzf.getTableStavke().setModel(new ModelTabeleStavka(new ArrayList<>()));
        kzf.getTableSStavke().setModel(new ModelTabeleSStavka(new ArrayList<>()));
    }
    
    
    public void izracunajRang(List<StavkaZapisnika> lista){
        //sortiranje timova po broju pobeda
        lista.sort((s1,s2)-> Integer.compare(
                s2.getTim().getBrojPobeda(),
                s1.getTim().getBrojPobeda()
        ));
        
        //dodela mesta na rang listi
        int rang = 1;
        for(StavkaZapisnika s : lista){
            s.setMestoNaRangListi(rang++);
        }
    }

}

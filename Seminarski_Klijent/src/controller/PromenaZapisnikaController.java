/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.sun.java.accessibility.util.AWTEventMonitor;
import modeli.Analiticar;
import forme.PromenaZapisnika;
import forme.ModelTabeleZapisnici;
import forme.ModelTabeleZapisniciIzmena;
import forme.ModelTabeleStavka;
import forme.ModelTabeleSStavka;
import forme.ModelTabeleSStavkaIzmena;
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
public class PromenaZapisnikaController {
    private Analiticar ulogovan;
    private final PromenaZapisnika przf;
    
    Zapisnik zaIzmenu = new Zapisnik();
    List<StavkaZapisnika> stavkeZaIzmenu = new ArrayList<>();
    List<SStavkaZapisnika> sstavkeZaIzmenu = new ArrayList<>();
    
    List<Zapisnik> sviZapisnici = new LinkedList<>();
    List<Zapisnik> filterZapisnici = new LinkedList<>();
    Zapisnik odabranZapisnik;
    StavkaZapisnika odabranaStavka;
    SStavkaZapisnika odabranaSStavka;
    
    public PromenaZapisnikaController(PromenaZapisnika przf)
    {
        this.przf=przf;
        addActionListener();
    }
    
    public void otvori(){
        przf.setVisible(true);
        pripremiCB();
        srediFormu();
    }
    
    
    private void addActionListener(){
    
        przf.getTabelaStavkaZapisnika().getSelectionModel().addListSelectionListener(e -> {
            przf.getBtnOdaberiStavkuZapisnika().setEnabled(false);
            if(!e.getValueIsAdjusting()){
                int row = przf.getTabelaStavkaZapisnika().getSelectedRow();
                if(row != -1){
                    ModelTabeleStavka mts = (ModelTabeleStavka) przf.getTabelaStavkaZapisnika().getModel();
                    odabranaStavka = mts.getStavkaZapisnikaAt(row);
                    przf.getBtnOdaberiStavkuZapisnika().setEnabled(true);
                }
            }
        });
        
        przf.getTabelaZapisnici().getSelectionModel().addListSelectionListener(e -> {
            przf.getBtnOdaberiZapisnik().setEnabled(false);
            if(!e.getValueIsAdjusting()){
                int row = przf.getTabelaZapisnici().getSelectedRow();
                if(row != -1){
                    ModelTabeleZapisniciIzmena mtz = (ModelTabeleZapisniciIzmena) przf.getTabelaZapisnici().getModel();
                    odabranZapisnik = mtz.getZapisnikAt(row);
                    przf.getBtnOdaberiZapisnik().setEnabled(true);
                }
            }
        });
        
        przf.getTabelaSStavkaZapisnika().getSelectionModel().addListSelectionListener(e -> {
            przf.getBtnOdaberiSStavkuZapisnika().setEnabled(false);
            if(!e.getValueIsAdjusting()){
                int row = przf.getTabelaSStavkaZapisnika().getSelectedRow();
                if(row != -1){
                    ModelTabeleSStavkaIzmena mtss = (ModelTabeleSStavkaIzmena) przf.getTabelaSStavkaZapisnika().getModel();
                    odabranaSStavka = mtss.getSStavkaZapisnikaAt(row);
                    przf.getBtnOdaberiSStavkuZapisnika().setEnabled(true);
                }
            }
        });
        
        przf.filtrirajZapisnike(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    //przf.getTabelaStavkaZapisnika().setModel(new ModelTabeleStavka(new ArrayList<>()));
                    //przf.getTabelaSStavkaZapisnika().setModel(new ModelTabeleSStavkaIzmena(new ArrayList<>()));
                    HashMap<String, Object> kriterijumi = new HashMap<>();
                    
                    String datumOd = przf.getTxtDatumOd().getText();
                    String datumDo = przf.getTxtDatumDo().getText();
                    
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
                        JOptionPane.showMessageDialog(przf, "Datum OD ne moze biti posle datuma DO.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if(przf.getCBDelegat().getSelectedItem()!=null){
                        de = (Delegat) przf.getCBDelegat().getSelectedItem();
                    }
                    
                    if(przf.getCBAnaliticar().getSelectedItem()!=null){
                        an = (Analiticar)przf.getCBAnaliticar().getSelectedItem();
                    }

                    kriterijumi.put("Datum_Pocetka", datumOd.isEmpty()? null : datumOd);
                    kriterijumi.put("Datum_Zavrsetka", datumDo.isEmpty()? null : datumDo);
                    kriterijumi.put("Id_Analiticar", an==null? null : an.getIdAnaliticara());
                    kriterijumi.put("Id_Delegat", de==null? null : de.getIdDelegata());
                    
                    filterZapisnici = komunikacija.Komunikacija.getInstance().pretragaZapisnikaPOKriterijumima(kriterijumi);
                    
                    if(filterZapisnici == null || filterZapisnici.isEmpty()){
                        JOptionPane.showMessageDialog(przf, "Sistem ne moze da nadje zapisnike po zadatim kriterijumima .", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        przf.getCBAnaliticar().setSelectedItem(null);
                        przf.getCBDelegat().setSelectedItem(null);
                        przf.getTxtDatumDo().setText("");
                        przf.getTxtDatumOd().setText("");
                    }else{
                        JOptionPane.showMessageDialog(przf, "Sistem je nasao zapisnike po zadatim kriterijumima.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        ModelTabeleZapisniciIzmena mtz = new ModelTabeleZapisniciIzmena(filterZapisnici);
                        przf.getTabelaZapisnici().setModel(mtz);
                        przf.getTabelaStavkaZapisnika().setModel(new ModelTabeleStavka(new ArrayList<>()));
                        przf.getTabelaSStavkaZapisnika().setModel(new ModelTabeleSStavkaIzmena(new ArrayList<>()));
                        
                        przf.getCBAnaliticar().setSelectedItem(null);
                        przf.getCBDelegat().setSelectedItem(null);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(przf, "Sistem ne moze da nadje zapisnike po zadatim kriterijumima .", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        przf.getTxtDatumDo().getDocument().addDocumentListener(new DocumentListener(){
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
        
        przf.getTxtDatumOd().getDocument().addDocumentListener(new DocumentListener(){
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
        
        przf.odaberiSelektovanZapisnik(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    int red = przf.getTabelaZapisnici().getSelectedRow();
                    ModelTabeleZapisniciIzmena mtz = (ModelTabeleZapisniciIzmena) przf.getTabelaZapisnici().getModel();
                    odabranZapisnik = mtz.getZapisnikAt(red);
                    przf.getBtnZapamtiIzmene().setEnabled(true);
                    List<StavkaZapisnika> listaStavke = odabranZapisnik.getStavka();
                    
                    if(listaStavke==null || listaStavke.isEmpty()){
                        ModelTabeleStavka mts = new ModelTabeleStavka(new ArrayList<>());
                        przf.getTabelaStavkaZapisnika().setModel(mts);
                        //przf.getBtnZapamtiIzmene().setEnabled(true);
                    }else{
                        ModelTabeleStavka mts = new ModelTabeleStavka(listaStavke);
                        przf.getTabelaStavkaZapisnika().setModel(mts);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(przf, "Sistem ne moze da nadje zapisnik.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        przf.odaberiSelektovanuStavkuZapisnika(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    
                    int red = przf.getTabelaStavkaZapisnika().getSelectedRow();
                    ModelTabeleStavka mts = (ModelTabeleStavka) przf.getTabelaStavkaZapisnika().getModel();
                    odabranaStavka = mts.getStavkaZapisnikaAt(red);
                    List<SStavkaZapisnika> listaSStavke = odabranaStavka.getSStavka();
                    
                    if(listaSStavke==null || listaSStavke.isEmpty()){
                        ModelTabeleSStavkaIzmena mtss = new ModelTabeleSStavkaIzmena(new ArrayList<>());
                        przf.getTabelaSStavkaZapisnika().setModel(mtss);
                        przf.getBtnZapamtiIzmene().setEnabled(true);
                    }else{
                        ModelTabeleSStavkaIzmena mtss = new ModelTabeleSStavkaIzmena(listaSStavke);
                        przf.getTabelaSStavkaZapisnika().setModel(mtss);
                    }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(przf, "Sistem ne moze da nadje stavke zapisnika.", "OBAVESTENJE", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        przf.odaberiSelektovanuSStavkuZapisnika(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    int red = przf.getTabelaSStavkaZapisnika().getSelectedRow();
                    ModelTabeleSStavkaIzmena mtss = (ModelTabeleSStavkaIzmena) przf.getTabelaSStavkaZapisnika().getModel();
                    odabranaSStavka = mtss.getSStavkaZapisnikaAt(red);
                    przf.getBtnZapamtiIzmene().setEnabled(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(przf, "Sistem ne moze da nadje sstavke zapisnika.", "OBAVESTENJE", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        przf.zapamtiIzmene(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    
                    zavrsiUredjivanjeTabela();
                    
                    zaIzmenu = odabranZapisnik;
                    if(zaIzmenu.getDatumPocetka()==null || zaIzmenu.getDatumZavrsetka()==null){
                        JOptionPane.showMessageDialog(przf, "Datumi moraju biti uneti.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(zaIzmenu.getDatumPocetka().isAfter(zaIzmenu.getDatumZavrsetka())){
                        JOptionPane.showMessageDialog(przf, "Datum pocetka ne moze biti pre datuma zavrsetka.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(zaIzmenu.getBrojgrupa()<=0){
                        JOptionPane.showMessageDialog(przf, "Broj grupa mora biti veci od 0.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(odabranaSStavka != null){
                        if(odabranaSStavka.getPoeneIzBloka()<=0){
                            JOptionPane.showMessageDialog(przf, "Broj poena iz bloka mora biti veci od 0.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    
                        if(odabranaSStavka.getPoeneIzIgre()<=0){
                            JOptionPane.showMessageDialog(przf, "Broj poena iz igre mora biti veci od 0.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    
                        if(odabranaSStavka.getPoeneSaServisa()<=0){
                            JOptionPane.showMessageDialog(przf, "Broj poena sa servisa mora biti veci od 0.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    
                        if(odabranaSStavka.getUkupnoPoena()<=0){
                            JOptionPane.showMessageDialog(przf, "Broj ukupnih poena mora biti veci od 0.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    
                    if(odabranaStavka != null){
                        ModelTabeleSStavkaIzmena sstavke = (ModelTabeleSStavkaIzmena)przf.getTabelaSStavkaZapisnika().getModel();
                        sstavkeZaIzmenu = sstavke.getListaSStavkeZapisnika();
                        odabranaStavka.setSStavka(sstavkeZaIzmenu);
                    }

                    ModelTabeleStavka stavke = (ModelTabeleStavka) przf.getTabelaStavkaZapisnika().getModel();
                    stavkeZaIzmenu = stavke.getListaStavkeZapisnika();
                    zaIzmenu.setStavka(stavkeZaIzmenu);
                    
                    boolean rezultat = komunikacija.Komunikacija.getInstance().promeniZapisnik(zaIzmenu);
                    if(rezultat){
                        JOptionPane.showMessageDialog(przf, "Sistem je zapamtio zapisnik.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        srediFormu();
                    }
                    else{
                        JOptionPane.showMessageDialog(przf, "Sistem ne moze da zapamti izmene.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }
                    
                } catch (Exception er) {
                    JOptionPane.showMessageDialog(przf, "Sistem ne moze da zapamti zapisnik.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
    }
    
    
    private List<Zapisnik> ucitajSveZapisnike(){
        ulogovan = kordinatorFormi.Kordinator.getInstance().getUlogovani();
        sviZapisnici = komunikacija.Komunikacija.getInstance().ucitajZapisnike();
        return sviZapisnici;
    }
    
    public void srediFormu(){
        ucitajSveZapisnike();
        
        przf.getCBAnaliticar().setSelectedItem(null);
        przf.getCBDelegat().setSelectedItem(null);
        
        przf.getBtnOdaberiZapisnik().setEnabled(false);
        przf.getBtnZapamtiIzmene().setEnabled(false);
        przf.getBtnOdaberiStavkuZapisnika().setEnabled(false);
        przf.getBtnOdaberiSStavkuZapisnika().setEnabled(false);
        
        przf.getTabelaZapisnici().setModel(new ModelTabeleZapisniciIzmena(sviZapisnici));
        przf.getTabelaStavkaZapisnika().setModel(new ModelTabeleStavka(new ArrayList<>()));
        przf.getTabelaSStavkaZapisnika().setModel(new ModelTabeleSStavkaIzmena(new ArrayList<>()));
        przf.getTxtDatumDo().setText("");
        przf.getTxtDatumOd().setText("");
        odabranZapisnik=null;
        odabranaSStavka=null;
        odabranaStavka=null;
    }
    
    private void pripremiCB(){
        List<Analiticar> zaCBAnaliticar = komunikacija.Komunikacija.getInstance().ucitajAnaliticare();
        List<Delegat> zaCBDelegat = komunikacija.Komunikacija.getInstance().ucitajDelegate();

        for(int i=0;i<zaCBAnaliticar.size();i++){
            przf.getCBAnaliticar().addItem(zaCBAnaliticar.get(i));
        }
        
        for(int i=0;i<zaCBDelegat.size();i++){
            przf.getCBDelegat().addItem(zaCBDelegat.get(i));
        }
    }
    
    
    private void validirajDatumOd() {
        String unos = przf.getTxtDatumOd().getText().trim();
        if(unos.isEmpty()){return;}
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(unos, formatter);
            przf.getTxtDatumOd().setBackground(Color.WHITE);
            przf.getBtnFilteri().setEnabled(true);
        } catch (Exception e) {
            przf.getTxtDatumOd().setBackground(new Color(255, 150, 150));
            przf.getBtnFilteri().setEnabled(false);
        }
    }
    
    private void validirajDatumDo() {
        String unos = przf.getTxtDatumDo().getText().trim();
        if(unos.isEmpty()){return;}
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(unos, formatter);
            przf.getTxtDatumDo().setBackground(Color.WHITE);
            przf.getBtnFilteri().setEnabled(true);
        } catch (Exception e) {
            przf.getTxtDatumDo().setBackground(new Color(255, 150, 150));
            przf.getBtnFilteri().setEnabled(false);
        }
    }
    
    private void zavrsiUredjivanjeTabela() {

        if (przf.getTabelaZapisnici().isEditing()) {
            przf.getTabelaZapisnici().getCellEditor().stopCellEditing();
        }

        if (przf.getTabelaStavkaZapisnika().isEditing()) {
            przf.getTabelaStavkaZapisnika().getCellEditor().stopCellEditing();
        }

        if (przf.getTabelaSStavkaZapisnika().isEditing()) {
            przf.getTabelaSStavkaZapisnika().getCellEditor().stopCellEditing();
        }
    }
    
}

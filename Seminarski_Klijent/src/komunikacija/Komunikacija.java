/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.net.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import modeli.Analiticar;
import modeli.Delegat;
import modeli.Igrac;
import modeli.Kvalifikacija;
import modeli.Mesto;
import modeli.Tim;
import modeli.Zapisnik;
import modeli.StavkaZapisnika;
import modeli.SStavkaZapisnika;

/**
 *
 * @author Katarina
 */
public class Komunikacija {
    private Socket s;
    private Primalac primalac;
    private Posiljalac posiljalac;
    private static Komunikacija instance;
    
    private Komunikacija(){}
    
    public static Komunikacija getInstance(){
        if(instance==null){
            instance=new Komunikacija();
        }
        return instance;
    }
    
    public void konekcija(){
        try {
            s = new Socket("localhost",9000);
            primalac = new Primalac(s);
            posiljalac = new Posiljalac(s);
        } catch (IOException ex) {
            System.out.println("GRESKA PRI KONEKCIJI");
            //Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Analiticar login(String username,String password){
        Analiticar a = new Analiticar(-1, null, null, null, username, password);
        Zahtev z = new Zahtev(Operacija.PRIJAVI_ANALITICARA, a);
        posiljalac.posalji(z);
        Odgovor odg = (Odgovor) primalac.primi();

        if (odg == null || odg.getOdgovor() == null) {
            return null;
        }

        Object odgovor = odg.getOdgovor();
        if (!(odgovor instanceof Analiticar)) {
            return null;
        }
        return (Analiticar) odgovor;

    }
    
    
    
    public List<Delegat> ucitajDelegate() {
        List<Delegat> delegati = new LinkedList<>();
        Zahtev z=new Zahtev(Operacija.UCITAJ_DELEGATE, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        delegati=(List<Delegat>) odg.getOdgovor();
        return delegati;
    }
    
    public List<Analiticar> ucitajAnaliticare() {
        List<Analiticar> analiticari = new LinkedList<>();
        Zahtev z=new Zahtev(Operacija.UCITAJ_ANALITICARE, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        analiticari=(List<Analiticar>) odg.getOdgovor();
        return analiticari;
    }
    
    public List<Kvalifikacija> ucitajKvalifikacije() {
        List<Kvalifikacija> kvalifikacije=new LinkedList<>();
        Zahtev z=new Zahtev(Operacija.UCITAJ_KVALIFIKACIJE, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        kvalifikacije=(List<Kvalifikacija>) odg.getOdgovor();
        return kvalifikacije;
    }
    
    public List<Mesto> ucitajMesta() {
        List<Mesto> mesta=new LinkedList<>();
        Zahtev z=new Zahtev(Operacija.UCITAJ_MESTA, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        mesta=(List<Mesto>) odg.getOdgovor();
        return mesta;
    }
    
    public List<Igrac> ucitajIgrace() {
        List<Igrac> igraci=new LinkedList<>();
        Zahtev z=new Zahtev(Operacija.UCITAJ_IGRACE, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        igraci=(List<Igrac>) odg.getOdgovor();
        return igraci;
    }
    
    public List<Tim> ucitajTim() {
        List<Tim> timovi=new LinkedList<>();
        Zahtev z=new Zahtev(Operacija.UCITAJ_TIMOVE, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        timovi=(List<Tim>) odg.getOdgovor();
        return timovi;
    }
    
    public List<Zapisnik> ucitajZapisnike() {
        List<Zapisnik> zapisnici = new LinkedList<>();
        Zahtev z=new Zahtev(Operacija.UCITAJ_ZAPISNIKE, null);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
        zapisnici=(List<Zapisnik>) odg.getOdgovor();
        System.out.println(zapisnici.size());
        return zapisnici;
    }
    
    
    public List<Analiticar> pretraziAnaliticarePoKriterijumima(Map<String,Object> kriterijumi) {
        Zahtev z = new Zahtev(Operacija.PRETRAZI_ANALITICARE_PO_KRITERIJUMU, kriterijumi);
        posiljalac.posalji(z);
        Odgovor odg = (Odgovor) primalac.primi();
        return (List<Analiticar>) odg.getOdgovor();
    }
    
    public Analiticar pretragaAnaliticaraPOKriterijumu(Map<String,Object> kriterijum) {
        Zahtev z = new Zahtev(Operacija.PRETRAZI_ANALITICARE_PO_KRITERIJUMU2, kriterijum);
        posiljalac.posalji(z);
        Odgovor odg = (Odgovor) primalac.primi();
        return (Analiticar) odg.getOdgovor();    
    }
    
    
    
    public List<Zapisnik> pretragaZapisnikaPOKriterijumima(Map<String,Object> kriterijumi) {
        Zahtev z = new Zahtev(Operacija.PRETRAZI_ZAPISNIKE_PO_KRITERIJUMU, kriterijumi);
        posiljalac.posalji(z);
        Odgovor odg = (Odgovor) primalac.primi();
        return (List<Zapisnik>) odg.getOdgovor();
    }
    
    public List<StavkaZapisnika> pretragaZapisnikaPOKriterijumu(Map<String,Object> kriterijum) {
        Zahtev z = new Zahtev(Operacija.PRETRAZI_ZAPISNIKE_PO_KRITERIJUMU2, kriterijum);
        posiljalac.posalji(z);
        Odgovor odg = (Odgovor) primalac.primi();
        return (List<StavkaZapisnika>)odg.getOdgovor();    
    }
    
    public boolean promeniZapisnik(Zapisnik zapisnik){
        Zahtev zahtev=new Zahtev(Operacija.PROMENI_ZAPISNIK, zapisnik);
        posiljalac.posalji(zahtev);
        Odgovor odgovor=(Odgovor) primalac.primi();
        /*if (odgovor.getOdgovor() != null && odgovor.getOdgovor() instanceof Boolean && (Boolean) odgovor.getOdgovor()) {
            System.out.println("Sistem je izmenio zapisnik");
        }else{
            System.out.println("Sistem ne moze da izmeni zapisnik");
        } */
        return (boolean)odgovor.getOdgovor();
    }
    
    public List<Delegat> pretragaDelegataPOKriterijumima(Map<String,Object> kriterijumi) {
        Zahtev z = new Zahtev(Operacija.PRETRAZI_DELEGATE_PO_KRITERIJUMU, kriterijumi);
        posiljalac.posalji(z);
        Odgovor odg = (Odgovor) primalac.primi();
        return (List<Delegat>) odg.getOdgovor();
    }
    
    public Delegat pretragaDelegataPOKriterijumu(Map<String,Object> kriterijum) 
    {
        Zahtev z = new Zahtev(Operacija.PRETRAZI_DELEGATE_PO_KRITERIJUMU2, kriterijum);
        posiljalac.posalji(z);
        Odgovor odg = (Odgovor) primalac.primi();
        return (Delegat) odg.getOdgovor(); 
    }

    
    
    public boolean obrisiDelegata(Delegat d) {
        Zahtev z = new Zahtev(Operacija.OBRISI_DELEGATA, d);
        posiljalac.posalji(z);
        Odgovor odg = (Odgovor) primalac.primi();
        if (odg.getOdgovor() instanceof Boolean) {
            return (Boolean) odg.getOdgovor();
        }
        return false;
}
    
    
    
    public void kreirajTim(Tim t) {
        Zahtev z=new Zahtev(Operacija.KREIRAJ_TIM,t);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();  
    }
    
    public void kreirajMesto(Mesto m) {
        Zahtev z=new Zahtev(Operacija.KREIRAJ_MESTO,m);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
    }
    
    public void kreirajIgraca(Igrac i) {
        Zahtev z=new Zahtev(Operacija.KREIRAJ_IGRACA,i);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
    }
    
    public void kreirajZapisnik(Zapisnik zap) {
        Zahtev z=new Zahtev(Operacija.KREIRAJ_ZAPISNIK,zap);
        posiljalac.posalji(z);
        Odgovor odg=(Odgovor) primalac.primi();
    }
}

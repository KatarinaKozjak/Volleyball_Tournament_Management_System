/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.net.*;
import komunikacija.Odgovor;
import komunikacija.Operacija;

import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;
import modeli.Analiticar;
import modeli.Delegat;
import modeli.Igrac;
import modeli.Kvalifikacija;
import modeli.Mesto;
import modeli.StavkaZapisnika;
import modeli.Tim;
import modeli.Zapisnik;

/**
 *
 * @author Katarina
 */
public class Obrada_Klijentskih_Zahteva extends Thread{
    private Socket s;
    private Posiljalac posiljalac;
    private Primalac primalac;
    private boolean kraj = false;
    
    public Obrada_Klijentskih_Zahteva(Socket s) {
        this.s = s;
        this.posiljalac = new Posiljalac(s);
        this.primalac = new Primalac(s);
    }
    
    @Override
    public void run(){
        while(!kraj){
            try {
                Zahtev zahtev = (Zahtev) primalac.primi();
                Odgovor odgovor = new Odgovor();
                
                if(zahtev == null){
                    System.out.println("Klijent se odvezao.");
                    zaustaviKlijenta();
                }
                
                try {
                    switch(zahtev.getOperacija()){
                        //-------------------Prijava------------------------------------
                        case Operacija.PRIJAVI_ANALITICARA:
                            Analiticar a = (Analiticar) zahtev.getParametar();
                            Analiticar prijavljeni = controller.ServerController.getInstance().prijaviAnaliticar(a);
                            odgovor.setOdgovor(prijavljeni);
                            break;
                        //---------------Ucitavanje-------------------------------------
                        case Operacija.UCITAJ_ANALITICARE:
                            List<Analiticar> analiticari = controller.ServerController.getInstance().ucitajAnaliticare();
                            odgovor.setOdgovor(analiticari);
                            break;
                        case Operacija.UCITAJ_DELEGATE:
                            List<Delegat> delegati = controller.ServerController.getInstance().ucitajDelegate();
                            odgovor.setOdgovor(delegati);
                            break;
                        case Operacija.UCITAJ_IGRACE:
                            List<Igrac> igraci = controller.ServerController.getInstance().ucitajIgrace();
                            odgovor.setOdgovor(igraci);
                            break;
                        case Operacija.UCITAJ_KVALIFIKACIJE:
                            List<Kvalifikacija> kvalifikacije = controller.ServerController.getInstance().ucitajKvalifikacije();
                            odgovor.setOdgovor(kvalifikacije);
                            break;
                        case Operacija.UCITAJ_MESTA:
                            List<Mesto> mesta = controller.ServerController.getInstance().ucitajMesta();
                            odgovor.setOdgovor(mesta);
                            break;
                        case Operacija.UCITAJ_TIMOVE:
                            List<Tim> timovi = controller.ServerController.getInstance().ucitajTimove();
                            odgovor.setOdgovor(timovi);
                            break;
                        case Operacija.UCITAJ_ZAPISNIKE:
                            List<Zapisnik> zapisnici = controller.ServerController.getInstance().ucitajZapisnike();
                            odgovor.setOdgovor(zapisnici);
                            break;
                        //-------------------------Dodavanje-----------------------------------------
                        case Operacija.KREIRAJ_MESTO:
                            Mesto m = (Mesto) zahtev.getParametar();
                            controller.ServerController.getInstance().kreirajMesto(m);
                            odgovor.setOdgovor(null);
                            break;
                        case Operacija.KREIRAJ_TIM:
                            Tim t = (Tim) zahtev.getParametar();
                            controller.ServerController.getInstance().kreirajTim(t);
                            odgovor.setOdgovor(null);
                            break;
                        case Operacija.KREIRAJ_ZAPISNIK:
                            Zapisnik z = (Zapisnik) zahtev.getParametar();
                            controller.ServerController.getInstance().kreirajZapisnik(z);
                            odgovor.setOdgovor(null);
                            break;
                        case Operacija.KREIRAJ_IGRACA:
                            Igrac i = (Igrac) zahtev.getParametar();
                            controller.ServerController.getInstance().ubaciIgrac(i);
                            odgovor.setOdgovor(null);
                            break;
                        //-------------------------Pretraga po kriterijumima---------------------------------
                        case Operacija.PRETRAZI_ANALITICARE_PO_KRITERIJUMU:
                            Object parametarAnaliticar = zahtev.getParametar();
                            HashMap<String, Object> kriterijumiAnaliticar = (HashMap<String, Object>) parametarAnaliticar;
                            List<Analiticar> AnaliticarPoKriterijumu = controller.ServerController.getInstance().pretraziAnaliticarPoKriterijumima(kriterijumiAnaliticar);
                            odgovor.setOdgovor(AnaliticarPoKriterijumu);
                            break;
                        case Operacija.PRETRAZI_DELEGATE_PO_KRITERIJUMU:
                            Object parametarDelegat = zahtev.getParametar();
                            HashMap<String, Object> kriterijumiDelegat = (HashMap<String, Object>) parametarDelegat;
                            List<Delegat> DelegatPoKriterijumu = controller.ServerController.getInstance().pretraziDelegatPoKriterijumima(kriterijumiDelegat);
                            odgovor.setOdgovor(DelegatPoKriterijumu);
                            break;
                        case Operacija.PRETRAZI_ZAPISNIKE_PO_KRITERIJUMU:
                            Object parametarZapisnik = zahtev.getParametar();
                            HashMap<String, Object> kriterijumiZapisnik = (HashMap<String, Object>) parametarZapisnik;
                            List<Zapisnik> ZapisnikPoKriterijumu = controller.ServerController.getInstance().pretraziZapsnikPoKriterijumima(kriterijumiZapisnik);
                            odgovor.setOdgovor(ZapisnikPoKriterijumu);
                            break;
                        case Operacija.PRETRAZI_ZAPISNIKE_PO_KRITERIJUMU2:
                            Object parametarZapisnik2 = zahtev.getParametar();
                            HashMap<String, Object> kriterijumiZapisnik2 = (HashMap<String, Object>) parametarZapisnik2;
                            List<StavkaZapisnika> ZapisnikPoKriterijumu2 = controller.ServerController.getInstance().pretraziZapsnikPoKriterijumima2(kriterijumiZapisnik2);
                            odgovor.setOdgovor(ZapisnikPoKriterijumu2);
                            break;
                        //------------------------------Izmena-------------------------------------
                        case Operacija.PROMENI_ZAPISNIK:
                            Zapisnik zapisnikZaIzmenu = (Zapisnik) zahtev.getParametar();
                            boolean uspelo = false;
                            uspelo=controller.ServerController.getInstance().izmeniZapisnik(zapisnikZaIzmenu);
                            odgovor.setOdgovor(uspelo);
                            break;
                        //--------------------Brisanje----------------------------
                        case Operacija.OBRISI_DELEGATA:
                            Delegat delegatZaBrisanje = (Delegat) zahtev.getParametar();
                            boolean uspesno = controller.ServerController.getInstance().obrisiDelegat(delegatZaBrisanje);
                            odgovor.setOdgovor(uspesno);
                            break;
                        default:
                            System.out.println("Nepoznata operacija: " + zahtev.getOperacija());
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    odgovor.setOdgovor(e);
                }
                posiljalac.posalji(odgovor);
            } catch (Exception ex) {
                Logger.getLogger(Obrada_Klijentskih_Zahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    
    
    
    public void zaustaviKlijenta() {
        kraj = true;
        try {
            s.close();
        } catch (IOException ex) {
            System.out.println("Greška prilikom zatvaranja soketa");
        }
        interrupt();
    }
}

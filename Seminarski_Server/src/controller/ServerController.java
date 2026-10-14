/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.Map;
import modeli.Analiticar;
import modeli.Delegat;
import modeli.Igrac;
import modeli.Kvalifikacija;
import modeli.Mesto;
import modeli.StavkaZapisnika;
import modeli.Tim;
import modeli.Zapisnik;
import operacije.UbaciMestoSO;
import operacije.UbaciTimSO;
import operacije.UbaciZapisnikSO;
import operacije.ObrisiDelegatSO;
import operacije.PretraziAnaliticarPoKriterijumimaSO;
import operacije.PretraziDelegatPoKriterijumimaSO;
import operacije.PretraziZapisnikPoKriterijumimaSO;
import operacije.PretragaZapisnikaPoKriterijumuSO;
import operacije.PrijaviAnaliticarSO;
import operacije.PromeniZapisnikSO;
import operacije.UbaciIgracSO;
import operacije.UcitajAnaliticareSO;
import operacije.UcitajDelegateSO;
import operacije.UcitajIgraceSO;
import operacije.UcitajKvalifikacijeSO;
import operacije.UcitajMestaSO;
import operacije.UcitajTimoveSO;
import operacije.UcitajZapisnikeSO;

/**
 *
 * @author Katarina
 */
public class ServerController {
    private static ServerController instance;
    
    private ServerController(){}
    
    public static ServerController getInstance(){
        if(instance==null){
            instance = new ServerController();
        }
        return instance;
    }
    
    //------Prijava------------------
    public Analiticar prijaviAnaliticar(Analiticar a)throws Exception{
        PrijaviAnaliticarSO so = new PrijaviAnaliticarSO();
        so.izvrsi(a, null);
        return so.getAnaliticar();
    }
    
    //--------------Ucitavanje-----------------
    public List<Mesto> ucitajMesta(){
        try {
            UcitajMestaSO uso=new UcitajMestaSO();
            uso.izvrsi(null, null);
            //System.out.println("controller server klijenti: "+uso.getMesta());
            return uso.getMesta();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Tim> ucitajTimove(){
        try {
            UcitajTimoveSO uso=new UcitajTimoveSO();
            uso.izvrsi(null, null);
            return uso.getTimovi();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Zapisnik> ucitajZapisnike(){
        try {
            UcitajZapisnikeSO uso=new UcitajZapisnikeSO();
            uso.izvrsi(null, null);
            return uso.getListaZapisnika();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Kvalifikacija> ucitajKvalifikacije(){
        try {
            UcitajKvalifikacijeSO uso=new UcitajKvalifikacijeSO();
            uso.izvrsi(null, null);
            return uso.getKvalifikacije();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Igrac> ucitajIgrace(){
        try {
            UcitajIgraceSO uso=new UcitajIgraceSO();
            uso.izvrsi(null, null);
            return uso.getIgraci();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Delegat> ucitajDelegate(){
        try {
            UcitajDelegateSO uso=new UcitajDelegateSO();
            uso.izvrsi(null, null);
            return uso.getDelegati();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Analiticar> ucitajAnaliticare(){
        try {
            UcitajAnaliticareSO uso=new UcitajAnaliticareSO();
            uso.izvrsi(null, null);
            return uso.getAnaliticari();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //--------Brisanje------------------
    public boolean obrisiDelegat(Delegat d) throws Exception {
        ObrisiDelegatSO oso = new ObrisiDelegatSO();
        oso.izvrsi(d, null);
        return true;
    }
    
    //--------------Dodavanje----------------------
    public boolean kreirajMesto(Mesto m) {
         try {
            UbaciMestoSO kso=new UbaciMestoSO();
            kso.izvrsi(m,null);
            return true;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean kreirajTim(Tim t) {
         try {
            UbaciTimSO kso=new UbaciTimSO();
            kso.izvrsi(t,null);
            return true;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean kreirajZapisnik(Zapisnik z) {
         try {
            UbaciZapisnikSO kso=new UbaciZapisnikSO();
            kso.izvrsi(z,null);
            return true;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean ubaciIgrac(Igrac i) {
         try {
            UbaciIgracSO uso=new UbaciIgracSO();
            uso.izvrsi(i,null);
            return true;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //------------Pretraga po kriterijumima-------------------
    public List<Zapisnik> pretraziZapsnikPoKriterijumima(Map<String,Object> kriterijumi) {
        try {
            PretraziZapisnikPoKriterijumimaSO pkso = new PretraziZapisnikPoKriterijumimaSO();
            pkso.izvrsi(null, kriterijumi);
            return pkso.getZapisnici();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<StavkaZapisnika> pretraziZapsnikPoKriterijumima2(Map<String,Object> kriterijumi) {
        try {
            PretragaZapisnikaPoKriterijumuSO pkso = new PretragaZapisnikaPoKriterijumuSO();
            pkso.izvrsi(null, kriterijumi);
            return pkso.getStavke();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Delegat> pretraziDelegatPoKriterijumima(Map<String,Object> kriterijumi) {
        try {
            PretraziDelegatPoKriterijumimaSO pkso = new PretraziDelegatPoKriterijumimaSO();
            pkso.izvrsi(null, kriterijumi);
            return pkso.getDelegati();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Analiticar> pretraziAnaliticarPoKriterijumima(Map<String,Object> kriterijumi) {
        try {
            PretraziAnaliticarPoKriterijumimaSO pkso = new PretraziAnaliticarPoKriterijumimaSO();
            pkso.izvrsi(null, kriterijumi);
            return pkso.getAnaliticari();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //------------------------Izmene------------------------------
    
    public boolean izmeniZapisnik(Zapisnik z) {
         try {
            PromeniZapisnikSO prso=new PromeniZapisnikSO();
            prso.izvrsi(z,null);
            return true;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kordinatorFormi;

import controller.BrisanjeDelegataController;
import controller.GlavnaController;
import controller.UbaciMestoController;
import controller.UbaciTimController;
import controller.UbacivanjeZapisnikaController;
import controller.LoginController;
import controller.PregledZapisnikaController;
import controller.PromenaZapisnikaController;
import controller.PretragaAnaliticaraController;
import controller.UbacivanjeIgracaController;
import forme.BrisanjeDelegataForma;
import forme.GlavnaForma;
import forme.UbaciTim;
import forme.LoginForma;
import forme.UbacivanjeZapisnika;
import forme.PretragaAnaliticara;
import forme.UbacivanjeMesta;
import forme.PregledZapisnika;
import forme.UbacivanjeIgraca;
import forme.PromenaZapisnika;
import modeli.Analiticar;
import modeli.Delegat;
import modeli.Zapisnik;

/**
 *
 * @author Katarina
 */
public class Kordinator {
    private Analiticar ulogovani;
    private static Kordinator instance;
    
    private Zapisnik izabranZapisnik;
    private Delegat izabranDelegat;
    
    
    LoginController loginController;
    GlavnaController glavnaController;
    UbacivanjeZapisnikaController kreiranjeZapisnikaController;
    BrisanjeDelegataController brisanjeDelegataController;
    PretragaAnaliticaraController pretragaAnaliticaraController;
    PregledZapisnikaController pregledZapisnikaController;
    UbaciTimController kreirajTimController; 
    UbaciMestoController ubaciMestoController;
    UbacivanjeIgracaController ubacivanjeIgracaController;
    PromenaZapisnikaController promenaZapisnikaController;
    
    //private Delegat izabraniDelegat;
    //private Analiticar izabraniAnaliticar;
    
    private Kordinator(){}
    
    public static Kordinator getInstance(){
        if(instance==null){
            instance=new Kordinator();
        }
        return instance;
    }
    
    public Analiticar getUlogovani(){return ulogovani;}
    
    public void setUlogovani(Analiticar ulogovan){this.ulogovani=ulogovan;}
    
    public Zapisnik getZapisnik(){return izabranZapisnik;}
    
    public void setZapisnik(Zapisnik z){this.izabranZapisnik=z;}
    
    public Delegat getDelegat(){return izabranDelegat;}
    
    public void setDelegat(Delegat d){this.izabranDelegat=d;}
    
    public void otvoriLoginFormu() {
        loginController=new LoginController(new LoginForma());
        loginController.otvori();
    }
    
    public void otvoriGF() {
        glavnaController = new GlavnaController(new GlavnaForma());
        glavnaController.otvori();
    }
    
    public void otvoriKreiranjeZapisnikaF()
    {
        kreiranjeZapisnikaController = new UbacivanjeZapisnikaController(new UbacivanjeZapisnika());
        kreiranjeZapisnikaController.otvori();
    }
    
    public void otvoriBrisanjeDelegataF()
    {
        brisanjeDelegataController = new BrisanjeDelegataController(new BrisanjeDelegataForma());
        brisanjeDelegataController.otvori();
    }
    
    public void otvoriPretragaAnaliticaraF(){
        pretragaAnaliticaraController = new PretragaAnaliticaraController(new PretragaAnaliticara());
        pretragaAnaliticaraController.otvori();
    }
    
    public void otvoriKreirajTimF(){
        kreirajTimController = new UbaciTimController(new UbaciTim());
        kreirajTimController.otvori();
    }
    
    public void otvoriKreirajMestoF(){
        ubaciMestoController = new UbaciMestoController(new UbacivanjeMesta());
        ubaciMestoController.otvori();
    }
    
    public void otvoriUbacivanjeIgracaF(){
        ubacivanjeIgracaController = new UbacivanjeIgracaController(new UbacivanjeIgraca());
        ubacivanjeIgracaController.otvori();
    }
    
    public void otvoriPretragaZapisnikaF(){
        pregledZapisnikaController = new PregledZapisnikaController(new PregledZapisnika());
        pregledZapisnikaController.otvori();
    }
    
    public void otvoriPromenaZapisnikaF(){
        promenaZapisnikaController = new PromenaZapisnikaController(new PromenaZapisnika());
        promenaZapisnikaController.otvori();
    }
    
}

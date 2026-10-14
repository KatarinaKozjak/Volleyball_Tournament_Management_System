/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.LinkedList;
import java.util.List;
import modeli.Kvalifikacija;

/**
 *
 * @author Katarina
 */
public class UcitajKvalifikacijeSO extends Apstraktna_Genericka_Operacija{
    private List<Kvalifikacija> kvalifikacije = new LinkedList<>();
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        //Nema posebnih preduslova
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{
        Kvalifikacija kvalifikacija = new Kvalifikacija();

        String upit = "SELECT * FROM " + kvalifikacija.vratiNazivTabele();

        if (kljuc != null && !kljuc.toString().trim().isEmpty()) {
            String uslov = kljuc.toString();
            if (!uslov.trim().toUpperCase().startsWith("WHERE")) {
                upit += " WHERE " + uslov;
            } else {
                upit += " " + uslov;
            }
        }
        kvalifikacije = broker.ucitajSve(kvalifikacija, upit);
    }
    
    public List<Kvalifikacija> getKvalifikacije(){
        return kvalifikacije;
    }
}

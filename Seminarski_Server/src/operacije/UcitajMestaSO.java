/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.LinkedList;
import java.util.List;
import modeli.Mesto;
/**
 *
 * @author Katarina
 */
public class UcitajMestaSO extends Apstraktna_Genericka_Operacija{

    private List<Mesto> mesta = new LinkedList<>();
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        //Nema posebnih preduslova
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{
        Mesto mesto = new Mesto();

        String upit ="SELECT * FROM " + mesto.vratiNazivTabele();

        if (kljuc != null && !kljuc.toString().trim().isEmpty()) {
            String uslov = kljuc.toString();
            if (!uslov.trim().toUpperCase().startsWith("WHERE")) {
                upit += " WHERE " + uslov;
            } else {
                upit += " " + uslov;
            }
        }
        mesta = broker.ucitajSve(mesto, upit);
    }
    
    public List<Mesto> getMesta(){
        return mesta;
    }
    
}

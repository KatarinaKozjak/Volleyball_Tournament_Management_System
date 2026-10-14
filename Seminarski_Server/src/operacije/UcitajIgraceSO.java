/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.LinkedList;
import java.util.List;
import modeli.Igrac;

/**
 *
 * @author Katarina
 */
public class UcitajIgraceSO extends Apstraktna_Genericka_Operacija{
    private List<Igrac> igraci = new LinkedList<>();
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        //Nema posebnih preduslova
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{
        Igrac igrac = new Igrac();
        String upit ="SELECT * FROM " + igrac.vratiNazivTabele();

        if (kljuc != null && !kljuc.toString().trim().isEmpty()) {
            String uslov = kljuc.toString();
            if (!uslov.trim().toUpperCase().startsWith("WHERE")) {
                upit += " WHERE " + uslov;
            } else {
                upit += " " + uslov;
            }
        }
        igraci = broker.ucitajSve(igrac, upit);
    }
    
    public List<Igrac> getIgraci(){
        return igraci;
    }
}

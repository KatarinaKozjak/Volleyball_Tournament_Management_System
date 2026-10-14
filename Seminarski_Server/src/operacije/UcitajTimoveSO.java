/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.LinkedList;
import java.util.List;
import modeli.Tim;

/**
 *
 * @author Katarina
 */
public class UcitajTimoveSO extends Apstraktna_Genericka_Operacija{
    private List<Tim> timovi = new LinkedList<>();
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        //Nema posebnih preduslova
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{
        Tim tim = new Tim();

        String upit = "SELECT * FROM tim";

        if (kljuc != null && !kljuc.toString().trim().isEmpty()) {
            String uslov = kljuc.toString();
            if (!uslov.trim().toUpperCase().startsWith("WHERE")) {
                upit += " WHERE " + uslov;
            } else {
                upit += " " + uslov;
            }
        }
        timovi = broker.ucitajSve(tim, upit);
    }
    
    public List<Tim> getTimovi(){
        return timovi;
    }
}

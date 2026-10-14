/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.LinkedList;
import java.util.List;
import modeli.Delegat;

/**
 *
 * @author Katarina
 */
public class UcitajDelegateSO extends Apstraktna_Genericka_Operacija{
    private List<Delegat> delegati = new LinkedList<>();
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        //Nema posebnih preduslova
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{
        Delegat delegat = new Delegat();
        String uslov = (String) kljuc;
        String upit ="SELECT delegat.Id_Delegat, delegat.Ime, delegat.Prezime, delegat.Id_Mesto, mesto.Naziv, mesto.Br_Stanovnika "+ "FROM delegat "+ "JOIN mesto ON delegat.Id_Mesto = mesto.Id_Mesto";

        if (uslov != null && !uslov.trim().isEmpty()) {
            if (!uslov.trim().toUpperCase().startsWith("WHERE")) {
                upit += " WHERE " + uslov;
            } else {
                upit += " " + uslov;
            }
        }
        delegati = broker.ucitajSve(delegat, upit);
    }
    
    public List<Delegat> getDelegati(){
        return delegati;
    }
}

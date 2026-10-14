/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modeli.Delegat;

/**
 *
 * @author Katarina
 */
public class PretraziDelegatPoKriterijumimaSO extends Apstraktna_Genericka_Operacija{
    private List<Delegat> delegati = new ArrayList<>();
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        ///////////// 
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc)  throws Exception{

        HashMap<String, Object> kriterijumi = (HashMap<String, Object>) kljuc;

        Integer id = (Integer) kriterijumi.get("delegat.Id_Delegat");
        String ime = (String) kriterijumi.get("delegat.Ime");
        String prezime = (String) kriterijumi.get("delegat.Prezime");
        String mesto = (String) kriterijumi.get("mesto.Naziv");

        StringBuilder uslov = new StringBuilder(" WHERE 1=1 ");

        if (ime != null && !ime.trim().isEmpty()) {
            uslov.append("AND delegat.Ime LIKE '%").append(ime).append("%' ");
        }
        if (prezime != null && !prezime.trim().isEmpty()) {
            uslov.append("AND delegat.Prezime LIKE '%").append(prezime).append("%' ");
        }
        if (mesto != null && !mesto.trim().isEmpty()) {
            uslov.append("AND mesto.Naziv = '").append(mesto).append("' ");
        }
        if (id != null) {
            uslov.append("AND delegat.Id_Delegat = ").append(id).append(" ");
        }
        
        String upit ="SELECT delegat.Id_Delegat, delegat.Ime, delegat.Prezime, delegat.Id_Mesto, mesto.Naziv, mesto.Br_Stanovnika "
            + "FROM delegat " + "JOIN mesto ON delegat.Id_Mesto = mesto.Id_Mesto " + uslov;
        
        delegati = broker.ucitajSve(new Delegat(), upit);
    }

    public List<Delegat> getDelegati() {
        return delegati;
    }
}

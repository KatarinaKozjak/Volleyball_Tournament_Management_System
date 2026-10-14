/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modeli.Analiticar;
import modeli.Delegat;
import modeli.Zapisnik;

/**
 *
 * @author Katarina
 */
public class PretraziAnaliticarPoKriterijumimaSO extends Apstraktna_Genericka_Operacija{
    
    private List<Analiticar> analiticari = new ArrayList<>();
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        //  
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc)  throws Exception{
        
        HashMap<String, Object> kriterijumi = (HashMap<String, Object>) kljuc;

        String id = (String) kriterijumi.get("Id_Analiticar");
        String ime = (String) kriterijumi.get("Ime");
        String prezime = (String) kriterijumi.get("Prezime");
        String mejl = (String) kriterijumi.get("Email");
        Integer delegatId = (Integer) kriterijumi.get("Id_Delegat");


        StringBuilder uslov = new StringBuilder("WHERE 1=1");

        if (ime != null && !ime.trim().isEmpty()) {
            uslov.append(" AND analiticar.Ime LIKE '%").append(ime).append("%' ");
        }
        if (prezime != null && !prezime.trim().isEmpty()) {
            uslov.append(" AND analiticar.Prezime LIKE '%").append(prezime).append("%' ");
        }
        if (mejl != null && !mejl.trim().isEmpty()) {
            uslov.append(" AND analiticar.Email LIKE '%").append(mejl).append("%' ");
        }
        if (id != null) {
            uslov.append(" AND analiticar.Id_Analiticar = ").append(id).append(" ");
        }
        if(delegatId!=null){
            uslov.append(" AND delegat.Id_Delegat = ").append(delegatId).append(" ");
        }
        
        String upit ="SELECT DISTINCT analiticar.Id_Analiticar, analiticar.Ime, analiticar.Prezime, analiticar.Email, analiticar.Username, analiticar.Password "
                + "FROM analiticar "
                + "LEFT JOIN zapisnik ON analiticar.Id_Analiticar = zapisnik.Id_Analiticar "
                + "LEFT JOIN delegat ON zapisnik.Id_Delegat = delegat.Id_Delegat " + uslov;

        analiticari = broker.ucitajSve(new Analiticar(), upit);
    }

    public List<Analiticar> getAnaliticari() {
        return analiticari;
    }
}

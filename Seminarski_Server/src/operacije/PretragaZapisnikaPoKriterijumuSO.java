/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modeli.StavkaZapisnika;
import modeli.SStavkaZapisnika;
import modeli.Zapisnik;

/**
 *
 * @author Katarina
 */
public class PretragaZapisnikaPoKriterijumuSO extends Apstraktna_Genericka_Operacija{
    
    private List<StavkaZapisnika> stavke = new ArrayList<>();
    
    @Override
    protected void preduslovi(Object param) throws Exception {
         
    }
    
    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc)  throws Exception{

        HashMap<String, Object> kriterijumi = (HashMap<String, Object>) kljuc;
        Integer idZap = (Integer) kriterijumi.get("Id_Zapisnik");
        String tim = (String) kriterijumi.get("Naziv");

        StringBuilder uslov = new StringBuilder(" WHERE 1=1 ");

        if (idZap != null) {
            uslov.append("AND sz.Id_Zapisnik = ").append(idZap).append(" ");
        }
        if (tim != null && !tim.trim().isEmpty()) {
            uslov.append("AND t.Naziv = '").append(tim).append("' ");
        }
        
        // 1. UCITAJ STAVKE ZAPISNIKA

        String upit = "SELECT sz.Id_Zapisnik, sz.RB_Stavke, sz.Mesto_na_rang_listi, sz.Id_Tim, t.Naziv "
            + "FROM stavka_zapisnika sz "
            + "JOIN tim t ON sz.Id_Tim = t.Id_Tim " + uslov;

        stavke = broker.ucitajSve(new StavkaZapisnika(),upit);

        // 2. ZA SVAKU STAVKU UCITAJ SSTAVKE

        for (StavkaZapisnika stavka : stavke) {

            String upitSStavke ="SELECT ss.Id_Zapisnik, ss.RB_Stavke, ss.RB_SStavke, ss.MVP_Turnira, ss.Poeni_iz_bloka, ss.Poeni_sa_servisa, "
                + "ss.Poeni_iz_igre, ss.Ukupno_Poena, ss.Id_Igrac, i.Ime, i.Prezime "
                + "FROM sstavka_zapisnika ss "
                + "JOIN igrac i ON ss.Id_Igrac = i.Id_Igrac "
                + "WHERE ss.Id_Zapisnik = " + stavka.getZapisnik().getIdZapisnika()
                + " AND ss.RB_Stavke = " + stavka.getRB();


            List<SStavkaZapisnika> sstavke = broker.ucitajSve(new SStavkaZapisnika(),upitSStavke);
            
            for (SStavkaZapisnika sstavka : sstavke) {
                sstavka.setZapisnik(stavka.getZapisnik());
                sstavka.setStavkaZapisnika(stavka);
            }
            
            stavka.setSStavka(sstavke);
        }     
    }
    
    public List<StavkaZapisnika> getStavke() {
        return stavke;
    }
}

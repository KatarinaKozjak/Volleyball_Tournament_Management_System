/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modeli.Zapisnik;
import modeli.StavkaZapisnika;
import modeli.SStavkaZapisnika;

/**
 *
 * @author Katarina
 */
public class PretraziZapisnikPoKriterijumimaSO extends Apstraktna_Genericka_Operacija{
    
    private List<Zapisnik> zapisnici = new ArrayList<>();
    
    @Override
    protected void preduslovi(Object param) throws Exception {
         
    }
    
    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{

        HashMap<String, Object> kriterijumi = (HashMap<String, Object>) kljuc;

        String datumOd = (String) kriterijumi.get("Datum_Pocetka");
        String datumDo = (String) kriterijumi.get("Datum_Zavrsetka");
        Integer idAnaliticar = (Integer) kriterijumi.get("Id_Analiticar");
        Integer idDelegat = (Integer) kriterijumi.get("Id_Delegat");

        StringBuilder uslov = new StringBuilder(" WHERE 1=1 ");

        if (datumDo != null && !datumDo.trim().isEmpty()) {
            uslov.append(" AND z.Datum_Pocetka <= '").append(datumDo).append("' ");
        }
        if (datumOd != null && !datumOd.trim().isEmpty()) {
            uslov.append(" AND z.Datum_Zavrsetka >= '").append(datumOd).append("' ");
        }
        if (idAnaliticar != null) {
            uslov.append(" AND z.Id_Analiticar = ").append(idAnaliticar).append(" ");
        }
        if (idDelegat != null) {
            uslov.append(" AND z.Id_Delegat = ").append(idDelegat).append(" ");
        }
        
        // 1. UCITAVANJE ZAPISNIKA
        
        String upit ="SELECT z.Id_Zapisnik, z.Datum_Pocetka, z.Datum_Zavrsetka, z.Broj_Grupa, a.Id_Analiticar, "
                + "a.Ime, a.Prezime, a.Email, a.Username, a.Password, d.Id_Delegat, d.Ime, d.Prezime, m.Id_Mesto, m.Naziv, m.Br_Stanovnika "
                + "FROM zapisnik z "
                + "JOIN delegat d ON z.Id_Delegat = d.Id_Delegat "
                + "JOIN analiticar a ON z.Id_Analiticar = a.Id_Analiticar "
                + "JOIN mesto m ON d.Id_Mesto = m.Id_Mesto "+ uslov;
        
        zapisnici = broker.ucitajSve(new Zapisnik(), upit);
        
        // 2. ZA SVAKI ZAPISNIK UCITAJ STAVKE

        for (Zapisnik z : zapisnici) {

            String upitStavke = "SELECT sz.Id_Zapisnik, sz.RB_Stavke, sz.Mesto_na_rang_listi, sz.Id_Tim, t.Naziv "
                + "FROM stavka_zapisnika sz "
                + "JOIN tim t ON sz.Id_Tim = t.Id_Tim "
                + "WHERE sz.Id_Zapisnik = "
                + z.getIdZapisnika();


            List<StavkaZapisnika> stavke = broker.ucitajSve(new StavkaZapisnika(),upitStavke);

            // 3. ZA SVAKU STAVKU UCITAJ SSTAVKE

            for (StavkaZapisnika stavka : stavke) {
                stavka.setZapisnik(z);

                String upitSStavke = "SELECT ss.Id_Zapisnik, ss.RB_Stavke, ss.RB_SStavke, ss.MVP_Turnira, ss.Poeni_iz_bloka, ss.Poeni_sa_servisa, ss.Poeni_iz_igre, "
                    + "ss.Ukupno_Poena, ss.Id_Igrac, i.Ime, i.Prezime "
                    + "FROM sstavka_zapisnika ss "
                    + "JOIN igrac i ON ss.Id_Igrac = i.Id_Igrac "
                    + "WHERE ss.Id_Zapisnik = " + z.getIdZapisnika()
                    + " AND ss.RB_Stavke = " + stavka.getRB();


                List<SStavkaZapisnika> sstavke = broker.ucitajSve(new SStavkaZapisnika(),upitSStavke);
                
                for (SStavkaZapisnika sstavka : sstavke) {
                    sstavka.setZapisnik(z);
                    sstavka.setStavkaZapisnika(stavka);
                }
                
                stavka.setSStavka(sstavke);
            }
            // 4. DODAJEMO STAVKE U ZAPISNIK
            z.setStavka(stavke);
        }
        
    }
    
    public List<Zapisnik> getZapisnici() {
        return zapisnici;
    }
    
}

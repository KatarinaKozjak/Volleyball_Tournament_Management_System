/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.LinkedList;
import java.util.List;
import modeli.Zapisnik;
import modeli.StavkaZapisnika;
import modeli.SStavkaZapisnika;
import modeli.Apstraktni_Domenski_Objekat;

/**
 *
 * @author Katarina
 */
public class UcitajZapisnikeSO extends Apstraktna_Genericka_Operacija{
    
    private List<Zapisnik> listaZapisnika;

    public UcitajZapisnikeSO() {
        listaZapisnika = new LinkedList<>();
    }
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        // Nema posebnih preduslova
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{
        Zapisnik zapisnik = new Zapisnik();
        String uslov = null;

        if (kljuc != null) {
            uslov = kljuc.toString();
        }

        // ============================================================
        // 1. UCITAVANJE ZAPISNIKA
        // ============================================================

        String upitZapisnik ="SELECT z.Id_Zapisnik, z.Datum_Pocetka, z.Datum_Zavrsetka, z.Broj_Grupa, z.Id_Analiticar, a.Ime, a.Prezime, a.Email, a.Username, a.Password, "
                + "z.Id_Delegat, d.Ime, d.Prezime, d.Id_Mesto, m.Naziv, m.Br_Stanovnika "
                + "FROM zapisnik z "
                + "JOIN delegat d ON z.Id_Delegat = d.Id_Delegat JOIN analiticar a ON z.Id_Analiticar = a.Id_Analiticar JOIN mesto m ON d.Id_Mesto = m.Id_Mesto";

        if (uslov != null && !uslov.trim().isEmpty()) {
            if (!uslov.trim().toUpperCase().startsWith("WHERE")) {
                upitZapisnik += " WHERE " + uslov;
            } else {
                upitZapisnik += " " + uslov;
            }
        }

        System.out.println(upitZapisnik);

        List<Apstraktni_Domenski_Objekat> rezultatZapisnika = broker.ucitajSve(zapisnik,upitZapisnik);

        listaZapisnika = new LinkedList<>();

        // ============================================================
        // 2. ZA SVAKI ZAPISNIK UCITAJ STAVKE
        // ============================================================

        for (Apstraktni_Domenski_Objekat adoZapisnik : rezultatZapisnika) {

            Zapisnik z = (Zapisnik) adoZapisnik;

            String upitStavka ="SELECT sz.Id_Zapisnik, sz.RB_Stavke, sz.Mesto_na_rang_listi, sz.Id_Tim, t.Naziv "
                    + "FROM stavka_zapisnika sz "
                    + "JOIN tim t ON sz.Id_Tim = t.Id_Tim "
                    + "WHERE sz.Id_Zapisnik = " + z.getIdZapisnika();

            System.out.println(upitStavka);

            List<Apstraktni_Domenski_Objekat> rezultatStavke = broker.ucitajSve(new StavkaZapisnika(),upitStavka);

            List<StavkaZapisnika> stavke = new LinkedList<>();

            // ========================================================
            // 3. ZA SVAKU STAVKU UCITAJ SSTAVKE
            // ========================================================

            for (Apstraktni_Domenski_Objekat adoStavka : rezultatStavke) {

                StavkaZapisnika stavka = (StavkaZapisnika) adoStavka;

                stavka.setZapisnik(z);

                String upitSStavka ="SELECT ss.Id_Zapisnik, ss.RB_Stavke, ss.RB_SStavke, ss.MVP_Turnira, ss.Poeni_iz_bloka, "
                        + "ss.Poeni_sa_servisa, ss.Poeni_iz_igre, ss.Ukupno_Poena, ss.Id_Igrac, i.Ime, i.Prezime "
                        + "FROM sstavka_zapisnika ss "
                        + "JOIN igrac i ON ss.Id_Igrac = i.Id_Igrac "
                        + "WHERE ss.Id_Zapisnik = " + z.getIdZapisnika() + " AND ss.RB_Stavke = " + stavka.getRB();

                System.out.println(upitSStavka);

                List<Apstraktni_Domenski_Objekat> rezultatSStavke = broker.ucitajSve(new SStavkaZapisnika(),upitSStavka);

                List<SStavkaZapisnika> sstavke = new LinkedList<>();

                // ====================================================
                // 4. POVEZIVANJE SSTAVKI SA STAVKOM I ZAPISNIKOM
                // ====================================================

                for (Apstraktni_Domenski_Objekat adoSStavka : rezultatSStavke) {

                    SStavkaZapisnika sstavka = (SStavkaZapisnika) adoSStavka;

                    sstavka.setZapisnik(z);
                    sstavka.setStavkaZapisnika(stavka);

                    sstavke.add(sstavka);
                }

                stavka.setSStavka(sstavke);

                stavke.add(stavka);
            }

            // ========================================================
            // 5. STAVKE UBACUJEMO U ZAPISNIK
            // ========================================================

            z.setStavka(stavke);

            listaZapisnika.add(z);
        }
    }


    public List<Zapisnik> getListaZapisnika() {
        return listaZapisnika;
    }
}

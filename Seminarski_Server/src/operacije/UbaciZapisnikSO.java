/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.logging.Level;
import java.util.logging.Logger;
import modeli.Zapisnik;
import modeli.StavkaZapisnika;
import modeli.SStavkaZapisnika;

/**
 *
 * @author Katarina
 */
public class UbaciZapisnikSO extends Apstraktna_Genericka_Operacija{
    
    private int idZapisnika;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Zapisnik)){
            throw new Exception("Sistem ne može da ubaci zapisnik.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{
        
        Zapisnik zapisnik = (Zapisnik) param;
        
        // ========================================
        // 1. UBACIVANJE ZAPISNIKA
        // ========================================

        String upitZapisnik ="INSERT INTO "+ zapisnik.vratiNazivTabele()+ " ("+ zapisnik.vratiKoloneZaUbacivanje()+ ") VALUES ("+ zapisnik.vratiVrednostiZaUbacivanje()+ ")";
        System.out.println(upitZapisnik);
        idZapisnika = broker.dodaj(upitZapisnik);

        zapisnik.setIdZapisnika(idZapisnika);
        
        // ========================================
        // 2. ODREDJIVANJE MVP-A
        // ========================================

        odrediMVP(zapisnik);

        // ========================================
        // 3. UBACIVANJE STAVKI
        // ========================================

        if (zapisnik.getStavka() != null && !zapisnik.getStavka().isEmpty()) {
            int rbStavke = 1;

            for (StavkaZapisnika stavka : zapisnik.getStavka()) {
                stavka.setZapisnik(zapisnik);
                stavka.setRedniBrojStavke(rbStavke++);
                String upitStavka ="INSERT INTO "+ stavka.vratiNazivTabele()+ " ("+ stavka.vratiKoloneZaUbacivanje()+ ") VALUES ("+ stavka.vratiVrednostiZaUbacivanje()+ ")";
                System.out.println(upitStavka);
                broker.dodaj(upitStavka);

                // ========================================
                // 4. UBACIVANJE SSTAVKI
                // ========================================

                if (stavka.getSStavka() != null && !stavka.getSStavka().isEmpty()) {
                    int rbSStavke = 1;

                    for (SStavkaZapisnika sstavka : stavka.getSStavka()) {
                        sstavka.setStavkaZapisnika(stavka);
                        sstavka.setZapisnik(zapisnik);
                        sstavka.setRedniBrojSStavke(rbSStavke++);

                        String upitSStavka ="INSERT INTO "+ sstavka.vratiNazivTabele()+ " ("+ sstavka.vratiKoloneZaUbacivanje()+ ") VALUES ("+ sstavka.vratiVrednostiZaUbacivanje()+ ")";
                        System.out.println(upitSStavka);
                        broker.dodaj(upitSStavka);
                    }
                }
            }
        }
    }
    
    public int getIdZapisnika() {
        return idZapisnika;
    }
    
    public void odrediMVP(Zapisnik z){
        StavkaZapisnika prviTim = null;

        for (StavkaZapisnika s : z.getStavka()) {
            if (s.getMestoNRL()== 1) {
                prviTim = s;
                break;
            }
        }

        if (prviTim == null || prviTim.getSStavka() == null) return;

        SStavkaZapisnika najbolji = null;

        for (SStavkaZapisnika ss : prviTim.getSStavka()) {

            if (najbolji == null || ss.getUkupnoPoena()> najbolji.getUkupnoPoena()) {
                najbolji = ss;
            }
        }

        if (najbolji != null) {
            najbolji.setMvp(true);
        }
    }
}






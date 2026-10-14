/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import modeli.Zapisnik;
import modeli.StavkaZapisnika;
import modeli.SStavkaZapisnika;
import repozitorijum.baza.implementacija.DBBroker;

/**
 *
 * @author Katarina
 */
public class PromeniZapisnikSO extends Apstraktna_Genericka_Operacija{
    
    @Override
    protected void preduslovi(Object param) throws Exception {
         if(param==null || !(param instanceof Zapisnik)){
             throw new Exception("Sistem ne može da izmeni zapisnik.");
         }
    }
    
    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc)  {
        try {
            Zapisnik zapisnik = (Zapisnik) param;
            
            // ============================================
            // 1. IZMENA ZAPISNIKA
            // ============================================

            String upitZapisnik ="UPDATE " + zapisnik.vratiNazivTabele()+ " SET " + zapisnik.vratiVrednostiZaIzmenu()+ " WHERE " + zapisnik.vratiPrimarniKljuc();
            System.out.println(upitZapisnik);
            broker.izmeni(upitZapisnik);

            // ============================================
            // 2. IZMENA STAVKI ZAPISNIKA
            // ============================================

            if (zapisnik.getStavka() != null && !zapisnik.getStavka().isEmpty()) {

                for (StavkaZapisnika stavka : zapisnik.getStavka()) {

                    // postavljamo vezu sa zapisnikom
                    stavka.setZapisnik(zapisnik);

                    if (stavka.getRB() > 0) {

                        String upitStavka ="UPDATE " + stavka.vratiNazivTabele()+ " SET " + stavka.vratiVrednostiZaIzmenu()+ " WHERE " + stavka.vratiPrimarniKljuc();
                        System.out.println(upitStavka);
                        broker.izmeni(upitStavka);
                    }

                    // ============================================
                    // 3. IZMENA SSTAVKI
                    // ============================================

                    if (stavka.getSStavka() != null && !stavka.getSStavka().isEmpty()) {

                        for (SStavkaZapisnika sstavka: stavka.getSStavka()) {
                            // postavljamo vezu sa roditeljskom stavkom
                            sstavka.setStavkaZapisnika(stavka);

                            if (sstavka.getRedniBrojSStavke() > 0) {

                                String upitSStavka ="UPDATE "+ sstavka.vratiNazivTabele()+ " SET "+ sstavka.vratiVrednostiZaIzmenu()+ " WHERE "+ sstavka.vratiPrimarniKljuc();
                                System.out.println(upitSStavka);
                                broker.izmeni(upitSStavka);
                            }
                        }
                    }
                }
            }   
        }
         catch (Exception ex) {
            //Logger.getLogger(PretraziAnaliticarPoKriterijumimaSO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

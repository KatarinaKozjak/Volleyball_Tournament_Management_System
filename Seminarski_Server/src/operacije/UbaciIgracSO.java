/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.logging.Level;
import java.util.logging.Logger;
import modeli.Igrac;

/**
 *
 * @author Katarina
 */
public class UbaciIgracSO extends Apstraktna_Genericka_Operacija{
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Igrac)){
            throw new Exception("Sistem ne može da kreira igraca.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{
        Igrac igrac = (Igrac) param;
        String upit ="INSERT INTO "+ igrac.vratiNazivTabele()+ " ("+ igrac.vratiKoloneZaUbacivanje()+ ") VALUES ("+ igrac.vratiVrednostiZaUbacivanje()+ ")";
        System.out.println(upit);
        broker.dodaj(upit);
    }
}

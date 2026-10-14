/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.logging.Level;
import java.util.logging.Logger;
import modeli.Mesto;

/**
 *
 * @author Katarina
 */
public class UbaciMestoSO extends Apstraktna_Genericka_Operacija{
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Mesto)){
            throw new Exception("Sistem ne može da kreira mesto.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{
        Mesto mesto = (Mesto) param;
        String upit ="INSERT INTO "+ mesto.vratiNazivTabele()+ " ("+ mesto.vratiKoloneZaUbacivanje()+ ") VALUES ("+ mesto.vratiVrednostiZaUbacivanje()+ ")";
        System.out.println(upit);
        broker.dodaj(upit);
    }
}

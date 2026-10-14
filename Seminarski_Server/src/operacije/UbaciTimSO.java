/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.logging.Level;
import java.util.logging.Logger;
import modeli.Tim;

/**
 *
 * @author Katarina
 */
public class UbaciTimSO extends Apstraktna_Genericka_Operacija{
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Tim)){
            throw new Exception("Sistem ne može da kreira tim.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{
        Tim tim = (Tim) param;
        String upit ="INSERT INTO "+ tim.vratiNazivTabele()+ " ("+ tim.vratiKoloneZaUbacivanje()+ ") VALUES ("+ tim.vratiVrednostiZaUbacivanje()+ ")";
        System.out.println(upit);
        broker.dodaj(upit);  
    }
}

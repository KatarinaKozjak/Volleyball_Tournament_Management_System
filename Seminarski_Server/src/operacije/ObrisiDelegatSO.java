/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import modeli.Delegat;

/**
 *
 * @author Katarina
 */
public class ObrisiDelegatSO extends Apstraktna_Genericka_Operacija{
    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Delegat)) {
            throw new Exception("Sistem ne može da obriše delegata.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{
        System.out.println("USAO U IZVRSETAK OPERACIJE BRISANJA DELEGATA");
        Delegat delegat = (Delegat) param;
        String upit = "DELETE FROM " + delegat.vratiNazivTabele()+" WHERE "+delegat.vratiPrimarniKljuc();
        broker.obrisi(upit);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.LinkedList;
import java.util.List;
import modeli.Analiticar;

/**
 *
 * @author Katarina
 */
public class UcitajAnaliticareSO extends Apstraktna_Genericka_Operacija{
    private List<Analiticar> analiticari = new LinkedList<>();
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        //Nema posebnih preduslova
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{
        Analiticar analiticar = new Analiticar();
        String uslov = (String) kljuc;

        String upit ="SELECT DISTINCT analiticar.Id_Analiticar, analiticar.Ime, analiticar.Prezime, analiticar.Email, analiticar.Username, analiticar.Password "+ "FROM analiticar "
            + "LEFT JOIN zapisnik ON analiticar.Id_Analiticar = zapisnik.Id_Analiticar "
            + "LEFT JOIN delegat ON zapisnik.Id_Delegat = delegat.Id_Delegat ";

        if (uslov != null && !uslov.trim().isEmpty()) {
            if (!uslov.trim().toUpperCase().startsWith("WHERE")) {
                upit += " WHERE " + uslov;
            } else {
                upit += " " + uslov;
            }
        }

        analiticari = broker.ucitajSve(analiticar, upit);
    }
    
    public List<Analiticar> getAnaliticari(){
        return analiticari;
    }
}

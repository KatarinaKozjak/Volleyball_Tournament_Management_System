/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeli.Analiticar;

/**
 *
 * @author Katarina
 */
public class PrijaviAnaliticarSO extends Apstraktna_Genericka_Operacija{
    
    private Analiticar analiticar=null;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Analiticar)) {
            throw new Exception("Neispravan parametar za prijavu analiticara!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, Object kljuc) throws Exception{
        
        //List<Object> sviAnaliticari = broker.ucitajSve(new Analiticar(), null);
        Analiticar uneseni = (Analiticar) param;
        String upit = "SELECT Id_Analiticar, Ime, Prezime, Email, Username, Password " + "FROM analiticar ";
            
        List<Object> sviAnaliticari = broker.ucitajSve(uneseni,upit);
        System.out.println("Svi analiticari: " + sviAnaliticari);
        analiticar = null;
            
        for (int i = 0; i < sviAnaliticari.size(); i++) {
            Analiticar baza = (Analiticar) sviAnaliticari.get(i);
            System.out.println("Provera: Username uneseni = " + uneseni.getUsername()+ ", Username baza = " + baza.getUsername());
            System.out.println("Provera: Sifra uneseni = '" + uneseni.getPassword()+ "', Sifra baza = '" + baza.getPassword()+ "'");
            if (uneseni.getUsername().equals( baza.getUsername()) && 
                baza.getPassword().equals(uneseni.getPassword())) {
                analiticar = baza;
                return;
            }
        }
    }

    public Analiticar getAnaliticar() {
        return analiticar;
    }
}

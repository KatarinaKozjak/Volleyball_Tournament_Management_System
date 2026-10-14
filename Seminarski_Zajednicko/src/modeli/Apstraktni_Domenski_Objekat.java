/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.io.Serializable;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author Katarina
 */
public interface Apstraktni_Domenski_Objekat extends Serializable{
    public String vratiNazivTabele();
    public List<Apstraktni_Domenski_Objekat> vatiListu(ResultSet rs) throws Exception;
    public String vratiKoloneZaUbacivanje();
    public String vratiVrednostiZaUbacivanje();
    public String vratiPrimarniKljuc();
    public Apstraktni_Domenski_Objekat vratiObjekatIzRS(ResultSet rs) throws Exception;
    public String vratiVrednostiZaIzmenu();
}

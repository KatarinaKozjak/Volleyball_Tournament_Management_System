/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
/**
 *
 * @author Katarina
 */
public class Igrac implements Apstraktni_Domenski_Objekat{

    private int idIgrac;
    private String ime;
    private String prezime;
    private String pozicija;
    
    public Igrac(){}
    
    public Igrac(int id, String ime, String prezime, String pozicija){
        this.idIgrac=id;
        this.ime=ime;
        this.prezime=prezime;
        this.pozicija=pozicija;
    }
    
    public void setIdIgraca(int id){this.idIgrac=id;}
    
    public void setIme(String ime){this.ime=ime;}
    
    public void setPrezime(String prezime){this.prezime=prezime;}
    
    public void setPozicija(String pozicija){this.pozicija=pozicija;}
    
    
    public int getIdIgraca(){return idIgrac;}
    
    public String getIme(){return ime;}
    
    public String getPrezime(){return prezime;}
    
    public String getPozicija(){return pozicija;}
    
    @Override
    public String toString(){
        return ime+" "+prezime+" "+pozicija;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Igrac other = (Igrac) obj;
        return idIgrac == other.idIgrac;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIgrac);
    }
    
    @Override
    public String vratiNazivTabele() {
        return "igrac";
    }

    @Override
    public List<Apstraktni_Domenski_Objekat> vatiListu(ResultSet rs) throws Exception {
        List<Apstraktni_Domenski_Objekat> lista = new LinkedList<>();
        while (rs.next()) {
            int id = rs.getInt("Id_Igrac");
            String ime = rs.getString("Ime");
            String prezime = rs.getString("Prezime");
            String pozicija = rs.getString("Pozicija");
            
            Igrac i = new Igrac(id, ime, prezime, pozicija);
            lista.add(i);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "Ime,Prezime,Pozicija";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+ime+"','"+prezime+"','"+pozicija+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "Id_Igrac="+idIgrac;
    }

    @Override
    public Apstraktni_Domenski_Objekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("Id_Igrac");
            String ime = rs.getString("Ime");
            String prezime = rs.getString("Prezime");
            String pozicija = rs.getString("Pozicija");
            
            return new Igrac(id, ime, prezime, pozicija);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "Ime='" + ime + "',Prezime='" + prezime + "',Pozicija=" + pozicija+"'";
    }
    
}

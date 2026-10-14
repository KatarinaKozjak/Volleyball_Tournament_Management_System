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
public class Kvalifikacija implements Apstraktni_Domenski_Objekat{

    private int idKvalifikacija;
    private String naziv;
    private String institucija;
    
    public Kvalifikacija(){}
    
    public Kvalifikacija(int id, String naziv, String insti){
        this.idKvalifikacija=id;
        this.naziv=naziv;
        this.institucija=insti;
    }
    
    public void setIdKvalifikacije(int id){this.idKvalifikacija=id;}
    
    public void setNaziv(String naziv){this.naziv=naziv;}
    
    public void setInstitucija(String institucija){this.institucija=institucija;}
    
    public int getIdKvalifikacije(){return idKvalifikacija;}
    
    public String getNaziv(){return naziv;}
    
    public String getInstitucija(){return institucija;}
    
    @Override
    public String toString(){
        return naziv+" "+institucija;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Kvalifikacija other = (Kvalifikacija) obj;
        return idKvalifikacija == other.idKvalifikacija;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKvalifikacija);
    }
    
    @Override
    public String vratiNazivTabele() {
        return "kvalifikacija";
    }

    @Override
    public List<Apstraktni_Domenski_Objekat> vatiListu(ResultSet rs) throws Exception {
        List<Apstraktni_Domenski_Objekat> lista = new LinkedList<>();
        while (rs.next()) {
            int id = rs.getInt("Id_Kvalifikacija");
            String naziv = rs.getString("Naziv");
            String institucija = rs.getString("Institucija");
            
            
            Kvalifikacija k = new Kvalifikacija(id, naziv, institucija);
            lista.add(k);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "Naziv,Institucija";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+naziv+"','"+institucija+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "Id_Kvalifikacija="+idKvalifikacija;
    }

    @Override
    public Apstraktni_Domenski_Objekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("Id_Kvalifikacija");
            String naziv = rs.getString("Naziv");
            String institucija = rs.getString("Institucija");
            
            return new Kvalifikacija(id, naziv, institucija);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "Naziv='"+naziv+"',Institucija='"+institucija+"'";
    }
    
}

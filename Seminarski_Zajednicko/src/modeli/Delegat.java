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
public class Delegat implements Apstraktni_Domenski_Objekat{

    private int IdDelegat;
    private String Ime;
    private String Prezime;
    private Mesto mesto;
    
    public Delegat(){}
    
    public Delegat(int id, String ime, String prezime, Mesto mesto){
        this.IdDelegat = id;
        this.Ime = ime;
        this.Prezime = prezime;
        this.mesto = mesto;
    }
    
    public int getIdDelegata() {
        return IdDelegat;
    }

    public void setIdDelegata(int id) {
        this.IdDelegat = id;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        this.Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        this.Prezime = prezime;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }
    
    @Override
    public String toString() {
        return Ime + " " + Prezime + " (" + mesto.getNaziv() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Delegat other = (Delegat) obj;
        return IdDelegat == other.IdDelegat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdDelegat);
    }
    
    @Override
    public String vratiNazivTabele() {
        return "delegat";
    }

    @Override
    public List<Apstraktni_Domenski_Objekat> vatiListu(ResultSet rs) throws Exception {
        List<Apstraktni_Domenski_Objekat> lista = new LinkedList<>();
        while (rs.next()) {
            int id = rs.getInt("delegat.Id_Delegat");
            String ime = rs.getString("delegat.Ime");
            String prezime = rs.getString("delegat.Prezime");
            int idMesta = rs.getInt("delegat.Id_Mesto");
            String nazivMesta = rs.getString("mesto.Naziv");
            int brojStanovnika = rs.getInt("mesto.Br_Stanovnika");

            Mesto mesto = new Mesto(idMesta, nazivMesta, brojStanovnika);
            Delegat d = new Delegat(id, ime, prezime, mesto);
            lista.add(d);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "Ime,Prezime,Id_Mesto";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + Ime + "','" + Prezime + "'," + mesto.getIdMesta();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "Id_Delegat=" + IdDelegat;
    }

    @Override
    public Apstraktni_Domenski_Objekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("delegat.Id_Delegat");
            String ime = rs.getString("delegat.Ime");
            String prezime = rs.getString("delegat.Prezime");
            int idMesta = rs.getInt("delegat.Id_Mesto");
            String nazivMesta = rs.getString("mesto.Naziv");
            int brojStanovnika = rs.getInt("mesto.Br_Stanovnika");
            
            Mesto mesto = new Mesto(idMesta, nazivMesta, brojStanovnika);
            return new Delegat(id, ime, prezime, mesto);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "Ime='" + Ime + "',Prezime='" + Prezime + "',Id_Mesto=" + mesto.getIdMesta();
    }
    
}

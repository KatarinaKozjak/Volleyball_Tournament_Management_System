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
public class StavkaZapisnika implements Apstraktni_Domenski_Objekat{

    private Zapisnik zapisnik;
    private int rb;
    private List<SStavkaZapisnika> sstavka;
    private int mestoNRL;
    private Tim tim;
    
    public StavkaZapisnika(){}
    
    public StavkaZapisnika(Zapisnik z, int rb,List<SStavkaZapisnika> sstavka, int mesto, Tim t){
        this.zapisnik=z;
        this.rb=rb;
        this.sstavka=sstavka;
        this.mestoNRL=mesto;
        this.tim=t;
    }
    
    public void setZapisnik(Zapisnik z){this.zapisnik=z;}
    
    public void setRedniBrojStavke(int rb){this.rb=rb;}
    
    public void setSStavka(List<SStavkaZapisnika> sstavka){this.sstavka=sstavka;}
    
    public void setMestoNaRangListi(int mesto){this.mestoNRL = mesto;}
    
    public void setTim(Tim t){this.tim=t;}
    
    public Zapisnik getZapisnik(){return zapisnik;}
    
    public int getRB(){return rb;}
    
    public List<SStavkaZapisnika> getSStavka(){return sstavka;}
    
    public int getMestoNRL(){return mestoNRL;}
    
    public Tim getTim(){return tim;}
    
    @Override
    public int hashCode() {
        return Objects.hash(rb,zapisnik.getIdZapisnika());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StavkaZapisnika other = (StavkaZapisnika) obj;
        return Objects.equals(zapisnik, other.zapisnik)
                && Objects.equals(rb, other.rb);
    }

    @Override
    public String toString() {
        return zapisnik.toString()+"\n Stavka: "+rb+" Tim : "+tim.getNaziv()+", mesto na rang listi: "+mestoNRL;
    }
    
    
    @Override
    public String vratiNazivTabele() {
        return "stavka_zapisnika";
    }

    @Override
    public List<Apstraktni_Domenski_Objekat> vatiListu(ResultSet rs) throws Exception {
        List<Apstraktni_Domenski_Objekat> lista = new LinkedList<>();
        while (rs.next()) {
            
            Zapisnik z = new Zapisnik();
            z.setIdZapisnika(rs.getInt("Id_Zapisnik"));
            
            int rbRS = rs.getInt("RB_Stavke");
            int mesto = rs.getInt("Mesto_na_rang_listi");
            
            Tim t = new Tim();
            t.setIdTima(rs.getInt("Id_Tim"));
            t.setNaziv(rs.getString("Naziv"));

            StavkaZapisnika s = new StavkaZapisnika(z,rbRS,null,mesto,t);
            lista.add(s);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "Id_Zapisnik, RB_Stavke, Mesto_na_rang_listi, Id_Tim";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return zapisnik.getIdZapisnika() + ", " + rb + ", " + mestoNRL + ", " + tim.getIdTima() ;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "Id_Zapisnik="+zapisnik.getIdZapisnika()+" AND RB_Stavke="+rb;
    }

    @Override
    public Apstraktni_Domenski_Objekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            Zapisnik z = new Zapisnik();
            z.setIdZapisnika(rs.getInt("Id_Zapisnik"));
            
            int rbRS = rs.getInt("RB_Stavke");
            int mesto = rs.getInt("Mesto_na_rang_listi");
            
            Tim t = new Tim();
            t.setIdTima(rs.getInt("Id_Tim"));
            t.setNaziv(rs.getString("Naziv"));

            return new StavkaZapisnika(z,rbRS,null,mesto,t);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "Id_Zapisnik=" + zapisnik.getIdZapisnika() + ", RB_Stavke=" + rb + ", Mesto_na_rang_listi=" + mestoNRL + ", Id_Tim=" + tim.getIdTima();
    }
    
}

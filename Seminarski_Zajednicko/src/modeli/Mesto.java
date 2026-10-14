/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.util.List;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Objects;
/**
 *
 * @author Katarina
 */
public class Mesto implements Apstraktni_Domenski_Objekat{
    private int idMesta;
    private String naziv;
    private int brojStanovnika;

  public Mesto() {
    }

    public Mesto(int idMesta, String naziv, int brojStanovnika) {
        this.idMesta = idMesta;
        this.naziv = naziv;
        this.brojStanovnika = brojStanovnika;
    }

    public int getIdMesta() {
        return idMesta;
    }

    public void setIdMesta(int idMesta) {
        this.idMesta = idMesta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMesta);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mesto other = (Mesto) obj;
        return idMesta == other.idMesta;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "Naziv,Br_Stanovnika";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "'," + brojStanovnika;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "Id_Mesto=" + idMesta;
    }

    @Override
    public Apstraktni_Domenski_Objekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        /*if (rs.next()) {
            int id = rs.getInt("Id_Mesto");
            String nazivrs = rs.getString("Naziv");
            int brojStanovnikars = rs.getInt("Br_Stanovnika");
            return new Mesto(id, nazivrs, brojStanovnikars);
        }
        return null;*/
        if(rs.next()){
            Mesto m = new Mesto();
            m.setIdMesta(rs.getInt("Id_Mesto"));
            m.setNaziv(rs.getString("Naziv"));
            m.setBrojStanovnika(rs.getInt("Br_Stanovnika"));
            
            return m;
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "Naziv='" + naziv + "',Br_Stanovnika=" + brojStanovnika;
    }

    @Override
    public List<Apstraktni_Domenski_Objekat> vatiListu(ResultSet rs) throws Exception {
        List<Apstraktni_Domenski_Objekat> lista = new LinkedList<>();
        while (rs.next()) {
            int id = rs.getInt("Id_Mesto");
            String nazivrs = rs.getString("Naziv");
            int brojStanovnikars = rs.getInt("Br_Stanovnika");
            
            Mesto m = new Mesto(id, nazivrs, brojStanovnikars);
            lista.add(m);
            
            //lista.add(vratiObjekatIzRS(rs));
        }
        return lista;
    }
}

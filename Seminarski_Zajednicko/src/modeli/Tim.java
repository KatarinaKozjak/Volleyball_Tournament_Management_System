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
public class Tim implements Apstraktni_Domenski_Objekat{

    private int idTim;
    private String naziv;
    private int brClanova;
    private int brPobeda;
    
    public Tim(){}
    
    public Tim(int id, String naziv, int brcl, int brP){
        this.idTim=id;
        this.naziv=naziv;
        this.brClanova=brcl;
        this.brPobeda=brP;
    }
    
    public void setIdTima(int id){this.idTim=id;}
    
    public void setNaziv(String naziv){this.naziv=naziv;}
    
    public void setBrojClanova(int br){this.brClanova=br;}
    
    public void setBrojPobeda(int br){this.brPobeda=br;}
    
    public int getIdTima(){return idTim;}
    
    public String getNaziv(){return naziv;}
    
    public int getBrClanova(){return brClanova;}
    
    public int getBrojPobeda(){return brPobeda;}
    
    @Override
    public String toString(){
        return naziv+" "+brClanova+" "+brPobeda;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tim other = (Tim) obj;
        return idTim == other.idTim;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTim);
    }
    
    @Override
    public String vratiNazivTabele() {
        return "tim";
    }

    @Override
    public List<Apstraktni_Domenski_Objekat> vatiListu(ResultSet rs) throws Exception {
        List<Apstraktni_Domenski_Objekat> lista = new LinkedList<>();
        while (rs.next()) {
            int id = rs.getInt("Id_Tim");
            String nazivRS = rs.getString("Naziv");
            int brClanovaRS = rs.getInt("Broj_Clanova");
            int brPobedaRS = rs.getInt("Broj_Pobeda");
            
            Tim t = new Tim(id, nazivRS, brClanovaRS,brPobedaRS);
            lista.add(t);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "Naziv, Broj_Clanova, Broj_Pobeda";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+naziv+"', "+brClanova+", "+brPobeda;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "Id_Tim="+idTim;
    }

    @Override
    public Apstraktni_Domenski_Objekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("Id_Tim");
            String nazivRS = rs.getString("Naziv");
            int brClanovaRS = rs.getInt("Broj_Clanova");
            int brPobedaRS = rs.getInt("Broj_Pobeda");
            
            return new Tim(id, nazivRS, brClanovaRS,brPobedaRS);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "Naziv='"+naziv+"', Broj_Clanova="+brClanova+", Broj_Pobeda="+brPobeda;
    }
    
}

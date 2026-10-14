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
public class SStavkaZapisnika implements Apstraktni_Domenski_Objekat{

    private Zapisnik zapisnik;
    private StavkaZapisnika sz;
    private int rbsStavke;
    private boolean mvp;
    private int poeniIzBloka;
    private int poeniSaServisa;
    private int poeniIzIgre;
    private int ukupnoPoena;
    private Igrac igrac;
    
    public SStavkaZapisnika(){}
    
    public SStavkaZapisnika(Zapisnik z, StavkaZapisnika stavka, int rb, boolean mvp, int pB, int pS, int pI, int ukupno, Igrac igrac){
        this.zapisnik=z;
        this.sz=stavka;
        this.rbsStavke=rb;
        this.mvp=mvp;
        this.poeniIzBloka=pB;
        this.poeniSaServisa=pS;
        this.poeniIzIgre=pI;
        this.ukupnoPoena=ukupno;
        this.igrac=igrac;
    }
    
    public void setZapisnik(Zapisnik z){this.zapisnik=z;}
    
    public void setStavkaZapisnika(StavkaZapisnika sz){this.sz=sz;}
    
    public void setRedniBrojSStavke(int rb){this.rbsStavke=rb;}
    
    public void setMvp(boolean mvp){this.mvp=mvp;}
    
    public void setPoeinBlok(int pb){this.poeniIzBloka=pb;}
    
    public void setPoeniServis(int ps){this.poeniSaServisa=ps;}
    
    public void setPoeniIgra(int pi){this.poeniIzIgre=pi;}
    
    public void setUkupnoPoena(int ukupno){this.ukupnoPoena=ukupno;}
    
    public void setIgraca(Igrac i){this.igrac=i;}
    
    public Zapisnik getZapisnik(){return zapisnik;}
    
    public StavkaZapisnika getRedniBrojStavkuZapisnika(){return sz;}
    
    public int getRedniBrojSStavke(){return rbsStavke;}
    
    public boolean getMvp(){return mvp;}
    
    public int getPoeneIzBloka(){return poeniIzBloka;}
    
    public int getPoeneSaServisa(){return poeniSaServisa;}
    
    public int getPoeneIzIgre(){return poeniIzIgre;}
    
    public Igrac getIgrac(){return igrac;}
    
    public int getUkupnoPoena(){return ukupnoPoena;}
    
    @Override
    public int hashCode() {
        return Objects.hash(rbsStavke,zapisnik.getIdZapisnika(),sz.getRB());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SStavkaZapisnika other = (SStavkaZapisnika) obj;
        return Objects.equals(zapisnik, other.zapisnik)
                && Objects.equals(rbsStavke, other.rbsStavke)
                && Objects.equals(sz, other.sz);
    }

    @Override
    public String toString() {
        return "------------\nStavka zapisnika :"+sz.getRB()+"\nRedni broj podstavke:"+rbsStavke+"\nIgracica: "+igrac.toString()+" -- MVP : "+mvp+"\nPoeni iz bloka: "+poeniIzBloka+"\nPoeni sa servisa: "+poeniSaServisa+"\nPoeni iz igre: "+poeniIzIgre+"\nUkupno osvojenih poena: "+ukupnoPoena;
    }
    
    @Override
    public String vratiNazivTabele() {
        return "sstavka_zapisnika";
    }

    @Override
    public List<Apstraktni_Domenski_Objekat> vatiListu(ResultSet rs) throws Exception {
        List<Apstraktni_Domenski_Objekat> lista = new LinkedList<>();
        while (rs.next()) {
            
            Zapisnik z = new Zapisnik();
            z.setIdZapisnika(rs.getInt("Id_Zapisnik"));
            
            StavkaZapisnika s = new StavkaZapisnika();
            s.setZapisnik(z);
            s.setRedniBrojStavke(rs.getInt("RB_Stavke"));
            
            int rb = rs.getInt("RB_SStavke");
            boolean mvp = rs.getBoolean("MVP_Turnira");
            int poeniBlok = rs.getInt("Poeni_iz_bloka");
            int poeniServis = rs.getInt("Poeni_sa_servisa");
            int poeniIgra = rs.getInt("Poeni_iz_igre");
            int ukupno = rs.getInt("Ukupno_Poena");
            
            Igrac i = new Igrac();
            i.setIdIgraca(rs.getInt("Id_Igrac"));
            i.setIme(rs.getString("Ime"));
            i.setPrezime(rs.getString("Prezime"));
            

            SStavkaZapisnika ss = new SStavkaZapisnika(z,s,rb,mvp,poeniBlok,poeniServis,poeniIgra,ukupno,i);
            lista.add(ss);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "Id_Zapisnik,RB_Stavke,RB_SStavke,MVP_Turnira,Poeni_iz_bloka,Poeni_sa_servisa,Poeni_iz_igre,Ukupno_Poena,Id_Igrac";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return zapisnik.getIdZapisnika() + ", " + sz.getRB() + ", " + rbsStavke + ", " +mvp+", "+poeniIzBloka+", "+poeniSaServisa+", "+poeniIzIgre+", "+ukupnoPoena+", "+igrac.getIdIgraca();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "Id_Zapisnik="+zapisnik.getIdZapisnika()+" AND RB_Stavke="+sz.getRB()+" AND RB_SStavke="+rbsStavke;
    }

    @Override
    public Apstraktni_Domenski_Objekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            Zapisnik z = new Zapisnik();
            z.setIdZapisnika(rs.getInt("Id_Zapisnik"));
            
            StavkaZapisnika s = new StavkaZapisnika();
            s.setZapisnik(z);
            s.setRedniBrojStavke(rs.getInt("RB_Stavke"));
            
            int rb = rs.getInt("RB_SStavke");
            boolean mvp = rs.getBoolean("MVP_Turnira");
            int poeniBlok = rs.getInt("Poeni_iz_bloka");
            int poeniServis = rs.getInt("Poeni_sa_servisa");
            int poeniIgra = rs.getInt("Poeni_iz_igre");
            int ukupno = rs.getInt("Ukupno_Poena");
            
            Igrac i = new Igrac();
            i.setIdIgraca(rs.getInt("Id_Igrac"));
            i.setIme(rs.getString("Ime"));
            i.setPrezime(rs.getString("Prezime"));
            
            
            return new SStavkaZapisnika(z,s,rb,mvp,poeniBlok,poeniServis,poeniIgra,ukupno,i);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "Id_Zapisnik = " + zapisnik.getIdZapisnika() + ", RB_Stavke = " + sz.getRB() + ", RB_SStavke = "+rbsStavke+", MVP_Turnira = "+mvp+", Poeni_iz_bloka = "+poeniIzBloka+", Poeni_sa_servisa = "+poeniSaServisa+", Poeni_iz_igre = "+poeniIzIgre+", Ukupno_Poena = "+ukupnoPoena+", Id_Igrac = "+igrac.getIdIgraca();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDate;
/**
 *
 * @author Katarina
 */
public class Zapisnik implements Apstraktni_Domenski_Objekat{

    private int idZapisnik;
    private LocalDate datumPocetka;
    private LocalDate datumZavrsetka;
    List<StavkaZapisnika> stavka;
    private int brojGrupa;
    private Analiticar analiticar;
    private Delegat delegat;
    
    public Zapisnik(){}
    
    public Zapisnik(int id, LocalDate datPo, LocalDate datZa,  List<StavkaZapisnika> stavka, int brGrupa, Analiticar a, Delegat d){
        this.idZapisnik=id;
        this.datumPocetka=datPo;
        this.datumZavrsetka=datZa;
        this.stavka=stavka;
        this.brojGrupa=brGrupa;
        this.analiticar=a;
        this.delegat=d;
    }
    
    public void setIdZapisnika(int id){this.idZapisnik=id;}
    
    public void setDatumPocetka(LocalDate datum){this.datumPocetka=datum;}
    
    public void setDatumZavsetka(LocalDate datum){this.datumZavrsetka=datum;}
    
    public List<StavkaZapisnika> getStavka() {return stavka;}

    public void setStavka(List<StavkaZapisnika> stavka) {this.stavka = stavka;}
    
    public void setBrojGrupa(int br){this.brojGrupa=br;}
    
    public void setAnaliticara(Analiticar a){this.analiticar=a;}
    
    public void setDelegta(Delegat d){this.delegat=d;}
    
    public int getIdZapisnika(){return idZapisnik;}
    
    public LocalDate getDatumPocetka(){return datumPocetka;}
    
    public LocalDate getDatumZavrsetka(){return datumZavrsetka;}
    
    public int getBrojgrupa(){return brojGrupa;}
    
    public Analiticar getAnaliticara(){return analiticar;}
    
    public Delegat getDelegata(){return delegat;}
    
    @Override
    public int hashCode() {
        return Objects.hash(idZapisnik);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Zapisnik other = (Zapisnik) obj;
        return idZapisnik == other.idZapisnik;
    }

    @Override
    public String toString() {
        return "Turnir ----\nDatum pocetka : "+datumPocetka + "\nDatum zavrsetka : " + datumZavrsetka + "\nBroj grupa " + brojGrupa+",\nAnaliticar = "+analiticar.toString()+"\nDelegat = "+delegat.toString();
    }
    
    
    @Override
    public String vratiNazivTabele() {
        return "zapisnik";
    }

    @Override
    public List<Apstraktni_Domenski_Objekat> vatiListu(ResultSet rs) throws Exception {
        List<Apstraktni_Domenski_Objekat> lista = new LinkedList<>();
        while (rs.next()) {
            
            int idZapisnika = rs.getInt("Id_Zapisnik");
            LocalDate datumPocetka = rs.getDate("Datum_Pocetka").toLocalDate();
            LocalDate datumZavrsetka = rs.getDate("Datum_Zavrsetka").toLocalDate();
            int brojGrupa = rs.getInt("Broj_Grupa");
            
            int idAnaliticara = rs.getInt("Id_Analiticar");
            String ime = rs.getString("Ime");
            String prezime = rs.getString("Prezime");
            String email = rs.getString("Email");
            String username = rs.getString("Username");
            String password = rs.getString("Password");
            Analiticar a = new Analiticar(idAnaliticara, ime, prezime, email, username, password);

            int idDelegat = rs.getInt("Id_Delegat");
            String imed = rs.getString("Ime");
            String prezimed = rs.getString("Prezime");
            int idMesta = rs.getInt("Id_Mesto");
            String nazivMesta = rs.getString("Naziv");
            int brojStanovnika = rs.getInt("Br_Stanovnika");

            Mesto mesto = new Mesto(idMesta, nazivMesta, brojStanovnika);
            Delegat d = new Delegat(idDelegat, imed, prezimed, mesto);
           

            Zapisnik z = new Zapisnik(idZapisnika,datumPocetka, datumZavrsetka,null,brojGrupa,a,d);
            lista.add(z);
        }
        return lista;
    }

    
    @Override
    public String vratiKoloneZaUbacivanje(){
        return "Datum_Pocetka,Datum_Zavrsetka,Broj_Grupa,Id_Analiticar,Id_Delegat";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + datumPocetka + "','"+datumZavrsetka+"',"+brojGrupa+"," + analiticar.getIdAnaliticara()+ "," + delegat.getIdDelegata();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "Id_Zapisnik="+idZapisnik;
    }

    @Override
    public Apstraktni_Domenski_Objekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            
            int id = rs.getInt("Id_Zapisnik");
            LocalDate datumPocetka = rs.getDate("Datum_Pocetka").toLocalDate();
            LocalDate datumZavrsetka = rs.getDate("Datum_Zavrsetka").toLocalDate();
            int brojGrupa = rs.getInt("Broj_Grupa");
            
            Analiticar a = new Analiticar();
            a.setIdAnaliticara(rs.getInt("Id_Analiticar"));
            
            Delegat d = new Delegat();
            d.setIdDelegata(rs.getInt("Id_Delegat"));
            
            return new Zapisnik(id, datumPocetka, datumZavrsetka, null,brojGrupa,a,d);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
      return "Datum_Pocetka='" + datumPocetka + "',Datum_Zavrsetka='" + datumZavrsetka + "',Broj_Grupa=" + brojGrupa
                + ",Id_Analiticar=" + analiticar.getIdAnaliticara()+ ",Id_Delegat=" + delegat.getIdDelegata();  
    }
    
}

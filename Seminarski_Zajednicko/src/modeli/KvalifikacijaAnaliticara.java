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
public class KvalifikacijaAnaliticara implements Apstraktni_Domenski_Objekat{

    private LocalDate datumIzdavanja;
    private Analiticar analiticar;
    private Kvalifikacija kvalifikacija;
    
    public KvalifikacijaAnaliticara(){}
    
    public KvalifikacijaAnaliticara(LocalDate datum, Analiticar a, Kvalifikacija k){
        this.datumIzdavanja=datum;
        this.analiticar=a;
        this.kvalifikacija=k;
    }
    
    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Analiticar getAnaliticar() {
        return analiticar;
    }

    public void setAnaliticar(Analiticar a) {
        this.analiticar = a;
    }

    public Kvalifikacija getKvalifikacija() {
        return kvalifikacija;
    }

    public void setKvalifikacija(Kvalifikacija kvalifikacija) {
        this.kvalifikacija = kvalifikacija;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(datumIzdavanja, analiticar, kvalifikacija);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        KvalifikacijaAnaliticara other = (KvalifikacijaAnaliticara) obj;
        return Objects.equals(datumIzdavanja, other.datumIzdavanja)
                && Objects.equals(analiticar, other.analiticar)
                && Objects.equals(kvalifikacija, other.kvalifikacija);
    }

    @Override
    public String toString() {
        return "IzdavanjeSertifikata{" + "datumIzdavanja=" + datumIzdavanja + ", analiticar=" + analiticar + ", kvalifikacija=" + kvalifikacija + '}';
    }
    
    @Override
    public String vratiNazivTabele() {
        return "kvalifikacija_analiticara";
    }

    @Override
    public List<Apstraktni_Domenski_Objekat> vatiListu(ResultSet rs) throws Exception {
        List<Apstraktni_Domenski_Objekat> lista = new LinkedList<>();
        while (rs.next()) {
            
            int idAnaliticara = rs.getInt("Id_Analiticar");
            String ime = rs.getString("Ime");
            String prezime = rs.getString("Prezime");
            String email = rs.getString("Email");
            String username = rs.getString("Username");
            String password = rs.getString("Password");
            Analiticar a = new Analiticar(idAnaliticara, ime, prezime, email, username, password);
            
            int idKvalifikacije = rs.getInt("Id_Kvalifikacije");
            String naziv = rs.getString("Naziv");
            String institucija = rs.getString("Institucija");
            Kvalifikacija k = new Kvalifikacija(idKvalifikacije, naziv, institucija);
            
            LocalDate datum = rs.getDate("Datum_Izdavanja").toLocalDate();

            KvalifikacijaAnaliticara ka = new KvalifikacijaAnaliticara(datum, a, k);
            lista.add(ka);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "Id_Analiticar,Id_Kvalifikacija,Datum_Izdavanja";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return analiticar.getIdAnaliticara()+","+ kvalifikacija.getIdKvalifikacije() +",'" + datumIzdavanja + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "Id_Analiticar="+analiticar.getIdAnaliticara()+"AND Id_Kvalifikacija="+kvalifikacija.getIdKvalifikacije()+"AND Datum_Izdavanja='"+datumIzdavanja+"'";
    }

    @Override
    public Apstraktni_Domenski_Objekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            
            Analiticar a = new Analiticar(
                rs.getInt("Id_Analiticar"),
                rs.getString("Ime"),
                rs.getString("Prezime"),
                rs.getString("Email"),
                rs.getString("Username"),
                rs.getString("Password")
            );
            Kvalifikacija k = new Kvalifikacija(
                rs.getInt("Id_Kvalifikacija"),
                rs.getString("Naziv"),
                rs.getString("Institucija")
            );
            LocalDate datum = rs.getDate("Datum_Izdavanja").toLocalDate();
            return new KvalifikacijaAnaliticara(datum, a, k);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "Id_Analiticar="+analiticar.getIdAnaliticara()+",Id_Kvalifikacija="+kvalifikacija.getIdKvalifikacije()+",Datum_Izdavanja='"+datumIzdavanja+"'";
    }
    
}

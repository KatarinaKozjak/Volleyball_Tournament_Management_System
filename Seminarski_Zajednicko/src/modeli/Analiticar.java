/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.sql.ResultSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Objects;
/**
 *
 * @author Katarina
 */
public class Analiticar implements Apstraktni_Domenski_Objekat{

    private int idAnaliticar;
    private String Ime;
    private String Prezime;
    private String Email;
    private String Username;
    private String Password;
    
    public Analiticar(){}
    
    public Analiticar(int id, String ime, String prez, String mejl, String username, String password){
        this.idAnaliticar=id;
        this.Ime=ime;
        this.Prezime=prez;
        this.Email=mejl;
        this.Username = username;
        this.Password=password;
    }
    
    public int getIdAnaliticara(){
        return idAnaliticar;
    }
    
    public String getImeAnaliticara(){
        return Ime;
    }
    
    public String getPrezimeAnaliticara(){
        return Prezime;
    }
    
    public String getEmailAnaliticara(){
        return Email;
    }
    
    public String getUsername(){return Username;}
    
    public String getPassword(){return Password;}
    
    public void setIdAnaliticara(int id){
        this.idAnaliticar=id;
    }
    
    public void setImeAnaliticara(String ime){
        this.Ime=ime;
    }
    
    public void setPrezimeAnaliticara(String prez){
        this.Prezime=prez;
    }
    
    public void setEmailAnaliticara(String mejl){
        this.Email=mejl;
    }
    
    public void setUsername(String user){this.Username=user;}
    
    public void setPassword(String pass){this.Password=pass;}
    
    @Override
    public String toString(){
        return Ime + " " + Prezime + " " + Email+" "+Username;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Analiticar other = (Analiticar) obj;
        return idAnaliticar == other.idAnaliticar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnaliticar);
    }

    
    @Override
    public String vratiNazivTabele() {
        return "analiticar";
    }

    @Override
    public List<Apstraktni_Domenski_Objekat> vatiListu(ResultSet rs) throws Exception {
        List<Apstraktni_Domenski_Objekat> lista = new LinkedList<>();
        while (rs.next()) {
            int id = rs.getInt("Id_Analiticar");
            String ime = rs.getString("Ime");
            String prezime = rs.getString("Prezime");
            String mejl = rs.getString("Email");
            String username = rs.getString("Username");
            String password = rs.getString("Password");
            
            Analiticar a = new Analiticar(id, ime, prezime, mejl, username, password);
            lista.add(a);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "Ime,Prezime,Email,Username,Password";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+Ime+"','"+Prezime+"','"+Email+"','"+Username+"','"+Password+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "Id_Analiticar="+idAnaliticar;
    }

    @Override
    public Apstraktni_Domenski_Objekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("Id_Analiticar");
            String ime = rs.getString("Ime");
            String prezime = rs.getString("Prezime");
            String mejl = rs.getString("Email");
            String username = rs.getString("Username");
            String password = rs.getString("Password");
            
            return new Analiticar(id, ime, prezime, mejl, username, password);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "Ime='"+Ime+"', Prezime='"+Prezime+"', Email='"+Email+"', Username='"+Username+"', Password='"+Password+"'";
    }
    
}

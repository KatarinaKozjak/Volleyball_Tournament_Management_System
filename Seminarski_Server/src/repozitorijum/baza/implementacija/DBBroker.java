/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repozitorijum.baza.implementacija;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeli.Apstraktni_Domenski_Objekat;
import repozitorijum.baza.DBConnectionFactory;
import repozitorijum.baza.DBRepository;

/**
 *
 * @author Katarina
 */
public class DBBroker implements DBRepository<Apstraktni_Domenski_Objekat>{

    @Override
    public List<Apstraktni_Domenski_Objekat> ucitajSve(Apstraktni_Domenski_Objekat parametar, String upit) throws Exception {
        System.out.println(upit);
        Statement statement = DBConnectionFactory.getInstance().getConnection().createStatement();
        ResultSet rs = statement.executeQuery(upit);
        
        List<Apstraktni_Domenski_Objekat> lista = parametar.vatiListu(rs);
        rs.close();
        statement.close();
        return lista;
    }
    
    @Override
    public int dodaj(String upit) throws Exception {
        int primarniKljuc = -1;
        try {
            System.out.println(upit);
            
            try ( PreparedStatement pst = DBConnectionFactory.getInstance().getConnection().prepareStatement(upit, Statement.RETURN_GENERATED_KEYS)) {
                pst.executeUpdate();

                try ( ResultSet rs = pst.getGeneratedKeys()) {
                    if (rs.next()) {
                        primarniKljuc = rs.getInt(1);
                    }
                }
            }
            return primarniKljuc;
        } catch (Exception ex) {
            ex.printStackTrace();
            return primarniKljuc;
        }
    }
    
    @Override
    public void izmeni(String upit) throws Exception {
        System.out.println(upit);
        try (Statement statement = DBConnectionFactory.getInstance().getConnection().createStatement()) {
            statement.executeUpdate(upit);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void obrisi(String upit) throws Exception {
        System.out.println(upit);
        Statement statement=DBConnectionFactory.getInstance().getConnection().createStatement();
        statement.executeUpdate(upit);
        statement.close();
    }
    
}

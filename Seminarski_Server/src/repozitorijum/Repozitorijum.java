/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repozitorijum;

import java.util.List;

/**
 *
 * @author Katarina
 */
public interface Repozitorijum<T> {
    List<T> ucitajSve(T param,String upit) throws Exception;
    int dodaj(String upit) throws Exception;
    void izmeni(String upit) throws Exception;    
    void obrisi(String upit) throws Exception;
    //List<T> ucitajSve(String upit);
}

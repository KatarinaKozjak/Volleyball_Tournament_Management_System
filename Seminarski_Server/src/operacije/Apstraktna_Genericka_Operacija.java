/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package operacije;

import repozitorijum.Repozitorijum;
import repozitorijum.baza.DBRepository;
import repozitorijum.baza.implementacija.DBBroker;
/**
 *
 * @author Katarina
 */
public abstract class Apstraktna_Genericka_Operacija {
    protected final Repozitorijum broker;
    
    public Apstraktna_Genericka_Operacija(){
        this.broker=(Repozitorijum) new DBBroker();
    }
    
    public final void izvrsi(Object objekat,Object kljuc)throws Exception{
        try {
            preduslovi(objekat);
            zapocniTransakciju();
            izvrsiOperaciju(objekat,kljuc);
            potvrdiTransakciju();
        } catch (Exception e) {
            ponistiTransakciju();
            throw e;
        } finally {
           // ugasiKonekciju();
        } 
    }
    
    protected abstract void preduslovi(Object param)throws Exception;
    
    private void zapocniTransakciju() throws Exception {
        ((DBRepository)broker).uspostaviKonekcijuSaBazom();
    }
    
    protected abstract void izvrsiOperaciju(Object param, Object kljuc) throws Exception;
    
    private void potvrdiTransakciju() throws Exception {
        ((DBRepository)broker).potvrdiTransakciju();
    }

    private void ponistiTransakciju() throws Exception {
        ((DBRepository)broker).ponistiTransakciju();
    }

    private void ugasiKonekciju() throws Exception {
        ((DBRepository)broker).raskiniKonekcijuSaBazom();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author Katarina
 */
public class Operacija implements Serializable{
    
    public static final int KREIRAJ_ZAPISNIK=1;//**************
    public static final int PRETRAZI_ZAPISNIK=2;//************
    public static final int PROMENI_ZAPISNIK=3;//**************
    public static final int OBRISI_ZAPISNIK=4;
    
    public static final int KREIRAJ_DELEGATA=5;
    public static final int PRETRAZI_DELEGATA=6;
    public static final int PROMENI_DELEGATA=7;
    public static final int OBRISI_DELEGATA=8;//****************
    
    public static final int PRIJAVI_ANALITICARA=9;//****************
    
    public static final int KREIRAJ_ANALITICARA=10;
    public static final int PRETRAZI_ANALITICARA=11;//****************
    public static final int PROMENI_ANALITICARA=12;
    public static final int OBRISI_ANALITICARA=13;
    
    public static final int KREIRAJ_TIM=14;//****************
    public static final int PRETRAZI_TIM=15;
    public static final int PROMENI_TIM=16;
    public static final int OBRISI_TIM=17;
    
    public static final int KREIRAJ_MESTO=18;//****************
    public static final int PRETRAZI_MESTA=19;
    public static final int PROMENI_MESTO = 20;
    public static final int OBRISI_MESTO = 22;
    
    public static final int PRETRAZI_MESTO_PO_KRITERIJUMIMA = 21;
    
    public static final int KREIRAJ_KLASIFIKACIJU = 23;
    public static final int PRETRAZI_KVALIFIKACIJE = 24;
    public static final int OBRISI_KVALIFIKACIJE = 27;
    
    public static final int UCITAJ_KVALIFIKACIJE=30;//******************
    public static final int UCITAJ_ZAPISNIKE=36;//*****************
    public static final int UCITAJ_TIMOVE=37;//*****************
    public static final int UCITAJ_IGRACE=38;//**************
    public static final int UCITAJ_MESTA=39;//****************
    public static final int UCITAJ_DELEGATE=40;//********************
    public static final int UCITAJ_ANALITICARE=41;//*************
    
    
    public static final int PRETRAZI_ZAPISNIKE_PO_KRITERIJUMU=25;//***************
    public static final int PRETRAZI_ANALITICARE_PO_KRITERIJUMU=26;//****************
    public static final int PRETRAZI_DELEGATE_PO_KRITERIJUMU=28;//****************
    public static final int PRETRAZI_TIMOVE_PO_KRITERIJUMU=29;
    public static final int PRETRAZI_IGRACE_PO_KRITERIJUMU=31;
    public static final int PRETRAZI_ZAPISNIKE_PO_KRITERIJUMU2=42;//*************
    public static final int PRETRAZI_DELEGATE_PO_KRITERIJUMU2=43;//***************
    public static final int PRETRAZI_ANALITICARE_PO_KRITERIJUMU2=44;//***********
    
    public static final int KREIRAJ_IGRACA=32;//*********************
    public static final int PRETRAZI_IGRACA=33;
    public static final int PROMENI_IGRACA=34;
    public static final int OBRISI_IGRACA=35;
    
}

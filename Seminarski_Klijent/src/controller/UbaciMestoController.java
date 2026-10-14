/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import forme.UbacivanjeMesta;
import forme.ModelTabeleMesto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modeli.Analiticar;
import modeli.Mesto;
/**
 *
 * @author Katarina
 */
public class UbaciMestoController {
    private final UbacivanjeMesta kmf;
    
    
    public UbaciMestoController(UbacivanjeMesta kmf){
        this.kmf=kmf;
        addActionListener();
    }
    
    private Analiticar ulogovani;
    //Mesto zaUnos = new Mesto();
    //private Mesto zaUnos=null;
    
    
    public void addActionListener(){
    
        /*kmf.BtnKreirajMestoActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    String naziv = kmf.getTxtNaziv().getText();
                    int brSt = Integer.parseInt(kmf.getTxtBrS().getText());
                    
                    ulogovani = kordinatorFormi.Kordinator.getInstance().getUlogovani();
                    List<Mesto> mesta = new ArrayList<>();
                    mesta = komunikacija.Komunikacija.getInstance().ucitajMesta();
                    
                    Mesto m = new Mesto(-1,naziv,brSt);
                    zaUnos = m;
                    //mesta.add(zaUnos);
                    JOptionPane.showMessageDialog(kmf, "Sistem je kreirao mesto.", "USPEH", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(kmf, "Sistem ne moze da kreira mesto.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });*/
        
        kmf.BtnZapamtiMestoActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    //zaUnos.setIdMesta(-1);
                    String naziv = kmf.getTxtNaziv().getText().trim();
                    String brojSt = kmf.getTxtBrS().getText().trim();
                    //int brSt = Integer.parseInt(kmf.getTxtBrS().getText());
                    
                    ulogovani = kordinatorFormi.Kordinator.getInstance().getUlogovani();
                    List<Mesto> mesta = new ArrayList<>();
                    mesta = komunikacija.Komunikacija.getInstance().ucitajMesta();
                    
                    if(!naziv.isEmpty() && !brojSt.isEmpty()){
                        int brSt = Integer.parseInt(brojSt);
                        if(brSt<=0){
                            JOptionPane.showMessageDialog(kmf, "Broj stanovnika mora da bude veci od 0.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        Mesto m = new Mesto(-1,naziv,brSt);
                        /*if(zaUnos==null){
                            JOptionPane.showMessageDialog(kmf, "Prvo mora da se kreira mesto.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                            return;
                        }*/
                    
                        komunikacija.Komunikacija.getInstance().kreirajMesto(m);
                        JOptionPane.showMessageDialog(kmf, "Sistem je zapamtio mesto.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        kmf.getTxtNaziv().setText("");
                        kmf.getTxtBrS().setText("");
                        osveziTabelu();
                    }
                    else{
                        JOptionPane.showMessageDialog(kmf, "Svi atributi moraju biti popunjeni.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(kmf,"Broj stanovnika mora biti ceo broj.","GRESKA",JOptionPane.ERROR_MESSAGE);
                } 
                catch (Exception er) {
                    JOptionPane.showMessageDialog(kmf, "Sistem ne moze da zapamti mesto.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
       
        });
    }
    
    public void otvori(){
        osveziTabelu();
        kmf.setVisible(true);
    }
    
    public void osveziTabelu(){
        List<Mesto> mesta = new ArrayList<>();
        mesta = komunikacija.Komunikacija.getInstance().ucitajMesta();        
        ModelTabeleMesto mtm = new ModelTabeleMesto(mesta);
        kmf.getTableMesta().setModel(mtm);
    }
}

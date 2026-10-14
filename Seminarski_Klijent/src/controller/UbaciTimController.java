/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import forme.UbaciTim;
import forme.ModelTabeleTim;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;
import modeli.Analiticar;
import modeli.Tim;
/**
 *
 * @author Katarina
 */
public class UbaciTimController {
    private final UbaciTim ktf;
    
    public UbaciTimController(UbaciTim ktf){
        this.ktf=ktf;
        addActionListener();
    }
    
    public void srediFormu(){
        List<Tim> timovi = komunikacija.Komunikacija.getInstance().ucitajTim();
        ModelTabeleTim mtt = new ModelTabeleTim(timovi);
        ktf.getTableTimovi().setModel(mtt);
    }
    
    private Analiticar ulogovani;
    
    
    
    public void addActionListener(){
        
        /*ktf.BtnKreirajTimActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    String naziv = ktf.getTxtNaziv().getText();
                    String brC = ktf.getTxtBrCl().getText();
                    String brP = ktf.getTxtBrPob().getText();
                    
                    ulogovani = kordinatorFormi.Kordinator.getInstance().getUlogovani();
                    if(!naziv.isEmpty() && !brC.isEmpty() && !brP.isEmpty()){
                        Tim t = new Tim(-1,naziv,Integer.parseInt(brC),Integer.parseInt(brP));
                        zaUnos = t;
                        JOptionPane.showMessageDialog(ktf, "Sistem je kreirao tim.", "USPEH", JOptionPane.INFORMATION_MESSAGE);

                        ktf.getBtnZapamti().setEnabled(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(ktf, "Morate popuniti sve atribute.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    }
 
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ktf, "Sistem ne moze da kreira tim.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });*/
        
        ktf.BtnZapamtiTimActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    
                    String naziv = ktf.getTxtNaziv().getText().trim();
                    String brC = ktf.getTxtBrCl().getText().trim();
                    String brP = ktf.getTxtBrPob().getText().trim();
                    
                    // Provera da li su sva polja popunjena
                    if (!naziv.isEmpty()&& !brC.isEmpty() && !brP.isEmpty()) {

                        int brojClanova = Integer.parseInt(brC);
                        int brojPobeda = Integer.parseInt(brP);

                        // Broj clanova mora biti veci od 0
                        if (brojClanova <= 0) {
                            JOptionPane.showMessageDialog(ktf,"Broj clanova mora da bude veci od 0.","GRESKA",JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Broj pobeda ne moze biti negativan
                        if (brojPobeda < 0) {
                            JOptionPane.showMessageDialog(ktf,"Broj pobeda ne moze biti negativan.","GRESKA",JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        Tim zaUnos = new Tim(-1,naziv,brojClanova,brojPobeda); 
                        komunikacija.Komunikacija.getInstance().kreirajTim(zaUnos);
                        JOptionPane.showMessageDialog(ktf, "Sistem je zapamtio tim.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        ktf.getTxtNaziv().setText("");
                        ktf.getTxtBrCl().setText("");
                        ktf.getTxtBrPob().setText("");
                        srediFormu();
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ktf,"Broj clanova i broj pobeda moraju biti celi brojevi.","GRESKA",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception er) {
                    JOptionPane.showMessageDialog(ktf, "Sistem ne moze da zapamti tim.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    public void otvori(){
        ktf.setVisible(true);
        srediFormu();
    }
    
}

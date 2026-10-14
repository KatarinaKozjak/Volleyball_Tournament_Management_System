/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import modeli.Analiticar;

/**
 *
 * @author Katarina
 */
public class LoginController {
    
    private final LoginForma lf;
    
    public LoginController(LoginForma lf) {
       this.lf = lf;
       addActionListener();
    }
    
    private void addActionListener() {
        lf.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username= String.valueOf(lf.getTxtUsername().getText());
                    String password=String.valueOf(lf.getTxtPassword().getPassword());
                    //komunikacija.Komunikacija.getInstance().konekcija();
                    //System.out.println(username);
                    //System.out.println(password);
                    Analiticar ulogovan = komunikacija.Komunikacija.getInstance().login(username,password);
                    if(ulogovan==null)
                    {
                       JOptionPane.showMessageDialog(lf, "Korisnicko ime i sifra nisu ispravni","GRESKA",JOptionPane.ERROR_MESSAGE);  
                    }
                    else{
                        JOptionPane.showMessageDialog(lf, "Korisničko ime i šifra su ispravni.", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        kordinatorFormi.Kordinator.getInstance().setUlogovani(ulogovan);
                        try {
                            kordinatorFormi.Kordinator.getInstance().otvoriGF(); 
                        
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(lf, "Ne moze da se otvori glavna forma u meni","GRESKA",JOptionPane.ERROR_MESSAGE);
                        }         
                   }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(lf, "Korisnicko ime i sifra nisu ispravni.","GRESKA",JOptionPane.ERROR_MESSAGE);    
                }
            }
        });
    }
    
    
    public void otvori() {
        lf.setVisible(true);
        komunikacija.Komunikacija.getInstance().konekcija();
    }
    
}

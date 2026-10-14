/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import forme.GlavnaForma;
import modeli.Analiticar;

/**
 *
 * @author Katarina
 */
public class GlavnaController {
    private final GlavnaForma gf;
    private Analiticar ulogovani;
    
    
    public GlavnaController(GlavnaForma gf)
    {
        this.gf=gf;
        addActionListener();
    }

    private void addActionListener() {}
    
    
    public void otvori() {
        gf.setVisible(true);
        ulogovani=kordinatorFormi.Kordinator.getInstance().getUlogovani();
        String imePr=ulogovani.getImeAnaliticara()+" "+ulogovani.getPrezimeAnaliticara();
        gf.getTxtIme().setText(ulogovani.getImeAnaliticara());
        gf.getTxtPrezime().setText(ulogovani.getPrezimeAnaliticara());
    }
}

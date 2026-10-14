/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;


import java.net.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Katarina
 */
public class Server extends Thread{
    private boolean kraj=false;
    private ServerSocket serverSoket;
    private List<Obrada_Klijentskih_Zahteva> klijenti=new LinkedList<>();

    @Override
    public void run() {
       try {
            serverSoket=new ServerSocket(9000);
            System.out.println("Serverski soket je otvoren");
            try {
               while (!kraj) {                
                Socket s=serverSoket.accept();
                System.out.println("Klijent je povezan");
                Obrada_Klijentskih_Zahteva nit=new Obrada_Klijentskih_Zahteva(s);
                klijenti.add(nit);
                nit.start();
            }
           } catch (SocketException e) {
           }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    
  
    public void zaustaviServer(){
        kraj=true;
        try {
            for (int i = 0; i < klijenti.size(); i++) {
                klijenti.get(i).zaustaviKlijenta();
            }
            serverSoket.close();
            System.out.println("Serverski soket je zatvoren.");
            this.interrupt();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

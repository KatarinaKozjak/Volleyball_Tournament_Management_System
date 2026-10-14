/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konfiguracija;

import java.util.Properties;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Katarina
 */
public class Konfiguracija {
    private static Konfiguracija instance;
    private Properties konfiguracija;
    private static final Path config_path = Paths.get("configuration", "config.properties");
    
    private Konfiguracija(){
        konfiguracija=new Properties();
        try (InputStream input = Files.newInputStream(config_path)) {
            konfiguracija.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, "Greška pri učitavanju konfiguracije", ex);
        }
    }
    
    public static Konfiguracija getInstance(){
        if(instance==null){
            instance=new Konfiguracija();
        }
        return instance;
    }
    
    public String getProperty(String key){
        return konfiguracija.getProperty(key,"n/a");
    }
    
    public void setProperty(String key,String value){
        konfiguracija.setProperty(key, value);
    }
    
    public void sacuvajIzmene(){
        try {
            Files.createDirectories(config_path.getParent());
            try(OutputStream output = Files.newOutputStream(config_path)){
                konfiguracija.store(output,null);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, "Greška pri čuvanju konfiguracije", ex);
        }
    }
}

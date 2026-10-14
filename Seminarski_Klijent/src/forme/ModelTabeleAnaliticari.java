/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.Analiticar;
/**
 *
 * @author Katarina
 */
public class ModelTabeleAnaliticari extends AbstractTableModel{

    List<Analiticar> analiticari;
    private String [] kolone = {"Id_Analiticar","Ime","Prezime","Email"};
    
    public ModelTabeleAnaliticari(List<Analiticar> lista){
        
        if(lista==null){this.analiticari=new LinkedList<>();}
        else{this.analiticari=lista;}
    
    }
    
    @Override
    public int getRowCount() {
        if(analiticari==null){return 0;}
        return analiticari.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(analiticari == null || rowIndex >=analiticari.size()){return null;}
        
        Analiticar a = analiticari.get(rowIndex);
        switch(columnIndex){
            case 0:
                return a.getIdAnaliticara();
            case 1:
                return a.getImeAnaliticara();
            case 2:
                return a.getPrezimeAnaliticara();
            case 3:
                return a.getEmailAnaliticara();
            default:
                return "N/A";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (analiticari == null || rowIndex >= analiticari.size()) return;

        Analiticar a = analiticari.get(rowIndex);

        switch (columnIndex) {
            case 1:
                a.setImeAnaliticara(value.toString());
                break;
            case 2:
                a.setPrezimeAnaliticara(value.toString());
                break;
            case 3:
                a.setEmailAnaliticara(value.toString());
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public List<Analiticar> getListaAnaliticara() {
        return analiticari;
    }

    public void setListaAnaliticari(List<Analiticar> lista) {
        if (analiticari == null) {
            this.analiticari = new LinkedList<>();
        } else {
            this.analiticari = lista;
        }
        fireTableDataChanged();
    }

    public Analiticar getAnaliticarAt(int index) {
        if (index >= 0 && index < analiticari.size()) {
            return analiticari.get(index);
        }
        return null;
    }
    
}

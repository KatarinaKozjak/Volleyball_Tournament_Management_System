/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.Delegat;

/**
 *
 * @author Katarina
 */
public class ModelTabeleDelegat extends AbstractTableModel{

    private List<Delegat> listaDelegata;
    private String[] kolone = {"Id_Delegat","Ime","Prezime","Mesto"};
    
    public ModelTabeleDelegat(List<Delegat> lista){
        
        if(lista==null){this.listaDelegata=new LinkedList<>();}
        else{this.listaDelegata=lista;}
    
    }
    
        
    @Override
    public int getRowCount() {
        if(listaDelegata==null){return 0;}
        return listaDelegata.size();
    }

    
    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(listaDelegata == null || rowIndex >=listaDelegata.size()){return null;}
        
        Delegat d = listaDelegata.get(rowIndex);
        switch(columnIndex){
            case 0:
                return d.getIdDelegata();
            case 1:
                return d.getIme();
            case 2:
                return d.getPrezime();
            case 3:
                return d.getMesto().getNaziv();
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
        if (listaDelegata == null || rowIndex >= listaDelegata.size()) return;

        Delegat d = listaDelegata.get(rowIndex);

        switch (columnIndex) {
            case 1:
                d.setIme(value.toString());
                break;
            case 2:
                d.setPrezime(value.toString());
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public List<Delegat> getListaDelegata() {
        return listaDelegata;
    }

    public void setListaDelegat(List<Delegat> lista) {
        if (listaDelegata == null) {
            this.listaDelegata = new LinkedList<>();
        } else {
            this.listaDelegata = lista;
        }
        fireTableDataChanged();
    }

    public Delegat getDelegatAt(int index) {
        if (index >= 0 && index < listaDelegata.size()) {
            return listaDelegata.get(index);
        }
        return null;
    }
    
}

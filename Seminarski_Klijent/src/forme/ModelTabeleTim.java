/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.Tim;

/**
 *
 * @author Katarina
 */
public class ModelTabeleTim extends AbstractTableModel{

    List<Tim> timovi;
    private String [] kolone = {"Id_Tim","Naziv","Broj_Clanova","Broj_Pobeda"};
    
    public ModelTabeleTim(List<Tim> lista){
        if(lista==null){this.timovi=new LinkedList<>();}
        else{this.timovi=lista;}
    }
    
    @Override
    public int getRowCount() {
        return timovi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(timovi == null || rowIndex >=timovi.size()){return null;}
        
        Tim t = timovi.get(rowIndex);
        switch(columnIndex){
            case 0:
                return t.getIdTima();
            case 1:
                return t.getNaziv();
            case 2:
                return t.getBrClanova();
            case 3:
                return t.getBrojPobeda();
            default:
                return "N/A";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public List<Tim> getListaTimova() {
        return timovi;
    }

    public void setListaTimova(List<Tim> lista) {
        this.timovi = lista;
        fireTableDataChanged();
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (timovi == null || rowIndex >= timovi.size()) return;

        Tim t = timovi.get(rowIndex);

        switch (columnIndex) {
            case 1:
                t.setIdTima(Integer.parseInt(value.toString()));
                break;
            case 2:
                t.setNaziv(value.toString());
                break;
            case 3:
                t.setBrojClanova(Integer.parseInt(value.toString()));
                break;
            case 4:
                t.setBrojPobeda(Integer.parseInt(value.toString()));
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public Tim getTimAt(int index) {
        if (index >= 0 && index < timovi.size()) {
            return timovi.get(index);
        }
        return null;
    }
    
}

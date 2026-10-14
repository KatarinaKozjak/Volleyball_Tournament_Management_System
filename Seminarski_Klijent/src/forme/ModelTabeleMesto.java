/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;


import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.Mesto;
/**
 *
 * @author Katarina
 */
public class ModelTabeleMesto extends AbstractTableModel{

    List<Mesto> listaMesta;
    private String[] kolone = {"Id_Mesto","Naziv","Broj_Stanovnika"};
    
    public ModelTabeleMesto(List<Mesto> lista){
        if(lista==null){this.listaMesta=new LinkedList<>();}
        else{this.listaMesta=lista;}
    }
    
    @Override
    public int getRowCount() {
        return listaMesta.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(listaMesta == null || rowIndex >=listaMesta.size()){return null;}
        
        Mesto m = listaMesta.get(rowIndex);
        switch(columnIndex){
            case 0:
                return m.getIdMesta();
            case 1:
                return m.getNaziv();
            case 2:
                return m.getBrojStanovnika();
            default:
                return "N/A";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public List<Mesto> getListaMesta() {
        return listaMesta;
    }

    public void setListaMesta(List<Mesto> lista) {
        this.listaMesta = lista;
        fireTableDataChanged();
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (listaMesta == null || rowIndex >= listaMesta.size()) return;

        Mesto m = listaMesta.get(rowIndex);

        switch (columnIndex) {
            case 0:
                m.setIdMesta(Integer.parseInt(value.toString()));
                break;
            case 1:
                m.setNaziv(value.toString());
                break;
            case 2:
                m.setBrojStanovnika(Integer.parseInt(value.toString()));
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public Mesto getMestoAt(int index) {
        if (index >= 0 && index < listaMesta.size()) {
            return listaMesta.get(index);
        }
        return null;
    }
}

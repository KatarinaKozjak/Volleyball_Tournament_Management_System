/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.Igrac;
/**
 *
 * @author Katarina
 */
public class ModelTabeleIgrac extends AbstractTableModel{
    List<Igrac> igraci;
    private String[] kolone = {"Id_Igrac","Ime","Prezime","Pozicija"};
    
    public ModelTabeleIgrac(List<Igrac> lista){
        if(lista==null){this.igraci=new LinkedList<>();}
        else{this.igraci=lista;}
    }
    
    @Override
    public int getRowCount() {
        return igraci.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(igraci == null || rowIndex >=igraci.size()){return null;}
        
        Igrac i = igraci.get(rowIndex);
        switch(columnIndex){
            case 0:
                return i.getIdIgraca();
            case 1:
                return i.getIme();
            case 2:
                return i.getPrezime();
            case 3:
                return i.getPozicija();
            default:
                return "N/A";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public List<Igrac> getListaIgraca() {
        return igraci;
    }

    public void setListaIgraca(List<Igrac> lista) {
        this.igraci = lista;
        fireTableDataChanged();
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (igraci == null || rowIndex >= igraci.size()) return;

        Igrac i = igraci.get(rowIndex);

        switch (columnIndex) {
            case 0:
                i.setIdIgraca(Integer.parseInt(value.toString()));
                break;
            case 1:
                i.setIme(value.toString());
                break;
            case 2:
                i.setPrezime(value.toString());
                break;
            case 3:
                i.setPozicija(value.toString());
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public Igrac getIgracAt(int index) {
        if (index >= 0 && index < igraci.size()) {
            return igraci.get(index);
        }
        return null;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.Zapisnik;
import modeli.StavkaZapisnika;

/**
 *
 * @author Katarina
 */
public class ModelTabeleStavka extends AbstractTableModel{

    private List<StavkaZapisnika> listaStavkiZapisnika = new LinkedList<>();
    private final String [] kolone = {"RB","Mesto na rang listi","Tim"};
    
    public ModelTabeleStavka(List<StavkaZapisnika> lista){
        this.listaStavkiZapisnika=lista;
    }
    
    @Override
    public int getRowCount() {
        return listaStavkiZapisnika.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaZapisnika sz = listaStavkiZapisnika.get(rowIndex);
        switch(columnIndex){
            case 0: return sz.getRB();
            case 1: return sz.getMestoNRL();
            case 2: return sz.getTim().getNaziv();
            default: return "N/A";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<StavkaZapisnika> getListaStavkeZapisnika() {
        return listaStavkiZapisnika;
    }

    public void setListaStavkeZapisnika(List<StavkaZapisnika> listaStavkiZapisnika) {
        this.listaStavkiZapisnika = listaStavkiZapisnika;
        fireTableDataChanged();
    }

    public StavkaZapisnika getStavkaZapisnikaAt(int index) {
        if (index >= 0 && index < listaStavkiZapisnika.size()) {
            return listaStavkiZapisnika.get(index);
        }
        return null;
    }
    
}

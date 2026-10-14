/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.Analiticar;
import modeli.Zapisnik;
/**
 *
 * @author Katarina
 */
public class ModelTabeleZapisnici extends AbstractTableModel{

    private List<Zapisnik> listaZapisnika = new LinkedList<>();
    private final String [] kolone = {"ID Zapisnika", "Datum pocetka", "Datum zavrsetka","Broj grupa","Ime analiticara","Prezime analiticara","Ime delegata","Prezime delegata"};
    
    public ModelTabeleZapisnici(List<Zapisnik> lista){
        this.listaZapisnika=lista;
    }
    
    @Override
    public int getRowCount() {
        return listaZapisnika.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zapisnik z =listaZapisnika.get(rowIndex);
        switch(columnIndex){
            case 0: return z.getIdZapisnika();
            case 1: return z.getDatumPocetka().toString();
            case 2: return z.getDatumZavrsetka().toString();
            case 3: return z.getBrojgrupa();
            case 4: return z.getAnaliticara().getImeAnaliticara();
            case 5: return z.getAnaliticara().getPrezimeAnaliticara();
            case 6: return z.getDelegata().getIme();
            case 7: return z.getDelegata().getPrezime();
            default: return "N/A";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Zapisnik> getListaZapisnika() {
        return listaZapisnika;
    }

    public void setListaZapisnika(List<Zapisnik> listaZapisnika) {
        this.listaZapisnika = listaZapisnika;
        fireTableDataChanged();
    }

    public Zapisnik getZapisnikAt(int index) {
        if (index >= 0 && index < listaZapisnika.size()) {
            return listaZapisnika.get(index);
        }
        return null;
    }
    
}

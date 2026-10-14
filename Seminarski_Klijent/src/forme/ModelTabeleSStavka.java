/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.SStavkaZapisnika;

/**
 *
 * @author Katarina
 */
public class ModelTabeleSStavka extends AbstractTableModel{
    private List<SStavkaZapisnika> listaSStavkiZapisnika = new LinkedList<>();
    private final String [] kolone = {"Mvp","PBlok","PServis","PIgra","Ukupno poena","Igrac"};
    
    public ModelTabeleSStavka(List<SStavkaZapisnika> lista){
        this.listaSStavkiZapisnika=lista;
    }
    
    @Override
    public int getRowCount() {
        return listaSStavkiZapisnika.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SStavkaZapisnika ssz =listaSStavkiZapisnika.get(rowIndex);
        switch(columnIndex){
            //case 0: return ssz.getZapisnik();
            //case 1: return ssz.getRedniBrojStavkuZapisnika();
            //case 2: return ssz.getRedniBrojSStavke();
            case 0: return ssz.getMvp();
            case 1: return ssz.getPoeneIzBloka();
            case 2: return ssz.getPoeneSaServisa();
            case 3: return ssz.getPoeneIzIgre();
            case 4: return ssz.getUkupnoPoena();
            case 5: return ssz.getIgrac().getIme()+" "+ssz.getIgrac().getPrezime();
            default: return "N/A";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<SStavkaZapisnika> getListaSStavkeZapisnika() {
        return listaSStavkiZapisnika;
    }

    public void setListaSStavkeZapisnika(List<SStavkaZapisnika> listaSStavkiZapisnika) {
        this.listaSStavkiZapisnika = listaSStavkiZapisnika;
        fireTableDataChanged();
    }

    public SStavkaZapisnika getSStavkaZapisnikaAt(int index) {
        if (index >= 0 && index < listaSStavkiZapisnika.size()) {
            return listaSStavkiZapisnika.get(index);
        }
        return null;
    }
}

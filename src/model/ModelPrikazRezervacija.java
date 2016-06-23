/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObjekat;
import domen.RezervacijaVoznje;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daniel
 */
public class ModelPrikazRezervacija extends AbstractTableModel {

    private List<AbstractObjekat> listaRezervacija;

    public ModelPrikazRezervacija(List<AbstractObjekat> listaRezervacija) {
        this.listaRezervacija = listaRezervacija;
    }

    @Override
    public int getRowCount() {
        return listaRezervacija.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RezervacijaVoznje rezv = (RezervacijaVoznje) listaRezervacija.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rezv.getRezevacijaID();
            case 1:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                return sdf.format(rezv.getDatumRezervacije());
            case 2:
                return rezv.isUplataUnapred() ? "DA" : "NE";
            case 3:
                return rezv.getVozac().getIme();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Rezervacija ID";
            case 1:
                return "Datum rezervacije";
            case 2:
                return "Uplata unapred?";
            case 3:
                return "Vozac";
            default:
                return "N/A";
        }
    }

    public List<AbstractObjekat> getListaRezervacija() {
        return listaRezervacija;
    }

    public void setListaRezervacija(List<AbstractObjekat> listaRezervacija) {
        this.listaRezervacija = listaRezervacija;
    }

}

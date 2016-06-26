/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObjekat;
import domen.Vozac;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daniel
 */
public class ModelVozac extends AbstractTableModel {

    private List<AbstractObjekat> listaVozaca;

    public ModelVozac(List<AbstractObjekat> listaVozaca) {
        this.listaVozaca = listaVozaca;
    }

    @Override
    public int getRowCount() {
        return listaVozaca.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Ime";
            case 1:
                return "e-mail";
            case 2:
                return "Datum prve voznje";
            default:
                return "N/A";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vozac v = (Vozac) listaVozaca.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return v.getIme();
            case 1:
                return v.getMail();
            case 2:
                return v.getDatumPrveVoznje();
            default:
                return "N/A";
        }
    }

    public List<AbstractObjekat> getListaVozaca() {
        return listaVozaca;
    }

    public void setListaVozaca(List<AbstractObjekat> listaVozaca) {
        this.listaVozaca = listaVozaca;
    }

}

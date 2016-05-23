/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObjekat;
import domen.MotorneSanke;
import domen.StavkaRezervacijeVoznje;
import java.sql.Savepoint;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daniel
 */
public class ModelStavka extends AbstractTableModel {

    private List<StavkaRezervacijeVoznje> listaStavki;
    int max = 0;

    public ModelStavka(List<StavkaRezervacijeVoznje> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public int getRowCount() {
        return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRezervacijeVoznje o = (StavkaRezervacijeVoznje) listaStavki.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return o.getRedniBrojStavke();
            case 1:
                return o.getMotorneSanke();
            default:
                return "N/A";
        }

    }

    public List<StavkaRezervacijeVoznje> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaRezervacijeVoznje> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StavkaRezervacijeVoznje o = (StavkaRezervacijeVoznje) listaStavki.get(rowIndex);
        switch (columnIndex) {
            case 0:
                o.setRedniBrojStavke((int) aValue);
                break;
            case 1:
                o.setMotorneSanke((MotorneSanke) aValue);
                break;
            default:
                System.out.println("DEFAULT");
                break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return false;
            case 1:
                return true;
            default:
                return false;
        }
    }

    public void dodajNovuStavku() {
        StavkaRezervacijeVoznje nova = new StavkaRezervacijeVoznje();
        nova.setRedniBrojStavke(max++);
        listaStavki.add(nova);
        fireTableDataChanged();
    }

}

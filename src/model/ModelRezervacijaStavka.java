/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.MotorneSanke;
import domen.StavkaRezervacijeVoznje;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import konstante.Konstante;

/**
 *
 * @author Daniel
 */
public class ModelRezervacijaStavka extends AbstractTableModel {

    private List<StavkaRezervacijeVoznje> listaStavki;
    int max = 0;

    public ModelRezervacijaStavka(List<StavkaRezervacijeVoznje> listaStavki) {
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
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StavkaRezervacijeVoznje o = (StavkaRezervacijeVoznje) listaStavki.get(rowIndex);
        switch (columnIndex) {
            case 0:
                o.setRedniBrojStavke((int) aValue);
                o.setStatus(Konstante.STATUS_IZMENJEN);
                break;
            case 1:
                o.setMotorneSanke((MotorneSanke) aValue);
                o.setStatus(Konstante.STATUS_IZMENJEN);
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
        nova.setStatus(Konstante.STATUS_NOVI);
        nova.setRedniBrojStavke(max++);
        listaStavki.add(nova);
        fireTableDataChanged();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.MotorneSanke;
import domen.StavkaRezervacijeVoznje;
import domen.TipSanki;
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
        max = listaStavki.size();
    }

    @Override
    public int getRowCount() {
        return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Redni Broj";
            case 1:
                return "Broj Sasije";
            case 2:
                return "Broj Mesta";
            case 3:
                return "Naziv Tipa";
            default:
                return "N/A";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRezervacijeVoznje o = (StavkaRezervacijeVoznje) listaStavki.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return o.getRedniBrojStavke();
            case 1:
                return o.getMotorneSanke().getBrojSasije();
            case 2:
                return o.getMotorneSanke().getBrojMestaZaSedenje();
            case 3:
                return o.getMotorneSanke().getTipSanki().getNazivTipa();
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
            case 1:
                o.setMotorneSanke((MotorneSanke) aValue);
                fireTableDataChanged();
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
        nova.setMotorneSanke(new MotorneSanke("", "", "", new TipSanki("", "", "", 0)));
        listaStavki.add(nova);
        fireTableDataChanged();
    }

}

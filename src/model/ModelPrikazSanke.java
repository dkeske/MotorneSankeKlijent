/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObjekat;
import domen.MotorneSanke;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daniel
 */
public class ModelPrikazSanke extends AbstractTableModel {

    List<AbstractObjekat> listaSanki;

    public ModelPrikazSanke(List<AbstractObjekat> listaSanki) {
        this.listaSanki = listaSanki;
    }

    @Override
    public int getRowCount() {
        return listaSanki.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MotorneSanke ms = (MotorneSanke) listaSanki.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ms.getMotorneSankeID();
            case 1:
                return ms.getBrojSasije();
            case 2:
                return ms.getBrojMestaZaSedenje();
            case 3:
                return ms.getTipSanki();
            default:
                return "n/a";
        }
    }

}

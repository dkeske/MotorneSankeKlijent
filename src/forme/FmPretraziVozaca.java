/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.AbstractObjekat;
import domen.Vozac;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import model.ModelVozac;

/**
 *
 * @author Daniel
 */
public class FmPretraziVozaca extends javax.swing.JFrame {

    /**
     * Creates new form FmPretraziVozaca
     */
    ModelVozac mvo;
    JFrame parent;
    public FmPretraziVozaca(JFrame parent) {
        initComponents();
        srediFormu();
        this.parent = parent;
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_pretraga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_vozaci = new javax.swing.JTable();
        btn_odaberi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_pretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pretragaKeyReleased(evt);
            }
        });

        tbl_vozaci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_vozaci);

        btn_odaberi.setText("Odaberi");
        btn_odaberi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_odaberiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_odaberi)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(txt_pretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_pretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_odaberi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pretragaKeyReleased
        // TODO add your handling code here:
        try {
            String pretraga = txt_pretraga.getText();
            List<AbstractObjekat> listaFilter;
            if (pretraga.isEmpty()) {
                listaFilter = Kontroler.vratiInstancuKontrolera().ucitajListuVozaca();
            } else {
                listaFilter = Kontroler.vratiInstancuKontrolera().pretraziVozace(pretraga);
            }
            mvo.setListaVozaca(listaFilter);
            mvo.fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(FmPretraziVozaca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txt_pretragaKeyReleased

    private void btn_odaberiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_odaberiActionPerformed
        // TODO add your handling code here:
        if(tbl_vozaci.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(rootPane, "Odaberite nekog vozaca!");
        } else {
            Vozac vv = (Vozac) mvo.getListaVozaca().get(tbl_vozaci.getSelectedRow());
            FmRezervacija fmr = (FmRezervacija) parent;
            fmr.postaviVozacaSelekt(vv);
            dispose();
        }
    }//GEN-LAST:event_btn_odaberiActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_odaberi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_vozaci;
    private javax.swing.JTextField txt_pretraga;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        try {

            List<AbstractObjekat> listaVozaca = Kontroler.vratiInstancuKontrolera().ucitajListuVozaca();
            mvo = new ModelVozac(listaVozaca);
            tbl_vozaci.setModel(mvo);
        } catch (Exception ex) {
            Logger.getLogger(FmPretraziVozaca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
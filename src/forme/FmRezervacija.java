/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.AbstractObjekat;
import domen.MotorneSanke;
import domen.RezervacijaVoznje;
import domen.StavkaRezervacijeVoznje;
import domen.Vozac;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import model.ModelRezervacijaStavka;

/**
 *
 * @author Daniel
 */
public class FmRezervacija extends javax.swing.JFrame {
    
    ModelRezervacijaStavka modelS;
    String mode = "create";
    JFrame parent;
    List<AbstractObjekat> listaDostupnihSanki;
    JComboBox cbox_ms;
    
    public void setParent(JFrame parent) {
        this.parent = parent;
    }

    /**
     * Creates new form FmRezervacija
     */
    public FmRezervacija() {
        initComponents();
        popuniFormu();
        txt_rezervacija_id.setEnabled(false);
    }
    
    public FmRezervacija(RezervacijaVoznje rez) {
        initComponents();
        popuniFormu();
        txt_rezervacija_id.setEnabled(false);
        ucitajRezervaciju(rez);
        mode = "edit";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_rezervacija_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_datum_rezervacije = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_stavke = new javax.swing.JTable();
        rbtn_uplata = new javax.swing.JRadioButton();
        cbox_vozac = new javax.swing.JComboBox();
        btn_plus = new javax.swing.JButton();
        btn_minus = new javax.swing.JButton();
        btn_sacuvaj = new javax.swing.JButton();
        btn_nadji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Rezervacija ID");

        jLabel2.setText("Datum rezervacije");

        jLabel3.setText("Uplata unapred");

        jLabel4.setText("Vozac");

        tbl_stavke.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_stavke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stavkeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_stavke);

        rbtn_uplata.setText("Da");

        cbox_vozac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_plus.setText("+");
        btn_plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_plusActionPerformed(evt);
            }
        });

        btn_minus.setText("-");
        btn_minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minusActionPerformed(evt);
            }
        });

        btn_sacuvaj.setText("Sacuvaj");
        btn_sacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sacuvajActionPerformed(evt);
            }
        });

        btn_nadji.setText("Nadji");
        btn_nadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nadjiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_sacuvaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(rbtn_uplata)
                    .addComponent(txt_rezervacija_id)
                    .addComponent(txt_datum_rezervacije)
                    .addComponent(cbox_vozac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_nadji)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_minus, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_plus))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_rezervacija_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_datum_rezervacije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(rbtn_uplata)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbox_vozac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_nadji)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btn_plus)
                        .addGap(44, 44, 44)
                        .addComponent(btn_minus)))
                .addGap(18, 18, 18)
                .addComponent(btn_sacuvaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_plusActionPerformed
        // TODO add your handling code here:
        modelS.dodajNovuStavku();
    }//GEN-LAST:event_btn_plusActionPerformed

    private void btn_minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minusActionPerformed
        if (tbl_stavke.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(parent, "Molim vas odaberite stavku!");
        } else {
            modelS.getListaStavki().remove(tbl_stavke.getSelectedRow());
            int i = 1;
            for (StavkaRezervacijeVoznje stavka : modelS.getListaStavki()) {
                stavka.setRedniBrojStavke(i++);
            }
            modelS.fireTableDataChanged();
        }
    }//GEN-LAST:event_btn_minusActionPerformed

    private void btn_sacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sacuvajActionPerformed
        try {
            String RezID = txt_rezervacija_id.getText();
            String datum = txt_datum_rezervacije.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datume = sdf.parse(datum);
            boolean unapred = rbtn_uplata.isSelected();
            Vozac vozac = (Vozac) cbox_vozac.getSelectedItem();
            List<StavkaRezervacijeVoznje> listaStavki = modelS.getListaStavki();
//            JOptionPane.showMessageDialog(parent, listaStavki.size());
            for (StavkaRezervacijeVoznje stavkaRezervacijeVoznje : listaStavki) {
                if (stavkaRezervacijeVoznje.getMotorneSanke().getBrojSasije().equals("")) {
                    throw new Exception("Svaka stavka mora imati sanke!");
                }
            }
            proveriDupleUnose();
            if (mode.equals("create")) {
                RezervacijaVoznje rzv = new RezervacijaVoznje("0", datume, unapred, vozac, listaStavki);
                RezervacijaVoznje rzvNova = (RezervacijaVoznje) Kontroler.vratiInstancuKontrolera().sacuvajRezervaciju(rzv);
                txt_rezervacija_id.setText(rzvNova.getRezevacijaID());
                JOptionPane.showMessageDialog(rootPane, "Uspesno sacuvana rezervacija!");
                
            } else {
                RezervacijaVoznje izmenjena = new RezervacijaVoznje(RezID, datume, unapred, vozac, listaStavki);
                ArrayList<StavkaRezervacijeVoznje> novaLista = new ArrayList<>();
                for (StavkaRezervacijeVoznje stavkaRezervacijeVoznje : listaStavki) {
                    stavkaRezervacijeVoznje.setRezervacijaVoznje(izmenjena);
                    novaLista.add(stavkaRezervacijeVoznje);
                }
                izmenjena.setListaStavki(novaLista);
                RezervacijaVoznje izBaze = (RezervacijaVoznje) Kontroler.vratiInstancuKontrolera().izmeniRezervaciju(izmenjena);
                JOptionPane.showMessageDialog(rootPane, "Uspesno izmenjena rezervacija!");
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Datum nije unet pravilno!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }

    }//GEN-LAST:event_btn_sacuvajActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (mode.equals("edit") && (parent instanceof FmRezervacijePrikaz)) {
            FmRezervacijePrikaz stara = (FmRezervacijePrikaz) parent;
            FmRezervacijePrikaz nova = new FmRezervacijePrikaz();
            nova.setParent(stara.parent);
            nova.setVisible(true);
        } else {
            parent.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btn_nadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nadjiActionPerformed
        // TODO add your handling code here:
        FmPretraziVozaca fmpv = new FmPretraziVozaca(this);
        fmpv.setVisible(true);
    }//GEN-LAST:event_btn_nadjiActionPerformed

    private void tbl_stavkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stavkeMouseClicked
        
    }//GEN-LAST:event_tbl_stavkeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FmRezervacija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FmRezervacija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FmRezervacija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FmRezervacija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FmRezervacija().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_minus;
    private javax.swing.JButton btn_nadji;
    private javax.swing.JButton btn_plus;
    private javax.swing.JButton btn_sacuvaj;
    private javax.swing.JComboBox cbox_vozac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtn_uplata;
    private javax.swing.JTable tbl_stavke;
    private javax.swing.JTextField txt_datum_rezervacije;
    private javax.swing.JTextField txt_rezervacija_id;
    // End of variables declaration//GEN-END:variables

    private void popuniFormu() {
        try {
            List<AbstractObjekat> lista = Kontroler.vratiInstancuKontrolera().ucitajListuVozaca();
            cbox_vozac.setModel(new DefaultComboBoxModel(lista.toArray()));
            listaDostupnihSanki = Kontroler.vratiInstancuKontrolera().ucitajListuMotornihSanki();
            
            cbox_ms = new JComboBox(listaDostupnihSanki.toArray());
//            cbox_ms.addItemListener(new ItemListener() {
//                @Override
//                public void itemStateChanged(ItemEvent e) {
//                    try {
//                        if (e.getStateChange() == ItemEvent.SELECTED) {
//                            Object obj = e.getItem();
//                            System.out.println("OBJEKAT : " + obj);
//                            listaDostupnihSanki = Kontroler.vratiInstancuKontrolera().ucitajListuMotornihSanki();
//                            for (StavkaRezervacijeVoznje stavkaRezervacijeVoznje : modelS.getListaStavki()) {
//                                if (!stavkaRezervacijeVoznje.getMotorneSanke().getMotorneSankeID().equals("")) {
//                                    listaDostupnihSanki.remove(stavkaRezervacijeVoznje.getMotorneSanke());
//                                }
//                            }
//                            cbox_ms.setModel(new DefaultComboBoxModel(listaDostupnihSanki.toArray()));
//                        }
//                    } catch (Exception ex) {
//                        Logger.getLogger(FmRezervacija.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            });
            modelS = new ModelRezervacijaStavka(new ArrayList<StavkaRezervacijeVoznje>());
            tbl_stavke.setModel(modelS);
            tbl_stavke.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(cbox_ms));
            tbl_stavke.setColumnSelectionAllowed(true);
            
        } catch (Exception ex) {
            Logger.getLogger(FmRezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void ucitajRezervaciju(RezervacijaVoznje rez) {
        txt_rezervacija_id.setText(rez.getRezevacijaID());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        txt_datum_rezervacije.setText(sdf.format(rez.getDatumRezervacije()));
        rbtn_uplata.setSelected(rez.isUplataUnapred());
        cbox_vozac.setSelectedItem(rez.getVozac());
        modelS.setListaStavki(rez.getListaStavki());
        for (StavkaRezervacijeVoznje stavkaRezervacijeVoznje : rez.getListaStavki()) {
            listaDostupnihSanki.remove(stavkaRezervacijeVoznje.getMotorneSanke());
        }
    }
    
    public void postaviVozacaSelekt(Vozac v) {
        cbox_vozac.setSelectedItem(v);
    }

    private void proveriDupleUnose() throws Exception {
        for (StavkaRezervacijeVoznje stav : modelS.getListaStavki()) {
            int i = 0;
            for (StavkaRezervacijeVoznje stavkaRezervacijeVoznje : modelS.getListaStavki()) {
                if(stav.getMotorneSanke().equals(stavkaRezervacijeVoznje.getMotorneSanke())){
                    i++;
                    if(i==2){
                        throw new Exception("Ne mozete rezervisati iste sanke vise puta!");
                    }
                }
            }
        }

    }
    
}

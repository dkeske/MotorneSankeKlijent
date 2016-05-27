/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.AbstractObjekat;
import domen.MotorneSanke;
import domen.TipSanki;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author Daniel
 */
public class FmMotorneSanke extends javax.swing.JFrame {

    private MotorneSanke ms;
    FmSankePrikaz parent;
    String mode;

    /**
     * Creates new form FmMotorneSanke
     */
    public FmMotorneSanke() {
        initComponents();
        pripremiFormu();
        mode = "create";
    }

    public FmMotorneSanke(MotorneSanke ms, FmSankePrikaz parent) throws HeadlessException {
        initComponents();
        pripremiFormu();
        this.ms = ms;
        ucitajSankeUFormu();
        this.parent = parent;
        this.parent.setEnabled(false);
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

        jLabel1 = new javax.swing.JLabel();
        txt_motorne_sanke_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_broj_sasije = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_broj_mesta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbox_tip_sanki = new javax.swing.JComboBox();
        btn_sacuvaj = new javax.swing.JButton();
        btn_ponisti = new javax.swing.JButton();
        btn_otkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Motorne sanke ID");

        jLabel2.setText("Broj sasije");

        jLabel3.setText("Broj mesta za sedenje");

        jLabel4.setText("Tip sanki");

        cbox_tip_sanki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_tip_sankiActionPerformed(evt);
            }
        });

        btn_sacuvaj.setText("Sacuvaj");
        btn_sacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sacuvajActionPerformed(evt);
            }
        });

        btn_ponisti.setText("Ponisti");
        btn_ponisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ponistiActionPerformed(evt);
            }
        });

        btn_otkazi.setText("Otkazi");
        btn_otkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_otkaziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(btn_sacuvaj))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_ponisti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_otkazi))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_motorne_sanke_id)
                            .addComponent(txt_broj_sasije)
                            .addComponent(txt_broj_mesta)
                            .addComponent(cbox_tip_sanki, 0, 159, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_motorne_sanke_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_broj_sasije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_broj_mesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(cbox_tip_sanki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sacuvaj)
                    .addComponent(btn_ponisti)
                    .addComponent(btn_otkazi))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sacuvajActionPerformed
        // TODO add your handling code here:
        try {
            String motorneSankeID = txt_motorne_sanke_id.getText();
            String brojSasije = txt_broj_sasije.getText();
            String brojMesta = txt_broj_mesta.getText();
            TipSanki tip = (TipSanki) cbox_tip_sanki.getSelectedItem();
            MotorneSanke motorneSanke = kreirajMotorneSanke(motorneSankeID, brojSasije, brojMesta, tip);
            MotorneSanke motS = (MotorneSanke) Kontroler.vratiInstancuKontrolera().sacuvajMotorneSanke(motorneSanke);
//            String ID = motS.getPrimaryKey();
//            if (mode.equals("edit")) {
                String ID = motS.getMotorneSankeID();
//            }
            JOptionPane.showMessageDialog(rootPane, "Uspesno sacuvane sanke ID : " + ID);
            txt_motorne_sanke_id.setText(ID);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btn_sacuvajActionPerformed

    private void btn_ponistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ponistiActionPerformed
        // TODO add your handling code here:
        txt_motorne_sanke_id.setText("");
        txt_broj_sasije.setText("");
        txt_broj_mesta.setText("");

    }//GEN-LAST:event_btn_ponistiActionPerformed

    private void btn_otkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_otkaziActionPerformed
        formClosing();
    }//GEN-LAST:event_btn_otkaziActionPerformed

    private void formClosing() {
        setVisible(false);
        if (mode.equals("edit")) {
            parent.dispose();
            parent = new FmSankePrikaz();
            parent.setVisible(true);
        }
        dispose();
    }

    private void cbox_tip_sankiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_tip_sankiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_tip_sankiActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (mode.equals("edit")) {
            formClosing();
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(FmMotorneSanke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FmMotorneSanke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FmMotorneSanke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FmMotorneSanke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FmMotorneSanke().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_otkazi;
    private javax.swing.JButton btn_ponisti;
    private javax.swing.JButton btn_sacuvaj;
    private javax.swing.JComboBox cbox_tip_sanki;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txt_broj_mesta;
    private javax.swing.JTextField txt_broj_sasije;
    private javax.swing.JTextField txt_motorne_sanke_id;
    // End of variables declaration//GEN-END:variables

    private MotorneSanke kreirajMotorneSanke(String motorneSankeID, String brojSasije, String brojMesta, TipSanki tip) throws Exception {
        MotorneSanke msanke = new MotorneSanke();
//        if (motorneSankeID == null || motorneSankeID.isEmpty()){
//            throw new Exception("ID nije unet!");
//        }
        if (brojSasije.isEmpty() || brojMesta.isEmpty() || tip == null) {
            throw new Exception("Sva polja su obavezna!");
        }
        try {
            double broj = Double.parseDouble(brojMesta);
        } catch (NumberFormatException nfe) {
            throw new Exception("Broj mesta za sedenje nije dobro unet!");
        }
        if (mode.equals("edit")) {
            System.out.println(mode + " je mode");
            msanke.setMotorneSankeID(motorneSankeID);
        } else {
            msanke.setMotorneSankeID("0");
        }
        msanke.setBrojSasije(brojSasije);
        msanke.setBrojMestaZaSedenje(brojMesta);
        msanke.setTipSanki(tip);
        return msanke;
    }

    private void pripremiFormu() {
        popuniComboBox();
        txt_motorne_sanke_id.setEnabled(false);
    }

    private void popuniComboBox() {
        cbox_tip_sanki.removeAllItems();
        try {
            List<AbstractObjekat> listaTipovaMS = Kontroler.vratiInstancuKontrolera().ucitajListuTipovaMS();
            cbox_tip_sanki.setModel(new DefaultComboBoxModel<>(listaTipovaMS.toArray()));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    private void ucitajSankeUFormu() {
        txt_motorne_sanke_id.setText(ms.getMotorneSankeID());
        txt_broj_sasije.setText(ms.getBrojSasije());
        txt_broj_mesta.setText(ms.getBrojMestaZaSedenje());
        cbox_tip_sanki.setSelectedItem(ms.getTipSanki());
    }
}

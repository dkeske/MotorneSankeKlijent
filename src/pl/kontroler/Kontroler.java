/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kontroler;

import domen.AbstractObjekat;
import domen.MotorneSanke;
import domen.TipSanki;
import java.io.IOException;
import komunikacija.Komunikacija;
import java.util.HashMap;
import java.util.List;
import transfer.KlijentTransfer;
import transfer.ServerTransfer;

/**
 *
 * @author Daniel
 */
public class Kontroler {
    private static Kontroler instanca;
    private HashMap sesija;
    
    public static Kontroler vratiInstancuKontrolera(){
        if(instanca == null){
            instanca = new Kontroler();
        }
        return instanca;
    }
    
    private Kontroler(){
        sesija = new HashMap();
    }

    public List<TipSanki> vratiListuTipovaMS() throws Exception {
        
        
        return null;
    }

    public void sacuvajMotorneSanke(MotorneSanke motorneSanke) throws Exception {
        
        
        
    }
    public List<AbstractObjekat> ucitajListuMotornihSanki() throws IOException, ClassNotFoundException{
        System.out.println("Ucitavanje liste MS");
        KlijentTransfer kt = new KlijentTransfer();
        kt.setOperacija(konstante.Konstante.UCITAJ_LISTU_MOTORNIH_SANKI);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
        if(st.getUspesnost() == 1){
            return (List<AbstractObjekat>) st.getPodaci();
        }
        else {
            return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AbstractObjekat;
import domen.Korisnik;
import domen.MotorneSanke;
import domen.TipSanki;
import exception.PovezivanjeException;
import java.io.IOException;
import komunikacija.Komunikacija;
import java.util.HashMap;
import java.util.List;
import konstante.Konstante;
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
    public List<AbstractObjekat> ucitajListuMotornihSanki() throws PovezivanjeException, Exception {
        List<AbstractObjekat> lista;
        try {
            System.out.println("Ucitavanje liste MS");
            KlijentTransfer kt = new KlijentTransfer();
            kt.setOperacija(Konstante.UCITAJ_LISTU_MOTORNIH_SANKI);
            Komunikacija.vratiInstancu().posaljiZahtev(kt);
            ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
            if(st.getUspesnost() == 1){
                return (List<AbstractObjekat>) st.getPodaci();
            }
            else {
                Exception exec = st.getException();
                throw exec;
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new PovezivanjeException("Doslo je do greske u komunikaciji");
        }
    }

    public AbstractObjekat ulogujKorisnika(String username, String password) throws Exception {
        System.out.println("Logovanje korisnika...");
        KlijentTransfer kt = new KlijentTransfer();
        kt.setOperacija(Konstante.ULOGUJ_KORISNIKA);
        Korisnik parametar = new Korisnik(null, null, username, password); 
        parametar.setHashPassword(password);
        kt.setParametar(parametar);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
        if(st.getUspesnost() == 1){
            return (AbstractObjekat) st.getPodaci();
        }
        else {
            Exception exec = st.getException();
            throw exec;
        }
    }
}

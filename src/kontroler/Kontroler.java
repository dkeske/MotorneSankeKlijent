/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AbstractObjekat;
import domen.Korisnik;
import domen.MotorneSanke;
import domen.RezervacijaVoznje;
import domen.StavkaRezervacijeVoznje;
import domen.TipSanki;
import domen.Vozac;
import exception.PovezivanjeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import komunikacija.Komunikacija;
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

    public static Kontroler vratiInstancuKontrolera() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public List<AbstractObjekat> ucitajListuTipovaMS() throws Exception {
        List<AbstractObjekat> lista;
        try {
            System.out.println("Ucitavanje liste tipova MS");
            KlijentTransfer kt = new KlijentTransfer();
            kt.setOperacija(Konstante.UCITAJ_LISTU_TIPOVA_MS);
            Komunikacija.vratiInstancu().posaljiZahtev(kt);
            ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
            if (st.getUspesnost() == 1) {
                return (List<AbstractObjekat>) st.getPodaci();
            } else {
                Exception exec = st.getException();
                throw exec;
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new PovezivanjeException("Doslo je do greske u komunikaciji");
        }
    }

    public AbstractObjekat sacuvajMotorneSanke(MotorneSanke motorneSanke) throws Exception {
        KlijentTransfer kt = new KlijentTransfer();
        kt.setOperacija(Konstante.KREIRAJ_MOTORNE_SANKE);
        kt.setParametar(motorneSanke);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (AbstractObjekat) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }

    }

    public List<AbstractObjekat> ucitajListuMotornihSanki() throws PovezivanjeException, Exception {
        List<AbstractObjekat> lista;
        try {
            System.out.println("Ucitavanje liste MS");
            KlijentTransfer kt = new KlijentTransfer();
            kt.setOperacija(Konstante.UCITAJ_LISTU_MOTORNIH_SANKI);
            Komunikacija.vratiInstancu().posaljiZahtev(kt);
            ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
            if (st.getUspesnost() == 1) {
                return (List<AbstractObjekat>) st.getPodaci();
            } else {
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
        Korisnik parametar = new Korisnik(null, null, username, password, true);
        parametar.setHashPassword(password);
        kt.setParametar(parametar);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (AbstractObjekat) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public List<AbstractObjekat> ucitajListuRezervacija() throws Exception {
        KlijentTransfer kt = new KlijentTransfer();
        kt.setOperacija(Konstante.UCITAJ_LISTU_REZERVACIJA);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObjekat>) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public List<AbstractObjekat> ucitajListuVozaca() throws PovezivanjeException, Exception {
        try {
            System.out.println("Ucitavanje liste vozaca");
            KlijentTransfer kt = new KlijentTransfer();
            kt.setOperacija(Konstante.UCITAJ_LISTU_VOZACA);
            Komunikacija.vratiInstancu().posaljiZahtev(kt);
            ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
            if (st.getUspesnost() == 1) {
                return (List<AbstractObjekat>) st.getPodaci();
            } else {
                Exception exec = st.getException();
                throw exec;
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new PovezivanjeException("Doslo je do greske u komunikaciji");
        }
    }

    public AbstractObjekat sacuvajRezervaciju(RezervacijaVoznje rzv) throws Exception {
        KlijentTransfer kt = new KlijentTransfer();
        kt.setOperacija(Konstante.KREIRAJ_REZERVACIJU_VOZNJE);
        kt.setParametar(rzv);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (AbstractObjekat) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public AbstractObjekat izmeniRezervaciju(RezervacijaVoznje izmenjena) throws IOException, ClassNotFoundException, Exception {
        KlijentTransfer kt = new KlijentTransfer();
        kt.setOperacija(Konstante.ZAPAMTI_REZERVACIJU_VOZNJE);
        kt.setParametar(izmenjena);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (AbstractObjekat) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public List<AbstractObjekat> pretraziRezervacije(String pretraga) throws IOException, ClassNotFoundException, Exception {
        KlijentTransfer kt = new KlijentTransfer();
        kt.setOperacija(Konstante.PRETRAZI_REZERVACIJU_VOZNJE);
        kt.setParametar(pretraga);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObjekat>) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public List<AbstractObjekat> pretraziSanke(String pretraga) throws IOException, ClassNotFoundException, Exception {
        KlijentTransfer kt = new KlijentTransfer();
        kt.setOperacija(Konstante.PRETRAZI_MOTORNE_SANKE);
        kt.setParametar(pretraga);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObjekat>) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public List<AbstractObjekat> pretraziVozace(String pretraga) throws IOException, ClassNotFoundException, Exception {
        KlijentTransfer kt = new KlijentTransfer();
        kt.setOperacija(Konstante.PRETRAZI_VOZACE);
        kt.setParametar(pretraga);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObjekat>) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public List<AbstractObjekat> obrisiSanke(MotorneSanke selected) throws IOException, ClassNotFoundException, Exception {
        KlijentTransfer kt = new KlijentTransfer();
        kt.setOperacija(Konstante.OBRISI_MOTORNE_SANKE);
        kt.setParametar(selected);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObjekat>) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public List<AbstractObjekat> obrisiRezervacij(RezervacijaVoznje rez) throws IOException, ClassNotFoundException, Exception {
        KlijentTransfer kt = new KlijentTransfer();
        kt.setOperacija(Konstante.OBRISI_REZERVACIJU_VOZNJE);
        kt.setParametar(rez);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObjekat>) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

}

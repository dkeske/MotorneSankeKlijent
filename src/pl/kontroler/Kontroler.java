/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kontroler;

import db.DatabaseBroker;
import domen.MotorneSanke;
import domen.TipSanki;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Kontroler {
    private DatabaseBroker dbb;
    private static Kontroler instanca;
    private HashMap sesija;
    
    public static Kontroler vratiInstancuKontrolera(){
        if(instanca == null){
            instanca = new Kontroler();
        }
        return instanca;
    }
    
    private Kontroler(){
        dbb = new DatabaseBroker();
        sesija = new HashMap();
    }

    public List<TipSanki> vratiListuTipovaMS() throws Exception {
        List<TipSanki> listaTipovaMS = new ArrayList<>();
        try {
            dbb.uspostaviKonekciju();
        } catch (Exception e) {
            throw new Exception("Greska prilikom povezivanja na bazu!");
        }
        try {
            listaTipovaMS = dbb.UcitajListuTipovaMotornihSanki();
            dbb.potvrdiTransakciju();
        } catch (Exception e) {
            dbb.ponistiTransakciju();
            e.printStackTrace();
        }
        try {
            dbb.raskiniKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaTipovaMS;
    }

    public void sacuvajMotorneSanke(MotorneSanke motorneSanke) throws Exception {
        try {
            dbb.uspostaviKonekciju();
        } catch (Exception e) {
            throw new Exception("Greska prilikom povezivanja na bazu!");
        }
        try {
            dbb.sacuvajMotorneSanke(motorneSanke);
            dbb.potvrdiTransakciju();
        } catch (Exception e) {
            dbb.ponistiTransakciju();
            e.printStackTrace();
        }
        try {
            dbb.raskiniKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}

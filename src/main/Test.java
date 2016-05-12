/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domen.AbstractObjekat;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.kontroler.Kontroler;
import start.StartKlijent;

/**
 *
 * @author Daniel
 */
public class Test extends Thread {

    public static void main(String[] args) {
        StartKlijent sk = new StartKlijent();
        sk.start();
        Test t = new Test();
        t.start();

    }

    @Override
    public void run() {
        try {
            try {
                Thread.sleep(1000);
                System.out.println("Saljem zahtev");
                List<AbstractObjekat> lista = Kontroler.vratiInstancuKontrolera().ucitajListuMotornihSanki();
                for (AbstractObjekat abstractObjekat : lista) {
                    System.out.println(abstractObjekat);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

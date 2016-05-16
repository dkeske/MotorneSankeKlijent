/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Komunikacija;

/**
 *
 * @author Daniel
 */
public class StartKlijent extends Thread{

    public StartKlijent() {
    }

    
    @Override
    public void run() {
        try {
            System.out.println("Postavljam socket");
            Socket socket = new Socket("127.0.0.1", 9000);
            Komunikacija.vratiInstancu().setSocket(socket);
            System.out.println("Postavio socket!");
            
        } catch (IOException ex) {
//            throw new Exception("Konekcija na server nije uspela!");
        }
        
    }
    
}

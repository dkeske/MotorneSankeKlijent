/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.KlijentTransfer;
import transfer.ServerTransfer;

/**
 *
 * @author Daniel
 */
public class Komunikacija {

    private static Socket socket;

    public Socket getSocket() {
        return socket;
    }
    ObjectInputStream in;
    ObjectOutputStream out;
    private static Komunikacija instance;

    public static Komunikacija vratiInstancu() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public void setSocket(Socket socket) throws IOException {
        Komunikacija.socket = socket;
        out = new ObjectOutputStream(this.socket.getOutputStream());
        in = new ObjectInputStream(this.socket.getInputStream());
        System.out.println("Podesio sam out!!!");
    }

    public void posaljiZahtev(KlijentTransfer kt) throws IOException {
        out.writeUnshared(kt);
    }

    public ServerTransfer procitajOdgovor() throws IOException, ClassNotFoundException {
        return (ServerTransfer) in.readUnshared();
    }
}

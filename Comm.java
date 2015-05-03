package trabalho2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Comm {
    
    public Socket client;
    public PrintStream signalOut;
    public Scanner signalIn;

    public void CreateClient(String ip, int port) throws IOException {

        System.out.println("Tentando conex�o em: "+ip+" : "+port);
        client = new Socket(ip, port);
        signalOut = new PrintStream(client.getOutputStream());
        signalIn = new Scanner(client.getInputStream());
    }
    
    public void CloseConnectionClient () throws IOException {
        client.close();
    }
    
    public void SendSignal(String response) throws IOException {
       signalOut.println(response);
       System.out.printf(response);
    }
    
    public String ReceiveSignal() throws IOException {
        String t = signalIn.nextLine();
        return t;
    }
}

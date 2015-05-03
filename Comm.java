package trabalho2;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Comm {
    
    public Socket client;
    public PrintWriter signalOut;
    public InputStream signalIn;

    public void CreateClient(String ip, int port) throws IOException {

        System.out.println("Tentando conex�o em: "+ip+" : "+port);
        client = new Socket(ip, port);
        signalOut = new PrintWriter(client.getOutputStream());
        signalIn = client.getInputStream();
    }
    
    public void CloseConnectionClient () throws IOException {
        client.close();
    }
    
    public void SendSignal(String response) {
       signalOut.println(response);
       System.out.println(response);
    }
    
}

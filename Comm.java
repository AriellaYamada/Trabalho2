/**
 *
 * @author Ariella Yamada   8937034
 * @author Carlos Schneider 9167910
 * @author Márcio Campos    8937462
 */

package trabalho2;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

//Classe que realiza e gerencia a conexão com o servidor
public class Comm {
    
    public Socket client;
    public PrintWriter signalOut;
    public InputStream signalIn;

    public void CreateClient(String ip, int port) throws IOException {

        //Inicia a conexão com o servidor
        System.out.println("Tentando conex�o em: "+ip+" : "+port);
        client = new Socket(ip, port);
        //"Porta" de saida de mensagens para o servidor
        signalOut = new PrintWriter(client.getOutputStream(), true);
        //"Porta" de entrada de mensagens do servidor
        signalIn = client.getInputStream();
    }
    
    //Método que encerra a conexão com o servidor
    public void CloseConnectionClient () throws IOException {
        client.close();
    }
    
    //Método que envia mensagem para o servidor
    public void SendSignal(String response) {  
       signalOut.println(response);
       System.out.println(response);
    }
    
}

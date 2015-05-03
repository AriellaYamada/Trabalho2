/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

import com.sun.corba.se.spi.activation.Server;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ariellayamada
 */



public class Comm {
    
    Socket client;
    ServerSocket server;
    public PrintWriter signalOut;
    public BufferedReader signalIn;

    public void Start () throws IOException {
        signalOut = new PrintWriter(client.getOutputStream(), true);
        signalIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }

    public void CreateServer(int port, Stage st) throws IOException {
        server = new ServerSocket(12345);

        System.out.println("Servidor criado");
        InetAddress IP = InetAddress.getLocalHost();
        System.out.println("IP: " + IP.toString());

        System.out.println("IP2: " + server.getInetAddress().toString());
        st.setTitle("Teste 2nd");

        TextField tf = new TextField();
        tf.setText(IP.toString());
        VBox vb = new VBox();
        Scene scene = new Scene(vb, 450, 450);
        st.setScene(scene);
        st.show();
        client = server.accept();

    }

    public void CreateClient(String ip, int port) throws IOException {

        System.out.println("Tentando conexão em: "+ip+" : "+port);
        client = new Socket(ip, port);
    }
    
    public void CloseConnectionServer () throws IOException {
        server.close();
        client.close();
    }
    
    public void CloseConnectionClient () throws IOException {
        client.close();
    }
    
    public void SendSignal(String response) throws IOException {
       signalOut.println(response);
    }
    
    public String ReceiveSignal() throws IOException {
        return signalIn.readLine();
    }
}

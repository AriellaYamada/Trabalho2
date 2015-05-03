/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ariellayamada
 */
public class Player {
    
    //public boolean type;
    public int mark;
    public int points;
    public String ip;
    public int port;
    public boolean authorization;
    //public int flagConnection;
    Comm connection;
    Graphics h;
    Game g;
    
    public Player(boolean type, Stage st) throws IOException{
        //this.type = type;
        connection = new Comm();
        g = new Game();
      
        //g = new Game();
        h = new Graphics(connection, this, st);
        
        if (type == true) {
            this.connection.CreateServer(12345, st);
            this.authorization = true;
        } else {
            this.authorization = false;
        }
    } 
    
    public Scene ConnectPane () {
        return h.ConnectPane(this);
    }
    
    public Scene Init () {
        return h.init(this);
    }

    public String getMark() {
        String m;
        switch (this.mark) {
            case 1:
                m = "X";
            default:
                m = "O";
        }
        return m;
    }
    
    public void ReceiveMove () throws IOException {
        int pos = Integer.parseInt(connection.ReceiveSignal());
        if (this.mark == 1) {
            g.matrix[pos] = 2;
        } else {
            g.matrix[pos] = 1;
        }
        this.authorization = true;
    }
    
    public void StartGame () throws IOException {
        
        //Inicia a partida
        connection.SetCommunication();
        Round r = new Round(this);
        Thread round = new Thread(r);
        //Verifica se alguém ganhou
        while (g.VerifyEnd() == 0) {
           round.start();
        }
        //Se ganhou
        if (g.VerifyEnd() == 1) {
            this.points++;
            this.g.nrounds++;
        //Se empatou
        } else if (g.VerifyEnd() == 3) {
            this.g.draw++;
            this.g.nrounds++;
        }
    }
}

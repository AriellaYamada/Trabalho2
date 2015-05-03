/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

import java.io.IOException;
import javafx.scene.Scene;
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
    public Comm connection;
    public Graphics frame;
    public Game game;
    public Stage window;
    
    public Player(boolean type, Stage st) throws IOException{
        //this.type = type;
        connection = new Comm();
        window = st;

        frame = new Graphics(connection, this, st);
        
        if (mark == 1) {
            this.authorization = true;
        } else {
            this.authorization = false;
        }
    } 
    
    public Scene ConnectPane () {
        return frame.ConnectPane(this);
    }
    
    public Scene Init () {
        return frame.init(this);
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
    
    public void StartGame () throws IOException {
        
        //Inicia a partida
        game = new Game(this.mark);
        ReceiveMove server = new ReceiveMove(this.connection.signalIn, this.game);
        Thread serverResponse = new Thread(server);
        
        serverResponse.start();
        //Verifica se alguém ganhou
        while (game.VerifyEnd() == 0) {
           if (this.game.turn == this.mark) {
               this.frame.UpdateButtons(this.game.matrix);
           }
        }
        serverResponse.stop();
        
        //Se ganhou
        if (game.VerifyEnd() == 1) {
            this.points++;
            this.game.nrounds++;
        //Se empatou
            
        } else if (game.VerifyEnd() == 3) {
            this.game.draw++;
            this.game.nrounds++;
        }
        window.setScene(frame.PlayAgain(this));
    }
}

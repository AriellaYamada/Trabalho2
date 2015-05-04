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
    public int order;
    public boolean flag;
    //public int flagConnection;
    public Comm connection;
    public Graphics frame;
    public Game game;
    public Stage window;

    public ReceiveMove server;
    
    public Player(Stage st) throws IOException {
        //this.type = type;
        connection = new Comm();
        window = st;
        flag = true;
        frame = new Graphics(connection, this, st);
    }

    public Scene ConnectPane() {
        return frame.ConnectPane(this);
    }

    public Scene Init() {
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

    public void StartGame() throws IOException, InterruptedException {

        //Inicia a partida
        game = new Game(this.mark, order);
        server = new ReceiveMove(this.connection.signalIn, this.game);
        frame.UpdateButtons(this);

        while (game.turn != 3) {
            //System.out.println("Vez do jogador " + game.turn);
            if (game.turn != this.mark){
                //this.frame.DisableAll();
                this.flag = true;
                server.run();
                this.frame.UpdateButtons(this);
            } else {
                while (this.flag)
                    System.out.println("Minha vez");
            }
        }
        /*
        //Se ganhou
        if (game.VerifyEnd() == 1) {
            this.points++;
            this.game.nrounds++;
            //Se empatou

        } else if (game.VerifyEnd() == 3) {
            this.game.draw++;
            this.game.nrounds++;
        }
        //window.setScene(frame.PlayAgain(this));
                */
    }
}

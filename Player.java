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
    //public int flagConnection;
    public Comm connection;
    public Graphics frame;
    public Game game;
    public Stage window;

    public Player(Stage st) throws IOException {
        //this.type = type;
        connection = new Comm();
        window = st;

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
        ReceiveMove server = new ReceiveMove(this.connection.signalIn, this.game);
        //Thread serverResponse = new Thread(server);

        //serverResponse.start();
        //Verifica se alguém ganhou
        while (game.turn != 42) {
            //frame.UpdateButtons(this);
           System.out.println(game.turn);
            switch (game.turn){
                case 1:
                    window.setScene(frame.Game(this));
                    //frame.UpdateButtons(this);
                    break;
                case 2:
                    window.setScene(frame.WaitTurn(this));
                    server.run();
                    break;
            }
            if (game.VerifyEnd() != 0) {
                game.turn = 42;
            }
            
        }

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
    }
}

/**
 *
 * @author Ariella Yamada 8937034
 * @author Carlos Schneider 9167910
 * @author Márcio Campos 8937462
 */

package trabalho2;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Classe que define todos os atributos e métodos do jogador local
public class Player {

    public int mark;
    public String ip;
    public int port;
    public int order;
    public Comm connection;
    public Graphics frame;
    public Game game;
    public Stage window;

    public ReceiveMove server;
    
    public Player(Stage st) throws IOException {
        connection = new Comm();
        window = st;
        frame = new Graphics(connection, this, st);
    }

    //Inicio da partida do jogador local
    public void StartGame() throws IOException, InterruptedException {

        game = new Game(this.mark, order);
        server = new ReceiveMove(this.connection.signalIn, this.game);

    }
}

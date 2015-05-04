/**
 *
 * @author Ariella Yamada 8937034
 * @author Carlos Schneider 9167910
 * @author Márcio Campos 8937462
 */

package trabalho2;

import java.io.InputStream;
import java.util.Scanner;

//Classe que define as jogadas do outro player dentro da rodada
public class ReceiveMove {

    public InputStream server;
    Game g;
    
    public ReceiveMove(InputStream s, Game g) {
        this.server = s;
        this.g = g;
    }
    
    //Aguarda a rodada do outro player e a recebe
    public void run(Player p) {
        System.out.println("Esperando move");
        Scanner move = new Scanner(this.server);
        String teste = null;
        while (!move.hasNextLine());    
        teste = move.nextLine();
        
        System.out.println("Recebeu " + teste);
    }
}

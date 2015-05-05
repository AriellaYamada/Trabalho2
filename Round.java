/**
 *
 * @author Ariella Yamada 8937034
 * @author Carlos Schneider 9167910
 * @author Márcio Campos 8937462
 */

package trabalho2;

//Classe define uma jogada
public class Round {
    private Player p;
    private int Winner;
    public Round (Player p) {
        this.p = p;
    }
    //Define a jogada e verifica se alguém ganhou
    public void run(String response) {
        
        //Envia jogada local para o servidor
        p.connection.SendSignal(response);
        Winner = p.game.VerifyEnd();
        if (Winner == 0) {
            //Espera jogada do outro player
            p.server.run(p);
            Winner = p.game.VerifyEnd();
            if(Winner != 0)
                p.window.setScene(p.frame.PlayAgain(p, Winner));
                p.window.show();
        } else {
            p.window.setScene(p.frame.PlayAgain(p, Winner));
            p.window.show();
        }
    }
}

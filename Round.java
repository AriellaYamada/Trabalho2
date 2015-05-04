/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

/**
 *
 * @author ariellayamada
 */
public class Round {
    private Player p;
    private int Winner;
    public Round (Player p) {
        this.p = p;
    }
    
    public void SetMatrix (int pos, int mark) {
        p.game.matrix[pos] = mark;
    }
    public void run(String response) {
        p.connection.SendSignal(response);
        Winner = p.game.VerifyEnd();
        System.out.println("Winner: " + Winner);
        if (Winner == 0) {
            p.server.run(p);
            Winner = p.game.VerifyEnd();
            System.out.println("Winner: " + Winner);
            if(Winner != 0)
                p.window.setScene(p.frame.PlayAgain(p, Winner));
                p.window.show();
        } else {
            p.window.setScene(p.frame.PlayAgain(p, Winner));
            p.window.show();
        }
    }
}

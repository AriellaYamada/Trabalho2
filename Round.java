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
    public Round (Player p) {
        this.p = p;
    }
    public void run(String response) {
        p.frame.DisableAll();
        p.connection.SendSignal(response);
        p.server.run();
        p.frame.UpdateButtons(this.p);
    }
}

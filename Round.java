/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ariellayamada
 */
public class Round {

    Player p;
    
    public Round (Player p) {
        this.p = p;
    }
    
    public void run() {
        if (this.p.authorization == true) {
            this.p.h.UpdateButtons(this.p.g.matrix);
            //ReceiveMove();
        } else {
            try {
                this.p.ReceiveMove();
            } catch (IOException ex) {
                Logger.getLogger(Round.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

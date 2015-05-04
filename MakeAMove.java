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
public class MakeAMove implements Runnable {
    
    public Player p;
    
    public MakeAMove(Player p) {
        this.p = p;
    }

    @Override
    public void run() {
        
        this.p.frame.UpdateButtons(p);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

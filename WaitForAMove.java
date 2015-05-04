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
public class WaitForAMove implements Runnable{
    private Player p;
    
    public WaitForAMove (Player p) {
        this.p = p;
    }
    @Override
    public void run() {
        
        this.p.frame.DisableAll();
        while (p.flag);
        //Thread test = new Thread(this.p.server);
        //test.start();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

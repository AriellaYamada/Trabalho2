/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author ariellayamada
 */
public class ReceiveMove implements Runnable{

    public InputStream server;
    
    public ReceiveMove(InputStream s) {
        this.server = s;
    }
    
    @Override
    public void run() {
        
        Scanner move = new Scanner(this.server);
        while (move.hasNextLine()) 
            Integer.parseInt(move.toString());
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

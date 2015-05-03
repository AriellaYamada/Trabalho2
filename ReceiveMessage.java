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
public class ReceiveMessage implements Runnable {
    public InputStream server;
    
    public ReceiveMessage (InputStream s) {
        this.server = s;
    }
    
     @Override
    public void run() {
        
        Scanner move = new Scanner(this.server);
        String teste;
        //while (move.hasNextLine()) {
            teste = move.nextLine();
            //g.ReceiveMove(Integer.parseInt(teste));
            System.out.println(teste);
        //}
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

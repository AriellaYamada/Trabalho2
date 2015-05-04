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
public class ReceiveMessage {
    public InputStream server;
    
    public ReceiveMessage (InputStream s) {
        this.server = s;
    }

    public String run() {
        
        Scanner move = new Scanner(this.server);
        String msg;
            msg = move.nextLine();
            System.out.println(msg);
            return msg;
       
    }
    
}

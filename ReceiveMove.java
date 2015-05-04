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
public class ReceiveMove {

    public InputStream server;
    Game g;
    
    public ReceiveMove(InputStream s, Game g) {
        this.server = s;
        this.g = g;
    }
    
    public void run() {
        
        Scanner move = new Scanner(this.server);
        String teste = null;
        while (!move.hasNextLine()){}    
        teste = move.nextLine();
        
        g.ReceiveMove(Integer.parseInt(teste));
        System.out.println(teste);
    }
}

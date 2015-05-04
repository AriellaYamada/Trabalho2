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
        System.out.println("Esperando move");
        Scanner move = new Scanner(this.server);
        String teste = null;
        while (!move.hasNextLine());    
        teste = move.nextLine();
        
        g.ReceiveMove(Integer.parseInt(teste));
        //g.PrintMatrix();
        System.out.println("Recebeu " + teste);
    }
}

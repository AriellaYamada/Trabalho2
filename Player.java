/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

import java.io.IOException;

/**
 *
 * @author ariellayamada
 */
public class Player {
    
    //public boolean type;
    public boolean mark;
    public int points;
    public String ip;
    public int port;
    Comm connection;
    Game g;
    Graphics h;
    
    public Player(boolean type) throws IOException{
        //this.type = type;
        connection = new Comm();
      
        //g = new Game();
        h = new Graphics(connection);
        
        if (type == true) {
            connection.CreateServer(port);
            
        } else {   
            connection.CreateClient(ip, 12345); 
        }  
    } 
}

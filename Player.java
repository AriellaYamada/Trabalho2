/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author ariellayamada
 */
public class Player {
    
    //public boolean type;
    public int mark;
    public int points;
    public String ip;
    public int port;
    public int flagConnection;
    Comm connection;
    Game g;
    Graphics h;
    
    public Player(boolean type) throws IOException{
        //this.type = type;
        flagConnection = 0;
        connection = new Comm();
      
        //g = new Game();
        h = new Graphics(connection);
        
        if (type == true) {
            connection.CreateServer(12345);  
        }
    } 
    
    public Scene ConnectPane () {
        return h.ConnectPane(this);
    }
    
    public Scene Init () {
        return h.init(this);
    }
}

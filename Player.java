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
            connection.CreateServer(12345);
            
        }
    } 
    
    public Scene ConnectPane () {
        
        StackPane player2Pane = new StackPane();
        Scene pane = new Scene(player2Pane, 500, 600);
        VBox org = new VBox(30);
        
        TextField ipEntry;
        TextField portEntry;
        
        ipEntry = new TextField();
        portEntry = new TextField();
        
        ipEntry.setOnAction(event -> {
           this.ip = ipEntry.getText();
           System.out.printf("%s\n", this.ip);
        });
        portEntry.setOnAction(event -> {
            this.port = Integer.parseInt(portEntry.getText());
            try {
                connection.CreateClient(this.ip, 12345);
                //System.out.printf("%d\n", this.port);
            } catch (IOException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        org.setAlignment(Pos.CENTER);
        org.getChildren().addAll(ipEntry, portEntry);
        
        player2Pane.getChildren().add(org);
        
        return pane;
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ariellayamada
 */
public class Trabalho2 extends Application{
    
    public Player p;
    Button btn;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {

        btn = new Button("Jogar");
        
        btn.setOnAction(event -> this.btnPressed(primaryStage));
       
         
        HBox boxButtons = new HBox(8);
        boxButtons.setAlignment(Pos.CENTER);
        boxButtons.getChildren().add(btn);
        
        StackPane root = new StackPane();
        root.getChildren().add(boxButtons);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Jogo da Velha");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void btnPressed (Stage primaryStage) {
        try {
            p = new Player(primaryStage);
        } catch (IOException ex) {
            Logger.getLogger(Trabalho2.class.getName()).log(Level.SEVERE, null, ex);
        }
        primaryStage.setScene(p.Init());
    }
    
}

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

    /**
     * @param args the command line arguments
     */
    
    public Player p;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Button novoJogo = new Button("Iniciar um jogo");
        Button conectar = new Button("Conectar à um jogador");
        
        novoJogo.setOnAction(event -> 
        {
            try {
                p = new Player(true);
                primaryStage.setScene(p.h.Game());
            } catch (IOException ex) {
                Logger.getLogger(Trabalho2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        );
        
        conectar.setOnAction(event ->{
            try {
                p = new Player(false);
            } catch (IOException ex) {
                Logger.getLogger(Trabalho2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
         
        HBox boxButtons = new HBox(8);
        boxButtons.setAlignment(Pos.CENTER);
        boxButtons.getChildren().addAll(novoJogo, conectar);
        
        StackPane root = new StackPane();
        root.getChildren().add(boxButtons);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Jogo da Velha");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}

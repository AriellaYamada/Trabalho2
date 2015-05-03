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
    Button novoJogo;
    Button conectar;
    
    public static void main(String[] args) {
        launch(args);
    }
   /*
    private void BtnPressed (int btn, boolean type) throws IOException {
        p = new Player(type, primaryStage);
    }
    */
    @Override
    public void start(Stage primaryStage) {

        novoJogo = new Button("Iniciar um jogo");
        conectar = new Button("Conectar à um jogador");
        
        novoJogo.setOnAction(event -> 
        {
            try {
                //Cria jogador como jogador/servidor
                p = new Player(true, primaryStage);
                primaryStage.setScene(p.Init());
            } catch (IOException ex) {
                Logger.getLogger(Trabalho2.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        conectar.setOnAction(event ->{
            try {

                //Cria jogador como jogador/cliente
                p = new Player(false, primaryStage);
                primaryStage.setScene(p.ConnectPane());
                
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

        primaryStage.setResizable(false);
        primaryStage.setTitle("Jogo da Velha");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}

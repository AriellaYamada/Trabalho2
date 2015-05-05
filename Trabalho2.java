/**
 *
 * @author Ariella Yamada 8937034
 * @author Carlos Schneider 9167910
 * @author Márcio Campos 8937462
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

public class Trabalho2 extends Application{
    
    public Player p;
    Button btn;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    //Tela de inicio
    @Override
    public void start(Stage primaryStage) {

        btn = new Button("Play");
        
        btn.setOnAction(event -> this.btnPressed(primaryStage));
       
         
        HBox boxButtons = new HBox(8);
        boxButtons.setAlignment(Pos.CENTER);
        boxButtons.getChildren().add(btn);
        
        StackPane root = new StackPane();
        root.getChildren().add(boxButtons);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
   //Funcao do botão "Jogar"
    public void btnPressed (Stage primaryStage) {
        try {
            p = new Player(primaryStage);
        } catch (IOException ex) {
            Logger.getLogger(Trabalho2.class.getName()).log(Level.SEVERE, null, ex);
        }
        primaryStage.setScene(p.frame.init(p));
    }
    
}

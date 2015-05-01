package trabalho2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ariellayamada
 */
public class Graphics extends Application{

    public Button[] btn = new Button[9];
   
    public String response;
    
    public Graphics() {
        
        //Cria os botões
        for (int i = 0; i < 9; i++) {
            btn[i] = new Button();
        }
        
        //Escreve mensagem
        btn[0].setOnAction(event -> {
            response = "0";
        });
        btn[1].setOnAction(event -> {
            response = "1";
        });
        btn[2].setOnAction(event -> {
            response = "2";
        });
        btn[3].setOnAction(event -> {
            response = "3";
        });
        btn[4].setOnAction(event -> {
            response = "4";
        });
        btn[5].setOnAction(event -> {
            response = "5";
        });
        btn[6].setOnAction(event -> {
            response = "6";
        });
        btn[7].setOnAction(event -> {
            response = "7";
        });
        btn[8].setOnAction(event -> {
            response = "8";
        });
        
        launch();
    }

    public Scene Game() {

        // MONTA A TELA DO JOGADOR/SERVIDOR
        StackPane player1Pane = new StackPane();
        Scene pane = new Scene(player1Pane, 500, 600);
        
        this.DisableAll();

        HBox line1 = new HBox(10);
        line1.setAlignment(Pos.CENTER);
        line1.getChildren().addAll(btn[0], btn[1], btn[2]);

        HBox line2 = new HBox(10);
        line2.setAlignment(Pos.CENTER);
        line2.getChildren().addAll(btn[3], btn[4], btn[5]);

        HBox line3 = new HBox(10);
        line3.setAlignment(Pos.CENTER);
        line3.getChildren().addAll(btn[6], btn[7], btn[8]);
                
        VBox org = new VBox(10);
        org.setAlignment(Pos.CENTER);
        org.getChildren().addAll(line1, line2, line3);

        player1Pane.getChildren().add(org);

        return pane;
    }
    
    public void DisableAll () {
        
        for (int i = 0; i < 9; i++) {
            btn[i].setDisable(false);
        }
    }
    
    public void UpdateButtons (int round[]) {
        
        int i;
        for (i = 0; i < 9; i++) {
            if (round[i] == 0) {
                //this.ActiveButton(i);
                btn[i].setDisable(false);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Jogo da Velha");
        primaryStage.setScene(this.Game());
        primaryStage.show();
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}

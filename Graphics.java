package trabalho2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ariellayamada
 */
public class Graphics {

    public Button[] btn = new Button[9];
   
    public String response;
    
    public Graphics() {
        
        for (int i = 0; i < 9; i++) {
            btn[i] = new Button();
        }
        btn[0].setOnAction(event -> {
            response = "field0";
        });
        btn[1].setOnAction(event -> {
            response = "field1";
        });
        btn[2].setOnAction(event -> {
            response = "field2";
        });
        btn[3].setOnAction(event -> {
            response = "field3";
        });
        btn[4].setOnAction(event -> {
            response = "field4";
        });
        btn[5].setOnAction(event -> {
            response = "field5";
        });
        btn[6].setOnAction(event -> {
            response = "field6";
        });
        btn[7].setOnAction(event -> {
            response = "field7";
        });
        btn[8].setOnAction(event -> {
            response = "field8";
        });
    }

    public Scene Game() {

        // MONTA A TELA DO JOGADOR/SERVIDOR
        StackPane player1Pane = new StackPane();
        Scene pane = new Scene(player1Pane, 500, 600);
        
        this.DisableAll();

        
        VBox column1 = new VBox(10);
        column1.setAlignment(Pos.CENTER);
        //column1.getChildren().addAll(btn[]);

        VBox column2 = new VBox(10);
        column2.setAlignment(Pos.CENTER);
        //column2.getChildren().addAll(field4, field5, field6);

        VBox column3 = new VBox(10);
        column3.setAlignment(Pos.CENTER);
        //column3.getChildren().addAll(field7, field8, field9);

        HBox org = new HBox(10);
        org.setAlignment(Pos.CENTER);
        org.getChildren().addAll(column1, column2, column3);

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
    
   
    
}

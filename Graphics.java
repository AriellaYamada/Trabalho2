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
    /*public Button field2 = new Button();
    public Button field3 = new Button();
    public Button field4 = new Button();
    public Button field5 = new Button();
    public Button field6 = new Button();
    public Button field7 = new Button();
    public Button field8 = new Button();
    public Button field9 = new Button();*/

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
        
        /*field2.setDisable(true);
        field3.setDisable(true);
        field4.setDisable(true);
        field5.setDisable(true);
        field6.setDisable(true);
        field7.setDisable(true);
        field8.setDisable(true);
        field9.setDisable(true);*/
    }
/*
    private void ActiveButton (int nbutton) {
      
        switch(nbutton) {
                    case 0:
                        field1.setDisable(false);
                        break;
                    case 1:
                        field2.setDisable(false);
                        break;
                    case 2:
                        field3.setDisable(false);
                        break;
                    case 3:
                        field4.setDisable(false);
                        break;
                    case 4:
                        field5.setDisable(false);
                        break;
                    case 5:
                        field6.setDisable(false);
                        break;
                    case 6:
                        field7.setDisable(false);
                        break;
                    case 7:
                        field8.setDisable(false);
                        break;
                    case 8:
                        field9.setDisable(false);
                        break;
                }
    }*/
    
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

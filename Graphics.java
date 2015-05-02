package trabalho2;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Ariella Yamada   9999999
 * @author Carlos Schneider 9167910
 * @author Márcio Campos    9999999
 */
public class Graphics{

    public Button[] btn = new Button[9];
   
    public String response;

    private void BtnPress(int id, Comm c){
        DisableAll();
        this.response = Integer.valueOf(id).toString();
        try {
            c.SendSignal(response);
        } catch (IOException ex) {
            Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Graphics(Comm c) {

        //Cria os botões
        for (int i = 0; i < 9; i++) {
            btn[i] = new Button();
            btn[i].setId(Integer.valueOf(i).toString());
        }

        btn[0].setOnAction(event -> BtnPress(0, c));
        btn[1].setOnAction(event -> BtnPress(1, c));
        btn[2].setOnAction(event -> BtnPress(2, c));
        btn[3].setOnAction(event -> BtnPress(3, c));
        btn[4].setOnAction(event -> BtnPress(4, c));
        btn[5].setOnAction(event -> BtnPress(5, c));
        btn[6].setOnAction(event -> BtnPress(6, c));
        btn[7].setOnAction(event -> BtnPress(7, c));
        btn[8].setOnAction(event -> BtnPress(8, c));

    }

    public Scene init() {
        StackPane choose = new StackPane();
        Scene pane = new Scene(choose, 500, 600);
        
        return pane;
    }
    public Scene Game() {

        // MONTA A TELA DO JOGADOR/SERVIDOR
        StackPane playerPane = new StackPane();
        Scene pane = new Scene(playerPane, 450, 450);
        
        DisableAll();

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(5));

        int k = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                btn[k].setText(Integer.valueOf(k).toString());
                btn[k].setPrefSize(150, 150);
                btn[k].setMaxSize(1000, 1000);
                //GridPane.setHalignment(btn[k], HPos.CENTER);
                GridPane.setHgrow(btn[k], Priority.ALWAYS);
                //GridPane.setValignment(btn[k], VPos.CENTER);
                GridPane.setVgrow(btn[k], Priority.ALWAYS);
                grid.add(btn[k], j, i);
                k++;
            }
        VBox org = new VBox(10);
        org.setAlignment(Pos.CENTER);
        org.getChildren().addAll(grid);
        grid.setPrefSize(450, 450);
        grid.setMaxSize(3000, 3000);
        playerPane.getChildren().add(org);

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

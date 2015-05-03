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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

    private void BtnPress(Player p, Button bt, Comm c){

        DisableAll();
        this.response = bt.getId();
        bt.setText(p.getMark());
        try {
            c.SendSignal(response);
        } catch (IOException ex) {
            Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Graphics(Comm c, Player p) {

        //Cria os botões
        for (int i = 0; i < 9; i++) {
            btn[i] = new Button();
            btn[i].setId(Integer.valueOf(i).toString());
        }

        btn[0].setOnAction(event -> BtnPress(p, btn[0], c));
        btn[1].setOnAction(event -> BtnPress(p, btn[1], c));
        btn[2].setOnAction(event -> BtnPress(p, btn[2], c));
        btn[3].setOnAction(event -> BtnPress(p, btn[3], c));
        btn[4].setOnAction(event -> BtnPress(p, btn[4], c));
        btn[5].setOnAction(event -> BtnPress(p, btn[5], c));
        btn[6].setOnAction(event -> BtnPress(p, btn[6], c));
        btn[7].setOnAction(event -> BtnPress(p, btn[7], c));
        btn[8].setOnAction(event -> BtnPress(p, btn[8], c));

    }

    public Scene init(Player p) {
        
        StackPane choose = new StackPane();
        Scene pane = new Scene(choose, 300, 250);
        
        Button x = new Button("x");
        Button o = new Button("o");
        
        HBox t = new HBox(20);
        t.setAlignment(Pos.CENTER);
        
        x.setOnAction(event -> {
            p.mark = 1;
        });
        
        o.setOnAction(event -> {
            p.mark = 2;
        });
        
        t.getChildren().addAll(x, o);
        
        choose.getChildren().add(t);
        
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
    
    public Scene ConnectPane (Player p) {
        
        StackPane player2Pane = new StackPane();
        Scene pane = new Scene(player2Pane, 500, 600);
        VBox org = new VBox(30);
        
        //TextField ipEntry;
        //TextField portEntry;

        TextField ipEntry = new TextField();
        ipEntry.setPromptText("IP 192.168.0.1");
        TextField portEntry = new TextField();
        portEntry.setPromptText("12345");
        Button btn = new Button("Conectar");
        btn.setDefaultButton(true);
        btn.setOnAction(event1 -> {
            p.ip = ipEntry.getText();
            p.port = Integer.parseInt(portEntry.getText());
            try {
                p.connection.CreateClient(p.ip, 12345);
                p.flagConnection = 1;
                //System.out.printf("%d\n", this.port);
            } catch (IOException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        /*
        ipEntry.setOnAction(event -> {
           p.ip = ipEntry.getText();
           System.out.printf("%s\n", p.ip);
        });
        portEntry.setOnAction(event -> {
            p.port = Integer.parseInt(portEntry.getText());
            try {
                p.connection.CreateClient(p.ip, 12345);
                p.flagConnection = 1;
                //System.out.printf("%d\n", this.port);
            } catch (IOException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        */
        org.setAlignment(Pos.CENTER);
        org.getChildren().addAll(ipEntry, portEntry, btn);
        
        player2Pane.getChildren().add(org);
        
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

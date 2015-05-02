package trabalho2;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
        Scene pane = new Scene(playerPane, 500, 600);

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

        playerPane.getChildren().add(org);

        return pane;
    }
    
    public Scene ConnectPane (Player p) {
        
        StackPane player2Pane = new StackPane();
        Scene pane = new Scene(player2Pane, 500, 600);
        VBox org = new VBox(30);
        
        TextField ipEntry;
        TextField portEntry;
        
        ipEntry = new TextField();
        portEntry = new TextField();
        
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
        
        org.setAlignment(Pos.CENTER);
        org.getChildren().addAll(ipEntry, portEntry);
        
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

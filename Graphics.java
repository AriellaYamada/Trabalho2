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

    private void BtnPress(int id){
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

        btn[0].setOnAction(event -> BtnPress(0));
        btn[1].setOnAction(event -> BtnPress(1));
        btn[2].setOnAction(event -> BtnPress(2));
        btn[3].setOnAction(event -> BtnPress(3));
        btn[4].setOnAction(event -> BtnPress(4));
        btn[5].setOnAction(event -> BtnPress(5));
        btn[6].setOnAction(event -> BtnPress(6));
        btn[7].setOnAction(event -> BtnPress(7));
        btn[8].setOnAction(event -> BtnPress(8));

    });

        /*
        //Escreve mensagem
        btn[0].setOnAction(event -> {
            DisableAll();
            response = "0";
            try {
                c.SendSignal(response);
            } catch (IOException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btn[1].setOnAction(event -> {
            DisableAll();
            response = "1";
            try {
                c.SendSignal(response);
            } catch (IOException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btn[2].setOnAction(event -> {
            DisableAll();
            response = "2";
            try {
                c.SendSignal(response);
            } catch (IOException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btn[3].setOnAction(event -> {
            DisableAll();
            response = "3";
            try {
                c.SendSignal(response);
            } catch (IOException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btn[4].setOnAction(event -> {
            DisableAll();
            response = "4";
            try {
                c.SendSignal(response);
            } catch (IOException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btn[5].setOnAction(event -> {
            DisableAll();
            response = "5";
            try {
                c.SendSignal(response);
            } catch (IOException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btn[6].setOnAction(event -> {
            DisableAll();
            response = "6";
            try {
                c.SendSignal(response);
            } catch (IOException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btn[7].setOnAction(event -> {
            DisableAll();
            response = "7";
            try {
                c.SendSignal(response);
            } catch (IOException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btn[8].setOnAction(event -> {
            DisableAll();
            response = "8";

        });*/
    }

    public Scene init() {
        StackPane choose = new StackPane();
        Scene pane = new Scene(choose, 500, 600);
        
        return pane;
    }
    public Scene Game() {

        // MONTA A TELA DO JOGADOR/SERVIDOR
        StackPane playerPane = new StackPane();
        Scene pane = new Scene(playerPane, 500, 600);
        
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

package trabalho2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    Stage secondaryStage;
    
    public Graphics(Comm c, Player p, Stage ps) {

        secondaryStage = ps;
        
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
    
    private void BtnPress(Player p, Button bt, Comm c){

        DisableAll();
        this.response = bt.getId();

        bt.setText(p.getMark());
        p.game.turn = 3 - p.game.turn;
        c.SendSignal(this.response);
    }
    
    public void StartGame (Player p) {
        
        try {
            p.StartGame();
        } catch (IOException ex) {
            Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ChooseMark (Player p, int mark) {
       
        p.mark = mark;
        System.out.printf("Escolheu : %d", mark);
        secondaryStage.setScene(this.ConnectPane(p));
    }
    
    public Scene init(Player p) {
        
        
        StackPane choose = new StackPane();
        Scene pane = new Scene(choose, 300, 250);
        
        Button x = new Button("x");
        Button o = new Button("o");
        
        HBox t = new HBox(20);
        t.setAlignment(Pos.CENTER);
        
        //1 = x
        //2 = o
        
        x.setOnAction(event -> ChooseMark(p, 1));
        o.setOnAction(event -> ChooseMark(p, 2));
        
        t.getChildren().addAll(x, o);
        
        choose.getChildren().add(t);
        
        return pane;
    }
    public Scene Game(Player p) {

        // MONTA A TELA DO JOGADOR/SERVIDOR
        StackPane playerPane = new StackPane();

        Scene pane = new Scene(playerPane, 450, 450);
        
        //DisableAll();
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(5));

        int k = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                btn[k].setPrefSize(150, 150);
                btn[k].setMaxSize(1000, 1000);
                GridPane.setHgrow(btn[k], Priority.ALWAYS);
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
        
        UpdateButtons(p);
        return pane;
    }
    
    public Scene ConnectPane (Player p) {
        
        StackPane player2Pane = new StackPane();
        Scene pane = new Scene(player2Pane, 500, 600);
        VBox org = new VBox(30);


        TextField ipEntry = new TextField();
        //ipEntry.setPromptText("IP 192.168.0.1");
        ipEntry.setText("192.168.0.8");
        TextField portEntry = new TextField();
        //portEntry.setPromptText("12345");
        portEntry.setText("12345");
        Button btn = new Button("Conectar");
        btn.setDefaultButton(true);
        btn.setOnAction(event1 -> {
            p.ip = ipEntry.getText();
            p.port = Integer.parseInt(portEntry.getText());
            try {
                p.connection.CreateClient(p.ip, 12345);
                
                ReceiveMessage accept = new ReceiveMessage(p.connection.signalIn);
                p.order = Integer.parseInt(accept.run());
                String answer = accept.run();
                if ("ready".equals(answer))
                    StartGame(p);
                
            } catch (IOException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        org.setAlignment(Pos.CENTER);
        org.getChildren().addAll(ipEntry, portEntry, btn);
        
        player2Pane.getChildren().add(org);
        
        return pane;
        
    }
    
    public void DisableAll () {
        for (int i = 0; i < 9; i++) {
            btn[i].setDisable(true);
        }
    }
    
    public void UpdateButtons (Player p) {
       
        for (int i = 0; i < 9; i++) {
            if (p.game.matrix[i] == 0)
                btn[i].setDisable(false);
            else
                btn[i].setText(p.getMark());
        }
    }  
    
    public Scene WaitTurn (Player p) {
        StackPane pn = new StackPane();
        Scene waitScene = new Scene(pn, 300, 250);
        Label wait  = new Label("Wait for your turn");
        
        pn.getChildren().add(wait);
        
        return waitScene;
        
    }
    public Scene PlayAgain (Player p) {
        StackPane st = new StackPane();
        Scene sn = new Scene(st, 300, 250);
        
        Label q = new Label("Do you want to play again?");
        Button yes = new Button("Yes");
        Button no = new Button("No");
        
        yes.setOnAction(event-> {
            try {
                p.StartGame();
            } catch (IOException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        no.setOnAction(event -> {
            try {
                p.connection.CloseConnectionClient();
            } catch (IOException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        HBox h = new HBox(30);
        h.setAlignment(Pos.CENTER);
        h.getChildren().addAll(yes, no);
        VBox v = new VBox();
        v.setAlignment(Pos.CENTER);
        v.getChildren().addAll(q, h);
        
        st.getChildren().add(v);
        
        return sn;
    }
}

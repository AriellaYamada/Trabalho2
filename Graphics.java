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

//Classe que monta todas as telas que são exibidas durante o jogo
public class Graphics {

    public Button[] btn = new Button[9];

    public String response;
    Stage secondaryStage;

    public Graphics(Comm c, Player p, Stage ps) {

        secondaryStage = ps;

        //Cria os botões do jogo
        for (int i = 0; i < 9; i++) {
            btn[i] = new Button();
            btn[i].setId(Integer.valueOf(i).toString());
        }

        btn[0].setOnAction(event -> BtnPress(p, 0));
        btn[1].setOnAction(event -> BtnPress(p, 1));
        btn[2].setOnAction(event -> BtnPress(p, 2));
        btn[3].setOnAction(event -> BtnPress(p, 3));
        btn[4].setOnAction(event -> BtnPress(p, 4));
        btn[5].setOnAction(event -> BtnPress(p, 5));
        btn[6].setOnAction(event -> BtnPress(p, 6));
        btn[7].setOnAction(event -> BtnPress(p, 7));
        btn[8].setOnAction(event -> BtnPress(p, 8));

    }

    //Define o que acontece a cada jogada
    private void BtnPress(Player p, int bt) {

        DisableAll();

        this.response = Integer.valueOf(bt).toString();
        Round r = new Round(p);
        p.game.ReceiveMove(bt, p.mark);
        UpdateButtons(p);
        //Espera a jogada do segundo player
        r.run(this.response);
        UpdateButtons(p);
        //p.flag = false;

    }

    //Exibe a tela com o novo jogo
    public void StartGame(Player p) {

        secondaryStage.setScene(Game(p));
        secondaryStage.show();

        if (p.order == 0) {
            this.DisableAll();
        }

        try {
            p.StartGame();
            if (p.order == 0) {
                p.server.run(p);
            }
            this.UpdateButtons(p);

        } catch (IOException ex) {
            Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Método que define a função do botão de selecionar "x" e "o"
    private void ChooseMark(Player p, int mark) {

        p.mark = mark;
        System.out.printf("Pos : %d", mark);
        secondaryStage.setScene(this.ConnectPane(p));
    }

    //Tela para selecionar "x" e "o"
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

    //Tela do jogo
    public Scene Game(Player p) {

        StackPane playerPane = new StackPane();

        Scene pane = new Scene(playerPane, 450, 450);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(5));

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btn[k].setPrefSize(150, 150);
                btn[k].setMaxSize(1000, 1000);
                GridPane.setHgrow(btn[k], Priority.ALWAYS);
                GridPane.setVgrow(btn[k], Priority.ALWAYS);
                grid.add(btn[k], j, i);
                k++;
            }
        }
        VBox org = new VBox(10);
        org.setAlignment(Pos.CENTER);
        org.getChildren().addAll(grid);
        grid.setPrefSize(450, 450);
        grid.setMaxSize(3000, 3000);
        playerPane.getChildren().add(org);

        return pane;
    }

    //Tela de conexão com o servidor
    public Scene ConnectPane(Player p) {

        StackPane player2Pane = new StackPane();
        Scene pane = new Scene(player2Pane, 450, 450);
        VBox org = new VBox(30);

        TextField ipEntry = new TextField();
        ipEntry.setMaxWidth(250);
                
        ipEntry.setPromptText("IP 192.168.0.1");
        Button btn = new Button("Connect");
        btn.setDefaultButton(true);
        btn.setOnAction(event1 -> {
            p.ip = ipEntry.getText();

            try {
                p.connection.CreateClient(p.ip);
            } catch (IOException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Recebe se ele foi o primeiro a se conectar
            ReceiveMessage accept = new ReceiveMessage(p.connection.signalIn);
            p.order = Integer.parseInt(accept.run());
            //Recebe resposta caso o segundo player já tenha se conectado
            String answer = accept.run();
            if ("ready".equals(answer)) {
                //Chama o inicio do jogo
                StartGame(p);
            }

        });

        org.setAlignment(Pos.CENTER);
        org.getChildren().addAll(ipEntry, btn);

        player2Pane.getChildren().add(org);

        return pane;

    }

    //Disabilita todos os botões do jogo
    public void DisableAll() {
        for (int i = 0; i < 9; i++) {
            btn[i].setDisable(true);
        }
    }

    //Atualiza todos os botões do jogo
    public void UpdateButtons(Player p) {

        for (int i = 0; i < 9; i++) {
            btn[i].setDisable(true);
            if (p.game.matrix[i] == 1) {
                btn[i].setText("X");
            } else if (p.game.matrix[i] == 2) {
                btn[i].setText("O");
            } else {
                btn[i].setDisable(false);
            }
        }
    }

    //Reseta os botões do jogo
    public void ResetButtons() {

        for (int i = 0; i < 9; i++) {
            btn[i].setText(" ");
            btn[i].setDisable(false);
        }
    }

    //Tela de fim de jogo
    public Scene PlayAgain(Player p, int winner) {
        StackPane st = new StackPane();
        Scene sn = new Scene(st, 300, 250);
        Label labelwinner;
        Label q = new Label("Do you want to play again?");
        if (winner == 3)
            labelwinner = new Label("Draw");
        else
            if (winner == p.mark)
                labelwinner = new Label("You win!!!");
            else
                labelwinner = new Label("You loose!!!");
        Button yes = new Button("Yes");
        Button no = new Button("No");

        yes.setOnAction(event -> StartGame(p));

        no.setOnAction(event -> {
            try {
                p.connection.CloseConnectionClient();
                p.window.close();
            } catch (IOException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        HBox h = new HBox(30);
        h.setAlignment(Pos.CENTER);
        h.getChildren().addAll(yes, no);
        VBox v = new VBox(20);
        v.setAlignment(Pos.CENTER);
        v.getChildren().addAll(labelwinner, q, h);

        st.getChildren().add(v);

        return sn;
    }
}

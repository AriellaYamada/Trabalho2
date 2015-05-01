/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ariellayamada
 */
public class Game {
    
    public int matrix[];
    public int nrounds;
    public int draw;
   
    public Game () {
        matrix = new int[9];
    }
    
    public boolean VerifyEnd() {
        if(matrix[0] != 0 && matrix[0] == matrix[1] && matrix[1] == matrix[2]) {
            return true;
        } else if (matrix[3] != 0 && matrix[3] == matrix[4] && matrix[4] == matrix[5]) {
            return true;
        } else if (matrix[6] != 0 && matrix[6] == matrix[7] && matrix[7] == matrix[8]) {
            return true;
        } else if (matrix[0] != 0 && matrix[0] == matrix[4] && matrix[4] == matrix[8]) {
            return true;
        } else if (matrix[2] != 0 && matrix[2] == matrix[4] && matrix[4] == matrix[6]) {
            return true;
        }
        return false;
    }
}

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
    
    public int VerifyEnd() {
        if(matrix[0] != 0) {
            //Verifica primeira linha
            if (matrix[0] == matrix[1] && matrix[1] == matrix[2]){ 
                return matrix[0];
            //Verifica primeira coluna
            } else if (matrix[0] == matrix[3] && matrix[3] == matrix[6]) {
                return matrix[0];
            }
        //Verifica segunda coluna
        } else if (matrix[1] != 0 && matrix[1] == matrix[4] && matrix[4] == matrix[7]) {
            return matrix[1];
        //Verifica terceira coluna
        } else if (matrix[2] != 0 && matrix[2] == matrix[5] && matrix[5] == matrix[8]) {
            return matrix[2];
        //Verifica segunda linha
        } else if (matrix[3] != 0 && matrix[3] == matrix[4] && matrix[4] == matrix[5]) {
            return matrix[3];
        //Verifica terceira linha
        } else if (matrix[6] != 0 && matrix[6] == matrix[7] && matrix[7] == matrix[8]) {
            return matrix[6];
        //Verifica diagonais
        } else if (matrix[0] != 0 && matrix[0] == matrix[4] && matrix[4] == matrix[8]) {
            return matrix[0];
        } else if (matrix[2] != 0 && matrix[2] == matrix[4] && matrix[4] == matrix[6]) {
            return matrix[2];
        }
        for (int i = 0; i < 9; i++) {
            if(matrix[i] == 0) {
                return 0;
            }
        }
        //Deu velha
        return 3;
    }
}

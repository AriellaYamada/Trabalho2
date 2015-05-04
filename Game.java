package trabalho2;

/**
 *
 * @author ariellayamada
 */
public class Game {

    public int matrix[];
    public int nrounds;
    public int draw;
    public int turn;

    public Game(int mark, int order) {
        matrix = new int[9];
        if (order == 0) {
            turn = mark;
        } else {
            if (mark == 1) {
                turn = 2;
            } else {
                turn = 1;
            }
        }
    }

    public boolean ReceiveMove(int move) {
        if (matrix[move] != 0) {
            matrix[move] = turn;
            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
            }
            return true;
        }
        return false;
    }

    public void PrintMatrix() {
        for (int i = 0; i < 9; i++) {
            System.out.println(this.matrix[i] + " ");
        }
    }

    public int VerifyEnd() {
        if (matrix[0] != 0) {
            //Verifica primeira linha
            if (matrix[0] == matrix[1] && matrix[1] == matrix[2]) {
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
            if (matrix[i] == 0) {
                return 0;
            }
        }
        //Deu velha
        return 3;
    }
}

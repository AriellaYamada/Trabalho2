/**
 *
 * @author Ariella Yamada   8937034
 * @author Carlos Schneider 9167910
 * @author Márcio Campos    8937462
 */

package trabalho2;

//Clase que lida com todas as funcionalidades e atributos do jogo
public class Game {

    public int matrix[];
    public int turn;

    public Game(int mark, int order) {
        //Inicializa a matriz que define os campos do jogo
        matrix = new int[9];
        //Seta quem inicia o jogo a partir da mensagem recebida do servidor
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

    //Altera na matriz a jogada do player
    public void ReceiveMove(int move, int player) {
        matrix[move] = player;
    }

    //Verifica se alguém ganhou
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
        //Verifica se deu velha
        for (int i = 0; i < 9; i++) {
            if (matrix[i] == 0) {
                return 0;
            }
        }
        //Deu velha
        return 3;
    }
}

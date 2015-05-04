/**
 *
 * @author Ariella Yamada 8937034
 * @author Carlos Schneider 9167910
 * @author Márcio Campos 8937462
 */

package trabalho2;

import java.io.InputStream;
import java.util.Scanner;

public class ReceiveMessage {
    public InputStream server;
    
    public ReceiveMessage (InputStream s) {
        this.server = s;
    }

    //Recebe mensagens do servidor
    public String run() {
        
        Scanner move = new Scanner(this.server);
        String msg;
            msg = move.nextLine();
            System.out.println(msg);
            return msg;
       
    }
    
}

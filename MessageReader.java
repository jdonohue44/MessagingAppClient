import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by jareddonohue on 10/10/17.
 */
public class MessageReader extends Thread {
    Socket clientSocket;
    BufferedReader inFromServer;

    public MessageReader(Socket socket) {
        clientSocket = socket;
        try {
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void run() {
        while (true) {
            try {
                if (inFromServer.ready()) {
                    System.out.println(inFromServer.readLine());
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}

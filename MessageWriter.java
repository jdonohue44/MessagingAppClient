import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by jareddonohue on 10/10/17.
 */
public class MessageWriter extends Thread {
    Socket clientSocket;
    DataOutputStream outToServer;
    BufferedReader stdIn;
    String username;

    public MessageWriter(Socket socket, String username) {
        clientSocket = socket;
        stdIn = new BufferedReader(new InputStreamReader(System.in));
        try {
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        this.username = username;
    }

    public void run() {
        try {
            readStdIn();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void readStdIn() throws IOException {
        String message;
        while ((message = stdIn.readLine()) != null) {
            sendMessage(message);
        }
    }

    private void sendMessage(String message) throws IOException {
        if (message.length() > 0) {
            outToServer.writeBytes(username + ": " + message + '\n');
        }
    }
}

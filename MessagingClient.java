import java.io.*;
import java.net.*;
/**
 * Class to represent the client
 */
public class  MessagingClient {
    Socket clientSocket;
    MessageReader messageReader;
    Thread readerThread;
    MessageWriter messageWriter;
    Thread writerThread;

    public MessagingClient(String username) {
        try {
            clientSocket = new Socket("54.83.149.230", 6789);
            System.out.println("Connection to server made.");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        messageReader = new MessageReader(clientSocket);
        readerThread = new Thread(messageReader);

        messageWriter = new MessageWriter(clientSocket, username);
        writerThread = new Thread(messageWriter);
    }

    public void run() throws IOException {
         readerThread.start();
         writerThread.start();
    }
}

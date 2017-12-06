import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Runs the client application
 */
public class Main{
    public static void main(String[] args) {
        // get username and pass it to MessagingClient
        try {
            System.out.print("enter your username: ");
            String username = new BufferedReader(new InputStreamReader(System.in)).readLine();
            MessagingClient messagingClient = new MessagingClient(username);
            messagingClient.run();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

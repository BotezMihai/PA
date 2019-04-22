import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocialNetworkServer {

    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean running = false;

    public static void main(String[] args)  {
        SocialNetworkServer server = new SocialNetworkServer();
        server.init();
        server.waitForClients(); //... handle the exceptions!
        System.out.println("sunt aici");
    }
    // Implement the init() method: create the serverSocket and set running to true
            // Implement the waitForClients() method: while running is true, create a new socket for every incoming client and start a ClientThread to execute its request.
    private void init() {
        try {
            serverSocket = new ServerSocket( PORT );
        } catch (IOException e) {
            e.printStackTrace();
        }
        running = true;
    }

    private void waitForClients(){
        while( running ) {
            System.out.println(" Asteptam un client... ");
            try {
                Socket socket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(socket,this);
                clientThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop() throws IOException {
        this.running = false;
        serverSocket.close();
    }
}

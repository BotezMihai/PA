import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class ClientThread extends Thread {


    private Socket socket = null;
    private final SocialNetworkServer server;
    private String name;
    private String friendshipFile;
    // Create the constructor that receives a reference to the server and to the client socket

    public ClientThread(Socket socket, SocialNetworkServer server) throws SocketException {
        this.socket = socket;
        this.socket.setSoTimeout(100000);
        this.server = server;
    }

    public void run() {
        BufferedReader in = null;
        String request = null;
        String response = null;
        PrintWriter out = null;
        //... usse try-catch-finally to handle the exceptions!
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream()); //server -> client stream
            while (true) {
                request = in.readLine();
                System.out.println("stringul este " + request);
                if (request == null)
                    break;
                response = execute(request);
                out.println(response);
                out.flush();
            }

        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            System.out.println("Socket timed out!!!");
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            out.println("exit");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized String execute(String request) {
        // display the message: "Server received the request ... "

        System.out.println(request);
        String[] parts = request.split(" ");
        if (parts[0].equals("register")) {
            try {
                File file = new File("utilizatori.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                while ((st = br.readLine()) != null)
                    if (st.equals(parts[1]) == true) {
                        return "Exista deja un utilizator cu acest nume";
                    }

            } catch (IOException ioe) {
                System.err.println("Eroare la citire");
            }
            try {
//

                FileWriter fw = new FileWriter("utilizatori.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(parts[1]);
                bw.newLine();
                bw.close();
            } catch (IOException ioe) {
                System.err.println("IOException: " + ioe.getMessage());
            }
        } else if (parts[0].equals("login")) {

            try {
                File file = new File("utilizatori.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                while ((st = br.readLine()) != null)
                    if (st.equals(parts[1]) == true) {
                        name = parts[1];
                        return "Bine ai venit," + parts[1] + "!";

                    }

            } catch (IOException ioe) {
                System.err.println("Eroare la citire");
            }

        } else if (parts[0].equals("friend")) {
            this.friendshipFile = name.concat(".txt");
            System.out.print("Fisierul este: " + friendshipFile);
            File tmpDir = new File(friendshipFile);
            boolean exists = tmpDir.exists();
            if (exists == false) {
                File file = new File(friendshipFile);

            }
            try {
                FileWriter fw = new FileWriter(friendshipFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                int i;
                for (i = 1; i < parts.length; i++) {
                    bw.write(parts[i]);
                    bw.newLine();
                }
                bw.close();
            } catch (IOException ioe) {
                System.err.println("IOException: " + ioe.getMessage());
            }


        } else if (parts[0].equals("send")) {

            String msg = "";
            msg += name;
            msg += ": ";
            int i;
            for (i = 1; i < parts.length; i++) {
                msg += parts[i];
                msg += " ";

            }
            try {
                System.out.print(name);
                this.friendshipFile = name.concat(".txt");
                File file = new File(friendshipFile);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String user;
                while ((user = br.readLine()) != null) {


                    String conversation = user;
                    conversation += "conv.txt";
                    System.out.print("conv e " + conversation);
//
                    File f = new File(conversation);
                    if (!f.exists()) {
                        System.out.println("se face");
                        f.createNewFile();
                    }
                    try {
                        FileWriter fw = new FileWriter(conversation, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(msg);
                        bw.newLine();
                        bw.close();
                    } catch (IOException ioe) {
                        System.err.println("IOException: " + ioe.getMessage());
                    }


                }

            } catch (IOException ioe) {
                System.err.println("Eroare la citire");
            }


        } else if (parts[0].equals("read")) {

            String nameFile = "";
            nameFile += name;
            nameFile += "conv.txt";
            File file = new File(nameFile);
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                String content = "";
                while ((line = bufferedReader.readLine()) != null) {
                    content += line;

                }
                return content;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {
            return "Comanda necunoscuta!";
        }

        return "succes";
    }
}

package app;

import java.io.*;
import java.net.*;
import java.util.*;

// Client class
class Client {
public static  long Client1stime=-1;
    // driver code
    public static String destinatinn="0",data;

    public static void main(String[] args)
    {
        Serverside();


        // establish a connection by providing host and port
        // number

        try (Socket socket = new Socket("localhost", Integer.parseInt(destinatinn))) {
            System.out.print("time in milliseconds = ");
            System.out.println(
                    System.currentTimeMillis());
            Client1stime=System.currentTimeMillis();
            // writing to server
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);
            // returns the current value of the system timer, in milliseconds

            // reading from server
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            // returns the current value of the system timer, in milliseconds


            // object of scanner class
            Scanner sc = new Scanner(System.in);
            String line = null;

            while (!"exit".equalsIgnoreCase(line)) {

                // reading from user
                line = sc.nextLine();

                // sending the user input to server
                out.println(line);
                out.flush();

                // displaying server reply
                System.out.print("time in milliseconds = ");
                System.out.println(System.currentTimeMillis());
                Client1stime=System.currentTimeMillis()-Client1stime;
                System.out.println("Server replied "
                        + in.readLine());
                System.out.println(Client1stime);
            }
            // closing the scanner object
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void Serverside()
    {
        ServerSocket server = null;

        try {
            // server is listening on port 1234
            server = new ServerSocket(22332);
            server.setReuseAddress(true);

            // running infinite loop for getting
            // client request
            while (true) {

                // socket object to receive incoming client
                // requests
                Socket client = server.accept();

                // Displaying that new client is connected
                // to server
                System.out.println("New client connected"
                        + client.getInetAddress()
                        .getHostAddress());

destinatinn=client.getInetAddress()
        .getHostAddress();
data = new PrintStream(client.getOutputStream()).toString();

break;
                // create a new thread object


                // This thread will handle the client
                // separately

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}

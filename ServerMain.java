import java.io.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain { 

    public static void main(String[] args) throws IOException {
        
        // set default port number 
        int port = 4000; 

        // check for user input port number
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        // print port number 
        System.out.printf(">>> Listening on port number %d\n", port);

        // create server 
        ServerSocket server = new ServerSocket(port);

        // while loop 
        while (true) {

            // print waiting for connection 
            System.out.println(">>> Waiting for connection");

            // accept incomming connection 
            Socket conn = server.accept(); 

            // print client connection confirmation 
            System.out.println(">>> Got a client connection");

            // get input stream 
            InputStream is = conn.getInputStream(); 
            Reader reader = new InputStreamReader(is); 
            BufferedReader br = new BufferedReader(reader); 

            // get output stream 
            OutputStream os = conn.getOutputStream(); 
            Writer writer = new OutputStreamWriter(os); 
            BufferedWriter bw = new BufferedWriter(writer); 

            // getting message from client 
            String msg = br.readLine(); 
            System.out.printf(">>> Message from client: %s\n", msg);

            // send message to client 
            String toClient = "PEEPEEPOOPOO"; 
            bw.write(toClient); 
            bw.flush(); 

            // close connection 
            conn.close(); 

        }

    }

}
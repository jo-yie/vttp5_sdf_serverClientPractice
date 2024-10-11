import java.io.*;
import java.net.Socket;

public class ClientMain {
    
    public static void main(String[] args) throws IOException {
        
        // create a socket to connect to server 
        Socket sock = new Socket("localhost", 4000); 

        // print to confirm connection to server 
        System.out.println(">> Conncected to server");

        // receive user input 
        Console cons = System.console(); 
        String msg = cons.readLine(">> User input: ");

        // get output stream 
        OutputStream os = sock.getOutputStream(); 
        Writer writer = new OutputStreamWriter(os); 
        BufferedWriter bw = new BufferedWriter(writer); 

        // get input stream 
        InputStream is = sock.getInputStream(); 
        Reader reader = new InputStreamReader(is); 
        BufferedReader br = new BufferedReader(reader);

        // write message to server
        // add new line to writer 
        bw.write(msg + "\n");

        // force it into the network 
        bw.flush();

        // read message from server 
        String toServer = br.readLine();

        // print message from server
        System.out.printf(">> Message from server: %s\n", toServer);

        // close connection 
        sock.close(); 

    }


}

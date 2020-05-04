




import java.io.PrintWriter;
import java.util.HashSet;
import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 
import java.net.*; 
import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;


/**
 * A multithreaded chat room server.  When a client connects the
 * server requests a screen name by sending the client the
 * text "SUBMITNAME", and keeps requesting a name until
 * a unique one is received.  After a client submits a unique
 * name, the server acknowledges with "NAMEACCEPTED".  Then
 * all messages from that client will be broadcast to all other
 * clients that have submitted a unique screen name.  The
 * broadcast messages are prefixed with "MESSAGE ".
 * 
 */
public class ChatServerExec {

    DataInputStream din; 
    DataOutputStream dout; 
    Socket socket;
    boolean shouldRun = true; 
    
    public ChatServerExec(int port) {
    	CHAT_ROOM_PORT = port;
    }
    
    /**
     * The port that the server listens on.
     */
    
    private static int CHAT_ROOM_PORT;
    
    /**
     * Starts an instance of a server in a thread so that GUI thread can continue to operate asynchronously
     * @param port
     */
    
   public void startServer() {

            ChatServer server = new ChatServer(CHAT_ROOM_PORT); 
            Thread thread = new Thread(server); 
            thread.start();
            
    }

    
  
   
}

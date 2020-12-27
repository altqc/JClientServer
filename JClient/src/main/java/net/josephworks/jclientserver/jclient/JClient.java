package net.josephworks.jclientserver.jclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class JClient {
    // constructor to put ip address and port
    public JClient(String address, int port) {
        // establish a connection
        DataInputStream input = null;
        DataOutputStream out = null;
        // initialize socket and input output streams
        Socket socket = null;
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException u) {
            System.out.println(u);
        }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        while (!line.equals("Over")) {
            try {
                assert input != null;
                line = input.readLine();
                assert out != null;
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        // close the connection
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }
}

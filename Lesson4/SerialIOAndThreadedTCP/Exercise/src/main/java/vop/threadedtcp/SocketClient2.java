package vop.threadedtcp;

import vop.serialio.Species;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient2 {

    public static void main(String[] args) {
        String str;
        Scanner inputStream = null;
        ObjectOutputStream outputStream = null;

        try (Socket clientSocket = new Socket("localhost", 3333)) {
            // Set up streams to send/receive data
            inputStream = new Scanner(clientSocket.getInputStream());
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            // Start massage from server:
            System.out.println(inputStream.nextLine());
            // Read a line from the keyboard:
            outputStream.writeObject(new Species("Calif. Condor", 27, 0.02));

            // Read answer from the server and output it to the screen
            str = inputStream.nextLine();
            System.out.println(str);

        } catch (Exception e) {
            // If any exception occurs, display it
            System.out.println("Error " + e);
        } finally {
            inputStream.close();
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

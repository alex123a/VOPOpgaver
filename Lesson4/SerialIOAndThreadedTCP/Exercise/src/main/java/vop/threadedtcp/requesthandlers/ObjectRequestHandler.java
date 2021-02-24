package vop.threadedtcp.requesthandlers;

import vop.serialio.Species;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class ObjectRequestHandler extends AbstractRequestHandler{

    public ObjectRequestHandler(Socket socket) {
        super(socket);
    }

    @Override
    public void run() {
        System.out.println("RequestHandler started for " + socket.getPort());

        try (ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            writer.println("Now chatting");
            System.out.println((Species) input.readObject());

            writer.println("Done");

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the file! " + e);
        } catch (IOException e) {
            System.out.println("Some other IO Exception: " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("This Thread is over!");
        }
    }
}

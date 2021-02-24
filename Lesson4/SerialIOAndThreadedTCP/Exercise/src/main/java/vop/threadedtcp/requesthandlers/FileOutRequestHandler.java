package vop.threadedtcp.requesthandlers;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOutRequestHandler extends AbstractRequestHandler {

    private String fileName;

    public FileOutRequestHandler(Socket socket, String fileName) {
        super(socket);
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("RequestHandler started for " + socket.getPort());

        try (Scanner scanner = new Scanner(socket.getInputStream());
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
            PrintWriter output = new PrintWriter(new File(fileName));
            output.print(new Date() + "\t");
            output.print(socket.getInetAddress() + ":" + socket.getPort());
            writer.println("Server ready. Type your massage:");

            while (scanner.hasNextLine()) {
                output.print("\t" + scanner.nextLine());
                writer.println("Done");
            }

            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the file! " + e);
        } catch (IOException e) {
            System.out.println("Some other IO Exception: " + e);
            //Logger.getLogger(FileOutRequestHandler.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            System.out.println("This Thread is over!");
        }
    }
}

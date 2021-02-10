package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fsan
 */
public class CamelWriter {

    private File inFile;

    public CamelWriter(String fName) {
        inFile = new File(getClass().getClassLoader().getResource(fName).getFile());
        System.out.println(inFile.getName());
    }

    public void readLines() {
        Scanner scan = null;
        try {
            scan = new Scanner(inFile);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.length() == 0) {
                    continue;
                }
                convert2camel(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CamelWriter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            scan.close();
        }

        // Benyt en Scanner til at læse inFile én linje ad gangen
        // Kald convert2camel med hver linje.
    }

    private void convert2camel(String line) {
        line = line.toLowerCase();
        String[] words = line.split(" ");
        String camelLine = words[0].toLowerCase();
        for (int i = 1; i < words.length; i++) {
            camelLine += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
//        System.out.println(camelLine);
        printToFile(camelLine);
        // Split line til et String[] af de enkelte ord i linjen
        // Konverter 1. ord til små og resten til stort begyndelsesbogstav
        // Sammensæt ordene til ét langt ord og udskriv.
    }

    private void printToFile(String line) {
        File f = new File("CamelOut.txt");
        try (FileWriter fw = new FileWriter(f, true)) {
            fw.append(line);
            fw.append("\n");
        } catch (IOException ex) {
            Logger.getLogger(CamelWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        String fName = "MaryAnn.txt";
        CamelWriter cw = new CamelWriter(fName);
        cw.readLines();
    }

}

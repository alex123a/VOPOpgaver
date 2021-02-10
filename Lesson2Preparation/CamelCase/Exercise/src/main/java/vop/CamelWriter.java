package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author erso
 */
public class CamelWriter {

    private File inFile;

    public CamelWriter(String fName) {
        this.inFile = new File(fName);
    }

    public void readLines() {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(inFile);
            while (inputStream.hasNextLine()) {
                convert2camel(inputStream.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("This file does not exist!");
        } finally {
            inputStream.close();
        }
    }

    private void convert2camel(String line) {
        String[] splittedWords = line.split(" ");
        String finalWord = splittedWords[0].toLowerCase();

        for (int i = 1; i < splittedWords.length; i++) {
            finalWord = finalWord + splittedWords[i].substring(0, 1).toUpperCase() + splittedWords[i].substring(1);
        }

        System.out.println(finalWord);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CamelWriter cw = new CamelWriter("DryLips.txt");
        CamelWriter cw = new CamelWriter("C:\\Users\\alexv\\Documents\\GitHub\\exercises\\Lesson2Preparation\\CamelCase\\Exercise\\src\\main\\resources\\DryLips.txt");
        cw.readLines();
    }

}

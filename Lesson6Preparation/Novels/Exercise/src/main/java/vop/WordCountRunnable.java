package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCountRunnable implements Runnable {
    private String fileName;

    public WordCountRunnable(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        int words = 0;
        try {
            Scanner scanner = new Scanner(new File(getClass().getResource(fileName).getPath()));
            while (scanner.hasNext()) {
                words++;
                scanner.next();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("The file " + fileName + " has: " + words + " words");
        }
    }
}

package vop;

import java.io.File;
import java.util.Scanner;

/**
 * @author erso
 */
public class FindFilesRecursive {

    private int noDirs = 0;
    private int noFiles = 0;


    // Exercise: If a file is a directory: Call all files recursively,
    // else print full path to the file. Count both dirs and atomic files.
    private void findFiles(File file) {
        if (file.isFile()) {
            System.out.println(file.getAbsolutePath());
            noFiles++;
        } else if (file.isDirectory()) {
            noDirs++;
            for (File theFile: file.listFiles()) {
                findFiles(theFile);
            }
        }
    }




    @Override
    public String toString() {
        return "FindFilesRecursive{" + "noDirs=" + noDirs + ", noFiles=" + noFiles + '}';
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();
        File startDir = new File(directory);

        FindFilesRecursive ffr = new FindFilesRecursive();
        ffr.findFiles(startDir);
        System.out.println("\n*************\n" + ffr);
        System.out.println("Number of files: " + ffr.noFiles + " number of directories: " + ffr.noDirs);
    }


}

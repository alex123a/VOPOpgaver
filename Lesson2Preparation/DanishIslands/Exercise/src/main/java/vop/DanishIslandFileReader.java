package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author erso
 */
public class DanishIslandFileReader {

    private File inFile;
    private List<DanishIsland> islandList;

    public DanishIslandFileReader(String fName) {
        this.inFile = new File(fName);
    }

    private void readFile() {
        islandList = new ArrayList<DanishIsland>();
        Scanner scan = null;
        String line;
        String[] tokens;

        String name = "";
        double circ;
        double area;
        int addr;
        int adkm;

        try {
            scan = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scan.hasNextLine()) {
            line = scan.nextLine();
            tokens = line.split(" ");
            name = tokens[0];
            circ = Double.parseDouble(tokens[1].replace(",", "."));
            area = Double.parseDouble(tokens[2].replace(",", "."));
            addr = Integer.parseInt(tokens[3]);
            adkm = Integer.parseInt(tokens[4]);
            islandList.add(new DanishIsland(name, circ, area, addr, adkm));
        }

        scan.close();
    }
    
    public List<?> getList(){
        return islandList;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println(DanishIslandFileReader.class.getClassLoader().getResource("Islands_komma.txt"));
        DanishIslandFileReader fr = new DanishIslandFileReader("C:/Users/alexv/Documents/GitHub/exercises/Lesson2Preparation/DanishIslands/Exercise/target/classes/Islands_komma.txt");
        //DanishIslandFileReader fr = new DanishIslandFileReader("Islands_komma.txt");
        fr.readFile();
        
        
        System.out.println("Result:\n" + fr.getList());

    }


}

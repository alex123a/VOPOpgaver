package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author fsan
 */
public class DanishIslandFileReader {

    private File inFile;
    private List<DanishIsland> islandList;


    public DanishIslandFileReader(String fName) {
        inFile = new File(fName);
    }

    private void readFile() {
        islandList = new ArrayList<>();
        String line;
        String[] tokens;
        String name = "";
        double circ;
        double area;
        int addr;
        int adkm;
        try (Scanner scan = new Scanner(inFile)) {
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                tokens = line.split(" ");
                name = tokens[0];
                NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);
                circ = format.parse(tokens[1]).doubleValue();
                area = format.parse(tokens[2]).doubleValue();
                addr = format.parse(tokens[3]).intValue();
                adkm = format.parse(tokens[4]).intValue();
                islandList.add(new DanishIsland(name, circ, area, addr, adkm));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException | ParseException ex) {
            System.err.println("NumberFormatException in " + name + "\n" + ex.getMessage());
        }

        // OPGAVEN:
        // Laes filen en linje ad gangen. Split linjen paa mellemrums tegnet.
        // Konverter de enkelte vaerdier til typerne der skal bruges i DanishIsland.
        // Opret et objekt for hver linje og tilfoej det til listen.
        // Vaer omhyggelig med at fange exceptions og faa lukke Scanner og fil
    }

    public List<?> getList() {
        return islandList;
    }

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        System.out.println(DanishIslandFileReader.class.getClassLoader().getResource("Islands_komma.txt"));
        URL file = DanishIslandFileReader.class.getClassLoader().getResource("Islands_komma.txt");
        DanishIslandFileReader fr = new DanishIslandFileReader(file.getFile());
        fr.readFile();

        System.out.println("Result:\n" + fr.getList());

    }

}

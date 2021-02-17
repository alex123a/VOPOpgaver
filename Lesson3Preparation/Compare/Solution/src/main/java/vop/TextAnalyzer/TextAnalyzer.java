package vop.TextAnalyzer;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class TextAnalyzer {

    private File file;

    public TextAnalyzer(String fileName) throws URISyntaxException {
        file = new File(getClass().getClassLoader().getResource(fileName).toURI().getPath());
    }

    // Opgave 2A
    // Parameteren sorted afgør om der skal benyttes et sorteret Set
    //
    public Set<String> findUniqueWords(boolean sorted) {
        // ternary operator (mere info: https://www.baeldung.com/java-ternary-operator)
        Set<String> set = sorted ? new TreeSet<>() : new HashSet<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                set.add(clean(scanner.next()));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return set;
    }

    public Map<String, Integer> countWords(boolean sorted) {
        Map<String, Integer> map = sorted ? new TreeMap<>() : new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            String word;
            int val;
            while (scanner.hasNext()) {
                val = 1;
                word = clean(scanner.next());

                if (map.containsKey(word)) {
                    val += map.get(word);
                }

                map.put(word, val);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return map;
    }

    // Opgave 2C:     Udvidelse af P15.1
    //
    public Map<Integer, Set<String>> lengthOfWords(boolean sorted) {
        Map<Integer, Set<String>> mapOfSets = sorted ? new TreeMap<>() : new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            String word;
            int length;
            while (scanner.hasNext()) {
                word = clean(scanner.next());
                length = word.length();

                if (mapOfSets.containsKey(length)) {
                    mapOfSets.get(length).add(word);
                    continue;
                }

                Set<String> s = sorted ? new TreeSet<>() : new HashSet<>();
                s.add(word);
                mapOfSets.put(length, s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return mapOfSets;

    }

    // Denne metode forsøger at fjerne alt 'snavs' fra en String,
    // så kun bogstaver bevares og store gøres til små
    private String clean(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws URISyntaxException {

        TextAnalyzer ta = new TextAnalyzer("alice30.txt");
        ta.countWords(false);
        // Opgave 2A. Find alle unikke ord i filen
        Set<String> set = ta.findUniqueWords(true);
        System.out.println(set);
        System.out.println("Number of unique words: " + set.size());

        System.out.println("\n------------------------------------------------------------------\n");

        // Opgave 2B. Tæl forekomster af ord
		Map<String, Integer> map = ta.countWords(true);
		System.out.println(map);

        System.out.println("\n------------------------------------------------------------------\n");

        // Opgave 2C. Benyt en mappe til at gruppere ord efter længde
		Map<Integer, Set<String>> map2 = ta.lengthOfWords(true);
		System.out.println(map2);
    }

}

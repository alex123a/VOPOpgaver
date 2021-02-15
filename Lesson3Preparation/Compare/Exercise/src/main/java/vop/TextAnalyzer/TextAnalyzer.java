package vop.TextAnalyzer;


import java.io.File;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.Map;

public class TextAnalyzer {

	private File file;

	public TextAnalyzer(String fileName) throws URISyntaxException {
		file = new File(getClass().getClassLoader().getResource(fileName).toURI().toString());
	}

	// Opgave 2A     
	// Parameteren sorted afgør om der skal benyttes et sorteret Set
	//
	public Set<String> findUniqueWords(boolean sorted) {
		Set<String> set = null;
		if (sorted) {
			//set =  //initialiser et sorteret Set
		} else {
			//set = // initialiser et usorteret Set
		}

		// gennemlæs filen et ord ad gangen
		// kald clean() metoden på hvert ord
		// og tilføj ordet til settet.

		return set;
	}

	// Opgave 2B:   Nearly as Listing 21.9 from Liang
	//
	public Map<String, Integer> countWords(boolean sorted) {
		Map<String, Integer> map = null;
		if (sorted) {
			//map = // sorteret mappe
		} else {
			//map = // usorteret mappe
		}
		// gennemlæs filen et ord ad gangen
		// kald clean() metoden på hvert ord
		// benyt mappen til at tælle forekomsten af hvert ord

		return map;
	}

	// Opgave 2C:     Udvidelse af P15.1
	//
	public Map<Integer, Set<String>> lengtOfWords(boolean sorted) {
		Map<Integer, Set<String>> mapOfSets = null;
		if (sorted) {
			//mapOfSets = // sorteret
		} else {
			//mapOfSets = // usorteret
		}
		// gennemlæs filen et ord ad gangen
		// kald clean() metoden på hvert ord
		// Indsæt hvert ord i det Set<String> som er værdi til ordlængden som key
		// Hint: nyt Set<String> skal oprettes hver gang en længde opdages første gang.


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
//		Set<String> set = ta.findUniqueWords(true);
//		System.out.println(set);
//		System.out.println("Number of unique words: " + set.size());

		System.out.println("\n------------------------------------------------------------------\n");

		// Opgave 2B. Tæl forekomster af ord
//		Map<String, Integer> map = ta.countWords(true);
//		System.out.println(map);
//
		System.out.println("\n------------------------------------------------------------------\n");

		// Opgave 2C. Benyt en mappe til at gruppere ord efter længde
//		Map<Integer, Set<String>> map2 = ta.lengtOfWords(true);
//		System.out.println(map2);

	}

}

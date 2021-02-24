package vop.TextAnalyzer;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.*;

public class TextAnalyzer {

	private File file;

	public TextAnalyzer(String fileName) throws URISyntaxException {
		//file = new File(getClass().getClassLoader().getResource(fileName).toURI().toString());
		file = new File(fileName);
	}


	public Set<String> findUniqueWords(boolean sorted) {
		Set<String> set;
		if (sorted) {
			set = new TreeSet<>();
		} else {
			set = new HashSet<>();
		}

		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				set.add(clean(scanner.next()));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("The file is not found! Check path");
		}

		return set;
	}

	public Map<String, Integer> countWords(boolean sorted) {
		Map<String, Integer> map;
		if (sorted) {
			map = new TreeMap<>();
		} else {
			map = new HashMap<>();
		}

		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String nextWord = this.clean(scanner.next());
				if (!map.containsKey(nextWord)) {
					map.put(nextWord, 1);
				} else {
					map.put(nextWord, map.get(nextWord) + 1);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("The file is not found! Check path");
		}

		return map;
	}


	public Map<Integer, Set<String>> lengtOfWords(boolean sorted) {
		Map<Integer, Set<String>> mapOfSets;
		if (sorted) {
			mapOfSets = new TreeMap<>();
		} else {
			mapOfSets = new HashMap<>();
		}

		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String nextWord = clean(scanner.next());
				if (!mapOfSets.containsKey(nextWord.length())) {
					mapOfSets.put(nextWord.length(), new HashSet<>(Arrays.asList(nextWord)));
				} else {
					Set<String> newSet = new TreeSet<>();
					newSet.addAll(mapOfSets.get(nextWord.length()));
					newSet.add(nextWord);
					mapOfSets.put(nextWord.length(), newSet);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("The file is not found! Check path");
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

		//TextAnalyzer ta = new TextAnalyzer("alice30.txt");
		TextAnalyzer ta = new TextAnalyzer("C:/Users/alexv/Documents/GitHub/exercises/Lesson3Preparation/Compare/Exercise/src/main/java/vop/TextAnalyzer/alice30.txt");
		ta.countWords(false);
		// Opgave 2A. Find alle unikke ord i filen
		Set<String> set = ta.findUniqueWords(true);
		System.out.println(set);
		System.out.println("Number of unique words: " + set.size());

		System.out.println("\n------------------------------------------------------------------\n");


		Map<String, Integer> map = ta.countWords(true);
		System.out.println(map);

		System.out.println("\n------------------------------------------------------------------\n");

		Map<Integer, Set<String>> map2 = ta.lengtOfWords(true);
		System.out.println(map2);

	}

}

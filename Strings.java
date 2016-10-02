package test.hacker.rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Strings {

	public static void pangrams(String[] args) {

		// constants
		final int ASCII_UPPERCASE_START = 65;
		final int ASCII_UPPERCASE_END = 90;
		final int ASCII_LOWERCASE_START = 97;
		final int ASCII_LOWERCASE_END = 122;

		Scanner s = new Scanner(System.in);
		char[] ca = s.nextLine().replace("\\s", "").toCharArray();
		List<Character> sentenceList = new ArrayList<>();
		for (char character : ca) {
			sentenceList.add(character);
		}

		List<Character> alphabet = new ArrayList<>();
		// initialize alphabet
		for (int i = ASCII_UPPERCASE_START, j = ASCII_LOWERCASE_START, k = 0; i <= ASCII_UPPERCASE_END
				&& j <= ASCII_LOWERCASE_END && k < 52; i++, j++, k = k + 2) {
			alphabet.add((char) i);
			alphabet.add((char) j);
		}

		int total = 0;
		Collections.sort(alphabet);
		for (Character c : sentenceList) {
			if (alphabet.contains(c)) {
				alphabet.remove(c);
				if (Character.isUpperCase(c)) {
					alphabet.remove(Character.valueOf(Character.toLowerCase(c)));
				} else {
					alphabet.remove(Character.valueOf(Character.toUpperCase(c)));
				}
				total++;
			}
		}

		System.out.println(total == 26 ? "pangram" : "not pangram");

		s.close();

	}

	/**
	 * Alternating characters
	 * 
	 * @param args
	 */
	public static void alternatingCharacters(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		s.nextLine();
		for (int i = 0; i < tc; i++) {
			int deletions = 0;
			char[] r = s.nextLine().toCharArray();

			char compareTo = r[0];
			for (int j = 0; j < r.length - 1; j++) {
				if (compareTo == r[j + 1]) {
					deletions++;
				}
				compareTo = r[j + 1];
			}
			System.out.println(deletions);
		}
		s.close();
	}

	/**
	 * Two strings : Brute force. Will time out.
	 */
	public static void twoStrings(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		String[] results = new String[tc];
		Arrays.fill(results, "NO");
		s.nextLine();

		for (int i = 0; i < tc; i++) {
			String first = s.nextLine();
			String second = s.nextLine();

			for (int substringSize = 1; substringSize < first.length(); substringSize++) {

				for (int startIndex = 0; startIndex + substringSize < first
						.length(); startIndex++) {
					if (second.contains(first.substring(startIndex, startIndex
							+ substringSize))) {
						results[i] = "YES";
						break;
					}
				}
				if (results[i].equals("YES")) {
					break;
				}

			}
		}

		for (String r : results) {
			System.out.println(r);
		}

		s.close();

	}

	public static void twoStringOptimal(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		String[] results = new String[tc];
		Arrays.fill(results, "NO");
		s.nextLine();

		for (int i = 0; i < tc; i++) {
			String first = s.nextLine();
			String second = s.nextLine();

			for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
				if (first.indexOf(c) > -1 && second.indexOf(c) > -1) {
					results[i] = "YES";
					break;
				}
			}
		}
		for (String r : results) {
			System.out.println(r);
		}
		s.close();
	}

	/**
	 * Funny String
	 * 
	 * @param args
	 */
	public static void funnyString(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		s.nextLine();

		for (int i = 0; i < tc; i++) {
			String funny = s.nextLine();
			char[] reversedFunnyR = new StringBuilder(funny).reverse()
					.toString().toCharArray();
			char[] funnyR = funny.toCharArray();

			int max = 0;
			for (int j = 1; j < funnyR.length; j++) {
				if (Math.abs(funnyR[j] - funnyR[j - 1]) == Math
						.abs(reversedFunnyR[j] - reversedFunnyR[j - 1])) {
					max++;
				} else {
					break;
				}
			}

			if (max == reversedFunnyR.length - 1) {
				System.out.println("Funny");
			} else {
				System.out.println("Not Funny");
			}

		}
		s.close();

	}

	/**
	 * Gemstones : Stream Implementation
	 * 
	 * @param args
	 */
	public static void gemstonesStream(String[] args) {
		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		s.nextLine();

		List<Integer> collection = null;
		for (int i = 0; i < tc; i++) {

			List<Integer> d = s.nextLine().chars().distinct().boxed()
					.collect(Collectors.toList());

			for (int j = 0; j < tc - 1; j++) {
				collection = s.nextLine().chars().distinct().boxed()
						.filter((p) -> {
							if (d.contains(p)) {
								return true;
							} else {
								d.remove(p);
								return false;
							}
						}).collect(Collectors.toList());
			}
		}
		System.out.println(collection.size());
		s.close();

	}

	public static void gemstones(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		s.nextLine();

		Set<Character> common = new HashSet<>();

		char[] first = s.nextLine().toCharArray();
		for (char c : first) {
			common.add(c);
		}

		for (int i = 0; i < tc - 1; i++) {
			char[] element = s.nextLine().toCharArray();
			Set<Character> elementSet = new HashSet<>();
			for (char c : element) {
				elementSet.add(c);
			}
			common.retainAll(elementSet);

		}

		System.out.println(common.size());
	}

	/**
	 * Bear and Steady Gene
	 * 
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void bearAndSteadyGene(String[] args) {

		Scanner sc = new Scanner(System.in);
		String g = "ACGT";

		int n = sc.nextInt();
		int need = n / 4;
		boolean ok = true;
		int[] cnt = new int[256];
		Arrays.fill(cnt, 0);
		sc.nextLine();

		String s = sc.nextLine();
		for (char c : s.toCharArray()) {
			cnt[c]++;
			if (cnt[c] > need || cnt[c] < need) {
				ok = false;
			}
		}

		if (ok) {
			System.out.println(0);
			return;
		} else {

		}

		System.out.println("Need : " + need);
		System.out.println("Number of A's : " + cnt['A']);
		System.out.println("Number of C's : " + cnt['C']);
		System.out.println("Number of G's : " + cnt['G']);
		System.out.println("Number of T's : " + cnt['T']);

		sc.close();
	}

	public static void frequencyTest(String[] args) {

		int[] cnt = new int[4];
		Arrays.fill(cnt, 0);

		String generateGene = generateGene(5000);
		for (char c : generateGene.toCharArray()) {
			switch (c) {
			case 'A':
				cnt[0]++;
				break;
			case 'C':
				cnt[1]++;
				break;
			case 'G':
				cnt[2]++;
				break;
			case 'T':
				cnt[3]++;
				break;
			}
		}

		System.out.println(generateGene);
		System.out.println("Number of A's : " + cnt[0]);
		System.out.println("Number of C's : " + cnt[1]);
		System.out.println("Number of G's : " + cnt[2]);
		System.out.println("Number of T's : " + cnt[3]);
		System.out
				.println("All : " + (int) (cnt[0] + cnt[1] + cnt[2] + cnt[3]));
	}

	private static String generateGene(int n) {
		char[] genes = new char[] { 'A', 'C', 'G', 'T' };
		StringBuilder sb = new StringBuilder();

		IntStream.range(0, n)
				.forEach(
						c -> sb.append(genes[(int) (Math.random() * 100)
								% genes.length]));

		return sb.toString();
	}

	/**
	 * Sherlock and Anagrams
	 * 
	 * @param args
	 */
	public static void sherlockAndAnagrams(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		s.nextLine();

		for (int i = 0; i < tc; i++) {
			String candidate = s.nextLine();

			// insert all substring in array
			List<String> substrings = new ArrayList<>();
			Map<Integer, List<String>> sort = new HashMap<>();

			for (int substringLength = 1; substringLength <= candidate.length() - 1; substringLength++) { // substring
				substrings = new ArrayList<>();
				for (int offset = 0; candidate.length() >= substringLength
						+ offset; offset++) { // substring
					// offset
					char[] sortedSubstring = candidate.substring(offset,
							offset + substringLength).toCharArray();
					Arrays.sort(sortedSubstring);
					substrings.add(new String(sortedSubstring));

				}
				Collections.sort(substrings);
				sort.put(substringLength, substrings);

			}

			int count = 0;
			int consecutive = 0;

			for (int j = 1; j < candidate.length(); j++) {
				List<String> list = sort.get(j);
				for (int k = 0; k < list.size() - 1; k++) {
					if (list.get(k).equals(list.get(k + 1))) {
						count++;
						if (k > 0 && list.get(k).equals(list.get(k - 1))) {
							consecutive++;
						}

						if (consecutive > 0) {
							count++;
							consecutive = 0;
						}
					}
				}
			}
			System.out.println(count);
		}

		s.close();

	}

	/**
	 * Find all permutations of a string
	 * 
	 * @param args
	 */
	static Integer numberOfPermutations = 0;

	public static void findAllPermutations(String[] args) {

		String s = "abcd";

		substring("", s);

		System.out.println("Number of permutations was :: "
				+ numberOfPermutations);
	}

	private static void substring(String prefix, String rest) {

		int n = rest.length();
		if (n == 0) {
			System.out.println(prefix);
			numberOfPermutations++;
		} else {
			for (int i = 0; i < n; i++) {
				substring(prefix + rest.charAt(i),
						rest.substring(0, i) + rest.substring(i + 1, n));
			}
		}

	}
}

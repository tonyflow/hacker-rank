package test.hacker.rank;

import edu.princeton.cs.algs4.TrieST;

public class BoggleTrie {

	private static String[] DICTIONARY;

	static {
		DICTIONARY = new String[] { "GEEKS", "FOR", "QUIZ", "GO" };
	}

	private TrieST<Character> root;

	public BoggleTrie() {
		root = new TrieST<Character>();
		for (String word : DICTIONARY) {
			root.put(word, null);
		}
	}

	private static String searchWord(TrieST<Character> root, int i, int j, boolean[][] visited, String str) {

		if (root.isEmpty()) {
			return str;
		}

		return null;
	}
}

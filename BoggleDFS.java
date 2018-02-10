package test.hacker.rank;

import java.util.Arrays;

public class BoggleDFS {

	private static int M = 3;
	private static int N = 3;
	private static String[] DICTIONARY;

	static {
		DICTIONARY = new String[] { "GEEKS", "FOR", "QUIZ", "GO" };
	}

	public static boolean isWord(String word) {
		for (String s : DICTIONARY) {
			if (s.equals(word)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param boggle
	 * @param visited
	 * @param i
	 * @param j
	 * @param str
	 */
	private static void findWordsUtil(char[][] boggle, boolean[][] visited, int i, int j, String str) {

		System.out.println(str + ". i = " + i + " j = " + j);

		visited[i][j] = true;
		str = str + boggle[i][j];

		if (isWord(str)) {
			System.out.printf("Found word %s \n", str);
		}

		for (int row = i - 1; row <= i + 1 && row < M; row++) {
			for (int col = j - 1; col <= j + 1 && col < N; col++) {
				if (row >= 0 && col >= 0 && !visited[row][col]) {
					findWordsUtil(boggle, visited, row, col, str);
				}
			}
		}

		StringBuilder builder = new StringBuilder(str);
		builder.deleteCharAt(str.length() - 1);
		str = builder.toString();
		visited[i][j] = false;
		// System.out.println("=== END OF CALL STACK ===");
	}

	public static void findWords(char[][] boggle) {

		boolean[][] visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			Arrays.fill(visited[i], false);
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				findWordsUtil(boggle, visited, i, j, "");
			}
		}
	}

	public static void traverseAdjacentCells(int i, int j, int M, int N) {
		for (int row = i - 1; row <= i + 1 && row < M; row++) {
			for (int col = j - 1; col <= j + 1 && col < N; col++) {
				if (row >= 0 && col >= 0) {
					// do something
				}
			}
		}
	}

	public static void main(String[] args) {
		char[][] boggle = new char[][] {
				{ 'G', 'I', 'Z' },
				{ 'U', 'E', 'K' },
				{ 'Q', 'S', 'E' }
		};

		findWords(boggle);

	}
}

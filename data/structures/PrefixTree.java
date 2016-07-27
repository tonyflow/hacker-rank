package test.hacker.rank.data.structures;

import java.util.Arrays;

public class PrefixTree {

	static public TrieNode createTree() {

		return new TrieNode('\0');
	}

	static void insertWord(TrieNode root, String word) {

		int l = word.length();
		TrieNode curNode = root;
		char[] letters = word.toCharArray();

		for (int i = 0; i < l; i++) {

			if (curNode.links[letters[i] - 'a'] == null) {
				curNode.links[letters[i] - 'a'] = new TrieNode(letters[i]);
			}
			curNode = curNode.links[letters[i] - 'a'];
		}

		curNode.isWord = true;
	}

	static boolean find(TrieNode root, String word) {
		return true;
	}

	/**
	 * Preorder traversal
	 * 
	 * @param root
	 */
	static void printTree(TrieNode root) {

		if (root == null) {
			return;
		}

		for (int i = 0; i < root.links.length; i++) {
			if (root.links[i] != null) {
				System.out.print(root.letter);
				printTree(root.links[i]);
			}

		}

	}

	static void printTree(TrieNode root, int level, char[] branch) {
		if (root == null)
			return;

		System.out.println("Level " + level);
		for (int i = 0; i < root.links.length; i++) {
			branch[level] = root.letter;
			System.out.println(Arrays.toString(branch));
			printTree(root.links[i], level + 1, branch);
		}

		if (root.isWord) {
			for (int j = 1; j <= level; j++)
				System.out.print(branch[j]);
			System.out.println();
		}
	}

	public static void main(String[] args) {

		TrieNode root = createTree();

		insertWord(root, "nikosstrongioglou");

		insertWord(root, "nikospapadopoulos");
		insertWord(root, "nioena");

		printTree(root, 0, new char[60]);

		System.out.println("ending...");

	}

}

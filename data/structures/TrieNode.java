package test.hacker.rank.data.structures;

public class TrieNode {

	public char letter;
	public TrieNode[] links;
	public boolean isWord;

	public TrieNode(char letter) {
		this.letter = letter;
		this.links=new TrieNode[26];
	}

}

package test.hacker.rank;

public class Trees {
	
	class Node {
	    int data;
	    Node left;
	    Node right;
	}
	
	void preOrder(Node root) {
		if (root==null) {
			return;
		}
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

}

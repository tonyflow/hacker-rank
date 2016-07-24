package test.hacker.rank.data.structures;

public class BinaryTree {

	Node root;

	public BinaryTree() {

	}

	private Node remove(Node root, Integer key) {

		if (root == null) {
			return root; // null
		} else if (key > root.key) {
			root.right = remove(root.right, key);
		} else if (key < root.key) {
			root.left = remove(root.left, key);
		} else {// found node

			// node has no children - is a leaf
			if (root.left == null && root.right == null) {
				root = null;
			}

			// node has one child
			else if (root.left == null) {
				root = root.right;
			}

			else if (root.right == null) {
				root = root.left;
			}

			// node has two children
			else {
				Node min = findMinFromRightSubtree(root.right);
				root.key = min.key;
				root.right = remove(root, min.key);
			}

		}
		return root;
	}

	private Node findMinFromRightSubtree(Node node) {

		Integer min = node.key;
		while (node.left != null) {
			if (node.left.key < min) {
				min = node.left.key;
			}
			node = node.left;
		}

		return node;
	}

	private void addNode(Integer key, String name) {

		Node theNewNode = new Node(key, name);

		if (this.root == null) {
			this.root = theNewNode;
		} else {

			Node focusNode = root;

			Node parent = null;

			while (true) {

				parent = focusNode;

				if (key < focusNode.key) {

					focusNode = focusNode.left;

					if (focusNode == null) {
						parent.left = theNewNode;
						return;
					}

				} else {

					focusNode = focusNode.right;

					if (focusNode == null) {

						parent.right = theNewNode;
						return;
					}

				}
			}
		}

	}

	private void preorderTraversal(Node start) {

		if (start != null) {
			System.out.println(start.key);

			preorderTraversal(start.right);

			preorderTraversal(start.left);
		}
	}

	private void postorderTraversal(Node start) {

		if (start != null) {
			postorderTraversal(start.right);

			postorderTraversal(start.left);

			System.out.println(start.key);
		}
	}

	private void inorderTraversal(Node start) {

		if (start != null) {
			inorderTraversal(start.right);

			System.out.println(start.key);

			inorderTraversal(start.left);
		}
	}

	private String findKey(Integer key) {

		Node focusNode = this.root;

		if (root == null) {
			throw new RuntimeException("No tree was initialized");
		}

		while (focusNode.key != key) {

			if (focusNode.key < key) {
				focusNode = focusNode.right;
			} else {
				focusNode = focusNode.left;
			}

			if (focusNode == null) {
				return "No such key was found";
			}
		}

		return focusNode.name;
	}

	class Node {
		public Integer key;
		public String name;
		public Node right;
		public Node left;

		public Node(Integer key, String name) {
			this.key = key;
			this.name = name;
		}

	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		tree.addNode(12, "Nikos");
		tree.addNode(13, "Androniki");
		tree.addNode(14, "Panagiotis");
		tree.addNode(5, "Athina");
		tree.addNode(6, "Georgia");

		System.out
				.println("============== preorderTraversal ===================================");
		tree.preorderTraversal(tree.root);
		System.out
				.println("============== inorderTraversal ===================================");
		tree.inorderTraversal(tree.root);
		System.out
				.println("============== postorderTraversal ===================================");
		tree.postorderTraversal(tree.root);

		System.out.println("So I found what seems to be " + tree.findKey(14));

		tree.remove(tree.root, 12);
	}
}

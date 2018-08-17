package codility;

public class Tree {

	private Node root;

	class Node {
		Node left, right;
		int data;

		public Node() {
			left = null;
			right = null;
			data = 0;
		}

		public Node(int n) {
			left = null;
			right = null;
			data = n;
		}
	}

	public Node addRoot(int data) {
		if (root == null) {
			root = new Node(data);
		}
		return root;
	}

	public Node addLeft(Node parent, int data) {
		Node n = new Node(data);
		parent.left = n;
		return n;
	}

	public Node addRight(Node parent, int data) {
		Node n = new Node(data);
		parent.right = n;
		return n;
	}

	public boolean search(int val) {
		return search(root, val);
	}

	private boolean search(Node n, int value) {
		if (n.data == value)
			return true;
		if (n.left != null)
			if (search(n.left, value))
				return true;
		if (n.right != null)
			if (search(n.right, value))
				return true;
		return false;
	}

	public static void main(String[] args) {

		//Integer elements[] = { 2, 7, 5, 2, 6, null, 9, null, null, 5, 11, 4, null };

		Tree tree = new Tree();
		Node r = tree.addRoot(2);
		Node l1 = tree.addLeft(r, 7);
		Node r1 = tree.addRight(r, 5);

		Node l2 = tree.addLeft(l1, 2);
		Node r2 = tree.addRight(l1, 6);

		Node r3 = tree.addRight(r1, 9);

		Node l3 = tree.addLeft(r2, 5);
		Node r4 = tree.addRight(r2, 11);

		Node l4 = tree.addLeft(r3, 4);

		int value = 2;

		System.out.println(tree.search(value));
	}

}

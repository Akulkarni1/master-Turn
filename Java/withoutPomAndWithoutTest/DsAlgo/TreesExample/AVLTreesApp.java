class AVLTreesImpl {
	class AVLTreeNode {
		int data;
		int height;
		int size;
		AVLTreeNode left;
		AVLTreeNode right;
		AVLTreeNode parent;

		AVLTreeNode(int newVal) {
			data = newVal;
			left = null;
			right = null;
			parent = null;
			height = 1;
			size = 1;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public AVLTreeNode getLeft() {
			return left;
		}

		public void setLeft(AVLTreeNode left) {
			this.left = left;
		}

		public AVLTreeNode getRight() {
			return right;
		}

		public void setRight(AVLTreeNode right) {
			this.right = right;
		}

		public AVLTreeNode getParent() {
			return parent;
		}

		public void setParent(AVLTreeNode parent) {
			this.parent = parent;
		}

	}

	public AVLTreeNode rotateleft(AVLTreeNode root) {
		AVLTreeNode newroot = root.right;
		AVLTreeNode leftsubTree = newroot.left;

		newroot.left = root;
		root.right = leftsubTree;
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		newroot.height = Math.max(height(newroot.left), height(newroot.right)) + 1;

		newroot.size = size(newroot.left) + size(newroot.right) + 1;

		return newroot;
	}

	public AVLTreeNode rotateright(AVLTreeNode root) {
		AVLTreeNode newroot = root.left;
		AVLTreeNode rightsubTree = newroot.right;

		newroot.right = root;
		root.left = rightsubTree;
		root.height = Math.max(height(root.left), height(root.right) + 1);
		newroot.height = Math.max(height(newroot.left), height(newroot.right) + 1);
		newroot.size = size(newroot.left) + size(newroot.right) + 1;

		return newroot;
	}

	public AVLTreeNode insert(AVLTreeNode node, int key, int count[], int index) {
		if (node == null) {
			return new AVLTreeNode(key);
		}
		if (node.data > key) {
			node.left = insert(node.left, key, count, index);
		} else {
			node.right = insert(node.right, key, count, index);
			count[index] = count[index] + size(node.left) + 1;
		}
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		node.size = size(node.left) + size(node.right) + 1;

		int balance = height(node.left) - height(node.right) + 1;
		if (balance > 1 && node.data > key) {
			return rotateright(node);
		}
		if (balance < -1 && node.data > key) {
			return rotateleft(node);
		}
		if (balance > 1 && node.data < key) {
			node.left = rotateleft(node.left);
			return rotateright(node);
		}
		if (balance < -1 && node.data < key) {
			node.right = rotateright(node.right);
			return rotateleft(node);
		}
		return node;
	}

	public int size(AVLTreeNode node) {
		return node == null ? 0 : node.size;
	}

	public int height(AVLTreeNode node) {
		return node == null ? 0 : node.height;
	}

	public int[] countSmallerOnRight(final int[] in) {
		final int[] smaller = new int[in.length];

		AVLTreeNode root = null;
		for (int i = in.length - 1; i >= 0; i--) {
			root = insert(root, in[i], smaller, i);
		}

		return smaller;
	}
}

public class AVLTreesApp {

}

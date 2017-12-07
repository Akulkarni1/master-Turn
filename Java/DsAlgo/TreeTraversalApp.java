import java.util.LinkedList;
import java.util.Queue;

class TreeTraversalImpl {
	class TreeNode {
		String data;
		TreeNode left, right;

		TreeNode() {
			data = "";
			left = null;
			right = null;
		}

		TreeNode(String newVal) {
			data = newVal;
			left = null;
			right = null;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}
	}

	TreeNode root;

	TreeTraversalImpl() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void addNode(String newVal) {
		TreeNode n = new TreeNode(newVal);
		if (root == null) {
			root = n;
		} else {
			while (root != null) {
				if (root.getData().compareTo(newVal) < 0) {
					root = root.getRight();
				} else {
					root = root.getLeft();
				}
			}
			if (root == null) {
				root = n;
			}

		}

	}

	public void postOrderTraversal() {
		doPostOrder(this.root);
	}

	public void doPostOrder(TreeNode root) {
		if (root == null)
			return;
		doPostOrder(root.getLeft());
		doPostOrder(root.getRight());
		System.out.println(root.getData());
	}

	public void preOrderTraversal() {
		doPreOrder(this.root);
	}

	public void doPreOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.getData());
		doPreOrder(root.getLeft());
		doPreOrder(root.getRight());
	}

	public void inOrderTraversal() {
		doInOrder(this.root);
	}

	public void doInOrder(TreeNode root) {
		if (root == null)
			return;
		doInOrder(root.getLeft());
		System.out.println(root.getData());
		doInOrder(root.getRight());
	}

	public void levelOrderTraversal() {
		Queue<TreeNode> discoveredNodeQueue = new LinkedList<TreeNode>();
		if (root == null) {
			System.out.println("The tree is empty");
			return;
		}
		discoveredNodeQueue.add(this.root);
		while (!discoveredNodeQueue.isEmpty()) {
			TreeNode tmpNode = discoveredNodeQueue.remove();
			if (tmpNode.getLeft() != null) {
				discoveredNodeQueue.add(tmpNode.getLeft());
			}
			if (tmpNode.getRight() != null) {
				discoveredNodeQueue.add(tmpNode.getRight());
			}
		}

	}

	public int findHeight() {
		return getHeight(root);
	}

	public int getHeight(TreeNode node) {
		if (node == null) {
			return -1;
		}
		return Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
	}

	public String findMinValue() {
		return getMinValue(root);
	}

	public String getMinValue(TreeNode node) {
		if (node.getLeft() != null) {
			return getMinValue(node.getLeft());
		}
		return node.getData();
	}

	public String findMaxValue() {
		return getMaxValue(root);
	}

	public String getMaxValue(TreeNode node) {
		if (node.getRight() != null) {
			return getMaxValue(node.getRight());
		}
		return node.getData();
	}

}

public class TreeTraversalApp {

}

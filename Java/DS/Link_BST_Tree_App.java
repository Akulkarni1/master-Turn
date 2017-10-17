/*
 * @Author Amit .K
 */
import java.util.*;

public class Link_BST_Tree_App<T extends Comparable<T>> implements Iterable<T> {
	public static void main(String[] args) {
		String[] a = { "Amit", "Hello", "World" };
		Link_BST_Tree_App<String> bst = new Link_BST_Tree_App<String>();
		for (String n : a)
			bst.insert(n);

		bst.preOrderTraversal();
		System.out.println();

		bst = new Link_BST_Tree_App<String>(new Comp1());
		for (String n : a)
			bst.insert(n);

		bst.preOrderTraversal();
		System.out.println();
		bst.inOrderTraversal();
		System.out.println();

		for (String n : bst)
			System.out.print(n);
		System.out.println();

		System.out.println(bst);

		bst.restore(new String[] { "Girish", "Ankit A", "Ankit S" }, new String[] { "Rob S", "Ankit A" });
		bst.preOrderTraversal();
		System.out.println();
		bst.inOrderTraversal();
		System.out.println();

		// testing diameter
		System.out.println("diameter = " + bst.diameter());
		// testing width
		System.out.println("width = " + bst.width());
	}

	private Node<T> root;
	private Comparator<T> comparator;

	public Link_BST_Tree_App() {
		root = null;
		comparator = null;
	}

	public Link_BST_Tree_App(Comparator<T> comp) {
		root = null;
		comparator = comp;
	}

	private int compare(T x, T y) {
		if (comparator == null)
			return x.compareTo(y);
		else
			return comparator.compare(x, y);
	}

	public void insert(T data) {
		root = insert(root, data);
	}

	private Node<T> insert(Node<T> p, T toInsert) {
		if (p == null)
			return new Node<T>(toInsert);

		if (compare(toInsert, p.data) == 0)
			return p;

		if (compare(toInsert, p.data) < 0)
			p.left = insert(p.left, toInsert);
		else
			p.right = insert(p.right, toInsert);

		return p;
	}

	public boolean search(T toSearch) {
		return search(root, toSearch);
	}

	private boolean search(Node<T> p, T toSearch) {
		if (p == null)
			return false;
		else if (compare(toSearch, p.data) == 0)
			return true;
		else if (compare(toSearch, p.data) < 0)
			return search(p.left, toSearch);
		else
			return search(p.right, toSearch);
	}


	public void delete(T toDelete) {
		root = delete(root, toDelete);
	}

	private Node<T> delete(Node<T> p, T toDelete) {
		if (p == null)
			throw new RuntimeException("cannot delete.");
		else if (compare(toDelete, p.data) < 0)
			p.left = delete(p.left, toDelete);
		else if (compare(toDelete, p.data) > 0)
			p.right = delete(p.right, toDelete);
		else {
			if (p.left == null)
				return p.right;
			else if (p.right == null)
				return p.left;
			else {
				// get data from the rightmost node in the left subtree
				p.data = retrieveData(p.left);
				// delete the rightmost node in the left subtree
				p.left = delete(p.left, p.data);
			}
		}
		return p;
	}

	private T retrieveData(Node<T> p) {
		while (p.right != null)
			p = p.right;

		return p.data;
	}


	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (T data : this)
			sb.append(data.toString());

		return sb.toString();
	}


	public void preOrderTraversal() {
		preOrderHelper(root);
	}

	private void preOrderHelper(Node r) {
		if (r != null) {
			System.out.print(r + " ");
			preOrderHelper(r.left);
			preOrderHelper(r.right);
		}
	}

	public void inOrderTraversal() {
		inOrderHelper(root);
	}

	private void inOrderHelper(Node r) {
		if (r != null) {
			inOrderHelper(r.left);
			System.out.print(r + " ");
			inOrderHelper(r.right);
		}
	}

	public Link_BST_Tree_App<T> clone() {
		Link_BST_Tree_App<T> twin = null;

		if (comparator == null)
			twin = new Link_BST_Tree_App<T>();
		else
			twin = new Link_BST_Tree_App<T>(comparator);

		twin.root = cloneHelper(root);
		return twin;
	}

	private Node<T> cloneHelper(Node<T> p) {
		if (p == null)
			return null;
		else
			return new Node<T>(p.data, cloneHelper(p.left), cloneHelper(p.right));
	}

	public int height() {
		return height(root);
	}

	private int height(Node<T> p) {
		if (p == null)
			return -1;
		else
			return 1 + Math.max(height(p.left), height(p.right));
	}

	public int countLeaves() {
		return countLeaves(root);
	}

	private int countLeaves(Node<T> p) {
		if (p == null)
			return 0;
		else if (p.left == null && p.right == null)
			return 1;
		else
			return countLeaves(p.left) + countLeaves(p.right);
	}

	public void restore(T[] pre, T[] in) {
		root = restore(pre, 0, pre.length, in, 0, in.length);
	}

	private Node<T> restore(T[] pre, int preL, int preR, T[] in, int inL, int inR) {
		if (preL <= preR) {
			int count = 0;
			// find the root in the inorder array
			while (pre[preL] != in[inL + count])
				count++;

			Node<T> tmp = new Node<T>(pre[preL]);
			tmp.left = restore(pre, preL + 1, preL + count, in, inL, inL + count - 1);
			tmp.right = restore(pre, preL + count + 1, preR, in, inL + count + 1, inR);
			return tmp;
		} else
			return null;
	}

	public int width() {
		int max = 0;
		for (int k = 0; k <= height(); k++) {
			int tmp = width(root, k);
			if (tmp > max)
				max = tmp;
		}
		return max;
	}

	public int width(Node<T> p, int depth) {
		if (p == null)
			return 0;
		else if (depth == 0)
			return 1;
		else
			return width(p.left, depth - 1) + width(p.right, depth - 1);
	}

	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node<T> p) {
		if (p == null)
			return 0;

		int len1 = height(p.left) + height(p.right) + 3;
		int len2 = Math.max(diameter(p.left), diameter(p.right));

		return Math.max(len1, len2);
	}

	public Iterator<T> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<T> {
		Stack<Node<T>> stk = new Stack<Node<T>>();

		public MyIterator() {
			if (root != null)
				stk.push(root);
		}

		public boolean hasNext() {
			return !stk.isEmpty();
		}

		public T next() {
			Node<T> cur = stk.peek();
			if (cur.left != null) {
				stk.push(cur.left);
			} else {
				Node<T> tmp = stk.pop();
				while (tmp.right == null) {
					if (stk.isEmpty())
						return cur.data;
					tmp = stk.pop();
				}
				stk.push(tmp.right);
			}

			return cur.data;
		}
		public void remove() {

		}
	}

	private class Node<T> {
		private T data;
		private Node<T> left, right;

		public Node(T data, Node<T> l, Node<T> r) {
			left = l;
			right = r;
			this.data = data;
		}

		public Node(T data) {
			this(data, null, null);
		}

		public String toString() {
			return data.toString();
		}
	}
}

class Comp1 implements Comparator<String> {
	public int compare(String x, String y) {
		return x.compareTo(y);
	}
}
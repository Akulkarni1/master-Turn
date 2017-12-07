import java.util.LinkedList;
import java.util.Set;

import javax.swing.tree.TreeNode;

public class MinPathAppTree {
	public int getHeight(TreeNode p) {
		int height = 0;
		while (p != null) {
			height++;
			p = p.parent;
		}
	}

	public Set<Integer> minPath(TreeNode p, TreeNode q) {
		int h1 = getHeight(p);
		int h2 = getHeight(q);
		LinkedList<Integer> pathDeeper = new LinkedList<Integer>();
		LinkedList<Integer> pathShallOver = new LinkedList<Integer>();
		if (h1 > h2) {
			swap(h1, h2);
			swap(p, q);
		}
		// invariant: h1 <= h2.
		int dh = h2 - h1;
		for (int h = 0; h < dh; h++) {
			pathDeeper.addFirst(q.key);
			q = q.getParent();
		}
		while (p != null && q != null) {
			pathShallOver.addLast(p.key);
			pathDeeper.addFirst(q.key);
			if (p == q) {
				Set<Integer> path = new HashSet<Integer>();
				path.addAll(getShallOver);
				path.addAll(pathDeeper);
				return path;
			}
			p = p.parent;
			q = q.parent;
		}
		return null;// if not in thw SAME TREE.
	}
}

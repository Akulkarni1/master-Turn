package AllTime;

import java.util.*;

public class PostOrderTravelWithoutRec {
    /*
Implement a postOrder traversal without recursion

*/
//postOrder traversal2.

    public static List<Integer> postOrderTraversal2(BinaryTreeNode<Integer> tree) {
        if (tree == null) {
            return Collections.emptyList();
        }
        Deque<BinaryTreeNode<Integer>> path = new LinkedList<>();
        BinaryTreeNode<Integer> prev = null;
        path.addFirst(tree);
        List<Integer> postOrderSequence = new ArrayList<>();
        while (!path.isEmpty()) {
            BinaryTreeNode<Integer> curr = path.peekFirst();
            if (prev == null || prev.left == curr || prev.right == null) {
                if (curr.left != null) {
                    path.addFirst(curr.left);
                } else if (curr.right != null) {
                    path.addFirst(curr.right);
                } else {
                    postOrderSequence.add(curr.data);
                    path.removeFirst();
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    path.addFirst(curr.right);
                } else {
                    postOrderSequence.add(curr.data);
                    path.removeFirst();
                }
            } else {
                postOrderSequence.add(curr.data);
                path.removeFirst();
            }
            prev = curr;
        }
        return postOrderSequence;
    }

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

}
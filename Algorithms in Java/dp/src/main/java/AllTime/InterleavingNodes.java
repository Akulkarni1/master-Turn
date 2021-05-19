package AllTime;

public class InterleavingNodes {
    /*
Let L be a singly linked list. Assume its nodes are numbered starting at 0. Define the
zip of L to be the list consisting of the interleaving of the nodes numbered 0, 1, 2, . . .
with the nodes numbered n - 1, n - 2, n - 3, .. where n is the number of nodes in the
list.

A brute-force approach is to iteratively identify the head and tail, remove
them from the original list, and append the pair to the result.
*/

    public static ListNode<Integer> zipLinkedList(ListNode<Integer> list) {
        if (list == null || list.next == null) {
            return list;
        }
        ListNode<Integer> slow = list, fast = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode<Integer> firstHalfHead = list, secoundHalfHead = slow.next;
        slow.next = null;
        secoundHalfHead = reverseLinkedList(secoundHalfHead);
        ListNode<Integer> fistHalfIterator = firstHalfHead;
        ListNode<Integer> secoundHalfInterator = secoundHalfHead;
        while (secoundHalfInterator != null) {
            ListNode<Integer> temp = secoundHalfInterator, next;
            secoundHalfInterator.next = fistHalfIterator.next;
            fistHalfIterator.next = secoundHalfInterator;
            fistHalfIterator = fistHalfIterator.next.next;
            secoundHalfInterator = temp;
        }
        return list;
    }

    private static ListNode<Integer> reverseLinkedList(ListNode<Integer> node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}

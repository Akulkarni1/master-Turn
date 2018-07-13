/*
 * Trying to solve all the problems related to linkedList.
 */
class LinkNode {
	int data;
	LinkNode next;

	LinkNode() {
		data = 0;
		next = null;
	}

	LinkNode(int newVal) {
		data = newVal;
		next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public LinkNode getNext() {
		return next;
	}

	public void setNext(LinkNode next) {
		this.next = next;
	}

}

class LinkedListImpl {
	LinkNode head;
	LinkNode tail;

	int count;

	LinkedListImpl() {
		head = null;
		tail = null;
		count = 0;
	}

	public void addFirst(int newVal) {
		LinkNode n = new LinkNode(newVal);
		if (head == null) {
			head = n;
			tail = n;
			count++;
		} else {
			n.next = head;
			head = n;
			count++;
		}
	}

	public void addLast(int newVal) {
		LinkNode n = new LinkNode(newVal);
		if (head == null) {
			head = n;
			tail = n;
			count = 1;
		} else {
			tail.next = n;
			tail = n;
			return;

		}
	}

	public void print() {
		LinkNode t = head;
		count = 0;
		while (t != null) {
			System.out.println(t.data);
			t = t.next;
			count++;
		}
		System.out.println("Number of elements " + count);
	}

	public void delete(int newVal) {
		LinkNode t = head;
		LinkNode temp = t.next;
		while (temp != null) {

			if (temp.data == newVal) {
				LinkNode l = temp.next;
				t.next = l;
				temp.next = null;
			}
			temp = t.next;
			t = t.next;
		}
	}

	public void reverse() {
		LinkNode prev = null;
		LinkNode current = head;
		LinkNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return;
	}

	// swap alternate node;
	public LinkNode swapAlternateNode() {
		if (head == null || head.next == null) {
			return head;
		}
		LinkNode newhead = null;
		LinkNode prev = head;
		LinkNode curr = prev.next;
		LinkNode temp = null;
		LinkNode last = null;
		while (curr != null && curr.next != null) {
			temp = curr.next;
			curr.next = curr.next.next;
			temp.next = curr;
			if (prev != null) {
				prev.next = temp;

			}
			if (newhead == null) {
				newhead = temp;
			}
			prev = curr;
			curr = curr.next;
		}
		head = newhead;
		return newhead;
	}

	/*
	 * Given a single linked list. Delete all the elements that has lager value
	 * element on right of it.
	 * 
	 */
	public LinkNode deleteNodewithHighOnRight() {
		LinkNode temp = null;
		LinkNode newHead = null;
		LinkNode prev = head;
		while (head != null && head.next != null) {
			temp = head.next;
			if (temp.data > head.data) {
				prev.next = temp;
			} else {
				if (newHead == null) {
					newHead = head;
				}
				prev = head;
			}
			head = head.next;
		}
		return newHead;
	}
}

public class LinkedListApp {
	public static void main(String[] args) {
		LinkedListImpl t = new LinkedListImpl();

		t.addFirst(2);
		t.addFirst(3);
		;// (5);
		t.addFirst(6);
		t.addFirst(4);
		t.addLast(7);
		t.print();
		// t.addAfter(8,6);
		// t.delete(6);
		t.reverse();
		t.print();
	}
}

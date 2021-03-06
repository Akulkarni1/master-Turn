/*@Author Amit.
 * 
 */
//Below is the class for singly linked List.
class SL_LinkedListNode<T> {
	T data;
	SL_LinkedListNode<T> next;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SL_LinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(SL_LinkedListNode<T> next) {
		this.next = next;
	}

	public SL_LinkedListNode(T value) {
		data = value;
		next = null;

	}
}

class LinkedList_Impl<T> {
	SL_LinkedListNode<T> first = null;

	/*
	 * Insert at the start of the list.
	 * 
	 */
	public void insert_start(SL_LinkedListNode<T> node) {

		node.next = first;
		first = node;
	}

	public void insert_end(SL_LinkedListNode<T> node) {
		SL_LinkedListNode<T> temp = first;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.next = node;
		temp = node;
		return;
	}

	public void remove() {
		if (first.getNext() != null) {
			first = first.getNext();
		} else
			first = null;

	}

	public void remove_end() {
		SL_LinkedListNode<T> temp = first;
		SL_LinkedListNode<T> prev = first;
		if (temp.getNext() != null) {
			while (temp.getNext() != null) {
				prev = temp;
				temp = temp.getNext();

			}

			prev.next = null;
			return;
		} else
			first = null;
		return;
	}

	public void printList(SL_LinkedListNode<T> node) {
		SL_LinkedListNode temp = first;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}

	}

	public void print() {
		printList(first);
	}
	
	public void reverseList() {
		SL_LinkedListNode prev =null;
		SL_LinkedListNode curr = first;
		SL_LinkedListNode next = null;
		while(curr!= null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		first = prev;
		print();
	}
	
}

/*
 * Below is the class for the doubly linkedList.
 */
class DL_LinkedListNode<T> {
	T data;
	DL_LinkedListNode prev, next;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DL_LinkedListNode getPrev() {
		return prev;
	}

	public void setPrev(DL_LinkedListNode prev) {
		this.prev = prev;
	}

	public DL_LinkedListNode getNext() {
		return next;
	}

	public void setNext(DL_LinkedListNode next) {
		this.next = next;
	}

	DL_LinkedListNode(T newVal) {
		data = newVal;
		prev = null;
		next = null;

	}

}

class DL_LinkedList_Impl<T> {
	DL_LinkedListNode<T> head = null;

	public void insert_start(DL_LinkedListNode<T> newVal) {
		if (head == null) {
			head = newVal;
		} else {
			newVal.next = head;
			head.prev = newVal;
			head = newVal;
		}
	}

	public void printlist(DL_LinkedListNode<T> newVal) {
		DL_LinkedListNode<T> temp = newVal;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

	public void remove() {
		if (head.getNext() != null) {
			head = head.getNext();
		} else
			head = null;

	}

	public void remove_end() {

		DL_LinkedListNode<T> temp = head;
		DL_LinkedListNode<T> prev = head;
		if (temp.getNext() != null) {
			while (temp.getNext() != null) {
				prev = temp;
				temp = temp.getNext();

			}

			prev.next = null;
			return;
		} else
			head = null;
		return;
	}

	public void print() {
		printlist(head);
	}

	public void insert_end(DL_LinkedListNode<T> newVal) {
		DL_LinkedListNode temp = head;
		if (temp == null) {
			temp = newVal;
			return;
		} else {
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.next = newVal;
			newVal.prev = temp;
			temp = newVal;
			return;
		}
	}
	public void reverseList() {
		DL_LinkedListNode prev =null;
		DL_LinkedListNode curr = head;
		DL_LinkedListNode next = null;
		while(curr!= null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		head = prev;
		print();
	}

}

public class LList_App {
	public static void main(String[] args) {
		DL_LinkedList_Impl<String> list = new DL_LinkedList_Impl<String>();
		list.insert_start(new DL_LinkedListNode<String>("Generic List"));// (new DL_LinkedListNode<String>("Generic
																			// list"));
		list.insert_start(new DL_LinkedListNode<String>("Hello"));
		list.insert_start(new DL_LinkedListNode<String>("World"));
		list.insert_end(new DL_LinkedListNode<String>("End of the list"));
		list.print();
		//list.remove_end();
		//System.out.println("After removing the head..");
		//list.print();
		list.reverseList();
	}

}

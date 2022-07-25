
public class LinkedList {
	public Node first;
	
	public LinkedList() {
		first = null;
	}
	public boolean isEmpty() {
		return(first == null);
	}
	public void InsertAtFront(char x) {
		Node newnode;
		newnode = new Node();
		newnode.data = x;
		newnode.next = first;
		first = newnode;
	}
	public char DeleteFirst() {
		char ret;
		if(first == null) return ' ';
		ret = first.data;
		first = first.next;
		return ret;
	}
	public char firstdata() {
		if(first == null) return ' ';
		return first.data;
	}
}

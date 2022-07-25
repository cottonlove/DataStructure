
public class Stack {
	private final LinkedList llist;
	public Stack() {
		llist = new LinkedList();
	}
	public void push(char x) {
		llist.InsertAtFront(x);
	}
	public char pop() {
		return llist.DeleteFirst();
	}
	public boolean isEmpty() {
		return llist.isEmpty();
	}
	public char peek() {
		return llist.firstdata();
	}
}

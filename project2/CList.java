public class CList {
	public CNode first;
	public CList() {
		first = null;
	}
	public void append(int x) {
		CNode newnode = new CNode();
		newnode.data = x;
		if(first==null) {
			first = newnode;
			newnode.next = newnode;
		}
		else {
			CNode tempNode = first;
			while(tempNode.next != first) {
				tempNode = tempNode.next;
			}
			tempNode.next = newnode;
			newnode.next = tempNode.next;
		}
		
	
	}
	public CIter getIter() {
		return new CIter(this,first);
	}
	
}
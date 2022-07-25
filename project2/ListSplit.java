public class ListSplit {
	public ListSplit() {
		outn = null;
		outp = null;
	}
	public Node outn, outp;
	public void split(Node first) {
		while(first !=null){
			int x;
			x = first.data;
			if(x>0) {
				if(outp==null) {
					outp = first;
					outp.next = null;
				}
				else {
					Node tempNode = outp;
					while(tempNode.next != null) {
						tempNode = tempNode.next;
					}
					tempNode.next = first;
					tempNode = tempNode.next;
					tempNode.next = null;
				}
			}
			else if(x<0) {
				if(outn==null) {
					outn = first;
					outn.next = null;
				}
				else {
					Node tempNode = outn;
					while(tempNode.next != null) {
						tempNode = tempNode.next;
					}
					tempNode.next = first;
					tempNode = tempNode.next;
					tempNode.next = null;
				}
			}
			first = first.next;
		}
	}
	
}
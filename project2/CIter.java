public class CIter {
	public CNode cur, prev;
	public CList clist;
	public CIter(CList caller, CNode pfirst) {
		clist = caller;
		cur = pfirst;
		prev.next = cur;	
	}
	public boolean isValid() {
		if(cur == null) return false;
		else return true;
	}
	public int getValue() {
		if(cur==null)return -1;
		else return cur.data;
	}
	public boolean setValue(int x) {
		if(cur==null) return false;
		else {
			cur.data = x;
			return true;
		}
	}
	public int delete() {
		int ret;
		if(cur == null) ret = -1;
		else {
			ret = cur.data;
			if(cur == clist.first) { 
				if(cur.next == cur) { //삭제후 empty
					clist.first = null;
					cur = null;
				}//첫 노드 삭제+nonempty
				clist.first = cur.next;
				cur = cur.next;
				prev.next = cur;
			}
			cur = cur.next;
			prev.next = cur;
		}
		return ret;
	}
	public boolean insertAfter(int x) {
		if(cur == null) return false;
		else {
			CNode newnode = new CNode();
			newnode.data = x;
			newnode.next = cur.next;
			cur.next = newnode;
			return true;
		}
	}
	public void next() {
		if(cur == null) return;
		else {
			prev = cur;
			cur = cur.next;
		}
	}
}
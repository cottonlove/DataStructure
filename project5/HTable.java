
class HTable {
	public Node[] table;

	// define this method
	public HTable() {
		this.table = new Node[997]; //array size must be 997
		for(int i=0; i<997; i++) {
			table[i] = null;//constructs an empty hash table. if there are no items in the hash table with hash value i, table[i] is null.
		}
	}

	// define this method
	public boolean insert(String k, int p) {
		int hashvalue = hash(k);
		
		if(table[hashvalue]==null){
			Node newone = new Node(); //k does not already exist in the table, then insert and return true.
			newone.key = k;
			newone.payload = p;
			table[hashvalue] = newone;
			newone.next = null;
			return true;}
		
		else {
				Node cur;
				cur = table[hashvalue];
				while(cur.next!=null&&cur.key!=k) {//key가 k가 아니면 한칸씩 이동
					cur = cur.next;
				}
				if(cur.key == k) {
					return false;
				}
				else {
					Node newone = new Node(); //k does not already exist in the table, then insert and return true.
					newone.key = k;
					newone.payload = p;
					cur.next = newone;
					newone.next = null;
					return true;
				}
		}
	}

	// define this method
	public boolean delete(String k) {
		int hashvalue = hash(k);
		if(table[hashvalue]==null) {
			return false;
		}
		else {
			Node cur;
			cur = table[hashvalue];
			Node prevnode;
			prevnode = null;//point
			while(cur.next !=null &&cur.key !=k) {
				prevnode = cur;
				cur = cur.next;
			}
				if(cur.key == k) {
					if(prevnode == null) {//처음 node delete인 경우
						table[hashvalue] = cur.next;
					}
					else {
						prevnode.next = cur.next;
					}
					return true;
				}
				else {
					return false;
				}
				
			}
			
	}

	// define this method
	public int query(String k) {
		int hashvalue = hash(k);
		if(table[hashvalue]==null) {
			return 0;
		}
		else {
			Node cur;
			cur = table[hashvalue];
			while(cur!=null && cur.key!= k) {
				cur = cur.next;
			}
			if(cur == null) {
				return 0;
			}
			else {
				return cur.payload;
			}
		}
		
	}

	// define this method
	public boolean modify(String k, int p) {
		int hashvalue = hash(k);
		if(table[hashvalue]==null) {
			return false;
		}
		else {
			Node cur;
			cur = table[hashvalue];
			while(cur!=null && cur.key!=k){
				cur = cur.next;}
				if(cur == null) {
					return false;
				}
				else {
					cur.payload = p;
					return true;
				}
			}
	}
	
	// do NOT modify this method
	public static int hash(String k) {
		if (k == null)
			return 0;

		int ret = k.hashCode();
		if (ret < 0)
			ret = -ret;
		ret = ret % 997;
		return ret;
	}
}

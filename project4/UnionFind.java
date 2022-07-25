public class UnionFind {
	public int parent[];
	public int card[];
	public UnionFind(int n) { //initialize
		parent= new int[n];
		card = new int[n];
		for(int i=0; i<n; i++) {
			parent[i] = -1;
			card[i] = 1;
		}
	}
	public int getcard(int x) {
		if(parent[x]==-1) {
			return card[x];
		}
		else {
			return card[Find(parent[x])];
		}
	}
	public int Find(int x) { //return name of subset that contains element x.
		if(parent[x]==-1) {
			return x;
		}
		else {
			return Find(parent[x]);
		}
	}
	public void Union(int i, int j) { //i, j mean name of set
		if(card[i]>=card[j]) { // weighted union: make the smaller-cardinality tree a subtree
			parent[j] = i;
			card[i] = card[i] + card[j];
		}
		else {
			parent[i] = j;
			card[j] = card[j] + card[i];
		}
	}
	
}

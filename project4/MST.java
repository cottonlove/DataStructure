class MST { //public �Ⱥٿ��� �ǳ�...?

	// define this method
    public static boolean find(int n, int m, int[] x, int[] y, int[] c, int[] ans) { 
    	//n: #of vertices m: # of edges x[i], y[i]: numeric IDs of two endpoints of Edge i 
    	//c[i]: cost of Edge i ans[] store IDs of Edge(like i).
    	int jeno =0;
    	
    	UnionFind uf = new UnionFind(n);
    	Edge alled[] = new Edge[m];
    	for(int i=0; i<m; i++) {//��� edge�� ���� ���� ����
    		alled[i] = new Edge(x[i], y[i], c[i],i);
    	}
    	Edge salled[] = new Edge[m+2];
    	for(int i=0; i<m; i++) {
    		salled[i+1] = alled[i];//�ֳĸ� �� heap���� 0��° ģ���� ������ϱ�
    	}
    	Heap.sort(salled, m); //salled�� descending order�� ����/ ������ �ݴ���. heap���� 0��° �Ƚ���. salled[1]~salled[m]����
    	for(int i=0; i<m; i++) {
    		alled[i]=salled[m-i];//descending�� �ٽ� ascending���� �ٲ�
    		/*System.out.println("alled["+i+"].ID="+alled[i].ID);*////////////////////
    	}
    	for(int k=0; k<m; k++) {
    			if(uf.Find(x[alled[k].ID])==uf.Find(y[alled[k].ID])) {//cyclic�Ǹ� �ȵ�~~
        			
        		}
        		else {
        			uf.Union(uf.Find(x[alled[k].ID]), uf.Find(y[alled[k].ID])); //cyclic �ƴϸ� �߰����ֱ�
        			ans[jeno] = alled[k].ID; //ans�� �߰��ϱ�
        			/*System.out.println("ans["+jeno+"]=alled["+k+"].ID="+alled[k].ID);*/////////////
        			jeno++;
        			if(jeno==n-1 && uf.card[uf.Find(x[0])]==n) { //disconnected ��츦 �߰������!
        				return true;
        			}
        		}
        }

		return false;//�� edge������ n-1�� �ȵǸ� mst���� ����.
    }
    
}


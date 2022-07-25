class MST { //public 안붙여도 되나...?

	// define this method
    public static boolean find(int n, int m, int[] x, int[] y, int[] c, int[] ans) { 
    	//n: #of vertices m: # of edges x[i], y[i]: numeric IDs of two endpoints of Edge i 
    	//c[i]: cost of Edge i ans[] store IDs of Edge(like i).
    	int jeno =0;
    	
    	UnionFind uf = new UnionFind(n);
    	Edge alled[] = new Edge[m];
    	for(int i=0; i<m; i++) {//모든 edge에 대한 정보 저장
    		alled[i] = new Edge(x[i], y[i], c[i],i);
    	}
    	Edge salled[] = new Edge[m+2];
    	for(int i=0; i<m; i++) {
    		salled[i+1] = alled[i];//왜냐면 내 heap에선 0번째 친구는 쓰레기니까
    	}
    	Heap.sort(salled, m); //salled를 descending order로 정렬/ 문제와 반대임. heap에서 0번째 안썼음. salled[1]~salled[m]까지
    	for(int i=0; i<m; i++) {
    		alled[i]=salled[m-i];//descending을 다시 ascending으로 바꿈
    		/*System.out.println("alled["+i+"].ID="+alled[i].ID);*////////////////////
    	}
    	for(int k=0; k<m; k++) {
    			if(uf.Find(x[alled[k].ID])==uf.Find(y[alled[k].ID])) {//cyclic되면 안돼~~
        			
        		}
        		else {
        			uf.Union(uf.Find(x[alled[k].ID]), uf.Find(y[alled[k].ID])); //cyclic 아니면 추가해주기
        			ans[jeno] = alled[k].ID; //ans에 추가하기
        			/*System.out.println("ans["+jeno+"]=alled["+k+"].ID="+alled[k].ID);*/////////////
        			jeno++;
        			if(jeno==n-1 && uf.card[uf.Find(x[0])]==n) { //disconnected 경우를 추가해줘야!
        				return true;
        			}
        		}
        }

		return false;//들어간 edge개수가 n-1이 안되면 mst존재 안함.
    }
    
}


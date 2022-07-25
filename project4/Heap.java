public class Heap{
	public Edge[] d; //array
	public int num; //heap의 node 갯수
	public int capacity; //array의 size
	
	public void Swap(int indexx, int indexy) { //array의 값들 swap하는 함수
		Edge temp = d[indexx];
		d[indexx]= d[indexy];
		d[indexy] = temp;
	}
	public void heapify(int root) { //heapify function
		while(2*root<=num) {
			int jeno = 2*root;
			if(jeno<num&&d[jeno].cost>d[jeno+1].cost) jeno++; //right child와 left child의 크기 비교->작은 놈 선택
			if(d[root].cost<=d[jeno].cost) break; //부모가 더 작다면 break
			Swap(root, jeno); //자식이 더 작으면 swap
			root=jeno;} //계속 반복
		}
		
	public Heap(int size) { //size는 heap이 동시에 갖는 최대 node 갯수
		this.capacity = size+1; //array d의 0번째는 사용 안하니까
		d = new Edge[size+1]; 
		d[0] = new Edge(0,0,0,-1); //쓰레기 값 
		this.num = 0; //initializes an empty heap that can store up to size integers
	}
	
	public boolean isEmpty() {
		if(num==0) {
			return true;
		}
		else return false;
	}
	
	public void insert(Edge x) {
		num++;
		d[num] = x;
		int i= num;
		while(d[i].cost<d[i/2].cost&&i!=1) { //To satisfy minimum heap's property.
			Swap(i, i/2);
			i = i/2;
		}
	}
	public int queryMin() { //최소는 root다
		if(num==0) {
			return Integer.MAX_VALUE;
		}
		else return d[1].cost;
	}
	public int deleteMin() {
		if(num==0) {
			return Integer.MAX_VALUE;
		}
		else {
			Swap(1, num); //root랑 마지막 놈 바꿈
			int yj = d[num].cost;
			num = num-1;//delete last node and decrease num
			heapify(1);
			return yj;
		}
	}
	public static void sort(Edge[]a, int n) {// static인거 notice하기 //descending order로 sort.
		for(int i=n/2; i>=1; i--) {
			minheapify2(a,n,i); //일단 minimum heap으로 만들기
		}
		for(int i=n; i>0; i--) {
			deleteMin2(a, i); //작은 놈부터 지우는 과정 반복
		}
	}
	public static void maSwap(Edge[]a, int indexx, int indexy) { //sort가 static이니까 static swap함수만들기
		Edge temp = a[indexx];
		a[indexx]= a[indexy];
		a[indexy] = temp;
	}
	public static void minheapify2(Edge[]a,int n, int root) { //sort에 쓸 static heapify함수 만들기
		while(2*root<=n) {
			int jeno = 2*root;
			if(jeno<n&&a[jeno].cost>a[jeno+1].cost) jeno++;
			if(a[root].cost<=a[jeno].cost) break;
			maSwap(a,root, jeno);
			root=jeno;
		}
	}
	public static int deleteMin2(Edge[]a,int n) {//sort에 쓸 static delete함수 만들기
		if(n==0) {
			return Integer.MAX_VALUE;
		}
		else {
			maSwap(a, 1, n);
			int yj = a[n].cost;
			n = n-1;//delete last node and decrease num
			minheapify2(a,n,1);
			return yj;
		}
	}
	public void print() { //만들어진 heap이 제대로인지 확인하기 위해 print함수 만들기
		for(int j=1; j<=num/2; j++) {
			System.out.print("Parent: " + d[j] + "Left child: "+d[2*j]+"Right child: "+ d[2*j+1]);
			System.out.println();
		}
	}
}
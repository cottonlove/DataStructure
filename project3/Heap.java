//array representation of binary trees 사용하삼
public class Heap{
	public int[] d; //array
	public int num; //heap의 node 갯수
	public int capacity; //array의 size
	public void Swap(int indexx, int indexy) { //array의 값들 swap하는 함수
		int temp = d[indexx];
		d[indexx]= d[indexy];
		d[indexy] = temp;
	}
	
	public void heapify(int root) { //heapify function
		while(2*root<=num) {
			int jeno = 2*root;
			if(jeno<num&&d[jeno]>d[jeno+1]) jeno++; //right child와 left child의 크기 비교->작은 놈 선택
			if(d[root]<=d[jeno]) break; //부모가 더 작다면 break
			Swap(root, jeno); //자식이 더 작으면 swap
			root=jeno; //계속 반복
		}

	}
	
	public Heap(int size) { //size는 heap이 동시에 갖는 최대 node 갯수
		this.capacity = size+1; //array d의 0번째는 사용 안하니까
		d = new int[size+1]; 
		d[0] = Integer.MIN_VALUE; //쓰레기 값 
		this.num = 0; //initializes an empty heap that can store up to size integers
	}
	
	public boolean isEmpty() {
		if(num==0) {
			return true;
		}
		else return false;
	}
	
	public void insert(int x) {
		num++;
		d[num] = x;
		int i= num;
		while(d[i]<d[i/2]&&i!=1) { //To satisfy minimum heap's property.
			Swap(i, i/2);
			i = i/2;
		}
	}
	public int queryMin() { //최소는 root다
		if(num==0) {
			return Integer.MAX_VALUE;
		}
		else return d[1];
	}
	public int deleteMin() {
		if(num==0) {
			return Integer.MAX_VALUE;
		}
		else {
			Swap(1, num); //root랑 마지막 놈 바꿈
			int yj = d[num];
			num = num-1;//delete last node and decrease num
			heapify(1);
			return yj;
		}
	}
	public static void sort(int[]a, int n) {// static인거 notice하기
		for(int i=n/2; i>=1; i--) {
			minheapify2(a,n,i); //일단 minimum heap으로 만들기
		}
		for(int i=n; i>0; i--) {
			deleteMin2(a, i); //작은 놈부터 지우는 과정 반복
		}
	}
	public static void maSwap(int[]a, int indexx, int indexy) { //sort가 static이니까 static swap함수만들기
		int temp = a[indexx];
		a[indexx]= a[indexy];
		a[indexy] = temp;
	}
	public static void minheapify2(int[]a,int n, int root) { //sort에 쓸 static heapify함수 만들기
		while(2*root<=n) {
			int jeno = 2*root;
			if(jeno<n&&a[jeno]>a[jeno+1]) jeno++;
			if(a[root]<=a[jeno]) break;
			maSwap(a,root, jeno);
			root=jeno;
		}
	}
	public static int deleteMin2(int[]a,int n) {//sort에 쓸 static delete함수 만들기
		if(n==0) {
			return Integer.MAX_VALUE;
		}
		else {
			maSwap(a, 1, n);
			int yj = a[n];
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

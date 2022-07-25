//array representation of binary trees ����ϻ�
public class Heap{
	public int[] d; //array
	public int num; //heap�� node ����
	public int capacity; //array�� size
	public void Swap(int indexx, int indexy) { //array�� ���� swap�ϴ� �Լ�
		int temp = d[indexx];
		d[indexx]= d[indexy];
		d[indexy] = temp;
	}
	
	public void heapify(int root) { //heapify function
		while(2*root<=num) {
			int jeno = 2*root;
			if(jeno<num&&d[jeno]>d[jeno+1]) jeno++; //right child�� left child�� ũ�� ��->���� �� ����
			if(d[root]<=d[jeno]) break; //�θ� �� �۴ٸ� break
			Swap(root, jeno); //�ڽ��� �� ������ swap
			root=jeno; //��� �ݺ�
		}

	}
	
	public Heap(int size) { //size�� heap�� ���ÿ� ���� �ִ� node ����
		this.capacity = size+1; //array d�� 0��°�� ��� ���ϴϱ�
		d = new int[size+1]; 
		d[0] = Integer.MIN_VALUE; //������ �� 
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
	public int queryMin() { //�ּҴ� root��
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
			Swap(1, num); //root�� ������ �� �ٲ�
			int yj = d[num];
			num = num-1;//delete last node and decrease num
			heapify(1);
			return yj;
		}
	}
	public static void sort(int[]a, int n) {// static�ΰ� notice�ϱ�
		for(int i=n/2; i>=1; i--) {
			minheapify2(a,n,i); //�ϴ� minimum heap���� �����
		}
		for(int i=n; i>0; i--) {
			deleteMin2(a, i); //���� ����� ����� ���� �ݺ�
		}
	}
	public static void maSwap(int[]a, int indexx, int indexy) { //sort�� static�̴ϱ� static swap�Լ������
		int temp = a[indexx];
		a[indexx]= a[indexy];
		a[indexy] = temp;
	}
	public static void minheapify2(int[]a,int n, int root) { //sort�� �� static heapify�Լ� �����
		while(2*root<=n) {
			int jeno = 2*root;
			if(jeno<n&&a[jeno]>a[jeno+1]) jeno++;
			if(a[root]<=a[jeno]) break;
			maSwap(a,root, jeno);
			root=jeno;
		}
	}
	public static int deleteMin2(int[]a,int n) {//sort�� �� static delete�Լ� �����
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
	public void print() { //������� heap�� ��������� Ȯ���ϱ� ���� print�Լ� �����
		for(int j=1; j<=num/2; j++) {
			System.out.print("Parent: " + d[j] + "Left child: "+d[2*j]+"Right child: "+ d[2*j+1]);
			System.out.println();
		}
	}
}


public class As12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Oracle o = new Oracle();// Oracle¿∫ black box
		int n, tofind, a;
		boolean found;
		n = o.getN();
		tofind = o.getWhatToFind();
		
		found = false;
		int left = 0;
		int right = n-1;
		while(left<right) {
			int mid = (left+right)/2;
			if(o.getElementAt(mid)<tofind) {left = mid +1;} else right = mid;
		}
		if((left==right)&&(o.getElementAt(left)==tofind)) {
			found = true;
			o.reportAnswer(true, left);
		}
		if (!found) o.reportAnswer(false, 0);
	}

}

import java.io.*;
public class As11 {

	public static void main(String[] args) {
		// TODO
		int num, id,p;
		String s,str,str1, str2;
		try {
			BufferedReader rd = new BufferedReader(new FileReader("input.txt"));
			BufferedWriter wr = new BufferedWriter(new FileWriter("output.txt"));
			s = rd.readLine();
			num = Integer.parseInt(s);
			int[] a = new int[num];
			String[] b = new String[num];
			for (int i=0; i< num; i++) {
				str = rd.readLine();
				id = str.indexOf(" ");
				str1 = str.substring(0, id);
				str2 = str.substring(id+1, str.length());
				p = Integer.parseInt(str1);
				a[i] = p;
				b[i] = str2;
			}
			rd.close();
			int min=0;
			for (int i=1; i<num; i++) {
				if(a[i] < a[min]) {
					min = i;
				}
			}
			wr.write(b[min]);
			wr.close();
		}
		catch (Exception e) {
			System.out.println("ERROR");
		}
		
	}

}

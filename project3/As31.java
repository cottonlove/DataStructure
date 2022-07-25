import java.io.*;
public class As31 {
	static Stack op = new Stack();
	static int num(Character ch) { // funcion that sets the num of priority
		if((ch =='*')||(ch=='/')) {
			return 2;
		}
		else if ((ch =='+')||(ch == '-')) {
			return 1;
		}
		else return 0;
	}

	public static void main(String[] args) {
		String s;
		try {
			BufferedReader rd = new BufferedReader(new FileReader("input.txt"));
			BufferedWriter wr = new BufferedWriter(new FileWriter("output.txt"));
			s = rd.readLine(); // read a line from inputfile
			int leng = s.length();
			for(int i=0; i< leng; i++) {
				char ch = s.charAt(i);
				if((ch=='+')||(ch=='-')||(ch=='*')||(ch=='/')) { //operator�� ���
					do {
						if(op.isEmpty()) { //stack of operator empty�� push 
							op.push(ch);
							break;
						}
						else {
							char top = (char) op.peek(); 
							if(num(ch)<=num(top)) { //op�� top�� ��
								wr.write(top);
								op.pop();
							}
							else {
								op.push(ch);
								break;
							}
						}
					}while(true); //push�ϴ� ��� �ƴϸ� �ݺ��ϰ�
				
				}
				else if((ch=='(')) { //stack �ۿ����� �켱���� ����
					op.push(ch);
				}
				else if(ch==')') { //'('�̰� ���ö����� pop�ϰ� output���Ϸ� write
					while((char)op.peek()!='(') {
						char x = op.pop();
						wr.write(x);
					}
					op.pop();
				}
				else { //operand�� �ٷ� output���Ϸ�
					wr.write(ch);
				}
			}
				
			while(!op.isEmpty()) { //�� ���� �����ش��� op empty�ɶ����� �� pop�� �� ����
				wr.write(op.pop());
				}		
			rd.close();
			wr.close();
			}
				
		catch (FileNotFoundException e) { //input���� ��ã�� ��� exception
			System.out.println("not found ERROR");
		}
		
		catch(IOException e) { //�׿� ����
			System.out.println("IO error");
		}

	}



}


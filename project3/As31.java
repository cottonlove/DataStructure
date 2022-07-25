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
				if((ch=='+')||(ch=='-')||(ch=='*')||(ch=='/')) { //operator인 경우
					do {
						if(op.isEmpty()) { //stack of operator empty면 push 
							op.push(ch);
							break;
						}
						else {
							char top = (char) op.peek(); 
							if(num(ch)<=num(top)) { //op의 top과 비교
								wr.write(top);
								op.pop();
							}
							else {
								op.push(ch);
								break;
							}
						}
					}while(true); //push하는 경우 아니면 반복하게
				
				}
				else if((ch=='(')) { //stack 밖에서는 우선순위 높다
					op.push(ch);
				}
				else if(ch==')') { //'('이거 나올때까지 pop하고 output파일로 write
					while((char)op.peek()!='(') {
						char x = op.pop();
						wr.write(x);
					}
					op.pop();
				}
				else { //operand는 바로 output파일로
					wr.write(ch);
				}
			}
				
			while(!op.isEmpty()) { //저 과정 다해준다음 op empty될때까지 다 pop한 후 쓰기
				wr.write(op.pop());
				}		
			rd.close();
			wr.close();
			}
				
		catch (FileNotFoundException e) { //input파일 못찾을 경우 exception
			System.out.println("not found ERROR");
		}
		
		catch(IOException e) { //그외 오류
			System.out.println("IO error");
		}

	}



}


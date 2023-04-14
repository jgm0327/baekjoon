import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> stk = new ArrayDeque<>();
		String str = br.readLine();
		StringBuilder answer = new StringBuilder();
		
		boolean flag = false;
		flag = false;
		for(int i=0 ; i<str.length() ; i++) {
			char ch = str.charAt(i);
			if(ch == '<') {
				while(!stk.isEmpty()) {
					answer.append(stk.pollLast());
				}
				flag = true;
			}else if(ch == '>') {
				answer.append(ch);
				flag = false;
			}else if(!flag && ch == ' ') {
				while(!stk.isEmpty()) {
					answer.append(stk.pollLast());
				}
				answer.append(ch);
			}
			if(flag)answer.append(ch);
			else if(ch != '>' && ch != ' ')stk.add(ch);
		}
		
		while(!stk.isEmpty()) {
			answer.append(stk.pollLast());
		}
		
		
		System.out.println(answer.toString());
		br.close();
	}

}

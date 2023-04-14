import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> stk = new ArrayDeque<>();
		String sticks = br.readLine();
		int answer = 0 ;
		char prev = '(';
		
		for(int i=0 ; i<sticks.length() ; i++) {
			char ch = sticks.charAt(i);
			if(ch == '(') {
				stk.add(ch);
			}else if(ch == ')') {
				if(prev != ')') {
					stk.pollLast();
					answer += stk.size();
				}else {
					stk.pollLast();
					answer++;
				}
			}
			prev = ch;
		}
		System.out.println(answer);
		br.close();
	}

}

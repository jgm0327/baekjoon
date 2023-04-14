import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> answer = new ArrayDeque<Character>(), temp = new ArrayDeque<>();
		String str = br.readLine();
		for(int i=0 ; i<str.length(); i++) {
			answer.add(str.charAt(i));
		}
		int n = Integer.parseInt(br.readLine());
		
		while(n-- > 0) {
			String[] input = br.readLine().split(" ");
			String command = input[0];
			if(input.length == 1) {
				if(command.equals("L") && !answer.isEmpty()) {
					temp.add(answer.pollLast());
				}else if(command.equals("D") && !temp.isEmpty()) {
					answer.add(temp.pollLast());
				}else if(command.equals("B") && !answer.isEmpty()) {
					answer.pollLast();
				}
			}else {
				char ch = input[1].charAt(0);
				answer.add(ch);
			}
		}
		while(!temp.isEmpty()) {
			answer.add(temp.pollLast());
		}
		
		StringBuilder sb = new StringBuilder();
		while(!answer.isEmpty()) {
			sb.append(answer.poll());
		}
		System.out.println(sb.toString());
		br.close();
	}

}

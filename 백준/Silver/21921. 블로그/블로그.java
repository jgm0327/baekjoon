import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(input.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(input.readLine());
		List<Integer> visitors = new ArrayList<>();
		int i = 0;
		while(stk.hasMoreTokens()) {
			visitors.add(Integer.parseInt(stk.nextToken())); 
		}
		
		int start = 0, end = m, answer = visitors.subList(0, m)
				.stream().mapToInt(Integer::intValue).sum(), cnt = 1;
		int prev = answer, next_value;
		while(end < n) {
			next_value = prev + (visitors.get(end) - visitors.get(start));
			if(answer < next_value) {
				answer = next_value;
				cnt = 1;
			}
			else if(answer == next_value) cnt++;
			prev = next_value;
			start++;end++;
		}
		if(answer == 0)System.out.println("SAD");
		else System.out.println(answer + "\n" + cnt);
		input.close();
	}
}

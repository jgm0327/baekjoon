import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> budgets = new ArrayList<>();
			String[] str = br.readLine().split(" ");
			int max_value = 0, value;
			for(String budget : str) {
				value = Integer.parseInt(budget);
				budgets.add(value);
				max_value = Math.max(max_value, value);
			}
			long m = Long.parseLong(br.readLine());
			long start = 0, end = max_value, answer = 0;
			
			while(start <= end) {
				long mid = (start + end) / 2, total = 0;
				for(Integer budget : budgets) {
					if(mid > budget)total += budget;
					else total += mid;
				}
				if(total <= m && mid <= m) {
					answer = Math.max(answer, mid);
					start = mid + 1;
				}
				else {
					end = mid - 1;
				}
			}
			System.out.println(answer);
		}catch(IOException e) {
			
		}
	}
}

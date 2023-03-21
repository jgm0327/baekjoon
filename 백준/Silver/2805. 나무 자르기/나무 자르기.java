import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static long m;
	static long[] woods;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Long.parseLong(str[1]);
			woods = new long[n+1];
			
			String[] input = br.readLine().split(" ");
			for(int i=0 ; i<n ; i++)woods[i] = Long.parseLong(input[i]);
			System.out.println(binary_search());
			br.close();
		}catch(IOException e) {
			
		}
	}
	
	private static long binary_search() {
		long start = 0, end = 2000000000, answer = 0;
		while(start <= end) {
			long mid = (start + end) / 2, total = 0;
			for(long wood : woods) {
				if(wood > mid)total += (wood - mid);
			}
			if(total < m) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
				answer = mid;
			}
		}
		return answer;
	}
}

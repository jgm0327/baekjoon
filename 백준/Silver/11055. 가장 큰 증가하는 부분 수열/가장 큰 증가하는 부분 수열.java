import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n, answer;
	private static int[] arr, dp;
	
	public static void main(String[] args) throws IOException{
		insert();
		dp = new int[n + 1];
		answer = arr[1];
		recur(1, 0, 0);
		System.out.println(answer);
	}
	
	private static void insert() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		
		int idx = 1;
		for(String value : br.readLine().split(" ")) {
			arr[idx++] = Integer.parseInt(value);
		}
		br.close();
	}
	
	private static void recur(int start, int total, int num) {
		if(n == 1) {
			answer = arr[1];
			return;
		}
		
		for(int i = start ; i<=n ; i++) {
			if(arr[i] > num && dp[i] < total + arr[i]) {
				total += arr[i];
				dp[i] = total;
				answer = Math.max(total, answer);
				recur(i+1, total, arr[i]);
				total -= arr[i];
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException{
		insert();
		solution();
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
	
	private static void solution() {
		int[] dp = new int[n+1];
		dp[1] = arr[1];
		for(int i=2 ; i<=n ; i++) {
			dp[i] = arr[i];
			for(int j=1 ; j<i ; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], arr[i] + dp[j]);
				}
			}
		}
		
		int ret = 0;
		for(int d : dp) {
			ret = Math.max(d, ret);
		}
		System.out.println(ret);
	}
}

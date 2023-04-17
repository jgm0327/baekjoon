import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int answer = Integer.MAX_VALUE;
	private static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		 recur(n, 0);
		System.out.println(answer);
		br.close();
	}
	
	private static void recur(int num, int depth) {
		if(dp[num] != 0 && dp[num] <= depth)return;
		if(num <= 1) {
			if(num == 1)
				answer = Math.min(answer, depth);
			return;
		}
		dp[num] = depth;
		if(num % 3 == 0)recur(num / 3, depth+1);
		if(num % 2 == 0)recur(num / 2, depth+1);
		recur(num-1, depth+1);
	}
}
